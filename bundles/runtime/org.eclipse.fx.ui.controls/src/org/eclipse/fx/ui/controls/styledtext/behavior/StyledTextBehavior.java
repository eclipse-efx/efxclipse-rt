/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Christoph Caks <ccaks@bestsolution.at> - improved editor behavior
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.behavior;

import java.text.BreakIterator;
import java.util.List;
import java.util.Optional;

import org.eclipse.fx.core.IntTuple;
import org.eclipse.fx.core.Util;
import org.eclipse.fx.core.text.DefaultTextEditActions;
import org.eclipse.fx.core.text.TextEditAction;
import org.eclipse.fx.core.text.TextUtil;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea.CustomQuickLink;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea.QuickLink;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea.QuickLinkable;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea.SimpleQuickLink;
import org.eclipse.fx.ui.controls.styledtext.StyledTextContent;
import org.eclipse.fx.ui.controls.styledtext.TextSelection;
import org.eclipse.fx.ui.controls.styledtext.TriggerActionMapping;
import org.eclipse.fx.ui.controls.styledtext.TriggerActionMapping.Context;
import org.eclipse.fx.ui.controls.styledtext.VerifyEvent;
import org.eclipse.fx.ui.controls.styledtext.events.TextPositionEvent;
import org.eclipse.fx.ui.controls.styledtext.events.UndoHintEvent;
import org.eclipse.fx.ui.controls.styledtext.internal.TextNode;
import org.eclipse.fx.ui.controls.styledtext.skin.StyledTextSkin;
import org.eclipse.jdt.annotation.NonNull;

import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.css.PseudoClass;
import javafx.event.Event;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * Behavior for styled text
 */
public class StyledTextBehavior {

	private TriggerActionMapping keyTriggerMapping = new TriggerActionMapping();

	private TextPositionSupport textPositionSupport;
	private HoverSupport hoverSupport;

	private final StyledTextArea styledText;

	int acceleration = 3;

	private final int AUTO_SCROLL_RATE = 50;

	private static final boolean AUTO_SCROLL = ! Boolean.getBoolean("styledtext.autoscroll.disabled"); //$NON-NLS-1$

	private final Timeline positionUpdaterTop = new Timeline(new KeyFrame(Duration.millis(this.AUTO_SCROLL_RATE), e -> {
		if( getControl().getCaretOffset() > 0 ) {
			int lineIdx = getControl().getContent().getLineAtOffset(getControl().getCaretOffset());
			if( lineIdx > 0 ) {
				int lineStart = getControl().getContent().getOffsetAtLine(Math.max(lineIdx - this.acceleration,0));
				moveCaretAbsolute(lineStart,true);
			}
		}
	}));

	private final Timeline positionUpdaterBottom = new Timeline(new KeyFrame(Duration.millis(this.AUTO_SCROLL_RATE), e -> {
		if( getControl().getCaretOffset() < getControl().getContent().getCharCount() ) {
			int lineIdx = getControl().getContent().getLineAtOffset(getControl().getCaretOffset());
			if( lineIdx < getControl().getContent().getLineCount() - 1 ) {
				int targetIndex = Math.min(lineIdx + this.acceleration,getControl().getContent().getLineCount()-1);
				int lineEndStart = getControl().getContent().getOffsetAtLine(targetIndex);

				// At the last line move to the last caret
				if( targetIndex == getControl().getLineCount()-1 ) {
					lineEndStart = Math.min(lineEndStart + getControl().getContent().getLine(targetIndex).length(),getControl().getCharCount());
				}

				moveCaretAbsolute(lineEndStart,true);
			}
		}
	}));

	/**
	 * Create a new behavior
	 *
	 * @param styledText
	 *            the styled text control
	 */
	public StyledTextBehavior(StyledTextArea styledText) {
		this.styledText = styledText;
		this.positionUpdaterTop.setCycleCount(Animation.INDEFINITE);
		this.positionUpdaterBottom.setCycleCount(Animation.INDEFINITE);
		styledText.addEventHandler(KeyEvent.KEY_PRESSED, this::onKeyPressed);
		styledText.addEventHandler(KeyEvent.KEY_TYPED, this::onKeyTyped);

		styledText.addEventHandler(MouseEvent.MOUSE_PRESSED, this::onMousePressed);
		styledText.addEventHandler(TextPositionEvent.TEXT_POSITION_MOVED, this::onTextPositionMoved);

		this.keyTriggerMapping.subscribe(this::defaultHandle);
		initKeymapping(this.keyTriggerMapping);


		styledText.addEventHandler(TextPositionEvent.TEXT_POSITION_PRESSED, this::onTextPositionPressed);
		styledText.addEventHandler(TextPositionEvent.TEXT_POSITION_CLICKED, this::onTextPositionClicked);
		styledText.addEventHandler(TextPositionEvent.TEXT_POSITION_RELEASED, this::onTextPositionReleased);
		styledText.addEventHandler(TextPositionEvent.TEXT_POSITION_DRAGGED, this::onTextPositionDragged);
		styledText.addEventHandler(TextPositionEvent.TEXT_POSITION_DRAG_DETECTED, this::onTextPositionDragDetected);

		this.keyTriggerMapping.overrideProperty().bind(styledText.overrideActionMappingProperty());
	}

	/**
	 * Install the content listener
	 *
	 * @param contentNode
	 *            the content node
	 */
	public void installContentListeners(final javafx.scene.layout.Region contentNode) {
		this.textPositionSupport = TextPositionSupport.install(contentNode, getControl());
		this.hoverSupport = HoverSupport.install(contentNode);
	}

	// text manipulation utils

	static int computeStart(StyledTextContent content, int firstLine) {
		return content.getOffsetAtLine(firstLine);
	}

	static int computeEnd(StyledTextContent content, int lastLine) {
		int endIndex;
		if (content.getLineCount() > lastLine + 1) {
			endIndex = content.getOffsetAtLine(lastLine + 1);
		} else {
			endIndex = content.getOffsetAtLine(lastLine) + content.getLine(lastLine).length();
		}
		return endIndex;
	}

	static int computeLength(StyledTextContent content, int firstLine, int lastLine) {
		return computeEnd(content, lastLine) - computeStart(content, firstLine);
	}

	private class LineRegion extends Region {
		public final int firstLine;
		public final int lastLine;

		public LineRegion(int firstLine, int lastLine) {
			super(computeStart(getControl().getContent(), firstLine), computeLength(getControl().getContent(), firstLine, lastLine));
			this.firstLine = firstLine;
			this.lastLine = lastLine;
		}

		public LineRegion(int singleLineIndex) {
			this(singleLineIndex, singleLineIndex);
		}

	}

	private @NonNull LineRegion getLineRegion(TextSelection selection) {
		int firstLine = getControl().getLineAtOffset(selection.offset);
		int lastLine = getControl().getLineAtOffset(selection.offset + selection.length);
		int lastLineBegin = getControl().getOffsetAtLine(lastLine);
		// dont count the last line if the caret is at index 0
		if (lastLineBegin == selection.offset + selection.length) {
			lastLine -= 1;
		}
		// limit
		lastLine = Math.min(getControl().getContent().getLineCount() - 1, lastLine);
		lastLine = Math.max(firstLine, lastLine);

		return new LineRegion(firstLine, lastLine);
	}

	private class Region {
		public final int start;
		public final int end;
		public final int length;

		Region(int startIndex, int length) {
			this.start = startIndex;
			this.end = startIndex + length;
			this.length = length;
		}

		public String read() {
			return getControl().getContent().getTextRange(this.start, this.length);
		}

		public void replace(@NonNull String replacement) {
			getControl().getContent().replaceTextRange(this.start, this.length, replacement);
		}

		public void selectWithCaretAtStart() {
			moveCaretAbsolute(this.start);
			getControl().setSelection(new TextSelection(this.start, this.length));
		}

		public void selectWithCaretAtEnd() {
			moveCaretAbsolute(this.end);
			getControl().setSelection(new TextSelection(this.start, this.length));
		}

	}

	// state for dnd stuff
	private volatile boolean pressedInSelection = false;
	private volatile boolean dragMoveTextMode = false;
	private volatile boolean dragSelectionMode = false;
	private volatile int dragMoveTextOffset = -1;
	private volatile int dragMoveTextLength = -1;
	private int mousePressedOffset = -1;

	private static boolean isInRange(int offset, int rangeOffset, int rangeLength) {
		return offset >= rangeOffset && offset < (rangeOffset + rangeLength);
	}

	private boolean isInSelection(int offset) {
		int selOffset = getControl().getSelection().offset;
		int selLength = getControl().getSelection().length;
		boolean r = selLength > 0 && isInRange(offset, selOffset, selLength);
		return r;
	}

	private void onKeyPressed(KeyEvent event) {

		if( this.keyTriggerMapping.exists(event) ) {
			getControl().fireEvent(UndoHintEvent.createBeginCompoundChangeEvent());
			try {
				boolean handled = this.keyTriggerMapping.triggerAction(event, new Context(getControl()));
				if (handled) {
					event.consume();
					return;
				}
			}
			finally {
				getControl().fireEvent(UndoHintEvent.createEndCompoundChangeEvent());
			}
		}

		if( this.dragMoveTextMode ) {

			if (event.getCode() == KeyCode.ESCAPE) {
				// Bug 491693 - StyledTextArea - Drag And Drop not canceled on Esc
				// cancel dnd operation
				this.dragMoveTextMode = false;
				this.pressedInSelection = false; // to prevent selection changes after cancel

				// update insertion marker
				((StyledTextSkin)getControl().getSkin()).updateInsertionMarkerIndex(-1);

				getControl().pseudoClassStateChanged(DRAG_TEXT_MOVE_ACTIVE_PSEUDOCLASS_STATE, false);
				getControl().pseudoClassStateChanged(DRAG_TEXT_COPY_ACTIVE_PSEUDOCLASS_STATE, false);

				event.consume();
				return;
			}

			if( event.isShortcutDown() ) {
				getControl().pseudoClassStateChanged(DRAG_TEXT_MOVE_ACTIVE_PSEUDOCLASS_STATE, false);
				getControl().pseudoClassStateChanged(DRAG_TEXT_COPY_ACTIVE_PSEUDOCLASS_STATE, true);
			} else {
				getControl().pseudoClassStateChanged(DRAG_TEXT_MOVE_ACTIVE_PSEUDOCLASS_STATE, true);
				getControl().pseudoClassStateChanged(DRAG_TEXT_COPY_ACTIVE_PSEUDOCLASS_STATE, false);
			}
		}

		VerifyEvent evt = new VerifyEvent(getControl(), getControl(), event);
		Event.fireEvent(getControl(), evt);

		// Bug in JavaFX who enables the menu when ALT is pressed
		if (Util.isMacOS()) {
			if (event.getCode() == KeyCode.ALT || event.isAltDown()) {
				event.consume();
			}
		} else if( org.eclipse.fx.ui.controls.Util.MNEMONICS_FIX ) {
			// Fix JavaFX bug with invalid mnemonics activation on ALTGR
			if( event.isAltDown() && event.isControlDown() ) {
				event.consume();
			}
		}

		if (evt.isConsumed()) {
			event.consume();
			return;
		}

		// tab insertion if not otherwise handled
		if (KeyCombination.keyCombination("Tab").match(event)) { //$NON-NLS-1$
			getControl().insert("\t"); //$NON-NLS-1$
			event.consume();
		}

	}

	private void onKeyTyped(KeyEvent event) {
		if (getControl().getEditable()) {

			String character = event.getCharacter();
			if (character.length() == 0) {
				return;
			}

			// check the modifiers
			// - OS-X: ALT+L ==> @
			// - win32/linux: ALTGR+Q ==> @
			if (event.isControlDown() || event.isAltDown() || (Util.isMacOS() && event.isMetaDown())) {
				if (!((event.isControlDown() || Util.isMacOS()) && event.isAltDown()))
					return;
			}

			if (character.charAt(0) > 31 // No ascii control chars
					&& character.charAt(0) != 127 // no delete key
					&& !event.isMetaDown()) {

				getControl().insert(character);

				// check for typed char action
				if( this.keyTriggerMapping.exists(character.charAt(0)) ) {
					getControl().fireEvent(UndoHintEvent.createBeginCompoundChangeEvent());
					try {
						this.keyTriggerMapping.triggerAction(character.charAt(0), new Context(getControl()));
					}
					finally {
						getControl().fireEvent(UndoHintEvent.createEndCompoundChangeEvent());
					}
				}
			}
		}
	}

	private void onTextPositionDragDetected(TextPositionEvent event) {
		if (this.pressedInSelection) {
			if( org.eclipse.fx.ui.controls.Util.isCopyEvent(event) ) {
				getControl().pseudoClassStateChanged(DRAG_TEXT_COPY_ACTIVE_PSEUDOCLASS_STATE, true);
			} else {
				getControl().pseudoClassStateChanged(DRAG_TEXT_MOVE_ACTIVE_PSEUDOCLASS_STATE, true);
			}
			this.dragMoveTextMode = true;
			this.dragMoveTextOffset = getControl().getSelection().offset;
			this.dragMoveTextLength = getControl().getSelection().length;
		} else {
			this.dragSelectionMode = true;
		}
	}

	private void onTextPositionDragged(TextPositionEvent event) {
		if (this.dragSelectionMode) {
			if( event.getOffset() >= 0 ) {
				this.positionUpdaterTop.stop();
				this.positionUpdaterBottom.stop();
				moveCaretAbsolute(event.getOffset(), true);
			} else {
				if( AUTO_SCROLL ) {
					if( event.getY() <= 0 ) {
						this.acceleration = (int) Math.abs(event.getY());
						this.positionUpdaterBottom.stop();
						if( this.positionUpdaterTop.getStatus() != Status.RUNNING ) {
							this.positionUpdaterTop.playFromStart();
						}
					} else {
						Bounds b = ((StyledTextSkin)getControl().getSkin()).getContentBounds();
						this.acceleration = (int) Math.abs( b.getMaxY() - event.getY());
						this.positionUpdaterTop.stop();
						if( this.positionUpdaterBottom.getStatus() != Status.RUNNING ) {
							this.positionUpdaterBottom.playFromStart();
						}
					}
				}
			}
			event.consume();
		} else if (this.dragMoveTextMode) {
			// update insertion marker
			((StyledTextSkin)getControl().getSkin()).updateInsertionMarkerIndex(event.getOffset());

			if( org.eclipse.fx.ui.controls.Util.isCopyEvent(event) ) {
				getControl().pseudoClassStateChanged(DRAG_TEXT_MOVE_ACTIVE_PSEUDOCLASS_STATE, false);
				getControl().pseudoClassStateChanged(DRAG_TEXT_COPY_ACTIVE_PSEUDOCLASS_STATE, true);
			} else {
				getControl().pseudoClassStateChanged(DRAG_TEXT_MOVE_ACTIVE_PSEUDOCLASS_STATE, true);
				getControl().pseudoClassStateChanged(DRAG_TEXT_COPY_ACTIVE_PSEUDOCLASS_STATE, false);
			}
			event.consume();
		}
	}

	private void onTextPositionReleased(TextPositionEvent event) {
		if (this.dragSelectionMode) {
			this.dragSelectionMode = false;
			this.positionUpdaterTop.stop();
			this.positionUpdaterBottom.stop();
			event.consume();
		} else if (this.dragMoveTextMode) {
			// update insertion marker
			((StyledTextSkin)getControl().getSkin()).updateInsertionMarkerIndex(-1);

			getControl().pseudoClassStateChanged(DRAG_TEXT_MOVE_ACTIVE_PSEUDOCLASS_STATE, false);
			getControl().pseudoClassStateChanged(DRAG_TEXT_COPY_ACTIVE_PSEUDOCLASS_STATE, false);

			int targetOffset = event.getOffset();

			if( getControl().getSelection().contains(targetOffset) ) {
				this.dragMoveTextMode = false;
				event.consume();
				return;
			}

			if( targetOffset < 0 ) {
				this.dragMoveTextMode = false;
				event.consume();
				return;
			}

			// read text
			@NonNull
			String text = getControl().getContent().getTextRange(this.dragMoveTextOffset, this.dragMoveTextLength);

			// notify the undo implementation that a compund change occurs
			getControl().fireEvent(UndoHintEvent.createBeginCompoundChangeEvent());
			try {
				if( ! org.eclipse.fx.ui.controls.Util.isCopyEvent(event) ) {
					// replace
					if (isInRange(targetOffset, this.dragMoveTextOffset, this.dragMoveTextLength)) {
						targetOffset = this.dragMoveTextOffset;
					}
					// after
					else if (targetOffset >= this.dragMoveTextOffset + this.dragMoveTextLength) {
						targetOffset -= this.dragMoveTextLength;
					}

					// remove
					getControl().getContent().replaceTextRange(this.dragMoveTextOffset, this.dragMoveTextLength, ""); //$NON-NLS-1$
				}

				// insert
				getControl().getContent().replaceTextRange(targetOffset, 0, text);

				// move caret to end of insertion and select the text
				moveCaretAbsolute(targetOffset + text.length());
				getControl().setSelection(new TextSelection(targetOffset, text.length()));
			}
			finally {
				getControl().fireEvent(UndoHintEvent.createEndCompoundChangeEvent());
			}


			this.dragMoveTextMode = false;
			event.consume();
		} else if (this.pressedInSelection) {
			moveCaretAbsolute(this.mousePressedOffset, event.isShiftDown());
			event.consume();
		}

		// in any case reset pressedInSelection
		this.pressedInSelection = false;
	}

	private void onTextPositionPressed(TextPositionEvent event) {
		if( event.getButton() != MouseButton.PRIMARY ) {
			return;
		}

		this.mousePressedOffset = event.getOffset();

		if( this.mousePressedOffset < 0 ) {
			this.mousePressedOffset = getControl().getContent().getCharCount();
		}

		if (isInSelection(this.mousePressedOffset)) {
			this.pressedInSelection = true;
			event.consume();
		} else {
			moveCaretAbsolute(this.mousePressedOffset, event.isShiftDown());
			event.consume();
		}
	}

	private void doLink(QuickLink link) {
		if (link instanceof SimpleQuickLink) {
			SimpleQuickLink simple = (SimpleQuickLink) link;
			getControl().setCaretOffset(simple.getRegion().upperEndpoint());
			getControl().setSelection(new TextSelection(simple.getRegion().lowerEndpoint(), simple.getRegion().upperEndpoint() - simple.getRegion().lowerEndpoint()));
		}
		else if (link instanceof CustomQuickLink) {
			CustomQuickLink custom = (CustomQuickLink) link;
			custom.getAction().run();
		}
	}

	private void onTextPositionClicked(TextPositionEvent event) {
		if (event.isStillSincePress()) {
			if (event.getClickCount() == 2 && event.getButton() == MouseButton.PRIMARY) {
				this.keyTriggerMapping.triggerAction(DefaultTextEditActions.SELECT_WORD, new Context(getControl()));
				event.consume();
			}
			if (event.getClickCount() == 3 && event.getButton() == MouseButton.PRIMARY) {
				this.keyTriggerMapping.triggerAction(DefaultTextEditActions.SELECT_LINE, new Context(getControl()));
				event.consume();
			}
		}

		if (event.isShortcutDown()) {
			Optional<QuickLinkable> linkable = getControl().getQuickLinkCallback().apply(event.getOffset());
			linkable.ifPresent((l) -> {
				if (l.getLinks().size() == 1) {
					doLink(l.getLinks().get(0));
				}
				else {
					// TODO handle case of multiple links
				}
			});

		}

	}

	/**
	 * @return the control
	 */
	protected StyledTextArea getControl() {
		return this.styledText;
	}

	private void onMousePressed(MouseEvent event) {
		getControl().requestFocus();
	}

	private Optional<TextNode> currentQuickLinkNode = Optional.empty();

	private static final PseudoClass QUICK_LINK_ACTIVE_PSEUDOCLASS_STATE = PseudoClass.getPseudoClass("quick-link-active"); //$NON-NLS-1$
	private static final PseudoClass DRAG_TEXT_MOVE_ACTIVE_PSEUDOCLASS_STATE = PseudoClass.getPseudoClass("drag-text-move-active"); //$NON-NLS-1$
	private static final PseudoClass DRAG_TEXT_COPY_ACTIVE_PSEUDOCLASS_STATE = PseudoClass.getPseudoClass("drag-text-copy-active"); //$NON-NLS-1$

	private void setCurrentQuickLinkNode(Optional<TextNode> node) {
		if (node.isPresent()) {
			this.getControl().setCursor(Cursor.HAND);
		}
		else {
			this.getControl().setCursor(null);
		}
		this.currentQuickLinkNode.ifPresent(n->n.getStyleClass().remove("quick_link")); //$NON-NLS-1$
		this.currentQuickLinkNode.ifPresent(n->n.setCursor(null));
		if( this.currentQuickLinkNode.isPresent() != node.isPresent() ) {
			getControl().pseudoClassStateChanged(QUICK_LINK_ACTIVE_PSEUDOCLASS_STATE, ! this.currentQuickLinkNode.isPresent());
		}

		this.currentQuickLinkNode = node;
		this.currentQuickLinkNode.ifPresent(n->n.getStyleClass().add("quick_link")); //$NON-NLS-1$
		this.currentQuickLinkNode.ifPresent(n->n.requestLayout());
	}

	private void onTextPositionMoved(TextPositionEvent event) {
		if (event.isShortcutDown()) {
			Optional<QuickLinkable> linkable = getControl().getQuickLinkCallback().apply(event.getOffset());
			if (linkable.isPresent()) {
				Point2D screenLocation = new Point2D(event.getScreenX(), event.getScreenY());
				Optional<TextNode> node = ((StyledTextSkin)getControl().getSkin()).findTextNode(screenLocation);

				if (!this.currentQuickLinkNode.equals(node)) {
					// changed
					setCurrentQuickLinkNode(node);
				}
			}
			else {
				setCurrentQuickLinkNode(Optional.empty());
			}

		}
		else {
			setCurrentQuickLinkNode(Optional.empty());
		}
	}

	private int computeCurrentLineNumber() {
		final int offset = getControl().getCaretOffset();
		return getControl().getLineAtOffset(offset);
	}

	private int computeCurrentLineStartOffset() {
		final int lineNumber = computeCurrentLineNumber();
		return getControl().getOffsetAtLine(lineNumber);
	}

	protected boolean defaultHandle(TextEditAction action, Context context) {
		if (action == DefaultTextEditActions.TEXT_START) {
			defaultNavigateTextStart();
			return true;
		}
		else if (action == DefaultTextEditActions.TEXT_END) {
			defaultNavigateTextEnd();
			return true;
		}
		else if (action == DefaultTextEditActions.TEXT_PAGE_DOWN) {
			defaultNavigateTextPageDown();
			return true;
		}
		else if (action == DefaultTextEditActions.TEXT_PAGE_UP) {
			defaultNavigateTextPageUp();
			return true;
		}
		else if (action == DefaultTextEditActions.LINE_START) {
			defaultNavigateLineStart();
			return true;
		}
		else if (action == DefaultTextEditActions.LINE_END) {
			defaultNavigateLineEnd();
			return true;
		}
		else if (action == DefaultTextEditActions.WORD_NEXT) {
			defaultNavigateWordNext();
			return true;
		}
		else if (action == DefaultTextEditActions.WORD_PREVIOUS) {
			defaultNavigateWordPrevious();
			return true;
		}
		else if (action == DefaultTextEditActions.SELECT_TEXT_START) {
			defaultSelectTextStart();
			return true;
		}
		else if (action == DefaultTextEditActions.SELECT_TEXT_END) {
			defaultSelectTextEnd();
			return true;
		}
		else if (action == DefaultTextEditActions.SELECT_TEXT_PAGE_DOWN) {
			defaultSelectTextPageDown();
			return true;
		}
		else if (action == DefaultTextEditActions.SELECT_TEXT_PAGE_UP) {
			defaultSelectTextPageUp();
			return true;
		}
		else if (action == DefaultTextEditActions.SELECT_LINE_START) {
			defaultSelectLineStart();
			return true;
		}
		else if (action == DefaultTextEditActions.SELECT_LINE_END) {
			defaultSelectLineEnd();
			return true;
		}
		else if (action == DefaultTextEditActions.SELECT_WORD_NEXT) {
			defaultSelectWordNext();
			return true;
		}
		else if (action == DefaultTextEditActions.SELECT_WORD_PREVIOUS) {
			defaultSelectWordPrevious();
			return true;
		}
		else if (action == DefaultTextEditActions.SELECT_WORD) {
			defaultSelectWord();
			return true;
		}
		else if (action == DefaultTextEditActions.SELECT_LINE) {
			defaultSelectLine();
			return true;
		}
		else if (action == DefaultTextEditActions.DELETE_LINE) {
			defaultDeleteLine();
			return true;
		}
		else if (action == DefaultTextEditActions.DELETE_WORD_NEXT) {
			defaultDeleteWordNext();
			return true;
		}
		else if (action == DefaultTextEditActions.DELETE_WORD_PREVIOUS) {
			defaultDeleteWordPrevious();
			return true;
		}
		else if (action == DefaultTextEditActions.MOVE_LINES_UP) {
			defaultMoveLinesUp();
			return true;
		}
		else if (action == DefaultTextEditActions.MOVE_LINES_DOWN) {
			defaultMoveLinesDown();
			return true;
		}
		else if (action == DefaultTextEditActions.INDENT) {
			defaultIndent();
			return true;
		}
		else if (action == DefaultTextEditActions.OUTDENT) {
			defaultOutdent();
			return true;
		}
		else if (action == DefaultTextEditActions.NEW_LINE) {
			defaultNewLine();
			return true;
		}
		else if (action == DefaultTextEditActions.SELECT_ALL) {
			defaultSelectAll();
			return true;
		}
		else if (action == DefaultTextEditActions.CUT) {
			defaultCut();
			return true;
		}
		else if (action == DefaultTextEditActions.COPY) {
			defaultCopy();
			return true;
		}
		else if (action == DefaultTextEditActions.PASTE) {
			defaultPaste();
			return true;
		}
		else if (action == DefaultTextEditActions.DELETE) {
			defaultDelete();
			return true;
		}
		else if (action == DefaultTextEditActions.DELETE_PREVIOUS) {
			defaultDeletePrevious();
			return true;
		}
		else if (action == DefaultTextEditActions.DELETE_LINE) {
			defaultDeleteLine();
			return true;
		}
		else if (action == DefaultTextEditActions.SCROLL_LINE_UP) {
			defaultScrollLineUp();
			return true;
		}
		else if (action == DefaultTextEditActions.SCROLL_LINE_DOWN)  {
			defaultScrollLineDown();
			return true;
		}
		else if (action == DefaultTextEditActions.NAVIGATE_TO_LINE) {
			defaultNavigateLineEnd();
			return true;
		}
		else if (action == DefaultTextEditActions.MOVE_UP) {
			defaultUp(false);
			return true;
		}
		else if (action == DefaultTextEditActions.MOVE_LEFT) {
			defaultLeft(false);
			return true;
		}
		else if (action == DefaultTextEditActions.MOVE_RIGHT) {
			defaultRight(false);
			return true;
		}
		else if (action == DefaultTextEditActions.MOVE_DOWN) {
			defaultDown(false);
			return true;
		}
		else if (action == DefaultTextEditActions.SELECT_UP) {
			defaultUp(true);
			return true;
		}
		else if (action == DefaultTextEditActions.SELECT_LEFT) {
			defaultLeft(true);
			return true;
		}
		else if (action == DefaultTextEditActions.SELECT_RIGHT) {
			defaultRight(true);
			return true;
		}
		else if (action == DefaultTextEditActions.SELECT_DOWN) {
			defaultDown(true);
			return true;
		}
		return false;
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#TEXT_START}
	 */
	protected void defaultNavigateTextStart() {
		getControl().setCaretOffset(0);
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#TEXT_END}
	 */
	protected void defaultNavigateTextEnd() {
		getControl().setCaretOffset(getControl().getContent().getCharCount());
	}

	private int calculatePageDownOffset() {
		final int linesPerPage = ((StyledTextSkin)getControl().getSkin()).getVisibleLineCount();
		final int globalOffset = getControl().getCaretOffset();
		final int lineIndex = getControl().getContent().getLineAtOffset(globalOffset);
		final int lineLocalOffset = globalOffset - getControl().getContent().getOffsetAtLine(lineIndex);

		final int newLineIndex = Math.min(getControl().getContent().getLineCount()-1, lineIndex + linesPerPage);
		final int newLineLocalOffset = Math.min(getControl().getContent().getLine(newLineIndex).length(), lineLocalOffset);

		return getControl().getOffsetAtLine(newLineIndex) + newLineLocalOffset;
	}

	private int calculatePageUpOffset() {
		final int linesPerPage = ((StyledTextSkin)getControl().getSkin()).getVisibleLineCount();
		final int globalOffset = getControl().getCaretOffset();
		final int lineIndex = getControl().getContent().getLineAtOffset(globalOffset);
		final int lineLocalOffset = globalOffset - getControl().getContent().getOffsetAtLine(lineIndex);

		final int newLineIndex = Math.max(0, lineIndex - linesPerPage);
		final int newLineLocalOffset = Math.min(getControl().getContent().getLine(newLineIndex).length(), lineLocalOffset);

		return getControl().getOffsetAtLine(newLineIndex) + newLineLocalOffset;
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#TEXT_PAGE_UP}
	 */
	protected void defaultSelectTextPageUp() {
		moveCaretAbsolute(calculatePageUpOffset(), true);
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#TEXT_PAGE_DOWN}
	 */
	protected void defaultSelectTextPageDown() {
		moveCaretAbsolute(calculatePageDownOffset(), true);
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#LINE_START}
	 */
	protected void defaultNavigateLineStart() {
		// TODO Should be position to the first none whitespace char??
		moveCaretAbsolute(computeCurrentLineStartOffset());
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#LINE_END}
	 */
	protected void defaultNavigateLineEnd() {
		final int caretLine = computeCurrentLineNumber();
		moveCaretAbsolute(getControl().getContent().getOffsetAtLine(caretLine) + getControl().getContent().getLine(caretLine).length());
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#WORD_NEXT}
	 */
	protected void defaultNavigateWordNext() {
		int following = TextUtil.findWordEndOffset(getControl().getContent(), getControl().getCaretOffset(), true);
		if (following != BreakIterator.DONE) {
			moveCaretAbsolute(following);
		}
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#WORD_PREVIOUS}
	 */
	protected void defaultNavigateWordPrevious() {
		int previous = TextUtil.findWordStartOffset(getControl().getContent(), getControl().getCaretOffset(), true);
		if (previous != BreakIterator.DONE) {
			moveCaretAbsolute(previous);
		}
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#TEXT_START}
	 */
	protected void defaultSelectTextStart() {
		moveCaretAbsolute(0, true);
	}


	/**
	 * default implementation for {@link DefaultTextEditActions#TEXT_END}
	 */
	protected void defaultSelectTextEnd() {
		moveCaretAbsolute(getControl().getCharCount(), true);
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#SELECT_TEXT_PAGE_UP}
	 */
	protected void defaultNavigateTextPageUp() {
		moveCaretAbsolute(calculatePageUpOffset(), false);
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#SELECT_TEXT_PAGE_DOWN}
	 */
	protected void defaultNavigateTextPageDown() {
		moveCaretAbsolute(calculatePageDownOffset(), false);
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#LINE_START}
	 */
	protected void defaultSelectLineStart() {
		// TODO Should be position to the first none whitespace char??
		moveCaretAbsolute(computeCurrentLineStartOffset(), true);
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#LINE_END}
	 */
	protected void defaultSelectLineEnd() {
		int caretLine = getControl().getContent().getLineAtOffset(getControl().getCaretOffset());
		int end = getControl().getContent().getOffsetAtLine(caretLine) + getControl().getContent().getLine(caretLine).length();
		moveCaretAbsolute(end, true);
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#SELECT_WORD_NEXT}
	 */
	protected void defaultSelectWordNext() {
		int following = TextUtil.findWordEndOffset(
				getControl().getContent(),
				getControl().getCaretOffset(), true);
		if (following != BreakIterator.DONE) {
			moveCaretAbsolute(following, true);
		}
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#SELECT_WORD_PREVIOUS}
	 */
	protected void defaultSelectWordPrevious() {
		int previous = TextUtil.findWordStartOffset(
				getControl().getContent(),
				getControl().getCaretOffset(), true);
		if (previous != BreakIterator.DONE) {
			moveCaretAbsolute(previous, true);
		}
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#SELECT_WORD}
	 */
	protected void defaultSelectWord() {
		IntTuple bounds = TextUtil.findWordBounds(getControl().getContent(), getControl().getCaretOffset(), true);
		int previous = bounds.value1;
		int next = bounds.value2;
		if (previous != BreakIterator.DONE && next != BreakIterator.DONE) {
			moveCaretAbsolute(previous);
			moveCaretAbsolute(next, true);
		}
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#SELECT_LINE}
	 */
	protected void defaultSelectLine() {
		@NonNull
		LineRegion lineRegion = getLineRegion(getControl().getSelection());
		lineRegion.selectWithCaretAtEnd();
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#DELETE_LINE}
	 */
	protected void defaultDeleteLine() {
		LineRegion lineRegion = getLineRegion(getControl().getSelection());
		lineRegion.replace(""); //$NON-NLS-1$
		moveCaretAbsolute(lineRegion.start);
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#DELETE_WORD_NEXT}
	 */
	protected void defaultDeleteWordNext() {
		int offset = getControl().getCaretOffset();
		int following = TextUtil.findWordEndOffset(
				getControl().getContent(),
				offset, true);
		if (following != BreakIterator.DONE) {
			getControl().getContent().replaceTextRange(getControl().getCaretOffset(), following - offset, ""); //$NON-NLS-1$
		}
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#DELETE_WORD_PREVIOUS}
	 */
	protected void defaultDeleteWordPrevious() {
		int offset = getControl().getCaretOffset();
		int previous = TextUtil.findWordStartOffset(getControl().getContent(), offset, true);
		if (previous != BreakIterator.DONE) {
			getControl().setCaretOffset(previous);
			getControl().getContent().replaceTextRange(previous, offset - previous, ""); //$NON-NLS-1$
		}
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#MOVE_LINES_UP}
	 */
	protected void defaultMoveLinesUp() {
		LineRegion moveTarget = getLineRegion(getControl().getSelection());
		if (moveTarget.firstLine > 0) {
			LineRegion above = new LineRegion(moveTarget.firstLine - 1);
			LineRegion all = new LineRegion(above.firstLine, moveTarget.lastLine);

			String aboveText = above.read();
			String moveTargetText = moveTarget.read();
			// we reach the last line
			if (moveTarget.lastLine + 1 == getControl().getContent().getLineCount()) {
				moveTargetText += getControl().getLineSeparator().getValue();
				aboveText = aboveText.replaceFirst("\r?\n$", ""); //$NON-NLS-1$ //$NON-NLS-2$
			}

			all.replace(moveTargetText + aboveText);
			new LineRegion(moveTarget.firstLine - 1, moveTarget.lastLine - 1).selectWithCaretAtStart();
		}
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#MOVE_LINES_DOWN}
	 */
	protected void defaultMoveLinesDown() {
		LineRegion moveTarget = getLineRegion(getControl().getSelection());
		if (moveTarget.lastLine + 1 < getControl().getContent().getLineCount()) {

			LineRegion below = new LineRegion(moveTarget.lastLine + 1);
			LineRegion all = new LineRegion(moveTarget.firstLine, below.lastLine);

			String belowText = below.read();
			String moveTargetText = moveTarget.read();
			// we reach the last line
			if (below.lastLine + 1 == getControl().getContent().getLineCount()) {
				belowText += getControl().getLineSeparator().getValue();
				moveTargetText = moveTargetText.replaceFirst("\r?\n$", ""); //$NON-NLS-1$ //$NON-NLS-2$
			}

			all.replace(belowText + moveTargetText);
			new LineRegion(moveTarget.firstLine + 1, moveTarget.lastLine + 1).selectWithCaretAtStart();
		}
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#NEW_LINE}
	 */
	protected void defaultNewLine() {
		int offset = getControl().getCaretOffset();
		int line = getControl().getContent().getLineAtOffset(offset);
		String lineContent = getControl().getContent().getLine(line);

		// Should we make this configurable
		char[] chars = lineContent.toCharArray();
		String prefix = ""; //$NON-NLS-1$
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ' || chars[i] == '\t') {
				prefix += chars[i];
			} else {
				break;
			}
		}

		if (getControl().getSelection().length > 0) {
			int caretPos = getControl().getSelection().offset + getControl().getLineSeparator().getValue().length() + prefix.length();
			getControl().getContent().replaceTextRange(getControl().getSelection().offset, getControl().getSelection().length, getControl().getLineSeparator().getValue() + prefix);
			getControl().setCaretOffset( caretPos );
		}
		else {
			getControl().getContent().replaceTextRange(getControl().getCaretOffset(), 0, getControl().getLineSeparator().getValue() + prefix);
			getControl().setCaretOffset(offset + getControl().getLineSeparator().getValue().length() + prefix.length());
		}

	}

	/**
	 * default implementation for {@link DefaultTextEditActions#SELECT_ALL}
	 */
	protected void defaultSelectAll() {
		int length = getControl().getContent().getCharCount();
		getControl().setSelectionRange(0, length);
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#COPY}
	 */
	protected void defaultCopy() {
		getControl().copy();
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#PASTE}
	 */
	protected void defaultPaste() {
		if (getControl().getEditable()) {
			getControl().paste();
		}
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#CUT}
	 */
	protected void defaultCut() {
		if (getControl().getEditable()) {
			getControl().cut();
		}
	}



	/**
	 * default implementation for {@link DefaultTextEditActions#DELETE}
	 */
	protected void defaultDelete() {
		int offset = getControl().getCaretOffset();
		TextSelection selection = getControl().getSelection();
		if (selection.length > 0) {
			getControl().getContent().replaceTextRange(selection.offset, selection.length, ""); //$NON-NLS-1$
			getControl().setCaretOffset(selection.offset);
		} else {

			int del = 1;
			if (getControl().getCaretOffset() + 2 <= getControl().getContent().getCharCount()) {
				if ("\r\n".equals(getControl().getContent().getTextRange(getControl().getCaretOffset(), 2))) { //$NON-NLS-1$
					del = 2;
				}
			}

			if (getControl().getCaretOffset() + del <= getControl().getContent().getCharCount()) {
				getControl().getContent().replaceTextRange(getControl().getCaretOffset(), del, ""); //$NON-NLS-1$
				getControl().setCaretOffset(offset);
			}
		}
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#DELETE_PREVIOUS}
	 */
	protected void defaultDeletePrevious() {
		int offset = getControl().getCaretOffset();
		TextSelection selection = getControl().getSelection();
		if (selection.length > 0) {
			getControl().getContent().replaceTextRange(selection.offset, selection.length, ""); //$NON-NLS-1$
			getControl().setCaretOffset(selection.offset);
		} else {
			int start = getControl().getCaretOffset() - 1;
			int del = 1;

			if (start - 1 >= 0) {
				if ("\r\n".equals(getControl().getContent().getTextRange(getControl().getCaretOffset()-2, 2))) { //$NON-NLS-1$
					start = start - 1;
					del = 2;
				}
			}

			if( start >= 0 ) {
				getControl().getContent().replaceTextRange(start, del, ""); //$NON-NLS-1$
				getControl().setCaretOffset(offset - del);			}
		}
	}

	private boolean isMultilineSelection() {
		return getControl().getLineAtOffset(getControl().getSelection().offset) != getControl().getLineAtOffset(getControl().getSelection().offset + getControl().getSelection().length);
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#INDENT}
	 */
	protected void defaultIndent() {
		if (isMultilineSelection()) {

			// TODO use LineRegion
			// TODO only replace selected lines

			String allContent = getControl().getContent().getTextRange(0, getControl().getCharCount());
			StringBuffer dataBuffer = new StringBuffer(allContent);

			final int caret = getControl().getCaretOffset();
			final int selectionOffset = getControl().getSelection().offset;
			final int selectionLength = getControl().getSelection().length;

			final int firstLine = getControl().getLineAtOffset(selectionOffset);
			int lastLine = getControl().getLineAtOffset(selectionOffset + selectionLength);

			if (getControl().getOffsetAtLine(lastLine) < selectionOffset + selectionLength) {
				// we need to indent this line too
				lastLine += 1;
			}

			int added = 0;

			int firstLineDelta = 0;
			int indentLength = getControl().isInsertSpacesForTab() ? getControl().getTabAdvance() : 1;

			String insertString = "\t"; //$NON-NLS-1$
			if( getControl().isInsertSpacesForTab() ) {
				StringBuilder b = new StringBuilder();
				for( int i = 0; i < getControl().getTabAdvance(); i++ ) {
					b.append(" "); //$NON-NLS-1$
				}
				insertString = b.toString();
			}

			for (int lineNumber = firstLine; lineNumber < lastLine; lineNumber++) {
				int lineStart = getControl().getOffsetAtLine(lineNumber) + added;
				dataBuffer.replace(lineStart, lineStart + 0, insertString);
				added += insertString.length();
				if (lineNumber == firstLine) {
					if (selectionOffset > lineStart) {
						firstLineDelta = selectionOffset - lineStart;
					}
				}
			}

			int start = selectionOffset - firstLineDelta;
			int length = selectionLength + added + firstLineDelta;
			String replaced = dataBuffer.substring(start,start+length);

			getControl().getContent().replaceTextRange(start, length-added, replaced);
			getControl().setCaretOffset(selectionOffset == caret ? caret + indentLength : caret + added);
			getControl().setSelectionRange(selectionOffset + indentLength, selectionLength + added - indentLength);
		}
	}


	/**
	 * default implementation for {@link DefaultTextEditActions#OUTDENT}
	 */
	protected void defaultOutdent() {
		// TODO use LineRegion
		// TODO only replace selected lines

		String allContent = getControl().getContent().getTextRange(0, getControl().getCharCount());
		StringBuffer dataBuffer = new StringBuffer(allContent);

		final int caret = getControl().getCaretOffset();
		final int selectionOffset = getControl().getSelection().offset;
		final int selectionLength = getControl().getSelection().length;

		final int firstLine = getControl().getLineAtOffset(selectionOffset);
		int lastLine = getControl().getLineAtOffset(selectionOffset + selectionLength);

		if (getControl().getOffsetAtLine(lastLine) < selectionOffset + selectionLength) {
			// we need to indent this line too
			lastLine += 1;
		}

		int firstLineDelta = 0;
		int firstLineSelectionIndent = 0;
		int[] removals = new int[lastLine-firstLine];

		for (int lineNumber = firstLine; lineNumber < lastLine; lineNumber++) {
			int lineStart = getControl().getOffsetAtLine(lineNumber);
			if (dataBuffer.charAt(lineStart) != '\t') {
				String begin = dataBuffer.substring(lineStart,Math.min(lineStart + getControl().getTabAdvance(), dataBuffer.length()));
				if( begin.length() != getControl().getTabAdvance() ) {
					return;
				} else {
					char[] cs = begin.toCharArray();
					for( int i = 0; i < cs.length; i++ ) {
						if( cs[i] == '\t' ) {
							removals[lineNumber-firstLine] = i+1;
							break;
						} else if( cs[i] != ' ' ) {
							return;
						}
					}
					if( removals[lineNumber-firstLine] == 0 ) {
						removals[lineNumber-firstLine] = getControl().getTabAdvance();
					}
				}
			} else {
				removals[lineNumber-firstLine] = 1;
			}
			if (lineNumber == firstLine) {
				if (selectionOffset > lineStart) {
					firstLineDelta = removals[lineNumber-firstLine];
					firstLineSelectionIndent = selectionOffset - lineStart;
				}
			}
		}

		int start = selectionOffset - firstLineSelectionIndent;
		int end = start + selectionLength + firstLineSelectionIndent;
		String replacedText = dataBuffer.substring(start, end);

		int removed = 0;

		for (int lineNumber = lastLine - 1; lineNumber >= firstLine; lineNumber--) {
			int lineStart = getControl().getOffsetAtLine(lineNumber);
			dataBuffer.replace(lineStart, lineStart + removals[lineNumber-firstLine], ""); //$NON-NLS-1$
			removed += removals[lineNumber-firstLine];
		}

		String newText = dataBuffer.substring(start, end - removed);

		getControl().getContent().replaceTextRange(start, replacedText.length(), newText);
		getControl().setCaretOffset(selectionOffset == caret ? caret - firstLineDelta : caret - removed);
		getControl().setSelectionRange(selectionOffset - firstLineDelta, selectionLength - removed + firstLineDelta);
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#MOVE_UP} and
	 * {@link DefaultTextEditActions#SELECT_UP}
	 *
	 * @param select
	 *            whether to change the selection
	 */
	protected void defaultUp(boolean select) {
		int currentRowIndex = getControl().getContent().getLineAtOffset(getControl().getCaretOffset());

		final int offset = getControl().getCaretOffset();

		int rowIndex = currentRowIndex;

		if (rowIndex == 0) {
			return;
		}

		int colIdx = offset - getControl().getContent().getOffsetAtLine(rowIndex);
		rowIndex -= 1;

		int lineOffset = getControl().getContent().getOffsetAtLine(rowIndex);
		int newCaretPosition = lineOffset + colIdx;
		int maxPosition = lineOffset + getControl().getContent().getLine(rowIndex).length();

		moveCaretAbsolute(Math.min(newCaretPosition, maxPosition), select);
	}


	/**
	 * default implementation for {@link DefaultTextEditActions#MOVE_DOWN} and
	 * {@link DefaultTextEditActions#SELECT_DOWN}
	 *
	 * @param select
	 *            whether to change the selection
	 */
	protected void defaultDown(boolean select) {
		int currentRowIndex = getControl().getContent().getLineAtOffset(getControl().getCaretOffset());

		final int offset = getControl().getCaretOffset();

		int rowIndex = currentRowIndex;
		if (rowIndex + 1 == getControl().getContent().getLineCount()) {
			return;
		}

		int colIdx = offset - getControl().getContent().getOffsetAtLine(rowIndex);
		rowIndex += 1;

		int lineOffset = getControl().getContent().getOffsetAtLine(rowIndex);
		int newCaretPosition = lineOffset + colIdx;
		int maxPosition = lineOffset + getControl().getContent().getLine(rowIndex).length();

		moveCaretAbsolute(Math.min(newCaretPosition, maxPosition), select);
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#MOVE_LEFT} and
	 * {@link DefaultTextEditActions#SELECT_LEFT}
	 *
	 * @param select
	 *            whether to change the selection
	 */
	protected void defaultLeft(boolean select) {
		moveCaretRelative(-1, select);
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#NAVIGATE_TO_LINE}
	 */
	protected void defaultNavigateToLine() {
		try {
			Optional<Integer> num = ((StyledTextSkin)getControl().getSkin()).fastQuery("Goto Line", "Line Number", Integer::parseInt);
			num.ifPresent((n)->defaultNavigateToLine(n-1));

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void defaultNavigateToLine(int lineIndex) {
		getControl().navigateToLine(lineIndex);
	}



	/**
	 * default implementation for {@link DefaultTextEditActions#MOVE_RIGHT} and
	 * {@link DefaultTextEditActions#SELECT_RIGHT}
	 *
	 * @param select
	 *            whether to change the selection
	 */
	protected void defaultRight(boolean select) {
		moveCaretRelative(1, select);
	}

	/**
	 * default implementation for {@link DefaultTextEditActions#SCROLL_LINE_UP}
	 */
	protected void defaultScrollLineUp() {
		((StyledTextSkin) getControl().getSkin()).scrollLineUp();
	}


	/**
	 * default implementation for {@link DefaultTextEditActions#SCROLL_LINE_DOWN}
	 */
	protected void defaultScrollLineDown() {
		((StyledTextSkin) getControl().getSkin()).scrollLineDown();
	}

	void moveCaretAbsolute(int absoluteOffset) {
		int offset = Math.max(0, absoluteOffset);
		offset = Math.min(getControl().getCharCount(), offset);
		getControl().setCaretOffset(offset);
	}

	@SuppressWarnings("deprecation")
	private void moveCaretAbsolute(int absoluteOffset, boolean select) {
		int offset = Math.max(0, absoluteOffset);
		offset = Math.min(getControl().getCharCount(), offset);

		// we need to jump 2 chars if windows line endings are in effect
		if( offset > 0 ) {
			String textRange = getControl().getContent().getTextRange(offset-1, 1);
			// check the navigation direction
			if( getControl().getCaretOffset() > offset ) {
				if( textRange.equals("\r") ) { //$NON-NLS-1$
					offset -= 1;
				}
			} else {
				if( textRange.equals("\r") ) { //$NON-NLS-1$
					offset += 1;
				}
			}
		}

		getControl().impl_setCaretOffset(Math.max(0,offset), select);
	}

	private void moveCaretRelative(int deltaOffset, boolean select) {
		int offset = getControl().getCaretOffset() + deltaOffset;
		moveCaretAbsolute(offset, select);
	}

	/**
	 * initializes the key mappings.
	 *
	 * @param keyMapping
	 *            the mapping
	 */
	protected void initKeymapping(TriggerActionMapping m) {

		if (Util.isMacOS()) {
			m.map("Meta+Left", DefaultTextEditActions.LINE_START); //$NON-NLS-1$
			m.map("Meta+Right", DefaultTextEditActions.LINE_END); //$NON-NLS-1$
			m.map("Meta+Up", DefaultTextEditActions.TEXT_START); //$NON-NLS-1$
			m.map("Meta+Down", DefaultTextEditActions.TEXT_END); //$NON-NLS-1$
			m.map("Alt+Right", DefaultTextEditActions.WORD_NEXT); //$NON-NLS-1$
			m.map("Alt+Left", DefaultTextEditActions.WORD_PREVIOUS); //$NON-NLS-1$
			m.map("Page Down", DefaultTextEditActions.TEXT_PAGE_DOWN); //$NON-NLS-1$
			m.map("Page Up", DefaultTextEditActions.TEXT_PAGE_UP); //$NON-NLS-1$

			m.map("Meta+Shift+Left", DefaultTextEditActions.SELECT_LINE_START); //$NON-NLS-1$
			m.map("Meta+Shift+Right", DefaultTextEditActions.SELECT_LINE_END); //$NON-NLS-1$
			m.map("Meta+Shift+Up", DefaultTextEditActions.SELECT_TEXT_START); //$NON-NLS-1$
			m.map("Meta+Shift+Down", DefaultTextEditActions.SELECT_TEXT_END); //$NON-NLS-1$
			m.map("Alt+Shift+Right", DefaultTextEditActions.SELECT_WORD_NEXT); //$NON-NLS-1$
			m.map("Alt+Shift+Left", DefaultTextEditActions.SELECT_WORD_PREVIOUS); //$NON-NLS-1$
			m.map("Shift+Page Down", DefaultTextEditActions.SELECT_TEXT_PAGE_DOWN); //$NON-NLS-1$
			m.map("Shift+Page Up", DefaultTextEditActions.SELECT_TEXT_PAGE_UP); //$NON-NLS-1$

			m.map("Alt+Delete", DefaultTextEditActions.DELETE_WORD_NEXT); //$NON-NLS-1$
			m.map("Alt+Backspace", DefaultTextEditActions.DELETE_WORD_PREVIOUS); //$NON-NLS-1$

			m.map("Meta+D", DefaultTextEditActions.DELETE_LINE); //$NON-NLS-1$

			m.map("Meta+C", DefaultTextEditActions.COPY); //$NON-NLS-1$
			m.map("Meta+V", DefaultTextEditActions.PASTE); //$NON-NLS-1$
			m.map("Meta+X", DefaultTextEditActions.CUT); //$NON-NLS-1$

			m.map("Meta+A", DefaultTextEditActions.SELECT_ALL); //$NON-NLS-1$

			m.map("Meta+Up", DefaultTextEditActions.SCROLL_LINE_UP); //$NON-NLS-1$
			m.map("Meta+Down", DefaultTextEditActions.SCROLL_LINE_DOWN); //$NON-NLS-1$

			m.map("Alt+Up", DefaultTextEditActions.MOVE_LINES_UP); //$NON-NLS-1$
			m.map("Alt+Down", DefaultTextEditActions.MOVE_LINES_DOWN); //$NON-NLS-1$

			m.map("Meta+L", DefaultTextEditActions.NAVIGATE_TO_LINE); //$NON-NLS-1$
		} else {

			m.map("Ctrl+Right", DefaultTextEditActions.WORD_NEXT); //$NON-NLS-1$
			m.map("Ctrl+Left", DefaultTextEditActions.WORD_PREVIOUS); //$NON-NLS-1$

			m.map("Ctrl+Shift+Right", DefaultTextEditActions.SELECT_WORD_NEXT); //$NON-NLS-1$
			m.map("Ctrl+Shift+Left", DefaultTextEditActions.SELECT_WORD_PREVIOUS); //$NON-NLS-1$

			m.map("Page Down", DefaultTextEditActions.TEXT_PAGE_DOWN); //$NON-NLS-1$
			m.map("Page Up", DefaultTextEditActions.TEXT_PAGE_UP); //$NON-NLS-1$
			m.map("Shift+Page Down", DefaultTextEditActions.SELECT_TEXT_PAGE_DOWN); //$NON-NLS-1$
			m.map("Shift+Page Up", DefaultTextEditActions.SELECT_TEXT_PAGE_UP); //$NON-NLS-1$

			m.map("Home", DefaultTextEditActions.LINE_START); //$NON-NLS-1$
			m.map("Shift+Home", DefaultTextEditActions.SELECT_LINE_START); //$NON-NLS-1$

			m.map("Ctrl+Home", DefaultTextEditActions.TEXT_START); //$NON-NLS-1$

			m.map("Ctrl+Shift+Home", DefaultTextEditActions.SELECT_TEXT_START); //$NON-NLS-1$

			m.map("End", DefaultTextEditActions.LINE_END); //$NON-NLS-1$
			m.map("Shift+End", DefaultTextEditActions.SELECT_LINE_END); //$NON-NLS-1$
			m.map("Ctrl+End", DefaultTextEditActions.TEXT_END); //$NON-NLS-1$
			m.map("Ctrl+Shift+End", DefaultTextEditActions.SELECT_TEXT_END); //$NON-NLS-1$

			m.map("Ctrl+Delete", DefaultTextEditActions.DELETE_WORD_NEXT); //$NON-NLS-1$
			m.map("Ctrl+Backspace", DefaultTextEditActions.DELETE_WORD_PREVIOUS); //$NON-NLS-1$

			m.map("Ctrl+C", DefaultTextEditActions.COPY); //$NON-NLS-1$
			m.map("Ctrl+V", DefaultTextEditActions.PASTE); //$NON-NLS-1$
			m.map("Ctrl+X", DefaultTextEditActions.CUT); //$NON-NLS-1$

			m.map("Ctrl+Insert", DefaultTextEditActions.COPY); //$NON-NLS-1$
			m.map("Shift+Insert", DefaultTextEditActions.PASTE); //$NON-NLS-1$
			
			m.map("Ctrl+A", DefaultTextEditActions.SELECT_ALL); //$NON-NLS-1$

			m.map("Ctrl+Up", DefaultTextEditActions.SCROLL_LINE_UP); //$NON-NLS-1$
			m.map("Ctrl+Down", DefaultTextEditActions.SCROLL_LINE_DOWN); //$NON-NLS-1$

			m.map("Ctrl+D", DefaultTextEditActions.DELETE_LINE); //$NON-NLS-1$

			m.map("Alt+Up", DefaultTextEditActions.MOVE_LINES_UP); //$NON-NLS-1$
			m.map("Alt+Down", DefaultTextEditActions.MOVE_LINES_DOWN); //$NON-NLS-1$

			m.map("Ctrl+L", DefaultTextEditActions.NAVIGATE_TO_LINE); //$NON-NLS-1$

		}

		m.mapConditional("tab-on-multiline", this::isMultilineSelection, "Tab", DefaultTextEditActions.INDENT);  //$NON-NLS-1$//$NON-NLS-2$
		m.map("Shift+Tab", DefaultTextEditActions.OUTDENT); //$NON-NLS-1$

		m.map("Delete", DefaultTextEditActions.DELETE); //$NON-NLS-1$
		m.map("Backspace", DefaultTextEditActions.DELETE_PREVIOUS); //$NON-NLS-1$

		m.map("Enter", DefaultTextEditActions.NEW_LINE); //$NON-NLS-1$

		m.map("Up", DefaultTextEditActions.MOVE_UP); //$NON-NLS-1$
		m.map("Down", DefaultTextEditActions.MOVE_DOWN); //$NON-NLS-1$
		m.map("Left", DefaultTextEditActions.MOVE_LEFT); //$NON-NLS-1$
		m.map("Right", DefaultTextEditActions.MOVE_RIGHT); //$NON-NLS-1$

		m.map("Shift+Up", DefaultTextEditActions.SELECT_UP); //$NON-NLS-1$
		m.map("Shift+Down", DefaultTextEditActions.SELECT_DOWN); //$NON-NLS-1$
		m.map("Shift+Left", DefaultTextEditActions.SELECT_LEFT); //$NON-NLS-1$
		m.map("Shift+Right", DefaultTextEditActions.SELECT_RIGHT); //$NON-NLS-1$
	}

	/**
	 * Trigger the action
	 * @param action the action
	 */
	public void triggerAction(TextEditAction action) {
		keyTriggerMapping.triggerAction(action, new Context(getControl()));
	}

}

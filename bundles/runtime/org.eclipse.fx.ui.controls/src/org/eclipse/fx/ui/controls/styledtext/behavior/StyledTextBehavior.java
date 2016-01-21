/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Christoph Caks <ccaks@bestsolution.at> - improved editor behavior
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.behavior;

import static javafx.scene.input.KeyCode.A;
import static javafx.scene.input.KeyCode.BACK_SPACE;
import static javafx.scene.input.KeyCode.C;
import static javafx.scene.input.KeyCode.D;
import static javafx.scene.input.KeyCode.DELETE;
import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.E;
import static javafx.scene.input.KeyCode.END;
import static javafx.scene.input.KeyCode.ENTER;
import static javafx.scene.input.KeyCode.HOME;
import static javafx.scene.input.KeyCode.LEFT;
import static javafx.scene.input.KeyCode.RIGHT;
import static javafx.scene.input.KeyCode.TAB;
import static javafx.scene.input.KeyCode.UP;
import static javafx.scene.input.KeyCode.V;
import static javafx.scene.input.KeyCode.X;
import static org.eclipse.fx.ui.controls.styledtext.behavior.StyledTextBehavior.KeyMapping.MetaKey.AltKey;
import static org.eclipse.fx.ui.controls.styledtext.behavior.StyledTextBehavior.KeyMapping.MetaKey.ControlKey;
import static org.eclipse.fx.ui.controls.styledtext.behavior.StyledTextBehavior.KeyMapping.MetaKey.MetaKey;
import static org.eclipse.fx.ui.controls.styledtext.behavior.StyledTextBehavior.KeyMapping.MetaKey.ShiftKey;

import java.text.BreakIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

import org.eclipse.fx.core.Util;
import org.eclipse.fx.ui.controls.styledtext.ActionEvent;
import org.eclipse.fx.ui.controls.styledtext.ActionEvent.ActionType;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.fx.ui.controls.styledtext.StyledTextContent;
import org.eclipse.fx.ui.controls.styledtext.StyledTextLayoutContainer;
import org.eclipse.fx.ui.controls.styledtext.TextSelection;
import org.eclipse.fx.ui.controls.styledtext.VerifyEvent;
import org.eclipse.fx.ui.controls.styledtext.behavior.StyledTextBehavior.KeyMapping.InputAction;
import org.eclipse.fx.ui.controls.styledtext.behavior.StyledTextBehavior.KeyMapping.KeyCombo;
import org.eclipse.fx.ui.controls.styledtext.skin.StyledTextSkin;
import org.eclipse.fx.ui.controls.styledtext.skin.StyledTextSkin.LineCell;
import org.eclipse.jdt.annotation.NonNull;

import javafx.event.Event;
import javafx.geometry.Bounds;
import javafx.scene.control.Control;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * Behavior for styled text
 */
public class StyledTextBehavior {



	private final StyledTextArea styledText;

	private KeyMapping keyMapping = new KeyMapping();

	/**
	 * Create a new behavior
	 *
	 * @param styledText
	 *            the styled text control
	 */
	public StyledTextBehavior(StyledTextArea styledText) {
		this.styledText = styledText;
		styledText.addEventHandler(KeyEvent.KEY_PRESSED, this::onKeyPressed);
		styledText.addEventHandler(KeyEvent.KEY_TYPED, this::onKeyTyped);

		styledText.addEventHandler(MouseEvent.MOUSE_PRESSED, this::onMousePressed);

		initKeymapping(keyMapping);
	}

	// called from skin
	public void installContentListeners(final Control contentNode) {
		contentNode.addEventHandler(MouseEvent.MOUSE_PRESSED, this::onContentMousePressed);
		contentNode.addEventHandler(MouseEvent.DRAG_DETECTED, this::onContentDragDetected);
		contentNode.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::onContentMouseDragged);
		contentNode.addEventHandler(MouseEvent.MOUSE_RELEASED, this::onContentMouseReleased);
		contentNode.addEventHandler(MouseEvent.MOUSE_CLICKED,  this::onContentMouseClicked);

		HoverSupport.install(contentNode);

	}

	// text manipulation utils

	static int computeStart(StyledTextContent content, int firstLine) {
		return content.getOffsetAtLine(firstLine);
	}

	static int computeEnd(StyledTextContent content, int lastLine) {
		int endIndex;
		if (content.getLineCount() > lastLine + 1) {
			endIndex = content.getOffsetAtLine(lastLine + 1);
		}
		else {
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
		lastLine = Math.min(getControl().getContent().getLineCount()-1, lastLine);
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
			return getControl().getContent().getTextRange(start, length);
		}

		public void replace(String replacement) {
			getControl().getContent().replaceTextRange(start, length, replacement);
		}

		public void select() {
			System.err.println("selecting " + start + " l " + length);
			moveCaretAbsolute(start);
			getControl().setSelection(new TextSelection(start, length));
		}


	}

	private volatile boolean dragMoveTextMode = false;
	private volatile boolean dragSelectionMode = false;


	// state for dnd stuff

	private volatile int dragMoveTextOffset = -1;
	private volatile int dragMoveTextLength = -1;

	private int mousePressedOffset = -1;


	private boolean isInRange(int offset, int rangeOffset, int rangeLength) {
		return offset >= rangeOffset && offset < (rangeOffset + rangeLength);
	}

	private boolean isInSelection(int offset) {
		int selOffset = getControl().getSelection().offset;
		int selLength = getControl().getSelection().length;
		boolean r =  selLength > 0 && isInRange(offset, selOffset, selLength);
		System.err.println("isInSelection(" + offset + ")" + "[" + selOffset + ", " + (selOffset + selLength) + ") -> " + r);
		return r;
	}



	private void onKeyPressed(KeyEvent event) {
		VerifyEvent evt = new VerifyEvent(getControl(), getControl(), event);
		Event.fireEvent(getControl(), evt);

		// Bug in JavaFX who enables the menu when ALT is pressed
		if (Util.isMacOS()) {
			if (event.getCode() == KeyCode.ALT || event.isAltDown()) {
				event.consume();
			}
		}

		if (evt.isConsumed()) {
			event.consume();
			return;
		}

		Optional<InputAction> keyAction = this.keyMapping.get(event);
		keyAction.ifPresent(a->{
			a.run();
			event.consume();
		});
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
			}

		}
	}


	private void onContentMousePressed(MouseEvent event) {
		this.mousePressedOffset = computeCursorOffset(event);
		System.err.println("MOUSE_PRESSED @ " + mousePressedOffset);

		if (isInSelection(mousePressedOffset)) {
			System.err.println(" -> starting dragMoveTextMode");
			event.setDragDetect(true);
			this.dragMoveTextMode = true;
			this.dragMoveTextOffset = getControl().getSelection().offset;
			this.dragMoveTextLength = getControl().getSelection().length;
		}
		else {
			System.err.println(" -> setting Caret");
			moveCaretAbsolute(this.mousePressedOffset, event.isShiftDown());
		}
	}
	private void onContentDragDetected(MouseEvent event) {
		if (!this.dragMoveTextMode && ! this.dragSelectionMode) {
			this.dragSelectionMode = true;
		}
	}
	private void onContentMouseDragged(MouseEvent event) {
		if (this.dragSelectionMode) {
//			System.err.println("MOUSE_DRAGGED [dragSelectionMode]");
			int offset = computeCursorOffset(event);
			moveCaretAbsolute(offset, true);
			event.consume();
		}
		else if (this.dragMoveTextMode) {
			//System.err.println("MOUSE_DRAGGED [dragMoveTextMode]");
			// nothing to do
			event.consume();
		}
	}
	private void onContentMouseReleased(MouseEvent event) {
		System.err.println("MOUSE_RELEASED");
		if (this.dragSelectionMode) {
			this.dragSelectionMode = false;
			event.consume();
		}
		else if (this.dragMoveTextMode) {
			int targetOffset = computeCursorOffset(event);

			// replace
			if (isInRange(targetOffset, dragMoveTextOffset, dragMoveTextLength)) {
				targetOffset = dragMoveTextOffset;
			}
			// after
			else if (targetOffset >= dragMoveTextOffset + dragMoveTextLength) {
				targetOffset -= dragMoveTextLength;
			}

			// read text
			@NonNull
			String text = getControl().getContent().getTextRange(dragMoveTextOffset, dragMoveTextLength);

			// remove
			getControl().getContent().replaceTextRange(dragMoveTextOffset, dragMoveTextLength, "");

			// insert
			getControl().getContent().replaceTextRange(targetOffset, 0, text);

			// move caret to end of insertion
			moveCaretAbsolute(targetOffset + text.length());

			this.dragMoveTextMode = false;
			event.consume();
		}
	}

	private void onContentMouseClicked(MouseEvent event) {
		if (event.isStillSincePress()) {
			System.err.println("MOUSE_CLICKED @ " + mousePressedOffset);
			if (event.getClickCount() == 2 && event.getButton() == MouseButton.PRIMARY) {
				System.err.println(" -> executing double click");
				// double click
				this.ACTION_SELECT_WORD.run();
				event.consume();
			}
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

	private int computeCurrentLineNumber() {
		final int offset = getControl().getCaretOffset();
		return getControl().getLineAtOffset(offset);
	}

	private int computeCurrentLineStartOffset() {
		final int lineNumber = computeCurrentLineNumber();
		return getControl().getOffsetAtLine(lineNumber);
	}

	/**
	 * Action to go the start of the text
	 */
	protected final StyledTextInputAction ACTION_NAVIGATE_TEXT_START = new StyledTextInputAction(ActionType.TEXT_START, this::defaultNavigateTextStart);
	/**
	 * default implementation for {@link #ACTION_NAVIGATE_TEXT_START}
	 */
	protected void defaultNavigateTextStart() {
		getControl().setCaretOffset(0);
	}

	/**
	 * Action to go the start of the text
	 */
	protected final InputAction ACTION_NAVIGATE_TEXT_END = new StyledTextInputAction(ActionType.TEXT_END, this::defaultNavigateTextEnd);
	/**
	 * default implementation for {@link #ACTION_NAVIGATE_TEXT_END}
	 */
	protected void defaultNavigateTextEnd() {
		getControl().setCaretOffset(getControl().getContent().getCharCount());
	}

	/**
	 * Action to go to the line start
	 */
	protected final InputAction ACTION_NAVIGATE_LINE_START = new StyledTextInputAction(ActionType.LINE_START, this::defaultNavigateLineStart);
	/**
	 * default implementation for {@link #ACTION_NAVIGATE_LINE_START}
	 */
	protected void defaultNavigateLineStart() {
		//TODO Should be position to the first none whitespace char??
		moveCaretAbsolute(computeCurrentLineStartOffset());
	}

	/**
	 * Action to go to the line end
	 */
	protected final InputAction ACTION_NAVIGATE_LINE_END = new StyledTextInputAction(ActionType.LINE_END, this::defaultNavigateLineEnd);
	/**
	 * default implementation for {@link #ACTION_NAVIGATE_LINE_END}
	 */
	protected void defaultNavigateLineEnd() {
		final int caretLine = computeCurrentLineNumber();
		moveCaretAbsolute(getControl().getContent().getOffsetAtLine(caretLine) + getControl().getContent().getLine(caretLine).length());
	}

	/**
	 * Action to go to the next word
	 */
	protected final InputAction ACTION_NAVIGATE_WORD_NEXT = new StyledTextInputAction(ActionType.WORD_NEXT, this::defaultNavigateWordNext);
	/**
	 * default implementation for {@link #ACTION_NAVIGATE_WORD_NEXT}
	 */
	protected void defaultNavigateWordNext() {
		BreakIterator wordInstance = BreakIterator.getWordInstance();
		wordInstance.setText(new StringCharacterIterator(getControl().getContent().getTextRange(0, getControl().getContent().getCharCount())));
		int following = wordInstance.following(getControl().getCaretOffset());
		if( following != BreakIterator.DONE ) {
			moveCaretAbsolute(following);
		}
	}

	/**
	 * Action to go to the previous word
	 */
	protected final InputAction ACTION_NAVIGATE_WORD_PREVIOUS = new StyledTextInputAction(ActionType.WORD_PREVIOUS, this::defaultNavigateWordPrevious);
	/**
	 * default implementation for {@link #ACTION_NAVIGATE_WORD_PREVIOUS}
	 */
	protected void defaultNavigateWordPrevious() {
		BreakIterator wordInstance = BreakIterator.getWordInstance();
		wordInstance.setText(new StringCharacterIterator(getControl().getContent().getTextRange(0, getControl().getContent().getCharCount())));
		int previous = wordInstance.preceding(getControl().getCaretOffset());
		if( previous != BreakIterator.DONE ) {
			moveCaretAbsolute(previous);
		}
	}

	/**
	 * Action to select to the start of the text
	 */
	protected final InputAction ACTION_SELECT_TEXT_START = new StyledTextInputAction(ActionType.SELECT_TEXT_START, this::defaultSelectTextStart);
	/**
	 * default implementation for {@link #ACTION_SELECT_TEXT_START}
	 */
	protected void defaultSelectTextStart() {
		moveCaretAbsolute(0, true);
	}

	/**
	 * Action to select to the end of the text
	 */
	protected final InputAction ACTION_SELECT_TEXT_END = new StyledTextInputAction(ActionType.SELECT_TEXT_END, this::defaultSelectTextEnd);
	/**
	 * default implementation for {@link #ACTION_SELECT_TEXT_END}
	 */
	protected void defaultSelectTextEnd() {
		moveCaretAbsolute(getControl().getCharCount(),true);
	}

	/**
	 * Action to select until the start of the line
	 */
	protected final InputAction ACTION_SELECT_LINE_START = new StyledTextInputAction(ActionType.SELECT_LINE_START, this::defaultSelectLineStart);
	/**
	 * default implementation for {@link #ACTION_SELECT_LINE_START}
	 */
	protected void defaultSelectLineStart() {
		//TODO Should be position to the first none whitespace char??
		moveCaretAbsolute(computeCurrentLineStartOffset(), true);
	}

	/**
	 * Action to select until the end of the line
	 */
	protected final InputAction ACTION_SELECT_LINE_END = new StyledTextInputAction(ActionType.SELECT_LINE_END, this::defaultSelectLineEnd);
	/**
	 * default implementation for {@link #ACTION_SELECT_LINE_END}
	 */
	protected void defaultSelectLineEnd() {
		int caretLine = getControl().getContent().getLineAtOffset(getControl().getCaretOffset());
		int end = getControl().getContent().getOffsetAtLine(caretLine) + getControl().getContent().getLine(caretLine).length();
		moveCaretAbsolute(end, true);
	}

	/**
	 * Action to select the next word
	 */
	protected final InputAction ACTION_SELECT_WORD_NEXT = new StyledTextInputAction(ActionType.SELECT_WORD_NEXT, this::defaultSelectWordNext);
	/**
	 * default implementation for {@link #ACTION_SELECT_WORD_NEXT}
	 */
	protected void defaultSelectWordNext() {
		BreakIterator wordInstance = BreakIterator.getWordInstance();
		wordInstance.setText(new StringCharacterIterator(getControl().getContent().getTextRange(0, getControl().getContent().getCharCount())));
		int following = wordInstance.following(getControl().getCaretOffset());
		if( following != BreakIterator.DONE ) {
			moveCaretAbsolute(following, true);
		}
	}

	/**
	 * Action to select the previous word
	 */
	protected final InputAction ACTION_SELECT_WORD_PREVIOUS = new StyledTextInputAction(ActionType.SELECT_WORD_PREVIOUS, this::defaultSelectWordPrevious);
	/**
	 * default implementation for {@link #ACTION_SELECT_WORD_PREVIOUS}
	 */
	protected void defaultSelectWordPrevious() {
		BreakIterator wordInstance = BreakIterator.getWordInstance();
		wordInstance.setText(new StringCharacterIterator(getControl().getContent().getTextRange(0, getControl().getContent().getCharCount())));
		int previous = wordInstance.preceding(getControl().getCaretOffset());
		if( previous != BreakIterator.DONE ) {
			moveCaretAbsolute(previous, true);
		}
	}

	/**
	 * Action to select the word at the current cursor
	 */
	protected final InputAction ACTION_SELECT_WORD = new StyledTextInputAction(ActionType.SELECT_WORD, this::defaultSelectWord);
	/**
	 * default implementation for {@link #ACTION_SELECT_WORD}
	 */
	protected void defaultSelectWord() {
		BreakIterator wordInstance = BreakIterator.getWordInstance();
		wordInstance.setText(new StringCharacterIterator(getControl().getContent().getTextRange(0, getControl().getContent().getCharCount())));
		int previous = wordInstance.preceding(getControl().getCaretOffset());
		int next = wordInstance.following(getControl().getCaretOffset());
		if( previous != BreakIterator.DONE && next != BreakIterator.DONE ) {
			moveCaretAbsolute(previous);
			moveCaretAbsolute(next, true);
		}
	}

	/**
	 * Action to delete current line
	 */
	protected final InputAction ACTION_DELETE_LINE = new StyledTextInputAction(this::defaultDeleteLine);
	/**
	 * default implementation for {@link #ACTION_DELETE_WORD_NEXT}
	 */
	protected void defaultDeleteLine() {
		LineRegion lineRegion = getLineRegion(getControl().getSelection());
		lineRegion.replace(""); //$NON-NLS-1$
		moveCaretAbsolute(lineRegion.start);

//		@NonNull
//		LineSelection lineSelection = getLineSelection();
//
//		System.err.println("delete " + lineSelection.firstLine + " to " + lineSelection.lastLine);
//		int beginIndex = getControl().getOffsetAtLine(lineSelection.firstLine);
//		int endIndex;
//		if (getControl().getContent().getLineCount() > lineSelection.lastLine + 1) {
//			endIndex = getControl().getOffsetAtLine(lineSelection.lastLine + 1);
//		}
//		else {
//			endIndex = getControl().getOffsetAtLine(lineSelection.lastLine) + getControl().getContent().getLine(lineSelection.lastLine).length();
//		}
//
//		getControl().getContent().replaceTextRange(beginIndex, endIndex - beginIndex, ""); //$NON-NLS-1$
//		moveCaretAbsolute(beginIndex);
	}

	/**
	 * Action to delete next word
	 */
	protected final InputAction ACTION_DELETE_WORD_NEXT = new StyledTextInputAction(ActionType.DELETE_WORD_NEXT, this::defaultDeleteWordNext);
	/**
	 * default implementation for {@link #ACTION_DELETE_WORD_NEXT}
	 */
	protected void defaultDeleteWordNext() {
		int offset = getControl().getCaretOffset();
		BreakIterator wordInstance = BreakIterator.getWordInstance();
		wordInstance.setText(new StringCharacterIterator(getControl().getContent().getTextRange(0, getControl().getContent().getCharCount())));
		int following = wordInstance.following(getControl().getCaretOffset());
		if( following != BreakIterator.DONE ) {
			getControl().getContent().replaceTextRange(getControl().getCaretOffset(), following - offset, ""); //$NON-NLS-1$
		}
	}

	/**
	 * Action to delete previous word
	 */
	protected final InputAction ACTION_DELETE_WORD_PREVIOUS = new StyledTextInputAction(ActionType.DELETE_WORD_PREVIOUS, this::defaultDeleteWordPrevious);
	/**
	 * default implementation for {@link #ACTION_DELETE_WORD_PREVIOUS}
	 */
	protected void defaultDeleteWordPrevious() {
		int offset = getControl().getCaretOffset();
		BreakIterator wordInstance = BreakIterator.getWordInstance();
		wordInstance.setText(new StringCharacterIterator(getControl().getContent().getTextRange(0, getControl().getContent().getCharCount())));
		int previous = wordInstance.preceding(getControl().getCaretOffset());
		if( previous != BreakIterator.DONE ) {
			getControl().setCaretOffset(previous);
			getControl().getContent().replaceTextRange(previous, offset - previous, ""); //$NON-NLS-1$
		}
	}

	/**
	 * Action to move selected lines up
	 */
	protected final InputAction ACTION_MOVE_LINES_UP = new StyledTextInputAction(this::defaultMoveLinesUp);
	/**
	 * default implementation for {@link #ACTION_MOVE_LINES_UP}
	 */
	protected void defaultMoveLinesUp() {
		LineRegion moveTarget = getLineRegion(getControl().getSelection());
		if (moveTarget.firstLine > 0) {
			LineRegion above = new LineRegion(moveTarget.firstLine -1);
			LineRegion all = new LineRegion(above.firstLine, moveTarget.lastLine);

			String aboveText = above.read();
			String moveTargetText = moveTarget.read();
			// we reach the last line
			if (moveTarget.lastLine + 1 == getControl().getContent().getLineCount()) {
				moveTargetText += getControl().getLineSeparator().getValue();
				aboveText = aboveText.replaceFirst("\r?\n$", ""); //$NON-NLS-1$ //$NON-NLS-2$
			}

			all.replace( moveTargetText + aboveText);
			new LineRegion(moveTarget.firstLine -1, moveTarget.lastLine -1).select();
		}
	}

	/**
	 * Action to move selected lines down
	 */
	protected final InputAction ACTION_MOVE_LINES_DOWN = new StyledTextInputAction(this::defaultMoveLinesDown);
	/**
	 * default implementation for {@link #ACTION_MOVE_LINES_DOWN}
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
			new LineRegion(moveTarget.firstLine +1, moveTarget.lastLine +1).select();
		}
	}


	/**
	 * Action to create a new line
	 */
	protected final InputAction ACTION_NEW_LINE = new StyledTextInputAction(ActionType.NEW_LINE, this::defaultNewLine);
	/**
	 * default implementation for {@link #ACTION_NEW_LINE}
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
		getControl().getContent().replaceTextRange(getControl().getCaretOffset(), 0, getControl().getLineSeparator().getValue() + prefix);
		getControl().setCaretOffset(offset + getControl().getLineSeparator().getValue().length() + prefix.length());

	}

	/**
	 * Action to select all
	 */
	protected final InputAction ACTION_SELECT_ALL = new StyledTextInputAction(this::defaultSelectAll);
	/**
	 * default implementation for {@link #ACTION_SELECT_ALL}
	 */
	protected void defaultSelectAll() {
		int length = getControl().getContent().getCharCount();
		getControl().setSelectionRange(0, length);
	}

	/**
	 * Action to copy
	 */
	protected final InputAction ACTION_COPY = new StyledTextInputAction(this::defaultCopy);
	/**
	 * default implementation for {@link #ACTION_COPY}
	 */
	protected void defaultCopy() {
		getControl().copy();
	}

	/**
	 * Action to paste
	 */
	protected final InputAction ACTION_PASTE = new StyledTextInputAction(this::defaultPaste);
	/**
	 * default implementation for {@link #ACTION_PASTE}
	 */
	protected void defaultPaste() {
		if (getControl().getEditable()) {
			getControl().paste();
		}
	}

	/**
	 * Action to cut
	 */
	protected final InputAction ACTION_CUT = new StyledTextInputAction(this::defaultCut);
	/**
	 * default implementation for {@link #ACTION_CUT}
	 */
	protected void defaultCut() {
		if (getControl().getEditable()) {
			getControl().cut();
		}
	}

	/**
	 * Action to delete
	 */
	protected final InputAction ACTION_DELETE = new StyledTextInputAction(this::defaultDelete);
	/**
	 * default implementation for {@link #ACTION_DELETE}
	 */
	protected void defaultDelete() {
		int offset = getControl().getCaretOffset();
		TextSelection selection = getControl().getSelection();
		if (selection.length > 0) {
			getControl().getContent().replaceTextRange(selection.offset, selection.length, ""); //$NON-NLS-1$
			getControl().setCaretOffset(selection.offset);
		} else {
			getControl().getContent().replaceTextRange(getControl().getCaretOffset(), 1, ""); //$NON-NLS-1$
			getControl().setCaretOffset(offset);
		}
	}

	/**
	 * Action to delete backwards
	 */
	protected final InputAction ACTION_BACKSPACE = new StyledTextInputAction(this::defaultBackspace);
	/**
	 * default implementation for {@link #ACTION_BACKSPACE}
	 */
	protected void defaultBackspace() {
		int offset = getControl().getCaretOffset();
		TextSelection selection = getControl().getSelection();
		if (selection.length > 0) {
			getControl().getContent().replaceTextRange(selection.offset, selection.length, ""); //$NON-NLS-1$
			getControl().setCaretOffset(selection.offset);
		} else {
			getControl().getContent().replaceTextRange(getControl().getCaretOffset() - 1, 1, ""); //$NON-NLS-1$
			getControl().setCaretOffset(offset - 1);
		}
	}


	private boolean isMultilineSelection() {
		return getControl().getLineAtOffset(getControl().getSelection().offset) != getControl().getLineAtOffset(getControl().getSelection().offset + getControl().getSelection().length);
	}


	/**
	 * Action to indent
	 */
	protected final InputAction ACTION_INDENT = new StyledTextInputAction(ActionType.INDENT, this::defaultIndent);
	/**
	 * default implementation for {@link #ACTION_INDENT}
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

			for (int lineNumber = firstLine; lineNumber < lastLine; lineNumber++) {
				int lineStart = getControl().getOffsetAtLine(lineNumber) + added;
				dataBuffer.replace(lineStart, lineStart + 0, "\t"); //$NON-NLS-1$
				added += 1;
				if (lineNumber == firstLine) {
					if (selectionOffset > lineStart) {
						firstLineDelta = 1;
					}
				}
			}

			getControl().getContent().setText(dataBuffer.toString());
			getControl().setCaretOffset(caret + added);
			getControl().setSelectionRange(selectionOffset + firstLineDelta, selectionLength + added - firstLineDelta);
		}
	}

	/**
	 * Action to outdent (opposite of indentation)
	 */
	protected final StyledTextInputAction ACTION_OUTDENT = new StyledTextInputAction(ActionType.OUTDENT, this::defaultOutdent);
	/**
	 * default implementation for {@link #ACTION_OUTDENT}
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

		for (int lineNumber = firstLine; lineNumber < lastLine; lineNumber++) {
			int lineStart = getControl().getOffsetAtLine(lineNumber);
			if (dataBuffer.charAt(lineStart)!='\t') {
				return;
			}
			if (lineNumber == firstLine) {
				if (selectionOffset > lineStart) {
					firstLineDelta = 1;
				}
			}
		}

		int removed = 0;

		for (int lineNumber = lastLine-1; lineNumber >= firstLine; lineNumber--) {
			int lineStart = getControl().getOffsetAtLine(lineNumber);
			dataBuffer.replace(lineStart, lineStart + 1, "");
			removed += 1;
		}

		getControl().getContent().setText(dataBuffer.toString());
		getControl().setCaretOffset(caret - removed);
		getControl().setSelectionRange(selectionOffset - firstLineDelta, selectionLength - removed + firstLineDelta);
	}

	/**
	 * Action to move caret upwards
	 */
	protected final StyledTextInputAction ACTION_MOVE_UP = new StyledTextInputAction(()->defaultUp(false));
	/**
	 * Action to move caret upwards while selecting
	 */
	protected final StyledTextInputAction ACTION_SELECT_UP = new StyledTextInputAction(()->defaultUp(true));

	/**
	 * default implementation for {@link #ACTION_MOVE_UP} and {@link #ACTION_SELECT_UP}
	 * @param select whether to change the selection
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
	 * Action to move caret down
	 */
	protected final StyledTextInputAction ACTION_MOVE_DOWN = new StyledTextInputAction(()->defaultDown(false));
	/**
	 * Action to move caret down while selecting
	 */
	protected final StyledTextInputAction ACTION_SELECT_DOWN = new StyledTextInputAction(()->defaultDown(true));

	/**
	 * default implementation for {@link #ACTION_MOVE_DOWN} and {@link #ACTION_SELECT_DOWN}
	 * @param select whether to change the selection
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
	 * Action to move caret left
	 */
	protected final StyledTextInputAction ACTION_MOVE_LEFT = new StyledTextInputAction(()->defaultLeft(false));
	/**
	 * Action to move caret left while selecting
	 */
	protected final StyledTextInputAction ACTION_SELECT_LEFT = new StyledTextInputAction(()->defaultLeft(true));

	/**
	 * default implementation for {@link #ACTION_MOVE_LEFT} and {@link #ACTION_SELECT_LEFT}
	 * @param select whether to change the selection
	 */
	protected void defaultLeft(boolean select) {
		moveCaretRelative(-1, select);
	}

	/**
	 * Action to move caret right
	 */
	protected final StyledTextInputAction ACTION_MOVE_RIGHT = new StyledTextInputAction(()->defaultRight(false));
	/**
	 * Action to move caret right while selecting
	 */
	protected final StyledTextInputAction ACTION_SELECT_RIGHT = new StyledTextInputAction(()->defaultRight(true));

	/**
	 * default implementation for {@link #ACTION_MOVE_RIGHT} and {@link #ACTION_SELECT_RIGHT}
	 * @param select whether to change the selection
	 */
	protected void defaultRight(boolean select) {
		moveCaretRelative(1, select);
	}


	/**
	 * Action to scroll one line up
	 */
	protected final StyledTextInputAction ACTION_SCROLL_LINE_UP = new StyledTextInputAction(this::defaultScrollLineUp);
	/**
	 * default implementation for {@link #ACTION_SCROLL_LINE_UP}
	 */
	protected void defaultScrollLineUp() {
		((StyledTextSkin)getControl().getSkin()).scrollLineUp();
	}

	/**
	 * Action to scroll one line down
	 */
	protected final StyledTextInputAction ACTION_SCROLL_LINE_DOWN = new StyledTextInputAction(this::defaultScrollLineDown);
	/**
	 * default implementation for {@link #ACTION_SCROLL_LINE_DOWN}
	 */
	protected void defaultScrollLineDown() {
		((StyledTextSkin)getControl().getSkin()).scrollLineDown();
	}


	private void moveCaretAbsolute(int absoluteOffset) {
		int offset = Math.max(0, absoluteOffset);
		offset = Math.min(getControl().getCharCount(), offset);
		getControl().setCaretOffset(offset);
	}

	@SuppressWarnings("deprecation")
	private void moveCaretAbsolute(int absoluteOffset, boolean select) {
		int offset = Math.max(0, absoluteOffset);
		offset = Math.min(getControl().getCharCount(), offset);
		getControl().impl_setCaretOffset(offset, select);
	}

	private void moveCaretRelative(int deltaOffset, boolean select) {
		int offset = getControl().getCaretOffset() + deltaOffset;
		moveCaretAbsolute(offset, select);
	}

	protected static class KeyMapping {
		public static enum MetaKey {
			AltKey,
			ControlKey,
			MetaKey,
			ShiftKey
		}

		public static class KeyCombo {
			public final KeyCode code;
			public final Set<MetaKey> meta;

			public KeyCombo(KeyCode code, MetaKey... meta) {
				this.code = code;
				this.meta = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(meta)));
			}

			@Override
			public String toString() {
				return code + " " + meta;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((code == null) ? 0 : code.hashCode());
				result = prime * result + ((meta == null) ? 0 : meta.hashCode());
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				KeyCombo other = (KeyCombo) obj;
				if (code != other.code)
					return false;
				if (meta == null) {
					if (other.meta != null)
						return false;
				} else if (!meta.equals(other.meta))
					return false;
				return true;
			}

		}

		public static interface Mapping {
			Supplier<Boolean> getCondition();
			InputAction getAction();
		}

		public static class SimpleMapping implements Mapping {
			private final Supplier<Boolean> condition;
			private final InputAction action;

			@Override
			public Supplier<Boolean> getCondition() {
				return condition;
			}

			@Override
			public InputAction getAction() {
				return action;
			}

			public SimpleMapping(Supplier<Boolean> condition, InputAction action) {
				this.condition = condition;
				this.action = action;
			}

		}

		public interface InputAction extends Runnable {
		}

		private Map<KeyCombo, List<Mapping>> comboMapping = new HashMap<>();

		/**
		 * maps a key combination to an action
		 * @param combo
		 * @param action
		 */
		public void mapKey(KeyCombo combo, InputAction action) {
			List<Mapping> list = this.comboMapping.get(combo);
			if (list == null) {
				list = new ArrayList<>();
				this.comboMapping.put(combo, list);
			}
			list.add(new SimpleMapping(()->true, action));
		}

		/**
		 * maps a key combination to an action
		 * @param combo
		 * @param action
		 * @param condition
		 */
		public void mapKey(KeyCombo combo, InputAction action, Supplier<Boolean> condition) {
			List<Mapping> list = this.comboMapping.get(combo);
			if (list == null) {
				list = new ArrayList<>();
				this.comboMapping.put(combo, list);
			}
			list.add(new SimpleMapping(condition, action));
		}

		/**
		 * looks up the action for the specified combo.
		 * @param combo
		 * @return the input action
		 */
		public Optional<InputAction> get(KeyCombo combo) {
			final List<Mapping> list = this.comboMapping.getOrDefault(combo, Collections.emptyList());
			return list.stream().filter(m->m.getCondition().get()).findFirst().map(m->m.getAction());
		}

		/**
		 * looks up the action for the specified key event
		 * @param event
		 * @return the input action
		 */
		public Optional<InputAction> get(KeyEvent event) {
			return this.get(createFromEvent(event));
		}

		/**
		 * unmaps all keys
		 */
		public void clearKeyMappings() {
			this.comboMapping.clear();
		}

		/**
		 * unmaps a key
		 * @param combo
		 */
		public void unmapKey(KeyCombo combo) {
			this.comboMapping.remove(combo);
		}

		public static KeyCombo createFromEvent(KeyEvent event) {
			Set<MetaKey> metaKeys = new HashSet<>();
			if (event.isShiftDown()) metaKeys.add(ShiftKey);
			if (event.isControlDown()) metaKeys.add(ControlKey);
			if (event.isAltDown()) metaKeys.add(AltKey);
			if (event.isMetaDown()) metaKeys.add(MetaKey);

			return new KeyCombo(event.getCode(), metaKeys.toArray(new MetaKey[] {}));
		}

	}

	private class StyledTextInputAction implements KeyMapping.InputAction {
		private final ActionType event;
		private final Runnable fallback;

		private final Runnable action;

		public StyledTextInputAction(ActionType event, Runnable fallback) {
			this.event = event;
			this.fallback = fallback;
			this.action = null;
		}

		public StyledTextInputAction(Runnable action) {
			this.event = null;
			this.fallback = null;
			this.action = action;
		}


		@Override
		public void run() {
			if (this.event != null) {
				ActionEvent evt = new ActionEvent(getControl(), getControl(), this.event);
				Event.fireEvent(getControl(), evt);

				if ( !evt.isConsumed() ) {
					this.fallback.run();
				}
			}
			else {
				this.action.run();
			}
		}
	}

	/**
	 * initializes the key mappings.
	 *
	 * @param keyMapping the mapping
	 */
	protected void initKeymapping(KeyMapping keyMapping) {

		if (Util.isMacOS()) {

			keyMapping.mapKey(new KeyCombo(LEFT, MetaKey), 	this.ACTION_NAVIGATE_LINE_START);
//			keyMapping.mapKey(new KeyCombo(A, ControlKey), 		this.ACTION_NAVIGATE_LINE_START);
			keyMapping.mapKey(new KeyCombo(RIGHT, MetaKey), 	this.ACTION_NAVIGATE_LINE_END);
//			keyMapping.mapKey(new KeyCombo(E, ControlKey), 		this.ACTION_NAVIGATE_LINE_END);
			keyMapping.mapKey(new KeyCombo(UP, MetaKey), 		this.ACTION_NAVIGATE_TEXT_START);
			keyMapping.mapKey(new KeyCombo(DOWN, MetaKey), 	this.ACTION_NAVIGATE_TEXT_END);
			keyMapping.mapKey(new KeyCombo(RIGHT, AltKey), 		this.ACTION_NAVIGATE_WORD_NEXT);
			keyMapping.mapKey(new KeyCombo(LEFT, AltKey), 			this.ACTION_NAVIGATE_WORD_PREVIOUS);

			keyMapping.mapKey(new KeyCombo(LEFT, MetaKey, ShiftKey), 	this.ACTION_SELECT_LINE_START);
//			keyMapping.mapKey(new KeyCombo(A, ControlKey, ShiftKey), 		this.ACTION_SELECT_LINE_START);
			keyMapping.mapKey(new KeyCombo(RIGHT, MetaKey, ShiftKey),	this.ACTION_SELECT_LINE_END);
//			keyMapping.mapKey(new KeyCombo(E, ControlKey, ShiftKey), 		this.ACTION_SELECT_LINE_END);
			keyMapping.mapKey(new KeyCombo(UP, MetaKey, ShiftKey), 	this.ACTION_SELECT_TEXT_START);
			keyMapping.mapKey(new KeyCombo(DOWN, MetaKey, ShiftKey), 	this.ACTION_SELECT_TEXT_END);
			keyMapping.mapKey(new KeyCombo(RIGHT, AltKey, ShiftKey), 		this.ACTION_SELECT_WORD_NEXT);
			keyMapping.mapKey(new KeyCombo(LEFT, AltKey, ShiftKey), 		this.ACTION_SELECT_WORD_PREVIOUS);

			keyMapping.mapKey(new KeyCombo(DELETE, AltKey),				this.ACTION_DELETE_WORD_NEXT);
			keyMapping.mapKey(new KeyCombo(BACK_SPACE, AltKey),			this.ACTION_DELETE_WORD_PREVIOUS);
			keyMapping.mapKey(new KeyCombo(D, MetaKey), 					this.ACTION_DELETE_LINE);

			keyMapping.mapKey(new KeyCombo(C, MetaKey), 	this.ACTION_COPY);
			keyMapping.mapKey(new KeyCombo(V, MetaKey), 	this.ACTION_PASTE);
			keyMapping.mapKey(new KeyCombo(X, MetaKey), 	this.ACTION_CUT);

			keyMapping.mapKey(new KeyCombo(A, MetaKey), this.ACTION_SELECT_ALL);
			keyMapping.mapKey(new KeyCombo(D, MetaKey), 	this.ACTION_DELETE_LINE);
			keyMapping.mapKey(new KeyCombo(UP, AltKey), 		this.ACTION_MOVE_LINES_UP);
			keyMapping.mapKey(new KeyCombo(DOWN, AltKey), 		this.ACTION_MOVE_LINES_DOWN);
		}
		else {
			keyMapping.mapKey(new KeyCombo(RIGHT, ControlKey), 				this.ACTION_NAVIGATE_WORD_NEXT);
			keyMapping.mapKey(new KeyCombo(LEFT, ControlKey), 				this.ACTION_NAVIGATE_WORD_PREVIOUS);

			keyMapping.mapKey(new KeyCombo(RIGHT, ShiftKey, ControlKey), 	this.ACTION_SELECT_WORD_NEXT);
			keyMapping.mapKey(new KeyCombo(LEFT, ShiftKey, ControlKey), 		this.ACTION_SELECT_WORD_PREVIOUS);

			keyMapping.mapKey(new KeyCombo(HOME), 								this.ACTION_NAVIGATE_LINE_START);
			keyMapping.mapKey(new KeyCombo(HOME, ShiftKey), 					this.ACTION_SELECT_LINE_START);
			keyMapping.mapKey(new KeyCombo(HOME, ControlKey), 				this.ACTION_NAVIGATE_TEXT_START);
			keyMapping.mapKey(new KeyCombo(HOME, ControlKey, ShiftKey), 		this.ACTION_SELECT_TEXT_START);

			keyMapping.mapKey(new KeyCombo(END), 								this.ACTION_NAVIGATE_LINE_END);
			keyMapping.mapKey(new KeyCombo(END, ShiftKey), 					this.ACTION_SELECT_LINE_END);
			keyMapping.mapKey(new KeyCombo(END, ControlKey), 					this.ACTION_NAVIGATE_TEXT_END);
			keyMapping.mapKey(new KeyCombo(END, ControlKey, ShiftKey), 		this.ACTION_SELECT_TEXT_END);

			keyMapping.mapKey(new KeyCombo(DELETE, ControlKey),					this.ACTION_DELETE_WORD_NEXT);
			keyMapping.mapKey(new KeyCombo(BACK_SPACE, ControlKey),			this.ACTION_DELETE_WORD_PREVIOUS);

			keyMapping.mapKey(new KeyCombo(C, ControlKey), this.ACTION_COPY);
			keyMapping.mapKey(new KeyCombo(V, ControlKey), this.ACTION_PASTE);
			keyMapping.mapKey(new KeyCombo(X, ControlKey), this.ACTION_CUT);

			keyMapping.mapKey(new KeyCombo(A, ControlKey), this.ACTION_SELECT_ALL);

			keyMapping.mapKey(new KeyCombo(UP, ControlKey), 	this.ACTION_SCROLL_LINE_UP);
			keyMapping.mapKey(new KeyCombo(DOWN, ControlKey), this.ACTION_SCROLL_LINE_DOWN);

			keyMapping.mapKey(new KeyCombo(D, ControlKey), 	this.ACTION_DELETE_LINE);

			keyMapping.mapKey(new KeyCombo(UP, AltKey), 		this.ACTION_MOVE_LINES_UP);
			keyMapping.mapKey(new KeyCombo(DOWN, AltKey), 		this.ACTION_MOVE_LINES_DOWN);

		}

		keyMapping.mapKey(new KeyCombo(TAB), 				this.ACTION_INDENT, this::isMultilineSelection);
		keyMapping.mapKey(new KeyCombo(TAB, ShiftKey), 	this.ACTION_OUTDENT);

		keyMapping.mapKey(new KeyCombo(DELETE), this.ACTION_DELETE);
		keyMapping.mapKey(new KeyCombo(BACK_SPACE), this.ACTION_BACKSPACE);

		keyMapping.mapKey(new KeyCombo(ENTER), this.ACTION_NEW_LINE);

		keyMapping.mapKey(new KeyCombo(UP), 		this.ACTION_MOVE_UP);
		keyMapping.mapKey(new KeyCombo(DOWN), 		this.ACTION_MOVE_DOWN);
		keyMapping.mapKey(new KeyCombo(LEFT), 		this.ACTION_MOVE_LEFT);
		keyMapping.mapKey(new KeyCombo(RIGHT), 	this.ACTION_MOVE_RIGHT);

		keyMapping.mapKey(new KeyCombo(UP, ShiftKey), 			this.ACTION_SELECT_UP);
		keyMapping.mapKey(new KeyCombo(DOWN, ShiftKey), 		this.ACTION_SELECT_DOWN);
		keyMapping.mapKey(new KeyCombo(LEFT, ShiftKey), 		this.ACTION_SELECT_LEFT);
		keyMapping.mapKey(new KeyCombo(RIGHT, ShiftKey), 		this.ACTION_SELECT_RIGHT);


		// action for insert tab support
		keyMapping.mapKey(new KeyCombo(TAB), ()->getControl().insert("\t")); //$NON-NLS-1$
	}

	/**
	 * computes the text offset under the mouse cursor.
	 * @param event
	 * @return the offset
	 */
	protected int computeCursorOffset(MouseEvent event) {
		List<LineCell> visibleCells = ((StyledTextSkin) getControl().getSkin()).getCurrentVisibleCells();

		LineCell lastCell = null;

		int result = getControl().getContent().getCharCount();

		for (LineCell tmp : visibleCells) {
			Bounds boundsInParent = tmp.getBoundsInParent();
			if (boundsInParent.getMinY() > event.getY()) {
				if (lastCell == null) {
					lastCell = tmp;
				}

				if (lastCell.getDomainElement() != null) {
					StyledTextLayoutContainer n = (StyledTextLayoutContainer) lastCell.getGraphic();
					if (n.localToScene(n.getBoundsInLocal()).contains(event.getSceneX(), event.getSceneY())) {
						int index = n.getCaretIndexAtPoint(n.sceneToLocal(event.getSceneX(), event.getSceneY()));
						if (index >= 0) {
							return n.getStartOffset() + index;
						}
					}

					final double minX = n.localToScene(n.getBoundsInLocal()).getMinX();
					final double mouseX = event.getSceneX();
					final boolean left = minX >= mouseX;

					result = lastCell.getDomainElement().getLineOffset() + (left ? 0 : lastCell.getDomainElement().getLineLength());
				}
				break;
			}
			lastCell = tmp;
		}
		return result;
	}





}

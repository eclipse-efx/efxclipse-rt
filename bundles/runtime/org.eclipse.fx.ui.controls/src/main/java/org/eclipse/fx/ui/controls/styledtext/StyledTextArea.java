/*******************************************************************************
 * Copyright (c) 2013 IBM & BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Christoph Caks <ccaks@bestsolution.at> - improved editor behavior
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 * 	IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.eclipse.fx.core.text.TextEditAction;
import org.eclipse.fx.core.text.TextUtil;
import org.eclipse.fx.ui.controls.JavaFXCompatUtil;
import org.eclipse.fx.ui.controls.styledtext.StyledTextContent.TextChangeListener;
import org.eclipse.fx.ui.controls.styledtext.model.AnnotationPresenter;
import org.eclipse.fx.ui.controls.styledtext.model.AnnotationProvider;
import org.eclipse.fx.ui.controls.styledtext.skin.StyledTextSkin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import com.google.common.collect.Range;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;
import javafx.css.CssMetaData;
import javafx.css.FontCssMetaData;
import javafx.css.StyleConverter;
import javafx.css.StyleOrigin;
import javafx.css.Styleable;
import javafx.css.StyleableDoubleProperty;
import javafx.css.StyleableObjectProperty;
import javafx.css.StyleableProperty;
import javafx.geometry.Point2D;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.input.Clipboard;
import javafx.scene.input.DataFormat;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Control which allows to implemented a code-editor
 *
 * <p>
 * <b>This is an experimental component provided as a preview we'll improve and
 * fix problems in up coming releases</b>
 * </p>
 *
 * @noreference
 */
public class StyledTextArea extends Control {
	class ContentProperty extends SimpleObjectProperty<@NonNull StyledTextContent> {
		WeakReference<StyledTextContent> oldContent;

		public ContentProperty(Object bean, String name, @NonNull StyledTextContent initialValue) {
			super(bean, name, initialValue);
			invalidated();
		}

		@Override
		protected void invalidated() {
			if (this.oldContent != null) {
				StyledTextContent content = this.oldContent.get();
				if (content != null) {
					content.removeTextChangeListener(StyledTextArea.this.textChangeListener);
				}
			}
			StyledTextContent newContent = get();

			this.oldContent = new WeakReference<StyledTextContent>(newContent);
			newContent.addTextChangeListener(StyledTextArea.this.textChangeListener);
		}
	}

	@NonNull
	final ObjectProperty<@NonNull StyledTextContent> contentProperty;

	TextChangeListener textChangeListener = new TextChangeListener() {
		@Override
		public void textChanging(TextChangingEvent event) {
			handleTextChanging(event);
		}

		@Override
		public void textChanged(TextChangedEvent event) {
			handleTextChanged(event);
		}

		@Override
		public void textSet(TextChangedEvent event) {
			handleTextSet(event);
		}
	};

	@NonNull
	private final DoubleProperty fontZoomFactor = new SimpleDoubleProperty(this, "fontZoomFactor", 1.0); //$NON-NLS-1$
	public DoubleProperty fontZoomFactorProperty() {
		return this.fontZoomFactor;
	}
	public void setFontZoomFactor(double factor) {
		this.fontZoomFactor.set(factor);
	}
	public double getFontZoomFactor() {
		return this.fontZoomFactor.get();
	}

	@NonNull
	private final StyledTextRenderer renderer = new StyledTextRenderer();

	@NonNull
	private final IntegerProperty caretOffsetProperty = new SimpleIntegerProperty(this, "caretOffset", 0); //$NON-NLS-1$

	@NonNull
	private final BooleanProperty lineRulerVisible = new SimpleBooleanProperty(this, "lineRulerVisible"); //$NON-NLS-1$

	@NonNull
	private final ObjectProperty<TextSelection> currentSelection = new SimpleObjectProperty<>(this, "currentSelection"); //$NON-NLS-1$

	@NonNull
	private final IntegerProperty tabAdvance = new SimpleIntegerProperty(this, "tabAdvance", 4); //$NON-NLS-1$

	@NonNull
	private final BooleanProperty insertSpacesForTab = new SimpleBooleanProperty(this, "insertSpacesForTab", false); //$NON-NLS-1$

	@NonNull
	private final ObjectProperty<TriggerActionMapping> overrideActionMappingProperty = new SimpleObjectProperty<>(this, "overrideActionMapping"); //$NON-NLS-1$

	public void setOverrideActionMapping(TriggerActionMapping mapping) {
		this.overrideActionMappingProperty.set(mapping);
	}

	public TriggerActionMapping getOverrideActionMapping() {
		return this.overrideActionMappingProperty.get();
	}

	public ObjectProperty<TriggerActionMapping> overrideActionMappingProperty() {
		return this.overrideActionMappingProperty;
	}

	/**
	 * Separator for lines
	 */
	public enum LineSeparator {
		/**
		 * \n eg os-x and linux default
		 */
		NEW_LINE("\n"), //$NON-NLS-1$
		/**
		 * \r\n default on windows
		 */
		CARRIAGE_RETURN_NEW_LINE("\r\n"); //$NON-NLS-1$

		private String value;

		private LineSeparator(String value) {
			this.value = value;
		}

		/**
		 * @return line separator
		 */
		public String getValue() {
			return this.value;
		}
	}

	@NonNull
	private final ObjectProperty<@NonNull LineSeparator> lineSeparator = new SimpleObjectProperty<>(this, "lineSeparator", "\n".equals(System.getProperty("line.separator")) ? LineSeparator.NEW_LINE : LineSeparator.CARRIAGE_RETURN_NEW_LINE); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	private SetProperty<AnnotationPresenter> annotationPresenter = new SimpleSetProperty<>(this, "annotationPresenter", FXCollections.observableSet()); //$NON-NLS-1$

	/**
	 * @return set of all registered annotation presenters
	 */
	public SetProperty<AnnotationPresenter> getAnnotationPresenter() {
		return this.annotationPresenter;
	}

	private SetProperty<AnnotationProvider> annotationProvider = new SimpleSetProperty<>(this, "annotationProvider", FXCollections.observableSet()); //$NON-NLS-1$

	/**
	 * @return set of all registered annotation providers
	 */
	public SetProperty<AnnotationProvider> getAnnotationProvider() {
		return this.annotationProvider;
	}

	public static interface QuickLinkable {
		Range<Integer> getRegion();

		List<QuickLink> getLinks();
	}

	public static interface QuickLink {
		String getLabel();
	}

	public static interface SimpleQuickLink extends QuickLink {
		Range<Integer> getRegion();
	}

	public static interface CustomQuickLink extends QuickLink {
		Runnable getAction();
	}

	private ObjectProperty<Function<Integer, Optional<QuickLinkable>>> quickLinkCallbackProperty = new SimpleObjectProperty<>(this, "quickLinkCallback", (offset) -> Optional.empty());

	/**
	 * sets the quick link callback.
	 * <p>
	 * If the callback returns one ore more entries, quick linking is available
	 * for the cursor position
	 * </p>
	 *
	 * @param callback
	 *            the quick linking callback
	 */
	public void setQuickLinkCallback(Function<Integer, Optional<QuickLinkable>> callback) {
		this.quickLinkCallbackProperty.set(callback);
	}

	/**
	 * returns the quick link callback.
	 *
	 * @return the quick linking callback
	 */
	public Function<Integer, Optional<QuickLinkable>> getQuickLinkCallback() {
		return this.quickLinkCallbackProperty.get();
	}

	private int anchor;

	// private int lastTextChangeStart;

	// private int lastTextChangeNewLineCount;

	private int lastTextChangeNewCharCount;

	// private int lastTextChangeReplaceLineCount;

	private int lastTextChangeReplaceCharCount;

	private static final String USER_AGENT_STYLESHEET = StyledTextArea.class.getResource("styledtextarea.css").toExternalForm(); //$NON-NLS-1$

	/**
	 * Create a new control
	 */
	public StyledTextArea() {
		this.getStyleClass().add("styled-text-area"); //$NON-NLS-1$
		this.contentProperty = new ContentProperty(this, "content", new DefaultContent()); //$NON-NLS-1$
		setFocusTraversable(true);

		//FIXME This rules out the CSS-Setting!
		// we cannot change remove it because the dynamic zoom depends on it -.-
		DoubleBinding lineHeight = org.eclipse.fx.ui.controls.Util.createTextHeightBinding("Pj", fontProperty(), this.fontZoomFactor); //$NON-NLS-1$
		fixedLineHeightProperty().bind(lineHeight.multiply(1.3));
	}

	static final CssMetaData<StyledTextArea, Number> FIXED_LINE_HEIGHT = new CssMetaData<StyledTextArea, Number>("-fx-fixed-line-height", //$NON-NLS-1$
			StyleConverter.getSizeConverter(), Integer.valueOf(16)) {

		@Override
		public boolean isSettable(StyledTextArea n) {
			return n.fixedLineHeight == null || !n.fixedLineHeight.isBound();
		}

		@Override
		@SuppressWarnings("unchecked")
		public StyleableProperty<Number> getStyleableProperty(StyledTextArea n) {
			return (StyleableProperty<Number>) n.fixedLineHeight;
		}
	};

	final DoubleProperty fixedLineHeight = new StyleableDoubleProperty(16) {
		@Override
		public Object getBean() {
			return StyledTextArea.this;
		}

		@Override
		public String getName() {
			return "fixedLineHeight"; //$NON-NLS-1$
		}

		@Override
		public CssMetaData<StyledTextArea, Number> getCssMetaData() {
			return FIXED_LINE_HEIGHT;
		}
	};

	/**
	 * @return the current fixed line height
	 */
	public double getFixedLineHeight() {
		return this.fixedLineHeight.get();
	}

	/**
	 * Set the fixed line height
	 *
	 * @param fixedLineHeight
	 *            the fixed line height
	 */
	public void setFixedLineHeight(double fixedLineHeight) {
		this.fixedLineHeight.set(fixedLineHeight);
	}

	/**
	 * @return the fixed line height
	 */
	public DoubleProperty fixedLineHeightProperty() {
		return this.fixedLineHeight;
	}

	static final FontCssMetaData<StyledTextArea> FONT = new FontCssMetaData<StyledTextArea>("-fx-font", Font.getDefault()) { //$NON-NLS-1$

		@Override
		public boolean isSettable(StyledTextArea n) {
			return n.font == null | !n.font.isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Font> getStyleableProperty(StyledTextArea n) {
			return (StyleableProperty<Font>) n.fontProperty();
		}

	};

	final ObjectProperty<Font> font = new StyleableObjectProperty<Font>(Font.getDefault()) {
		private boolean settingFontViaCSS = false;

		@Override
		public CssMetaData<? extends Styleable, Font> getCssMetaData() {
			return FONT;
		}

		@Override
		public Object getBean() {
			return StyledTextArea.this;
		}

		@Override
		public String getName() {
			return "font"; //$NON-NLS-1$
		}

		@Override
		public void applyStyle(StyleOrigin newOrigin, Font value) {
			try {
				this.settingFontViaCSS = true;
				super.applyStyle(newOrigin, value);
			} finally {
				this.settingFontViaCSS = false;
			}

		}

		@Override
		protected void invalidated() {
			super.invalidated();
			if (this.settingFontViaCSS == false) {
				JavaFXCompatUtil.reapplyCSS(StyledTextArea.this);
			}
		}

	};

	/**
	 * @return the default font used by the widget
	 */
	public final ObjectProperty<Font> fontProperty() {
		return this.font;
	}

	/**
	 * Set the default font used by the widget
	 *
	 * @param value
	 *            the value
	 */
	public final void setFont(Font value) {
		this.font.setValue(value);
	}

	/**
	 * @return the default font used by the widget
	 */
	public final Font getFont() {
		return this.font.getValue();
	}

	/**
	 * @return the current line separator
	 * @since 2.2.0
	 */
	public @NonNull LineSeparator getLineSeparator() {
		return this.lineSeparator.get();
	}

	@Override
	public String getUserAgentStylesheet() {
		return USER_AGENT_STYLESHEET;
	}

	private TextChangingEvent changingEvent;

	void handleTextChanging(TextChangingEvent event) {
		this.changingEvent = event;

		this.renderer.textChanging(event);

		if (event.replaceCharCount < 0) {
			event.offset += event.replaceCharCount;
			event.replaceCharCount *= -1;
		}

		// this.lastTextChangeStart = event.offset;
		// this.lastTextChangeNewLineCount = event.newLineCount;
		this.lastTextChangeNewCharCount = event.newCharCount;
		// this.lastTextChangeReplaceLineCount = event.replaceLineCount;
		this.lastTextChangeReplaceCharCount = event.replaceCharCount;

		// Update the caret offset if it is greater than the length of the
		// content.
		// This is necessary since style range API may be called between the
		// handleTextChanging and handleTextChanged events and this API sets the
		// caretOffset.
		int newEndOfText = getContent().getCharCount() - event.replaceCharCount + event.newCharCount;
		if (getCaretOffset() > newEndOfText)
			setCaretOffset(newEndOfText/* , SWT.DEFAULT */);
	}

	void handleTextChanged(TextChangedEvent xxx) {
		if (this.changingEvent == null) {
			// full text change
			int newCharCount = getCharCount();
			if (this.caretOffsetProperty.get() > newCharCount) {
				this.caretOffsetProperty.set(newCharCount);
			}

			// in SWT this is done in reset()
			clearSelection();

			// if( getSkin() instanceof StyledTextSkin ) {
			// ((StyledTextSkin)getSkin()).computeModel();
			// }
		} else {
			// partial text change
			// TextChangingEvent event = this.changingEvent;
			this.changingEvent = null;

			// if (getSkin() instanceof StyledTextSkin) {
			// ((StyledTextSkin) getSkin()).computeModelDelta(event);
			// }
		}
	}

	void handleTextSet(TextChangedEvent event) {
		this.changingEvent = null;
	}

	void updateSelection(int startOffset, int replacedLength, int newLength) {
		if (getSelection().offset + getSelection().length > startOffset && getSelection().offset < startOffset + replacedLength) {
			// selection intersects replaced text. set caret behind text change
			setSelection(new TextSelection(startOffset + newLength,
					0)/* , true, false */);
		} else {
			// move selection to keep same text selected

			int computedOffset = getSelection().offset + newLength - replacedLength;
			if (computedOffset >= 0 && computedOffset < getCharCount()) {
				// we only set this if the offset is valid!!
				setSelection(new TextSelection(computedOffset,
						getSelection().length)/* , true, false */);
			}
			if (getSelection().length > 0) {
				int delta = this.lastTextChangeNewCharCount - this.lastTextChangeReplaceCharCount;
				this.caretOffsetProperty.set(Math.max(0, Math.min(getCharCount() - 1, getCaretOffset() + delta)));
			}
		}
	}

	@Override
	protected Skin<?> createDefaultSkin() {
		return new StyledTextSkin(this);
	}

	/**
	 * Show a line ruler on the left
	 * <p>
	 * Default is <code>false</code>
	 * </p>
	 *
	 * @return the property
	 */
	public @NonNull BooleanProperty lineRulerVisibleProperty() {
		return this.lineRulerVisible;
	}

	/**
	 * Show/hide the line ruler
	 * <p>
	 * Default is <code>false</code>
	 * </p>
	 *
	 * @param lineRulerVisible
	 *            the new state
	 */
	public void setLineRulerVisible(boolean lineRulerVisible) {
		lineRulerVisibleProperty().set(lineRulerVisible);
	}

	/**
	 * Is line ruler shown
	 * <p>
	 * Default is <code>false</code>
	 * </p>
	 *
	 * @return the current state
	 */
	public boolean isLineRulerVisible() {
		return lineRulerVisibleProperty().get();
	}

	/**
	 * The current caret offset
	 *
	 * @return the property
	 */
	public @NonNull IntegerProperty caretOffsetProperty() {
		return this.caretOffsetProperty;
	}

	/**
	 * Set the current caret offset
	 *
	 * @param offset
	 *            the new offset
	 */
	public void setCaretOffset(int offset) {
		this.anchor = offset;
		caretOffsetProperty().set(offset);
		clearSelection();
	}

	/**
	 * Setting the caret offset and updateing the selection if requested
	 *
	 * @param offset
	 *            the offset
	 * @param selection
	 *            <code>true</code> to update the current selection
	 * @deprecated internal API for now
	 */
	@Deprecated
	public void impl_setCaretOffset(int offset, boolean selection) {
		if (selection) {
			caretOffsetProperty().set(offset);

			if (offset > this.anchor) {
				setSelectionRange(this.anchor, offset - this.anchor);
			} else {
				setSelectionRange(offset, this.anchor - offset);
			}
		} else {
			setCaretOffset(offset);
		}
	}

	/**
	 * @return the current caret offset
	 */
	public int getCaretOffset() {
		return caretOffsetProperty().get();
	}

	/**
	 * Set the content
	 *
	 * @param content
	 *            the content
	 */
	public void setContent(@NonNull StyledTextContent content) {
		contentProperty().set(content);
	}

	/**
	 * Access the content
	 *
	 * @return the content
	 */
	public @NonNull StyledTextContent getContent() {
		return contentProperty().get();
	}

	/**
	 * The content property
	 *
	 * @return the property
	 */
	public @NonNull ObjectProperty<@NonNull StyledTextContent> contentProperty() {
		return this.contentProperty;
	}

	/**
	 * Set the style range
	 *
	 * @param range
	 *            the range
	 */
	public void setStyleRange(@Nullable StyleRange range) {
		if (range != null) {
			if (range.isUnstyled()) {
				setStyleRanges(range.start, range.length, null, null, false);
			} else {
				setStyleRanges(range.start, 0, null, new StyleRange[] { range }, false);
			}
		} else {
			setStyleRanges(0, 0, null, null, true);
		}
	}

	/**
	 * Set the style range
	 *
	 * @param start
	 *            the start
	 * @param length
	 *            the length
	 * @param ranges
	 *            the ranges
	 * @param styles
	 *            the style ranges
	 */
	public void setStyleRanges(int start, int length, int[] ranges, @Nullable StyleRange[] styles) {
		if (ranges == null || styles == null) {
			setStyleRanges(start, length, null, null, false);
		} else {
			setStyleRanges(start, length, ranges, styles, false);
		}
	}

	/**
	 * Set the style ranges
	 *
	 * @param ranges
	 *            the ranges
	 * @param styles
	 *            the style ranges
	 */
	public void setStyleRanges(int[] ranges, @Nullable StyleRange[] styles) {
		if (ranges == null || styles == null) {
			setStyleRanges(0, 0, null, null, true);
		} else {
			setStyleRanges(0, 0, ranges, styles, true);
		}
	}

	/**
	 * Set the style ranges
	 *
	 * @param ranges
	 *            the ranges
	 */
	public void setStyleRanges(@Nullable StyleRange... ranges) {
		setStyleRanges(0, 0, null, ranges, true);
	}

	/**
	 * Replace style ranges
	 *
	 * @param start
	 *            the start
	 * @param length
	 *            the length
	 * @param ranges
	 *            the new ranges
	 */
	public void replaceStyleRanges(int start, int length, @Nullable StyleRange[] ranges) {
		if (ranges == null)
			throw new IllegalArgumentException();
		setStyleRanges(start, length, null, ranges, false);
	}

	void setStyleRanges(int start, int length, int[] ranges, StyleRange[] styles, boolean reset) {
		int charCount = getContent().getCharCount();
		int end = start + length;
		if (start > end || start < 0) {
			throw new IllegalArgumentException();
		}

		if (styles != null) {
			if (end > charCount) {
				throw new IllegalArgumentException();
			}
			if (ranges != null) {
				if (ranges.length != styles.length << 1)
					throw new IllegalArgumentException();
			}
			int lastOffset = 0;
			// boolean variableHeight = false;
			for (int i = 0; i < styles.length; i++) {
				if (styles[i] == null) {
					throw new IllegalArgumentException();
				}
				int rangeStart, rangeLength;
				if (ranges != null) {
					rangeStart = ranges[i << 1];
					rangeLength = ranges[(i << 1) + 1];
				} else {
					rangeStart = styles[i].start;
					rangeLength = styles[i].length;
				}
				if (rangeLength < 0) {
					throw new IllegalArgumentException();
				}
				if (!(0 <= rangeStart && rangeStart + rangeLength <= charCount)) {
					throw new IllegalArgumentException();
				}
				if (lastOffset > rangeStart) {
					throw new IllegalArgumentException();
				}
				// variableHeight |= styles[i].isVariableHeight();
				lastOffset = rangeStart + rangeLength;
			}
			// if (variableHeight) setVariableLineHeight();
		}

		@SuppressWarnings("unused")
		int rangeStart = start, rangeEnd = end;
		if (styles != null && styles.length > 0) {
			if (ranges != null) {
				rangeStart = ranges[0];
				rangeEnd = ranges[ranges.length - 2] + ranges[ranges.length - 1];
			} else {
				rangeStart = styles[0].start;
				rangeEnd = styles[styles.length - 1].start + styles[styles.length - 1].length;
			}
		}

		if (reset) {
			this.renderer.setStyleRanges(null, null);
		} else {
			this.renderer.updateRanges(start, length, length);
		}

		if (styles != null && styles.length > 0) {
			this.renderer.setStyleRanges(ranges, styles);
		}

		if( getSkin() instanceof StyledTextSkin ) {
			((StyledTextSkin)getSkin()).refreshStyles(start, length);
		}

		// if (getSkin() instanceof StyledTextSkin) {
		// ((StyledTextSkin) getSkin()).requestRedraw();
		// }

	}

	/**
	 * Access style ranges in the specified segment
	 *
	 * @param start
	 *            the start
	 * @param length
	 *            the length
	 * @param includeRanges
	 *            include ranges
	 * @return the ranges
	 */
	public StyleRange[] getStyleRanges(int start, int length, boolean includeRanges) {
		StyleRange[] ranges = this.renderer.getStyleRanges(start, length, includeRanges);
		if (ranges != null)
			return ranges;
		return new StyleRange[0];
	}

	/**
	 * The style range at the given offset
	 *
	 * @param offset
	 *            the offset
	 * @return the style range
	 */
	public StyleRange getStyleRangeAtOffset(int offset) {
		if (offset < 0 || offset >= getCharCount()) {
			throw new IllegalArgumentException();
		}
		// if (!isListening(ST.LineGetStyle)) {
		StyleRange[] ranges = this.renderer.getStyleRanges(offset, 1, true);
		if (ranges != null)
			return ranges[0];
		// }
		return null;
	}

	/**
	 * @return the current char count
	 */
	public int getCharCount() {
		return getContent().getCharCount();
	}

	static class LineInfo {
		int flags;
		Color background;
		int alignment;
		int indent;
		int wrapIndent;
		boolean justify;
		int[] segments;
		char[] segmentsChars;
		int[] tabStops;

		public LineInfo() {
		}

		public LineInfo(LineInfo info) {
			if (info != null) {
				this.flags = info.flags;
				this.background = info.background;
				this.alignment = info.alignment;
				this.indent = info.indent;
				this.wrapIndent = info.wrapIndent;
				this.justify = info.justify;
				this.segments = info.segments;
				this.segmentsChars = info.segmentsChars;
				this.tabStops = info.tabStops;
			}
		}
	}

	/*******************************************************************************
	 * Copyright (c) 2000, 2011 IBM Corporation and others. All rights reserved.
	 * This program and the accompanying materials are made available under the
	 * terms of the Eclipse Public License v1.0 which accompanies this
	 * distribution, and is available at
	 * http://www.eclipse.org/legal/epl-v10.html
	 *
	 * Contributors: IBM Corporation - initial API and implementation
	 *******************************************************************************/
	class StyledTextRenderer {

		StyleRange[] stylesSet;
		int stylesSetCount = 0;
		int[] ranges;
		int styleCount;
		StyleRange[] styles;
		boolean hasLinks;
		LineInfo[] lines;
		int lineCount;
		int[] lineWidth;
		int[] lineHeight;

		final static boolean COMPACT_STYLES = true;
		final static boolean MERGE_STYLES = true;

		final static int GROW = 32;

		void setStyleRanges(int[] newRanges, StyleRange[] newStyles) {
			int[] _newRanges = newRanges;
			StyleRange[] _newStyles = newStyles;
			if (_newStyles == null) {
				this.stylesSetCount = this.styleCount = 0;
				this.ranges = null;
				this.styles = null;
				this.stylesSet = null;
				this.hasLinks = false;
				return;
			}
			if (_newRanges == null && COMPACT_STYLES) {
				_newRanges = new int[_newStyles.length << 1];
				StyleRange[] tmpStyles = new StyleRange[_newStyles.length];
				if (this.stylesSet == null)
					this.stylesSet = new StyleRange[4];
				for (int i = 0, j = 0; i < _newStyles.length; i++) {
					StyleRange newStyle = _newStyles[i];
					_newRanges[j++] = newStyle.start;
					_newRanges[j++] = newStyle.length;
					int index = 0;
					while (index < this.stylesSetCount) {
						if (this.stylesSet[index].similarTo(newStyle))
							break;
						index++;
					}
					if (index == this.stylesSetCount) {
						if (this.stylesSetCount == this.stylesSet.length) {
							StyleRange[] tmpStylesSet = new StyleRange[this.stylesSetCount + 4];
							System.arraycopy(this.stylesSet, 0, tmpStylesSet, 0, this.stylesSetCount);
							this.stylesSet = tmpStylesSet;
						}
						this.stylesSet[this.stylesSetCount++] = newStyle;
					}
					tmpStyles[i] = this.stylesSet[index];
				}
				_newStyles = tmpStyles;
			}

			if (this.styleCount == 0) {
				if (_newRanges != null) {
					this.ranges = new int[_newRanges.length];
					System.arraycopy(_newRanges, 0, this.ranges, 0, this.ranges.length);
				}
				this.styles = new StyleRange[_newStyles.length];
				System.arraycopy(_newStyles, 0, this.styles, 0, this.styles.length);
				this.styleCount = _newStyles.length;
				return;
			}
			if (_newRanges != null && this.ranges == null) {
				this.ranges = new int[this.styles.length << 1];
				for (int i = 0, j = 0; i < this.styleCount; i++) {
					this.ranges[j++] = this.styles[i].start;
					this.ranges[j++] = this.styles[i].length;
				}
			}
			if (_newRanges == null && this.ranges != null) {
				_newRanges = new int[_newStyles.length << 1];
				for (int i = 0, j = 0; i < _newStyles.length; i++) {
					_newRanges[j++] = _newStyles[i].start;
					_newRanges[j++] = _newStyles[i].length;
				}
			}
			if (this.ranges != null && _newRanges != null) {
				int rangeCount = this.styleCount << 1;
				int start = _newRanges[0];
				int modifyStart = getRangeIndex(start, -1, rangeCount), modifyEnd;
				boolean insert = modifyStart == rangeCount;
				if (!insert) {
					int end = _newRanges[_newRanges.length - 2] + _newRanges[_newRanges.length - 1];
					modifyEnd = getRangeIndex(end, modifyStart - 1, rangeCount);
					insert = modifyStart == modifyEnd && this.ranges[modifyStart] >= end;
				}
				if (insert) {
					addMerge(_newRanges, _newStyles, _newRanges.length, modifyStart, modifyStart);
					return;
				}
				modifyEnd = modifyStart;
				int[] mergeRanges = new int[6];
				StyleRange[] mergeStyles = new StyleRange[3];
				for (int i = 0; i < _newRanges.length; i += 2) {
					int newStart = _newRanges[i];
					int newEnd = newStart + _newRanges[i + 1];
					if (newStart == newEnd)
						continue;
					int modifyLast = 0, mergeCount = 0;
					while (modifyEnd < rangeCount) {
						if (newStart >= this.ranges[modifyStart] + this.ranges[modifyStart + 1])
							modifyStart += 2;
						if (this.ranges[modifyEnd] + this.ranges[modifyEnd + 1] > newEnd)
							break;
						modifyEnd += 2;
					}
					if (this.ranges[modifyStart] < newStart && newStart < this.ranges[modifyStart] + this.ranges[modifyStart + 1]) {
						mergeStyles[mergeCount >> 1] = this.styles[modifyStart >> 1];
						mergeRanges[mergeCount] = this.ranges[modifyStart];
						mergeRanges[mergeCount + 1] = newStart - this.ranges[modifyStart];
						mergeCount += 2;
					}
					mergeStyles[mergeCount >> 1] = _newStyles[i >> 1];
					mergeRanges[mergeCount] = newStart;
					mergeRanges[mergeCount + 1] = _newRanges[i + 1];
					mergeCount += 2;
					if (modifyEnd < rangeCount && this.ranges[modifyEnd] < newEnd && newEnd < this.ranges[modifyEnd] + this.ranges[modifyEnd + 1]) {
						mergeStyles[mergeCount >> 1] = this.styles[modifyEnd >> 1];
						mergeRanges[mergeCount] = newEnd;
						mergeRanges[mergeCount + 1] = this.ranges[modifyEnd] + this.ranges[modifyEnd + 1] - newEnd;
						mergeCount += 2;
						modifyLast = 2;
					}
					int grow = addMerge(mergeRanges, mergeStyles, mergeCount, modifyStart, modifyEnd + modifyLast);
					rangeCount += grow;
					modifyStart = modifyEnd += grow;
				}
			} else {
				int start = _newStyles[0].start;
				int modifyStart = getRangeIndex(start, -1, this.styleCount), modifyEnd;
				boolean insert = modifyStart == this.styleCount;
				if (!insert) {
					int end = _newStyles[_newStyles.length - 1].start + _newStyles[_newStyles.length - 1].length;
					modifyEnd = getRangeIndex(end, modifyStart - 1, this.styleCount);
					insert = modifyStart == modifyEnd && this.styles[modifyStart].start >= end;
				}
				if (insert) {
					addMerge(_newStyles, _newStyles.length, modifyStart, modifyStart);
					return;
				}
				modifyEnd = modifyStart;
				StyleRange[] mergeStyles = new StyleRange[3];
				for (int i = 0; i < _newStyles.length; i++) {
					StyleRange newStyle = _newStyles[i], style;
					int newStart = newStyle.start;
					int newEnd = newStart + newStyle.length;
					if (newStart == newEnd)
						continue;
					int modifyLast = 0, mergeCount = 0;
					while (modifyEnd < this.styleCount) {
						if (newStart >= this.styles[modifyStart].start + this.styles[modifyStart].length)
							modifyStart++;
						if (this.styles[modifyEnd].start + this.styles[modifyEnd].length > newEnd)
							break;
						modifyEnd++;
					}
					style = this.styles[modifyStart];
					if (style.start < newStart && newStart < style.start + style.length) {
						style = mergeStyles[mergeCount++] = (StyleRange) style.clone();
						style.length = newStart - style.start;
					}
					mergeStyles[mergeCount++] = newStyle;
					if (modifyEnd < this.styleCount) {
						style = this.styles[modifyEnd];
						if (style.start < newEnd && newEnd < style.start + style.length) {
							style = mergeStyles[mergeCount++] = (StyleRange) style.clone();
							style.length += style.start - newEnd;
							style.start = newEnd;
							modifyLast = 1;
						}
					}
					int grow = addMerge(mergeStyles, mergeCount, modifyStart, modifyEnd + modifyLast);
					modifyStart = modifyEnd += grow;
				}
			}

		}

		int[] getRanges(int start, int length) {
			if (length == 0)
				return null;
			int[] newRanges;
			int end = start + length - 1;
			if (this.ranges != null) {
				int rangeCount = this.styleCount << 1;
				int rangeStart = getRangeIndex(start, -1, rangeCount);
				if (rangeStart >= rangeCount)
					return null;
				if (this.ranges[rangeStart] > end)
					return null;
				int rangeEnd = Math.min(rangeCount - 2, getRangeIndex(end, rangeStart - 1, rangeCount));
				if (this.ranges[rangeEnd] > end)
					rangeEnd = Math.max(rangeStart, rangeEnd - 2);
				newRanges = new int[rangeEnd - rangeStart + 2];
				System.arraycopy(this.ranges, rangeStart, newRanges, 0, newRanges.length);
			} else {
				int rangeStart = getRangeIndex(start, -1, this.styleCount);
				if (rangeStart >= this.styleCount)
					return null;
				if (this.styles[rangeStart].start > end)
					return null;
				int rangeEnd = Math.min(this.styleCount - 1, getRangeIndex(end, rangeStart - 1, this.styleCount));
				if (this.styles[rangeEnd].start > end)
					rangeEnd = Math.max(rangeStart, rangeEnd - 1);
				newRanges = new int[(rangeEnd - rangeStart + 1) << 1];
				for (int i = rangeStart, j = 0; i <= rangeEnd; i++, j += 2) {
					StyleRange style = this.styles[i];
					newRanges[j] = style.start;
					newRanges[j + 1] = style.length;
				}
			}
			if (start > newRanges[0]) {
				newRanges[1] = newRanges[0] + newRanges[1] - start;
				newRanges[0] = start;
			}
			if (end < newRanges[newRanges.length - 2] + newRanges[newRanges.length - 1] - 1) {
				newRanges[newRanges.length - 1] = end - newRanges[newRanges.length - 2] + 1;
			}
			return newRanges;
		}

		int getRangeIndex(int offset, int low, int high) {
			int _low = low;
			int _high = high;
			if (this.styleCount == 0)
				return 0;
			if (this.ranges != null) {
				while (_high - _low > 2) {
					int index = ((_high + _low) / 2) / 2 * 2;
					int end = this.ranges[index] + this.ranges[index + 1];
					if (end > offset) {
						_high = index;
					} else {
						_low = index;
					}
				}
			} else {
				while (_high - _low > 1) {
					int index = ((_high + _low) / 2);
					int end = this.styles[index].start + this.styles[index].length;
					if (end > offset) {
						_high = index;
					} else {
						_low = index;
					}
				}
			}
			return _high;
		}

		void textChanging(TextChangingEvent event) {
			int start = event.offset;
			int newCharCount = event.newCharCount, replaceCharCount = event.replaceCharCount;
			@SuppressWarnings("unused")
			int newLineCount = event.newLineCount, replaceLineCount = event.replaceLineCount;

			updateRanges(start, replaceCharCount, newCharCount);
			//
			// int startLine = getContent().getLineAtOffset(start);
			// if (replaceCharCount == getContent().getCharCount()) lines =
			// null;
			// if (replaceLineCount == lineCount) {
			// lineCount = newLineCount;
			// lineWidth = new int[lineCount];
			// lineHeight = new int[lineCount];
			// reset(0, lineCount);
			// } else {
			// int delta = newLineCount - replaceLineCount;
			// if (lineCount + delta > lineWidth.length) {
			// int[] newWidths = new int[lineCount + delta + GROW];
			// System.arraycopy(lineWidth, 0, newWidths, 0, lineCount);
			// lineWidth = newWidths;
			// int[] newHeights = new int[lineCount + delta + GROW];
			// System.arraycopy(lineHeight, 0, newHeights, 0, lineCount);
			// lineHeight = newHeights;
			// }
			// if (lines != null) {
			// if (lineCount + delta > lines.length) {
			// LineInfo[] newLines = new LineInfo[lineCount + delta + GROW];
			// System.arraycopy(lines, 0, newLines, 0, lineCount);
			// lines = newLines;
			// }
			// }
			// int startIndex = startLine + replaceLineCount + 1;
			// int endIndex = startLine + newLineCount + 1;
			// System.arraycopy(lineWidth, startIndex, lineWidth, endIndex,
			// lineCount - startIndex);
			// System.arraycopy(lineHeight, startIndex, lineHeight, endIndex,
			// lineCount - startIndex);
			// for (int i = startLine; i < endIndex; i++) {
			// lineWidth[i] = lineHeight[i] = -1;
			// }
			// for (int i = lineCount + delta; i < lineCount; i++) {
			// lineWidth[i] = lineHeight[i] = -1;
			// }
			// if (layouts != null) {
			// int layoutStartLine = startLine - topIndex;
			// int layoutEndLine = layoutStartLine + replaceLineCount + 1;
			// for (int i = layoutStartLine; i < layoutEndLine; i++) {
			// if (0 <= i && i < layouts.length) {
			// if (layouts[i] != null) layouts[i].dispose();
			// layouts[i] = null;
			// if (bullets != null && bulletsIndices != null) bullets[i] = null;
			// }
			// }
			// if (delta > 0) {
			// for (int i = layouts.length - 1; i >= layoutEndLine; i--) {
			// if (0 <= i && i < layouts.length) {
			// endIndex = i + delta;
			// if (0 <= endIndex && endIndex < layouts.length) {
			// layouts[endIndex] = layouts[i];
			// layouts[i] = null;
			// if (bullets != null && bulletsIndices != null) {
			// bullets[endIndex] = bullets[i];
			// bulletsIndices[endIndex] = bulletsIndices[i];
			// bullets[i] = null;
			// }
			// } else {
			// if (layouts[i] != null) layouts[i].dispose();
			// layouts[i] = null;
			// if (bullets != null && bulletsIndices != null) bullets[i] = null;
			// }
			// }
			// }
			// } else if (delta < 0) {
			// for (int i = layoutEndLine; i < layouts.length; i++) {
			// if (0 <= i && i < layouts.length) {
			// endIndex = i + delta;
			// if (0 <= endIndex && endIndex < layouts.length) {
			// layouts[endIndex] = layouts[i];
			// layouts[i] = null;
			// if (bullets != null && bulletsIndices != null) {
			// bullets[endIndex] = bullets[i];
			// bulletsIndices[endIndex] = bulletsIndices[i];
			// bullets[i] = null;
			// }
			// } else {
			// if (layouts[i] != null) layouts[i].dispose();
			// layouts[i] = null;
			// if (bullets != null && bulletsIndices != null) bullets[i] = null;
			// }
			// }
			// }
			// }
			// }
			// if (replaceLineCount != 0 || newLineCount != 0) {
			// int startLineOffset = getContent().getOffsetAtLine(startLine);
			// if (startLineOffset != start) startLine++;
			// updateBullets(startLine, replaceLineCount, newLineCount, true);
			// if (lines != null) {
			// startIndex = startLine + replaceLineCount;
			// endIndex = startLine + newLineCount;
			// System.arraycopy(lines, startIndex, lines, endIndex, lineCount -
			// startIndex);
			// for (int i = startLine; i < endIndex; i++) {
			// lines[i] = null;
			// }
			// for (int i = lineCount + delta; i < lineCount; i++) {
			// lines[i] = null;
			// }
			// }
			// }
			// lineCount += delta;
			// if (maxWidthLineIndex != -1 && startLine <= maxWidthLineIndex &&
			// maxWidthLineIndex <= startLine + replaceLineCount) {
			// maxWidth = 0;
			// maxWidthLineIndex = -1;
			// for (int i = 0; i < lineCount; i++) {
			// if (lineWidth[i] > maxWidth) {
			// maxWidth = lineWidth[i];
			// maxWidthLineIndex = i;
			// }
			// }
			// }
			// }
		}

		int addMerge(int[] mergeRanges, StyleRange[] mergeStyles, int mergeCount, int modifyStart, int modifyEnd) {
			int _mergeCount = mergeCount;
			int _modifyEnd = modifyEnd;
			int rangeCount = this.styleCount << 1;
			StyleRange endStyle = null;
			int endStart = 0, endLength = 0;
			if (_modifyEnd < rangeCount) {
				endStyle = this.styles[_modifyEnd >> 1];
				endStart = this.ranges[_modifyEnd];
				endLength = this.ranges[_modifyEnd + 1];
			}
			int grow = _mergeCount - (_modifyEnd - modifyStart);
			if (rangeCount + grow >= this.ranges.length) {
				int[] tmpRanges = new int[this.ranges.length + grow + (GROW << 1)];
				System.arraycopy(this.ranges, 0, tmpRanges, 0, modifyStart);
				StyleRange[] tmpStyles = new StyleRange[this.styles.length + (grow >> 1) + GROW];
				System.arraycopy(this.styles, 0, tmpStyles, 0, modifyStart >> 1);
				if (rangeCount > _modifyEnd) {
					System.arraycopy(this.ranges, _modifyEnd, tmpRanges, modifyStart + _mergeCount, rangeCount - _modifyEnd);
					System.arraycopy(this.styles, _modifyEnd >> 1, tmpStyles, (modifyStart + _mergeCount) >> 1, this.styleCount - (_modifyEnd >> 1));
				}
				this.ranges = tmpRanges;
				this.styles = tmpStyles;
			} else {
				if (rangeCount > _modifyEnd) {
					System.arraycopy(this.ranges, _modifyEnd, this.ranges, modifyStart + _mergeCount, rangeCount - _modifyEnd);
					System.arraycopy(this.styles, _modifyEnd >> 1, this.styles, (modifyStart + _mergeCount) >> 1, this.styleCount - (_modifyEnd >> 1));
				}
			}
			if (MERGE_STYLES) {
				int j = modifyStart;
				for (int i = 0; i < _mergeCount; i += 2) {
					if (j > 0 && this.ranges[j - 2] + this.ranges[j - 1] == mergeRanges[i] && mergeStyles[i >> 1].similarTo(this.styles[(j - 2) >> 1])) {
						this.ranges[j - 1] += mergeRanges[i + 1];
					} else {
						this.styles[j >> 1] = mergeStyles[i >> 1];
						this.ranges[j++] = mergeRanges[i];
						this.ranges[j++] = mergeRanges[i + 1];
					}
				}
				if (endStyle != null && this.ranges[j - 2] + this.ranges[j - 1] == endStart && endStyle.similarTo(this.styles[(j - 2) >> 1])) {
					this.ranges[j - 1] += endLength;
					_modifyEnd += 2;
					_mergeCount += 2;
				}
				if (rangeCount > _modifyEnd) {
					System.arraycopy(this.ranges, modifyStart + _mergeCount, this.ranges, j, rangeCount - _modifyEnd);
					System.arraycopy(this.styles, (modifyStart + _mergeCount) >> 1, this.styles, j >> 1, this.styleCount - (_modifyEnd >> 1));
				}
				grow = (j - modifyStart) - (_modifyEnd - modifyStart);
			} else {
				System.arraycopy(mergeRanges, 0, this.ranges, modifyStart, _mergeCount);
				System.arraycopy(mergeStyles, 0, this.styles, modifyStart >> 1, _mergeCount >> 1);
			}
			this.styleCount += grow >> 1;
			return grow;
		}

		int addMerge(StyleRange[] mergeStyles, int mergeCount, int modifyStart, int modifyEnd) {
			int _mergeCount = mergeCount;
			int _modifyEnd = modifyEnd;
			int grow = _mergeCount - (_modifyEnd - modifyStart);
			StyleRange endStyle = null;
			if (_modifyEnd < this.styleCount)
				endStyle = this.styles[_modifyEnd];
			if (this.styleCount + grow >= this.styles.length) {
				StyleRange[] tmpStyles = new StyleRange[this.styles.length + grow + GROW];
				System.arraycopy(this.styles, 0, tmpStyles, 0, modifyStart);
				if (this.styleCount > _modifyEnd) {
					System.arraycopy(this.styles, _modifyEnd, tmpStyles, modifyStart + _mergeCount, this.styleCount - _modifyEnd);
				}
				this.styles = tmpStyles;
			} else {
				if (this.styleCount > _modifyEnd) {
					System.arraycopy(this.styles, _modifyEnd, this.styles, modifyStart + _mergeCount, this.styleCount - _modifyEnd);
				}
			}
			if (MERGE_STYLES) {
				int j = modifyStart;
				for (int i = 0; i < _mergeCount; i++) {
					StyleRange newStyle = mergeStyles[i], style;
					if (j > 0 && (style = this.styles[j - 1]).start + style.length == newStyle.start && newStyle.similarTo(style)) {
						style.length += newStyle.length;
					} else {
						this.styles[j++] = newStyle;
					}
				}
				StyleRange style = this.styles[j - 1];
				if (endStyle != null && style.start + style.length == endStyle.start && endStyle.similarTo(style)) {
					style.length += endStyle.length;
					_modifyEnd++;
					_mergeCount++;
				}
				if (this.styleCount > _modifyEnd) {
					System.arraycopy(this.styles, modifyStart + _mergeCount, this.styles, j, this.styleCount - _modifyEnd);
				}
				grow = (j - modifyStart) - (_modifyEnd - modifyStart);
			} else {
				System.arraycopy(mergeStyles, 0, this.styles, modifyStart, _mergeCount);
			}
			this.styleCount += grow;
			return grow;
		}

		void updateRanges(int start, int replaceCharCount, int newCharCount) {
			if (this.styleCount == 0 || (replaceCharCount == 0 && newCharCount == 0))
				return;
			if (this.ranges != null) {
				int rangeCount = this.styleCount << 1;
				int modifyStart = getRangeIndex(start, -1, rangeCount);
				if (modifyStart == rangeCount)
					return;
				int end = start + replaceCharCount;
				int modifyEnd = getRangeIndex(end, modifyStart - 1, rangeCount);
				int offset = newCharCount - replaceCharCount;
				if (modifyStart == modifyEnd && this.ranges[modifyStart] < start && end < this.ranges[modifyEnd] + this.ranges[modifyEnd + 1]) {
					if (newCharCount == 0) {
						this.ranges[modifyStart + 1] -= replaceCharCount;
						modifyEnd += 2;
					} else {
						if (rangeCount + 2 > this.ranges.length) {
							int[] newRanges = new int[this.ranges.length + (GROW << 1)];
							System.arraycopy(this.ranges, 0, newRanges, 0, rangeCount);
							this.ranges = newRanges;
							StyleRange[] newStyles = new StyleRange[this.styles.length + GROW];
							System.arraycopy(this.styles, 0, newStyles, 0, this.styleCount);
							this.styles = newStyles;
						}
						System.arraycopy(this.ranges, modifyStart + 2, this.ranges, modifyStart + 4, rangeCount - (modifyStart + 2));
						System.arraycopy(this.styles, (modifyStart + 2) >> 1, this.styles, (modifyStart + 4) >> 1, this.styleCount - ((modifyStart + 2) >> 1));
						this.ranges[modifyStart + 3] = this.ranges[modifyStart] + this.ranges[modifyStart + 1] - end;
						this.ranges[modifyStart + 2] = start + newCharCount;
						this.ranges[modifyStart + 1] = start - this.ranges[modifyStart];
						this.styles[(modifyStart >> 1) + 1] = this.styles[modifyStart >> 1];
						rangeCount += 2;
						this.styleCount++;
						modifyEnd += 4;
					}
					if (offset != 0) {
						for (int i = modifyEnd; i < rangeCount; i += 2) {
							this.ranges[i] += offset;
						}
					}
				} else {
					if (this.ranges[modifyStart] < start && start < this.ranges[modifyStart] + this.ranges[modifyStart + 1]) {
						this.ranges[modifyStart + 1] = start - this.ranges[modifyStart];
						modifyStart += 2;
					}
					if (modifyEnd < rangeCount && this.ranges[modifyEnd] < end && end < this.ranges[modifyEnd] + this.ranges[modifyEnd + 1]) {
						this.ranges[modifyEnd + 1] = this.ranges[modifyEnd] + this.ranges[modifyEnd + 1] - end;
						this.ranges[modifyEnd] = end;
					}
					if (offset != 0) {
						for (int i = modifyEnd; i < rangeCount; i += 2) {
							this.ranges[i] += offset;
						}
					}
					System.arraycopy(this.ranges, modifyEnd, this.ranges, modifyStart, rangeCount - modifyEnd);
					System.arraycopy(this.styles, modifyEnd >> 1, this.styles, modifyStart >> 1, this.styleCount - (modifyEnd >> 1));
					this.styleCount -= (modifyEnd - modifyStart) >> 1;
				}
			} else {
				int modifyStart = getRangeIndex(start, -1, this.styleCount);
				if (modifyStart == this.styleCount)
					return;
				int end = start + replaceCharCount;
				int modifyEnd = getRangeIndex(end, modifyStart - 1, this.styleCount);
				int offset = newCharCount - replaceCharCount;
				if (modifyStart == modifyEnd && this.styles[modifyStart].start < start && end < this.styles[modifyEnd].start + this.styles[modifyEnd].length) {
					if (newCharCount == 0) {
						this.styles[modifyStart].length -= replaceCharCount;
						modifyEnd++;
					} else {
						if (this.styleCount + 1 > this.styles.length) {
							StyleRange[] newStyles = new StyleRange[this.styles.length + GROW];
							System.arraycopy(this.styles, 0, newStyles, 0, this.styleCount);
							this.styles = newStyles;
						}
						System.arraycopy(this.styles, modifyStart + 1, this.styles, modifyStart + 2, this.styleCount - (modifyStart + 1));
						this.styles[modifyStart + 1] = (StyleRange) this.styles[modifyStart].clone();
						this.styles[modifyStart + 1].length = this.styles[modifyStart].start + this.styles[modifyStart].length - end;
						this.styles[modifyStart + 1].start = start + newCharCount;
						this.styles[modifyStart].length = start - this.styles[modifyStart].start;
						this.styleCount++;
						modifyEnd += 2;
					}
					if (offset != 0) {
						for (int i = modifyEnd; i < this.styleCount; i++) {
							this.styles[i].start += offset;
						}
					}
				} else {
					if (this.styles[modifyStart].start < start && start < this.styles[modifyStart].start + this.styles[modifyStart].length) {
						this.styles[modifyStart].length = start - this.styles[modifyStart].start;
						modifyStart++;
					}
					if (modifyEnd < this.styleCount && this.styles[modifyEnd].start < end && end < this.styles[modifyEnd].start + this.styles[modifyEnd].length) {
						this.styles[modifyEnd].length = this.styles[modifyEnd].start + this.styles[modifyEnd].length - end;
						this.styles[modifyEnd].start = end;
					}
					if (offset != 0) {
						for (int i = modifyEnd; i < this.styleCount; i++) {
							this.styles[i].start += offset;
						}
					}
					System.arraycopy(this.styles, modifyEnd, this.styles, modifyStart, this.styleCount - modifyEnd);
					this.styleCount -= modifyEnd - modifyStart;
				}
			}
		}

		StyleRange[] getStyleRanges(int start, int length, boolean includeRanges) {
			if (length == 0)
				return null;
			StyleRange[] newStyles;
			int end = start + length - 1;
			if (this.ranges != null) {
				int rangeCount = this.styleCount << 1;
				int rangeStart = getRangeIndex(start, -1, rangeCount);
				if (rangeStart >= rangeCount)
					return null;
				if (this.ranges[rangeStart] > end)
					return null;
				int rangeEnd = Math.min(rangeCount - 2, getRangeIndex(end, rangeStart - 1, rangeCount));
				if (this.ranges[rangeEnd] > end)
					rangeEnd = Math.max(rangeStart, rangeEnd - 2);
				newStyles = new StyleRange[((rangeEnd - rangeStart) >> 1) + 1];
				if (includeRanges) {
					for (int i = rangeStart, j = 0; i <= rangeEnd; i += 2, j++) {
						newStyles[j] = (StyleRange) this.styles[i >> 1].clone();
						newStyles[j].start = this.ranges[i];
						newStyles[j].length = this.ranges[i + 1];
					}
				} else {
					System.arraycopy(this.styles, rangeStart >> 1, newStyles, 0, newStyles.length);
				}
			} else {
				int rangeStart = getRangeIndex(start, -1, this.styleCount);
				if (rangeStart >= this.styleCount)
					return null;
				if (this.styles[rangeStart].start > end)
					return null;
				int rangeEnd = Math.min(this.styleCount - 1, getRangeIndex(end, rangeStart - 1, this.styleCount));
				if (this.styles[rangeEnd].start > end)
					rangeEnd = Math.max(rangeStart, rangeEnd - 1);
				newStyles = new StyleRange[rangeEnd - rangeStart + 1];
				System.arraycopy(this.styles, rangeStart, newStyles, 0, newStyles.length);
			}
			if (includeRanges || this.ranges == null) {
				StyleRange style = newStyles[0];
				if (start > style.start) {
					newStyles[0] = style = (StyleRange) style.clone();
					style.length = style.start + style.length - start;
					style.start = start;
				}
				style = newStyles[newStyles.length - 1];
				if (end < style.start + style.length - 1) {
					newStyles[newStyles.length - 1] = style = (StyleRange) style.clone();
					style.length = end - style.start + 1;
				}
			}
			return newStyles;
		}
	}

	// public void setTabs(int tabWidth) {
	// // keep empty
	// }
	//
	// public void setRedraw(boolean b) {
	// // keep empty
	// }

	/**
	 * @return the current selection
	 */
	public @NonNull TextSelection getSelection() {
		TextSelection textSelection = this.currentSelection.get();
		if (textSelection == null) {
			textSelection = new TextSelection(getCaretOffset(), 0);
		}
		return textSelection;
	}

	/**
	 * @return the selection property
	 */
	public @NonNull ObjectProperty<TextSelection> selectionProperty() {
		return this.currentSelection;
	}

	/**
	 * Set the current selection
	 *
	 * @param selection
	 *            the selection
	 */
	public void setSelection(@NonNull TextSelection selection) {
		if (selection.length == 0) {
			setCaretOffset(selection.offset);
		} else {
			// this.caretOffsetProperty.set(selection.offset+selection.length);
			this.currentSelection.set(selection);
		}
	}

	/**
	 * Clear the current selection
	 */
	public void clearSelection() {
		this.currentSelection.set(null);
	}

	/**
	 * Set the selection
	 *
	 * @param offset
	 *            the offset
	 * @param length
	 *            the length
	 */
	public void setSelectionRange(int offset, int length) {
		setSelection(new TextSelection(offset, length));
	}

	@NonNull
	private final BooleanProperty editableProperty = new SimpleBooleanProperty(this, "editableProperty", true); //$NON-NLS-1$

	/**
	 * Mark the editor editable
	 *
	 * <p>
	 * Default is <code>true</code>
	 * </p>
	 *
	 * @param editable
	 *            the new value
	 */
	public void setEditable(boolean editable) {
		editableProperty().set(editable);
	}

	/**
	 * Check if editable
	 * <p>
	 * Default is <code>true</code>
	 * </p>
	 *
	 * @return the current value
	 */
	public boolean getEditable() {
		return editableProperty().get();
	}

	/**
	 * The editable property
	 * <p>
	 * Default is <code>true</code>
	 * </p>
	 *
	 * @return the property
	 */
	public @NonNull BooleanProperty editableProperty() {
		return this.editableProperty;
	}

	public static enum LineLocation {
		BELOW, ABOVE, CENTER
	}

	/**
	 * Check the location at the given offset
	 *
	 * @param offset
	 *            the offset
	 * @param locationHint
	 *            hint for y coordinate relative to line
	 * @return the point
	 */
	public @Nullable Point2D getLocationAtOffset(int offset, LineLocation locationHint) {
		if (offset < 0 || offset > getCharCount()) {
			throw new IllegalArgumentException();
		}
		return ((StyledTextSkin) getSkin()).getCaretLocation(offset, locationHint);
	}

	/**
	 * Get the line height
	 *
	 * @param offset
	 *            the offset
	 * @return the height
	 */
	public double getLineHeight(int offset) {
		if (offset < 0 || offset > getCharCount()) {
			throw new IllegalArgumentException();
		}
		return ((StyledTextSkin) getSkin()).getLineHeight(offset);
	}

	// public void showSelection() {
	// // TODO Auto-generated method stub
	//
	// }

	/**
	 * Get the line index for the caret
	 *
	 * @param caretOffset
	 *            the caret offset
	 * @return the line index
	 */
	public int getLineAtOffset(int caretOffset) {
		return getContent().getLineAtOffset(caretOffset);
	}

	/**
	 * Get the initial offset of the line
	 *
	 * @param lineNumber
	 *            the line number
	 * @return the offset
	 */
	public int getOffsetAtLine(int lineNumber) {
		return getContent().getOffsetAtLine(lineNumber);
	}

	/**
	 * Get the text for the given range
	 *
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 * @return the text
	 */
	public @NonNull String getText(int start, int end) {
		return getContent().getTextRange(start, end - start + 1);
	}

	/**
	 * @return <code>true</code> if the selection has a length of 0
	 */
	public boolean isSelectionEmpty() {
		return getSelection().length == 0;
	}

	/**
	 * inserts text at the caret location or replaces a given selection
	 *
	 * @param text
	 */
	@SuppressWarnings("null")
	public void insert(CharSequence text) {
		if (text == null)
			throw new NullPointerException();

		int start, replaceLength;
		if (!isSelectionEmpty()) {
			// replace selection
			start = this.getSelection().offset;
			replaceLength = this.getSelection().length;
		} else {
			// insert at caret
			start = this.getCaretOffset();
			replaceLength = 0;
		}

		String content = text.toString();
		if( isInsertSpacesForTab() ) {
			content = content.replaceAll("\t", TextUtil.createRepeatedString(' ', this.tabAdvance.get())); //$NON-NLS-1$
		}

		this.getContent().replaceTextRange(start, replaceLength, content);
		this.setCaretOffset(start + content.length());
	}

	private IntegerProperty lineCount = new SimpleIntegerProperty(this, "lineCount", 0); //$NON-NLS-1$

	/**
	 * @return current number of line
	 */
	public ReadOnlyIntegerProperty lineCountProperty() {
		return this.lineCount;
	}

	/**
	 * @return current number of line
	 */
	public int getLineCount() {
		return this.lineCount.get();
	}

	/**
	 * Paste the clipboard content
	 */
	public void paste() {
		final Clipboard clipboard = Clipboard.getSystemClipboard();
		if (clipboard.hasString()) {
			final String text = fix0TerminatedString(clipboard.getString());
			if (text != null) {
				insert(text);
			}
		}
	}

	private static String fix0TerminatedString(String text) {
		String result = text;
		int nullIdx = text.indexOf(0);
		if(nullIdx > 0) {
			result = text.substring(0, nullIdx);
		}
		return result;
	}

	/**
	 * Copy the current selection into the clipboard
	 */
	@SuppressWarnings("null")
	public void copy() {
		if (getSelection().length > 0) {
			final Clipboard clipboard = Clipboard.getSystemClipboard();
			clipboard.setContent(Collections.singletonMap(DataFormat.PLAIN_TEXT, getContent().getTextRange(getSelection().offset, getSelection().length)));
		}
	}

	/**
	 * Cut the current selection into the clipboard
	 */
	public void cut() {
		TextSelection selection = getSelection();
		if (selection.length > 0) {
			final Clipboard clipboard = Clipboard.getSystemClipboard();
			String content = getContent().getTextRange(selection.offset, selection.length);
			setCaretOffset(selection.offset);
			getContent().replaceTextRange(selection.offset, content.length(), ""); //$NON-NLS-1$
			clipboard.setContent(Collections.singletonMap(DataFormat.PLAIN_TEXT, content));
		}
	}

	/**
	 * Get the char offset at the give coordinates
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @return the offset
	 */
	public int getOffsetAtPosition(double x, double y) {
		int result = ((StyledTextSkin) getSkin()).getOffsetAtPosition(x, y);
		return result;
	}

	private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

	static {
		final List<CssMetaData<? extends Styleable, ?>> styleables = new ArrayList<CssMetaData<? extends Styleable, ?>>(Control.getClassCssMetaData());
		styleables.add(FIXED_LINE_HEIGHT);
		styleables.add(FONT);
		STYLEABLES = Collections.unmodifiableList(styleables);
	}

	public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
		return STYLEABLES;
	}

	@Override
	public List<CssMetaData<? extends Styleable, ?>> getControlCssMetaData() {
		return getClassCssMetaData();
	}

	/**
	 * navigates to specified line
	 *
	 * @param lineIndex
	 */
	public void navigateToLine(int lineIndex) {
		if (lineIndex >= 0 && lineIndex <= getContent().getLineCount()) {
			int offset = getContent().getOffsetAtLine(lineIndex);
			setCaretOffset(offset);
		}
	}

	/**
	 * Set the number of chars a tab advances in the document. Default is 4.
	 *
	 * @param advance
	 *            the number of chars
	 * @since 2.4.0
	 */
	public void setTabAdvance(int advance) {
		tabAvanceProperty().set(advance);
	}

	/**
	 * @return The number of chars a tab advances in the document. Default is 4.
	 * @since 2.4.0
	 */
	public int getTabAdvance() {
		return tabAvanceProperty().get();
	}

	/**
	 * @return The number of chars a tab advances in the document. Default is 4.
	 * @since 2.4.0
	 */
	public @NonNull IntegerProperty tabAvanceProperty() {
		return this.tabAdvance;
	}

	/**
	 * When inserting a tab it is replaced with the number of spaces defined in
	 * {@link #tabAvanceProperty()}
	 * <p>
	 * <b>Already existing tabs in the content are not replaced</b>
	 * </p>
	 *
	 * @param insertSpacesForTab
	 *            <code>true</code> to turn on the replacement
	 * @since 2.4.0
	 */
	public void setInsertSpacesForTab(boolean insertSpacesForTab) {
		this.insertSpacesForTab.set(insertSpacesForTab);
	}

	/**
	 * When inserting a tab it is replaced with the number of spaces defined in
	 * {@link #tabAvanceProperty()}
	 * <p>
	 * <b>Already existing tabs in the content are not replaced</b>
	 * </p>
	 *
	 * @return <code>true</code> if replacement is turned on
	 * @since 2.4.0
	 */
	public boolean isInsertSpacesForTab() {
		return this.insertSpacesForTab.get();
	}

	/**
	 * When inserting a tab it is replaced with the number of spaces defined in
	 * {@link #tabAvanceProperty()}
	 * <p>
	 * <b>Already existing tabs in the content are not replaced</b>
	 * </p>
	 *
	 * @return property to observe
	 * @since 2.4.0
	 */
	public @NonNull BooleanProperty insertSpacesForTabProperty() {
		return this.insertSpacesForTab;
	}

	/**
	 * Reveal the current caret location
	 * @since 2.4.0
	 */
	public void revealCaret() {
		if (getSkin() != null) {
			((StyledTextSkin)getSkin()).scrollOffsetIntoView(getCaretOffset(), 2, 2);
		}
	}

	/**
	 * Trigger the respective action
	 * @param action the action
	 */
	public void triggerAction(TextEditAction action) {
		((StyledTextSkin)getSkin()).getBehavior().triggerAction(action);
	}
}

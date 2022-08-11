/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation, BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	   IBM Corporation - initial API
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.custom;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.Region;

import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.fx.ui.controls.styledtext.TextChangedEvent;
import org.eclipse.fx.ui.controls.styledtext.TextStyle;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.Util;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Composite;

public class StyledText extends Canvas {
	private StyledTextArea nativeObject;
	private StyledTextContent content;
	
	public StyledText(Composite parent, int style) {
		super(parent, style);
	}
	
	protected javafx.scene.canvas.Canvas internal_initCanvas() {
		return null;
	}
	
	@Override
	protected Region createWidget() {
		nativeObject = new StyledTextArea();
		setContent(new DefaultContent());
		return nativeObject;
	}
	
	@Override
	protected void initListeners() {
		super.initListeners();
	}
	
	@Override
	public Region internal_getNativeObject() {
		return nativeObject;
	}


	private static org.eclipse.fx.ui.controls.styledtext.StyleRange[] toFXRanges(StyleRange[] styles) {
		org.eclipse.fx.ui.controls.styledtext.StyleRange[] rv = new org.eclipse.fx.ui.controls.styledtext.StyleRange[styles.length];
		for( int i = 0; i < rv.length; i++ ) {
			rv[i] = toFXRange(styles[i]);
		}
		return rv;	
	}

	private static org.eclipse.fx.ui.controls.styledtext.StyleRange toFXRange(StyleRange swtRange) {
		TextStyle fxTextStyle = new TextStyle("swtRange");
		fxTextStyle.background = swtRange.background != null ? swtRange.background.internal_getNativeObject() : null;
		fxTextStyle.borderColor = swtRange.borderColor != null ? swtRange.borderColor.internal_getNativeObject() : null;
		fxTextStyle.borderStyle = swtRange.borderStyle;
		fxTextStyle.data = swtRange.data;
		fxTextStyle.font = swtRange.font != null ? swtRange.font.internal_getNativeObject() : null;
		fxTextStyle.foreground = swtRange.foreground != null ? swtRange.foreground.internal_getNativeObject() : javafx.scene.paint.Color.BLACK;
		fxTextStyle.rise = swtRange.rise;
		fxTextStyle.strikeout = swtRange.strikeout;
		fxTextStyle.strikeoutColor = swtRange.strikeoutColor != null ? swtRange.strikeoutColor.internal_getNativeObject() : null;
		fxTextStyle.underline = swtRange.underline;
		fxTextStyle.underlineColor = swtRange.underlineColor != null ? swtRange.underlineColor.internal_getNativeObject() : null;
		fxTextStyle.underlineStyle = swtRange.underlineStyle;
		org.eclipse.fx.ui.controls.styledtext.StyleRange r = new org.eclipse.fx.ui.controls.styledtext.StyleRange(fxTextStyle);
		r.start = swtRange.start;
		r.length = swtRange.length;
		return r;
	}
	
	
	public void addExtendedModifyListener(ExtendedModifyListener extendedModifyListener) {
		Util.logNotImplemented();
	}
	
	public void addBidiSegmentListener(BidiSegmentListener listener) {
		Util.logNotImplemented();
	}
	
	public void addCaretListener(CaretListener listener) {
		Util.logNotImplemented();
	}
	
	public void addLineBackgroundListener(LineBackgroundListener listener) {
		Util.logNotImplemented();
	}
	
	public void addLineStyleListener(LineStyleListener listener) {
		Util.logNotImplemented();
	}
	
	public void addModifyListener(ModifyListener modifyListener) {
		Util.logNotImplemented();
	}
	
	public void addPaintObjectListener(PaintObjectListener listener) {
		Util.logNotImplemented();
	}
	
	public void addSelectionListener(SelectionListener listener) {
		Util.logNotImplemented();
	}
	
	public void addVerifyKeyListener(VerifyKeyListener listener) {
		Util.logNotImplemented();
	}
	
	public void addVerifyListener(VerifyListener verifyListener) {
		Util.logNotImplemented();
	}
	
	public void addWordMovementListener(MovementListener movementListener) {
		Util.logNotImplemented();
	}
	
	public void append(String string) {
		Util.logNotImplemented();
	}
	
	public void copy() {
		Util.logNotImplemented();
	}
	
	public void copy(int clipboardType) {
		Util.logNotImplemented();
	}
	
	public int getAlignment() {
		Util.logNotImplemented();
		return 0;
	}
	
	public boolean getAlwaysShowScrollBars() {
		Util.logNotImplemented();
		return false;
	}
	
	public Color getMarginColor() {
		Util.logNotImplemented();
		return null;
	}
	
	public void cut() {
		Util.logNotImplemented();
	}
	
	public int getBaseline() {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getBaseline(int offset) {
		Util.logNotImplemented();
		return 0;
	}
	
	public boolean getBidiColoring() {
		Util.logNotImplemented();
		return false;
	}
	
	public boolean getBlockSelection() {
		Util.logNotImplemented();
		return false;
	}
	
	public Rectangle getBlockSelectionBounds() {
		Util.logNotImplemented();
		return new Rectangle(0, 0, 0, 0);
	}
	
	public int getBottomMargin() {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getCaretOffset() {
		Util.logNotImplemented();
		return 0;
	}
	
	public StyledTextContent getContent() {
		return content;
	}
	
	public boolean getDragDetect () {
		Util.logNotImplemented();
		return false;
	}
	
	public boolean getDoubleClickEnabled() {
		Util.logNotImplemented();
		return false;
	}
	
	public boolean getEditable() {
		Util.logNotImplemented();
		return false;
	}
	
	public int getHorizontalIndex() {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getHorizontalPixel() {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getIndent() {
		Util.logNotImplemented();
		return 0;
	}
	
	public boolean getJustify() {
		Util.logNotImplemented();
		return false;
	}
	
	public int getKeyBinding(int key) {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getCharCount() {
		Util.logNotImplemented();
		return 0;
	}
	
	public String getLine(int lineIndex) {
		Util.logNotImplemented();
		return null;
	}
	
	public int getLineAlignment(int index) {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getLineAtOffset(int offset) {
		Util.logNotImplemented();
		return 0;
	}
	
	public Color getLineBackground(int index) {
		Util.logNotImplemented();
		return null;
	}
	
	public Bullet getLineBullet(int index) {
		Util.logNotImplemented();
		return null;
	}
	
	public int getLineCount() {
		Util.logNotImplemented();
		return 0;
	}
	
	public String getLineDelimiter() {
		Util.logNotImplemented();
		return null;
	}
	
	public int getLineHeight() {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getLineHeight(int offset) {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getLineIndent(int index) {
		Util.logNotImplemented();
		return 0;
	}
	
	public boolean getLineJustify(int index) {
		Util.logNotImplemented();
		return false;
	}
	
	public int getLineSpacing() {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getLinePixel(int lineIndex) {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getLineIndex(int y) {
		Util.logNotImplemented();
		return 0;
	}
	
	public int[] getLineTabStops(int index) {
		Util.logNotImplemented();
		return new int[0];
	}
	
	public int getLineWrapIndent(int index) {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getLeftMargin() {
		Util.logNotImplemented();
		return 0;
	}
	
	public Point getLocationAtOffset(int offset) {
		Util.logNotImplemented();
		return new Point(0,0);
	}
	
	public int getOffsetAtLine(int lineIndex) {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getOffsetAtLocation(Point point) {
		Util.logNotImplemented();
		return 0;
	}
	
	public int[] getRanges() {
		Util.logNotImplemented();
		return new int[0];
	}
	
	public int[] getRanges(int start, int length) {
		Util.logNotImplemented();
		return new int[0];
	}
	
	public int getRightMargin() {
		Util.logNotImplemented();
		return 0;
	}
	
	public Point getSelection() {
		Util.logNotImplemented();
		return new Point(0,0);
	}
	
	public Point getSelectionRange() {
		Util.logNotImplemented();
		return new Point(0,0);
	}
	
	public int[] getSelectionRanges() {
		Util.logNotImplemented();
		return new int[0];
	}
	
	public Color getSelectionBackground() {
		Util.logNotImplemented();
		return null;
	}
	
	public int getSelectionCount() {
		Util.logNotImplemented();
		return 0;
	}
	
	public Color getSelectionForeground() {
		Util.logNotImplemented();
		return null;
	}
	
	public String getSelectionText() {
		Util.logNotImplemented();
		return null;
	}
	
	public StyleRange getStyleRangeAtOffset(int offset) {
		Util.logNotImplemented();
		return null;
	}
	
	public StyleRange[] getStyleRanges() {
		Util.logNotImplemented();
		return new StyleRange[0];
	}
	
	public StyleRange[] getStyleRanges(boolean includeRanges) {
		Util.logNotImplemented();
		return new StyleRange[0];
	}
	
	public StyleRange[] getStyleRanges(int start, int length) {
		Util.logNotImplemented();
		return new StyleRange[0];
	}
	
	public StyleRange[] getStyleRanges(int start, int length, boolean includeRanges) {
		Util.logNotImplemented();
		return new StyleRange[0];
	}
	
	public int getTabs() {
		Util.logNotImplemented();
		return 0;
	}
	
	public int[] getTabStops() {
		Util.logNotImplemented();
		return new int[0];
	}
	
	public String getText() {
		Util.logNotImplemented();
		return null;
	}
	
	public String getText(int start, int end) {
		Util.logNotImplemented();
		return null;
	}
	
	public Rectangle getTextBounds(int start, int end) {
		Util.logNotImplemented();
		return new Rectangle(0, 0, 0, 0);
	}
	
	public String getTextRange(int start, int length) {
		Util.logNotImplemented();
		return null;
	}
	
	public int getTextLimit() {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getTopIndex() {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getTopMargin() {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getTopPixel() {
		Util.logNotImplemented();
		return 0;
	}
	
	public boolean getWordWrap() {
		Util.logNotImplemented();
		return false;
	}
	
	public int getWrapIndent() {
		Util.logNotImplemented();
		return 0;
	}
	
	public void insert(String string) {
		Util.logNotImplemented();
	}
	
	public void invokeAction(int action) {
		Util.logNotImplemented();
	}
	
	public boolean isTextSelected() {
		Util.logNotImplemented();
		return false;
	}
	
	public void paste(){
		Util.logNotImplemented();
	}
	
	public void print() {
		Util.logNotImplemented();
	}
	
	public Runnable print(Printer printer) {
		Util.logNotImplemented();
		return new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
	public Runnable print(Printer printer, StyledTextPrintOptions options) {
		Util.logNotImplemented();
		return new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
	public void redrawRange(int start, int length, boolean clearBackground) {
		Util.logNotImplemented();
	}
	
	public void removeBidiSegmentListener(BidiSegmentListener listener) {
		Util.logNotImplemented();
	}
	
	public void removeCaretListener(CaretListener listener) {
		Util.logNotImplemented();
	}
	
	public void removeExtendedModifyListener(ExtendedModifyListener extendedModifyListener) {
		Util.logNotImplemented();
	}
	
	public void removeLineBackgroundListener(LineBackgroundListener listener) {
		Util.logNotImplemented();
	}
	
	public void removeLineStyleListener(LineStyleListener listener) {
		Util.logNotImplemented();
	}
	
	public void removeModifyListener(ModifyListener modifyListener) {
		Util.logNotImplemented();
	}
	
	public void removePaintObjectListener(PaintObjectListener listener) {
		Util.logNotImplemented();
	}
	
	public void removeSelectionListener(SelectionListener listener) {
		Util.logNotImplemented();
	}
	
	public void removeVerifyListener(VerifyListener verifyListener) {
		Util.logNotImplemented();
	}
	
	public void removeVerifyKeyListener(VerifyKeyListener listener) {
		Util.logNotImplemented();
	}
	
	public void removeWordMovementListener(MovementListener listener) {
		Util.logNotImplemented();
	}
	
	public void replaceStyleRanges(int start, int length, StyleRange[] ranges) {
		Util.logNotImplemented();
	}
	
	public void replaceTextRange(int start, int length, String text) {
		Util.logNotImplemented();
	}
	
	public void selectAll() {
		Util.logNotImplemented();
	}
	
	public void setAlignment(int alignment) {
		Util.logNotImplemented();
	}
	
	public void setAlwaysShowScrollBars(boolean show) {
		Util.logNotImplemented();
	}
	
	public void setBlockSelection(boolean blockSelection) {
		Util.logNotImplemented();
	}
	
	public void setBlockSelectionBounds(Rectangle rect) {
		Util.logNotImplemented();
	}
	
	public void setBlockSelectionBounds(int x, int y, int width, int height) {
		Util.logNotImplemented();
	}
	
	public void setBidiColoring(boolean mode) {
		Util.logNotImplemented();
	}
	
	public void setBottomMargin (int bottomMargin) {
		Util.logNotImplemented();
	}
	
	@Override
	public void setCaret(Caret caret) {
		// TODO Auto-generated method stub
//		super.setCaret(caret);
		Util.logNotImplemented();
	}
	
	public void setCaretOffset(int offset) {
		Util.logNotImplemented();
	}
	
	public void setContent(StyledTextContent newContent) {
		this.content = newContent;
		nativeObject.setContent(new WrappedStyledContent(newContent));
	}
	
	public void setDoubleClickEnabled(boolean enable) {
		Util.logNotImplemented();
	}
	
	public void setEditable(boolean editable) {
		Util.logNotImplemented();
	}
	
	public void setHorizontalIndex(int offset) {
		Util.logNotImplemented();
	}
	
	public void setHorizontalPixel(int pixel) {
		Util.logNotImplemented();
	}
	
	public void setIndent(int indent) {
		Util.logNotImplemented();
	}
	
	public void setJustify(boolean justify) {
		Util.logNotImplemented();
	}
	
	public void setKeyBinding(int key, int action) {
		Util.logNotImplemented();
	}
	
	public void setLeftMargin (int leftMargin) {
		Util.logNotImplemented();
	}
	
	public void setLineAlignment(int startLine, int lineCount, int alignment) {
		Util.logNotImplemented();
	}
	
	public void setLineBackground(int startLine, int lineCount, Color background) {
		Util.logNotImplemented();
	}
	
	public void setLineBullet(int startLine, int lineCount, Bullet bullet) {
		Util.logNotImplemented();
	}
	
	public void setLineIndent(int startLine, int lineCount, int indent) {
		Util.logNotImplemented();
	}
	
	public void setLineJustify(int startLine, int lineCount, boolean justify) {
		Util.logNotImplemented();
	}
	
	public void setLineSpacing(int lineSpacing) {
		Util.logNotImplemented();
	}
	
	public void setLineTabStops(int startLine, int lineCount, int[] tabStops) {
		Util.logNotImplemented();
	}
	
	public void setLineWrapIndent(int startLine, int lineCount, int wrapIndent) {
		Util.logNotImplemented();
	}
	
	public void setMarginColor(Color color) {
		Util.logNotImplemented();
	}
	
	public void setMargins (int leftMargin, int topMargin, int rightMargin, int bottomMargin) {
		Util.logNotImplemented();
	}
	
	public void setRightMargin (int rightMargin) {
		Util.logNotImplemented();
	}
	
	public void setSelection(int start) {
		Util.logNotImplemented();
	}
	
	public void setSelection(Point point) {
		Util.logNotImplemented();
	}
	
	public void setSelectionBackground (Color color) {
		Util.logNotImplemented();
	}
	
	public void setSelectionForeground (Color color) {
		Util.logNotImplemented();
	}
	
	public void setSelection(int start, int end) {
		Util.logNotImplemented();
	}
	
	public void setSelectionRange(int start, int length) {
		Util.logNotImplemented();
	}
	
	public void setStyleRange(StyleRange styleRange) {
		nativeObject.setStyleRange(toFXRange(styleRange));
	}

	public void setStyleRanges(int start, int length, int[] ranges, StyleRange[] styles) {
		nativeObject.setStyleRanges(start, length, ranges, toFXRanges(styles));
	}
	
	public void setStyleRanges(int[] ranges, StyleRange[] styles) {
		nativeObject.setStyleRanges(ranges, toFXRanges(styles));
	}
	
	public void setStyleRanges(StyleRange[] ranges) {
		nativeObject.setStyleRanges(toFXRanges(ranges));
	}
	
	public void setTabs(int tabs) {
		Util.logNotImplemented();
	}
	
	public void setTabStops(int [] tabs) {
		Util.logNotImplemented();
	}
	
	public void setText(String string) {
		content.setText(string);
	}
	
	public void setTextLimit(int limit) {
		Util.logNotImplemented();
	}
	
	public void setTopIndex(int topIndex) {
		Util.logNotImplemented();
	}
	
	public void setTopMargin (int topMargin) {
		Util.logNotImplemented();
	}
	
	public void setTopPixel(int pixel) {
		Util.logNotImplemented();
	}
	
	public void setWordWrap(boolean wrap) {
		Util.logNotImplemented();
	}
	
	public void setWrapIndent(int wrapIndent) {
		Util.logNotImplemented();
	}
	
	public void showSelection() {
		Util.logNotImplemented();
	}
	
	static class WrappedStyledContent implements org.eclipse.fx.ui.controls.styledtext.StyledTextContent {
		private StyledTextContent swtTextContent;
		private org.eclipse.swt.custom.TextChangeListener swtTextChangeListener;
		private List<TextChangeListener> changeListeners = new ArrayList<>();
		
		public WrappedStyledContent(StyledTextContent swtTextContent) {
			this.swtTextContent = swtTextContent;
			this.swtTextChangeListener = new org.eclipse.swt.custom.TextChangeListener() {
				
				@Override
				public void textSet(org.eclipse.swt.custom.TextChangedEvent event) {
					System.err.println("=====================> TEXT IS SET");
					if( ! changeListeners.isEmpty() ) {
						TextChangedEvent e = TextChangedEvent.textSet(WrappedStyledContent.this);
						for( TextChangeListener l : changeListeners ) {
							l.textSet(e);
						}
					}
				}
				
				@Override
				public void textChanging(org.eclipse.swt.custom.TextChangingEvent event) {
					System.err.println("=====================> TEXT IS CHANGING");
					if( ! changeListeners.isEmpty() ) {
						org.eclipse.fx.ui.controls.styledtext.TextChangingEvent e = org.eclipse.fx.ui.controls.styledtext.TextChangingEvent.textChanging(
								WrappedStyledContent.this, event.start, 
								event.replaceCharCount, 
								event.replaceLineCount, 
								event.newText, 
								event.newCharCount, 
								event.newLineCount);
						for( TextChangeListener l : changeListeners ) {
							l.textChanging(e);
						}
					}
				}
				
				@Override
				public void textChanged(org.eclipse.swt.custom.TextChangedEvent event) {
					System.err.println("=====================> TEXT IS CHANGED");
					if( ! changeListeners.isEmpty() ) {
						TextChangedEvent e = TextChangedEvent.textChanged(WrappedStyledContent.this);
						for( TextChangeListener l : changeListeners ) {
							l.textChanged(e);
						}
					}
					System.err.println("NEW TEXT: " + getTextRange(0, getCharCount()));
				}
			};
		}
		
		@Override
		public String getLine(int index) {
			return swtTextContent.getLine(index);
		}

		@Override
		public String getTextRange(int start, int length) {
			return swtTextContent.getTextRange(start, length);
		}

		@Override
		public void setText(String text) {
			swtTextContent.setText(text);
		}

		@Override
		public int getCharCount() {
			return swtTextContent.getCharCount();
		}

		@Override
		public int getLineCount() {
			return swtTextContent.getLineCount();
		}

		@Override
		public int getOffsetAtLine(int lineIndex) {
			return swtTextContent.getOffsetAtLine(lineIndex);
		}

		@Override
		public int getLineAtOffset(int charPosition) {
			return swtTextContent.getLineAtOffset(charPosition);
		}

		@Override
		public void replaceTextRange(int start, int replaceLength,
				String newText) {
			swtTextContent.replaceTextRange(start, replaceLength, newText);
		}

		@Override
		public void addTextChangeListener(TextChangeListener listener) {
			changeListeners.add(listener);
			if( changeListeners.size() == 1 ) {
				swtTextContent.addTextChangeListener(swtTextChangeListener);
			}
		}

		@Override
		public void removeTextChangeListener(TextChangeListener listener) {
			changeListeners.remove(listener);
			if( changeListeners.isEmpty() ) {
				swtTextContent.removeTextChangeListener(swtTextChangeListener);
			}
		}
	}
}

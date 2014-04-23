/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation, BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   IBM Corporation - initial API
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.graphics.textlayout;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.text.TextAlignment;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Resource;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.internal.Util;
import org.eclipse.swt.widgets.Display;

import com.sun.javafx.font.PrismFontLoader;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.RectBounds;
import com.sun.javafx.geom.Shape;
import com.sun.javafx.scene.text.GlyphList;
import com.sun.javafx.scene.text.TextLayout;
import com.sun.javafx.scene.text.TextLayoutFactory;
import com.sun.javafx.scene.text.TextLine;
import com.sun.javafx.scene.text.TextSpan;
import com.sun.javafx.tk.Toolkit;

@SuppressWarnings("restriction")
public class NativeTextLayout extends Resource implements InternalTextLayout {
	private com.sun.javafx.scene.text.TextLayout nativeLayout;
	private Font font;
	private String text;
	private StyleItem[] styles;
	private boolean justify;
	private int alignment = SWT.LEFT;
	
	private boolean dirty = true;
	private int width;
	private int spacing;
	private int orientation = SWT.LEFT_TO_RIGHT;
	private int[] segments;
	private char[] segmentsChars;
	private int wrapWidth;
	private int ascent;
	private int descent;
	private int wrapIndent;
	private int[] tabs;
	private int indent;
	static final char LTR_MARK = '\u200E', RTL_MARK = '\u200F';
	private TextSpanImpl[] spans;
	private int lineOffsets[];
	private StyleItem[][] lineStyles;
	
	static class StyleItem {
		TextStyle style;
		int start;
	}
	
	class TextSpanImpl implements TextSpan {
		private StyleItem i;
		private String text;
		
		public TextSpanImpl(StyleItem i, String text) {
			this.i = i;
			this.text = text;
		}
		
		@Override
		public String getText() {
			return text;
		}

		@Override
		public Object getFont() {
			return i.style != null ? i.style.font.internal_getNativeObject().impl_getNativeFont() : NativeTextLayout.this.getFont().internal_getNativeObject().impl_getNativeFont();
		}

		@Override
		public RectBounds getBounds() {
			return null;
		}
		
	}
	
	public NativeTextLayout(Device device) {
		super(device);
		TextLayoutFactory factory = Toolkit.getToolkit().getTextLayoutFactory();
		nativeLayout = factory.createLayout();
		
		wrapWidth = ascent = descent = -1;
		alignment = SWT.LEFT;
		orientation = SWT.LEFT_TO_RIGHT;
		styles = new StyleItem[2];
		styles[0] = new StyleItem();
		styles[1] = new StyleItem();
		text = ""; //$NON-NLS-1$
	}
	
	private void recalculateLayout() {
		if( dirty ) {
			StyleItem[] items = itemize();
			spans = new TextSpanImpl[items.length-1];
			List<List<StyleItem>> lineStylesList = new ArrayList<List<StyleItem>>();
			
			for (int i = 0; i < items.length-1; i++) {
				StyleItem run = styles[i];
				int endidx = items.length == i + 1 ? text.length()-run.start: items[i+1].start;
				String t = text.substring(run.start, endidx);
				if( run.style == null ) {
					spans[i] = new TextSpanImpl(run, t);
				} else {
					spans[i] = new TextSpanImpl(run, t);
				}
			}
			
			nativeLayout.setContent(spans);
			
			TextLine[] lines = nativeLayout.getLines();
			lineOffsets = new int[lines.length+1];
			
			for( int i = 0; i < lines.length; i++ ) {
				GlyphList[] runs = lines[i].getRuns();
				for( GlyphList r : runs ) {
					System.err.println(r.getTextSpan().getText());
				}
				lineOffsets[i] = runs[runs.length-1].getCharOffset(0);
			}
			lineOffsets[lineOffsets.length-1] = text.length();
			
			dirty = false;
		}
	}
	
	public void draw(GC gc, int x, int y) {
		for( TextSpanImpl i : spans ) {
			Shape shape = nativeLayout.getShape(TextLayout.TYPE_TEXT,i);
			if( i.i.style != null ) {
				gc.setBackground(i.i.style.foreground);
			}
			gc.internal_drawShape(x,y,shape);
			gc.setBackground(null);
		}
	}
	
	public void draw(GC gc, int x, int y, int selectionStart, int selectionEnd, Color selectionForeground, Color selectionBackground) {
		Util.logNotImplemented();
		gc.drawText(text, x, y, true);
	}
	
	public void draw(GC gc, int x, int y, int selectionStart, int selectionEnd, Color selectionForeground, Color selectionBackground, int flags) {
		Util.logNotImplemented();
		gc.drawText(text, x, y, true);
	}
	
	public int getAlignment() {
		return alignment;
	}
	
	public int getAscent () {
		return ascent;
	}
	
	public Rectangle getBounds() {
		recalculateLayout();
		BaseBounds bounds = nativeLayout.getBounds();
		return new Rectangle((int)bounds.getMinX(), (int)bounds.getMinY(), (int)bounds.getWidth(), (int)bounds.getHeight());
	}

	public int getDescent () {
		return descent;
	}
	
	public Font getFont () {
		return font != null ? font : getDevice().getSystemFont();
	}
	
	public int getIndent () {
		return indent;
	}
	
	public boolean getJustify () {
		return justify;
	}

	public Rectangle getLineBounds(int lineIndex) {
		recalculateLayout();
		RectBounds bounds = nativeLayout.getLines()[lineIndex].getBounds();
		return new Rectangle((int)bounds.getMinX(), (int)bounds.getMinY(), (int)bounds.getWidth(), (int)bounds.getHeight());
	}
	
	public int getLineCount() {
		recalculateLayout();
		return nativeLayout.getLines().length;
	}
		
	public int getOrientation() {
		return orientation;
	}
		
	public int[] getRanges () {
		int[] result = new int[styles.length * 2];
		int count = 0;
		for (int i=0; i< styles.length - 1; i++) {
			if (styles[i].style != null) {
				result[count++] = styles[i].start;
				result[count++] = styles[i + 1].start - 1;
			}
		}
		if (count != result.length) {
			int[] newResult = new int[count];
			System.arraycopy(result, 0, newResult, 0, count);
			result = newResult;
		}
		return result;		
	}
	
	public int[] getSegments() {
		return segments;
	}
	
	public char[] getSegmentsChars () {
		return segmentsChars;
	}
	
	public int getSpacing () {
		return spacing;
	}
	
	public TextStyle getStyle (int offset) {
		int length = text.length();
		if (!(0 <= offset && offset < length)) SWT.error(SWT.ERROR_INVALID_RANGE);
		for (int i=1; i<styles.length; i++) {
			StyleItem item = styles[i];
			if (item.start > offset) {
				return styles[i - 1].style;
			}
		}
		return null;		
	}
	
	public TextStyle[] getStyles () {
		TextStyle[] result = new TextStyle[styles.length];
		int count = 0;
		for (int i=0; i<styles.length; i++) {
			if (styles[i].style != null) {
				result[count++] = styles[i].style;
			}
		}
		if (count != result.length) {
			TextStyle[] newResult = new TextStyle[count];
			System.arraycopy(result, 0, newResult, 0, count);
			result = newResult;
		}
		return result;		
	}
	
	public int[] getTabs() {
		return tabs;
	}
	
	public String getText () {
		return text;
	}
	
	public int getWidth () {
		return width;
	}
	
	public int getWrapIndent () {
		return wrapIndent;
	}
	
	public void setAlignment (int alignment) {
		this.alignment = alignment;
		this.dirty = true;
		if( ! justify ) {
			switch (alignment) {
			case SWT.LEFT:
				nativeLayout.setAlignment(TextAlignment.LEFT.ordinal());
				break;
			case SWT.RIGHT:
				nativeLayout.setAlignment(TextAlignment.RIGHT.ordinal());
				break;
			case SWT.CENTER:
				nativeLayout.setAlignment(TextAlignment.CENTER.ordinal());
				break;
			}
		}
	}
	
	public void setAscent (int ascent) {
		Util.logNotImplemented();
		this.ascent = ascent;
	}
	
	public void setDescent (int descent) {
		Util.logNotImplemented();
		this.descent = descent;
	}
	
	public void setFont (Font font) {
		this.font = font;
		this.dirty = true;
	}

	public void setIndent (int indent) {
		this.indent = indent;
	}
	
	public void setWrapIndent (int wrapIndent) {
		this.wrapIndent = wrapIndent;
	}
	
	public void setJustify (boolean justify) {
		this.justify = justify;
		this.dirty = true;
		if( justify ) {
			nativeLayout.setAlignment(com.sun.javafx.scene.text.TextLayout.ALIGN_JUSTIFY);	
		} else {
			switch (alignment) {
			case SWT.LEFT:
				nativeLayout.setAlignment(com.sun.javafx.scene.text.TextLayout.ALIGN_LEFT);
				break;
			case SWT.RIGHT:
				nativeLayout.setAlignment(com.sun.javafx.scene.text.TextLayout.ALIGN_RIGHT);
				break;
			case SWT.CENTER:
				nativeLayout.setAlignment(com.sun.javafx.scene.text.TextLayout.ALIGN_CENTER);
				break;
			}
		}
	}
	
	public void setOrientation(int orientation) {
		int mask = SWT.LEFT_TO_RIGHT | SWT.RIGHT_TO_LEFT;
		this.dirty = true;
		orientation &= mask;
		if( orientation == 0 ) return;
		this.orientation = orientation;
		if( (orientation & SWT.LEFT_TO_RIGHT) != SWT.LEFT_TO_RIGHT ) {
			nativeLayout.setDirection(com.sun.javafx.scene.text.TextLayout.DIRECTION_DEFAULT_LTR);
		} else {
			nativeLayout.setDirection(com.sun.javafx.scene.text.TextLayout.DIRECTION_DEFAULT_RTL);
		}
	}
	
	public void setSegments(int[] segments) {
		if (this.segments == null && segments == null) return;
		if (this.segments != null && segments !=null) {
			if (this.segments.length == segments.length) {
				int i;
				for (i = 0; i <segments.length; i++) {
					if (this.segments[i] != segments[i]) break;
				}
				if (i == segments.length) return;
			}
		}
		this.segments = segments;
	}
	
	public void setSegmentsChars(char[] segmentsChars) {
		if (this.segmentsChars == null && segmentsChars == null) return;
		if (this.segmentsChars != null && segmentsChars != null) {
			if (this.segmentsChars.length == segmentsChars.length) {
				int i;
				for (i = 0; i <segmentsChars.length; i++) {
					if (this.segmentsChars[i] != segmentsChars[i]) break;
				}
				if (i == segmentsChars.length) return;
			}
		}
		this.segmentsChars = segmentsChars;
	}
	
	public void setSpacing (int spacing) {
		this.dirty = true;
		this.spacing = spacing;
		nativeLayout.setLineSpacing(spacing);
	}

	public void setStyle (TextStyle style, int start, int end) {
		this.dirty = true;
		int length = text.length();
		if (length == 0) return;
		if (start > end) return;
		start = Math.min(Math.max(0, start), length - 1);
		end = Math.min(Math.max(0, end), length - 1);
		int low = -1;
		int high = styles.length;
		while (high - low > 1) {
			int index = (high + low) / 2;
			if (styles[index + 1].start > start) {
				high = index;
			} else {
				low = index;
			}
		}
		if (0 <= high && high < styles.length) {
			StyleItem item = styles[high];
			if (item.start == start && styles[high + 1].start - 1 == end) {
				if (style == null) {
					if (item.style == null) return;
				} else {
					if (style.equals(item.style)) return;
				}
			}
		}
		int modifyStart = high;
		int modifyEnd = modifyStart;
		while (modifyEnd < styles.length) {
			if (styles[modifyEnd + 1].start > end) break;
			modifyEnd++;
		}
		if (modifyStart == modifyEnd) {
			int styleStart = styles[modifyStart].start; 
			int styleEnd = styles[modifyEnd + 1].start - 1;
			if (styleStart == start && styleEnd == end) {
				styles[modifyStart].style = style;
				return;
			}
			if (styleStart != start && styleEnd != end) {
				StyleItem[] newStyles = new StyleItem[styles.length + 2];
				System.arraycopy(styles, 0, newStyles, 0, modifyStart + 1);
				StyleItem item = new StyleItem();
				item.start = start;
				item.style = style;
				newStyles[modifyStart + 1] = item;	
				item = new StyleItem();
				item.start = end + 1;
				item.style = styles[modifyStart].style;
				newStyles[modifyStart + 2] = item;
				System.arraycopy(styles, modifyEnd + 1, newStyles, modifyEnd + 3, styles.length - modifyEnd - 1);
				styles = newStyles;
				return;
			}
		}
		if (start == styles[modifyStart].start) modifyStart--;
		if (end == styles[modifyEnd + 1].start - 1) modifyEnd++;
		int newLength = styles.length + 1 - (modifyEnd - modifyStart - 1);
		StyleItem[] newStyles = new StyleItem[newLength];
		System.arraycopy(styles, 0, newStyles, 0, modifyStart + 1);	
		StyleItem item = new StyleItem();
		item.start = start;
		item.style = style;
		newStyles[modifyStart + 1] = item;
		styles[modifyEnd].start = end + 1;
		System.arraycopy(styles, modifyEnd, newStyles, modifyStart + 2, styles.length - modifyEnd);
		styles = newStyles;	
	}
	
	public void setTabs(int[] tabs) {
		this.tabs = tabs;
	}
	
	public void setText (String text) {
		this.dirty = true;
		this.text = text;
		styles = new StyleItem[2];
		styles[0] = new StyleItem();
		styles[1] = new StyleItem();	
		styles[1].start = text.length();
	}
	
	public void setWidth (int width) {
		this.dirty = true;
		this.width = width;
		nativeLayout.setWrapWidth(width);
	}
	
	@Override
	public void dispose() {
		Toolkit.getToolkit().getTextLayoutFactory().disposeLayout(nativeLayout);
		nativeLayout = null;
	}

	@Override
	public boolean isDisposed() {
		return nativeLayout == null;
	}
	
	String getSegmentsText() {
		int length = text.length();
		if (length == 0) return text;
		if (segments == null) return text;
		int nSegments = segments.length;
		if (nSegments == 0) return text;
		if (segmentsChars == null) {
			if (nSegments == 1) return text;
			if (nSegments == 2) {
				if (segments[0] == 0 && segments[1] == length) return text;
			}
		}
		char[] oldChars = new char[length];
		text.getChars(0, length, oldChars, 0);
		char[] newChars = new char[length + nSegments];
		int charCount = 0, segmentCount = 0;
		char defaultSeparator = orientation == SWT.RIGHT_TO_LEFT ? RTL_MARK : LTR_MARK;
		while (charCount < length) {
			if (segmentCount < nSegments && charCount == segments[segmentCount]) {
				char separator = segmentsChars != null && segmentsChars.length > segmentCount ? segmentsChars[segmentCount] : defaultSeparator;
				newChars[charCount + segmentCount++] = separator;
			} else {
				newChars[charCount + segmentCount] = oldChars[charCount++];
			}
		}
		while (segmentCount < nSegments) {
			segments[segmentCount] = charCount;
			char separator = segmentsChars != null && segmentsChars.length > segmentCount ? segmentsChars[segmentCount] : defaultSeparator;
			newChars[charCount + segmentCount++] = separator;
		}
		return new String(newChars, 0, newChars.length);
	}

	StyleItem[] itemize () {
		int length = text.length();
		if (length == 0) {
			return new StyleItem[]{new StyleItem(), new StyleItem()};
		}
		int runCount = 0, start = 0;
		StyleItem[] runs = new StyleItem[length];
		char[] chars = text.toCharArray();
		for (int i = 0; i<length; i++) {
			char ch = chars[i];
			if (ch == '\t' || ch == '\r' || ch == '\n') {
				if (i != start) {
					StyleItem item = new StyleItem();
					item.start = start;
					runs[runCount++] = item;
				}
				StyleItem item = new StyleItem();
				item.start = i;
				runs[runCount++] = item;
				start = i + 1;
			}
		}
		char lastChar = chars[length - 1];
		if (!(lastChar == '\t' || lastChar == '\r' || lastChar == '\n')) {
			StyleItem item = new StyleItem();
			item.start = start;
			runs[runCount++] = item;
		}
		if (runCount != length) {
			StyleItem[] newRuns = new StyleItem[runCount];
			System.arraycopy(runs, 0, newRuns, 0, runCount);
			runs = newRuns;
		}
		runs = merge(runs, runCount);
		return runs;
	}

	/* 
	 *  Merge styles ranges and script items 
	 */
	StyleItem[] merge (StyleItem[] items, int itemCount) {
		int length = text.length();
		int count = 0, start = 0, end = length, itemIndex = 0, styleIndex = 0;
		StyleItem[] runs = new StyleItem[itemCount + styles.length];
		while (start < end) {
			StyleItem item = new StyleItem();
			item.start = start;
			item.style = styles[styleIndex].style;
			runs[count++] = item;
			int itemLimit = itemIndex + 1 < items.length ? items[itemIndex + 1].start : length;
			int styleLimit = styleIndex + 1 < styles.length ? styles[styleIndex + 1].start : length;
			if (styleLimit <= itemLimit) {
				styleIndex++;
				start = styleLimit;
			}
			if (itemLimit <= styleLimit) {
				itemIndex++;
				start = itemLimit;
			}
//			item.length = start - item.start;
		}
		StyleItem item = new StyleItem();
		item.start = end;
		runs[count++] = item;
		if (runs.length != count) {
			StyleItem[] result = new StyleItem[count];
			System.arraycopy(runs, 0, result, 0, count);
			return result;
		}
		return runs;
	}
	
	public int getNextOffset (int offset, int movement) {
		// TODO Auto-generated method stub
		Util.logNotImplemented();
		return text.length();
	}
	
	public int getPreviousOffset (int offset, int movement) {
		// TODO Auto-generated method stub
		Util.logNotImplemented();
		return text.length();		
	}

	@Override
	public Rectangle getBounds(int start, int end) {
		// TODO Auto-generated method stub
		Util.logNotImplemented();
		return null;
	}

	@Override
	public int getLevel(int offset) {
		// TODO Auto-generated method stub
		Util.logNotImplemented();
		return 0;
	}

	@Override
	public int[] getLineOffsets() {
		recalculateLayout();
		return lineOffsets;
	}

	@Override
	public int getLineIndex(int offset) {
		recalculateLayout();
		TextLine[] lines = nativeLayout.getLines();
		// Line offset is one more than number off lines!!!!
		for( int i = 0; i < lines.length; i++ ) {
			if( lineOffsets[i+1] > offset ) {
				return i;
			}
		}
		return 0;
	}

	@Override
	public FontMetrics getLineMetrics(int lineIndex) {
		recalculateLayout();
		int lineCount = getLineCount();
		int length = text.length();
		Util.logNotImplemented();
//		if (length == 0) {
			Font font = this.font != null ? this.font : Display.getCurrent().getSystemFont();
			com.sun.javafx.tk.FontMetrics fontMetrics = PrismFontLoader.getInstance().getFontMetrics(font.internal_getNativeObject());
			return new FontMetrics((int)Math.ceil(fontMetrics.getAscent()), (int)Math.ceil(fontMetrics.getDescent()), 0, 0, (int)Math.ceil(fontMetrics.getAscent()) + (int)Math.ceil(fontMetrics.getDescent()));
//		} else {
//			Util.logNotImplemented();
//			return null;
//		}		
	}

	@Override
	public Point getLocation(int offset, boolean trailing) {
		recalculateLayout();
		for( GlyphList l : nativeLayout.getLines()[0].getRuns() ) {
			TextSpanImpl i = (TextSpanImpl) l.getTextSpan();
			if( i.i.start <= offset ) {
				int idx = offset - i.i.start;
				return new Point((int)l.getPosX(idx), (int)l.getPosY(idx));
			}
		}
		
		//		for( TextSpanImpl i : spans ) {
//			if( i.i.start < offset ) {
//				return nativeLayout.getRuns()[0].
//			}
//		}
		// TODO Auto-generated method stub
		Util.logNotImplemented();
		return new Point(0, 0);
	}

	@Override
	public int getOffset(Point point, int[] trailing) {
		// TODO Auto-generated method stub
		Util.logNotImplemented();
		return 0;
	}

	@Override
	public int getOffset(int x, int y, int[] trailing) {
		// TODO Auto-generated method stub
		Util.logNotImplemented();
		return 0;
	}

}

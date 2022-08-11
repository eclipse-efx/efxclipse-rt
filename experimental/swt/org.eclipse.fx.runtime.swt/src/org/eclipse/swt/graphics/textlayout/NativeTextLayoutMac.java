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
package org.eclipse.swt.graphics.textlayout;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
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
public class NativeTextLayoutMac implements InternalTextLayout {
	String text;
	StyleItem[] styles;
	int stylesCount;
	int wrapWidth;
	int ascent;
	int descent;
	int alignment;
	int orientation;
	int[] segments;
	char[] segmentsChars;
	Device device;
	
	static final char LTR_MARK = '\u200E', RTL_MARK = '\u200F';
	
	int[] lineOffsets;
	RectBounds[] lineBounds;
	private TextLayout nativeLayout;
	private Font font;
	private int indent;
	private boolean justify;
	private int spacing;
	private int[] tabs;
	
	static class StyleItem {

		public int start;
		public TextStyle style;
	}
	
	public NativeTextLayoutMac(Device device) {
		this.device = device;
		wrapWidth = ascent = descent = -1;
		alignment = SWT.LEFT;
		orientation = SWT.LEFT_TO_RIGHT;
		text = "";
		styles = new StyleItem[2];
		styles[0] = new StyleItem();
		styles[1] = new StyleItem();
		stylesCount = 2;
		
		TextLayoutFactory factory = Toolkit.getToolkit().getTextLayoutFactory();
		nativeLayout = factory.createLayout();
	}
	
	private void computeRuns() {
		if (lineBounds != null) return;
		String segmentsText = getSegmentsText();
		
		int textLength = segmentsText.length();
		List<TextSpan> spanList = new ArrayList<TextSpan>();
		for (int i = 0; i < stylesCount - 1; i++) {
			StyleItem run = styles[i];
			
			int location = textLength != 0 ? translateOffset(run.start) : 0;
			int length = translateOffset(styles[i + 1].start) - location;
			
			spanList.add(new TextSpanImpl(run, text.substring(location, location+length)));
		}
		
		nativeLayout.setContent(spanList.toArray(new TextSpan[0]));
	
		TextLine[] lines = nativeLayout.getLines();
		lineBounds = new RectBounds[lines.length];
		lineOffsets = new int[lines.length+1];
		
//		System.err.println("LINE BOUNDS: ");
		for( int i = 0; i < lines.length;i++ ) {
			lineBounds[i] = lines[i].getBounds();
//			System.err.println(" ====> " + lineBounds[i]);
			GlyphList[] runs = lines[i].getRuns();
//			for( GlyphList r : runs ) {
//				System.err.println(r.getWidth() + "/" + r.getHeight());
//			}
			lineOffsets[i] = runs[runs.length-1].getCharOffset(0);
		}
	}
	
	@Override
	public void draw(GC gc, int x, int y) {
		computeRuns();
		for( TextLine l : nativeLayout.getLines() ) {
			for( GlyphList gl : l.getRuns() ) {
				TextSpanImpl ts = (TextSpanImpl) gl.getTextSpan();
				Shape shape = nativeLayout.getShape(TextLayout.TYPE_TEXT, ts);
				if( ts.i.style != null ) {
					gc.setBackground(ts.i.style.foreground);
				}
				
				gc.internal_drawShape(x,y,shape);
				gc.setBackground(null);
			}
		}		
	}

	@Override
	public void draw(GC gc, int x, int y, int selectionStart, int selectionEnd,
			Color selectionForeground, Color selectionBackground) {
		Util.logNotImplemented();
		draw(gc, x, y);
	}

	@Override
	public void draw(GC gc, int x, int y, int selectionStart, int selectionEnd,
			Color selectionForeground, Color selectionBackground, int flags) {
		Util.logNotImplemented();
		draw(gc, x, y);		
	}

	@Override
	public int getAlignment() {
		return alignment;
	}

	@Override
	public int getAscent() {
		return ascent;
	}

	@Override
	public Rectangle getBounds() {
		computeRuns();
		BaseBounds bounds = nativeLayout.getBounds();
		return new Rectangle((int)Math.ceil(bounds.getMinX()), (int)Math.ceil(bounds.getMinY()), (int)Math.ceil(bounds.getWidth()), (int)Math.ceil(bounds.getHeight()));
	}

	@Override
	public Rectangle getBounds(int start, int end) {
		computeRuns();
		int x1 = 0, x2 = 0;
		int y1 = 0, y2 = 0;
		
		for( TextLine l : nativeLayout.getLines() ) {
			for( GlyphList g : l.getRuns() ) {
				if( g.getCharOffset(0) >= start ) {
					x1 = (int)g.getPosX(start - g.getCharOffset(0));
					y1 = (int)g.getPosY(start - g.getCharOffset(0));
					break;
				}
			}
		}
		
		for( TextLine l : nativeLayout.getLines() ) {
			for( GlyphList g : l.getRuns() ) {
				if( g.getCharOffset(0) >= end ) {
					x2 = (int)g.getPosX(end - g.getCharOffset(0));
					y2 = (int)g.getPosY(end - g.getCharOffset(0));
					break;
				}
			}
		}
		
		Rectangle r = new Rectangle(x1, y1, x2-x1, y2 - y1);
		System.err.println("RANGE BOUNDS: " + r);
		return r;
	}

	@Override
	public int getDescent() {
		return descent;
	}

	@Override
	public Font getFont() {
		return font != null ? font : device.getSystemFont();
	}

	@Override
	public int getIndent() {
		return indent;
	}

	@Override
	public boolean getJustify() {
		return justify;
	}

	@Override
	public int getLevel(int offset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] getLineOffsets() {
		computeRuns();
		int[] offsets = new int[lineOffsets.length];
		for (int i = 0; i < offsets.length; i++) {
			offsets[i] = untranslateOffset(lineOffsets[i]);
		}
		return offsets;
	}

	@Override
	public int getLineIndex(int offset) {
		computeRuns();
		int length = text.length();
		if (!(0 <= offset && offset <= length)) SWT.error(SWT.ERROR_INVALID_RANGE);
		offset = translateOffset(offset);
		for (int line=0; line<lineOffsets.length - 1; line++) {
			if (lineOffsets[line + 1] > offset) {
				return line;
			}
		}
		return lineBounds.length - 1;
	}

	@Override
	public Rectangle getLineBounds(int lineIndex) {
//FIXME When return real size we get a stack overflow		
//		computeRuns();
//		if (!(0 <= lineIndex && lineIndex < lineBounds.length)) SWT.error(SWT.ERROR_INVALID_RANGE);
//		RectBounds rect = lineBounds[lineIndex];
//		System.err.println("====> " + rect);
//		int height =  Math.max((int)Math.ceil(rect.getHeight()), ascent + descent);
//		Rectangle r = new Rectangle(0, 0, (int)Math.ceil(rect.getWidth())+1, height);
//		System.err.println("=================> " + r);
//		return r;
		return new Rectangle(0, 0, 0, 0);
	}

	@Override
	public int getLineCount() {
		computeRuns();	
		return lineOffsets.length - 1;
	}

	@Override
	public FontMetrics getLineMetrics(int lineIndex) {
//		computeRuns();
//		int lineCount = getLineCount();
//		if (!(0 <= lineIndex && lineIndex < lineCount)) SWT.error(SWT.ERROR_INVALID_RANGE);
//		int length = text.length();
//		if (length == 0) {
//			Font font = this.font != null ? this.font : device.getSystemFont();
//			int ascent = (int)layoutManager.defaultBaselineOffsetForFont(font.handle);
//			int descent = (int)layoutManager.defaultLineHeightForFont(font.handle) - ascent;
//			ascent = Math.max(ascent, this.ascent);
//			descent = Math.max(descent, this.descent);
//			return FontMetrics.cocoa_new(ascent, descent, 0, 0, ascent + descent);
//		}
//		Rectangle rect = getLineBounds(lineIndex);
//		int baseline = (int)layoutManager.typesetter().baselineOffsetInLayoutManager(layoutManager, getLineOffsets()[lineIndex]);
//		return FontMetrics.cocoa_new(rect.height - baseline, baseline, 0, 0, rect.height);
		Font font = this.font != null ? this.font : Display.getCurrent().getSystemFont();
		com.sun.javafx.tk.FontMetrics fontMetrics = PrismFontLoader.getInstance().getFontMetrics(font.internal_getNativeObject());
		return new FontMetrics((int)Math.ceil(fontMetrics.getAscent()), (int)Math.ceil(fontMetrics.getDescent()), 0, 0, (int)Math.ceil(fontMetrics.getAscent()) + (int)Math.ceil(fontMetrics.getDescent()));
	}

	@Override
	public Point getLocation(int offset, boolean trailing) {
		computeRuns();
		int length = text.length();
		if (!(0 <= offset && offset <= length)) SWT.error(SWT.ERROR_INVALID_RANGE);
		if (length == 0) return new Point(0, 0);
		if (offset == length) {
			RectBounds rect = lineBounds[lineBounds.length - 1];
			return new Point((int)(rect.getMinX() + rect.getWidth()), (int)rect.getMinY());
		} else {
			offset = translateOffset(offset);
			for( TextLine l : nativeLayout.getLines() ) {
				for( GlyphList gl : l.getRuns() ) {
					int startOffset = gl.getCharOffset(0);
					if( startOffset <= offset ) {
						int glyphIdx = offset - startOffset;
						if( trailing ) {
							if( gl.getGlyphCount() > 0 ) {
								return new Point((int)(gl.getPosX(0)+gl.getWidth()),(int)gl.getPosY(glyphIdx));	
							}
						} else {
							if( gl.getGlyphCount() > 0 ) {
								return new Point((int)gl.getPosX(glyphIdx),(int)gl.getPosY(glyphIdx));	
							}
						}
						
					}
				}
			}
		}
		return new Point(0, 0);
	}

	@Override
	public int getNextOffset(int offset, int movement) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOffset(Point point, int[] trailing) {
		checkLayout();
		if (point == null) SWT.error(SWT.ERROR_NULL_ARGUMENT);
		return getOffset(point.x, point.y, trailing);
	}

	@Override
	public int getOffset(int x, int y, int[] trailing) {
		computeRuns();
		if (trailing != null && trailing.length < 1) SWT.error(SWT.ERROR_INVALID_ARGUMENT);
		int length = text.length();
		if (length == 0) return 0;

		int offset = -1;
		for( TextLine l : nativeLayout.getLines() ) {
			if( l.getBounds().contains(x, y) ) {
				GlyphList[] gls = l.getRuns();
				for( int g = 0; g < gls.length; g++  ) {
					for( int i = 0; i < gls[g].getGlyphCount(); i++ ) {
						if( gls[g].getPosX(i) > x ) {
							int idx = i - 1;
							if( idx < 0 ) {
								if( g > 0 ) {
									offset = gls[g-1].getCharOffset(gls[g-1].getGlyphCount()-1);
								} else {
									offset = gls[g].getCharOffset(0);
								}
							} else {
								offset = gls[g].getCharOffset(i);
							}
						}
					}
				}
			}
			
//			if( offset != -1 ) {
//				offset = Math.min(untranslateOffset(offset), length - 1);
//				if (trailing != null) {
//				trailing[0] = Math.round((float)/*64*/partialFraction[0]);
//				if (partialFraction[0] >= 0.5) {
//					char ch = text.charAt(offset);
//					if (0xD800 <= ch && ch <= 0xDBFF) {
//						if (offset + 1 < length) {
//							ch = text.charAt(offset + 1);
//							if (0xDC00 <= ch && ch <= 0xDFFF) {
//								trailing[0]++;
//							}
//						}
//					}
//				}
//			}
//			return offset;
//			}
		}
		
		System.err.println(" =================> " + offset);
		
		return offset;
		
//		NSPoint pt = new NSPoint();
//		pt.x = x;
//		pt.y = y;
//		double /*float*/[] partialFraction = new double /*float*/[1];
//		long /*int*/ glyphIndex = layoutManager.glyphIndexForPoint(pt, textContainer, partialFraction);
//		int offset = (int)/*64*/layoutManager.characterIndexForGlyphAtIndex(glyphIndex);
//		offset = Math.min(untranslateOffset(offset), length - 1);
//		if (trailing != null) {
//			trailing[0] = Math.round((float)/*64*/partialFraction[0]);
//			if (partialFraction[0] >= 0.5) {
//				char ch = text.charAt(offset);
//				if (0xD800 <= ch && ch <= 0xDBFF) {
//					if (offset + 1 < length) {
//						ch = text.charAt(offset + 1);
//						if (0xDC00 <= ch && ch <= 0xDFFF) {
//							trailing[0]++;
//						}
//					}
//				}
//			}
//		}
//		return offset;
//		Util.logNotImplemented();
//		return 0;
	}

	@Override
	public int getOrientation() {
		return orientation;
	}

	@Override
	public int getPreviousOffset(int offset, int movement) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] getRanges() {
		checkLayout();
		int[] result = new int[stylesCount * 2];
		int count = 0;
		for (int i=0; i<stylesCount - 1; i++) {
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

	@Override
	public int[] getSegments() {
		return segments;
	}

	public char[] getSegmentsChars () {
		checkLayout();
		return segmentsChars;
	}

	@Override
	public int getSpacing() {
		return spacing;
	}

	@Override
	public TextStyle getStyle(int offset) {
		checkLayout();
		int length = text.length();
		if (!(0 <= offset && offset < length)) SWT.error(SWT.ERROR_INVALID_RANGE);
		for (int i=1; i<stylesCount; i++) {
			StyleItem item = styles[i];
			if (item.start > offset) {
				return styles[i - 1].style;
			}
		}
		return null;
	}

	@Override
	public TextStyle[] getStyles() {
		checkLayout();
		TextStyle[] result = new TextStyle[stylesCount];
		int count = 0;
		for (int i=0; i<stylesCount; i++) {
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

	@Override
	public int[] getTabs() {
		checkLayout();
		return tabs;
	}

	@Override
	public String getText() {
		checkLayout ();
		return text;
	}

	@Override
	public int getWidth() {
		checkLayout();
		return wrapWidth;
	}

	@Override
	public void setAlignment(int alignment) {
		int mask = SWT.LEFT | SWT.CENTER | SWT.RIGHT;
		alignment &= mask;
		if (alignment == 0) return;
		if ((alignment & SWT.LEFT) != 0) alignment = SWT.LEFT;
		if ((alignment & SWT.RIGHT) != 0) alignment = SWT.RIGHT;
		if (this.alignment == alignment) return;
		freeRuns();
		this.alignment = alignment;
	}

	@Override
	public void setAscent(int ascent) {
		checkLayout ();
		if (ascent < -1) SWT.error(SWT.ERROR_INVALID_ARGUMENT);
		if (this.ascent == ascent) return;
		freeRuns();
		this.ascent = ascent;
	}

	@Override
	public void setDescent(int descent) {
		checkLayout ();
		if (descent < -1) SWT.error(SWT.ERROR_INVALID_ARGUMENT);
		if (this.descent == descent) return;
		freeRuns();
		this.descent = descent;
	}

	@Override
	public void setFont(Font font) {
		checkLayout ();
		if (font != null && font.isDisposed()) SWT.error(SWT.ERROR_INVALID_ARGUMENT);
		Font oldFont = this.font;
		if (oldFont == font) return;
		this.font = font;
		if (oldFont != null && oldFont.equals(font)) return;
		freeRuns();
	}

	@Override
	public void setIndent(int indent) {
		checkLayout ();
		if (indent < 0) return;
		if (this.indent == indent) return;
		freeRuns();
		this.indent = indent;
	}

	@Override
	public void setJustify(boolean justify) {
		checkLayout ();
		if (justify == this.justify) return;
		freeRuns();
		this.justify = justify;
	}

	@Override
	public void setOrientation(int orientation) {
		checkLayout();
		int mask = SWT.LEFT_TO_RIGHT | SWT.RIGHT_TO_LEFT;
		orientation &= mask;
		if (orientation == 0) return;
		if ((orientation & SWT.LEFT_TO_RIGHT) != 0) orientation = SWT.LEFT_TO_RIGHT;
		if (this.orientation == orientation) return;
		this.orientation = orientation;
		freeRuns();
	}

	@Override
	public void setSegments(int[] segments) {
		checkLayout();
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
		freeRuns();
		this.segments = segments;
	}
	
	public void setSegmentsChars(char[] segmentsChars) {
		checkLayout();
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
		freeRuns();
		this.segmentsChars = segmentsChars;
	}

	@Override
	public void setSpacing(int spacing) {
		checkLayout();
		if (spacing < 0) SWT.error(SWT.ERROR_INVALID_ARGUMENT);
		if (this.spacing == spacing) return;
		freeRuns();
		this.spacing = spacing;
	}

	@Override
	public void setStyle (TextStyle style, int start, int end) {
		checkLayout();
			int length = text.length();
			if (length == 0) return;
			if (start > end) return;
			start = Math.min(Math.max(0, start), length - 1);
			end = Math.min(Math.max(0, end), length - 1);
			int low = -1;
			int high = stylesCount;
			while (high - low > 1) {
				int index = (high + low) / 2;
				if (styles[index + 1].start > start) {
					high = index;
				} else {
					low = index;
				}
			}
			if (0 <= high && high < stylesCount) {
				StyleItem item = styles[high];
				if (item.start == start && styles[high + 1].start - 1 == end) {
					if (style == null) {
						if (item.style == null) return;
					} else {
						if (style.equals(item.style)) return;
					}
				}
			}
			freeRuns();
			int modifyStart = high;
			int modifyEnd = modifyStart;
			while (modifyEnd < stylesCount) {
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
					int newLength = stylesCount + 2; 
					if (newLength > styles.length) {
						int newSize = Math.min(newLength + 1024, Math.max(64, newLength * 2));
						StyleItem[] newStyles = new StyleItem[newSize];
						System.arraycopy(styles, 0, newStyles, 0, stylesCount);
						styles = newStyles;
					}
					System.arraycopy(styles, modifyEnd + 1, styles, modifyEnd + 3, stylesCount - modifyEnd - 1);
					StyleItem item = new StyleItem();
					item.start = start;
					item.style = style;
					styles[modifyStart + 1] = item;	
					item = new StyleItem();
					item.start = end + 1;
					item.style = styles[modifyStart].style;
					styles[modifyStart + 2] = item;
					stylesCount = newLength;
					return;
				}
			}
			if (start == styles[modifyStart].start) modifyStart--;
			if (end == styles[modifyEnd + 1].start - 1) modifyEnd++;
			int newLength = stylesCount + 1 - (modifyEnd - modifyStart - 1);
			if (newLength > styles.length) {
				int newSize = Math.min(newLength + 1024, Math.max(64, newLength * 2));
				StyleItem[] newStyles = new StyleItem[newSize];
				System.arraycopy(styles, 0, newStyles, 0, stylesCount);
				styles = newStyles;
			}
			System.arraycopy(styles, modifyEnd, styles, modifyStart + 2, stylesCount - modifyEnd);
			StyleItem item = new StyleItem();
			item.start = start;
			item.style = style;
			styles[modifyStart + 1] = item;
			styles[modifyStart + 2].start = end + 1;
			stylesCount = newLength;
	}

	@Override
	public void setTabs(int[] tabs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setText (String text) {
		checkLayout ();
		if (text == null) SWT.error(SWT.ERROR_NULL_ARGUMENT);
		if (text.equals(this.text)) return;
		freeRuns();
		this.text = text;
		styles = new StyleItem[2];
		styles[0] = new StyleItem();
		styles[1] = new StyleItem();
		styles[1].start = text.length();
		stylesCount = 2;
	}
	
	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDisposed() {
		// TODO Auto-generated method stub
		return false;
	}

	
	void checkLayout() {
		if (isDisposed()) SWT.error(SWT.ERROR_GRAPHIC_DISPOSED);
	}
	
	void freeRuns() {
		lineBounds = null;
		lineOffsets = null;
		for (int i = 0; i < stylesCount - 1; i++) {
//			StyleItem run = styles[i];
//			if (run.cell != null) {
//				run.cell = null;
//			}
		}
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
	
	int translateOffset (int offset) {
		int length = text.length();
		if (length == 0) return offset;
		if (segments == null) return offset;
		int nSegments = segments.length;
		if (nSegments == 0) return offset;
		if (segmentsChars == null) {
			if (nSegments == 1) return offset;
			if (nSegments == 2) {
				if (segments[0] == 0 && segments[1] == length) return offset;
			}
		}
		for (int i = 0; i < nSegments && offset - i >= segments[i]; i++) {
			offset++;
		}	
		return offset;
	}
	
	int untranslateOffset (int offset) {
		int length = text.length();
		if (length == 0) return offset;
		if (segments == null) return offset;
		int nSegments = segments.length;
		if (nSegments == 0) return offset;
		if (segmentsChars == null) {
			if (nSegments == 1) return offset;
			if (nSegments == 2) {
				if (segments[0] == 0 && segments[1] == length) return offset;
			}
		}
		for (int i = 0; i < nSegments && offset > segments[i]; i++) {
			offset--;
		}
		return offset;
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
			return i.style != null ? i.style.font.internal_getNativeObject().impl_getNativeFont() : NativeTextLayoutMac.this.getFont().internal_getNativeObject().impl_getNativeFont();
		}

		@Override
		public RectBounds getBounds() {
			return null;
		}
		
	}
}

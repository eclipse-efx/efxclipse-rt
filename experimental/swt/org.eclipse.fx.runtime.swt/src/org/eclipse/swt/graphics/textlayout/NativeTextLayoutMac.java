package org.eclipse.swt.graphics.textlayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.TextStyle;

public class NativeTextLayoutMac implements InternalTextLayout {
	String text;
	StyleItem[] styles;
	int stylesCount;
	int wrapWidth;
	int ascent;
	int descent;
	int alignment;
	int orientation;
	
	int[] lineOffsets;
	javafx.scene.shape.Rectangle[] lineBounds;
	
	static class StyleItem {

		public int start;
		public TextStyle style;
	}
	
	public NativeTextLayoutMac() {
		wrapWidth = ascent = descent = -1;
		alignment = SWT.LEFT;
		orientation = SWT.LEFT_TO_RIGHT;
		text = "";
		styles = new StyleItem[2];
		styles[0] = new StyleItem();
		styles[1] = new StyleItem();
		stylesCount = 2;
	}
	
	@Override
	public void draw(GC gc, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(GC gc, int x, int y, int selectionStart, int selectionEnd,
			Color selectionForeground, Color selectionBackground) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(GC gc, int x, int y, int selectionStart, int selectionEnd,
			Color selectionForeground, Color selectionBackground, int flags) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAlignment() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAscent() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getBounds(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDescent() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Font getFont() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIndent() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getJustify() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLevel(int offset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] getLineOffsets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLineIndex(int offset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Rectangle getLineBounds(int lineIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLineCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FontMetrics getLineMetrics(int lineIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getLocation(int offset, boolean trailing) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNextOffset(int offset, int movement) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOffset(Point point, int[] trailing) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOffset(int x, int y, int[] trailing) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOrientation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPreviousOffset(int offset, int movement) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] getRanges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getSegments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSpacing() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TextStyle getStyle(int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TextStyle[] getStyles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getTabs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAlignment(int alignment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAscent(int ascent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDescent(int descent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFont(Font font) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIndent(int indent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJustify(boolean justify) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOrientation(int orientation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSegments(int[] segments) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSpacing(int spacing) {
		// TODO Auto-generated method stub
		
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

}

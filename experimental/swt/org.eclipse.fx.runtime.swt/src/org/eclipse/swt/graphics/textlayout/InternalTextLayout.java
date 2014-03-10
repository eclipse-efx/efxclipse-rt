package org.eclipse.swt.graphics.textlayout;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.TextStyle;

public interface InternalTextLayout {
	public void draw(GC gc, int x, int y);
	
	public void draw(GC gc, int x, int y, int selectionStart, int selectionEnd, Color selectionForeground, Color selectionBackground);
	
	public void draw(GC gc, int x, int y, int selectionStart, int selectionEnd, Color selectionForeground, Color selectionBackground, int flags);
	
	public int getAlignment();
	
	public int getAscent ();
	
	public Rectangle getBounds();
	
	public Rectangle getBounds(int start, int end);
	
	public int getDescent ();
	
	public Font getFont ();
	
	public int getIndent ();
	
	public boolean getJustify ();
	
	public int getLevel(int offset);
	
	public int[] getLineOffsets();
	
	public int getLineIndex(int offset);
	
	public Rectangle getLineBounds(int lineIndex);
	
	public int getLineCount();
	
	public FontMetrics getLineMetrics (int lineIndex);
	
	public Point getLocation(int offset, boolean trailing);
	
	public int getNextOffset (int offset, int movement);
	
	public int getOffset(Point point, int[] trailing);
	
	public int getOffset(int x, int y, int[] trailing);
	
	public int getOrientation();
	
	public int getPreviousOffset (int offset, int movement);
	
	public int[] getRanges ();
	
	public int[] getSegments();
	
//	public char[] getSegmentsChars () {
//		return layout.getSegmentsChars();
//	}
	
	public int getSpacing ();
	
	public TextStyle getStyle (int offset);
	
	public TextStyle[] getStyles ();
	
	public int[] getTabs();
	
	public String getText ();
	
	public int getWidth ();
	
//	public int getWrapIndent () {
//		return layout.getWrapIndent();
//	}
	
	public void setAlignment (int alignment);
	
	public void setAscent (int ascent);
	
	public void setDescent (int descent);
	
	public void setFont (Font font);

	public void setIndent (int indent);
	
//	public void setWrapIndent (int wrapIndent) {
//		layout.setWrapIndent(wrapIndent);
//	}
	
	public void setJustify (boolean justify);
	
	public void setOrientation(int orientation);
	
	public void setSegments(int[] segments);
	
//	public void setSegmentsChars(char[] segmentsChars) {
//		layout.setSegmentsChars(segmentsChars);
//	}
	
	public void setSpacing (int spacing);

	public void setStyle (TextStyle style, int start, int end);
	
	public void setTabs(int[] tabs);
	
	public void setText (String text);
	
	public void setWidth (int width);
	
	public void dispose();

	public boolean isDisposed();
}

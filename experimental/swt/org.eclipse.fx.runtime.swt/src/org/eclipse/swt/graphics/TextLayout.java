package org.eclipse.swt.graphics;

import javafx.scene.text.TextAlignment;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.textlayout.InternalTextLayout;
import org.eclipse.swt.graphics.textlayout.NativeTextLayout;
import org.eclipse.swt.graphics.textlayout.NativeTextLayoutMac;
import org.eclipse.swt.internal.Util;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.RectBounds;
import com.sun.javafx.scene.text.TextLayoutFactory;
import com.sun.javafx.tk.Toolkit;

@SuppressWarnings("restriction")
public class TextLayout extends Resource {
	private InternalTextLayout layout;
	
	public TextLayout(Device device) {
		super(device);
		layout = new NativeTextLayout(device);
//		layout = new SwingTextLayout(device);
		layout = new NativeTextLayoutMac(device);
	}
	
	public void draw(GC gc, int x, int y) {
		layout.draw(gc, x, y);
	}
	
	public void draw(GC gc, int x, int y, int selectionStart, int selectionEnd, Color selectionForeground, Color selectionBackground) {
		layout.draw(gc, x, y, selectionStart, selectionEnd, selectionForeground, selectionBackground);
	}
	
	public void draw(GC gc, int x, int y, int selectionStart, int selectionEnd, Color selectionForeground, Color selectionBackground, int flags) {
		layout.draw(gc, x, y, selectionStart, selectionEnd, selectionForeground, selectionBackground, flags);
	}
	
	public int getAlignment() {
		return layout.getAlignment();
	}
	
	public int getAscent () {
		return layout.getAscent();
	}
	
	public Rectangle getBounds() {
		return layout.getBounds();
	}
	
	public Rectangle getBounds(int start, int end) {
		return layout.getBounds(start, end);
	}
	
	public int getDescent () {
		return layout.getDescent();
	}
	
	public Font getFont () {
		return layout.getFont();
	}
	
	public int getIndent () {
		return layout.getIndent();
	}
	
	public boolean getJustify () {
		return layout.getJustify();
	}
	
	public int getLevel(int offset) {
		return layout.getLevel(offset);
	}
	
	public int[] getLineOffsets() {
		return layout.getLineOffsets();
	}
	
	public int getLineIndex(int offset) {
		return layout.getLineIndex(offset);
	}
	
	public Rectangle getLineBounds(int lineIndex) {
		return layout.getLineBounds(lineIndex);
	}
	
	public int getLineCount() {
		return layout.getLineCount();
	}
	
	public FontMetrics getLineMetrics (int lineIndex) {
		return layout.getLineMetrics(lineIndex);
	}
	
	public Point getLocation(int offset, boolean trailing) {
		return layout.getLocation(offset, trailing);
	}
	
	public int getNextOffset (int offset, int movement) {
		return layout.getNextOffset(offset, movement);
	}
	
	public int getOffset(Point point, int[] trailing) {
		return layout.getOffset(point, trailing);
	}
	
	public int getOffset(int x, int y, int[] trailing) {
		return layout.getOffset(x, y, trailing);
	}
	
	public int getOrientation() {
		return layout.getOrientation();
	}
	
	public int getPreviousOffset (int offset, int movement) {
		return layout.getPreviousOffset(offset, movement);		
	}
	
	public int[] getRanges () {
		return layout.getRanges();
	}
	
	public int[] getSegments() {
		return layout.getSegments();
	}
	
//	public char[] getSegmentsChars () {
//		return layout.getSegmentsChars();
//	}
	
	public int getSpacing () {
		return layout.getSpacing();
	}
	
	public TextStyle getStyle (int offset) {
		return layout.getStyle(offset);		
	}
	
	public TextStyle[] getStyles () {
		return layout.getStyles();		
	}
	
	public int[] getTabs() {
		return layout.getTabs();
	}
	
	public String getText () {
		return layout.getText();
	}
	
	public int getWidth () {
		return layout.getWidth();
	}
	
//	public int getWrapIndent () {
//		return layout.getWrapIndent();
//	}
	
	public void setAlignment (int alignment) {
		layout.setAlignment(alignment);
	}
	
	public void setAscent (int ascent) {
		layout.setAscent(ascent);
	}
	
	public void setDescent (int descent) {
		layout.setDescent(descent);
	}
	
	public void setFont (Font font) {
		layout.setFont(font);
	}

	public void setIndent (int indent) {
		layout.setIndent(indent);
	}
	
//	public void setWrapIndent (int wrapIndent) {
//		layout.setWrapIndent(wrapIndent);
//	}
	
	public void setJustify (boolean justify) {
		layout.setJustify(justify);
	}
	
	public void setOrientation(int orientation) {
		layout.setOrientation(orientation);
	}
	
	public void setSegments(int[] segments) {
		layout.setSegments(segments);
	}
	
//	public void setSegmentsChars(char[] segmentsChars) {
//		layout.setSegmentsChars(segmentsChars);
//	}
	
	public void setSpacing (int spacing) {
		layout.setSpacing(spacing); 
	}

	public void setStyle (TextStyle style, int start, int end) {
		layout.setStyle(style, start, end);
	}
	
	public void setTabs(int[] tabs) {
		layout.setTabs(tabs);
	}
	
	public void setText (String text) {
		layout.setText(text);
	}
	
	public void setWidth (int width) {
		layout.setWidth(width);
	}
	
	@Override
	public void dispose() {
		layout.dispose();
	}

	@Override
	public boolean isDisposed() {
		return layout.isDisposed();
	}

}

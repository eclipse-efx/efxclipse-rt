package org.eclipse.swt.graphics;

public class FontMetrics {
	private final int ascent;
	private final int descent;
	private final int averageCharWidth;
	private final int leading;
	private final int height;
	
	public FontMetrics(int ascent, int descent, int averageCharWidth, int leading, int height) {
		this.ascent = ascent;
		this.descent = descent;
		this.averageCharWidth = averageCharWidth;
		this.leading = leading;
		this.height = height;
	}
	
	public int getAscent() {
		return ascent;
	}
	
	public int getDescent() {
		return descent;
	}
	
	public int getAverageCharWidth() {
		return averageCharWidth;
	}

	public int getLeading() {
		return leading;
	}
	
	public int getHeight() {
		return height;
	}
}

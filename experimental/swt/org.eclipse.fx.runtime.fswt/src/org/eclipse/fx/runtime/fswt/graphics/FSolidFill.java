package org.eclipse.fx.runtime.fswt.graphics;

public final class FSolidFill implements FFill {
	public final int red;
	public final int green;
	public final int blue;
	public final double opacity;

	public FSolidFill(int red, int green, int blue, double opacity) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.opacity = opacity;
	}
}

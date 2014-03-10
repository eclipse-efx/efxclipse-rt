package org.eclipse.swt.widgets;

import org.eclipse.swt.graphics.Rectangle;

public class TouchSource {
	int /* long */handle;
	boolean direct;
	Rectangle bounds;

	TouchSource(int /* long */handle, boolean direct, Rectangle bounds) {
		this.handle = handle;
		this.direct = direct;
		this.bounds = bounds;
	}

	public boolean isDirect() {
		return direct;
	}

	public Rectangle getBounds() {
		return new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height);
	}

	public String toString() {
		return "TouchSource {handle=" + handle + " direct=" + direct + " bounds=" + bounds + "}";
	}
}

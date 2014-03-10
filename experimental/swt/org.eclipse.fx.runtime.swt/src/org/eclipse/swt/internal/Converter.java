package org.eclipse.swt.internal;

import javafx.geometry.Bounds;

import org.eclipse.swt.graphics.Rectangle;

public class Converter {
	public static Rectangle fromBounds(Bounds b) {
		return new Rectangle((int)b.getMinX(), (int)b.getMinY(), (int)b.getWidth(), (int)b.getHeight());
	}
}

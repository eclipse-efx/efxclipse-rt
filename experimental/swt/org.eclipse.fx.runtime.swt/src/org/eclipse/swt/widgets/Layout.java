package org.eclipse.swt.widgets;

import org.eclipse.swt.graphics.Point;

public abstract class Layout {
	protected abstract void layout (Composite composite, boolean flushCache);
	protected abstract Point computeSize (Composite composite, int wHint, int hHint, boolean flushCache);
	
	protected boolean flushCache(Control child) {
		return false;
	}
}

package org.eclipse.swt.events;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Event;

public final class PaintEvent extends TypedEvent {

	public GC gc;

	public int x;

	public int y;

	public int width;

	public int height;

	public int count;

	static final long serialVersionUID = 3256446919205992497L;

	public PaintEvent(Event e) {
		super(e);
		this.gc = e.gc;
		this.x = e.x;
		this.y = e.y;
		this.width = e.width;
		this.height = e.height;
		this.count = e.count;
	}

	public String toString() {
		String string = super.toString();
		return string.substring(0, string.length() - 1) // remove trailing '}'
				+ " gc=" + gc + " x=" + x + " y=" + y + " width=" + width + " height=" + height + " count=" + count + "}";
	}
}
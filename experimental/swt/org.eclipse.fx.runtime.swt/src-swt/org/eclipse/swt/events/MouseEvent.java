package org.eclipse.swt.events;

import org.eclipse.swt.widgets.Event;

public class MouseEvent extends TypedEvent {

	public int button;

	public int stateMask;

	public int x;

	public int y;

	public int count;

	static final long serialVersionUID = 3257288037011566898L;

	public MouseEvent(Event e) {
		super(e);
		this.x = e.x;
		this.y = e.y;
		this.button = e.button;
		this.stateMask = e.stateMask;
		this.count = e.count;
	}

	public String toString() {
		String string = super.toString();
		return string.substring(0, string.length() - 1) // remove trailing '}'
				+ " button=" + button + " stateMask=0x" + Integer.toHexString(stateMask) + " x=" + x + " y=" + y + " count=" + count + "}";
	}
}
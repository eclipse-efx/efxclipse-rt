package org.eclipse.swt.events;

import org.eclipse.swt.widgets.Event;

public class GestureEvent extends TypedEvent {

	public int stateMask;

	public int detail;

	public int x;

	public int y;

	public double rotation;

	public int xDirection;

	public int yDirection;

	public double magnification;

	public boolean doit;

	static final long serialVersionUID = -8348741538373572182L;

	public GestureEvent(Event e) {
		super(e);
		this.stateMask = e.stateMask;
		this.x = e.x;
		this.y = e.y;
		this.detail = e.detail;
		this.rotation = e.rotation;
		this.xDirection = e.xDirection;
		this.yDirection = e.yDirection;
		this.magnification = e.magnification;
		this.doit = e.doit;
	}

	public String toString() {
		String string = super.toString();
		return string.substring(0, string.length() - 1) // remove trailing '}'
				+ " stateMask=0x" + Integer.toHexString(stateMask) + " detail=" + detail + " x=" + x + " y=" + y + " rotation=" + rotation + " xDirection=" + xDirection + " yDirection=" + yDirection + " magnification=" + magnification + "}";
	}
}
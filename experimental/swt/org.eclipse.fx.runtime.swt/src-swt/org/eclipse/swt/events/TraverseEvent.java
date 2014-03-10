package org.eclipse.swt.events;

import org.eclipse.swt.widgets.Event;

public final class TraverseEvent extends KeyEvent {

	public int detail;

	static final long serialVersionUID = 3257565105301239349L;

	public TraverseEvent(Event e) {
		super(e);
		this.detail = e.detail;
	}

	public String toString() {
		String string = super.toString();
		return string.substring(0, string.length() - 1) // remove trailing '}'
				+ " detail=" + detail + "}";
	}
}
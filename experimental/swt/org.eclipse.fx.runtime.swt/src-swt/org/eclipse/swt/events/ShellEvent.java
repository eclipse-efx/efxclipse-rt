package org.eclipse.swt.events;

import org.eclipse.swt.widgets.Event;

public final class ShellEvent extends TypedEvent {

	public boolean doit;

	static final long serialVersionUID = 3257569490479888441L;

	public ShellEvent(Event e) {
		super(e);
		this.doit = e.doit;
	}

	public String toString() {
		String string = super.toString();
		return string.substring(0, string.length() - 1) // remove trailing '}'
				+ " doit=" + doit + "}";
	}
}
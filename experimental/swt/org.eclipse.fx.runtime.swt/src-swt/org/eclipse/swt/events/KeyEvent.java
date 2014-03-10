package org.eclipse.swt.events;

import org.eclipse.swt.widgets.Event;

public class KeyEvent extends TypedEvent {

	public char character;

	public int keyCode;

	public int keyLocation;

	public int stateMask;

	public boolean doit;

	static final long serialVersionUID = 3256442491011412789L;

	public KeyEvent(Event e) {
		super(e);
		this.character = e.character;
		this.keyCode = e.keyCode;
		this.keyLocation = e.keyLocation;
		this.stateMask = e.stateMask;
		this.doit = e.doit;
	}

	public String toString() {
		String string = super.toString();
		return string.substring(0, string.length() - 1) // remove trailing '}'
				+ " character='" + ((character == 0) ? "\\0" : String.valueOf(character)) + "'=0x" + Integer.toHexString(character) + " keyCode=0x" + Integer.toHexString(keyCode) + " keyLocation=0x" + Integer.toHexString(keyLocation) + " stateMask=0x" + Integer.toHexString(stateMask)
				+ " doit="
				+ doit + "}";
	}
}
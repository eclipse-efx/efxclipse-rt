package org.eclipse.swt.events;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;

public class SelectionEvent extends TypedEvent {
	public Widget item;
	public int detail;
	public int x;
	public int y;
	public int width;
	public int height;
	public int stateMask;
	public String text;
	public boolean doit;
	static final long serialVersionUID = 3976735856884987953L;
	
	public SelectionEvent(Event e) {
		super(e);
		this.item = e.item;
		this.x = e.x;
		this.y = e.y;
		this.width = e.width;
		this.height = e.height;
		this.detail = e.detail;
		this.stateMask = e.stateMask;
		this.text = e.text;
		this.doit = e.doit;
	}
}

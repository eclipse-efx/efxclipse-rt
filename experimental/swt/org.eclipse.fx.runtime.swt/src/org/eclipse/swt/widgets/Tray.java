package org.eclipse.swt.widgets;

import org.eclipse.swt.internal.Util;

public class Tray extends Widget {

	Tray(Display display, int style) {
		super(display, style);
	}

	@Override
	protected Object createWidget() {
		Util.logNotImplemented();
		return null;
	}

	@Override
	public Object internal_getNativeObject() {
		Util.logNotImplemented();
		return null;
	}

	public TrayItem getItem (int index) {
		Util.logNotImplemented();
		return null;
	}
	
	public int getItemCount () {
		Util.logNotImplemented();
		return 0;
	}
	
	public TrayItem [] getItems () {
		Util.logNotImplemented();
		return new TrayItem[0];
	}
}

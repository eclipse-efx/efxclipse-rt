package org.eclipse.swt.events;

import org.eclipse.swt.internal.SWTEventListener;

public interface SelectionListener extends SWTEventListener {
	public void widgetSelected(SelectionEvent e);
	public void widgetDefaultSelected(SelectionEvent e);
}

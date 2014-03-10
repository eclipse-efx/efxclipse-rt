package org.eclipse.swt.events;

import org.eclipse.swt.internal.SWTEventListener;

public interface DisposeListener extends SWTEventListener {

	public void widgetDisposed(DisposeEvent e);
}

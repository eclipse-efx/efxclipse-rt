package org.eclipse.swt.events;

import org.eclipse.swt.internal.SWTEventListener;

public interface ControlListener extends SWTEventListener {

	public void controlMoved(ControlEvent e);

	public void controlResized(ControlEvent e);
}

package org.eclipse.swt.events;

import org.eclipse.swt.internal.SWTEventListener;

public interface TouchListener extends SWTEventListener {

	public void touch(TouchEvent e);
}
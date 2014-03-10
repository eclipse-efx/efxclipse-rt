package org.eclipse.swt.events;

import org.eclipse.swt.internal.SWTEventListener;

public interface MenuDetectListener extends SWTEventListener {

	public void menuDetected(MenuDetectEvent e);
}
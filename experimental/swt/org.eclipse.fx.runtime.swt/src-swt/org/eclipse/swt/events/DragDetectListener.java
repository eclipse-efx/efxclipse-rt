package org.eclipse.swt.events;

import org.eclipse.swt.internal.SWTEventListener;

public interface DragDetectListener extends SWTEventListener {

	public void dragDetected(DragDetectEvent e);
}
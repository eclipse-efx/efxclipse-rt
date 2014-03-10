package org.eclipse.swt.events;

import org.eclipse.swt.internal.SWTEventListener;

public interface PaintListener extends SWTEventListener {

	public void paintControl(PaintEvent e);
}
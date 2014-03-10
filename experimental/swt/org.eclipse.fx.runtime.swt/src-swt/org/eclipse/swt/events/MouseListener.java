package org.eclipse.swt.events;

import org.eclipse.swt.internal.SWTEventListener;

public interface MouseListener extends SWTEventListener {

	public void mouseDoubleClick(MouseEvent e);

	public void mouseDown(MouseEvent e);

	public void mouseUp(MouseEvent e);
}
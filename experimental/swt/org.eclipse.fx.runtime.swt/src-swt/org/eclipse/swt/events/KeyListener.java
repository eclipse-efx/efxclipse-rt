package org.eclipse.swt.events;

import org.eclipse.swt.internal.SWTEventListener;

public interface KeyListener extends SWTEventListener {

	public void keyPressed(KeyEvent e);

	public void keyReleased(KeyEvent e);
}
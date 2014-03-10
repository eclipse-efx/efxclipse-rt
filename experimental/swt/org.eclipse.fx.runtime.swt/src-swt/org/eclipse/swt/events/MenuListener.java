package org.eclipse.swt.events;

import org.eclipse.swt.internal.SWTEventListener;

public interface MenuListener extends SWTEventListener {
	public void menuHidden(MenuEvent e);

	public void menuShown(MenuEvent e);
}

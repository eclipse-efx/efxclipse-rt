package org.eclipse.swt.events;

import org.eclipse.swt.internal.SWTEventListener;

public interface FocusListener extends SWTEventListener {

	public void focusGained(FocusEvent e);

	public void focusLost(FocusEvent e);
}
package org.eclipse.swt.events;

import org.eclipse.swt.internal.SWTEventListener;

public interface HelpListener extends SWTEventListener {

	public void helpRequested(HelpEvent e);
}
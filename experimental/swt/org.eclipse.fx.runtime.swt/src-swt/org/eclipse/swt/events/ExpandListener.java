package org.eclipse.swt.events;

import org.eclipse.swt.internal.SWTEventListener;

public interface ExpandListener extends SWTEventListener {

	public void itemCollapsed(ExpandEvent e);

	public void itemExpanded(ExpandEvent e);
}
package org.eclipse.swt.events;

import org.eclipse.swt.internal.SWTEventListener;

public interface TreeListener extends SWTEventListener {

	public void treeCollapsed(TreeEvent e);

	public void treeExpanded(TreeEvent e);
}
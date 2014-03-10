package org.eclipse.swt.accessibility;

import org.eclipse.swt.internal.Util;
import org.eclipse.swt.widgets.ToolBar;

public class Accessible {

	public void addAccessibleListener(AccessibleListener accessibleListener) {
		Util.logNotImplemented();
	}

	public void addAccessibleAttributeListener(
			AccessibleAttributeListener accessibleAttributeAdapter) {
		Util.logNotImplemented();
	}

	public void sendEvent(int eventAttributeChanged, Object object) {
		Util.logNotImplemented();
	}

	public void setFocus(int childidSelf) {
		Util.logNotImplemented();
	}

	public void addAccessibleControlListener(
			AccessibleControlListener accessibleControlAdapter) {
		Util.logNotImplemented();
	}

	public ToolBar getControl() {
		Util.logNotImplemented();
		return null;
	}

	public void selectionChanged() {
		Util.logNotImplemented();
	}

}

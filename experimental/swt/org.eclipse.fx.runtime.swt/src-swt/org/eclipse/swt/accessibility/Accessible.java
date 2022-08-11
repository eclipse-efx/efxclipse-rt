/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
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

	public void removeAccessibleListener(AccessibleAdapter accessibleListener) {
		Util.logNotImplemented();
	}

}

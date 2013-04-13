/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.e4.controls.fx2;

import org.eclipse.fx.e4.controls.FXTab;

import javafx.beans.DefaultProperty;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.util.Callback;

/**
 * <p>Tabs are placed within a {@link FX2TabPane}, where each tab represents a single
 * 'page'.</p>
 * <p>Tabs can contain any {@link Node} such as UI controls or groups
 * of nodes added to a layout container.</p>
 * <p>When the user clicks
 * on a Tab in the TabPane the Tab content becomes visible to the user.</p>
 */
@DefaultProperty("content")
public class FX2Tab extends Tab implements FXTab {
	private Callback<Tab, Boolean> closeVetoHandler;
	
	public Callback<Tab, Boolean> getCloseVetoHandler() {
		return closeVetoHandler;
	}

	@Override
	public void setCloseVetoHandler(Callback<Tab, Boolean> closeVetoHandler) {
		this.closeVetoHandler = closeVetoHandler;
	}
}
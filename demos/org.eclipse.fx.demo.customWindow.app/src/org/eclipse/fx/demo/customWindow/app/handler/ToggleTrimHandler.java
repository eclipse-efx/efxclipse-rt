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
 
package org.eclipse.fx.demo.customWindow.app.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.menu.MToolItem;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

public class ToggleTrimHandler {
	
	@Execute
	public void execute(MToolItem item, EModelService modelService, MApplication application) {
		String side = item.getPersistedState().get("trim.side");
		toggleTrim(item, modelService, application, side);
	}

	private void toggleTrim(MToolItem item, EModelService modelService, MApplication application, String side) {
		MTrimBar trimBar = (MTrimBar)modelService.find("org.eclipse.fx.demo.customwindow.app.trimbar." + side, application);
		trimBar.setToBeRendered(!trimBar.isToBeRendered());
		if (trimBar.isToBeRendered()) {
			item.setLabel("Remove " + side + " trim");
		} else {
			item.setLabel("Add " + side + " trim");
		}
	}
		
}
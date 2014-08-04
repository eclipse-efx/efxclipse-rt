/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.testcases.e4.lifecycle;

import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.fx.ui.workbench.services.lifecycle.annotation.PreClose;
import org.eclipse.fx.ui.workbench.services.lifecycle.annotation.PreShow;

public class MenuLifecycle {
	
	private MDirectMenuItem ds;

	@PreClose
	void closeingMenu(MMenu m) {
		ds.getParent().getChildren().remove(ds);
	}
	
	@PreShow
	void openingMenu(MMenu m, EModelService ms) {
		ds = ms.createModelElement(MDirectMenuItem.class);
		ds.setLabel("Dynamic Item");
		m.getChildren().add(0,ds);
	}
}

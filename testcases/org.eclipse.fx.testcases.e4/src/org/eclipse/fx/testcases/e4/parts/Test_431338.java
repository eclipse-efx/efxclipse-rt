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
package org.eclipse.fx.testcases.e4.parts;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;

public class Test_431338 {
	@Inject
	MPart part;
	
	@PostConstruct
	void init(BorderPane parent) {
		Button b = new Button("Add ViewMenu");
		b.setOnAction(this::showHideViewMenu);
		
		parent.setCenter(b);
	}
	
	void showHideViewMenu(ActionEvent e) {
		if( ! part.getMenus().stream().filter(this::viewFilter).findFirst().isPresent() ) {
			MMenu m = MMenuFactory.INSTANCE.createMenu();
			m.getTags().add("ViewMenu");
			
			MDirectMenuItem mi = MMenuFactory.INSTANCE.createDirectMenuItem();
			mi.setLabel("Sample Item");
			m.getChildren().add(mi);
			part.getMenus().add(m);
		}
	}
	
	boolean viewFilter(MMenu m) {
		return m.getTags().contains("ViewMenu");
	}
	
	
}

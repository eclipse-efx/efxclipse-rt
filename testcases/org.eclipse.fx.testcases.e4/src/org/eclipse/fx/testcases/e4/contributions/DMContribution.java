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
package org.eclipse.fx.testcases.e4.contributions;

import java.util.List;

import org.eclipse.e4.ui.di.AboutToHide;
import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuItem;

public class DMContribution {
	@AboutToShow
	public void ats(List<MMenuItem> items){
//		menu.getChildren().remove(0); <--works
//		System.err.println(menu);
//		System.err.println("ATSH");
		for(int i=0 ; i< 1; i++) {
	           MDirectMenuItem menuItem = MMenuFactory.INSTANCE.createDirectMenuItem();
	           menuItem.setLabel("Test  menu " + i);
	           menuItem.setElementId("test.dynamicmenucontribution"+ i);
	           menuItem.setContributorURI("platform:/plugin/org.eclipse.fx.testcases.e4");
	           menuItem.setContributionURI("bundleclass://org.eclipse.fx.testcases.e4/org.eclipse.fx.testcases.e4.handlers.DynDiHandler");
	           items.add(menuItem);
	       }
	}
	
	@AboutToHide
	public void ath(List<MMenuItem> items){
		System.err.println(items.size());
		System.err.println("ATH");
	}

}
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


import javax.annotation.PostConstruct;

import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

import org.eclipse.e4.ui.di.Focus;

public class Test_431391 {
	private ListView<String> myList;
	
	@PostConstruct
	void init(BorderPane p) {
		p.setTop(new Label("Test Focus"));
		myList = new ListView<String>();
		myList.setItems(FXCollections.observableArrayList("A","B","C","D","E"));
		p.setCenter(myList);
	}
	
	@Focus
	void onFocus() {
		Thread.dumpStack();
		System.err.println("Focus is called!!!");
	}
}

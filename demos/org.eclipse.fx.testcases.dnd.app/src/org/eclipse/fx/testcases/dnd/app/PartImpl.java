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
package org.eclipse.fx.testcases.dnd.app;

import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;

public class PartImpl {
	private TextField f;

	@PostConstruct
	void init(BorderPane parent, MPart part) {
//		Label l = new Label(part.getLabel());
//		l.setFont(Font.font(30));
//		
//		parent.setCenter(l);
//		
//		f = new TextField();
//		parent.setBottom(f);
		ListView<String> l = new ListView<String>();
		l.setItems(FXCollections.observableArrayList("A","B","C"));
		parent.setCenter(l);
	}
	
//	@Focus
//	void focus() {
//		f.requestFocus();
//	}
}

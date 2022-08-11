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
package org.eclipse.fx.testcases.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MyController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.err.println("The controller is created!!!");
	}

	/**
	 * This the click 1 method
	 * 
	 * @param event
	 *            the event
	 */
	@FXML
	public void clicked(ActionEvent event) {
		System.err.println("Hello World");
	}

	/**
	 * This is the click 2 method
	 * 
	 * @param event
	 *            the event
	 */
	@FXML
	public void clicked2(ActionEvent event) {

	}

//	@FXML
//	public void clicked(String event) {
//
//	}

//	@FXML
//	public void clicked() {
//
//	}
}

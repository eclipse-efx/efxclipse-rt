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
package org.eclipse.fx.xtext.sample.editor.text;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SampleTextField extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane p = new BorderPane();
		
		TextField f = new TextField("I'm a text field");
		p.setCenter(f);
		
		primaryStage.setScene(new Scene(p));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

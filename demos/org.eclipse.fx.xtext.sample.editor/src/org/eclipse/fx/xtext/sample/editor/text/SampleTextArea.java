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
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SampleTextArea extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane p = new BorderPane();
		
		TextArea t = new TextArea();
		StringBuilder b = new StringBuilder();
		b.append("This is a multiline text\n");
		b.append("This is a multiline text\n");
		b.append("This is a multiline text\n");
		t.setText(b.toString());
		p.setCenter(t);
		
		primaryStage.setScene(new Scene(p));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

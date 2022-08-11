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

import org.eclipse.fx.ui.controls.styledtext.StyledLabel;
import org.eclipse.fx.ui.controls.styledtext.StyledString;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SampleStyledLabel extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane p = new BorderPane();
		
		StyledString ss = new StyledString();
		ss.appendSegment("Styled", "h1");
		ss.appendSegment("Label", "h1","colorful");
		
		StyledLabel l = new StyledLabel(ss);
		p.setCenter(l);
		
		Scene s = new Scene(p);
		s.getStylesheets().add(getClass().getResource("styled-string.css").toExternalForm());
		
		primaryStage.setScene(s);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

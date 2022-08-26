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

import org.eclipse.fx.ui.controls.styledtext.StyleRange;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SampleStyledTextArea extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane p = new BorderPane();
		
		StyledTextArea a = new StyledTextArea();
		a.getContent().setText("public class Sample {\n\n}");
		a.setStyleRanges(
				new StyleRange("keyword", 0, "public".length(), null, null),
				new StyleRange("keyword", "public".length()+1, "class".length(), null, null)
				);
		a.setLineRulerVisible(true);
		p.setCenter(a);
		
		Scene s = new Scene(p);
		s.getStylesheets().add(getClass().getResource("styled-text.css").toExternalForm());
		
		primaryStage.setScene(s);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

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
package org.eclipse.swt.snippets;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FXTest extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		final Tooltip t = new Tooltip();
		VBox box = new VBox();
		box.getChildren().add(new Label("Hello"));
		box.getChildren().add(new Label("World!"));
		t.setGraphic(box);
		
		Button b = new Button("Open Tooltip");
		b.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				t.show(primaryStage);
			}
		});
		
		Scene s = new Scene(b,400,400);
		primaryStage.setScene(s);
		primaryStage.show();
	}

}

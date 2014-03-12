/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SimpleTabFolder extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		ETabFolder f = new ETabFolder();
		
		{
			ETab t = new ETab("Tab 1");
			f.getTabs().add(t);			
		}
		
		{
			ETab t = new ETab("Tab 2");
			f.getTabs().add(t);			
		}
		
		primaryStage.setScene(new Scene(f,500,500));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}

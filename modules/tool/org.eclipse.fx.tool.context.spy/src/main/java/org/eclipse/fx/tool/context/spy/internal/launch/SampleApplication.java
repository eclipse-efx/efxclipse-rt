/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Thomas Fahrmeyer (lauritziu_ii@yahoo.de) - initial API and implementation
*/
package org.eclipse.fx.tool.context.spy.internal.launch;

import org.eclipse.fx.tool.context.spy.internal.model.ContextSpyModel;
import org.eclipse.fx.tool.context.spy.internal.view.ContextSpyView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SampleApplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		DummyContextProvider p = new DummyContextProvider();
		
		ContextSpyModel contextSpyModel = new ContextSpyModel();
		contextSpyModel.setContext(p.getApplicationContext());
		ContextSpyView contextSpyView = new ContextSpyView(contextSpyModel);
		
		primaryStage.setScene(new Scene(contextSpyView.getGui(),900,800));
		
		
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}

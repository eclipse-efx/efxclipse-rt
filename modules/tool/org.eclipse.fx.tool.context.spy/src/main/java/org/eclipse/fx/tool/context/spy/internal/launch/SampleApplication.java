/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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

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
package org.eclipse.fx.demo.osgi.di;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.ui.di.FXMLBuilder;
import org.eclipse.fx.ui.di.FXMLLoader;
import org.eclipse.fx.ui.di.FXMLLoaderFactory;

public class MainApplication {
	@Inject
	@FXMLLoader
	FXMLLoaderFactory loaderFactory;
	
	@PostConstruct
	void run(IApplicationContext applicationContext, javafx.application.Application jfxApplication, Stage primaryStage) {
		FXMLBuilder<BorderPane> loader = loaderFactory.loadRequestorRelative("ExampleGraph.fxml");
		try {
			BorderPane pane = loader.load();
			Scene s = new Scene(pane, 200, 200);
			primaryStage.setScene(s);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

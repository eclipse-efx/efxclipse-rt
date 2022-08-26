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
package org.eclipse.fx.ui.preferences.app;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.ui.preferences.PreferenceUI;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApplication {
	@Inject
	private IEclipseContext context;

	@Inject
	public MainApplication() {

	}

	@PostConstruct
	void run(IApplicationContext applicationContext, javafx.application.Application jfxApplication,
			Stage primaryStage) {

		BorderPane pane = new BorderPane();

		IEclipseContext preferenceCtx = context.createChild("Preference");
		preferenceCtx.set(BorderPane.class, pane);

		PreferenceUI prefUI = ContextInjectionFactory.make(PreferenceUI.class, preferenceCtx);
		prefUI.registerOnCancelHandler(page -> primaryStage.close());
		prefUI.registerOnOkHandler(page -> primaryStage.close());

		Scene s = new Scene(pane);
		primaryStage.setScene(s);
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.setTitle("Preference Sample");
		primaryStage.show();
	}
}

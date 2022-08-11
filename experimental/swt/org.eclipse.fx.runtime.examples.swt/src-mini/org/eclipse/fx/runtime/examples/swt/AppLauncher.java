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
package org.eclipse.fx.runtime.examples.swt;

import java.lang.reflect.Method;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppLauncher extends Application {
	private static String MAIN_CLASS;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.err.println("IN START");
		Method m = Class.forName(MAIN_CLASS).getMethod("main", new String[0].getClass());
		Object o = new String[0];
		m.invoke(null, o);
	}

	public static void main(String[] args) {
		MAIN_CLASS = args[0];
		launch(args);
	}
}

/*******************************************************************************
 * Copyright (c) 2013 Sopot Cela and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sopot Cela<sopotcela@gmail.com> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.testcases.e4.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;

public class DynamicWinHandler {

	@Execute
	public void test(MApplication app) {
		System.err.println("Adding a window... ");
		MWindow window = MBasicFactory.INSTANCE.createWindow();
		window.setX(0);
		window.setY(0);
		window.setWidth(500);
		window.setHeight(500);
		window.setLabel("Sopot");
		app.getChildren().add(window);
//		app.getChildren().remove(window);
	}
}
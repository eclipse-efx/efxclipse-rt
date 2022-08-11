/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.testcases.e4.handlers;

import javafx.stage.Stage;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.fx.ui.dialogs.MessageDialog;

public class DialogTest {
	@Execute
	void openDialog(Stage stage) {
		MessageDialog.openInformationDialog(stage, "Hello World!", "This is blocking!");
	}
}

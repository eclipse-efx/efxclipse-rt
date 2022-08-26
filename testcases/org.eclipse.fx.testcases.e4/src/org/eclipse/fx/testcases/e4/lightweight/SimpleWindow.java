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
package org.eclipse.fx.testcases.e4.lightweight;

import org.eclipse.fx.ui.controls.stage.DefaultFramePane;
import org.eclipse.fx.ui.panes.FillLayoutPane;

import javafx.scene.control.Button;

public class SimpleWindow extends DefaultFramePane {
	public SimpleWindow() {
		super(new FillLayoutPane(),true);
		setTitle("Bla Bla Bla");
		setClientArea(new Button("Hello World!!!!"));
		setMaxSize(500, 500);
	}
}

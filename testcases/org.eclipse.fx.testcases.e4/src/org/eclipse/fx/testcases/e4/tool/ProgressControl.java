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
package org.eclipse.fx.testcases.e4.tool;

import javax.annotation.PostConstruct;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;

public class ProgressControl {
	@PostConstruct
	public void init(Group g) {
		HBox b = new HBox();
		ProgressBar bar = new ProgressBar();
		b.getChildren().add(new Label("Bla Bla"));
		b.getChildren().add(bar);
		g.getChildren().add(b);
	}
}

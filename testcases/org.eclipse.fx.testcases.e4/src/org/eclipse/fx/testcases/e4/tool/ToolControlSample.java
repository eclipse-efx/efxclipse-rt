/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.testcases.e4.tool;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import javax.annotation.PostConstruct;

public class ToolControlSample {
	@PostConstruct
	void init(Group g) {
		HBox b = new HBox();
		b.getChildren().addAll(new Label("A Toolcontrol"),new TextField());
		g.getChildren().add(b);
	}
}

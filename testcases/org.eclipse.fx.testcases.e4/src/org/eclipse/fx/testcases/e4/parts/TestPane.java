/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.testcases.e4.parts;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import javax.annotation.PostConstruct;

public class TestPane {
	@PostConstruct
	void init(VBox vbox) {
		vbox.getChildren().add(new Button("VBox"));
	}
}

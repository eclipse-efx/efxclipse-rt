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

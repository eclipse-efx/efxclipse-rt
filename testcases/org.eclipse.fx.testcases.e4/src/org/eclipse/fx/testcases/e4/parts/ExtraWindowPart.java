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
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.testcases.e4.parts;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;

public class ExtraWindowPart {
	@PostConstruct
	void init(BorderPane parent) {
		parent.setCenter(new Label("I'm in an extra window"));
	}
}

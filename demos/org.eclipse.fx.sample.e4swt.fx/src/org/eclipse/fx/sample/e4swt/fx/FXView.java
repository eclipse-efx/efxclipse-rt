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
package org.eclipse.fx.sample.e4swt.fx;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;

public class FXView {
	@PostConstruct
	void init(BorderPane p) {
		p.setCenter(new Button("Hello JavaFX!"));
	}
}

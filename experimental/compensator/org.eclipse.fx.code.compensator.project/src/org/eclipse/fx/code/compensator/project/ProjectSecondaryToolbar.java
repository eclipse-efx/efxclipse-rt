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
package org.eclipse.fx.code.compensator.project;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;

public class ProjectSecondaryToolbar {
	@PostConstruct
	public void init(BorderPane parent) {
		parent.setTop(new Label("2nd TB"));
	}

}

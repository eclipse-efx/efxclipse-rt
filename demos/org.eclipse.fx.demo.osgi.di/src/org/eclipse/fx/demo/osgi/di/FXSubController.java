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
package org.eclipse.fx.demo.osgi.di;

import javafx.fxml.FXML;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;

@SuppressWarnings("restriction")
public class FXSubController {
	@Inject
	private PrintService service;
	
	@PostConstruct
	void created(IEclipseContext context) {
		System.err.println("Subcontroller post construction");
	}
	
	@FXML
	void initialize() {
		System.err.println("Subcontroller controller");
	}
	
	@FXML
	void sayHello() {
		service.print("Subcontroller - Hello World!");
	}
}

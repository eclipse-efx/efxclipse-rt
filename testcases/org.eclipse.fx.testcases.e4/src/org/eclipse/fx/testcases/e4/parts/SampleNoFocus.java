/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
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

import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;

public class SampleNoFocus {
	private BorderPane p;
	
	@PostConstruct
	void init(BorderPane p) {
		this.p = p;
		p.setCenter(new Rectangle(0,0,200,200));
	}
	
	@Focus
	void setFocus() {
		System.err.println("REQUESTING FOCUS");
		p.requestFocus();
	}

}

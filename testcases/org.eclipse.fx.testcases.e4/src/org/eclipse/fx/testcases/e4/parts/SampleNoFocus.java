/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

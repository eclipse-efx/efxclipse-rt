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
package org.eclipse.fx.testcases.fxgraph;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Button;

public class MyButton extends Button {
	private SimpleDoubleProperty scaleFactor = new SimpleDoubleProperty(this,
			"scaleFactor", 1.0);

	public MyButton() {
		setText("This is my bu");
	}
	
	public final SimpleDoubleProperty scaleFactorProperty() {
		return scaleFactor;
	}

	public double getScaleFactor() {
		return scaleFactor.get();
	}

	public void setScaleFactor(double scale) {
		scaleFactor.set(scale);
	}
}

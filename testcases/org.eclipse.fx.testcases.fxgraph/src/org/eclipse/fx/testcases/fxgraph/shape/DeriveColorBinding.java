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
package org.eclipse.fx.testcases.fxgraph.shape;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.value.ObservableDoubleValue;
import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;

public class DeriveColorBinding extends ObjectBinding<Color> {
	
	private ObservableValue<Color> sourceColor;
	private ObservableDoubleValue hueShift;
	private ObservableDoubleValue saturationFactor;
	private ObservableDoubleValue brightnessFactor;
	private ObservableDoubleValue opacityFactor;
	
	public DeriveColorBinding(
			ObservableValue<Color> sourceColor, 
			ObservableDoubleValue hueShift,
			ObservableDoubleValue saturationFactor,
			ObservableDoubleValue brightnessFactor,
			ObservableDoubleValue opacityFactor
			) {
		this.sourceColor = sourceColor;
		this.hueShift = hueShift;
		this.saturationFactor = saturationFactor;
		this.brightnessFactor = brightnessFactor;
		this.opacityFactor = opacityFactor;
		bind(sourceColor, hueShift, saturationFactor, brightnessFactor, opacityFactor);
	}
	
	@Override
	protected Color computeValue() {
		Color c = sourceColor.getValue().deriveColor(
				hueShift.getValue().doubleValue(), 
				saturationFactor.getValue().doubleValue(), 
				brightnessFactor.getValue().doubleValue(), opacityFactor.getValue().doubleValue());
		return c;
	}
	
	public static DeriveColorBinding create(
			ObservableValue<Color> sourceColor, 
			ObservableDoubleValue hueShift,
			ObservableDoubleValue saturationFactor,
			ObservableDoubleValue brightnessFactor,
			ObservableDoubleValue opacityFactor) {
		return new DeriveColorBinding(sourceColor,hueShift,saturationFactor,brightnessFactor,opacityFactor);
	}
	
	

}

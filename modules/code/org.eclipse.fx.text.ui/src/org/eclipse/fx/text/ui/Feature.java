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
package org.eclipse.fx.text.ui;

import java.util.function.Supplier;

import org.eclipse.fx.text.ui.internal.InvisibleCharSupport;
import org.eclipse.fx.text.ui.internal.LineNumberSupport;

public enum Feature {
	SHOW_LINE_NUMBERS(()->new LineNumberSupport()),
	SHOW_HIDDEN_SYMBOLS(()->new InvisibleCharSupport());


	private Supplier<IFeature> featureFactory;
	private Feature(Supplier<IFeature> featureFactory) {
		this.featureFactory = featureFactory;
	}

	public Supplier<IFeature> getFeatureFactory() {
		return featureFactory;
	}

}

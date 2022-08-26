/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
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
package org.eclipse.fx.ui.animation;

import javafx.animation.Transition;
import javafx.beans.property.DoubleProperty;
import javafx.util.Duration;

/**
 * Transition updating a double property
 */
public class DoublePropertyTransition extends Transition {
	private final DoubleProperty p;
	private double from;
	private double delta;

	/**
	 * Create a new transition
	 * 
	 * @param p
	 *            the double property to update
	 * @param duration
	 *            the duration
	 * @param from
	 *            the start value
	 * @param to
	 *            the end value
	 */
	public DoublePropertyTransition(DoubleProperty p, Duration duration, double from, double to) {
		this.p = p;
		setCycleDuration(duration);
		this.delta = to - from;
	}

	@Override
	protected void interpolate(double frac) {
		this.p.set(this.from + this.delta * frac);
	}

}

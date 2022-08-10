/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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
import javafx.util.Duration;

/**
 * Base class for transitions (current useage is for Nashorn transitions because
 * they can not access the protected final method
 * <code>Animation#setCycleDuration</code>)
 */
public abstract class BaseTransition extends Transition {
	/**
	 * Create a transition with a predefined duration
	 * 
	 * @param duration
	 *            the duration
	 */
	public BaseTransition(Duration duration) {
		setCycleDuration(duration);
	}
}

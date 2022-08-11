/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Sun Volland<sun.volland@free.fr>
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.base.services;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Maximization service interface
 *
 * @since 2.2.0
 */
public interface MaximizationService {
	/**
	 * Maximize an UI element
	 *
	 * @param element
	 *            element to maximize
	 */
	void maximize(@NonNull MUIElement element);

	/**
	 * Restore to the default state
	 */
	void restore();

	/**
	 * Checks whether the given element is currently maximized
	 *
	 * @param element
	 *            element to check
	 * @return {@code true} if the element is maximized, {@code false} if not
	 */
	boolean isMaximized(@NonNull MUIElement element);

}

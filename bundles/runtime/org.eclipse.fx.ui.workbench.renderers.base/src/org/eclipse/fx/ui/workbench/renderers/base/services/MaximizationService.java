/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 */
public interface MaximizationService {
	/**
	 * Maximize an UI element
	 * 
	 * @param element element to maximize
	 */
	void maximize(@NonNull MUIElement element);
	
	/**
	 * Unmaximize current maximized element.
	 */
	void unMaximize();
	
	/**
	 * Checks whether the given element is currently maximized
	 * 
	 * @param element element to check
	 * @return {@code true} if the element is maximized, {@code false} if not
	 */
	boolean isMaximized(@NonNull MUIElement element);
	
}

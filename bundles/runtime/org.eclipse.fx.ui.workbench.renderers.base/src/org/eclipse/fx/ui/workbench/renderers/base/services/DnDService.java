/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.base.services;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Service to constraint drag and drop operations
 */
public interface DnDService {
	/**
	 * Check if a split is allowed
	 * 
	 * @param element
	 *            the element
	 * @return <code>true</code> if a split is allowed
	 */
	public boolean splitAllowed(@NonNull MUIElement element);

	/**
	 * Check if a detach is allowed
	 * 
	 * @param element
	 *            the element to detach
	 * @return <code>true</code> if a detach is allowed
	 */
	public boolean detachAllowed(@NonNull MUIElement element);

	/**
	 * Check if we can reparent the element
	 * 
	 * @param element
	 *            the element
	 * @return <code>true</code> if a reparent is allowed
	 */
	public boolean repartentAllowed(@NonNull MUIElement element);

	/**
	 * Handle the detaching of an element
	 * 
	 * @param sourceElement
	 *            the source element
	 * @return <code>true</code> if detaching is handled
	 */
	public boolean handleDetach(@NonNull MUIElement sourceElement);
}

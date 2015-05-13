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
package org.eclipse.fx.ui.workbench.services;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Service used to handle model stuff
 * 
 * @noimplement
 * @since 2.0
 */
public interface ModelService {
	/**
	 * Get global unique identifier for the given model element
	 * 
	 * @param element
	 *            the element
	 * @return the unique identifier
	 */
	public @NonNull String getUniqueId(@NonNull MApplicationElement element);

	/**
	 * Get the real element for the given id
	 * 
	 * @param m
	 *            the application element
	 * @param uniqueId
	 *            the unique id
	 * @return the instance or <code>null</code> if not found
	 */
	public @Nullable <M extends MApplicationElement> M getElementInstance(@NonNull MApplication m, @NonNull String uniqueId);
}

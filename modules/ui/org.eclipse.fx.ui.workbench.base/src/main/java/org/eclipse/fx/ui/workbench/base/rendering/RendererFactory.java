/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
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
package org.eclipse.fx.ui.workbench.base.rendering;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Factory to createing renderers for give elements
 */
public interface RendererFactory {
	/**
	 * Get the renderer responsible for the model element
	 * 
	 * @param element
	 *            the model element
	 * @param <R>
	 *            the renderer type
	 * @return the renderer
	 */
	public <R extends ElementRenderer<@NonNull ?, ?>> @Nullable R getRenderer(MUIElement element);
}
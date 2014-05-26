/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.base.rendering;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Base interface implemented by all renderers
 * 
 * @param <M>
 *            the model element type
 * @param <C>
 *            the control/widget type
 */
public interface ElementRenderer<M extends MUIElement, C> {
	@NonNull
	public C createWidget(@NonNull M element);

	public IEclipseContext setupRenderingContext(@NonNull M element);

	public void bindWidget(@NonNull M element, @NonNull C widget);

	public void processContent(@NonNull M element);

	public void postProcess(@NonNull M element);

	public void childRendered(@NonNull M parentElement, @NonNull MUIElement element);

	public void preDestroy(@NonNull M element);

	public void hideChild(@NonNull M container, @NonNull MUIElement changedObj);

	public void destroyWidget(@NonNull M element);

	public IEclipseContext getModelContext(@NonNull MUIElement part);

	public void focus(@NonNull MUIElement element);

	public C getWidget(@NonNull M element);

}
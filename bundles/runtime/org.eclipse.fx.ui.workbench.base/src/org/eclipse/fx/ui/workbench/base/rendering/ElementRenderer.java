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
	public C createWidget(@NonNull M element);

	public IEclipseContext setupRenderingContext(M element);

	public void bindWidget(M element, C widget);

	public void processContent(M element);

	public void postProcess(M element);

	public void childRendered(M parentElement, MUIElement element);

	public void preDestroy(M element);

	public void hideChild(M container, MUIElement changedObj);

	public void destroyWidget(M element);

	public IEclipseContext getModelContext(MUIElement part);

	public void focus(MUIElement element);

	public C getWidget(M element);

}
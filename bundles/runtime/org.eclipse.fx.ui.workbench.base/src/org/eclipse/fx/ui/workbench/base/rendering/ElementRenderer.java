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
import org.eclipse.jdt.annotation.Nullable;

/**
 * Base interface implemented by all renderers
 * 
 * @param <M>
 *            the model element type
 * @param <C>
 *            the control/widget type
 */
public interface ElementRenderer<@NonNull M extends MUIElement, C> {
	/**
	 * Create the widget for the given model element
	 * 
	 * @param element
	 *            the model element
	 * @return the widget created
	 */
	public @NonNull C createWidget(@NonNull M element);

	/**
	 * Setup the context for rendering the element
	 * 
	 * @param element
	 *            the element
	 * @return the context
	 */
	public IEclipseContext setupRenderingContext(@NonNull M element);

	/**
	 * Bind the widget and the element together
	 * 
	 * @param element
	 *            the element
	 * @param widget
	 *            the widget
	 */
	public void bindWidget(@NonNull M element, @NonNull C widget);

	/**
	 * Process the elements content
	 * 
	 * @param element
	 *            the element
	 */
	public void processContent(@NonNull M element);

	/**
	 * Post process the element
	 * 
	 * @param element
	 *            the element
	 */
	public void postProcess(@NonNull M element);

	/**
	 * Inform the that a direct child of the parentElement has been rendered
	 * 
	 * @param parentElement
	 *            the parent
	 * @param element
	 *            the child rendered
	 */
	public void childRendered(@NonNull M parentElement, @NonNull MUIElement element);

	/**
	 * Inform about destruction of the element
	 * 
	 * @param element
	 *            the element
	 */
	public void preDestroy(@NonNull M element);

	/**
	 * Hide the child of the element
	 * 
	 * @param parent
	 *            the element container
	 * @param element
	 *            the element to hide
	 */
	public void hideChild(@NonNull M parent, @NonNull MUIElement element);

	/**
	 * Destroy the widget associated with the element
	 * 
	 * @param element
	 *            the element
	 */
	public void destroyWidget(@NonNull M element);

	/**
	 * Retrieve the model context for the given element
	 * 
	 * @param element
	 *            the element
	 * @return the context
	 */
	public @Nullable IEclipseContext getModelContext(@NonNull MUIElement element);

	/**
	 * Focus the given element
	 * 
	 * @param element
	 *            the element to focus
	 */
	public void focus(@NonNull MUIElement element);

	/**
	 * Get the widget for the given elemenet
	 * 
	 * @param element
	 *            the element
	 * @return the widget
	 */
	public @Nullable C getWidget(@NonNull M element);

}
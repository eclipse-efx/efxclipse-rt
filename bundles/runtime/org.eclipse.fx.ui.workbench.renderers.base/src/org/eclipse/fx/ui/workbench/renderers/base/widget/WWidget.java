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
package org.eclipse.fx.ui.workbench.renderers.base.widget;

import java.util.List;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Basic native widget abstraction
 * 
 * @param <M>
 *            the model element
 */
public interface WWidget<M extends MUIElement> {
	/**
	 * Current state of the widget
	 */
	public enum WidgetState {
		/**
		 * widget is currently in setup phase
		 */
		IN_SETUP,
		/**
		 * widget is fully created
		 */
		CREATED,
		/**
		 * widget is in tear down phase
		 */
		IN_TEAR_DOWN,
		/**
		 * widget is fully disposed
		 */
		DISPOSED
	}

	/**
	 * Updating the widget state
	 * 
	 * @param state
	 *            the new state
	 */
	public void setWidgetState(@NonNull WidgetState state);

	/**
	 * @return the current widget state
	 */
	@NonNull
	public WidgetState getWidgetState();

	/**
	 * Set a handler informed about a property change
	 * 
	 * @param handler
	 *            the handler
	 */
	public void setPropertyChangeHandler(@NonNull WPropertyChangeHandler<? extends WWidget<M>> handler);

	/**
	 * Set the associated application model element
	 * 
	 * @param domElement
	 *            the dom element
	 */
	public void setDomElement(@NonNull M domElement);

	/**
	 * @return access the associated application model element
	 */
	@Nullable
	public M getDomElement();

	/**
	 * Add a list of style class names used for a CSS class-Selector in your css
	 * 
	 * @param classnames
	 *            list of classnames
	 */
	public void addStyleClasses(@NonNull List<String> classnames);

	/**
	 * A styleclass names used for a CSS class-Selector in your css
	 * 
	 * @param classnames
	 *            the classnames to add
	 */
	public void addStyleClasses(@NonNull String... classnames);

	/**
	 * Set a style id used for an CSS ID-Selector in your css
	 * 
	 * @param id
	 */
	public void setStyleId(@NonNull String id);

	/**
	 * @return the native widget
	 */
	@NonNull
	public Object getWidget();

	/**
	 * deactivate the control tree
	 */
	public void deactivate();

	/**
	 * activate the control tree
	 */
	public void activate();

	/**
	 * @return check if this control tree is active
	 */
	public boolean isActive();

	/**
	 * Register a callback to get informed when this widget gets activated
	 * 
	 * @param callback the callback
	 */
	public void registerActivationCallback(@NonNull WCallback<Boolean, Void> callback);
}

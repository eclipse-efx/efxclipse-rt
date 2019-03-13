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
package org.eclipse.fx.ui.workbench.renderers.base.widget;

import org.eclipse.e4.ui.model.application.ui.MUIElement;

/**
 * Basic interface for widgets supporting a maximized content
 * 
 */
public interface WMaximizationHost {

	/**
	 * 
	 */
	public enum Location {
		/**
		 * Display on the left side of the owner
		 */
		UPPER_LEFT,
		/**
		 * Display on the right side of the owner
		 */
		UPPER_RIGHT
	}

	/**
	 * Maximizes a widget
	 * 
	 * @param widget
	 *            widget to maximize
	 */
	void setMaximizedContent(WLayoutedWidget<? extends MUIElement> widget);

	/**
	 * Remove maximized content
	 */
	void removeMaximizedContent();

	/**
	 * @return <code>true</code> if partial restoring is supported
	 * @since 3.5.0
	 */
	default boolean supportPartialRestore() {
		return false;
	}

	/**
	 * Add a widget who is partially restored
	 * 
	 * @param widget
	 *            the widget
	 * @param location
	 *            the location
	 * @since 3.5.0
	 */
	default void addPartialWidget(WLayoutedWidget<? extends MUIElement> widget, Location location) {
		// nothing by default
	}

	/**
	 * Remove the partially restore widget
	 * 
	 * @param widget
	 *            the widget
	 * @since 3.5.0
	 */
	default void removePartialWidget(WLayoutedWidget<? extends MUIElement> widget) {
		// nothing by default
	}
}

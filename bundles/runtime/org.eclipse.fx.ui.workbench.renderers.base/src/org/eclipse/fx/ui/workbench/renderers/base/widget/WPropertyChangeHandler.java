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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Inform about a property change
 * 
 * @param <W>
 *            the widget type
 */
@FunctionalInterface
public interface WPropertyChangeHandler<W extends WWidget<?>> {
	/**
	 * Event object with informations about the property change
	 * 
	 * @param <W>
	 *            the widget type
	 */
	public static class WPropertyChangeEvent<W extends WWidget<?>> {
		/**
		 * Name of the property
		 */
		@NonNull 
		public final String propertyname;
		/**
		 * The widget
		 */
		@NonNull 
		public final W widget;
		/**
		 * The new value
		 */
		@Nullable
		public final Object newValue;

		/**
		 * Create an event
		 * 
		 * @param widget
		 *            the widget
		 * @param propertyname
		 *            the property name
		 * @param newValue
		 *            the new value
		 */
		public WPropertyChangeEvent(@NonNull W widget, @NonNull String propertyname, @Nullable Object newValue) {
			this.widget = widget;
			this.propertyname = propertyname;
			this.newValue = newValue;
		}
	}

	/**
	 * Called when a property is modified
	 * 
	 * @param event
	 *            the event
	 */
	public void propertyObjectChanged(@NonNull WPropertyChangeEvent<W> event);
}

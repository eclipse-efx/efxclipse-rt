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
package org.eclipse.fx.ui.workbench.renderers.base.widget;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Mixin for widgets who support min/max
 */
public interface WMinMaxableWidget {
	/**
	 * The current state
	 */
	public enum WMinMaxState {
		/**
		 * Toggle the state
		 */
		TOGGLE,
		/**
		 * Maximized
		 */
		MAXIMIZE,
		/**
		 * Restored
		 */
		RESTORE,
		/**
		 * Minimize
		 */
		MINIMIZE
	}

	/**
	 * 
	 */
	public enum WMinMaxWidgetState {
		/**
		 * Minimize
		 */
		MINIMIZED,
		/**
		 * Maximize
		 */
		MAXIMIZED,
		/**
		 * Default
		 */
		DEFAULT,
		/**
		 * None
		 */
		NONE
	}

	/**
	 * Set callback to be invoked when the state changes
	 *
	 * @param minMaxCallback
	 *            the callback
	 */
	public void setMinMaxCallback(@NonNull WCallback<WMinMaxState, Void> minMaxCallback);

	/**
	 * Set the actual state
	 * 
	 * @param state
	 */
	@Deprecated
	public void setMinMaxState(@NonNull WMinMaxState state);

	/**
	 * Update the widget state
	 * 
	 * @param state
	 *            the new state
	 */
	public default void setMinMaxState(@NonNull WMinMaxWidgetState state) {
		// nothing
	}
}

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
		RESTORE
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
	 * @param state
	 */
	public void setMinMaxState(@NonNull WMinMaxState state);
}

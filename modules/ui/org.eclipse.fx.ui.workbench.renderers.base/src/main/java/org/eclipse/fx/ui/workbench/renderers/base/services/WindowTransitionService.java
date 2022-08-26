/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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
package org.eclipse.fx.ui.workbench.renderers.base.services;

import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Service for window transition effects (hiding/showing)
 * 
 * @param <C>
 *            the native type
 */
public interface WindowTransitionService<C> {
	/**
	 * Delegate to do the animation
	 * 
	 * @param <C>
	 *            the native type
	 */
	public interface AnimationDelegate<C> {
		/**
		 * Animate the window
		 * 
		 * @param window
		 *            the window to animate
		 * @param finished
		 *            callback invoked when the animation is finished
		 */
		public void animate(@NonNull C window, @NonNull Runnable finished);
	}

	/**
	 * Create a delegate to show the given window
	 * 
	 * @param window
	 *            the window element
	 * @return the delegate or <code>null</code>
	 */
	@Nullable
	public AnimationDelegate<C> getShowDelegate(@NonNull MWindow window);

	/**
	 * Create a delegate to hide the given window
	 * 
	 * @param window
	 *            the window element
	 * @return the delegate or <code>null</code>
	 */
	@Nullable
	public AnimationDelegate<C> getHideDelegate(@NonNull MWindow window);
}

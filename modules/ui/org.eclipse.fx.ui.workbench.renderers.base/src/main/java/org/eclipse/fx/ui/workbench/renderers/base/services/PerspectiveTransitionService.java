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
package org.eclipse.fx.ui.workbench.renderers.base.services;

import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Service for perspective transition effects
 * 
 * @param <P>
 *            the native container type
 * @param <C>
 *            the native control type
 */
public interface PerspectiveTransitionService<P, C> {
	/**
	 * Create a delegate animate the switch between perspectives
	 * 
	 * @param fromPerspective
	 *            the perspective hidden
	 * @param toPerspective
	 *            the perspective shown
	 * @return the delegate or <code>null</code>
	 */
	@Nullable
	public AnimationDelegate<P, C> getDelegate(@NonNull MPerspective fromPerspective, @NonNull MPerspective toPerspective);

	/**
	 * Delegate to animate between the 2 native controls
	 * 
	 * @param <P>
	 *            the native container type
	 * @param <C>
	 *            the native control
	 */
	public interface AnimationDelegate<P, C> {
		/**
		 * Animate the control
		 * 
		 * @param container
		 *            the container
		 * @param control
		 *            the native control to be shown
		 * @param finished
		 *            callback invoked when the animation is finished
		 */
		public void animate(@NonNull P container, @NonNull C control, @NonNull Runnable finished);
	}
}
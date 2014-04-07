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
		 */
		public void animate(@NonNull P container, @NonNull C control);
	}
}
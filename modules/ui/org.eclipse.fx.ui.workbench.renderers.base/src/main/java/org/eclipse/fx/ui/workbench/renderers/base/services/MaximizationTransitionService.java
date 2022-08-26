/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Sun Volland<sun.volland@free.fr>
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.base.services;

/**
 * Interface for implementing a maximization transition.
 *
 * @param <C>
 *            Container type
 * @param <N>
 *            Maximizable node type
 * @since 2.2.0
 */
public interface MaximizationTransitionService<C, N> {

	/**
	 * Perform a maximize transition
	 *
	 * @param commonRoot
	 *            Common ancestor component of maxContainer and node
	 * @param greyPane
	 *            Pane used to mask maximized container background
	 * @param maxContainer
	 *            Target container that will finally host maximized node
	 * @param node
	 *            Node to maximize
	 * @param finished
	 *            Must be run when animation is finished
	 */
	void maximize(C commonRoot, C greyPane, C maxContainer, N node, Runnable finished);

	/**
	 * Perform a transition to the default state
	 *
	 *
	 * @param commonRoot
	 *            Common ancestor component of maxContainer and targetContainer
	 * @param greyPane
	 *            Pane used to mask maximized container background
	 * @param maxContainer
	 *            Container hosting maximized node
	 * @param targetContainer
	 *            Container that will finally host node
	 * @param node
	 *            Node to unmaximize
	 * @param finished
	 *            Must be run when animation is finished
	 */
	void restore(C commonRoot, C greyPane, C maxContainer, C targetContainer, N node, Runnable finished);
}

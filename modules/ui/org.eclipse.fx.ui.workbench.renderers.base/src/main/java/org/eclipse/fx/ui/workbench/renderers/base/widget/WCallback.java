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

/**
 * Callback
 * 
 * @param <P>
 *            the parameter
 * @param <R>
 *            the return value
 */
@FunctionalInterface
public interface WCallback<P, R> {
	/**
	 * Callback method
	 * 
	 * @param param
	 *            the parameter
	 * @return the return value
	 */
	public R call(P param);
}

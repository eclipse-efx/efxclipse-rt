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
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.function;

/**
 * Operation that accepts a single value and produces one
 *
 * @param <V>
 *            the value passed
 * @param <R>
 *            the value returned
 * @since 1.2
 */
@FunctionalInterface
public interface ExFunction<V, R> {
	/**
	 * Called to apply the operation on the given value
	 *
	 * @param value
	 *            the value
	 * @return the value returned
	 * @throws Throwable
	 *             exception if something goes wrong
	 */
	public R wrappedApply(V value) throws Throwable;
}

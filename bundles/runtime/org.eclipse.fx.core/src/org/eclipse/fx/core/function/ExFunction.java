/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
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

import java.util.function.BiFunction;

/**
 * Represents a function that accepts a two double-valued argument and produces
 * a result. This is the {@code double}-consuming primitive specialization for
 * {@link BiFunction}.
 *
 * @param <R>
 *            the type of the result of the function
 * @since 3.0
 */
@FunctionalInterface
public interface BiDoubleFunction<R> {
	/**
	 * Applies this function to the given arguments.
	 *
	 * @param t
	 * @param u
	 * @return the function result
	 */
	public R apply(double t, double u);

}

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

import java.util.function.IntPredicate;

/**
 * Like {@link IntPredicate} but with 2 arguments
 *
 * @since 3.0
 */
public interface BiIntPredicate {
	/**
	 * Evaluates this predicate on the given arguments.
	 *
	 * @param t
	 *            the first argument
	 * @param u
	 *            the second argument
	 * @return {@code true} if the input arguments matches the predicate,
	 *         otherwise {@code false}
	 */
	public boolean test(int t, int u);
}

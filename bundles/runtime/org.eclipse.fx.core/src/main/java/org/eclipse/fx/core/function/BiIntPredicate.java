/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

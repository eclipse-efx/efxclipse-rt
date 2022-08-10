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

import java.util.function.IntUnaryOperator;

/**
 * Like {@link IntUnaryOperator} but with 2 arguments
 *
 * @since 3.0
 */
public interface BiIntUnaryOperator {
	/**
	 * Applies this operator to the given operands.
	 *
	 * @param t
	 *            the first operand
	 * @param u
	 *            the second operand
	 * @return the operator result
	 */
	public int applyAsInt(int t, int u);
}

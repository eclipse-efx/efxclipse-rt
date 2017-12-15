/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core;

/**
 * Utilities to deal with numbers
 *
 * @since 3.0
 */
public class NumberUtils {
	/**
	 * Constraint the given value to the upper and lower bound
	 *
	 * @param v
	 *            the value to constraint
	 * @param min
	 *            the lower bound (only values &gt;= 0 are applied)
	 * @param max
	 *            the upper bound (only values &gt;= 0 are applied)
	 * @return the value
	 * @since 2.2.0
	 */
	public static double unsignedConstraintValue(double v, double min, double max) {
		double rv = v;
		if (min >= 0) {
			rv = Math.max(rv, min);
		}

		if (max >= 0) {
			rv = Math.min(rv, max);
		}
		return rv;
	}
}

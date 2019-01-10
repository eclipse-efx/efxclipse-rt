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

import com.google.common.math.DoubleMath;

/**
 * Utilities to deal with numbers
 *
 * @since 3.0
 */
public class NumberUtils {
	/**
	 * Constraint the given value to the upper and lower bound
	 *
	 * @param v   the value to constraint
	 * @param min the lower bound (only values >= 0 are applied)
	 * @param max the upper bound (only values >= 0 are applied)
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

	/**
	 * Compare 2 doubles using {@link Double#compare(double, double)}
	 * 
	 * @param d1 the first double
	 * @param d2 the second double
	 * @return the result
	 * @since 3.5.0
	 */
	public static boolean equals(double d1, double d2) {
		return Double.compare(d1, d2) == 0;
	}
	
	/**
	 * Compare 2 doubles using {@link Double#compare(double, double)}
	 * 
	 * @param d1 the first double
	 * @param d2 the second double
	 * @return the result
	 * @since 3.5.0
	 */
	public static boolean notEquals(double d1, double d2) {
		return ! equals(d1, d2);
	}

	/**
	 * Compare 2 doubles if they are equal if the delta is less than 0.01
	 * 
	 * @param d1 the first double
	 * @param d2 the second double
	 * @return the result
	 * @since 3.5.0
	 */
	public static boolean fuzzyEquals(double d1, double d2) {
		return DoubleMath.fuzzyEquals(d1, d2, 0.01);
	}
	
	/**
	 * Compare 2 doubles if they are NOT equal if the delta is less than 0.01
	 * 
	 * @param d1 the first double
	 * @param d2 the second double
	 * @return the result
	 * @since 3.5.0
	 */
	public static boolean fuzzyNotEquals(double d1, double d2) {
		return ! fuzzyEquals(d1, d2);
	}
}

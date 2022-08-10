/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
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
package org.eclipse.fx.core;

/**
 * A value class holding 2 integers
 *
 * @since 2.4.0
 */
public class IntTuple {
	/**
	 * Value 1
	 */
	public final int value1;
	/**
	 * Value 2
	 */
	public final int value2;

	/**
	 * Create a new tuple
	 *
	 * @param value1
	 *            the first value
	 * @param value2
	 *            the second value
	 */
	public IntTuple(int value1, int value2) {
		this.value1 = value1;
		this.value2 = value2;
	}
}

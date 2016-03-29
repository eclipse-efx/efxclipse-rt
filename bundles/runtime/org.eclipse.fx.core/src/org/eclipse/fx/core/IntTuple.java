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

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
 * A value class holding 2 values
 *
 * @param <U>
 *            type of value 1
 * @param <V>
 *            type of value 2
 * @since 2.4.0
 */
public final class Duple<U, V> {
	/**
	 * Value 1
	 */
	public final U value1;
	/**
	 * Value 2
	 */
	public final V value2;

	/**
	 * Create a new instance
	 *
	 * @param value1
	 *            the value
	 * @param value2
	 *            the value
	 */
	public Duple(U value1, V value2) {
		this.value1 = value1;
		this.value2 = value2;
	}
}

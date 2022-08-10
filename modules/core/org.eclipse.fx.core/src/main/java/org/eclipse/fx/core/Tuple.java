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
 * A value class holding 2 values
 *
 * @param <U>
 *            type of value 1
 * @param <V>
 *            type of value 2
 * @since 2.4.0
 */
public final class Tuple<U, V> {
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
	public Tuple(U value1, V value2) {
		this.value1 = value1;
		this.value2 = value2;
	}

	@SuppressWarnings("null")
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.value1 == null) ? 0 : this.value1.hashCode());
		result = prime * result + ((this.value2 == null) ? 0 : this.value2.hashCode());
		return result;
	}

	@SuppressWarnings("null")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuple<?,?> other = (Tuple<?,?>) obj;
		if (this.value1 == null) {
			if (other.value1 != null)
				return false;
		} else if (!this.value1.equals(other.value1))
			return false;
		if (this.value2 == null) {
			if (other.value2 != null)
				return false;
		} else if (!this.value2.equals(other.value2))
			return false;
		return true;
	}
}

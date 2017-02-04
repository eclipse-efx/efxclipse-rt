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
package org.eclipse.fx.core;

/**
 * A value to hold tripples
 * 
 * @param <U>
 *            the type of value 1
 * @param <V>
 *            the type of value 2
 * @param <W>
 *            the type of value 3
 *            
 * @since 3.0
 */
public class Triple<U, V, W> {
	/**
	 * Value 1
	 */
	public final U value1;
	/**
	 * Value 2
	 */
	public final V value2;
	/**
	 * Value 3
	 */
	public final W value3;

	/**
	 * Create a new triple
	 * 
	 * @param value1
	 *            the value 1
	 * @param value2
	 *            the value 2
	 * @param value3
	 *            the value 3
	 */
	public Triple(U value1, V value2, W value3) {
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
	}

	@SuppressWarnings("null")
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.value1 == null) ? 0 : this.value1.hashCode());
		result = prime * result + ((this.value2 == null) ? 0 : this.value2.hashCode());
		result = prime * result + ((this.value3 == null) ? 0 : this.value3.hashCode());
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
		Triple<?,?,?> other = (Triple<?,?,?>) obj;
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
		if (this.value3 == null) {
			if (other.value3 != null)
				return false;
		} else if (!this.value3.equals(other.value3))
			return false;
		return true;
	}
}

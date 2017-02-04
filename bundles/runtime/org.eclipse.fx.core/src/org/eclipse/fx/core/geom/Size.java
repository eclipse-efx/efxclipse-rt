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
package org.eclipse.fx.core.geom;

/**
 * Value object who holds a width and height value
 *
 * <p>
 * The class my get a value type later so do not synchronize on it
 * </p>
 *
 * @since 3.0
 */
public class Size {
	/**
	 * The width
	 */
	public final double width;
	/**
	 * The height
	 */
	public final double height;

	/**
	 * Create a new size object
	 *
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 */
	public Size(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(this.height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Size other = (Size) obj;
		if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(other.height))
			return false;
		if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	}
}

/*******************************************************************************
 * Copyright (c) 2019 BestSolution.at and others.
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
package org.eclipse.fx.core.geom;

/**
 * A rectangular bounding box
 * 
 * @since 3.6.0
 */
public class Bounds {
	/**
	 * The x coordinate
	 */
	public final double x;
	/**
	 * The y coordinate
	 */
	public final double y;
	/**
	 * The width
	 */
	public final double width;
	/**
	 * The height
	 */
	public final double height;

	/**
	 * Create a new bounding box
	 * 
	 * @param x      the x
	 * @param y      the y
	 * @param width  the width
	 * @param height the height
	 */
	public Bounds(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * Check if the provided bounds intersect with us
	 * 
	 * @param r the bounds
	 * @return <code>true</code> if they intersect
	 */
	public boolean intersects(Bounds r) {
		return intersects(r.x, r.y, r.width, r.height);
	}

	/**
	 * Check if the provided rectangle intersects with us
	 * 
	 * @param x the upper-left x
	 * @param y the upper-left y
	 * @param w the width
	 * @param h the height
	 * @return <code>true</code> if they intersect
	 */
	public boolean intersects(double x, double y, double w, double h) {
		if (w < 0 || h < 0)
			return false;
		return x + w >= this.x 
				&& y + h >= this.y 
				&& x <= this.x + this.width 
				&& y <= this.y + this.height;
	}

	@Override
	public String toString() {
		return "Bounds [x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$//$NON-NLS-5$
	}
}

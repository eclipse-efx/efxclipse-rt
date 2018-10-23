/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.layouts;

/**
 * An item to layout
 * 
 * @since 3.5.0
 */
public interface LayoutItem {
	/**
	 * Compute the minimum width for the given height
	 * 
	 * @param height the height
	 * @return the minimum width
	 */
	public double minWidth(double height);

	/**
	 * Compute the minimum height for the given width
	 * 
	 * @param width the width
	 * @return the minimum height
	 */
	public double minHeight(double width);

	/**
	 * Compute the preferred width for the given height
	 * 
	 * @param height the height
	 * @return the preferred width
	 */
	public double prefWidth(double height);

	/**
	 * Compute the preferred height for the given width
	 * 
	 * @param width the width
	 * @return the preferred height
	 */
	public double prefHeight(double width);

	/**
	 * Compute the maximum width for the given height
	 * 
	 * @param height the height
	 * @return the maximum width
	 */
	public double maxWidth(double height);

	/**
	 * Compute the maximum height for the given width
	 * 
	 * @param width the width
	 * @return the preferred height
	 */
	public double maxHeight(double width);

	/**
	 * Resize and relocate the item
	 * 
	 * @param x      the x coordinate
	 * @param y      the y coordiante
	 * @param width  the width
	 * @param height the height
	 */
	public void resizeRelocate(double x, double y, double width, double height);
}

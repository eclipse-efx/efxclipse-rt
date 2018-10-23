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
 * A layout algorithm
 * 
 * @param <C> the layout context
 * @since 3.5.0
 */
public interface Layout<C extends LayoutContext> {
	/**
	 * Constant to represent the computed size
	 */
	public static final double USE_COMPUTED_SIZE = -1;

	/**
	 * Constant to represent that the method is not implemented
	 */
	public static final double NOT_IMPLEMENTED = -2;

	/**
	 * Do the layout the elements
	 * 
	 * @param context layout context
	 */
	public void layout(C context);

	/**
	 * Compute the minimum width needed for the given height
	 * 
	 * @param context the context
	 * @param height  the height
	 * @return the minimum width
	 */
	public double computeMinWidth(C context, double height);

	/**
	 * Compute the minimum height for the given width
	 * 
	 * @param context the context
	 * @param width   the width
	 * @return the minimum height
	 */
	public double computeMinHeight(C context, double width);

	/**
	 * Compute the preferred width needed for the given height
	 * 
	 * @param context the context
	 * @param height  the height
	 * @return the preferred width
	 */
	public double computePrefWidth(C context, double height);

	/**
	 * Compute the preferred height for the given width
	 * 
	 * @param context the context
	 * @param width   the width
	 * @return the preferred height
	 */
	public double computePrefHeight(C context, double width);

	/**
	 * Compute the maximum width needed for the given height
	 * 
	 * @param context the context
	 * @param height  the height
	 * @return the maximum width
	 */
	public double computeMaxWidth(C context, double height);

	/**
	 * Compute the maximum height for the given width
	 * 
	 * @param context the context
	 * @param width   the width
	 * @return the maximum height
	 */
	public double computeMaxHeight(C context, double width);
}
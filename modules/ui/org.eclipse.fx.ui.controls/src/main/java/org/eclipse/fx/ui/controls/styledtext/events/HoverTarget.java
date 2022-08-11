/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.events;

import com.google.common.collect.Range;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;

public class HoverTarget {

	/**
	 * lower left point of the first letter
	 */
	public final Point2D screenAnchor;


	/**
	 * the associated model element.
	 */
	public final Object model;

	/**
	 * the range in the text
	 */
	public final Range<Integer> textRange;

	/**
	 * bounds of text in screen coordinates.
	 * <p>
	 * if the text spans over multiple lines, this is <code>null</code>
	 * </p>
	 *
	 */
	public final Bounds screenBounds;



	public HoverTarget(Object model, Range<Integer> textRange, Point2D screenAnchor, Bounds screenBounds) {
		this.screenAnchor = screenAnchor;
		this.model = model;
		this.textRange = textRange;
		this.screenBounds = screenBounds;
	}

	@Override
	public String toString() {
		return "HoverTarget(@"+textRange+", "+model+")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((screenAnchor == null) ? 0 : screenAnchor.hashCode());
		result = prime * result + ((screenBounds == null) ? 0 : screenBounds.hashCode());
		result = prime * result + ((textRange == null) ? 0 : textRange.hashCode());
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
		HoverTarget other = (HoverTarget) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (screenAnchor == null) {
			if (other.screenAnchor != null)
				return false;
		} else if (!screenAnchor.equals(other.screenAnchor))
			return false;
		if (screenBounds == null) {
			if (other.screenBounds != null)
				return false;
		} else if (!screenBounds.equals(other.screenBounds))
			return false;
		if (textRange == null) {
			if (other.textRange != null)
				return false;
		} else if (!textRange.equals(other.textRange))
			return false;
		return true;
	}



}

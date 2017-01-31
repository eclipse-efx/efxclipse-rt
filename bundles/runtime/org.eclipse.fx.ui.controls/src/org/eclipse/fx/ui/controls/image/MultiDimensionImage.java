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
package org.eclipse.fx.ui.controls.image;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.image.Image;

/**
 * Interface describe an image capable of updating the image property depending
 * on the required dimension
 *
 * @since 3.0
 */
public interface MultiDimensionImage {
	/**
	 * @return the ratio
	 */
	public double getRatio();

	/**
	 * @return the ratio
	 */
	public ReadOnlyDoubleProperty ratioProperty();

	/**
	 * @return property who holds the current image
	 */
	public ReadOnlyObjectProperty<Image> imageProperty();

	/**
	 * Update the dimension
	 *
	 * @param w
	 *            the width
	 * @param h
	 *            the height
	 */
	public void updateDimension(double w, double h);

	/**
	 * Create a multi-dimension image who provides the same source image for any
	 * dimension
	 *
	 * @param image
	 *            the image
	 * @return a new image
	 */
	public static MultiDimensionImage singleDimension(Image image) {
		return new SingleMultiDimensionImage(image);
	}
}
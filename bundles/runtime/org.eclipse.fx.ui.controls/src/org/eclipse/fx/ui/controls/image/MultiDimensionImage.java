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

import java.util.function.Function;

import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.core.cache.Cache;

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

	/**
	 * Create a multi dimension image who is calculated lazily and uses the same
	 * image for any dimension
	 *
	 * @param threadSynchronize
	 *            helper to synchronize back to the UI thread
	 * @param placeholder
	 *            a placeholder image to show while loading
	 * @param data
	 *            the domain object used a the input to create the image
	 * @param imageComputer
	 *            function to compute the image (called outside the UI-Thread)
	 * @return an image instance
	 */
	public static <O> MultiDimensionImage singleDimension(ThreadSynchronize threadSynchronize, Image placeholder, O data, Function<O, Image> imageComputer) {
		return new SingleMultiDimensionImage(threadSynchronize, placeholder, data, imageComputer, null);
	}

	/**
	 * Create a multi dimension image who is calculated lazily and uses the same
	 * image for any dimension
	 *
	 * @param threadSynchronize
	 *            helper to synchronize back to the UI thread
	 * @param placeholder
	 *            a placeholder image to show while loading
	 * @param data
	 *            the domain object used a the input to create the image
	 * @param imageComputer
	 *            function to compute the image (called outside the UI-Thread)
	 * @param cache
	 *            added cache
	 * @return an image instance
	 */
	public static <O> MultiDimensionImage singleDimension(ThreadSynchronize threadSynchronize, Image placeholder, O data, Function<O, Image> imageComputer, Cache<O, Image> cache) {
		return new SingleMultiDimensionImage(threadSynchronize, placeholder, data, imageComputer, cache);
	}
}
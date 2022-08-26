/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
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
package org.eclipse.fx.ui.controls.image;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.core.cache.Cache;
import org.eclipse.jdt.annotation.Nullable;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.image.Image;

/**
 * Image who provides the same image for all dimensions
 *
 * @since 3.0
 */
public class SingleMultiDimensionImage implements MultiDimensionImage {
	private final ReadOnlyObjectWrapper<Image> img;
	private final ReadOnlyDoubleWrapper ratio;

	/**
	 * Create a new image
	 *
	 * @param img
	 *            the one and only image
	 */
	public SingleMultiDimensionImage(Image img) {
		this.img = new ReadOnlyObjectWrapper<Image>(this, "image", img); //$NON-NLS-1$
		this.ratio = new ReadOnlyDoubleWrapper(this, "ratio", img.getWidth() / img.getHeight()); //$NON-NLS-1$
	}

	/**
	 * Create a new image who is calculated in a background thread. The provided
	 * domain object is used a lock monitor so that for one domain object no
	 * more than one calculation is running at a time
	 *
	 * @param threadSynchronize
	 *            synchronize to ui thread
	 *
	 * @param placeholder
	 *            image used as a placeholder presented while computing
	 * @param data
	 *            the domain object the image is computed for
	 * @param imageComputer
	 *            function to compute the image
	 */
	public <O> SingleMultiDimensionImage(ThreadSynchronize threadSynchronize, Image placeholder, O data, Function<O, Image> imageComputer, @Nullable Cache<O, Image> cache) {
		this.img = new ReadOnlyObjectWrapper<Image>(this, "image", placeholder); //$NON-NLS-1$
		this.ratio = new ReadOnlyDoubleWrapper(this, "ratio", placeholder.getWidth() / placeholder.getHeight()); //$NON-NLS-1$

		CompletableFuture.supplyAsync(() -> {
			synchronized (data) {
				if( cache != null ) {
					Optional<Image> rv = cache.get(data);
					if( rv.isPresent() ) {
						return rv.get();
					}
				}

				Image image = imageComputer.apply(data);

				if( cache != null ) {
					cache.put(data, image);
				}

				return image;
			}
		}).thenAccept(threadSynchronize.wrap(this::imageComputed));
	}

	private void imageComputed(Image img) {
		this.img.set(img);
		this.ratio.set(img.getWidth() / img.getHeight());
	}

	@Override
	public double getRatio() {
		return this.ratio.get();
	}

	@Override
	public ReadOnlyDoubleProperty ratioProperty() {
		return this.ratio.getReadOnlyProperty();
	}

	@Override
	public ReadOnlyObjectProperty<Image> imageProperty() {
		return this.img.getReadOnlyProperty();
	}

	@Override
	public void updateDimension(double w, double h) {
		// nothing to do
	}

}

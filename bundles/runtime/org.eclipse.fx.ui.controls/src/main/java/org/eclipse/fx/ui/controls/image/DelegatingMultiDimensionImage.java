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

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.core.function.BiDoubleFunction;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.image.Image;

/**
 * A {@link MultiDimensionImage} image who (asynchronously) calculates an image
 * for a provided dimension
 *
 * @since 3.0
 */
public class DelegatingMultiDimensionImage implements MultiDimensionImage {
	private final ReadOnlyDoubleWrapper ratio = new ReadOnlyDoubleWrapper(this, "ratio", 1.0); //$NON-NLS-1$
	private final ReadOnlyObjectWrapper<Image> image = new ReadOnlyObjectWrapper<Image>(this, "image"); //$NON-NLS-1$
	private final BiDoubleFunction<CompletableFuture<Optional<Image>>> asyncImageProvider;
	private final BiDoubleFunction<Optional<Image>> syncImageProvider;
	private final ThreadSynchronize threadSync;
	private CompletableFuture<Optional<Image>> currentLoading;

	DelegatingMultiDimensionImage(BiDoubleFunction<Optional<Image>> syncImageProvider, ThreadSynchronize threadSync, BiDoubleFunction<CompletableFuture<Optional<Image>>> asyncImageProvider) {
		this.syncImageProvider = syncImageProvider;
		this.asyncImageProvider = asyncImageProvider;
		this.threadSync = threadSync;
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
		return this.image.getReadOnlyProperty();
	}

	@Override
	public void updateDimension(double w, double h) {
		if (this.syncImageProvider != null) {
			this.syncImageProvider.apply(w, h).ifPresent( i -> {
				double newValue = i.getWidth() / i.getHeight();
				this.ratio.set( newValue);
				this.image.set(i);
			});
		} else {
			synchronized (this) {
				if (this.currentLoading != null) {
					this.currentLoading.cancel(false);
				}
				this.currentLoading = this.asyncImageProvider.apply(w, h);
				this.currentLoading.thenAccept(oi -> {
					oi.ifPresent( i -> {
						this.threadSync.asyncExec(() -> {
							this.ratio.set( i.getWidth() / i.getHeight() );
							this.image.set(i);
						});
					});
				});
			}
		}
	}

	/**
	 * Create an image who calculates the image asynchronously
	 *
	 * @param threadSync
	 *            strategy to synchronize back to a the thread
	 * @param imageProvider
	 *            function producing a {@link CompletableFuture} calculating the
	 *            image in a background task
	 * @return an image instance
	 */
	public static DelegatingMultiDimensionImage async(ThreadSynchronize threadSync, BiDoubleFunction<CompletableFuture<Optional<Image>>> imageProvider) {
		Objects.requireNonNull(threadSync, "You need to provide a strategy to synchronize back to the ui thread"); //$NON-NLS-1$
		Objects.requireNonNull(imageProvider, "You need to provide a function who is responsible to load the image"); //$NON-NLS-1$
		return new DelegatingMultiDimensionImage(null, threadSync, imageProvider);
	}

	/**
	 * Create an image who calculates the image synchronously
	 *
	 * @param imageProvider
	 *            the provider
	 * @return a new image instance
	 */
	public static DelegatingMultiDimensionImage sync(BiDoubleFunction<Optional<Image>> imageProvider) {
		Objects.requireNonNull(imageProvider, "You need to provide a function who is responsible to load the image"); //$NON-NLS-1$
		return new DelegatingMultiDimensionImage(imageProvider, null, null);
	}
}

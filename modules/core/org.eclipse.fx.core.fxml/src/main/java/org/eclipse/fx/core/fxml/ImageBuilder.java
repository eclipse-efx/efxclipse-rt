/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.fxml;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.scene.image.Image;
import javafx.util.Builder;

/**
 * A builder for images
 */
public class ImageBuilder implements Builder<Image> {

	private String url = ""; //$NON-NLS-1$
	private double requestedWidth = 0;
	private double requestedHeight = 0;
	private boolean preserveRatio = false;
	private boolean smooth = false;
	private boolean backgroundLoading = false;

	/**
	 * @return a new builder instance
	 */
	@NonNull
	public static ImageBuilder create() {
		return new ImageBuilder();
	}

	/**
	 * Add an url property
	 * 
	 * @param url
	 *            the url
	 * @return the builder
	 * @see Image#Image(String, double, double, boolean, boolean, boolean)
	 */
	@NonNull
	public ImageBuilder url(@Nullable String url) {
		this.url = url;
		return this;
	}

	/**
	 * The requested width
	 * 
	 * @param requestedWidth
	 *            the width
	 * @return the builder
	 * @see Image#Image(String, double, double, boolean, boolean, boolean)
	 */
	@NonNull
	public ImageBuilder requestedWidth(double requestedWidth) {
		this.requestedWidth = requestedWidth;
		return this;
	}

	/**
	 * The requested height
	 * 
	 * @param requestedHeight
	 *            the height
	 * @return the builder
	 * @see Image#Image(String, double, double, boolean, boolean, boolean)
	 */
	@NonNull
	public ImageBuilder requestedHeight(double requestedHeight) {
		this.requestedHeight = requestedHeight;
		return this;
	}

	/**
	 * <code>true</code> to preserve the ratio
	 * 
	 * @param preserveRatio
	 *            preserve the ratio
	 * @return the builder
	 */
	@NonNull
	public ImageBuilder preserveRatio(boolean preserveRatio) {
		this.preserveRatio = preserveRatio;
		return this;
	}

	/**
	 * <code>true</code> to smooth the image when scaling
	 * 
	 * @param smooth
	 *            turn on/off smoothing
	 * @return the builder
	 */
	@NonNull
	public ImageBuilder smooth(boolean smooth) {
		this.smooth = smooth;
		return this;
	}
	
	/**
	 * Load the image in background
	 * @param backgroundLoading turn on/off background loading
	 * @return the builder
	 */
	@NonNull
	public ImageBuilder backgroundLoading(boolean backgroundLoading) {
		this.backgroundLoading = backgroundLoading;
		return this;
	}

	@Override
	@NonNull
	public Image build() {
		return new Image(this.url, this.requestedWidth, this.requestedHeight, this.preserveRatio, this.smooth, this.backgroundLoading);
	}

}

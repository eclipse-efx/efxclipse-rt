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

import javafx.scene.image.Image;
import javafx.util.Builder;

public class ImageBuilder implements Builder<Image> {
	private String url = "";
	private double requestedWidth = 0;
	private double requestedHeight = 0;
	private boolean preserveRatio = false;
	private boolean smooth = false;
	private boolean backgroundLoading = false;

	public static ImageBuilder create() {
		return new ImageBuilder();
	}
	
	public ImageBuilder url(String url) {
		this.url = url;
		return this;
	}
	
	public ImageBuilder requestedWidth(double requestedWidth) {
		this.requestedWidth = requestedWidth;
		return this;
	}
	
	public ImageBuilder requestedHeight(double requestedHeight) {
		this.requestedHeight = requestedHeight;
		return this;
	}
	
	public ImageBuilder preserveRatio(boolean preserveRatio) {
		this.preserveRatio = preserveRatio;
		return this;
	}
	
	public ImageBuilder smooth(boolean smooth) {
		this.smooth = smooth;
		return this;
	}
	
	public ImageBuilder backgroundLoading(boolean backgroundLoading) {
		this.backgroundLoading = backgroundLoading;
		return this;
	}

	@Override
	public Image build() {
		return new Image(url, requestedWidth, requestedHeight, preserveRatio, smooth, backgroundLoading);
	}

}

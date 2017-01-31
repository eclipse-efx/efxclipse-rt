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
		this.ratio = new ReadOnlyDoubleWrapper(this,"ratio",img.getWidth() / img.getHeight()); //$NON-NLS-1$
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

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
package org.eclipse.fx.ui.controls.list;

import java.util.function.Function;

import org.eclipse.fx.core.bindings.FXBindings;
import org.eclipse.fx.ui.controls.image.MultiDimensionImage;
import org.eclipse.fx.ui.controls.image.ScalingImageViewer;
import org.eclipse.fx.ui.controls.image.ScalingImageViewer.Dimension;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

/**
 * List cell display an image
 *
 * @param <T>
 *            the item type
 *
 * @since 3.0
 */
public class ScalingImageListCell<T> extends ListCell<T> {
	private final ScalingImageViewer imageViewer = new ScalingImageViewer();
	private final Function<T, ObservableValue<MultiDimensionImage>> imageProvider;

	/**
	 * Create a new image cell
	 *
	 * @param view
	 *            the list view
	 * @param imageProvider
	 *            function to provide the property with the multi-dimension
	 *            image
	 */
	public ScalingImageListCell(ListView<T> view, Function<T, ObservableValue<MultiDimensionImage>> imageProvider) {
		this.imageProvider = imageProvider;
		this.imageViewer.derivedDimensionProperty().bind(FXBindings.map(view.orientationProperty(), o -> o == Orientation.HORIZONTAL ? Dimension.WIDTH : Dimension.HEIGHT));
	}

	@Override
	protected double computePrefHeight(double width) { // Looks like a bug in
		return super.computeMinHeight(width);
	}

	@Override
	public Orientation getContentBias() {
		return Orientation.HORIZONTAL;
	}

	@Override
	protected void updateItem(T item, boolean empty) {
		super.updateItem(item, empty);

		if (item == null || empty) {
			setGraphic(null);
			this.imageViewer.imageProperty().unbind();
		} else {
			this.imageViewer.imageProperty().bind(this.imageProvider.apply(item));
			setGraphic(this.imageViewer);
		}
	}
}
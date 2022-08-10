/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.markers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.fx.ui.controls.Util;
import org.eclipse.jdt.annotation.NonNull;

import javafx.beans.property.ObjectProperty;
import javafx.css.CssMetaData;
import javafx.css.SimpleStyleableObjectProperty;
import javafx.css.StyleConverter;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.StrokeType;

/**
 * Marks a Tab-Position
 */
public final class TabOutlineMarker extends Group {
	@NonNull
	private Bounds containerBounds;
	@NonNull
	private Bounds referenceBounds;
	private boolean before;

	/**
	 * Create a new tab outline
	 *
	 * @param containerBounds
	 *            the bounds of the container
	 * @param referenceBounds
	 *            the bounds of the reference tab
	 * @param before
	 *            <code>true</code> to mark the insert point before reference
	 *            bounds
	 */
	public TabOutlineMarker(@NonNull Bounds containerBounds, @NonNull Bounds referenceBounds, boolean before) {
		setUserData(Util.FIND_NODE_EXCLUDE);
		this.containerBounds = containerBounds;
		this.referenceBounds = referenceBounds;
		updateBounds(containerBounds, referenceBounds, before);
		getStyleClass().add("tab-outline-marker"); //$NON-NLS-1$
	}

	/**
	 * Update the tab outline
	 *
	 * @param containerBounds
	 *            the bounds of the container
	 * @param referenceBounds
	 *            the bounds of the reference tab
	 * @param before
	 *            <code>true</code> to mark the insert point before reference
	 *            bounds
	 */
	public void updateBounds(@NonNull Bounds containerBounds, @NonNull Bounds referenceBounds, boolean before) {
		this.containerBounds = containerBounds;
		this.referenceBounds = referenceBounds;
		this.before = before;

		Polyline pl = new Polyline();

		Bounds _referenceBounds = referenceBounds;

		if (before) {
			_referenceBounds = new BoundingBox(Math.max(0, _referenceBounds.getMinX() - _referenceBounds.getWidth() / 2), _referenceBounds.getMinY(), _referenceBounds.getWidth(), _referenceBounds.getHeight());
		} else {
			_referenceBounds = new BoundingBox(Math.max(0, _referenceBounds.getMaxX() - _referenceBounds.getWidth() / 2), _referenceBounds.getMinY(), _referenceBounds.getWidth(), _referenceBounds.getHeight());
		}

		pl.getPoints().addAll(
		// -----------------
		// top
		// -----------------
		// start
				Double.valueOf(0.0), Double.valueOf(_referenceBounds.getMaxY()),

				// tab start
				Double.valueOf(_referenceBounds.getMinX()), Double.valueOf(_referenceBounds.getMaxY()),

				// // tab start top
				Double.valueOf(_referenceBounds.getMinX()), Double.valueOf(_referenceBounds.getMinY()),

				// tab end right
				Double.valueOf(_referenceBounds.getMaxX()), Double.valueOf(_referenceBounds.getMinY()),

				// tab end bottom
				Double.valueOf(_referenceBounds.getMaxX()), Double.valueOf(_referenceBounds.getMaxY()),

				// end
				Double.valueOf(containerBounds.getMaxX()), Double.valueOf(_referenceBounds.getMaxY()),

				// -----------------
				// right
				// -----------------
				Double.valueOf(containerBounds.getMaxX()), Double.valueOf(containerBounds.getMaxY()),

				// -----------------
				// bottom
				// -----------------
				Double.valueOf(containerBounds.getMinX()), Double.valueOf(containerBounds.getMaxY()),

				// -----------------
				// left
				// -----------------
				Double.valueOf(containerBounds.getMinX()), Double.valueOf(_referenceBounds.getMaxY()));
		pl.strokeProperty().bind(fillProperty());
		pl.setStrokeWidth(3);
		pl.setStrokeType(StrokeType.INSIDE);
		getChildren().setAll(pl);
	}

	@SuppressWarnings("null")
	@NonNull
	private final ObjectProperty<@NonNull Paint> fill = new SimpleStyleableObjectProperty<>(FILL, this, "fill", Color.ORANGE); //$NON-NLS-1$

	/**
	 * The fill property
	 *
	 * <p>
	 * The default color {@link Color#ORANGE} <span style=
	 * "background-color: orange; color: orange; border-width: 1px; border-color: black; border-style: solid; width: 15; height: 15;">__</span>
	 * </p>
	 *
	 * @return the property
	 */
	public @NonNull ObjectProperty<@NonNull Paint> fillProperty() {
		return this.fill;
	}

	/**
	 * Set a new fill
	 * <p>
	 * The default color {@link Color#ORANGE} <span style=
	 * "background-color: orange; color: orange; border-width: 1px; border-color: black; border-style: solid; width: 15; height: 15;">__</span>
	 * </p>
	 *
	 * @param fill
	 *            the fill
	 */
	public void setFill(@NonNull Paint fill) {
		fillProperty().set(fill);
	}

	/**
	 * Get the current fill
	 * <p>
	 * The default color {@link Color#ORANGE} <span style=
	 * "background-color: orange; color: orange; border-width: 1px; border-color: black; border-style: solid; width: 15; height: 15;">__</span>
	 * </p>
	 *
	 * @return the current fill
	 */
	public @NonNull Paint getFill() {
		return fillProperty().get();
	}

	@SuppressWarnings("null")
	private static final CssMetaData<TabOutlineMarker, @NonNull Paint> FILL = new CssMetaData<TabOutlineMarker, @NonNull Paint>("-fx-fill", StyleConverter.getPaintConverter(), Color.ORANGE) { //$NON-NLS-1$

		@Override
		public boolean isSettable(TabOutlineMarker node) {
			return !node.fillProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<@NonNull Paint> getStyleableProperty(TabOutlineMarker node) {
			return (StyleableProperty<@NonNull Paint>) node.fillProperty();
		}

	};

	private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

	static {
		@SuppressWarnings("static-access")
		final List<CssMetaData<? extends Styleable, ?>> styleables = new ArrayList<CssMetaData<? extends Styleable, ?>>(Group.getClassCssMetaData());
		styleables.add(FILL);
		STYLEABLES = Collections.unmodifiableList(styleables);
	}

	public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
		return STYLEABLES;
	}

	@Override
	public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
		return getClassCssMetaData();
	}
}

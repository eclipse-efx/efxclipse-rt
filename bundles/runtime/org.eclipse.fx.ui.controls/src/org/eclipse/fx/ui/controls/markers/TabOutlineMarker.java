/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.markers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sun.javafx.css.converters.PaintConverter;

import javafx.beans.property.ObjectProperty;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableObjectProperty;
import javafx.css.StyleableProperty;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.StrokeType;

public class TabOutlineMarker extends Group {
	private Bounds containerBounds;
	private Bounds referenceBounds;
	private boolean before;

	public TabOutlineMarker(Bounds containerBounds, Bounds referenceBounds, boolean before) {
		updateBounds(containerBounds, referenceBounds, before);
	}

	public void updateBounds(Bounds containerBounds, Bounds referenceBounds, boolean before) {
		if (containerBounds.equals(this.containerBounds) && referenceBounds.equals(this.referenceBounds) && before == this.before) {
			return;
		}

		this.containerBounds = containerBounds;
		this.referenceBounds = referenceBounds;
		this.before = before;

		Polyline pl = new Polyline();

		if (before) {
			referenceBounds = new BoundingBox(Math.max(0, referenceBounds.getMinX() - referenceBounds.getWidth() / 2), referenceBounds.getMinY(), referenceBounds.getWidth(), referenceBounds.getHeight());
		} else {
			referenceBounds = new BoundingBox(Math.max(0, referenceBounds.getMaxX() - referenceBounds.getWidth() / 2), referenceBounds.getMinY(), referenceBounds.getWidth(), referenceBounds.getHeight());
		}

		pl.getPoints().addAll(
				// -----------------
				// top
				// -----------------
				// start
				0.0, referenceBounds.getMaxY(),

				// tab start
				referenceBounds.getMinX(), referenceBounds.getMaxY(),

				// // tab start top
				referenceBounds.getMinX(), referenceBounds.getMinY(),

				// tab end right
				referenceBounds.getMaxX(), referenceBounds.getMinY(),

				// tab end bottom
				referenceBounds.getMaxX(), referenceBounds.getMaxY(),

				// end
				containerBounds.getMaxX(), referenceBounds.getMaxY(),

				// -----------------
				// right
				// -----------------
				containerBounds.getMaxX(), containerBounds.getMaxY(),

				// -----------------
				// bottom
				// -----------------
				containerBounds.getMinX(), containerBounds.getMaxY(),

				// -----------------
				// left
				// -----------------
				containerBounds.getMinX(), referenceBounds.getMaxY());
		pl.strokeProperty().bind(fillProperty());
		pl.setStrokeWidth(3);
		pl.setStrokeType(StrokeType.INSIDE);
		getChildren().setAll(pl);
	}

	private ObjectProperty<Paint> fill;

	public ObjectProperty<Paint> fillProperty() {
		if (fill == null) {
			fill = new StyleableObjectProperty<Paint>(Color.ORANGE) {

				@Override
				public CssMetaData<? extends Styleable, Paint> getCssMetaData() {
					return FILL;
				}

				@Override
				public Object getBean() {
					return TabOutlineMarker.this;
				}

				@Override
				public String getName() {
					return "fill";
				}

			};
		}
		return fill;
	}

	public void setFill(Paint fill) {
		fillProperty().set(fill);
	}

	public Paint getFill() {
		return fillProperty().get();
	}

	private static final CssMetaData<TabOutlineMarker, Paint> FILL = new CssMetaData<TabOutlineMarker, Paint>("-fx-fill", PaintConverter.getInstance(), Color.rgb(0, 139, 255)) {

		@Override
		public boolean isSettable(TabOutlineMarker node) {
			return node.fill == null || !node.fill.isBound();
		}

		@Override
		public StyleableProperty<Paint> getStyleableProperty(TabOutlineMarker node) {
			return (StyleableProperty<Paint>) node.fillProperty();
		}

	};

	private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

	static {
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

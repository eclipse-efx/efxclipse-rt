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

import org.eclipse.fx.core.bindings.FXBindings;
import org.eclipse.fx.core.bindings.FXCollectors;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

/**
 * An image viewer who adjust the image to:
 * <ul>
 * <li>fill the maximum space</li>
 * <li>use best image for dimension</li>
 * </ul>
 *
 * @since 3.0
 */
public class ScalingImageViewer extends Region {
	/**
	 * The derived dimension
	 */
	public static enum Dimension {
		/**
		 * Both dimensions are derived
		 */
		BOTH,
		/**
		 * Height is derived from the width
		 */
		HEIGHT,
		/**
		 * Width is derived from the height
		 */
		WIDTH
	}

	private final ObjectProperty<@NonNull Dimension> derivedDimension = new SimpleObjectProperty<@NonNull Dimension>(this, "derivedDimension", Dimension.BOTH) { //$NON-NLS-1$
		@Override
		protected void invalidated() {
			super.invalidated();
			requestLayout();
		}
	};
	private ObjectProperty<@Nullable MultiDimensionImage> image = new SimpleObjectProperty<@Nullable MultiDimensionImage>(this, "image") {//$NON-NLS-1$
		@Override
		protected void invalidated() {
			super.invalidated();
			requestLayout();
		}
	};
	private final ObjectProperty<@NonNull Pos> anker = new SimpleObjectProperty<@NonNull Pos>(this, "anker", Pos.TOP_LEFT) { //$NON-NLS-1$
		@Override
		protected void invalidated() {
			super.invalidated();
			requestLayout();
		}
	};

	private final ImageView imageView;

	/**
	 * Create a new viewer
	 */
	public ScalingImageViewer() {
		this.imageView = new ImageView();
		this.imageView.setManaged(false);

		ObjectBinding<Image> dimImg = FXBindings.bindStream(this.image).map( m -> {
			return m == null ? null : m.imageProperty();
		}).collect(FXCollectors.toBinding());
		ObjectBinding<Number> ratioBinding = FXBindings.bindStream(this.image)
				.map( m -> {
					return m == null ? null : m.ratioProperty();
				}).collect(FXCollectors.toBinding());
		ratioBinding.addListener( (ob,ol,ne) -> {
			requestLayout();
			layout();
		});
		this.imageView.imageProperty().bind(dimImg);
		getChildren().add(this.imageView);
	}

	@Override
	public Orientation getContentBias() {
		switch (getDerivedDimension()) {
		case HEIGHT:
			return Orientation.HORIZONTAL;
		case WIDTH:
			return Orientation.VERTICAL;
		default:
			return null;
		}
	}

	@Override
	protected void layoutChildren() {
		super.layoutChildren();
		MultiDimensionImage img = getImage();
		if (img != null) {
			double w;
			double h;

			switch (getDerivedDimension()) {
			case HEIGHT: {
				w = getWidth() - snappedLeftInset() - snappedRightInset();
				h = (w / img.getRatio()) - snappedTopInset() - snappedBottomInset();
				break;
			}
			case WIDTH: {
				h = getHeight() - snappedTopInset() - snappedBottomInset();
				w = (h * img.getRatio()) - snappedLeftInset() - snappedRightInset();
			}
			default: {
				w = getWidth() - snappedLeftInset() - snappedRightInset();
				h = (w / img.getRatio()) - snappedTopInset() - snappedBottomInset();

				if (h > getHeight() - snappedTopInset() - snappedBottomInset()) {
					h = getHeight() - snappedTopInset() - snappedBottomInset();
					w = (h * img.getRatio()) - snappedLeftInset() - snappedRightInset();
				}
			}
			}

			img.updateDimension(w, h);

			this.imageView.setFitWidth(w);
			this.imageView.setFitHeight(h);
			double x;
			double y;
			switch (this.anker.get().getHpos()) {
			case LEFT:
				x = snappedLeftInset();
				break;
			case CENTER:
				x = (getWidth() / 2) - (w / 2);
				break;
			case RIGHT:
			default:
				x = getWidth() - snappedRightInset() - w;
				break;
			}

			switch (this.anker.getValue().getVpos()) {
			case BASELINE:
			case BOTTOM:
				y = getHeight() - snappedBottomInset() - h;
				break;
			case CENTER:
				y = (getHeight() / 2) - (h / 2);
				break;
			case TOP:
			default:
				y = snappedTopInset();
				break;
			}

			x = snapPosition(x);
			y = snapPosition(y);

			this.imageView.resizeRelocate(x, y, w, h);
		}
	}

	/**
	 * Property with the derived dimension
	 * <p>
	 * Default: {@link Dimension#BOTH}
	 * </p>
	 *
	 * @return the property
	 */
	public final ObjectProperty<@NonNull Dimension> derivedDimensionProperty() {
		return this.derivedDimension;
	}

	/**
	 * The current derived dimension
	 * <p>
	 * Default: {@link Dimension#BOTH}
	 * </p>
	 *
	 * @return the current value
	 */
	public final @NonNull Dimension getDerivedDimension() {
		return derivedDimensionProperty().get();
	}

	/**
	 * Set the current derived dimension
	 * <p>
	 * Default: {@link Dimension#BOTH}
	 * </p>
	 *
	 * @param derivedDimension
	 *            the new value
	 */
	public final void setDerivedDimension(final @NonNull Dimension derivedDimension) {
		derivedDimensionProperty().set(derivedDimension);
	}

	/**
	 * Property holding the image displayed
	 *
	 * @return the property
	 */
	public final ObjectProperty<@Nullable MultiDimensionImage> imageProperty() {
		return this.image;
	}

	/**
	 * @return the current image, might be <code>null</code>
	 */
	public final @Nullable MultiDimensionImage getImage() {
		return this.imageProperty().get();
	}

	/**
	 * Set the current image
	 *
	 * @param image
	 *            the image, might be <code>null</code>
	 */
	public final void setImage(final @Nullable MultiDimensionImage image) {
		this.imageProperty().set(image);
	}

	@Override
	protected double computeMinHeight(double width) {
		MultiDimensionImage img = getImage();
		if( img == null ) {
			return super.computeMinHeight(width);
		}

		switch (getDerivedDimension()) {
		case HEIGHT: {
			double w = width - snappedLeftInset() - snappedRightInset();
			return (w / img.getRatio()) - snappedTopInset() - snappedBottomInset();
		}
		default:
			return super.computeMinHeight(width);
		}
	}

	@Override
	protected double computePrefHeight(double width) {
		return super.computeMinHeight(width);
	}

	@Override
	protected double computeMinWidth(double height) {
		MultiDimensionImage img = getImage();
		if( img == null ) {
			return super.computeMinWidth(height);
		}

		switch (getDerivedDimension()) {
		case WIDTH: {
			double h = height - snappedTopInset() - snappedBottomInset();
			return (h * img.getRatio()) - snappedLeftInset() - snappedRightInset();
		}
		default:
			return super.computeMinWidth(height);
		}

	}

	@Override
	protected double computePrefWidth(double height) {
		return super.computeMinWidth(height);
	}

	/**
	 * Property with the anker used by the image
	 * <p>
	 * Default: {@link Pos#TOP_LEFT}
	 * </p>
	 *
	 * @return the anker
	 */
	public final ObjectProperty<Pos> ankerProperty() {
		return this.anker;
	}

	/**
	 * Get the current anker
	 * <p>
	 * Default: {@link Pos#TOP_LEFT}
	 * </p>
	 *
	 * @return the current anker
	 */
	public final Pos getAnker() {
		return this.ankerProperty().get();
	}

	/**
	 * Set the current anker
	 * <p>
	 * Default: {@link Pos#TOP_LEFT}
	 * </p>
	 *
	 * @param anker
	 *            the anker, must not be <code>null<code>
	 */
	public final void setAnker(final Pos anker) {
		this.ankerProperty().set(anker);
	}

}

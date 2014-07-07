/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Tom Schindl<tom.schindl@bestsolution.at> - ported to JavaFX
 *******************************************************************************/
package org.eclipse.fx.ui.panes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.css.CssMetaData;
import javafx.css.SimpleStyleableBooleanProperty;
import javafx.css.SimpleStyleableIntegerProperty;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.geometry.Bounds;
import javafx.scene.Node;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import com.sun.javafx.css.converters.BooleanConverter;
import com.sun.javafx.css.converters.SizeConverter;

/**
 * A layout pane known from SWT which layouts all children horizontal or
 * vertical providing them the full space and sizing all them equally
 */
@SuppressWarnings("restriction")
public class FillLayoutPane extends AbstractLayoutPane<FillLayoutPane.FillData> {
	private static final CssMetaData<FillLayoutPane, Number> MARGIN_WIDTH = new CssMetaData<FillLayoutPane, Number>("-fx-inner-margin-width", SizeConverter.getInstance(), Integer.valueOf(0)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(FillLayoutPane node) {
			return !node.marginWidthProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(FillLayoutPane node) {
			return (StyleableProperty<Number>) node.marginWidthProperty();
		}
	};

	private static final CssMetaData<FillLayoutPane, Number> MARGIN_HEIGHT = new CssMetaData<FillLayoutPane, Number>("-fx-inner-margin-height", SizeConverter.getInstance(), Integer.valueOf(0)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(FillLayoutPane node) {
			return !node.marginHeightProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(FillLayoutPane node) {
			return (StyleableProperty<Number>) node.marginHeightProperty();
		}
	};

	private static final CssMetaData<FillLayoutPane, Number> SPACING = new CssMetaData<FillLayoutPane, Number>("-fx-spacing", SizeConverter.getInstance(), Integer.valueOf(0)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(FillLayoutPane node) {
			return !node.spacingProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(FillLayoutPane node) {
			return (StyleableProperty<Number>) node.spacingProperty();
		}
	};

	private static final CssMetaData<FillLayoutPane, Boolean> HORIZONTAL = new CssMetaData<FillLayoutPane, Boolean>("-fx-horizontal", BooleanConverter.getInstance(), Boolean.TRUE) { //$NON-NLS-1$

		@Override
		public boolean isSettable(FillLayoutPane node) {
			return !node.horizontalProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Boolean> getStyleableProperty(FillLayoutPane node) {
			return (StyleableProperty<Boolean>) node.horizontalProperty();
		}
	};

	private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

	static {

		@SuppressWarnings("static-access")
		final List<CssMetaData<? extends Styleable, ?>> styleables = new ArrayList<CssMetaData<? extends Styleable, ?>>(AbstractLayoutPane.getClassCssMetaData());
		styleables.add(MARGIN_WIDTH);
		styleables.add(MARGIN_HEIGHT);
		styleables.add(SPACING);
		styleables.add(HORIZONTAL);
		STYLEABLES = Collections.unmodifiableList(styleables);
	}

	public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
		return STYLEABLES;
	}

	@Override
	public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
		return getClassCssMetaData();
	}

	@NonNull
	private final BooleanProperty horizontal = new SimpleStyleableBooleanProperty(HORIZONTAL, this, "horizontal", true); //$NON-NLS-1$

	@NonNull
	private final IntegerProperty marginWidth = new SimpleStyleableIntegerProperty(MARGIN_WIDTH, this, "marginWidth", Integer.valueOf(0)); //$NON-NLS-1$

	@NonNull
	private final IntegerProperty marginHeight = new SimpleStyleableIntegerProperty(MARGIN_HEIGHT, this, "marginHeight", Integer.valueOf(0)); //$NON-NLS-1$

	@NonNull
	private final IntegerProperty spacing = new SimpleStyleableIntegerProperty(SPACING, this, "spacing", Integer.valueOf(0)); //$NON-NLS-1$

	static class FillData {

		double defaultWidth = -1, defaultHeight = -1;
		double currentWhint, currentHhint, currentWidth = -1, currentHeight = -1;

		Size computeSize(Node control, double wHint, double hHint, boolean flushCache) {
			if (flushCache)
				flushCache();
			if (wHint == FX_DEFAULT && hHint == FX_DEFAULT) {
				if (this.defaultWidth == -1 || this.defaultHeight == -1) {
					// Size size = computeSize (wHint, hHint, flushCache);
					this.defaultWidth = control.prefWidth(hHint);
					this.defaultHeight = control.prefHeight(wHint);
				}
				return new Size(this.defaultWidth, this.defaultHeight);
			}
			if (this.currentWidth == -1 || this.currentHeight == -1 || wHint != this.currentWhint || hHint != this.currentHhint) {
				// Point size = control.computeSize (wHint, hHint, flushCache);
				this.currentWhint = wHint;
				this.currentHhint = hHint;
				this.currentWidth = control.getLayoutBounds().getWidth();
				this.currentHeight = control.getLayoutBounds().getHeight();
			}
			return new Size(this.currentWidth, this.currentHeight);
		}

		void flushCache() {
			this.defaultWidth = this.defaultHeight = -1;
			this.currentWidth = this.currentHeight = -1;
		}
	}

	@NonNull
	private static final String LAYOUT_KEY = "fillData"; //$NON-NLS-1$
	
	/**
	 * Set a constraint object for the node
	 * 
	 * @param n
	 *            the node
	 * @param data
	 *            the fill data
	 */
	public final static void setConstraint(@NonNull Node n, @NonNull FillData data) {
		setConstraint(n, LAYOUT_KEY, data);
	}

	/**
	 * Access the constraint object for the node
	 * 
	 * @param n
	 *            the node
	 * @return the constraint or <code>null</code>
	 */
	public final static @Nullable FillData getConstraint(@NonNull Node n) {
		return (FillData) getConstraint(n, LAYOUT_KEY);
	}

	/**
	 * Define how controls are layouted
	 * 
	 * @param horizontal
	 *            <code>true</code> to layout next to each other
	 */
	public final void setHorizontal(boolean horizontal) {
		this.horizontal.set(horizontal);
	}

	/**
	 * @return the current value
	 */
	public final boolean isHorizontal() {
		return this.horizontal.get();
	}

	/**
	 * @return the property, <code>true</code> if children an layouted next to
	 *         each other
	 */
	public final @NonNull BooleanProperty horizontalProperty() {
		return this.horizontal;
	}

	/**
	 * Margin left on the left and right border of the container
	 * 
	 * @param marginWidth
	 *            the width
	 */
	public final void setMarginWidth(int marginWidth) {
		this.marginWidth.set(marginWidth);
	}

	/**
	 * Margin left on the left and right border of the container
	 * 
	 * @return the current value
	 */
	public final int getMarginWidth() {
		return this.marginWidth.get();
	}

	/**
	 * @return Margin left on the left and right border of the container
	 */
	public final @NonNull IntegerProperty marginWidthProperty() {
		return this.marginWidth;
	}

	/**
	 * @return the margin left on top and bottom of the container
	 */
	public final @NonNull IntegerProperty marginHeightProperty() {
		return this.marginHeight;
	}

	/**
	 * The margin left on top and bottom of the container
	 * 
	 * @param marginHeight
	 *            the margin
	 */
	public final void setMarginHeight(int marginHeight) {
		this.marginHeight.set(marginHeight);
	}

	/**
	 * @return the margin left on top and bottom of the container
	 */
	public final int getMarginHeight() {
		return this.marginHeight.get();
	}

	/**
	 * @return the spacing between children
	 */
	public final @NonNull IntegerProperty spacingProperty() {
		return this.spacing;
	}

	/**
	 * @return the spacing between children
	 */
	public final int getSpacing() {
		return this.spacing.get();
	}

	/**
	 * The spacing between children
	 * 
	 * @param spacing
	 *            the spacing
	 */
	public final void setSpacing(int spacing) {
		this.spacing.set(spacing);
	}

	@Override
	protected Size computeSize(double wHint, double hHint, boolean flushCache) {
		@SuppressWarnings("null")
		@NonNull Node[] children = getChildren().toArray(new Node[0]);
		int count = children.length;
		double maxWidth = 0, maxHeight = 0;
		for (int i = 0; i < count; i++) {
			Node child = children[i];
			double w = wHint, h = hHint;
			if (count > 0) {
				if (this.horizontal.get() && wHint != FX_DEFAULT) {
					w = Math.max(0, (wHint - (count - 1) * this.spacing.get()) / count);
				}
				if (!this.horizontal.get() && hHint != FX_DEFAULT) {
					h = Math.max(0, (hHint - (count - 1) * this.spacing.get()) / count);
				}
			}
			Size size = computeChildSize(child, w, h, flushCache);
			maxWidth = Math.max(maxWidth, size.width);
			maxHeight = Math.max(maxHeight, size.height);
		}
		double width = 0, height = 0;
		if (this.horizontal.get()) {
			width = count * maxWidth;
			if (count != 0)
				width += (count - 1) * this.spacing.get();
			height = maxHeight;
		} else {
			width = maxWidth;
			height = count * maxHeight;
			if (count != 0)
				height += (count - 1) * this.spacing.get();
		}
		width += this.marginWidth.get() * 2 + getPadding().getLeft() + getPadding().getRight();
		height += this.marginHeight.get() * 2 + getPadding().getTop() + getPadding().getBottom();
		if (wHint != FX_DEFAULT)
			width = wHint;
		if (hHint != FX_DEFAULT)
			height = hHint;
		return new Size(width, height);
	}
 
	static Size computeChildSize(@NonNull Node control, double wHint, double hHint, boolean flushCache) {
		FillData data = getConstraint(control);
		if (data == null) {
			data = new FillData();
			setConstraint(control, data);
		}
		Size size = null;
		if (wHint == FX_DEFAULT && hHint == FX_DEFAULT) {
			size = data.computeSize(control, wHint, hHint, flushCache);
		} else {
			// TEMPORARY CODE
			int trimX, trimY;
			trimX = trimY = 0;
			// FIXME
			// if (control instanceof Scrollable) {
			// Rectangle rect = ((Scrollable) control).computeTrim(0, 0, 0, 0);
			// trimX = rect.width;
			// trimY = rect.height;
			// } else {
			// trimX = trimY = control.getBorderWidth() * 2;
			// }
			double w = wHint == FX_DEFAULT ? wHint : Math.max(0, wHint - trimX);
			double h = hHint == FX_DEFAULT ? hHint : Math.max(0, hHint - trimY);
			size = data.computeSize(control, w, h, flushCache);
		}
		return size;
	}

	@Override
	protected void layoutChildren() {
		super.layoutChildren();

		Bounds rect = getLayoutBounds();
		Node[] children = getChildren().toArray(new Node[0]);
		int count = children.length;
		if (count == 0)
			return;
		double width = rect.getWidth() - this.marginWidth.get() * 2 - getPadding().getLeft() - getPadding().getRight();
		double height = rect.getHeight() - this.marginHeight.get() * 2 - getPadding().getTop() - getPadding().getBottom();
		if (this.horizontal.get()) {
			width -= (count - 1) * this.spacing.get();
			double x = rect.getMinX() + getPadding().getLeft() + this.marginWidth.get(), extra = width % count;
			double y = rect.getMinY() + getPadding().getTop() + this.marginHeight.get(), cellWidth = width / count;
			for (int i = 0; i < count; i++) {
				Node child = children[i];
				double childWidth = cellWidth;
				if (i == 0) {
					childWidth += extra / 2;
				} else {
					if (i == count - 1)
						childWidth += (extra + 1) / 2;
				}
				child.resizeRelocate(x, y, childWidth, height);
				x += childWidth + this.spacing.get();
			}
		} else {
			height -= (count - 1) * this.spacing.get();
			double x = rect.getMinX() + getPadding().getLeft() + this.marginWidth.get(), cellHeight = height / count;
			double y = rect.getMinY() + getPadding().getTop() + this.marginHeight.get(), extra = height % count;
			for (int i = 0; i < count; i++) {
				Node child = children[i];
				double childHeight = cellHeight;
				if (i == 0) {
					childHeight += extra / 2;
				} else {
					if (i == count - 1)
						childHeight += (extra + 1) / 2;
				}
				child.resizeRelocate(x, y, width, childHeight);
				y += childHeight + this.spacing.get();
			}
		}
	}
}

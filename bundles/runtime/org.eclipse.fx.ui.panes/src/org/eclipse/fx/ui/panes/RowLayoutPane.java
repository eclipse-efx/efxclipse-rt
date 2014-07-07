/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.panes;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.css.CssMetaData;
import javafx.css.SimpleStyleableBooleanProperty;
import javafx.css.SimpleStyleableIntegerProperty;
import javafx.css.StyleableProperty;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Node;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import com.sun.javafx.css.converters.BooleanConverter;
import com.sun.javafx.css.converters.SizeConverter;

/**
 * Layout items from top to bottom or left to right
 */
@SuppressWarnings("restriction")
public class RowLayoutPane extends AbstractLayoutPane<RowData> {

	private static final CssMetaData<RowLayoutPane, Number> MARGIN_WIDTH = new CssMetaData<RowLayoutPane, Number>("-fx-inner-margin-width", SizeConverter.getInstance(), Integer.valueOf(0)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(RowLayoutPane node) {
			return !node.marginWidthProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(RowLayoutPane node) {
			return (StyleableProperty<Number>) node.marginWidthProperty();
		}
	};

	private static final CssMetaData<RowLayoutPane, Number> MARGIN_HEIGHT = new CssMetaData<RowLayoutPane, Number>("-fx-inner-margin-height", SizeConverter.getInstance(), Integer.valueOf(0)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(RowLayoutPane node) {
			return !node.marginHeightProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(RowLayoutPane node) {
			return (StyleableProperty<Number>) node.marginHeightProperty();
		}
	};

	private static final CssMetaData<RowLayoutPane, Number> MARGIN_LEFT = new CssMetaData<RowLayoutPane, Number>("-fx-inner-margin-left", SizeConverter.getInstance(), Integer.valueOf(0)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(RowLayoutPane node) {
			return !node.marginLeftProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(RowLayoutPane node) {
			return (StyleableProperty<Number>) node.marginLeftProperty();
		}
	};

	private static final CssMetaData<RowLayoutPane, Number> MARGIN_TOP = new CssMetaData<RowLayoutPane, Number>("-fx-inner-margin-top", SizeConverter.getInstance(), Integer.valueOf(0)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(RowLayoutPane node) {
			return !node.marginTopProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(RowLayoutPane node) {
			return (StyleableProperty<Number>) node.marginTopProperty();
		}
	};

	private static final CssMetaData<RowLayoutPane, Number> MARGIN_RIGHT = new CssMetaData<RowLayoutPane, Number>("-fx-inner-margin-right", SizeConverter.getInstance(), Integer.valueOf(0)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(RowLayoutPane node) {
			return !node.marginRightProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(RowLayoutPane node) {
			return (StyleableProperty<Number>) node.marginRightProperty();
		}
	};

	private static final CssMetaData<RowLayoutPane, Number> MARGIN_BOTTOM = new CssMetaData<RowLayoutPane, Number>("-fx-inner-margin-bottom", SizeConverter.getInstance(), Integer.valueOf(0)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(RowLayoutPane node) {
			return !node.marginBottomProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(RowLayoutPane node) {
			return (StyleableProperty<Number>) node.marginBottomProperty();
		}
	};

	private static final CssMetaData<RowLayoutPane, Number> SPACING = new CssMetaData<RowLayoutPane, Number>("-fx-spacing", SizeConverter.getInstance(), Integer.valueOf(3)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(RowLayoutPane node) {
			return !node.spacingProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(RowLayoutPane node) {
			return (StyleableProperty<Number>) node.spacingProperty();
		}
	};

	private static final CssMetaData<RowLayoutPane, Boolean> WRAP = new CssMetaData<RowLayoutPane, Boolean>("-fx-wrap", BooleanConverter.getInstance(), Boolean.TRUE) { //$NON-NLS-1$

		@Override
		public boolean isSettable(RowLayoutPane node) {
			return !node.wrapProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Boolean> getStyleableProperty(RowLayoutPane node) {
			return (StyleableProperty<Boolean>) node.wrapProperty();
		}
	};

	private static final CssMetaData<RowLayoutPane, Boolean> PACK = new CssMetaData<RowLayoutPane, Boolean>("-fx-pack", BooleanConverter.getInstance(), Boolean.TRUE) { //$NON-NLS-1$

		@Override
		public boolean isSettable(RowLayoutPane node) {
			return !node.packProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Boolean> getStyleableProperty(RowLayoutPane node) {
			return (StyleableProperty<Boolean>) node.packProperty();
		}
	};

	private static final CssMetaData<RowLayoutPane, Boolean> FILL = new CssMetaData<RowLayoutPane, Boolean>("-fx-fill", BooleanConverter.getInstance(), Boolean.FALSE) { //$NON-NLS-1$

		@Override
		public boolean isSettable(RowLayoutPane node) {
			return !node.fillProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Boolean> getStyleableProperty(RowLayoutPane node) {
			return (StyleableProperty<Boolean>) node.fillProperty();
		}
	};

	private static final CssMetaData<RowLayoutPane, Boolean> CENTER = new CssMetaData<RowLayoutPane, Boolean>("-fx-center", BooleanConverter.getInstance(), Boolean.FALSE) { //$NON-NLS-1$

		@Override
		public boolean isSettable(RowLayoutPane node) {
			return !node.centerProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Boolean> getStyleableProperty(RowLayoutPane node) {
			return (StyleableProperty<Boolean>) node.centerProperty();
		}
	};

	private static final CssMetaData<RowLayoutPane, Boolean> JUSTIFY = new CssMetaData<RowLayoutPane, Boolean>("-fx-justify", BooleanConverter.getInstance(), Boolean.FALSE) { //$NON-NLS-1$

		@Override
		public boolean isSettable(RowLayoutPane node) {
			return !node.justifyProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Boolean> getStyleableProperty(RowLayoutPane node) {
			return (StyleableProperty<Boolean>) node.justifyProperty();
		}
	};

	private static final CssMetaData<RowLayoutPane, Boolean> HORIZONTAL = new CssMetaData<RowLayoutPane, Boolean>("-fx-horizontal", BooleanConverter.getInstance(), Boolean.FALSE) { //$NON-NLS-1$

		@Override
		public boolean isSettable(RowLayoutPane node) {
			return !node.horizontalProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Boolean> getStyleableProperty(RowLayoutPane node) {
			return (StyleableProperty<Boolean>) node.horizontalProperty();
		}
	};

	@NonNull
	private final IntegerProperty marginWidth = new SimpleStyleableIntegerProperty(MARGIN_WIDTH, this, "marginWidth", Integer.valueOf(0)); //$NON-NLS-1$
	@NonNull
	private final IntegerProperty marginHeight = new SimpleStyleableIntegerProperty(MARGIN_HEIGHT, this, "marginHeight", Integer.valueOf(0)); //$NON-NLS-1$

	@NonNull
	private final IntegerProperty marginLeft = new SimpleStyleableIntegerProperty(MARGIN_LEFT, this, "marginLeft", Integer.valueOf(0)); //$NON-NLS-1$
	@NonNull
	private final IntegerProperty marginTop = new SimpleStyleableIntegerProperty(MARGIN_TOP, this, "marginTop", Integer.valueOf(0)); //$NON-NLS-1$
	@NonNull
	private final IntegerProperty marginRight = new SimpleStyleableIntegerProperty(MARGIN_RIGHT, this, "marginRight", Integer.valueOf(0)); //$NON-NLS-1$
	@NonNull
	private final IntegerProperty marginBottom = new SimpleStyleableIntegerProperty(MARGIN_BOTTOM, this, "marginBottom", Integer.valueOf(0)); //$NON-NLS-1$

	@NonNull
	private IntegerProperty spacing = new SimpleStyleableIntegerProperty(SPACING, this, "spacing", Integer.valueOf(3)); //$NON-NLS-1$

	@NonNull
	private BooleanProperty wrap = new SimpleStyleableBooleanProperty(WRAP, this, "wrap", true); //$NON-NLS-1$

	@NonNull
	private BooleanProperty pack = new SimpleStyleableBooleanProperty(PACK, this, "pack", true); //$NON-NLS-1$

	@NonNull
	private BooleanProperty fill = new SimpleStyleableBooleanProperty(FILL, this, "fill", false); //$NON-NLS-1$

	@NonNull
	private BooleanProperty center = new SimpleStyleableBooleanProperty(CENTER, this, "center", false); //$NON-NLS-1$

	@NonNull
	private BooleanProperty justify = new SimpleStyleableBooleanProperty(JUSTIFY, this, "justify", false); //$NON-NLS-1$

	@NonNull
	private BooleanProperty horizontal = new SimpleStyleableBooleanProperty(HORIZONTAL, this, "horizontal", true); //$NON-NLS-1$

	@NonNull
	private static final String LAYOUT_KEY = "rowData"; //$NON-NLS-1$

	/**
	 * Associate a layout constraint with the node
	 * 
	 * @param n
	 *            the node
	 * @param griddata
	 *            the constraint
	 */
	public final static void setConstraint(@NonNull Node n, @NonNull RowData griddata) {
		setConstraint(n, LAYOUT_KEY, griddata);
	}

	/**
	 * Get the layout constraint for the node
	 * 
	 * @param n
	 *            the node
	 * @return the layout constraint or <code>null</code>
	 */
	public final static @Nullable RowData getConstraint(@NonNull Node n) {
		return (RowData) getConstraint(n, LAYOUT_KEY);
	}

	@Override
	protected org.eclipse.fx.ui.panes.AbstractLayoutPane.Size computeSize(double wHint, double hHint, boolean flushCache) {
		Size extent;
		if (isHorizontal()) {
			extent = layoutHorizontal(false, (wHint != FX_DEFAULT) && isWrap(), wHint, flushCache);
		} else {
			extent = layoutVertical(false, (hHint != FX_DEFAULT) && isWrap(), hHint, flushCache);
		}

		double width = extent.width;
		double height = extent.height;

		if (wHint != FX_DEFAULT)
			width = wHint;
		if (hHint != FX_DEFAULT)
			height = hHint;

		return new Size(width, height);
	}

	private static Size computeSize(@NonNull Node control, boolean flushCache) {
		int wHint = FX_DEFAULT, hHint = FX_DEFAULT;
		RowData data = getConstraint(control);
		if (data != null) {
			wHint = data.getWidth();
			hHint = data.getHeight();
		}
		return new Size(control.prefWidth(wHint), control.prefHeight(hHint));
	}

	@Override
	protected void layoutChildren() {
		super.layoutChildren();
		Bounds clientArea = getLayoutBounds();
		if (isHorizontal()) {
			layoutHorizontal(true, isWrap(), clientArea.getWidth(), true);
		} else {
			layoutVertical(true, isWrap(), clientArea.getHeight(), true);
		}
	}
	
	private int getInnerMarginLeft() {
		return (int) Math.ceil(getMarginWidth() + getMarginLeft() + getPadding().getLeft());
	}

	private int getInnerMarginRight() {
		return (int) Math.ceil(getMarginWidth() + getMarginRight() + getPadding().getRight());
	}

	private int getInnerMarginTop() {
		return (int) Math.ceil(getMarginHeight() + getMarginTop() + getPadding().getTop());
	}

	private int getInnerMarginBottom() {
		return (int) Math.ceil(getMarginHeight() + getMarginBottom() + getPadding().getBottom());
	}

	Size layoutHorizontal(boolean move, boolean wrap, double width, boolean flushCache) {
		@SuppressWarnings("null")
		@NonNull
		Node[] children = getChildren().toArray(new Node[0]);
		int count = 0;
		for (int i = 0; i < children.length; i++) {
			Node control = children[i];
			RowData data = getConstraint(control);
			if (data == null || !data.isExclude()) {
				children[count++] = children[i];
			}
		}
		if (count == 0) {
			return new Size(getInnerMarginLeft() + getInnerMarginRight(), getInnerMarginTop() + getInnerMarginBottom());
		}
		double childWidth = 0, childHeight = 0, maxHeight = 0;
		if (!isPack()) {
			for (int i = 0; i < count; i++) {
				Node child = children[i];
				Size size = computeSize(child, flushCache);
				childWidth = Math.max(childWidth, size.width);
				childHeight = Math.max(childHeight, size.height);
			}
			maxHeight = childHeight;
		}
		double clientX = 0, clientY = 0;
		if (move) {
			Bounds rect = getLayoutBounds();
			clientX = rect.getMinX();
			clientY = rect.getMinY();
		}
		double[] wraps = null;
		boolean wrapped = false;
		Bounds[] bounds = null;
		if (move && (isJustify() || isFill() || isCenter())) {
			bounds = new Bounds[count];
			wraps = new double[count];
		}
		double maxX = 0, x = getInnerMarginLeft(), y = getInnerMarginTop();
		for (int i = 0; i < count; i++) {
			Node child = children[i];
			if (isPack()) {
				Size size = computeSize(child, flushCache);
				childWidth = size.width;
				childHeight = size.height;
			}
			if (wrap && (i != 0) && (x + childWidth > width)) {
				wrapped = true;
				if (move && (isJustify() || isFill() || isCenter())) {
					if (wraps != null) {
						wraps[i - 1] = maxHeight;
					}
				}

				x = getInnerMarginLeft();
				y += getSpacing() + maxHeight;
				if (isPack())
					maxHeight = 0;
			}
			if (isPack() || isFill() || isCenter()) {
				maxHeight = Math.max(maxHeight, childHeight);
			}
			if (move) {
				double childX = x + clientX, childY = y + clientY;
				if (isJustify() || isFill() || isCenter()) {
					if (bounds != null) {
						bounds[i] = new BoundingBox(childX, childY, childWidth, childHeight);
					}
				} else {
					child.resizeRelocate(childX, childY, childWidth, childHeight);
				}
			}
			x += getSpacing() + childWidth;
			maxX = Math.max(maxX, x);
		}
		maxX = Math.max(clientX + getInnerMarginLeft(), maxX - getSpacing());
		if (!wrapped)
			maxX += getInnerMarginRight();
		if (move && (isJustify() || isFill() || isCenter())) {
			double space = 0, margin = 0;
			if (!wrapped) {
				space = Math.max(0, (width - maxX) / (count + 1));
				margin = Math.max(0, ((width - maxX) % (count + 1)) / 2);
			} else {
				if (isFill() || isJustify() || isCenter()) {
					int last = 0;
					if (count > 0) {
						if (wraps != null) {
							wraps[count - 1] = maxHeight;
						}
					}

					for (int i = 0; i < count; i++) {
						if (wraps != null && wraps[i] != 0) {
							int wrapCount = i - last + 1;
							if (isJustify()) {
								int wrapX = 0;
								for (int j = last; j <= i; j++) {
									if (bounds != null) {
										wrapX += bounds[j].getWidth() + getSpacing();
									}
								}
								space = Math.max(0, (width - wrapX) / (wrapCount + 1));
								margin = Math.max(0, ((width - wrapX) % (wrapCount + 1)) / 2);
							}
							for (int j = last; j <= i; j++) {
								if (isJustify()) {
									if (bounds != null) {
										bounds[j] = changeX(bounds[j], (space * (j - last + 1)) + margin);
									}
								}
								if (isFill()) {
									if (bounds != null) {
										bounds[j] = changeHeight(bounds[j], wraps[i]);
									}
								} else {
									if (isCenter()) {
										if (bounds != null) {
											bounds[j] = changeY(bounds[j], Math.max(0, (wraps[i] - bounds[j].getHeight()) / 2));
										}
									}
								}
							}
							last = i + 1;
						}
					}
				}
			}
			for (int i = 0; i < count; i++) {
				if (!wrapped) {
					if (isJustify()) {
						if (bounds != null) {
							bounds[i] = changeX(bounds[i], (space * (i + 1)) + margin);
						}
					}
					if (isFill()) {
						if (bounds != null) {
							bounds[i] = changeHeight(bounds[i], maxHeight);
						}
					} else {
						if (isCenter()) {
							if (bounds != null) {
								bounds[i] = changeY(bounds[i], Math.max(0, (maxHeight - bounds[i].getHeight()) / 2));
							}
						}
					}
				}
				if (bounds != null) {
					children[i].resizeRelocate(bounds[i].getMinX(), bounds[i].getMinY(), bounds[i].getWidth(), bounds[i].getHeight());
				}
			}
		}
		return new Size(maxX, y + maxHeight + getInnerMarginBottom());
	}

	Size layoutVertical(boolean move, boolean wrap, double height, boolean flushCache) {
		@SuppressWarnings("null")
		@NonNull
		Node[] children = getChildren().toArray(new Node[0]);
		int count = 0;
		for (int i = 0; i < children.length; i++) {
			Node control = children[i];
			RowData data = getConstraint(control);
			if (data == null || !data.isExclude()) {
				children[count++] = children[i];
			}
		}
		if (count == 0) {
			return new Size(getInnerMarginLeft() + getInnerMarginRight(), getInnerMarginTop() + getInnerMarginBottom());
		}
		double childWidth = 0, childHeight = 0, maxWidth = 0;
		if (!isPack()) {
			for (int i = 0; i < count; i++) {
				Node child = children[i];
				Size size = computeSize(child, flushCache);
				childWidth = Math.max(childWidth, size.width);
				childHeight = Math.max(childHeight, size.height);
			}
			maxWidth = childWidth;
		}
		double clientX = 0, clientY = 0;
		if (move) {
			Bounds rect = getLayoutBounds();
			clientX = rect.getMinX();
			clientY = rect.getMinY();
		}
		double[] wraps = null;
		boolean wrapped = false;
		Bounds[] bounds = null;
		if (move && (isJustify() || isFill() || isCenter())) {
			bounds = new Bounds[count];
			wraps = new double[count];
		}
		double maxY = 0, x = getInnerMarginLeft(), y = getInnerMarginBottom();
		for (int i = 0; i < count; i++) {
			Node child = children[i];
			if (isPack()) {
				Size size = computeSize(child, flushCache);
				childWidth = size.width;
				childHeight = size.height;
			}
			if (wrap && (i != 0) && (y + childHeight > height)) {
				wrapped = true;
				if (move && (isJustify() || isFill() || isCenter())) {
					if (wraps != null) {
						wraps[i - 1] = maxWidth;
					}
				}

				x += getSpacing() + maxWidth;
				y = getInnerMarginTop();
				if (isPack())
					maxWidth = 0;
			}
			if (isPack() || isFill() || isCenter()) {
				maxWidth = Math.max(maxWidth, childWidth);
			}
			if (move) {
				double childX = x + clientX, childY = y + clientY;
				if (isJustify() || isFill() || isCenter()) {
					if (bounds != null) {
						bounds[i] = new BoundingBox(childX, childY, childWidth, childHeight);
					}
				} else {
					child.resizeRelocate(childX, childY, childWidth, childHeight);
				}
			}
			y += getSpacing() + childHeight;
			maxY = Math.max(maxY, y);
		}
		maxY = Math.max(clientY + getInnerMarginTop(), maxY - getSpacing());
		if (!wrapped)
			maxY += getInnerMarginBottom();
		if (move && (isJustify() || isFill() || isCenter())) {
			double space = 0, margin = 0;
			if (!wrapped) {
				space = Math.max(0, (height - maxY) / (count + 1));
				margin = Math.max(0, ((height - maxY) % (count + 1)) / 2);
			} else {
				if (isFill() || isJustify() || isCenter()) {
					int last = 0;
					if (count > 0) {
						if (wraps != null) {
							wraps[count - 1] = maxWidth;
						}
					}
					for (int i = 0; i < count; i++) {
						if (wraps != null && wraps[i] != 0) {
							int wrapCount = i - last + 1;
							if (isJustify()) {
								int wrapY = 0;
								for (int j = last; j <= i; j++) {
									if (bounds != null) {
										wrapY += bounds[j].getHeight() + getSpacing();
									}
								}
								space = Math.max(0, (height - wrapY) / (wrapCount + 1));
								margin = Math.max(0, ((height - wrapY) % (wrapCount + 1)) / 2);
							}
							for (int j = last; j <= i; j++) {
								if (isJustify()) {
									if (bounds != null) {
										bounds[j] = changeY(bounds[j], (space * (j - last + 1)) + margin);
									}
								}
								if (isFill()) {
									if (bounds != null) {
										bounds[j] = changeWidth(bounds[j], wraps[i]);
									}
								} else {
									if (isCenter()) {
										if (bounds != null) {
											bounds[j] = changeX(bounds[j], Math.max(0, (wraps[i] - bounds[j].getWidth()) / 2));
										}
									}
								}
							}
							last = i + 1;
						}
					}
				}
			}
			for (int i = 0; i < count; i++) {
				if (!wrapped) {
					if (isJustify()) {
						if (bounds != null) {
							bounds[i] = changeY(bounds[i], (space * (i + 1)) + margin);
						}
					}
					if (isFill()) {
						if (bounds != null) {
							bounds[i] = changeWidth(bounds[i], maxWidth);
						}
					} else {
						if (isCenter()) {
							if (bounds != null) {
								bounds[i] = changeX(bounds[i], Math.max(0, (maxWidth - bounds[i].getWidth()) / 2));
							}
						}
					}

				}
				if (bounds != null) {
					children[i].resizeRelocate(bounds[i].getMinX(), bounds[i].getMinY(), bounds[i].getWidth(), bounds[i].getHeight());
				}
			}
		}
		return new Size(x + maxWidth + getInnerMarginRight(), maxY);
	}

	private static Bounds changeX(Bounds original, double amount) {
		return new BoundingBox(original.getMinX() + amount, original.getMinY(), original.getWidth(), original.getHeight());
	}

	private static Bounds changeY(Bounds original, double amount) {
		return new BoundingBox(original.getMinX(), original.getMinY() + amount, original.getWidth(), original.getHeight());
	}

	private static Bounds changeHeight(Bounds original, double amount) {
		return new BoundingBox(original.getMinX(), original.getMinY(), original.getWidth(), original.getHeight() + amount);
	}

	private static Bounds changeWidth(Bounds original, double amount) {
		return new BoundingBox(original.getMinX(), original.getMinY(), original.getWidth() + amount, original.getHeight());
	}

	/**
	 * center specifies whether the controls in a row should be centered
	 * vertically in each cell for horizontal layouts, or centered horizontally
	 * in each cell for vertical layouts.
	 * 
	 * <p>
	 * The default is <code>false</code>
	 * </p>
	 * 
	 * @param value
	 *            the new value
	 */
	public void setCenter(boolean value) {
		centerProperty().set(value);
	}

	/**
	 * center specifies whether the controls in a row should be centered
	 * vertically in each cell for horizontal layouts, or centered horizontally
	 * in each cell for vertical layouts.
	 * 
	 * <p>
	 * The default is <code>false</code>
	 * </p>
	 * 
	 * @return the current value
	 */
	public boolean isCenter() {
		return centerProperty().get();
	}

	/**
	 * center specifies whether the controls in a row should be centered
	 * vertically in each cell for horizontal layouts, or centered horizontally
	 * in each cell for vertical layouts.
	 * 
	 * <p>
	 * The default is <code>false</code>
	 * </p>
	 * 
	 * @return the property
	 */
	public @NonNull BooleanProperty centerProperty() {
		return this.center;
	}

	/**
	 * fill specifies whether the controls in a row should be all the same
	 * height for horizontal layouts, or the same width for vertical layouts.
	 * 
	 * <p>
	 * The default is <code>false</code>
	 * </p>
	 * 
	 * @param value
	 *            the new value
	 */
	public void setFill(boolean value) {
		fillProperty().set(value);
	}

	/**
	 * fill specifies whether the controls in a row should be all the same
	 * height for horizontal layouts, or the same width for vertical layouts.
	 * 
	 * <p>
	 * The default is <code>false</code>
	 * </p>
	 * 
	 * @return the current value
	 */
	public boolean isFill() {
		return fillProperty().get();
	}

	/**
	 * fill specifies whether the controls in a row should be all the same
	 * height for horizontal layouts, or the same width for vertical layouts.
	 * 
	 * <p>
	 * The default is <code>false</code>
	 * </p>
	 * 
	 * @return the property
	 */
	public @NonNull BooleanProperty fillProperty() {
		return this.fill;
	}

	/**
	 * justify specifies whether the controls in a row should be fully
	 * justified, with any extra space placed between the controls.
	 * <p>
	 * The default is <code>false</code>
	 * </p>
	 * 
	 * @param value
	 *            the new value
	 */
	public void setJustify(boolean value) {
		justifyProperty().set(value);
	}

	/**
	 * justify specifies whether the controls in a row should be fully
	 * justified, with any extra space placed between the controls.
	 * <p>
	 * The default is <code>false</code>
	 * </p>
	 * 
	 * @return the current value
	 */
	public boolean isJustify() {
		return justifyProperty().get();
	}

	/**
	 * justify specifies whether the controls in a row should be fully
	 * justified, with any extra space placed between the controls.
	 * <p>
	 * The default is <code>false</code>
	 * </p>
	 * 
	 * @return the property
	 */
	public @NonNull BooleanProperty justifyProperty() {
		return this.justify;
	}

	/**
	 * marginBottom specifies the number of pixels of vertical margin that will
	 * be placed along the bottom edge of the layout.
	 * <p>
	 * The default is 0
	 * </p>
	 * 
	 * @param value
	 */
	public void setMarginBottom(int value) {
		marginBottomProperty().set(value);
	}

	/**
	 * marginBottom specifies the number of pixels of vertical margin that will
	 * be placed along the bottom edge of the layout.
	 * <p>
	 * The default is 0
	 * </p>
	 * 
	 * @return the current value
	 */
	public int getMarginBottom() {
		return marginBottomProperty().get();
	}

	/**
	 * marginBottom specifies the number of pixels of vertical margin that will
	 * be placed along the bottom edge of the layout.
	 * <p>
	 * The default is 0
	 * </p>
	 * 
	 * @return the property
	 */
	public @NonNull IntegerProperty marginBottomProperty() {
		return this.marginBottom;
	}

	/**
	 * marginHeight specifies the number of pixels of vertical margin that will
	 * be placed along the top and bottom edges of the layout.
	 *
	 * <p>
	 * The default is 0
	 * </p>
	 * 
	 * @param value
	 *            the new value
	 */
	public void setMarginHeight(int value) {
		marginHeightProperty().set(value);
	}

	/**
	 * marginHeight specifies the number of pixels of vertical margin that will
	 * be placed along the top and bottom edges of the layout.
	 *
	 * <p>
	 * The default is 0
	 * </p>
	 * 
	 * @return the current value
	 */
	public int getMarginHeight() {
		return marginHeightProperty().get();
	}

	/**
	 * marginHeight specifies the number of pixels of vertical margin that will
	 * be placed along the top and bottom edges of the layout.
	 *
	 * <p>
	 * The default is 0
	 * </p>
	 * 
	 * @return the property
	 */
	public @NonNull IntegerProperty marginHeightProperty() {
		return this.marginHeight;
	}

	/**
	 * marginLeft specifies the number of pixels of horizontal margin that will
	 * be placed along the left edge of the layout.
	 * <p>
	 * The default is 0
	 * </p>
	 * 
	 * @param value
	 *            the new value
	 */
	public void setMarginLeft(int value) {
		marginLeftProperty().set(value);
	}

	/**
	 * marginLeft specifies the number of pixels of horizontal margin that will
	 * be placed along the left edge of the layout.
	 * <p>
	 * The default is 0
	 * </p>
	 * 
	 * @return the current value
	 */
	public int getMarginLeft() {
		return marginLeftProperty().get();
	}

	/**
	 * marginLeft specifies the number of pixels of horizontal margin that will
	 * be placed along the left edge of the layout.
	 * <p>
	 * The default is 0
	 * </p>
	 * 
	 * @return the property
	 */
	public @NonNull IntegerProperty marginLeftProperty() {
		return this.marginLeft;
	}

	/**
	 * marginRight specifies the number of pixels of horizontal margin that will
	 * be placed along the right edge of the layout.
	 * <p>
	 * The default is 0
	 * </p>
	 * 
	 * @param value
	 *            the new value
	 */
	public void setMarginRight(int value) {
		marginRightProperty().set(value);
	}

	/**
	 * marginRight specifies the number of pixels of horizontal margin that will
	 * be placed along the right edge of the layout.
	 * <p>
	 * The default is 0
	 * </p>
	 * 
	 * @return the current value
	 */
	public int getMarginRight() {
		return marginRightProperty().get();
	}

	/**
	 * marginRight specifies the number of pixels of horizontal margin that will
	 * be placed along the right edge of the layout.
	 * <p>
	 * The default is 0
	 * </p>
	 * 
	 * @return the property
	 */
	public @NonNull IntegerProperty marginRightProperty() {
		return this.marginRight;
	}

	/**
	 * marginTop specifies the number of pixels of vertical margin that will be
	 * placed along the top edge of the layout.
	 * <p>
	 * The default is 0
	 * </p>
	 * 
	 * @param value
	 *            the new value
	 */
	public void setMarginTop(int value) {
		marginTopProperty().set(value);
	}

	/**
	 * marginTop specifies the number of pixels of vertical margin that will be
	 * placed along the top edge of the layout.
	 * <p>
	 * The default is 0
	 * </p>
	 * 
	 * @return the current value
	 */
	public int getMarginTop() {
		return marginTopProperty().get();
	}

	/**
	 * marginTop specifies the number of pixels of vertical margin that will be
	 * placed along the top edge of the layout.
	 * <p>
	 * The default is 0
	 * </p>
	 * 
	 * @return the property
	 */
	public @NonNull IntegerProperty marginTopProperty() {
		return this.marginTop;
	}

	/**
	 * marginWidth specifies the number of pixels of horizontal margin that will
	 * be placed along the left and right edges of the layout.
	 * <p>
	 * The default is 0
	 * </p>
	 * 
	 * @param value
	 *            the new value
	 */
	public void setMarginWidth(int value) {
		this.marginWidth.set(value);
	}

	/**
	 * marginWidth specifies the number of pixels of horizontal margin that will
	 * be placed along the left and right edges of the layout.
	 * <p>
	 * The default is 0
	 * </p>
	 * 
	 * @return the current value
	 */
	public int getMarginWidth() {
		return marginWidthProperty().get();
	}

	/**
	 * marginWidth specifies the number of pixels of horizontal margin that will
	 * be placed along the left and right edges of the layout.
	 * <p>
	 * The default is 0
	 * </p>
	 * 
	 * @return the property
	 */
	public @NonNull IntegerProperty marginWidthProperty() {
		return this.marginWidth;
	}

	/**
	 * pack specifies whether all controls in the layout take their preferred
	 * size. If pack is false, all controls will have the same size which is the
	 * size required to accommodate the largest preferred height and the largest
	 * preferred width of all the controls in the layout.
	 * <p>
	 * The default is <code>true</code>
	 * </p>
	 * 
	 * @param value
	 *            the new value
	 */
	public void setPack(boolean value) {
		packProperty().set(value);
	}

	/**
	 * pack specifies whether all controls in the layout take their preferred
	 * size. If pack is false, all controls will have the same size which is the
	 * size required to accommodate the largest preferred height and the largest
	 * preferred width of all the controls in the layout.
	 * <p>
	 * The default is <code>true</code>
	 * </p>
	 * 
	 * @return the current value
	 */
	public boolean isPack() {
		return packProperty().get();
	}

	/**
	 * pack specifies whether all controls in the layout take their preferred
	 * size. If pack is false, all controls will have the same size which is the
	 * size required to accommodate the largest preferred height and the largest
	 * preferred width of all the controls in the layout.
	 * <p>
	 * The default is <code>true</code>
	 * </p>
	 * 
	 * @return the property
	 */
	public @NonNull BooleanProperty packProperty() {
		return this.pack;
	}

	/**
	 * spacing specifies the number of pixels between the edge of one cell and
	 * the edge of its neighboring cell.
	 * 
	 * <p>
	 * The default is 3
	 * </p>
	 * 
	 * @param value
	 *            the spacing
	 */
	public void setSpacing(int value) {
		spacingProperty().set(value);
	}

	/**
	 * spacing specifies the number of pixels between the edge of one cell and
	 * the edge of its neighboring cell.
	 * 
	 * <p>
	 * The default is 3
	 * </p>
	 * 
	 * @return the current value
	 */
	public int getSpacing() {
		return spacingProperty().get();
	}

	/**
	 * spacing specifies the number of pixels between the edge of one cell and
	 * the edge of its neighboring cell.
	 * 
	 * <p>
	 * The default is 3
	 * </p>
	 * 
	 * @return the property
	 */
	public @NonNull IntegerProperty spacingProperty() {
		return this.spacing;
	}

	/**
	 * wrap specifies whether a control will be wrapped to the next row if there
	 * is insufficient space on the current row.
	 * <p>
	 * The default is <code>true</code>
	 * </p>
	 * 
	 * @param value
	 *            the new value
	 */
	public void setWrap(boolean value) {
		wrapProperty().set(value);
	}

	/**
	 * wrap specifies whether a control will be wrapped to the next row if there
	 * is insufficient space on the current row.
	 * <p>
	 * The default is <code>true</code>
	 * </p>
	 * 
	 * @return the current value
	 */
	public boolean isWrap() {
		return wrapProperty().get();
	}

	/**
	 * wrap specifies whether a control will be wrapped to the next row if there
	 * is insufficient space on the current row.
	 * <p>
	 * The default is <code>true</code>
	 * </p>
	 * 
	 * @return the property
	 */
	public @NonNull BooleanProperty wrapProperty() {
		return this.wrap;
	}

	/**
	 * horizontal specifies if controls are layouted horizontally or vertically
	 * <p>
	 * The default is <code>true</code>
	 * </p>
	 * 
	 * @param value
	 *            the new value
	 */
	public void setHorizontal(boolean value) {
		horizontalProperty().set(value);
	}

	/**
	 * horizontal specifies if controls are layouted horizontally or vertically
	 * <p>
	 * The default is <code>true</code>
	 * </p>
	 * 
	 * @return the current value
	 */
	public boolean isHorizontal() {
		return horizontalProperty().get();
	}

	/**
	 * horizontal specifies if controls are layouted horizontally or vertically
	 * <p>
	 * The default is <code>true</code>
	 * </p>
	 * 
	 * @return the property
	 */
	public @NonNull BooleanProperty horizontalProperty() {
		return this.horizontal;
	}
}

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

import java.util.WeakHashMap;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Node;

public class RowLayoutPane extends AbstractLayoutPane<RowData> {

	public enum Type {
		VERTICAL,
		HORIZONTAL
	}
	
	/**
	 * type specifies whether the layout places controls in rows or columns.
	 * 
	 * The default value is HORIZONTAL.
	 * 
	 * Possible values are:
	 * <ul>
	 * <li>HORIZONTAL: Position the controls horizontally from left to right</li>
	 * <li>VERTICAL: Position the controls vertically from top to bottom</li>
	 * </ul>
	 * 
	 * @since 2.0
	 */
	public ObjectProperty<Type> type = new SimpleObjectProperty<Type>(this, "type", Type.HORIZONTAL);

	/**
	 * marginWidth specifies the number of pixels of horizontal margin that will
	 * be placed along the left and right edges of the layout.
	 * 
	 * The default value is 0.
	 * 
	 * @since 3.0
	 */
	public IntegerProperty marginWidth = new SimpleIntegerProperty(this, "marginWidth", 0);

	/**
	 * marginHeight specifies the number of pixels of vertical margin that will
	 * be placed along the top and bottom edges of the layout.
	 * 
	 * The default value is 0.
	 * 
	 * @since 3.0
	 */
	public IntegerProperty marginHeight = new SimpleIntegerProperty(this, "marginHeight", 0);

	/**
	 * spacing specifies the number of pixels between the edge of one cell and
	 * the edge of its neighbouring cell.
	 * 
	 * The default value is 3.
	 */
	public IntegerProperty spacing = new SimpleIntegerProperty(this, "spacing", 3);

	/**
	 * wrap specifies whether a control will be wrapped to the next row if there
	 * is insufficient space on the current row.
	 * 
	 * The default value is true.
	 */
	public BooleanProperty wrap = new SimpleBooleanProperty(this, "wrap", true);

	/**
	 * pack specifies whether all controls in the layout take their preferred
	 * size. If pack is false, all controls will have the same size which is the
	 * size required to accommodate the largest preferred height and the largest
	 * preferred width of all the controls in the layout.
	 * 
	 * The default value is true.
	 */
	public BooleanProperty pack = new SimpleBooleanProperty(this, "pack", true);

	/**
	 * fill specifies whether the controls in a row should be all the same
	 * height for horizontal layouts, or the same width for vertical layouts.
	 * 
	 * The default value is false.
	 * 
	 * @since 3.0
	 */
	public BooleanProperty fill = new SimpleBooleanProperty(this, "fill", false);

	/**
	 * center specifies whether the controls in a row should be centered
	 * vertically in each cell for horizontal layouts, or centered horizontally
	 * in each cell for vertical layouts.
	 * 
	 * The default value is false.
	 * 
	 * @since 3.4
	 */
	public BooleanProperty center = new SimpleBooleanProperty(this, "center", false);

	/**
	 * justify specifies whether the controls in a row should be fully
	 * justified, with any extra space placed between the controls.
	 * 
	 * The default value is false.
	 */
	public BooleanProperty justify = new SimpleBooleanProperty(this, "justify", false);

	/**
	 * marginLeft specifies the number of pixels of horizontal margin that will
	 * be placed along the left edge of the layout.
	 * 
	 * The default value is 3.
	 */
	public IntegerProperty marginLeft = new SimpleIntegerProperty(this, "marginLeft", 3);

	/**
	 * marginTop specifies the number of pixels of vertical margin that will be
	 * placed along the top edge of the layout.
	 * 
	 * The default value is 3.
	 */
	public IntegerProperty marginTop = new SimpleIntegerProperty(this, "marginTop", 3);

	/**
	 * marginRight specifies the number of pixels of horizontal margin that will
	 * be placed along the right edge of the layout.
	 * 
	 * The default value is 3.
	 */
	public IntegerProperty marginRight = new SimpleIntegerProperty(this, "marginRight", 3);

	/**
	 * marginBottom specifies the number of pixels of vertical margin that will
	 * be placed along the bottom edge of the layout.
	 * 
	 * The default value is 3.
	 */
	public IntegerProperty marginBottom = new SimpleIntegerProperty(this, "marginBottom", 3);

	private static WeakHashMap<Node, RowData> CONSTRAINTS = new WeakHashMap<Node, RowData>();
	
	public static void setConstraint(Node n, RowData griddata) {
		CONSTRAINTS.put(n, griddata);
	}
	
	public static RowData getConstraint(Node n) {
		return CONSTRAINTS.get(n);
	}
	
	@Override
	protected org.eclipse.fx.ui.panes.AbstractLayoutPane.Size computeSize(double wHint, double hHint, boolean flushCache) {
		Size extent;
		if (type.get() == Type.HORIZONTAL) {
			extent = layoutHorizontal(false, (wHint != FX_DEFAULT) && wrap.get(), wHint, flushCache);
		} else {
			extent = layoutVertical(false, (hHint != FX_DEFAULT) && wrap.get(), hHint, flushCache);
		}

		double width = extent.width;
		double height = extent.height;

		if (wHint != FX_DEFAULT)
			width = wHint;
		if (hHint != FX_DEFAULT)
			height = hHint;

		return new Size(width, height);
	}

	Size computeSize(Node control, boolean flushCache) {
		int wHint = FX_DEFAULT, hHint = FX_DEFAULT;
		RowData data = (RowData) getConstraint(control);
		if (data != null) {
			wHint = data.width.get();
			hHint = data.height.get();
		}
		return new Size(control.prefWidth(wHint), control.prefHeight(hHint));
	}

	@Override
	protected void layoutChildren() {
		super.layoutChildren();
		Bounds clientArea = getLayoutBounds();
		if (type.get() == Type.HORIZONTAL) {
			layoutHorizontal(true, wrap.get(), clientArea.getWidth(), true);
		} else {
			layoutVertical(true, wrap.get(), clientArea.getHeight(), true);
		}
	}

	Size layoutHorizontal(boolean move, boolean wrap, double width, boolean flushCache) {
		Node[] children = getChildren().toArray(new Node[0]);
		int count = 0;
		for (int i = 0; i < children.length; i++) {
			Node control = children[i];
			RowData data = (RowData) getConstraint(control);
			if (data == null || !data.exclude.get()) {
				children[count++] = children[i];
			}
		}
		if (count == 0) {
			return new Size(marginLeft.get() + marginWidth.get() * 2 + marginRight.get(), marginTop.get() + marginHeight.get() * 2 + marginBottom.get());
		}
		double childWidth = 0, childHeight = 0, maxHeight = 0;
		if (!pack.get()) {
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
		if (move && (justify.get() || fill.get() || center.get())) {
			bounds = new Bounds[count];
			wraps = new double[count];
		}
		double maxX = 0, x = marginLeft.get() + marginWidth.get(), y = marginTop.get() + marginHeight.get();
		for (int i = 0; i < count; i++) {
			Node child = children[i];
			if (pack.get()) {
				Size size = computeSize(child, flushCache);
				childWidth = size.width;
				childHeight = size.height;
			}
			if (wrap && (i != 0) && (x + childWidth > width)) {
				wrapped = true;
				if (move && (justify.get() || fill.get() || center.get())) {
					if( wraps != null ) {
						wraps[i - 1] = maxHeight;	
					}
				}
					
				x = marginLeft.get() + marginWidth.get();
				y += spacing.get() + maxHeight;
				if (pack.get())
					maxHeight = 0;
			}
			if (pack.get() || fill.get() || center.get()) {
				maxHeight = Math.max(maxHeight, childHeight);
			}
			if (move) {
				double childX = x + clientX, childY = y + clientY;
				if (justify.get() || fill.get() || center.get()) {
					if( bounds != null ) {
						bounds[i] = new BoundingBox(childX, childY, childWidth, childHeight);	
					}
				} else {
					child.resizeRelocate(childX, childY, childWidth, childHeight);
				}
			}
			x += spacing.get() + childWidth;
			maxX = Math.max(maxX, x);
		}
		maxX = Math.max(clientX + marginLeft.get() + marginWidth.get(), maxX - spacing.get());
		if (!wrapped)
			maxX += marginRight.get() + marginWidth.get();
		if (move && (justify.get() || fill.get() || center.get())) {
			double space = 0, margin = 0;
			if (!wrapped) {
				space = Math.max(0, (width - maxX) / (count + 1));
				margin = Math.max(0, ((width - maxX) % (count + 1)) / 2);
			} else {
				if (fill.get() || justify.get() || center.get()) {
					int last = 0;
					if (count > 0) {
						if( wraps != null ) {
							wraps[count - 1] = maxHeight;	
						}
					}
						
					for (int i = 0; i < count; i++) {
						if ( wraps != null && wraps[i] != 0) {
							int wrapCount = i - last + 1;
							if (justify.get()) {
								int wrapX = 0;
								for (int j = last; j <= i; j++) {
									if( bounds != null ) {
										wrapX += bounds[j].getWidth() + spacing.get();	
									}
								}
								space = Math.max(0, (width - wrapX) / (wrapCount + 1));
								margin = Math.max(0, ((width - wrapX) % (wrapCount + 1)) / 2);
							}
							for (int j = last; j <= i; j++) {
								if (justify.get()) {
									if( bounds != null ) {
										bounds[j] = changeX(bounds[j], (space * (j - last + 1)) + margin);	
									}
								}
								if (fill.get()) {
									if( bounds != null ) {
										bounds[j] = changeHeight(bounds[j], wraps[i]);	
									}
								} else {
									if (center.get()) {
										if( bounds != null ) {
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
					if (justify.get()) {
						if( bounds != null ) {
							bounds[i] = changeX(bounds[i], (space * (i + 1)) + margin);	
						}
					}
					if (fill.get()) {
						if( bounds != null ) {
							bounds[i] = changeHeight(bounds[i], maxHeight);	
						}
					} else {
						if (center.get()) {
							if( bounds != null ) {
								bounds[i] = changeY(bounds[i], Math.max(0, (maxHeight - bounds[i].getHeight()) / 2));	
							}
						}
					}
				}
				if( bounds != null ) {
					children[i].resizeRelocate(bounds[i].getMinX(), bounds[i].getMinY(), bounds[i].getWidth(), bounds[i].getHeight());	
				}
			}
		}
		return new Size(maxX, y + maxHeight + marginBottom.get() + marginHeight.get());
	}

	Size layoutVertical(boolean move, boolean wrap, double height, boolean flushCache) {
		Node[] children = getChildren().toArray(new Node[0]);
		int count = 0;
		for (int i = 0; i < children.length; i++) {
			Node control = children[i];
			RowData data = (RowData) getConstraint(control);
			if (data == null || !data.exclude.get()) {
				children[count++] = children[i];
			}
		}
		if (count == 0) {
			return new Size(marginLeft.get() + marginWidth.get() * 2 + marginRight.get(), marginTop.get() + marginHeight.get() * 2 + marginBottom.get());
		}
		double childWidth = 0, childHeight = 0, maxWidth = 0;
		if (!pack.get()) {
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
		if (move && (justify.get() || fill.get() || center.get())) {
			bounds = new Bounds[count];
			wraps = new double[count];
		}
		double maxY = 0, x = marginLeft.get() + marginWidth.get(), y = marginTop.get() + marginHeight.get();
		for (int i = 0; i < count; i++) {
			Node child = children[i];
			if (pack.get()) {
				Size size = computeSize(child, flushCache);
				childWidth = size.width;
				childHeight = size.height;
			}
			if (wrap && (i != 0) && (y + childHeight > height)) {
				wrapped = true;
				if (move && (justify.get() || fill.get() || center.get())) {
					if( wraps != null ) {
						wraps[i - 1] = maxWidth;	
					}
				}
					
				x += spacing.get() + maxWidth;
				y = marginTop.get() + marginHeight.get();
				if (pack.get())
					maxWidth = 0;
			}
			if (pack.get() || fill.get() || center.get()) {
				maxWidth = Math.max(maxWidth, childWidth);
			}
			if (move) {
				double childX = x + clientX, childY = y + clientY;
				if (justify.get() || fill.get() || center.get()) {
					if( bounds != null ) {
						bounds[i] = new BoundingBox(childX, childY, childWidth, childHeight);	
					}
				} else {
					child.resizeRelocate(childX, childY, childWidth, childHeight);
				}
			}
			y += spacing.get() + childHeight;
			maxY = Math.max(maxY, y);
		}
		maxY = Math.max(clientY + marginTop.get() + marginHeight.get(), maxY - spacing.get());
		if (!wrapped)
			maxY += marginBottom.get() + marginHeight.get();
		if (move && (justify.get() || fill.get() || center.get())) {
			double space = 0, margin = 0;
			if (!wrapped) {
				space = Math.max(0, (height - maxY) / (count + 1));
				margin = Math.max(0, ((height - maxY) % (count + 1)) / 2);
			} else {
				if (fill.get() || justify.get() || center.get()) {
					int last = 0;
					if (count > 0) {
						if( wraps != null ) {
							wraps[count - 1] = maxWidth;	
						}
					}
					for (int i = 0; i < count; i++) {
						if (wraps != null && wraps[i] != 0) {
							int wrapCount = i - last + 1;
							if (justify.get()) {
								int wrapY = 0;
								for (int j = last; j <= i; j++) {
									if( bounds != null ) {
										wrapY += bounds[j].getHeight() + spacing.get();	
									}
								}
								space = Math.max(0, (height - wrapY) / (wrapCount + 1));
								margin = Math.max(0, ((height - wrapY) % (wrapCount + 1)) / 2);
							}
							for (int j = last; j <= i; j++) {
								if (justify.get()) {
									if( bounds != null ) {
										bounds[j] = changeY(bounds[j], (space * (j - last + 1)) + margin);	
									}
								}
								if (fill.get()) {
									if( bounds != null ) {
										bounds[j] = changeWidth(bounds[j], wraps[i]);	
									}
								} else {
									if (center.get()) {
										if( bounds != null ) {
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
					if (justify.get()) {
						if( bounds != null ) {
							bounds[i] = changeY(bounds[i], (space * (i + 1)) + margin);	
						}
					}
					if (fill.get()) {
						if( bounds != null ) {
							bounds[i] = changeWidth(bounds[i], maxWidth);	
						}
					} else {
						if (center.get()) {
							if( bounds != null ) {
								bounds[i] = changeX(bounds[i], Math.max(0, (maxWidth - bounds[i].getWidth()) / 2));	
							}
						}
					}

				}
				if( bounds != null ) {
					children[i].resizeRelocate(bounds[i].getMinX(), bounds[i].getMinY(), bounds[i].getWidth(), bounds[i].getHeight());	
				}
			}
		}
		return new Size(x + maxWidth + marginRight.get() + marginWidth.get(), maxY);
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

	// ----
	public void setCenterHint(boolean value) {
		center.set(value);
	}

	public boolean isCenterHint() {
		return center.get();
	}

	public BooleanProperty centerProperty() {
		return center;
	}
	
	// ----
	public void setFill(boolean value) {
		fill.set(value);
	}

	public boolean isFill() {
		return fill.get();
	}

	public BooleanProperty fillProperty() {
		return fill;
	}
	
	// ----
	public void setJustify(boolean value) {
		justify.set(value);
	}

	public boolean isJustify() {
		return justify.get();
	}

	public BooleanProperty justifyProperty() {
		return justify;
	}
	
	// ----
	public void setMarginBottom(int value) {
		marginBottom.set(value);
	}

	public int getMarginBottom() {
		return marginBottom.get();
	}

	public IntegerProperty marginBottomProperty() {
		return marginBottom;
	}
	
	// ----
	public void setMarginHeight(int value) {
		marginHeight.set(value);
	}

	public int getMarginHeight() {
		return marginHeight.get();
	}

	public IntegerProperty marginHeightProperty() {
		return marginHeight;
	}
	
	// ----
	public void setMarginLeft(int value) {
		marginLeft.set(value);
	}

	public int getMarginLeft() {
		return marginLeft.get();
	}

	public IntegerProperty marginLeftProperty() {
		return marginLeft;
	}
	
	// ----
	public void setMarginRight(int value) {
		marginRight.set(value);
	}

	public int getMarginRight() {
		return marginRight.get();
	}

	public IntegerProperty marginRightProperty() {
		return marginRight;
	}
	
	// ----
	public void setMarginTop(int value) {
		marginTop.set(value);
	}

	public int getMarginTop() {
		return marginTop.get();
	}

	public IntegerProperty marginTopProperty() {
		return marginTop;
	}
	
	// ----
	public void setMarginWidth(int value) {
		marginWidth.set(value);
	}

	public int getMarginWidth() {
		return marginWidth.get();
	}

	public IntegerProperty marginWidthProperty() {
		return marginWidth;
	}
	
	// ----
	public void setPack(boolean value) {
		pack.set(value);
	}

	public boolean isPack() {
		return pack.get();
	}

	public BooleanProperty packProperty() {
		return pack;
	}

	// ----
	public void setSpacing(int value) {
		spacing.set(value);
	}

	public int getSpacing() {
		return spacing.get();
	}

	public IntegerProperty spacingProperty() {
		return spacing;
	}

	// ----
	public void setWrap(boolean value) {
		wrap.set(value);
	}

	public boolean isWrap() {
		return wrap.get();
	}

	public BooleanProperty wrapProperty() {
		return wrap;
	}

	// ----
	public void setType(Type value) {
		type.set(value);
	}

	public Type getType() {
		return type.get();
	}

	public ObjectProperty<Type> typeProperty() {
		return type;
	}
}

/*******************************************************************************
 * Copyright (c) 2000, 2010 IBM Corporation and others.
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

import org.eclipse.fx.ui.panes.GridData.Alignment;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.css.CssMetaData;
import javafx.css.SimpleStyleableBooleanProperty;
import javafx.css.SimpleStyleableIntegerProperty;
import javafx.css.StyleConverter;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.scene.Node;

/**
 * @author tomschindl
 *
 */
/**
 * Layout pane known from SWT
 */
public class GridLayoutPane extends AbstractLayoutPane<GridData> {
	@NonNull
	private static final String LAYOUT_KEY = "gridData"; //$NON-NLS-1$

	private static final CssMetaData<GridLayoutPane, Number> NUM_COLUMNS = new CssMetaData<GridLayoutPane, Number>("-fx-columns", StyleConverter.getSizeConverter(), Integer.valueOf(1)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(GridLayoutPane node) {
			return !node.numColumnsProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(GridLayoutPane node) {
			return (StyleableProperty<Number>) node.numColumnsProperty();
		}
	};

	private static final CssMetaData<GridLayoutPane, Boolean> MAKE_COLS_EQUAL_WIDTH = new CssMetaData<GridLayoutPane, Boolean>("-fx-columns-equal-width", StyleConverter.getBooleanConverter(), Boolean.FALSE) { //$NON-NLS-1$

		@Override
		public boolean isSettable(GridLayoutPane node) {
			return !node.makeColumnsEqualWidthProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Boolean> getStyleableProperty(GridLayoutPane node) {
			return (StyleableProperty<Boolean>) node.makeColumnsEqualWidthProperty();
		}
	};

	private static final CssMetaData<GridLayoutPane, Number> MARGIN_WIDTH = new CssMetaData<GridLayoutPane, Number>("-fx-inner-margin-width", StyleConverter.getSizeConverter(), Integer.valueOf(5)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(GridLayoutPane node) {
			return !node.marginWidthProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(GridLayoutPane node) {
			return (StyleableProperty<Number>) node.marginWidthProperty();
		}
	};

	private static final CssMetaData<GridLayoutPane, Number> MARGIN_HEIGHT = new CssMetaData<GridLayoutPane, Number>("-fx-inner-margin-height", StyleConverter.getSizeConverter(), Integer.valueOf(5)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(GridLayoutPane node) {
			return !node.marginHeightProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(GridLayoutPane node) {
			return (StyleableProperty<Number>) node.marginHeightProperty();
		}
	};

	private static final CssMetaData<GridLayoutPane, Number> MARGIN_LEFT = new CssMetaData<GridLayoutPane, Number>("-fx-inner-margin-left", StyleConverter.getSizeConverter(), Integer.valueOf(0)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(GridLayoutPane node) {
			return !node.marginLeftProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(GridLayoutPane node) {
			return (StyleableProperty<Number>) node.marginLeftProperty();
		}
	};

	private static final CssMetaData<GridLayoutPane, Number> MARGIN_TOP = new CssMetaData<GridLayoutPane, Number>("-fx-inner-margin-top", StyleConverter.getSizeConverter(), Integer.valueOf(0)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(GridLayoutPane node) {
			return !node.marginTopProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(GridLayoutPane node) {
			return (StyleableProperty<Number>) node.marginTopProperty();
		}
	};

	private static final CssMetaData<GridLayoutPane, Number> MARGIN_RIGHT = new CssMetaData<GridLayoutPane, Number>("-fx-inner-margin-right", StyleConverter.getSizeConverter(), Integer.valueOf(0)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(GridLayoutPane node) {
			return !node.marginRightProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(GridLayoutPane node) {
			return (StyleableProperty<Number>) node.marginRightProperty();
		}
	};

	private static final CssMetaData<GridLayoutPane, Number> MARGIN_BOTTOM = new CssMetaData<GridLayoutPane, Number>("-fx-inner-margin-bottom", StyleConverter.getSizeConverter(), Integer.valueOf(0)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(GridLayoutPane node) {
			return !node.marginBottomProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(GridLayoutPane node) {
			return (StyleableProperty<Number>) node.marginBottomProperty();
		}
	};

	private static final CssMetaData<GridLayoutPane, Number> HORIZONTAL_SPACING = new CssMetaData<GridLayoutPane, Number>("-fx-hspace", StyleConverter.getSizeConverter(), Integer.valueOf(5)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(GridLayoutPane node) {
			return !node.horizontalSpacingProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(GridLayoutPane node) {
			return (StyleableProperty<Number>) node.horizontalSpacingProperty();
		}
	};

	private static final CssMetaData<GridLayoutPane, Number> VERTICAL_SPACING = new CssMetaData<GridLayoutPane, Number>("-fx-vspace", StyleConverter.getSizeConverter(), Integer.valueOf(5)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(GridLayoutPane node) {
			return !node.verticalSpacingProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(GridLayoutPane node) {
			return (StyleableProperty<Number>) node.verticalSpacingProperty();
		}
	};

	private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

	static {

		@SuppressWarnings("static-access")
		final List<CssMetaData<? extends Styleable, ?>> styleables = new ArrayList<CssMetaData<? extends Styleable, ?>>(AbstractLayoutPane.getClassCssMetaData());
		styleables.add(HORIZONTAL_SPACING);
		styleables.add(MAKE_COLS_EQUAL_WIDTH);
		styleables.add(MARGIN_BOTTOM);
		styleables.add(MARGIN_HEIGHT);
		styleables.add(MARGIN_LEFT);
		styleables.add(MARGIN_RIGHT);
		styleables.add(MARGIN_TOP);
		styleables.add(MARGIN_WIDTH);
		styleables.add(VERTICAL_SPACING);
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
	private final IntegerProperty numColumns = new SimpleStyleableIntegerProperty(NUM_COLUMNS, this, "columns", Integer.valueOf(1)); //$NON-NLS-1$

	@NonNull
	private final BooleanProperty makeColumnsEqualWidth = new SimpleStyleableBooleanProperty(MAKE_COLS_EQUAL_WIDTH, this, "makeColumnsEqualWidth", false); //$NON-NLS-1$

	@NonNull
	private final IntegerProperty marginWidth = new SimpleStyleableIntegerProperty(MARGIN_WIDTH, this, "marginWidth", Integer.valueOf(5)); //$NON-NLS-1$
	@NonNull
	private final IntegerProperty marginHeight = new SimpleStyleableIntegerProperty(MARGIN_HEIGHT, this, "marginHeight", Integer.valueOf(5)); //$NON-NLS-1$

	@NonNull
	private final IntegerProperty marginLeft = new SimpleStyleableIntegerProperty(MARGIN_LEFT, this, "marginLeft", Integer.valueOf(0)); //$NON-NLS-1$
	@NonNull
	private final IntegerProperty marginTop = new SimpleStyleableIntegerProperty(MARGIN_TOP, this, "marginTop", Integer.valueOf(0)); //$NON-NLS-1$
	@NonNull
	private final IntegerProperty marginRight = new SimpleStyleableIntegerProperty(MARGIN_RIGHT, this, "marginRight", Integer.valueOf(0)); //$NON-NLS-1$
	@NonNull
	private final IntegerProperty marginBottom = new SimpleStyleableIntegerProperty(MARGIN_BOTTOM, this, "marginBottom", Integer.valueOf(0)); //$NON-NLS-1$

	@NonNull
	private final IntegerProperty horizontalSpacing = new SimpleStyleableIntegerProperty(HORIZONTAL_SPACING, this, "horizontalSpacing", Integer.valueOf(5)); //$NON-NLS-1$
	@NonNull
	private final IntegerProperty verticalSpacing = new SimpleStyleableIntegerProperty(VERTICAL_SPACING, this, "verticalSpacing", Integer.valueOf(5)); //$NON-NLS-1$

	/**
	 * Associate a layout constraint with the node
	 *
	 * @param n
	 *            the node
	 * @param griddata
	 *            the constraint
	 */
	public final static void setConstraint(@NonNull Node n, @NonNull GridData griddata) {
		setConstraint(n, LAYOUT_KEY, griddata);
	}

	/**
	 * Get the layout constraint for the node
	 *
	 * @param n
	 *            the node
	 * @return the layout constraint or <code>null</code>
	 */
	public final static @Nullable GridData getConstraint(@NonNull Node n) {
		return (GridData) getConstraint(n, LAYOUT_KEY);
	}

	@Override
	protected org.eclipse.fx.ui.panes.AbstractLayoutPane.Size computeSize(double width, double height, boolean flushCache) {
		org.eclipse.fx.ui.panes.AbstractLayoutPane.@NonNull Size size = calculateLayout(false, 0, 0, width, height, flushCache);
		return size;
	}

	@Override
	protected double computeMinHeight(double width) {
		return 0; //TODO fix calculation of min size
	}

	@Override
	protected double computeMinWidth(double height) {
		return 0; //TODO fix calculation of min size
	}

	@Override
	protected void layoutChildren() {
		super.layoutChildren();
		calculateLayout(true, getLayoutBounds().getMinX(), getLayoutBounds().getMinY(), getLayoutBounds().getWidth(), getLayoutBounds().getHeight(), true);
	}

	@NonNull
	private Size calculateLayout(boolean move, double x, double y, double width, double height, boolean flushCache) {
		if (getNumColumns() < 1) {
			return new Size(getInnerMarginLeft() + getInnerMarginRight(), getInnerMarginTop() + getInnerMarginBottom());
		}

		@SuppressWarnings("null")
		@NonNull
		Node[] children = getChildren().toArray(new Node[0]);

		int count = 0;
		for (int i = 0; i < children.length; i++) {
			Node control = children[i];
			GridData data = getConstraint(control);
			if (data == null || !data.isExclude()) {
				children[count++] = children[i];
			}
		}
		if (count == 0) {
			return new Size(getInnerMarginLeft() + getInnerMarginRight(), getInnerMarginTop() + getInnerMarginBottom());
		}
		for (int i = 0; i < count; i++) {
			Node child = children[i];
			GridData data = getConstraint(child);

			if (data == null) {
				data = new GridData();
				setConstraint(child, data);
			}

			if (flushCache)
				data.flushCache();

			data.computeSize(child, data.getWidthHint(), data.getHeightHint(), flushCache);

			if (data.isGrabExcessHorizontalSpace() && data.getMinimumWidth() > 0) {
				if (data.cacheWidth < data.getMinimumWidth()) {
					int trim = 0;
					// TEMPORARY CODE
					// FIXME
					// if (child instanceof Scrollable) {
					// Rectangle rect = ((Scrollable) child).computeTrim (0, 0,
					// 0, 0);
					// trim = rect.width;
					// } else {
					// trim = child.getBorderWidth () * 2;
					// }
					data.cacheWidth = data.cacheHeight = FX_DEFAULT;
					data.computeSize(child, Math.max(0, data.getMinimumWidth() - trim), data.getHeightHint(), false);
				}
			}
			if (data.isGrabExcessVerticalSpace() && data.getMinimumHeight() > 0) {
				data.cacheHeight = Math.max(data.cacheHeight, data.getMinimumHeight());
			}
		}

		/* Build the grid */
		int row = 0, column = 0, rowCount = 0, columnCount = getNumColumns();
		Node[][] grid = new Node[4][columnCount];
		for (int i = 0; i < count; i++) {
			Node child = children[i];
			GridData data = getConstraint(child);
			if (data == null) {
				data = new GridData();
			}
			int hSpan = Math.max(1, Math.min(data.getHorizontalSpan(), columnCount));
			int vSpan = Math.max(1, data.getVerticalSpan());
			while (true) {
				int lastRow = row + vSpan;
				if (lastRow >= grid.length) {
					Node[][] newGrid = new Node[lastRow + 4][columnCount];
					System.arraycopy(grid, 0, newGrid, 0, grid.length);
					grid = newGrid;
				}
				if (grid[row] == null) {
					grid[row] = new Node[columnCount];
				}
				while (column < columnCount && grid[row][column] != null) {
					column++;
				}
				int endCount = column + hSpan;
				if (endCount <= columnCount) {
					int index = column;
					while (index < endCount && grid[row][index] == null) {
						index++;
					}
					if (index == endCount)
						break;
					column = index;
				}
				if (column + hSpan >= columnCount) {
					column = 0;
					row++;
				}
			}
			for (int j = 0; j < vSpan; j++) {
				if (grid[row + j] == null) {
					grid[row + j] = new Node[columnCount];
				}
				for (int k = 0; k < hSpan; k++) {
					grid[row + j][column + k] = child;
				}
			}
			rowCount = Math.max(rowCount, row + vSpan);
			column += hSpan;
		}

		/* Column widths */
		double availableWidth = width - getHorizontalSpacing() * (columnCount - 1) - (getInnerMarginLeft() + getInnerMarginRight());
		int expandCount = 0;
		double[] widths = new double[columnCount];
		double[] minWidths = new double[columnCount];
		boolean[] expandColumn = new boolean[columnCount];
		for (int j = 0; j < columnCount; j++) {
			for (int i = 0; i < rowCount; i++) {
				GridData data = getData(grid, i, j, rowCount, columnCount, true);
				if (data != null) {
					int hSpan = Math.max(1, Math.min(data.getHorizontalSpan(), columnCount));
					if (hSpan == 1) {
						double w = data.cacheWidth + data.getHorizontalIndent();
						widths[j] = Math.max(widths[j], w);
						if (data.isGrabExcessHorizontalSpace()) {
							if (!expandColumn[j])
								expandCount++;
							expandColumn[j] = true;
						}
						if (!data.isGrabExcessHorizontalSpace() || data.getMinimumWidth() != 0) {
							w = !data.isGrabExcessHorizontalSpace() || data.getMinimumWidth() == FX_DEFAULT ? data.cacheWidth : data.getMinimumWidth();
							w += data.getHorizontalIndent();
							minWidths[j] = Math.max(minWidths[j], w);
						}
					}
				}
			}
			for (int i = 0; i < rowCount; i++) {
				GridData data = getData(grid, i, j, rowCount, columnCount, false);
				if (data != null) {
					int hSpan = Math.max(1, Math.min(data.getHorizontalSpan(), columnCount));
					if (hSpan > 1) {
						int spanWidth = 0, spanMinWidth = 0, spanExpandCount = 0;
						for (int k = 0; k < hSpan; k++) {
							spanWidth += widths[j - k];
							spanMinWidth += minWidths[j - k];
							if (expandColumn[j - k])
								spanExpandCount++;
						}
						if (data.isGrabExcessHorizontalSpace() && spanExpandCount == 0) {
							expandCount++;
							expandColumn[j] = true;
						}
						double w = data.cacheWidth + data.getHorizontalIndent() - spanWidth - (hSpan - 1) * getHorizontalSpacing();
						if (w > 0) {
							if (isMakeColumnsEqualWidth()) {
								double equalWidth = (w + spanWidth) / hSpan;
								double remainder = (w + spanWidth) % hSpan;
								int last = -1;
								for (int k = 0; k < hSpan; k++) {
									widths[last = j - k] = Math.max(equalWidth, widths[j - k]);
								}
								if (last > -1)
									widths[last] += remainder;
							} else {
								if (spanExpandCount == 0) {
									widths[j] += w;
								} else {
									double delta = w / spanExpandCount;
									double remainder = w % spanExpandCount;
									int last = -1;
									for (int k = 0; k < hSpan; k++) {
										if (expandColumn[j - k]) {
											widths[last = j - k] += delta;
										}
									}
									if (last > -1)
										widths[last] += remainder;
								}
							}
						}
						if (!data.isGrabExcessHorizontalSpace() || data.getMinimumWidth() != 0) {
							w = !data.isGrabExcessHorizontalSpace() || data.getMinimumWidth() == FX_DEFAULT ? data.cacheWidth : data.getMinimumWidth();
							w += data.getHorizontalIndent() - spanMinWidth - (hSpan - 1) * getHorizontalSpacing();
							if (w > 0) {
								if (spanExpandCount == 0) {
									minWidths[j] += w;
								} else {
									double delta = w / spanExpandCount;
									double remainder = w % spanExpandCount;
									int last = -1;
									for (int k = 0; k < hSpan; k++) {
										if (expandColumn[j - k]) {
											minWidths[last = j - k] += delta;
										}
									}
									if (last > -1)
										minWidths[last] += remainder;
								}
							}
						}
					}
				}
			}
		}
		if (isMakeColumnsEqualWidth()) {
			double minColumnWidth = 0;
			double columnWidth = 0;
			for (int i = 0; i < columnCount; i++) {
				minColumnWidth = Math.max(minColumnWidth, minWidths[i]);
				columnWidth = Math.max(columnWidth, widths[i]);
			}
			columnWidth = width == FX_DEFAULT || expandCount == 0 ? columnWidth : Math.max(minColumnWidth, availableWidth / columnCount);
			for (int i = 0; i < columnCount; i++) {
				expandColumn[i] = expandCount > 0;
				widths[i] = columnWidth;
			}
		} else {
			if (width != FX_DEFAULT && expandCount > 0) {
				int totalWidth = 0;
				for (int i = 0; i < columnCount; i++) {
					totalWidth += widths[i];
				}
				int c = expandCount;
				double delta = (availableWidth - totalWidth) / c;
				double remainder = (availableWidth - totalWidth) % c;
				int last = -1;
				while (totalWidth != availableWidth) {
					for (int j = 0; j < columnCount; j++) {
						if (expandColumn[j]) {
							if (widths[j] + delta > minWidths[j]) {
								widths[last = j] = widths[j] + delta;
							} else {
								widths[j] = minWidths[j];
								expandColumn[j] = false;
								c--;
							}
						}
					}
					if (last > -1)
						widths[last] += remainder;

					for (int j = 0; j < columnCount; j++) {
						for (int i = 0; i < rowCount; i++) {
							GridData data = getData(grid, i, j, rowCount, columnCount, false);
							if (data != null) {
								int hSpan = Math.max(1, Math.min(data.getHorizontalSpan(), columnCount));
								if (hSpan > 1) {
									if (!data.isGrabExcessHorizontalSpace() || data.getMinimumWidth() != 0) {
										int spanWidth = 0, spanExpandCount = 0;
										for (int k = 0; k < hSpan; k++) {
											spanWidth += widths[j - k];
											if (expandColumn[j - k])
												spanExpandCount++;
										}
										double w = !data.isGrabExcessHorizontalSpace() || data.getMinimumWidth() == FX_DEFAULT ? data.cacheWidth : data.getMinimumWidth();
										w += data.getHorizontalIndent() - spanWidth - (hSpan - 1) * getHorizontalSpacing();
										if (w > 0) {
											if (spanExpandCount == 0) {
												widths[j] += w;
											} else {
												double delta2 = w / spanExpandCount;
												double remainder2 = w % spanExpandCount;
												int last2 = -1;
												for (int k = 0; k < hSpan; k++) {
													if (expandColumn[j - k]) {
														widths[last2 = j - k] += delta2;
													}
												}
												if (last2 > -1)
													widths[last2] += remainder2;
											}
										}
									}
								}
							}
						}
					}
					if (c == 0)
						break;
					totalWidth = 0;
					for (int i = 0; i < columnCount; i++) {
						totalWidth += widths[i];
					}
					delta = (availableWidth - totalWidth) / c;
					remainder = (availableWidth - totalWidth) % c;
					last = -1;
				}
			}
		}

		/* Wrapping */
		GridData[] flush = null;
		int flushLength = 0;
		if (width != FX_DEFAULT) {
			for (int j = 0; j < columnCount; j++) {
				for (int i = 0; i < rowCount; i++) {
					GridData data = getData(grid, i, j, rowCount, columnCount, false);
					if (data != null) {
						if (data.getHeightHint() == FX_DEFAULT) {
							Node child = grid[i][j];
							// TEMPORARY CODE
							int hSpan = Math.max(1, Math.min(data.getHorizontalSpan(), columnCount));
							int currentWidth = 0;
							for (int k = 0; k < hSpan; k++) {
								currentWidth += widths[j - k];
							}
							currentWidth += (hSpan - 1) * getHorizontalSpacing() - data.getHorizontalIndent();
							if ((currentWidth != data.cacheWidth && data.getHorizontalAlignment() == Alignment.FILL) || (data.cacheWidth > currentWidth)) {
								int trim = 0;
								// FIXME
								// if (child instanceof Scrollable) {
								// Rectangle rect = ((Scrollable)
								// child).computeTrim (0, 0, 0, 0);
								// trim = rect.width;
								// } else {
								// trim = child.getBorderWidth () * 2;
								// }
								data.cacheWidth = data.cacheHeight = FX_DEFAULT;
								data.computeSize(child, Math.max(0, currentWidth - trim), data.getHeightHint(), false);
								if (data.isGrabExcessVerticalSpace() && data.getMinimumHeight() > 0) {
									data.cacheHeight = Math.max(data.cacheHeight, data.getMinimumHeight());
								}
								if (flush == null)
									flush = new GridData[count];
								flush[flushLength++] = data;
							}
						}
					}
				}
			}
		}

		/* Row heights */
		double availableHeight = height - getVerticalSpacing() * (rowCount - 1) - (getInnerMarginTop() + getInnerMarginBottom());
		expandCount = 0;
		double[] heights = new double[rowCount];
		double[] minHeights = new double[rowCount];
		boolean[] expandRow = new boolean[rowCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				GridData data = getData(grid, i, j, rowCount, columnCount, true);
				if (data != null) {
					int vSpan = Math.max(1, Math.min(data.getVerticalSpan(), rowCount));
					if (vSpan == 1) {
						double h = data.cacheHeight + data.getVerticalIndent();
						heights[i] = Math.max(heights[i], h);
						if (data.isGrabExcessVerticalSpace()) {
							if (!expandRow[i])
								expandCount++;
							expandRow[i] = true;
						}
						if (!data.isGrabExcessVerticalSpace() || data.getMinimumHeight() != 0) {
							h = !data.isGrabExcessVerticalSpace() || data.getMinimumHeight() == FX_DEFAULT ? data.cacheHeight : data.getMinimumHeight();
							h += data.getVerticalIndent();
							minHeights[i] = Math.max(minHeights[i], h);
						}
					}
				}
			}
			for (int j = 0; j < columnCount; j++) {
				GridData data = getData(grid, i, j, rowCount, columnCount, false);
				if (data != null) {
					int vSpan = Math.max(1, Math.min(data.getVerticalSpan(), rowCount));
					if (vSpan > 1) {
						int spanHeight = 0, spanMinHeight = 0, spanExpandCount = 0;
						for (int k = 0; k < vSpan; k++) {
							spanHeight += heights[i - k];
							spanMinHeight += minHeights[i - k];
							if (expandRow[i - k])
								spanExpandCount++;
						}
						if (data.isGrabExcessVerticalSpace() && spanExpandCount == 0) {
							expandCount++;
							expandRow[i] = true;
						}
						double h = data.cacheHeight + data.getVerticalIndent() - spanHeight - (vSpan - 1) * getVerticalSpacing();
						if (h > 0) {
							if (spanExpandCount == 0) {
								heights[i] += h;
							} else {
								double delta = h / spanExpandCount;
								double remainder = h % spanExpandCount;
								int last = -1;
								for (int k = 0; k < vSpan; k++) {
									if (expandRow[i - k]) {
										heights[last = i - k] += delta;
									}
								}
								if (last > -1)
									heights[last] += remainder;
							}
						}
						if (!data.isGrabExcessVerticalSpace() || data.getMinimumHeight() != 0) {
							h = !data.isGrabExcessVerticalSpace() || data.getMinimumHeight() == FX_DEFAULT ? data.cacheHeight : data.getMinimumHeight();
							h += data.getVerticalIndent() - spanMinHeight - (vSpan - 1) * getVerticalSpacing();
							if (h > 0) {
								if (spanExpandCount == 0) {
									minHeights[i] += h;
								} else {
									double delta = h / spanExpandCount;
									double remainder = h % spanExpandCount;
									int last = -1;
									for (int k = 0; k < vSpan; k++) {
										if (expandRow[i - k]) {
											minHeights[last = i - k] += delta;
										}
									}
									if (last > -1)
										minHeights[last] += remainder;
								}
							}
						}
					}
				}
			}
		}
		if (height != FX_DEFAULT && expandCount > 0) {
			int totalHeight = 0;
			for (int i = 0; i < rowCount; i++) {
				totalHeight += heights[i];
			}
			int c = expandCount;
			double delta = (availableHeight - totalHeight) / c;
			double remainder = (availableHeight - totalHeight) % c;
			int last = -1;
			while (totalHeight != availableHeight) {
				for (int i = 0; i < rowCount; i++) {
					if (expandRow[i]) {
						if (heights[i] + delta > minHeights[i]) {
							heights[last = i] = heights[i] + delta;
						} else {
							heights[i] = minHeights[i];
							expandRow[i] = false;
							c--;
						}
					}
				}
				if (last > -1)
					heights[last] += remainder;

				for (int i = 0; i < rowCount; i++) {
					for (int j = 0; j < columnCount; j++) {
						GridData data = getData(grid, i, j, rowCount, columnCount, false);
						if (data != null) {
							int vSpan = Math.max(1, Math.min(data.getVerticalSpan(), rowCount));
							if (vSpan > 1) {
								if (!data.isGrabExcessVerticalSpace() || data.getMinimumHeight() != 0) {
									int spanHeight = 0, spanExpandCount = 0;
									for (int k = 0; k < vSpan; k++) {
										spanHeight += heights[i - k];
										if (expandRow[i - k])
											spanExpandCount++;
									}
									double h = !data.isGrabExcessVerticalSpace() || data.getMinimumHeight() == FX_DEFAULT ? data.cacheHeight : data.getMinimumHeight();
									h += data.getVerticalIndent() - spanHeight - (vSpan - 1) * getVerticalSpacing();
									if (h > 0) {
										if (spanExpandCount == 0) {
											heights[i] += h;
										} else {
											double delta2 = h / spanExpandCount;
											double remainder2 = h % spanExpandCount;
											int last2 = -1;
											for (int k = 0; k < vSpan; k++) {
												if (expandRow[i - k]) {
													heights[last2 = i - k] += delta2;
												}
											}
											if (last2 > -1)
												heights[last2] += remainder2;
										}
									}
								}
							}
						}
					}
				}
				if (c == 0)
					break;
				totalHeight = 0;
				for (int i = 0; i < rowCount; i++) {
					totalHeight += heights[i];
				}
				delta = (availableHeight - totalHeight) / c;
				remainder = (availableHeight - totalHeight) % c;
				last = -1;
			}
		}

		/* Position the controls */
		if (move) {
			double gridY = y + getInnerMarginTop();
			for (int i = 0; i < rowCount; i++) {
				double gridX = x + getInnerMarginLeft();
				for (int j = 0; j < columnCount; j++) {
					GridData data = getData(grid, i, j, rowCount, columnCount, true);
					if (data != null) {
						int hSpan = Math.max(1, Math.min(data.getHorizontalSpan(), columnCount));
						int vSpan = Math.max(1, data.getVerticalSpan());
						int cellWidth = 0, cellHeight = 0;
						for (int k = 0; k < hSpan; k++) {
							cellWidth += widths[j + k];
						}
						for (int k = 0; k < vSpan; k++) {
							cellHeight += heights[i + k];
						}
						cellWidth += getHorizontalSpacing() * (hSpan - 1);
						double childX = gridX + data.getHorizontalIndent();
						double childWidth = Math.min(data.cacheWidth, cellWidth);
						switch (data.getHorizontalAlignment()) {
						case CENTER:
							childX += Math.max(0, (cellWidth - data.getHorizontalIndent() - childWidth) / 2);
							break;
						case END:
							childX += Math.max(0, cellWidth - data.getHorizontalIndent() - childWidth);
							break;
						case FILL:
							childWidth = cellWidth - data.getHorizontalIndent();
							break;
						case BEGINNING:
							// Nothing todo
							break;
						}
						cellHeight += getVerticalSpacing() * (vSpan - 1);
						double childY = gridY + data.getVerticalIndent();
						double childHeight = Math.min(data.cacheHeight, cellHeight);
						switch (data.getVerticalAlignment()) {
						case CENTER:
							childY += Math.max(0, (cellHeight - data.getVerticalIndent() - childHeight) / 2);
							break;
						case END:
							childY += Math.max(0, cellHeight - data.getVerticalIndent() - childHeight);
							break;
						case FILL:
							childHeight = cellHeight - data.getVerticalIndent();
							break;
						case BEGINNING:
							// Nothing todo
							break;
						}
						Node child = grid[i][j];
						if (child != null) {
							child.resizeRelocate(childX, childY, childWidth, childHeight);
						}
					}
					gridX += widths[j] + getHorizontalSpacing();
				}
				gridY += heights[i] + getVerticalSpacing();
			}
		}

		// clean up cache
		for (int i = 0; i < flushLength; i++) {
			if (flush != null) {
				flush[i].cacheWidth = flush[i].cacheHeight = -1;
			}
		}

		int totalDefaultWidth = 0;
		int totalDefaultHeight = 0;
		for (int i = 0; i < columnCount; i++) {
			totalDefaultWidth += widths[i];
		}
		for (int i = 0; i < rowCount; i++) {
			totalDefaultHeight += heights[i];
		}
		totalDefaultWidth += getHorizontalSpacing() * (columnCount - 1) + getInnerMarginLeft() + getInnerMarginRight();
		totalDefaultHeight += getVerticalSpacing() * (rowCount - 1) + getInnerMarginTop() + getInnerMarginBottom();
		return new Size(totalDefaultWidth, totalDefaultHeight);
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

	static GridData getData(Node[][] grid, int row, int column, int rowCount, int columnCount, boolean first) {
		Node control = grid[row][column];
		if (control != null) {
			GridData data = (GridData) getConstraint(control);
			if (data == null) {
				data = new GridData();
			}
			int hSpan = Math.max(1, Math.min(data.getHorizontalSpan(), columnCount));
			int vSpan = Math.max(1, data.getVerticalSpan());
			int i = first ? row + vSpan - 1 : row - vSpan + 1;
			int j = first ? column + hSpan - 1 : column - hSpan + 1;
			if (0 <= i && i < rowCount) {
				if (0 <= j && j < columnCount) {
					if (control == grid[i][j])
						return data;
				}
			}
		}
		return null;
	}

	/**
	 * The number of columns
	 *
	 * @param numColumns
	 *            the columns
	 */
	public final void setNumColumns(int numColumns) {
		numColumnsProperty().set(numColumns);
	}

	/**
	 * @return The number of columns
	 */
	public final int getNumColumns() {
		return numColumnsProperty().get();
	}

	/**
	 * @return The number of columns
	 */
	public final @NonNull IntegerProperty numColumnsProperty() {
		return this.numColumns;
	}

	/**
	 * If <code>true</code> all columns have the same width
	 *
	 * @param makeColumnsEqualWidth
	 *            make all columns equal
	 */
	public final void setMakeColumnsEqualWidth(boolean makeColumnsEqualWidth) {
		makeColumnsEqualWidthProperty().set(makeColumnsEqualWidth);
	}

	/**
	 * @return If <code>true</code> all columns have the same width
	 */
	public final boolean isMakeColumnsEqualWidth() {
		return makeColumnsEqualWidthProperty().get();
	}

	/**
	 * @return If <code>true</code> all columns have the same width
	 */
	public final @NonNull BooleanProperty makeColumnsEqualWidthProperty() {
		return this.makeColumnsEqualWidth;
	}

	/**
	 * Horizontal spacing between columns
	 *
	 * @param value
	 *            the spacing
	 */
	public final void setHorizontalSpacing(int value) {
		horizontalSpacingProperty().set(value);
	}

	/**
	 * @return Horizontal spacing between columns
	 */
	public final int getHorizontalSpacing() {
		return horizontalSpacingProperty().get();
	}

	/**
	 * @return Horizontal spacing between columns
	 */
	public final @NonNull IntegerProperty horizontalSpacingProperty() {
		return this.horizontalSpacing;
	}

	/**
	 * Margin on the left and right
	 *
	 * @param value
	 *            the margin
	 */
	public final void setMarginWidth(int value) {
		marginWidthProperty().set(value);
	}

	/**
	 * @return Margin on the left and right
	 */
	public final int getMarginWidth() {
		return marginWidthProperty().get();
	}

	/**
	 * @return Margin on the left and right
	 */
	public final @NonNull IntegerProperty marginWidthProperty() {
		return this.marginWidth;
	}

	/**
	 * Margin on the top and bottom
	 *
	 * @param value
	 *            the margin
	 */
	public final void setMarginHeight(int value) {
		marginHeightProperty().set(value);
	}

	/**
	 * @return Margin on the top and bottom
	 */
	public final int getMarginHeight() {
		return marginHeightProperty().get();
	}

	/**
	 * @return Margin on the top and bottom
	 */
	public final @NonNull IntegerProperty marginHeightProperty() {
		return this.marginHeight;
	}

	/**
	 * The margin on the left
	 *
	 * @param value
	 *            the left margin
	 */
	public final void setMarginLeft(int value) {
		marginLeftProperty().set(value);
	}

	/**
	 * @return The margin on the left
	 */
	public final int getMarginLeft() {
		return marginLeftProperty().get();
	}

	/**
	 * @return The margin on the left
	 */
	public final @NonNull IntegerProperty marginLeftProperty() {
		return this.marginLeft;
	}

	/**
	 * The margin on the top
	 *
	 * @param value
	 *            the new margin
	 */
	public final void setMarginTop(int value) {
		marginTopProperty().set(value);
	}

	/**
	 * @return The margin on the top
	 */
	public final int getMarginTop() {
		return marginTopProperty().get();
	}

	/**
	 * @return The margin on the top
	 */
	public final @NonNull IntegerProperty marginTopProperty() {
		return this.marginTop;
	}

	/**
	 * The margin on the right
	 *
	 * @param value
	 *            the new margin
	 */
	public final void setMarginRight(int value) {
		marginRightProperty().set(value);
	}

	/**
	 * @return The margin on the right
	 */
	public final int getMarginRight() {
		return marginRightProperty().get();
	}

	/**
	 * @return The margin on the right
	 */
	public final @NonNull IntegerProperty marginRightProperty() {
		return this.marginRight;
	}

	/**
	 * The margin on the bottom
	 *
	 * @param value
	 *            the new margin
	 */
	public final void setMarginBottom(int value) {
		marginBottomProperty().set(value);
	}

	/**
	 * @return The margin on the bottom
	 */
	public final int getMarginBottom() {
		return marginBottomProperty().get();
	}

	/**
	 * @return The margin on the bottom
	 */
	public final @NonNull IntegerProperty marginBottomProperty() {
		return this.marginBottom;
	}

	/**
	 * The vertical spacing between rows
	 *
	 * @param value
	 *            the spacing
	 */
	public final void setVerticalSpacing(int value) {
		verticalSpacingProperty().set(value);
	}

	/**
	 * @return The vertical spacing between rows
	 */
	public final int getVerticalSpacing() {
		return verticalSpacingProperty().get();
	}

	/**
	 * @return The vertical spacing between rows
	 */
	public final @NonNull IntegerProperty verticalSpacingProperty() {
		return this.verticalSpacing;
	}
}
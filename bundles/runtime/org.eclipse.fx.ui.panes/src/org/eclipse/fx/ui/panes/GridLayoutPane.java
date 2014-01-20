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


import org.eclipse.fx.ui.panes.GridData.Alignment;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.WritableIntegerValue;
import javafx.scene.Node;

public class GridLayoutPane extends AbstractLayoutPane<GridData> {
	private IntegerProperty numColumns = new SimpleIntegerProperty(this, "columns", 1);
	 
	private BooleanProperty makeColumnsEqualWidth = new SimpleBooleanProperty(this,"makeColumnsEqualWidth",false);
	
	private IntegerProperty marginWidth = new SimpleIntegerProperty(this, "marginWidth", 5);
	private IntegerProperty marginHeight = new SimpleIntegerProperty(this, "marginHeight", 5);
	
	private IntegerProperty marginLeft = new SimpleIntegerProperty(this, "marginLeft", 0);
	private IntegerProperty marginTop = new SimpleIntegerProperty(this, "marginTop", 0);
	private IntegerProperty marginRight = new SimpleIntegerProperty(this, "marginRight", 0);
	private IntegerProperty marginBottom = new SimpleIntegerProperty(this, "marginBottom", 0);
	
	private IntegerProperty horizontalSpacing = new SimpleIntegerProperty(this, "horizontalSpacing", 5);
	private IntegerProperty verticalSpacing = new SimpleIntegerProperty(this, "verticalSpacing", 5);
		
	public static void setConstraint(Node n, GridData griddata) {
		setConstraint(n, "gd",griddata);
	}
	
	public static GridData getConstraint(Node n) {
		return (GridData)getConstraint(n,"gd");
	}
	
	@Override
	protected org.eclipse.fx.ui.panes.AbstractLayoutPane.Size computeSize(
			double width, double height, boolean flushCache) {
		return calculateLayout(false, 0, 0, width, height, flushCache);
	}
	
	@Override
	protected void layoutChildren() {
		super.layoutChildren();
		calculateLayout(true, getLayoutBounds().getMinX(), getLayoutBounds().getMinY(), getLayoutBounds().getWidth(), getLayoutBounds().getHeight(), true);
	}
	
	
	private Size calculateLayout( boolean move, double x, double y, double width, double height, boolean flushCache) {
		if (numColumns.get() < 1) {
			return new Size (marginLeft.get() + marginWidth.get() * 2 + marginRight.get(), marginTop.get() + marginHeight.get() * 2 + marginBottom.get());
		}
		
		Node[] children = getChildren().toArray(new Node[0]);
		
		int count = 0;
		for (int i=0; i<children.length; i++) {
			Node control = children [i];
			GridData data = (GridData) getConstraint(control,"gd");
			if (data == null || !data.exclude.get()) {
				children [count++] = children [i];
			} 
		}
		if (count == 0) {
			return new Size (marginLeft.get() + marginWidth.get() * 2 + marginRight.get(), marginTop.get() + marginHeight.get() * 2 + marginBottom.get());
		}
		for (int i=0; i<count; i++) {
			Node child = children [i];
			GridData data = (GridData) getConstraint(child,"gd");
			
			if (data == null) {
				data = new GridData ();
				setConstraint(child, "gd",data);
			}
			
			if (flushCache) data.flushCache ();
			
			data.computeSize (child, data.widthHint.get(), data.heightHint.get(), flushCache);
			
			if (data.grabExcessHorizontalSpace.get() && data.minimumWidth.get() > 0) {
				if (data.cacheWidth < data.minimumWidth.get()) {
					int trim = 0;
					//TEMPORARY CODE
//FIXME					
//					if (child instanceof Scrollable) {
//						Rectangle rect = ((Scrollable) child).computeTrim (0, 0, 0, 0);
//						trim = rect.width;
//					} else {
//						trim = child.getBorderWidth () * 2;
//					}
					data.cacheWidth = data.cacheHeight = FX_DEFAULT;
					data.computeSize (child, Math.max (0, data.minimumWidth.get() - trim), data.heightHint.get(), false);
				}
			}
			if (data.grabExcessVerticalSpace.get() && data.minimumHeight.get() > 0) {
				data.cacheHeight = Math.max (data.cacheHeight, data.minimumHeight.get());
			}
		}

		/* Build the grid */
		int row = 0, column = 0, rowCount = 0, columnCount = numColumns.get();
		Node [][] grid = new Node [4] [columnCount];
		for (int i=0; i<count; i++) {	
			Node child = children [i];
			GridData data = (GridData) getConstraint(child,"gd");
			int hSpan = Math.max (1, Math.min (data.horizontalSpan.get(), columnCount));
			int vSpan = Math.max (1, data.verticalSpan.get());
			while (true) {
				int lastRow = row + vSpan;
				if (lastRow >= grid.length) {
					Node [][] newGrid = new Node [lastRow + 4] [columnCount];
					System.arraycopy (grid, 0, newGrid, 0, grid.length);
					grid = newGrid;
				}
				if (grid [row] == null) {
					grid [row] = new Node [columnCount];
				}
				while (column < columnCount && grid [row] [column] != null) {
					column++;
				}
				int endCount = column + hSpan;
				if (endCount <= columnCount) {
					int index = column;
					while (index < endCount && grid [row] [index] == null) {
						index++;
					}
					if (index == endCount) break;
					column = index;
				}
				if (column + hSpan >= columnCount) {
					column = 0;
					row++;
				}
			}
			for (int j=0; j<vSpan; j++) {
				if (grid [row + j] == null) {
					grid [row + j] = new Node [columnCount];
				}
				for (int k=0; k<hSpan; k++) {
					grid [row + j] [column + k] = child;
				}
			}
			rowCount = Math.max (rowCount, row + vSpan);
			column += hSpan;
		}

		/* Column widths */
		double availableWidth = width - horizontalSpacing.get() * (columnCount - 1) - (marginLeft.get() + marginWidth.get() * 2 + marginRight.get());
		int expandCount = 0;
		double [] widths = new double [columnCount];
		double [] minWidths = new double [columnCount];
		boolean [] expandColumn = new boolean [columnCount];
		for (int j=0; j<columnCount; j++) {
			for (int i=0; i<rowCount; i++) {
				GridData data = getData (grid, i, j, rowCount, columnCount, true);
				if (data != null) {
					int hSpan = Math.max (1, Math.min (data.horizontalSpan.get(), columnCount));
					if (hSpan == 1) {
						double w = data.cacheWidth + data.horizontalIndent.get();
						widths [j] = Math.max (widths [j], w);
						if (data.grabExcessHorizontalSpace.get()) {
							if (!expandColumn [j]) expandCount++;
							expandColumn [j] = true;
						}
						if (!data.grabExcessHorizontalSpace.get() || data.minimumWidth.get() != 0) {
							w = !data.grabExcessHorizontalSpace.get() || data.minimumWidth.get() == FX_DEFAULT ? data.cacheWidth : data.minimumWidth.get();
							w += data.horizontalIndent.get();
							minWidths [j] = Math.max (minWidths [j], w);
						}
					}
				}
			}
			for (int i=0; i<rowCount; i++) {
				GridData data = getData (grid, i, j, rowCount, columnCount, false);
				if (data != null) {
					int hSpan = Math.max (1, Math.min (data.horizontalSpan.get(), columnCount));
					if (hSpan > 1) {
						int spanWidth = 0, spanMinWidth = 0, spanExpandCount = 0;
						for (int k=0; k<hSpan; k++) {
							spanWidth += widths [j-k];
							spanMinWidth += minWidths [j-k];
							if (expandColumn [j-k]) spanExpandCount++;
						}
						if (data.grabExcessHorizontalSpace.get() && spanExpandCount == 0) {
							expandCount++;
							expandColumn [j] = true;
						}
						double w = data.cacheWidth + data.horizontalIndent.get() - spanWidth - (hSpan - 1) * horizontalSpacing.get();
						if (w > 0) {
							if (makeColumnsEqualWidth.get()) {
								double equalWidth = (w + spanWidth) / hSpan;
								double remainder = (w + spanWidth) % hSpan;
								int last = -1;
								for (int k = 0; k < hSpan; k++) {
									widths [last=j-k] = Math.max (equalWidth, widths [j-k]);
								}
								if (last > -1) widths [last] += remainder;
							} else {
								if (spanExpandCount == 0) {
									widths [j] += w;
								} else {
									double delta = w / spanExpandCount;
									double remainder = w % spanExpandCount;
									int last = -1;
									for (int k = 0; k < hSpan; k++) {
										if (expandColumn [j-k]) {
											widths [last=j-k] += delta;
										}
									}
									if (last > -1) widths [last] += remainder;
								}
							}
						}
						if (!data.grabExcessHorizontalSpace.get() || data.minimumWidth.get() != 0) {
							w = !data.grabExcessHorizontalSpace.get() || data.minimumWidth.get() == FX_DEFAULT ? data.cacheWidth : data.minimumWidth.get();
							w += data.horizontalIndent.get() - spanMinWidth - (hSpan - 1) * horizontalSpacing.get();
							if (w > 0) {
								if (spanExpandCount == 0) {
									minWidths [j] += w;
								} else {
									double delta = w / spanExpandCount;
									double remainder = w % spanExpandCount;
									int last = -1;
									for (int k = 0; k < hSpan; k++) {
										if (expandColumn [j-k]) {
											minWidths [last=j-k] += delta;
										}
									}
									if (last > -1) minWidths [last] += remainder;
								}
							}
						}
					}
				}
			}
		}
		if (makeColumnsEqualWidth.get()) {
			double minColumnWidth = 0;
			double columnWidth = 0;
			for (int i=0; i<columnCount; i++) {
				minColumnWidth = Math.max (minColumnWidth, minWidths [i]);
				columnWidth = Math.max (columnWidth, widths [i]);
			}
			columnWidth = width == FX_DEFAULT || expandCount == 0 ? columnWidth : Math.max (minColumnWidth, availableWidth / columnCount);
			for (int i=0; i<columnCount; i++) {
				expandColumn [i] = expandCount > 0;
				widths [i] = columnWidth;
			}
		} else {
			if (width != FX_DEFAULT && expandCount > 0) {
				int totalWidth = 0;
				for (int i=0; i<columnCount; i++) {
					totalWidth += widths [i];
				}
				int c = expandCount;
				double delta = (availableWidth - totalWidth) / c;
				double remainder = (availableWidth - totalWidth) % c;
				int last = -1;
				while (totalWidth != availableWidth) {
					for (int j=0; j<columnCount; j++) {
						if (expandColumn [j]) {
							if (widths [j] + delta > minWidths [j]) {
								widths [last = j] = widths [j] + delta;
							} else {
								widths [j] = minWidths [j];
								expandColumn [j] = false;
								c--;
							}
						}
					}
					if (last > -1) widths [last] += remainder;
					
					for (int j=0; j<columnCount; j++) {
						for (int i=0; i<rowCount; i++) {
							GridData data = getData (grid, i, j, rowCount, columnCount, false);
							if (data != null) {
								int hSpan = Math.max (1, Math.min (data.horizontalSpan.get(), columnCount));
								if (hSpan > 1) {
									if (!data.grabExcessHorizontalSpace.get() || data.minimumWidth.get() != 0) {
										int spanWidth = 0, spanExpandCount = 0;
										for (int k=0; k<hSpan; k++) {
											spanWidth += widths [j-k];
											if (expandColumn [j-k]) spanExpandCount++;
										}
										double w = !data.grabExcessHorizontalSpace.get() || data.minimumWidth.get() == FX_DEFAULT ? data.cacheWidth : data.minimumWidth.get();
										w += data.horizontalIndent.get() - spanWidth - (hSpan - 1) * horizontalSpacing.get();
										if (w > 0) {
											if (spanExpandCount == 0) {
												widths [j] += w;
											} else {
												double delta2 = w / spanExpandCount;
												double remainder2 = w % spanExpandCount;
												int last2 = -1;
												for (int k = 0; k < hSpan; k++) {
													if (expandColumn [j-k]) {
														widths [last2=j-k] += delta2;
													}
												}
												if (last2 > -1) widths [last2] += remainder2;	
											}
										}
									}
								}
							}
						}
					}
					if (c == 0) break;
					totalWidth = 0;
					for (int i=0; i<columnCount; i++) {
						totalWidth += widths [i];
					}
					delta = (availableWidth - totalWidth) / c;
					remainder = (availableWidth - totalWidth) % c;
					last = -1;
				}
			}
		}

		/* Wrapping */
		GridData [] flush = null;
		int flushLength = 0;
		if (width != FX_DEFAULT) {
			for (int j=0; j<columnCount; j++) {
				for (int i=0; i<rowCount; i++) {
					GridData data = getData (grid, i, j, rowCount, columnCount, false);
					if (data != null) {
						if (data.heightHint.get() == FX_DEFAULT) {
							Node child = grid [i][j];
							//TEMPORARY CODE
							int hSpan = Math.max (1, Math.min (data.horizontalSpan.get(), columnCount));
							int currentWidth = 0;
							for (int k=0; k<hSpan; k++) {
								currentWidth += widths [j-k];
							}
							currentWidth += (hSpan - 1) * horizontalSpacing.get() - data.horizontalIndent.get();
							if ((currentWidth != data.cacheWidth && data.horizontalAlignment.get() == Alignment.FILL) || (data.cacheWidth > currentWidth)) {
								int trim = 0;
//FIXME								
//								if (child instanceof Scrollable) {
//									Rectangle rect = ((Scrollable) child).computeTrim (0, 0, 0, 0);
//									trim = rect.width;
//								} else {
//									trim = child.getBorderWidth () * 2;
//								}
								data.cacheWidth = data.cacheHeight = FX_DEFAULT;
								data.computeSize (child, Math.max (0, currentWidth - trim), data.heightHint.get(), false);
								if (data.grabExcessVerticalSpace.get() && data.minimumHeight.get() > 0) {
									data.cacheHeight = Math.max (data.cacheHeight, data.minimumHeight.get());
								}
								if (flush == null) flush = new GridData [count];
								flush [flushLength++] = data;
							}
						}
					}
				}
			}
		}

		/* Row heights */
		double availableHeight = height - verticalSpacing.get() * (rowCount - 1) - (marginTop.get() + marginHeight.get() * 2 + marginBottom.get());
		expandCount = 0;
		double [] heights = new double [rowCount];
		double [] minHeights = new double [rowCount];
		boolean [] expandRow = new boolean [rowCount];
		for (int i=0; i<rowCount; i++) {
			for (int j=0; j<columnCount; j++) {
				GridData data = getData (grid, i, j, rowCount, columnCount, true);
				if (data != null) {
					int vSpan = Math.max (1, Math.min (data.verticalSpan.get(), rowCount));
					if (vSpan == 1) {
						double h = data.cacheHeight + data.verticalIndent.get();
						heights [i] = Math.max (heights [i], h);
						if (data.grabExcessVerticalSpace.get()) {
							if (!expandRow [i]) expandCount++;
							expandRow [i] = true;
						}
						if (!data.grabExcessVerticalSpace.get() || data.minimumHeight.get() != 0) {
							h = !data.grabExcessVerticalSpace.get() || data.minimumHeight.get() == FX_DEFAULT ? data.cacheHeight : data.minimumHeight.get();
							h += data.verticalIndent.get();
							minHeights [i] = Math.max (minHeights [i], h);
						}
					}
				}
			}
			for (int j=0; j<columnCount; j++) {
				GridData data = getData (grid, i, j, rowCount, columnCount, false);
				if (data != null) {
					int vSpan = Math.max (1, Math.min (data.verticalSpan.get(), rowCount));
					if (vSpan > 1) {
						int spanHeight = 0, spanMinHeight = 0, spanExpandCount = 0;
						for (int k=0; k<vSpan; k++) {
							spanHeight += heights [i-k];
							spanMinHeight += minHeights [i-k];
							if (expandRow [i-k]) spanExpandCount++;
						}
						if (data.grabExcessVerticalSpace.get() && spanExpandCount == 0) {
							expandCount++;
							expandRow [i] = true;
						}
						double h = data.cacheHeight + data.verticalIndent.get() - spanHeight - (vSpan - 1) * verticalSpacing.get();
						if (h > 0) {
							if (spanExpandCount == 0) {
								heights [i] += h;
							} else {
								double delta = h / spanExpandCount;
								double remainder = h % spanExpandCount;
								int last = -1;
								for (int k = 0; k < vSpan; k++) {
									if (expandRow [i-k]) {
										heights [last=i-k] += delta;
									}
								}
								if (last > -1) heights [last] += remainder;	
							}
						}
						if (!data.grabExcessVerticalSpace.get() || data.minimumHeight.get() != 0) {
							h = !data.grabExcessVerticalSpace.get() || data.minimumHeight.get() == FX_DEFAULT ? data.cacheHeight : data.minimumHeight.get();
							h += data.verticalIndent.get() - spanMinHeight - (vSpan - 1) * verticalSpacing.get();
							if (h > 0) {
								if (spanExpandCount == 0) {
									minHeights [i] += h;
								} else {
									double delta = h / spanExpandCount;
									double remainder = h % spanExpandCount;
									int last = -1;
									for (int k = 0; k < vSpan; k++) {
										if (expandRow [i-k]) {
											minHeights [last=i-k] += delta;
										}
									}
									if (last > -1) minHeights [last] += remainder;	
								}
							}
						}
					}
				}
			}
		}
		if (height != FX_DEFAULT && expandCount > 0) {
			int totalHeight = 0;
			for (int i=0; i<rowCount; i++) {
				totalHeight += heights [i];
			}
			int c = expandCount;
			double delta = (availableHeight - totalHeight) / c;
			double remainder = (availableHeight - totalHeight) % c;
			int last = -1;
			while (totalHeight != availableHeight) {
				for (int i=0; i<rowCount; i++) {
					if (expandRow [i]) {
						if (heights [i] + delta > minHeights [i]) {
							heights [last = i] = heights [i] + delta;
						} else {
							heights [i] = minHeights [i];
							expandRow [i] = false;
							c--;
						}
					}
				}
				if (last > -1) heights [last] += remainder;
				
				for (int i=0; i<rowCount; i++) {
					for (int j=0; j<columnCount; j++) {
						GridData data = getData (grid, i, j, rowCount, columnCount, false);
						if (data != null) {
							int vSpan = Math.max (1, Math.min (data.verticalSpan.get(), rowCount));
							if (vSpan > 1) {
								if (!data.grabExcessVerticalSpace.get() || data.minimumHeight.get() != 0) {
									int spanHeight = 0, spanExpandCount = 0;
									for (int k=0; k<vSpan; k++) {
										spanHeight += heights [i-k];
										if (expandRow [i-k]) spanExpandCount++;
									}
									double h = !data.grabExcessVerticalSpace.get() || data.minimumHeight.get() == FX_DEFAULT ? data.cacheHeight : data.minimumHeight.get();
									h += data.verticalIndent.get() - spanHeight - (vSpan - 1) * verticalSpacing.get();
									if (h > 0) {
										if (spanExpandCount == 0) {
											heights [i] += h;
										} else {
											double delta2 = h / spanExpandCount;
											double remainder2 = h % spanExpandCount;
											int last2 = -1;
											for (int k = 0; k < vSpan; k++) {
												if (expandRow [i-k]) {
													heights [last2=i-k] += delta2;
												}
											}
											if (last2 > -1) heights [last2] += remainder2;
										}
									}
								}
							}
						}
					}
				}
				if (c == 0) break;
				totalHeight = 0;
				for (int i=0; i<rowCount; i++) {
					totalHeight += heights [i];
				}
				delta = (availableHeight - totalHeight) / c;
				remainder = (availableHeight - totalHeight) % c;
				last = -1;
			}
		}

		/* Position the controls */
		if (move) {
			double gridY = y + marginTop.get() + marginHeight.get();
			for (int i=0; i<rowCount; i++) {
				double gridX = x + marginLeft.get() + marginWidth.get();
				for (int j=0; j<columnCount; j++) {
					GridData data = getData (grid, i, j, rowCount, columnCount, true);
					if (data != null) {
						int hSpan = Math.max (1, Math.min (data.horizontalSpan.get(), columnCount));
						int vSpan = Math.max (1, data.verticalSpan.get());
						int cellWidth = 0, cellHeight = 0;
						for (int k=0; k<hSpan; k++) {
							cellWidth += widths [j+k];
						}
						for (int k=0; k<vSpan; k++) {
							cellHeight += heights [i+k];
						}
						cellWidth += horizontalSpacing.get() * (hSpan - 1);
						double childX = gridX + data.horizontalIndent.get();
						double childWidth = Math.min (data.cacheWidth, cellWidth);
						switch (data.horizontalAlignment.get()) {
							case CENTER:
								childX += Math.max (0, (cellWidth - data.horizontalIndent.get() - childWidth) / 2);
								break;
							case END:
								childX += Math.max (0, cellWidth - data.horizontalIndent.get() - childWidth);
								break;
							case FILL:
								childWidth = cellWidth - data.horizontalIndent.get();
								break;
							case BEGINNING:
								// Nothing todo
								break;
						}
						cellHeight += verticalSpacing.get() * (vSpan - 1);
						double childY = gridY + data.verticalIndent.get();
						double childHeight = Math.min (data.cacheHeight, cellHeight);
						switch (data.verticalAlignment.get()) {
							case CENTER:
								childY += Math.max (0, (cellHeight - data.verticalIndent.get() - childHeight) / 2);
								break;
							case END:
								childY += Math.max (0, cellHeight - data.verticalIndent.get() - childHeight);
								break;
							case FILL:
								childHeight = cellHeight - data.verticalIndent.get();
								break;
							case BEGINNING:
								// Nothing todo
								break;
						}
						Node child = grid [i][j];
						if (child != null) {
							child.resizeRelocate(childX, childY, childWidth, childHeight);
						}
					}
					gridX += widths [j] + horizontalSpacing.get();
				}
				gridY += heights [i] + verticalSpacing.get();
			}
		}

		// clean up cache
		for (int i = 0; i < flushLength; i++) {
			if( flush != null ) {
				flush [i].cacheWidth = flush [i].cacheHeight = -1;	
			}
		}

		int totalDefaultWidth = 0;
		int totalDefaultHeight = 0;
		for (int i=0; i<columnCount; i++) {
			totalDefaultWidth += widths [i];
		}
		for (int i=0; i<rowCount; i++) {
			totalDefaultHeight += heights [i];
		}
		totalDefaultWidth += horizontalSpacing.get() * (columnCount - 1) + marginLeft.get() + marginWidth.get() * 2 + marginRight.get();
		totalDefaultHeight += verticalSpacing.get() * (rowCount - 1) + marginTop.get() + marginHeight.get() * 2 + marginBottom.get();
		return new Size (totalDefaultWidth, totalDefaultHeight);
	}
	
	GridData getData (Node [][] grid, int row, int column, int rowCount, int columnCount, boolean first) {
		Node control = grid [row] [column];
		if (control != null) {
			GridData data = (GridData) getConstraint(control,"gd");
			int hSpan = Math.max (1, Math.min (data.horizontalSpan.get(), columnCount));
			int vSpan = Math.max (1, data.verticalSpan.get());
			int i = first ? row + vSpan - 1 : row - vSpan + 1;
			int j = first ? column + hSpan - 1 : column - hSpan + 1;
			if (0 <= i && i < rowCount) {
				if (0 <= j && j < columnCount) {
					if (control == grid [i][j]) return data;
				}
			}
		}
		return null;
	}
	
	// --------
	public void setNumColumns(int numColumns) {
		this.numColumns.set(numColumns);
	}
	
	public int getNumColumns() {
		return this.numColumns.get();
	}
	
	public WritableIntegerValue numColumnsProperty() {
		return numColumns;
	}

	// --------
	public void setMakeColumnsEqualWidth(boolean makeColumnsEqualWidth) {
		this.makeColumnsEqualWidth.set(makeColumnsEqualWidth);
	}
	
	public boolean isMakeColumnsEqualWidth() {
		return this.makeColumnsEqualWidth.get();
	}
	
	public BooleanProperty makeColumnsEqualWidthProperty() {
		return makeColumnsEqualWidth;
	}
	
	// --------
	public void setHorizontalSpacing(int value) {
		horizontalSpacing.set(value);
	}
	
	public void getHorizontalSpacing() {
		horizontalSpacing.get();
	}
	
	public IntegerProperty horizontalSpacing() {
		return horizontalSpacing;
	}
	
	// ----
	public void setMarginWidth(int value) {
		marginWidth.set(value);
	}
	
	public int getMarginWidth() {
		return marginWidth.get();
	}
	
	public IntegerProperty getMarginWidthProperty() {
		return marginWidth;
	}
	
	// ----
	public void setMarginHeight(int value) {
		marginHeight.set(value);
	}
	
	public int getMarginHeight() {
		return marginHeight.get();
	}
	
	public IntegerProperty getMarginHeightProperty() {
		return marginHeight;
	}
	
	// ----
	public void setMarginLeft(int value) {
		marginLeft.set(value);
	}
	
	public int getMarginLeft() {
		return marginLeft.get();
	}
	
	public IntegerProperty getMarginLeftProperty() {
		return marginLeft;
	}
	
	// ----
	public void setMarginTop(int value) {
		marginTop.set(value);
	}
	
	public int getMarginTop() {
		return marginTop.get();
	}
	
	public IntegerProperty getMarginTopProperty() {
		return marginTop;
	}
	
	// ----
	public void setMarginRight(int value) {
		marginRight.set(value);
	}
	
	public int getMarginRight() {
		return marginRight.get();
	}
	
	public IntegerProperty getMarginRightProperty() {
		return marginRight;
	}
	
	// ----
	public void setMarginBottom(int value) {
		marginBottom.set(value);
	}
	
	public int getMarginBottom() {
		return marginBottom.get();
	}
	
	public IntegerProperty getMarginBottomProperty() {
		return marginBottom;
	}
	
	// ----
	public void setVerticalSpacing(int value) {
		verticalSpacing.set(value);
	}
	
	public int getVerticalSpacing() {
		return verticalSpacing.get();
	}
	
	public IntegerProperty getVerticalSpacingProperty() {
		return verticalSpacing;
	}
}
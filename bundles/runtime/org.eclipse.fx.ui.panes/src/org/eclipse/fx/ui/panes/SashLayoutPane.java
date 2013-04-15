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
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.WritableIntegerValue;
import javafx.event.EventHandler;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SashLayoutPane extends Pane {
	class SashRect {
		Bounds rect;
		MGenericTile container;
		MUIElement left;
		MUIElement right;

		public SashRect(Bounds rect, MGenericTile container,
				MUIElement left, MUIElement right) {
			this.container = container;
			this.rect = rect;
			this.left = left;
			this.right = right;
		}
	}
	
	public abstract static class MUIElement {
		Double weight;
		Object widget;
		boolean visible = true;
		
		public boolean isVisible() {
			return visible;
		}
		
		public void setWeight(Double weight) {
			this.weight = weight;
		}
	}
	
	public static class MGenericTile extends MUIElement {
		boolean horizontal;
		List<MUIElement> children = new ArrayList<MUIElement>();
		
		public MGenericTile() {
			
		}
		
		public void setHorizontal(boolean horizontal) {
			this.horizontal = horizontal;
		}
		
		public void add(MUIElement element) {
			children.add(element);
		}
	}
	
	public static class MUIControl extends MUIElement {
		public MUIControl() {
			
		}
	}
	
	private WritableIntegerValue minSashPercent = new SimpleIntegerProperty(this, "minSashPercent", 10);
	
	private WritableIntegerValue marginLeft = new SimpleIntegerProperty(this, "marginLeft", 0);
	private WritableIntegerValue marginRight = new SimpleIntegerProperty(this, "marginRight", 0);
	private WritableIntegerValue marginTop = new SimpleIntegerProperty(this, "marginTop", 0);
	private WritableIntegerValue marginBottom = new SimpleIntegerProperty(this, "marginBottom", 0);
	private WritableIntegerValue sashWidth = new SimpleIntegerProperty(this, "sashWidth", 4);
	
	private MGenericTile root;
	private List<SashRect> sashes = new ArrayList<SashRect>();
	private boolean draggingSashes = false;
	List<SashRect> sashesToDrag;
	
	public SashLayoutPane() {
		this.root = new MGenericTile();
		this.root.widget = this;
		
		onMouseMovedProperty().set(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (!draggingSashes) {
					// Set the cursor feedback
					List<SashRect> sashList = getSashRects(event.getX(), event.getY());
					if (sashList.size() == 0) {
						setCursor(Cursor.DEFAULT);
					} else if (sashList.size() == 1) {
						if (sashList.get(0).container.horizontal) {
							setCursor(Cursor.W_RESIZE);
						} else {
							setCursor(Cursor.S_RESIZE);
						}
					} else {
						setCursor(Cursor.CROSSHAIR);
					}
				}
			}
		});
		
		onMouseDraggedProperty().set(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (draggingSashes) {
					adjustWeights(sashesToDrag, event.getX(), event.getY());
					requestLayout();
				}
			}
		});
		
		onMouseReleasedProperty().set(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				draggingSashes = false;
			}
		});
		
		onMousePressedProperty().set(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				sashesToDrag = getSashRects(event.getX(), event.getY());
				if (sashesToDrag.size() > 0) {
					draggingSashes = true;
				}
			}
		});
		
//		onMouseMovedProperty().addListener(new ChangeListener<EventHandler<MouseEvent>>() {
//
//			@Override
//			public void changed(
//					ObservableValue<? extends EventHandler<MouseEvent>> observable,
//					EventHandler<MouseEvent> oldValue,
//					EventHandler<MouseEvent> newValue) {
//				newValue.
//			}
//		});
		
//		host.addMouseListener(new MouseListener() {
//			public void mouseUp(MouseEvent e) {
//				host.setCapture(false);
//				draggingSashes = false;
//			}
//
//			public void mouseDown(MouseEvent e) {
//				if (e.button != 1)
//					return;
//
//				sashesToDrag = getSashRects(e.x, e.y);
//				if (sashesToDrag.size() > 0) {
//					draggingSashes = true;
//					host.setCapture(true);
//				}
//			}
//
//			public void mouseDoubleClick(MouseEvent e) {
//			}
//		});
		
	}
	
	public void setMarginLeft(int marginLeft) {
		this.marginLeft.set(marginLeft);
	}
	
	public int getMarginLeft() {
		return this.marginLeft.get();
	}
	
	public void setMarginRight(int marginRight) {
		this.marginRight.set(marginRight);
	}
	
	public int getMarginRight() {
		return this.marginRight.get();
	}
	
	public void setMarginTop(int marginTop) {
		this.marginTop.set(marginTop);
	}
	
	public int getMarginTop() {
		return this.marginTop.get();
	}
	
	public void setMarginBottom(int marginBottom) {
		this.marginBottom.set(marginBottom);
	}
	
	public int getMarginBottom() {
		return this.marginBottom.get();
	}
	
	public void setSashWidth(int sashWidth) {
		this.sashWidth.set(sashWidth);
	}
	
	public int getSashWidth() {
		return this.sashWidth.get();
	}
	
	protected List<SashRect> getSashRects(double x, double y) {
		List<SashRect> srs = new ArrayList<SashRect>();
		boolean inSash = false;
		for (SashRect sr : sashes) {
			if (sr.rect.contains(x, y))
				inSash = true;
		}
		if (!inSash)
			return srs;

		BoundingBox target = new BoundingBox(x - 5, y - 5, 10, 10);
		for (SashRect sr : sashes) {
			if (sr.rect.intersects(target))
				srs.add(sr);
		}
		return srs;
	}
	
	protected void adjustWeights(List<SashRect> sashes, double curX, double curY) {
		for (SashRect sr : sashes) {
			double totalWeight = getWeight(sr.left) + getWeight(sr.right);
			double minSashValue = (((totalWeight / 100.0) * minSashPercent.get()) + 0.5);
			
			Bounds leftRect = getRectangle(sr.left);
			Bounds rightRect = getRectangle(sr.right);
			if (leftRect == null || rightRect == null)
				continue;

			double leftWeight;
			double rightWeight;

			if (sr.container.horizontal) {
				double left = leftRect.getMinX();
				double right = rightRect.getMinX() + rightRect.getWidth();
				double pct = (curX - left) / (right - left);
				leftWeight = ((totalWeight * pct) + 0.5);
				if (leftWeight < minSashValue)
					leftWeight = minSashValue;
				if (leftWeight > (totalWeight - minSashValue))
					leftWeight = totalWeight - minSashValue;
				rightWeight = totalWeight - leftWeight;
			} else {
				double top = leftRect.getMinY();
				double bottom = rightRect.getMinY() + rightRect.getHeight();
				double pct = (curY - top) / (bottom - top);
				leftWeight = (int)((totalWeight * pct) + 0.5);
				
				if (leftWeight < minSashValue)
					leftWeight = minSashValue;
				
				if (leftWeight > (totalWeight - minSashValue))
					leftWeight = totalWeight - minSashValue;
				
				rightWeight = totalWeight - leftWeight;
			}

			setWeight(sr.left, leftWeight);
			setWeight(sr.right, rightWeight);
			
		}
	}
	
	private void setWeight(MUIElement element, double weight) {
		element.weight = weight;
	}
	
	public void setConstraint(Node node, MUIControl data) {
		data.widget = node;
	}
	
	public MGenericTile getRoot() {
		return root;
	}
	
	@Override
	protected void layoutChildren() {
		if (root == null)
			return;

		Bounds bounds = getLayoutBounds();
		bounds = new BoundingBox(bounds.getMinX() + marginLeft.get(), 
				bounds.getMinY() + marginTop.get(), 
				bounds.getWidth() - (marginLeft.get() + marginRight.get()), 
				bounds.getHeight() - (marginTop.get() + marginBottom.get()));

		sashes.clear();
		tileSubNodes(bounds, root);
	}
	
	private Bounds getRectangle(MUIElement element) {
		if (element instanceof MGenericTile)
			return (Bounds) element.widget;
		else if (element.widget instanceof Node)
			return ((Node) (element.widget)).getBoundsInParent();
		return null;
	}
	
	private void setRectangle(MUIElement node, Bounds bounds) {
		if (node.widget instanceof Node) {
			Node ctrl = (Node) node.widget;
			ctrl.resizeRelocate(bounds.getMinX(), bounds.getMinY(), bounds.getWidth(), bounds.getHeight());
		} else if (node instanceof MGenericTile) {
			Bounds newRect = new BoundingBox(bounds.getMinX(), bounds.getMinY(), bounds.getWidth(),
					bounds.getHeight());
			node.widget = newRect;
		}
	}
	
	private List<MUIElement> getVisibleChildren(MGenericTile sashContainer) {
		List<MUIElement> visKids = new ArrayList<MUIElement>();
		for (MUIElement child : sashContainer.children) {
			if (child.isVisible())
				visKids.add(child);
		}
		return visKids;
	}
	
	private double totalWeight(MGenericTile node) {
		double total = 0;
		for (MUIElement subNode : node.children) {
			if (subNode.isVisible())
				total += getWeight(subNode);
		}
		return total;
	}
	
	private void tileSubNodes(Bounds bounds, MUIElement node) {
		if (node != root)
			setRectangle(node, bounds);

		if (!(node instanceof MGenericTile))
			return;

		MGenericTile sashContainer = (MGenericTile) node;
		List<MUIElement> visibleChildren = getVisibleChildren(sashContainer);
		int childCount = visibleChildren.size();

		// How many pixels do we have?
		double availableWidth = sashContainer.horizontal ? bounds.getWidth()
				: bounds.getHeight();

		// Subtract off the room for the sashes
		availableWidth -= ((childCount - 1) * sashWidth.get());

		// Get the total of the weights
		double totalWeight = totalWeight(sashContainer);
		double tilePos = sashContainer.horizontal ? bounds.getMinX() : bounds.getMinY();

		MUIElement prev = null;
		for (MUIElement subNode : visibleChildren) {
			// Add a 'sash' between this node and the 'prev'
			if (prev != null) {
				Bounds sashRect = sashContainer.horizontal ? new BoundingBox(
						tilePos, bounds.getMinY(), sashWidth.get(), bounds.getHeight())
						: new BoundingBox(bounds.getMinX(), tilePos, bounds.getWidth(),
								sashWidth.get());
				sashes.add(new SashRect(sashRect, sashContainer, prev, subNode));
				tilePos += sashWidth.get();
			}

			// Calc the new size as a %'age of the total
			double ratio = getWeight(subNode) / totalWeight;
			double newSize = availableWidth * ratio;
			
			Bounds subBounds = sashContainer.horizontal ? new BoundingBox(
					tilePos, bounds.getMinY(), newSize, bounds.getHeight()) : new BoundingBox(
					bounds.getMinX(), tilePos, bounds.getWidth(), newSize);
					
					
			tilePos += newSize;

			tileSubNodes(subBounds, subNode);
			prev = subNode;
		}
	}
	
	private static double getWeight(MUIElement element) {
		Double info = element.weight;
		if (info == null ) {
			element.weight = Double.valueOf(100);
			info = element.weight;
		}

		return info;
	}
}

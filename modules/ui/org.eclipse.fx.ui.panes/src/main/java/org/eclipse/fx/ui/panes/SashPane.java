/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.panes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.jdt.annotation.NonNull;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.css.CssMetaData;
import javafx.css.PseudoClass;
import javafx.css.SimpleStyleableIntegerProperty;
import javafx.css.StyleConverter;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

/**
 * <p>
 * A layout container who lays out its children in a row or column arrangement
 * (as specified by the orientation) and places a Sash between each child.
 * </p>
 * <p>
 * One child may be maximized to occupy the entire size of the {@link SashPane}
 * </p>
 * <p>
 * The relative sizes of the children may be specified using weights
 * </p>
 *
 * @since 2.6.0
 */
public class SashPane extends Region {
	private static final String USER_AGENT_STYLESHEET = SashPane.class.getResource("sash-pane.css").toExternalForm(); //$NON-NLS-1$

	private static final String LAYOUT_KEY = "sashData"; //$NON-NLS-1$
	static final int DRAG_MINIMUM = 20;
	private boolean syncInProgress;

	private Sash[] sashes = new Sash[0];
	private BooleanProperty horizontal = new SimpleBooleanProperty(this, "horizontal", true) {//$NON-NLS-1$
		@Override
		protected void invalidated() {
			super.invalidated();
			clearCache();
		}
	};
	private ObjectProperty<Node> maximizedControl = new SimpleObjectProperty<Node>(this, "maximizedControl") {//$NON-NLS-1$
		@Override
		protected void invalidated() {
			super.invalidated();
			clearCache();
		}
	};

	private static final CssMetaData<SashPane, Number> SASH_WIDTH = new CssMetaData<SashPane, Number>("-fx-sash-width", //$NON-NLS-1$
			StyleConverter.getSizeConverter(), Integer.valueOf(8)) {

		@Override
		public boolean isSettable(SashPane node) {
			return !node.sashWidthProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<Number> getStyleableProperty(SashPane node) {
			return (StyleableProperty<Number>) node.sashWidthProperty();
		}
	};
	@NonNull
	private final IntegerProperty sashWidth = new SimpleStyleableIntegerProperty(SASH_WIDTH, this, "sashWidth", //$NON-NLS-1$
			Integer.valueOf(8));

	private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

	static {
		final List<CssMetaData<? extends Styleable, ?>> styleables = new ArrayList<>(Region.getClassCssMetaData());
		styleables.add(SASH_WIDTH);
		STYLEABLES = Collections.unmodifiableList(styleables);
	}

	public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
		return STYLEABLES;
	}

	@Override
	public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
		return getClassCssMetaData();
	}
	
	/**
	 * Optional interface implemented by Items so that I are layouted with their fixed size
	 */
	public interface FixedSashItem {
		/**
		 * @return property controlling if the item is fixed
		 */
		public ObservableBooleanValue fixed();
	}

	private ObservableList<Node> items = FXCollections.observableArrayList();

	private Sash draggedSash;
	private Node c1;
	private Node c2;
	private double resize_1;
	private double resize_2;
	private double start;
	private Bounds clientArea;

	private double resize_total;

	private static PseudoClass HORIZONTAL = PseudoClass.getPseudoClass("horizontal"); //$NON-NLS-1$
	private static PseudoClass VERTICAL = PseudoClass.getPseudoClass("vertical"); //$NON-NLS-1$
	
	private ObjectProperty<int[]> weights = null;

	/**
	 * Create a new sash pane
	 */
	public SashPane() {
		getStyleClass().add("sash-pane"); //$NON-NLS-1$
		this.items.addListener((Change<? extends Node> c) -> {
			while (c.next()) {
				if (c.wasRemoved()) {
					getChildren().removeIf(n -> {
						boolean rv = n instanceof SashChild && c.getRemoved().contains(((SashChild) n).getChildren().get(0));
						if( rv ) {
							((SashChild)n).dispose();
						}
						return rv;
					});
				}
				if (c.wasAdded()) {
					getChildren().addAll(c.getFrom(),
							c.getAddedSubList().stream().map(SashChild::new).collect(Collectors.toList()));
				}
			}
			clearCache();
		});
		this.sashWidth.addListener(o -> {
			clearCache();
			requestLayout();
		});
		pseudoClassStateChanged(HORIZONTAL, true);
		pseudoClassStateChanged(VERTICAL, false);
		this.horizontal.addListener((o, ol, ne) -> {
			pseudoClassStateChanged(HORIZONTAL, ne.booleanValue());
			pseudoClassStateChanged(VERTICAL, !ne.booleanValue());
		});
	}

	@Override
	public String getUserAgentStylesheet() {
		return USER_AGENT_STYLESHEET;
	}

	/**
	 * @return children of the {@link SashPane}
	 */
	public ObservableList<Node> getItems() {
		return this.items;
	}

	void clearCache() {
		this.clientArea = null;
	}

	@Override
	protected void layoutChildren() {
		layoutChildren(false);
	}
	
	private boolean hasFixedChild() {
		return getManagedChildren().stream()
			.filter(Node::isVisible)
			.map(SashChild.class::cast)
			.filter(SashChild::isFixed)
			.findAny().isPresent();
	}

	void layoutChildren(boolean force) {
		int x = (int) Math.ceil(getPadding().getLeft());
		int y = (int) Math.ceil(getPadding().getTop());
		int w = (int) Math.floor(getWidth()) - (int) Math.ceil(getPadding().getLeft())
				- (int) Math.ceil(getPadding().getRight());
		int h = (int) Math.floor(getHeight()) - (int) Math.ceil(getPadding().getTop())
				- (int) Math.ceil(getPadding().getBottom());
		
		boolean hasFixedChild = hasFixedChild();
		
		Bounds b = new BoundingBox(x, y, w, h);

		if (!force && this.clientArea != null && this.clientArea.equals(b) && ! hasFixedChild ) {
			return;
		}

		if (w <= 1 || h <= 1) {
			return;
		}

		List<Node> children = getManagedChildren().stream().filter(Node::isVisible).collect(Collectors.toList());

		if (children.isEmpty()) {
			return;
		}

		if (this.maximizedControl.get() != null && children.contains(this.maximizedControl.get())) {
			for (int i = 0; i < children.size(); i++) {
				if (children.get(i) != this.maximizedControl.get()) {
					children.get(i).resizeRelocate(0, 0, 0, 0);
				} else {
					children.get(i).resizeRelocate(x, y, h, w);
				}
			}
			return;
		}
		
		// TODO Adjust sash numbers
		if (this.sashes.length < children.size() - 1) {
			Sash[] newSashes = new Sash[children.size() - 1];
			System.arraycopy(this.sashes, 0, newSashes, 0, this.sashes.length);
			for (int i = this.sashes.length; i < newSashes.length; i++) {
				newSashes[i] = createSash();
			}
			this.sashes = newSashes;
		}

		if (this.sashes.length > children.size() - 1) {
			if (children.size() == 0) {
				for (int i = 0; i < this.sashes.length; i++) {
					getChildren().remove(this.sashes[i]);
				}
				this.sashes = new Sash[0];
			} else {
				Sash[] newSashes = new Sash[children.size() - 1];
				System.arraycopy(this.sashes, 0, newSashes, 0, newSashes.length);
				for (int i = children.size() - 1; i < this.sashes.length; i++) {
					getChildren().remove(this.sashes[i]);
				}
				this.sashes = newSashes;
			}
		}

		if( ! hasFixedChild() ) {
			layoutSimple(x,y,w,h);
		} else {
			layoutWithFixedChild(x,y,w,h,force);
		}

		this.clientArea = b;
		syncWeightProperty();
	}
	
	private void layoutWithFixedChild(int _x, int _y, int _w, int _h, boolean force) {
		int x = _x;
		int y = _y;
		int w = _w;
		int h = _h;
		
		List<SashChild> children = getManagedChildren().stream()
				.filter(Node::isVisible)
				.map(SashChild.class::cast)
				.collect(Collectors.toList());
		
		// check if it a simple UC where we only have 2 children and one is fixed
		if( children.size() == 2 ) {
			Node startNode = children.get(0);
			Node endNode = children.get(1);
			
			if( ((SashChild)children.get(0)).isFixed() ) {
				if (this.horizontal.get()) {
					double minWidth = startNode.minWidth(h);
					
					startNode.resizeRelocate(x, y, w, minWidth);
					x += minWidth;
					this.sashes[0].resizeRelocate(x, y, getSashWidth(), h);
					x += getSashWidth();
					endNode.resizeRelocate(x, y, w - x, h);
				} else {
					double minHeight = startNode.minHeight(w);
					
					startNode.resizeRelocate(x, y, w, minHeight);
					y += minHeight;
					this.sashes[0].resizeRelocate(x, y, w, getSashWidth());
					y += getSashWidth();
					endNode.resizeRelocate(x, y, w, h - y);
				}				
			} else {
				if (this.horizontal.get()) {
					double minWidth = endNode.minWidth(h);
					double sashWidth = getSashWidth();
					
					startNode.resizeRelocate(x, y, w - minWidth - sashWidth, h);
					x += w - minWidth - sashWidth;
					this.sashes[0].resizeRelocate(x, y, sashWidth, h);
					x += sashWidth;
					endNode.resizeRelocate(x, y, minWidth, h);
				} else {
					double minHeight = endNode.minHeight(w);
					double sashHeight = getSashWidth();
					
					startNode.resizeRelocate(x, y, w, h - minHeight - sashHeight);
					y += h - minHeight - sashHeight;
					this.sashes[0].resizeRelocate(x, y, w, sashHeight);
					y += sashHeight;
					endNode.resizeRelocate(x, y, w, minHeight);
				}
			}
		} else {
			layoutWithFixedChildComplex(_x, _y, _w, _h, force);
		}
	}
	
	private void layoutWithFixedChildComplex(int _x, int _y, int _w, int _h, boolean force) {
		int x = _x;
		int y = _y;
		int w = _w;
		int h = _h;
		
		List<SashChild> children = getManagedChildren().stream()
				.filter(Node::isVisible)
				.map(SashChild.class::cast)
				.collect(Collectors.toList());
		
		long[] ratios = new long[children.size()];
		long total = 0;
		for (int i = 0; i < children.size(); i++) {
			if( ! children.get(i).isFixed() ) {
				Object data = children.get(i).getProperties().get(LAYOUT_KEY);
				if (data != null && data instanceof SashFormData) {
					ratios[i] = ((SashFormData) data).weight;
				} else {
					data = new SashFormData();
					children.get(i).getProperties().put(LAYOUT_KEY, data);
					((SashFormData) data).weight = ratios[i] = ((200 << 16) + 999) / 1000;

				}
				total += ratios[i];	
			}
		}
		
		if( horizontal.get() ) {
			w -= children.stream().filter(SashChild::isFixed).mapToDouble( s -> computeFixedWidth(s, _h)).sum();
			
			double sashSize = getSashWidth();

			for( int i = 0; i < children.size(); i++ ) {
				SashChild sashChild = children.get(i);
				int ratioWidth = (int) (ratios[i] * (h - this.sashes.length * sashSize) / total);
				
				if( i > 0 ) {
					this.sashes[i - 1].resizeRelocate(x, y, sashSize, h);
					x += sashSize;
				}
				
				if( sashChild.isFixed() ) {
					int targetWidth = (int) computeFixedWidth(sashChild, h);
					
					sashChild.resizeRelocate(x, y, targetWidth, h);
					x += targetWidth;
				} else {
					sashChild.resizeRelocate(x, y, ratioWidth, h);
					x += ratioWidth;
				}
			}			

		} else {
			h -= children.stream().filter(SashChild::isFixed).mapToDouble( s -> computeFixedHeight(s, _w)).sum();
			
			double sashSize = getSashWidth();
			
			for( int i = 0; i < children.size(); i++ ) {
				SashChild sashChild = children.get(i);
				int ratioHeight = (int) (ratios[i] * (h - this.sashes.length * sashSize) / total);
				
				if( i > 0 ) {
					this.sashes[i - 1].resizeRelocate(x, y, w, sashSize);
					y += sashSize;
				}
				
				if( sashChild.isFixed() ) {
					int targetHeight = (int) computeFixedHeight(sashChild, w);
					
					sashChild.resizeRelocate(x, y, w, targetHeight);
					y += targetHeight;
				} else {
					sashChild.resizeRelocate(x, y, w, ratioHeight);
					y += ratioHeight;
				}
			}			
		}
	}
	
	private static double computeFixedHeight(SashChild child, int width) {
		return child.minHeight(width);
	}
	
	private static double computeFixedWidth(SashChild child, int height) {
		return child.minWidth(height);
	}
	
	private static int findPrevUnfixed(List<SashChild> children, int index) {
		for( int i = index - 1; i >= 0; i-- ) {
			if( ! children.get(i).isFixed() ) {
				return i;
			}
		}
		return -1;
	}
	
	private static int findNextUnfixed(List<SashChild> children, int index) {
		for( int i = index + 1; i < children.size(); i++ ) {
			if( ! children.get(i).isFixed() ) {
				return i;
			}
		}
		return -1;
	}
	
	private void layoutSimple(int _x, int _y, int _w, int _h) {
		int x = _x;
		int y = _y;
		int w = _w;
		int h = _h;
		
		List<Node> children = getManagedChildren().stream().filter(Node::isVisible).collect(Collectors.toList());
		
		long[] ratios = new long[children.size()];
		long total = 0;
		for (int i = 0; i < children.size(); i++) {
			Object data = children.get(i).getProperties().get(LAYOUT_KEY);
			if (data != null && data instanceof SashFormData) {
				ratios[i] = ((SashFormData) data).weight;
			} else {
				data = new SashFormData();
				children.get(i).getProperties().put(LAYOUT_KEY, data);
				((SashFormData) data).weight = ratios[i] = ((200 << 16) + 999) / 1000;

			}
			total += ratios[i];
		}

//		int spread = 0;
//		boolean adjust = false;

		// int sashwidth = 10; //TODO sashes.length > 0 ? sashForm.SASH_WIDTH +
		// sashes [0].getBorderWidth() * 2 : sashForm.SASH_WIDTH;
		if (this.horizontal.get()) {
			int width = (int) (ratios[0] * (w - this.sashes.length * getSashWidth()) / total);
			Node node = children.get(0);
			node.resizeRelocate(x, y, width, h);
			x += width;
			for (int i = 1; i < children.size() - 1; i++) {
				node = children.get(i);
				this.sashes[i - 1].resizeRelocate(x, y, getSashWidth(), h);
				x += getSashWidth();
				width = (int) (ratios[i] * (w - this.sashes.length * getSashWidth()) / total);
				node.resizeRelocate(x, y, width, h);
				x += width;
			}
			if (children.size() > 1) {
				node = children.get(children.size() - 1);
				this.sashes[this.sashes.length - 1].resizeRelocate(x, y, getSashWidth(), h);
				x += getSashWidth();
				width = w - x;
				node.resizeRelocate(x, y, width, h);
			}
		} else {
			Node node = children.get(0);
			int height = (int) (ratios[0] * (h - this.sashes.length * getSashWidth()) / total);
			int delta = (int)node.minHeight(w) - height;
			
//			System.err.println("======> " + w + " =>" + delta);
			
			if( delta > 0 ) {
//				adjust = true;
//				spread += delta;  
				height += delta;
			}
			
			node.resizeRelocate(x, y, w, height);
			
			y += height;
			for (int i = 1; i < children.size() - 1; i++) {
				node = children.get(i);
				height = (int) (ratios[i] * (h - this.sashes.length * getSashWidth()) / total);
				delta = (int)node.minHeight(w) - height;
				
				if( delta > 0 ) {
//					adjust = true;
//					spread += delta; 
					height += delta;
				} 
//				else {
//					if( spread > 0 ) {
//						System.err.println("SPREAD: " + spread);
//						if( spread < Math.abs(delta) ) {
//							System.err.println("ADJUST IT");
//							spread = 0;
//							height -= spread;
//						} else {
//							spread = spread - Math.abs(delta);
//							height -= Math.abs(delta);
//						}
//					}
//				}
				
				this.sashes[i - 1].resizeRelocate(x, y, w, getSashWidth());
				y += getSashWidth();
				
				node.resizeRelocate(x, y, w, height);
				y += height;
			}
			
			if (children.size() > 1) {
				node = children.get(children.size() - 1);
				this.sashes[this.sashes.length - 1].resizeRelocate(x, y, w, getSashWidth());
				y += getSashWidth();
				height = h - y;
				node.resizeRelocate(x, y, w, height);
			}
			
//			if( adjust ) {
//				for( Node n : children ) {
//					updateLayoutData(n, (int)n.getLayoutBounds().getHeight(), h);
//				}
//			}
		}
	}
	
//	private void updateLayoutData(Node n, int size, int available) {
//		Object data = n.getProperties().get(LAYOUT_KEY);
//		((SashFormData) data).weight = (((long) size << 16) + available - 1) / available;
//		
//	}
	
	private void syncWeightProperty() {
		if( this.weights != null ) {
			try {
				this.syncInProgress = true;
				int[] newVal = getWeights();
				if( !Arrays.equals(newVal, this.weights.get()) ) {
					this.weights.set(newVal);
				}
			} finally {
				this.syncInProgress = false;
			}
		}
	}

	private void handleDragSash(MouseEvent e) {
		if( this.draggedSash == null || this.c1 == null || this.c2 == null ) {
			return;
		}
		
		e.consume();
		
		if( hasFixedChild() ) {
			// We only have to handle drag if there are more than 2 children
			if( getChildren().size() > 2 ) {
				handleDragFixed(e);
			}
		} else {
			handleDragSashSimple(e);
		}
		syncWeightProperty();
		requestLayout();
	}
	
	private void handleDragFixed(MouseEvent e) {
		List<SashChild> children = getManagedChildren().stream()
				.filter(Node::isVisible)
				.map(SashChild.class::cast)
				.collect(Collectors.toList());
		
		if (this.horizontal.get()) {
			double w = children.stream().filter(SashChild::isFixed).mapToDouble( s -> computeFixedHeight(s, (int)getWidth())).sum();
			Rectangle rectangle = new Rectangle(getWidth() - w, getHeight(), getInsets());
			
			double delta = e.getScreenX() - this.start;

			long newSize_1 = (long) (this.resize_1 + delta);
			long newSize_2 = (long) (this.resize_2 - delta);

			long minChildWidth1 = minChildWidth(this.c1, getHeight());
			long minChildWidth2 = minChildWidth(this.c2, getHeight());
			
			if (newSize_1 < minChildWidth1) {
				newSize_2 = (long) this.resize_total - minChildWidth1;
				newSize_1 = minChildWidth1;
			}

			if (newSize_2 < minChildWidth2) {
				newSize_1 = (long) this.resize_total - minChildWidth2;
				newSize_2 = minChildWidth2;
			}

			Object data1 = this.c1.getProperties().get(LAYOUT_KEY);
			if (data1 == null || !(data1 instanceof SashFormData)) {
				data1 = new SashFormData();
				this.c1.getProperties().put(LAYOUT_KEY, data1);
			}
			Object data2 = this.c2.getProperties().get(LAYOUT_KEY);
			if (data2 == null || !(data2 instanceof SashFormData)) {
				data2 = new SashFormData();
				this.c2.getProperties().put(LAYOUT_KEY, data2);
			}

			((SashFormData) data1).weight = (((long) newSize_1 << 16) + rectangle.width - 1) / rectangle.width;
			((SashFormData) data2).weight = (((long) newSize_2 << 16) + rectangle.width - 1) / rectangle.width;

			this.c1.resize(newSize_1, rectangle.height);
			this.c2.resizeRelocate(this.c1.getLayoutX() + newSize_1 + getSashWidth(), this.c2.getLayoutY(), newSize_2,
					rectangle.height);
			this.draggedSash.relocate(this.c1.getLayoutX() + newSize_1, this.draggedSash.getLayoutY());
		} else {
			double h = children.stream().filter(SashChild::isFixed).mapToDouble( s -> computeFixedHeight(s, (int)getWidth())).sum();
			Rectangle rectangle = new Rectangle(getWidth(), getHeight() - h, getInsets());
			
			double delta = e.getScreenY() - this.start;
			long newSize_1 = (long) (this.resize_1 + delta);
			long newSize_2 = (long) (this.resize_2 - delta);

			long minChildHeight1 = minChildHeight(this.c1, getWidth());
			long minChildHeight2 = minChildHeight(this.c2, getWidth());
			
			if (newSize_1 < minChildHeight1) {
				newSize_2 = (long) this.resize_total - minChildHeight1;
				newSize_1 = minChildHeight1;
			}

			if (newSize_2 < minChildHeight2) {
				newSize_1 = (long) this.resize_total - minChildHeight2;
				newSize_2 = minChildHeight2;
			}

			Object data1 = this.c1.getProperties().get(LAYOUT_KEY);
			if (data1 == null || !(data1 instanceof SashFormData)) {
				data1 = new SashFormData();
				this.c1.getProperties().put(LAYOUT_KEY, data1);
			}
			Object data2 = this.c2.getProperties().get(LAYOUT_KEY);
			if (data2 == null || !(data2 instanceof SashFormData)) {
				data2 = new SashFormData();
				this.c2.getProperties().put(LAYOUT_KEY, data2);
			}

			((SashFormData) data1).weight = (((long) newSize_1 << 16) + rectangle.height - 1) / rectangle.height;
			((SashFormData) data2).weight = (((long) newSize_2 << 16) + rectangle.height - 1) / rectangle.height;

			this.c1.resize(rectangle.width, newSize_1);
			this.c2.resizeRelocate(this.c2.getLayoutX(), this.c1.getLayoutY() + newSize_1 + getSashWidth(),
					rectangle.width, newSize_2);
			this.draggedSash.relocate(this.draggedSash.getLayoutX(), this.c1.getLayoutY() + newSize_1);			
		}

	}
	
	private static long minChildWidth(Node child, double height) {
		return Math.max((long)child.minWidth(height), DRAG_MINIMUM);
	}
	
	private static long minChildHeight(Node child, double width) {
		return Math.max((long)child.minHeight(width), DRAG_MINIMUM);
	}
	
	private void handleDragSashSimple(MouseEvent e) {
		Rectangle rectangle = new Rectangle(getWidth(), getHeight(), getInsets());

		if (this.horizontal.get()) {
			double delta = e.getScreenX() - this.start;

			long newSize_1 = (long) (this.resize_1 + delta);
			long newSize_2 = (long) (this.resize_2 - delta);

			long minChildWidth1 = minChildWidth(this.c1, getHeight());
			long minChildWidth2 = minChildWidth(this.c2, getHeight());
			
			if (newSize_1 < minChildWidth1) {
				newSize_2 = (long) this.resize_total - minChildWidth1;
				newSize_1 = minChildWidth1;
			}

			if (newSize_2 < minChildWidth2) {
				newSize_1 = (long) this.resize_total - minChildWidth2;
				newSize_2 = minChildWidth2;
			}

			Object data1 = this.c1.getProperties().get(LAYOUT_KEY);
			if (data1 == null || !(data1 instanceof SashFormData)) {
				data1 = new SashFormData();
				this.c1.getProperties().put(LAYOUT_KEY, data1);
			}
			Object data2 = this.c2.getProperties().get(LAYOUT_KEY);
			if (data2 == null || !(data2 instanceof SashFormData)) {
				data2 = new SashFormData();
				this.c2.getProperties().put(LAYOUT_KEY, data2);
			}

			((SashFormData) data1).weight = (((long) newSize_1 << 16) + rectangle.width - 1) / rectangle.width;
			((SashFormData) data2).weight = (((long) newSize_2 << 16) + rectangle.width - 1) / rectangle.width;

			this.c1.resize(newSize_1, rectangle.height);
			this.c2.resizeRelocate(this.c1.getLayoutX() + newSize_1 + getSashWidth(), this.c2.getLayoutY(), newSize_2,
					rectangle.height);
			this.draggedSash.relocate(this.c1.getLayoutX() + newSize_1, this.draggedSash.getLayoutY());
		} else {
			double delta = e.getScreenY() - this.start;
			long newSize_1 = (long) (this.resize_1 + delta);
			long newSize_2 = (long) (this.resize_2 - delta);
			
			long minChildHeight1 = minChildHeight(this.c1, getWidth());
			long minChildHeight2 = minChildHeight(this.c2, getWidth());
			
			if (newSize_1 < minChildHeight1) {
				newSize_2 = (long) this.resize_total - minChildHeight1;
				newSize_1 = minChildHeight1;
			}

			if (newSize_2 < minChildHeight2) {
				newSize_1 = (long) this.resize_total - minChildHeight2;
				newSize_2 = minChildHeight2;
			}
			
			long remainder = (long)this.resize_total - newSize_1 - newSize_2;
			
			if( remainder != 0 ) {
				newSize_1 += remainder;
			}

			Object data1 = this.c1.getProperties().get(LAYOUT_KEY);
			if (data1 == null || !(data1 instanceof SashFormData)) {
				data1 = new SashFormData();
				this.c1.getProperties().put(LAYOUT_KEY, data1);
			}
			Object data2 = this.c2.getProperties().get(LAYOUT_KEY);
			if (data2 == null || !(data2 instanceof SashFormData)) {
				data2 = new SashFormData();
				this.c2.getProperties().put(LAYOUT_KEY, data2);
			}

			((SashFormData) data1).weight = (((long) newSize_1 << 16) + rectangle.height - 1) / rectangle.height;
			((SashFormData) data2).weight = (((long) newSize_2 << 16) + rectangle.height - 1) / rectangle.height;

			this.c1.resize(rectangle.width, newSize_1);
			this.c2.resizeRelocate(this.c2.getLayoutX(), this.c1.getLayoutY() + newSize_1 + getSashWidth(),
					rectangle.width, newSize_2);
			this.draggedSash.relocate(this.draggedSash.getLayoutX(), this.c1.getLayoutY() + newSize_1);
		}
	}

	private void handlePressedSash(MouseEvent e) {
		e.consume();
		
		Sash sash = (Sash) e.getSource();

		int sashIndex = -1;
		for (int i = 0; i < this.sashes.length; i++) {
			if (this.sashes[i] == sash) {
				sashIndex = i;
				break;
			}
		}
		if (sashIndex == -1)
			return;

		this.start = this.horizontal.get() ? e.getScreenX() : e.getScreenY();
		this.draggedSash = sash;

		List<SashChild> visibleNodes = getManagedChildren().stream()
				.filter(Node::isVisible)
				.map(SashChild.class::cast)
				.collect(Collectors.toList());

		if( hasFixedChild() &&  (visibleNodes.get(sashIndex).isFixed() || visibleNodes.get(sashIndex+1).isFixed()) ) {
			int idx = visibleNodes.get(sashIndex).isFixed() ? findPrevUnfixed(visibleNodes, sashIndex) : sashIndex;
			if( idx != -1 ) {
				this.c1 = visibleNodes.get(idx);
				Bounds b = this.c1.getLayoutBounds();
				this.resize_1 = this.horizontal.get() ? b.getWidth() : b.getHeight();
			} else {
				this.c1 = null;
			}
			
			idx = findNextUnfixed(visibleNodes, sashIndex);
			if( idx != -1 ) {
				this.c2 = visibleNodes.get(idx);
				Bounds b = this.c2.getLayoutBounds();
				this.resize_2 = this.horizontal.get() ? b.getWidth() : b.getHeight();
			} else {
				this.c2 = null;
			}
			
			this.resize_total = this.resize_1 + this.resize_2;		
		} else {
			this.c1 = visibleNodes.get(sashIndex);
			Bounds b = this.c1.getLayoutBounds();
			this.resize_1 = this.horizontal.get() ? b.getWidth() : b.getHeight();

			this.c2 = visibleNodes.get(sashIndex + 1);
			b = this.c2.getLayoutBounds();
			this.resize_2 = this.horizontal.get() ? b.getWidth() : b.getHeight();
			this.resize_total = this.resize_1 + this.resize_2;			
		}
	}

	private Sash createSash() {
		Sash sash = new Sash();
		sash.setOnMousePressed(this::handlePressedSash);
		sash.setOnMouseDragged(this::handleDragSash);
		sash.setOnMouseReleased( evt -> {
			this.draggedSash = null;
			this.c1 = null;
			this.c2 = null;
		});
		getChildren().add(sash);
		return sash;
	}

	/**
	 * <p>
	 * Specify the relative weight of each child in the {@link SashPane}. This will
	 * determine what percent of the total width (if {@link SashPane} has Horizontal
	 * orientation) or total height (if {@link SashPane} has Vertical orientation)
	 * each control will occupy.
	 * </p>
	 * <p>
	 * The weights must be positive values and there must be an entry for each
	 * non-sash child of the SashForm.
	 * </p>
	 *
	 * @param weights
	 */
	public void setWeights(int[] weights) {
		List<Node> children = getManagedChildren();

		if (weights == null || weights.length != children.size()) {
			throw new IllegalArgumentException();
		}

		int total = 0;
		for (int i = 0; i < weights.length; i++) {
			if (weights[i] < 0) {
				throw new IllegalArgumentException();
			}
			total += weights[i];
		}

		if (total == 0) {
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < children.size(); i++) {
			Object data = children.get(i).getProperties().get(LAYOUT_KEY);
			if (data == null || !(data instanceof SashFormData)) {
				data = new SashFormData();
				children.get(i).getProperties().put(LAYOUT_KEY, data);
			}
			((SashFormData) data).weight = (((long) weights[i] << 16) + total - 1) / total;
		}
		clearCache();
		requestLayout();
	}

	/**
	 * <p>
	 * Answer the relative weight of each child in the SashForm.
	 * </p>
	 * <p>
	 * The weight represents the percent of the total width (if SashForm has
	 * Horizontal orientation) or total height (if SashForm has Vertical
	 * orientation) each control occupies.
	 * </p>
	 * <p>
	 * The weights are returned in order of the creation of the widgets (weight[0]
	 * corresponds to the weight of the first child created).
	 * </p>
	 *
	 * @return the relative weight of each child
	 */
	public int[] getWeights() {
		List<Node> children = getManagedChildren();
		int[] ratios = new int[children.size()];
		for (int i = 0; i < children.size(); i++) {
			Object data = children.get(i).getProperties().get(LAYOUT_KEY);
			if (data != null && data instanceof SashFormData) {
				ratios[i] = (int) (((SashFormData) data).weight * 1000 >> 16);
			} else {
				ratios[i] = 200;
			}
		}
		return ratios;
	}
	
	/**
	 * @return property with the current weights
	 * @see #getWeights()
	 * @see #setWeights(int[])
	 */
	public ObjectProperty<int[]> weightsProperty() {
		if( this.weights == null ) {
			this.weights = new SimpleObjectProperty<>(this, "weights"); //$NON-NLS-1$
			this.weights.addListener( (ob, ol, ne) -> {
				if( ! this.syncInProgress ) {
					setWeights(ne);
				}
			} );
		}
		return this.weights;
	}

	/**
	 * @return Property defining if children are layed out in columns
	 *         (<code>true</code>) or rows (<code>false</code>)
	 */
	public final BooleanProperty horizontalProperty() {
		return this.horizontal;
	}

	/**
	 * @return <code>true</code> if children layed out in columns
	 */
	public final boolean isHorizontal() {
		return this.horizontalProperty().get();
	}

	/**
	 * Change the layout of children to columns (<code>true</code>) or rows
	 * (<code>false</code>)
	 *
	 * @param horizontal
	 */
	public final void setHorizontal(final boolean horizontal) {
		this.horizontalProperty().set(horizontal);
	}

	// public final ObjectProperty<Node> maximizedControlProperty() {
	// return this.maximizedControl;
	// }
	//
	// public final Node getMaximizedControl() {
	// return this.maximizedControlProperty().get();
	// }
	//
	// public final void setMaximizedControl(final Node maximizedControl) {
	// this.maximizedControlProperty().set(maximizedControl);
	// }

	/**
	 * @return width of the sash shown between items
	 */
	public final IntegerProperty sashWidthProperty() {
		return this.sashWidth;
	}

	/**
	 * @return the width of a sash
	 */
	public final int getSashWidth() {
		return this.sashWidthProperty().get();
	}

	/**
	 * Set the width of a sash
	 *
	 * @param sashWidth the width
	 */
	public final void setSashWidth(final int sashWidth) {
		this.sashWidthProperty().set(sashWidth);
	}

	static class SashFormData {
		public long weight;
	}

	static class Sash extends StackPane {
		public Sash() {
			getStyleClass().add("sash"); //$NON-NLS-1$
			setManaged(false);
			setMouseTransparent(false);
			
			Region r = new Region();
			r.getStyleClass().add("sash-handle"); //$NON-NLS-1$
			getChildren().add(r);
		}
	}

	static class SashChild extends AnchorPane {
		ObjectProperty<Boolean> fixedSize = new SimpleObjectProperty<>();
		private javafx.scene.shape.Rectangle r = new javafx.scene.shape.Rectangle();

		public SashChild(Node c) {
			if( c instanceof FixedSashItem ) {
				this.fixedSize.bind(((FixedSashItem)c).fixed());
				this.fixedSize.addListener( (ob,ol,ne) -> {
					Parent parent = getParent();
					if( parent != null ) {
						((SashPane) parent).layoutChildren(true);
					}
				});
			}
			getChildren().add(c);
			setClip(this.r);
			visibleProperty().bind(c.visibleProperty());
			visibleProperty().addListener((ob, ol, ne) -> {
				Parent parent = getParent();
				if( parent != null ) {
					((SashPane) parent).layoutChildren(true);	
				}
			});
			AnchorPane.setBottomAnchor(c, Double.valueOf(0.0));
			AnchorPane.setTopAnchor(c, Double.valueOf(0.0));
			AnchorPane.setLeftAnchor(c, Double.valueOf(0.0));
			AnchorPane.setRightAnchor(c, Double.valueOf(0.0));
//			setStyle("-fx-border-width: 1; -fx-border-style: solid; -fx-border-color: black");
		}

		@Override
		public void resize(double width, double height) {
			super.resize(width, height);
			this.r.setWidth(width);
			this.r.setHeight(height);
		}

		public void dispose() {
			visibleProperty().unbind();
			this.fixedSize.unbind();
		}
		
		public boolean isFixed() {
			return Boolean.TRUE.equals(this.fixedSize.get());
		}
	}

	static class Rectangle {
		int x;
		int y;
		int width;
		int height;

		public Rectangle(double width, double height, Insets insets) {
			this.x = (int) Math.ceil(insets.getLeft());
			this.y = (int) Math.ceil(insets.getTop());
			this.width = (int) Math.floor(width) - (int) Math.ceil(insets.getLeft())
					- (int) Math.ceil(insets.getRight());
			this.height = (int) Math.floor(height) - (int) Math.ceil(insets.getTop())
					- (int) Math.ceil(insets.getBottom());
		}

		public Rectangle(Bounds b) {
			this.x = (int) Math.ceil(b.getMinX());
			this.y = (int) Math.ceil(b.getMinY());
			this.width = (int) Math.floor(b.getWidth());
			this.height = (int) Math.floor(b.getHeight());
		}
	}
}

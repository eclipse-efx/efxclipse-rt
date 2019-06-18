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

import org.eclipse.fx.ui.controls.Util;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;

/**
 * Overlay to represent different area
 */
public final class AreaOverlay extends Region {
	private final BorderPane left;
	private final BorderPane right;
	private final BorderPane top;
	private final BorderPane bottom;

	private final double leftRightRatio;
	private Area activeType = Area.NONE;
	private static final String STYLECLASS_ACTIVE = "active"; //$NON-NLS-1$

	/**
	 * The area
	 */
	public enum Area {
		/**
		 * No area
		 */
		NONE,
		/**
		 * The top one
		 */
		TOP,
		/**
		 * The left one
		 */
		LEFT,
		/**
		 * The right one
		 */
		RIGHT,
		/**
		 * The bottom one
		 */
		BOTTOM
	}
	
	/**
	 * Create an area overlay
	 * 
	 * @param leftRightRatio
	 *            the ration used by the left and right areas
	 */
	public AreaOverlay(double leftRightRatio) {
		setUserData(Util.FIND_NODE_EXCLUDE);
		getStyleClass().add("area-overlay"); //$NON-NLS-1$

		this.leftRightRatio = leftRightRatio;
		this.left = new BorderPane(new Label("Left")); //$NON-NLS-1$
		this.left.getStyleClass().addAll("left", "area");  //$NON-NLS-1$//$NON-NLS-2$

		this.right = new BorderPane(new Label("Right")); //$NON-NLS-1$
		this.right.getStyleClass().addAll("right", "area");  //$NON-NLS-1$//$NON-NLS-2$

		this.top = new BorderPane(new Label("Top")); //$NON-NLS-1$
		this.top.getStyleClass().addAll("top", "area");  //$NON-NLS-1$//$NON-NLS-2$

		this.bottom = new BorderPane(new Label("Bottom")); //$NON-NLS-1$
		this.bottom.getStyleClass().addAll("bottom", "area");  //$NON-NLS-1$//$NON-NLS-2$
		
		getChildren().addAll(this.left, this.right, this.top, this.bottom);
	}
	
	/**
	 * Update the active area
	 * @param area the active area
	 */
	public void updateActiveArea(Area area) {
		Node newNode = getNodeForType(area);
		Node oldNode = getNodeForType(this.activeType);
		if( newNode == oldNode ) {
			return;
		}
		if( oldNode != null ) {
			oldNode.getStyleClass().remove(STYLECLASS_ACTIVE);
		}
		if(newNode != null) {
			newNode.getStyleClass().add(STYLECLASS_ACTIVE);
		}
		this.activeType = area;
	}
	
	private Node getNodeForType(Area area) {
		switch (area) {
		case BOTTOM:
			return this.bottom;
		case LEFT:
			return this.left;
		case RIGHT:
			return this.right;
		case TOP:
			return this.top;
		default:
			return null;
		}
	}
	
	@Override
	protected void layoutChildren() {
		super.layoutChildren();

		Insets pad = getPadding();
		double width = getWidth() * this.leftRightRatio;
		double height = getHeight() - (pad.getTop() + pad.getBottom());

		this.left.resizeRelocate(pad.getLeft(), pad.getTop(), width, height);
		this.right.resizeRelocate(getWidth() - pad.getRight() - width, pad.getTop(), width, height);

		this.top.resizeRelocate(this.left.getLayoutX() + this.left.getWidth(), this.left.getLayoutY(), getWidth() - width * 2, height / 2);
		this.bottom.resizeRelocate(this.left.getLayoutX() + this.left.getWidth(), this.top.getLayoutY() + this.top.getHeight(), getWidth() - width * 2, height / 2);
	}
}

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

import javafx.geometry.Insets;
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

	/**
	 * Create an area overlay
	 * 
	 * @param leftRightRatio
	 *            the ration used by the left and right areas
	 */
	public AreaOverlay(double leftRightRatio) {
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

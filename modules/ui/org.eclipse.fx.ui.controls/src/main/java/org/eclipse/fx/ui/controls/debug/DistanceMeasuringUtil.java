/*******************************************************************************
 * Copyright (c) 2020 BestSolution.at and others.
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
package org.eclipse.fx.ui.controls.debug;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.observable.FXObservableUtil;

import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;

/**
 * Utility one can attach to a scenegraph to measure the distance between nodes
 * <p>
 * <strong>This is not released as API yet so it might change and/or removed/moved anywhere else</strong>
 * </p>
 * 
 * @noreference
 */
public class DistanceMeasuringUtil extends Region {
	private Subscription boundsChangeSub;
	private Region line1;
	private Region line2;
	private Region line3;

	private Double l1 = null;
	private Double l2 = null;
	private Label text;

	private Region draggedNode;
	private double startVal;
	private double startLocation;

	/**
	 * Create a new instance
	 * 
	 * @param p
	 *            the parent
	 */
	public DistanceMeasuringUtil(Parent p) {
		setMouseTransparent(true);
		this.line1 = new Region();
		this.line1.setStyle("-fx-background-color: rgba(0,0,0,0.0), rgba(255,0,0,0.0), rgba(255,0,0,1); -fx-background-insets: 0, 0 8 0 8, 0 12 0 12; -fx-cursor: h-resize"); //$NON-NLS-1$
		this.line1.setOnMousePressed(e -> {
			this.draggedNode = this.line1;
			this.startLocation = e.getScreenX();
			this.startVal = this.l1.doubleValue();
		});
		this.line1.setOnMouseDragged(e -> {
			if (this.draggedNode == this.line1) {
				this.l1 = Double.valueOf(this.startVal + (e.getScreenX() - this.startLocation));
				requestLayout();
			}
		});
		this.line1.setOnMouseReleased(e -> this.draggedNode = null);

		this.line2 = new Region();
		this.line2.setStyle("-fx-background-color: rgba(0,0,0,0), rgba(255,0,0,0), rgba(255,0,0,1); -fx-background-insets: 0, 0 8 0 8, 0 12 0 12; -fx-cursor: h-resize"); //$NON-NLS-1$
		this.line2.setOnMousePressed(e -> {
			this.draggedNode = this.line2;
			this.startLocation = e.getScreenX();
			this.startVal = this.l2.doubleValue();
		});
		this.line2.setOnMouseDragged(e -> {
			if (this.draggedNode == this.line2) {
				this.l2 = Double.valueOf(this.startVal + (e.getScreenX() - this.startLocation));
				requestLayout();
			}
		});
		this.line2.setOnMouseReleased(e -> {
			this.draggedNode = null;
		});

		this.line3 = new Region();
		this.line3.setStyle("-fx-background-color: rgba(255,0,0);"); //$NON-NLS-1$

		this.text = new Label();
		this.text.setStyle("-fx-text-fill: rgba(255,0,0); -fx-font-size: 10px"); //$NON-NLS-1$
		this.text.setText("0px"); //$NON-NLS-1$

		setManaged(false);
		this.boundsChangeSub = FXObservableUtil.onChange(p.layoutBoundsProperty(), this::handleBoundsChange);

		getChildren().addAll(this.line1, this.line2, this.line3, this.text);
		FXObservableUtil.onChange(sceneProperty(), this::handleSceneChange);
	}

	private void handleSceneChange(Scene ol, Scene ne) {
		ne.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
			if (e.getCode() == KeyCode.COMMAND) {
				setMouseTransparent(false);
			} else if (e.getCode() == KeyCode.LEFT) {
				if (this.draggedNode == this.line1) {
					this.l1 = Double.valueOf(this.l1.doubleValue() - 1);
					this.startVal -= 1;
					requestLayout();
					e.consume();
				}
				if (this.draggedNode == this.line2) {
					this.l2 = Double.valueOf(this.l2.doubleValue() - 1);
					this.startVal -= 1;
					requestLayout();
					e.consume();
				}
			} else if (e.getCode() == KeyCode.RIGHT) {
				if (this.draggedNode == this.line1) {
					this.l1 = Double.valueOf(this.l1.doubleValue() + 1);
					this.startVal += 1;
					requestLayout();
					e.consume();
				}
				if (this.draggedNode == this.line2) {
					this.l2 = Double.valueOf(this.l2.doubleValue() + 1);
					this.startVal += 1;
					requestLayout();
					e.consume();
				}
			}
		});
		ne.addEventFilter(KeyEvent.KEY_RELEASED, e -> {
			if (e.getCode() == KeyCode.COMMAND) {
				setMouseTransparent(true);
			}
		});
	}

	private void handleBoundsChange(Bounds b) {
		resize(b.getWidth(), b.getHeight());
	}
	
	/**
	 * Dispose the utility
	 */
	public void dispose() {
		this.boundsChangeSub.dispose();
	}

	@Override
	protected void layoutChildren() {
		double areaWidth = 25;
		if (this.l1 == null) {
			this.l1 = Double.valueOf(getWidth() / 2 - areaWidth / 2);
		}
		if (this.l2 == null) {
			this.l2 = Double.valueOf(getWidth() / 2 + areaWidth / 2);
		}

		this.line1.resizeRelocate(this.l1.doubleValue(), 0, areaWidth, getHeight());
		this.line2.resizeRelocate(this.l2.doubleValue(), 0, areaWidth, getHeight());
		this.line3.resizeRelocate(Math.min(this.l1.doubleValue(), this.l2.doubleValue()) + areaWidth / 2, getHeight() / 2, Math.abs(this.l1.doubleValue() - this.l2.doubleValue()), 1);

		this.text.setText(String.format("%.2f px", Double.valueOf(Math.abs(this.l1.doubleValue() - this.l2.doubleValue())))); //$NON-NLS-1$
		double w = this.text.prefWidth(Region.USE_COMPUTED_SIZE);
		double h = this.text.prefHeight(Region.USE_COMPUTED_SIZE);
		this.text.resizeRelocate(Math.min(this.l1.doubleValue(), this.l2.doubleValue()) + areaWidth / 2 + Math.abs(this.l1.doubleValue() - this.l2.doubleValue()) / 2 - w / 2, getHeight() / 2 + 3, w, h);
	}
}

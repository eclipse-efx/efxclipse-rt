/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.animation;

import javafx.animation.Transition;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

/**
 * This {@link Transition} creates a scale animation that spans the provided
 * duration.
 * <p>
 * Unlike {@link javafx.animation.ScaleTransition} this transition does not
 * operate on {@code scaleX},{@code scaleY} and {@code scaleZ} variables of the
 * {@code node} at regular interval but uses {@link Scale#xProperty()},
 * {@link Scale#yProperty()} and {@link Scale#zProperty()}
 * </p>
 * 
 * @since 3.1.0
 */
public class ScaleTransition extends Transition {
	private double startX = Double.NaN;
	private double startY = Double.NaN;
	private double startZ = Double.NaN;

	private double deltaX;
	private double deltaY;
	private double deltaZ;

	private final Scale scale;

	private double fromX = 1;
	private double toX = 1;
	private double fromY = 1;
	private double toY = 1;
	private double fromZ = 1;
	private double toZ = 1;

	/**
	 * Create a new scale transition
	 * 
	 * @param duration
	 *            the duration
	 * @param scale
	 *            the scale
	 */
	public ScaleTransition(Duration duration, Scale scale) {
		this.scale = scale;
		setCycleDuration(duration);
	}

	/**
	 * Set a new from value for the x coordinate (default=1)
	 * 
	 * @param fromX
	 *            the new value
	 */
	public void setFromX(double fromX) {
		this.fromX = fromX;
		computeDelta();
	}

	/**
	 * Set a new to value for the x coordinate (default=1)
	 * 
	 * @param toX
	 *            the new value
	 */
	public void setToX(double toX) {
		this.toX = toX;
		computeDelta();
	}

	/**
	 * Set a new from value for the y coordinate (default=1);
	 * 
	 * @param fromY
	 *            the new value
	 */
	public void setFromY(double fromY) {
		this.fromY = fromY;
		computeDelta();
	}

	/**
	 * Set a new to value for the y coordinate (default=1);
	 * 
	 * @param toY
	 *            the new value
	 */
	public void setToY(double toY) {
		this.toY = toY;
		computeDelta();
	}

	/**
	 * Set a new from value for the z coordinate (default=1)
	 * 
	 * @param fromZ
	 *            the new value
	 */
	public void setFromZ(double fromZ) {
		this.fromZ = fromZ;
		computeDelta();
	}

	/**
	 * Set a new to value for the z coordinate (default=1);
	 * 
	 * @param toZ
	 *            the new value
	 */
	public void setToZ(double toZ) {
		this.toZ = toZ;
		computeDelta();
	}

	private void computeDelta() {
		this.startX = this.fromX;
		this.startY = this.fromY;
		this.startZ = this.fromZ;
		this.deltaX = this.toX - this.fromX;
		this.deltaY = this.toY - this.fromY;
		this.deltaZ = this.toZ - this.fromZ;
	}

	@Override
	protected void interpolate(double frac) {
		if (!Double.isNaN(this.startX)) {
			this.scale.setX(this.startX + frac * this.deltaX);
		}
		if (!Double.isNaN(this.startY)) {
			this.scale.setY(this.startY + frac * this.deltaY);
		}
		if (!Double.isNaN(this.startZ)) {
			this.scale.setZ(this.startZ + frac * this.deltaZ);
		}
	}

}

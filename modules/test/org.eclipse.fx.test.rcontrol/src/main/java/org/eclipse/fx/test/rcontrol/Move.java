/*******************************************************************************
 * Copyright (c) 2019 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.test.rcontrol;

import java.time.Duration;

import org.eclipse.fx.core.ThreadSynchronize.BlockCondition;

import javafx.animation.Transition;
import javafx.geometry.Pos;

/**
 * Move operations
 */
public interface Move {
	/**
	 * Create operation who moves the cursor from the current mouse position by the
	 * provided delta
	 * 
	 * @param dx
	 *            the x delta
	 * @param dy
	 *            the y delta
	 * @return operation
	 */
	public static Operation by(double dx, double dy) {
		return (r) -> {
			r.mouseMoveTo(r.mouseX() + (int) dx, r.mouseY() + (int) dy);
			return r;
		};
	}

	/**
	 * Create operation who moves the cursor from the current mouse position by the
	 * provided delta in the provided time
	 * 
	 * @param d
	 *            duration it takes move the delta
	 * 
	 * @param dx
	 *            the x delta
	 * @param dy
	 *            the y delta
	 * @return operation
	 */
	public static Operation by(Duration d, double dx, double dy) {
		return (r) -> {
			BlockCondition<Void> b = new BlockCondition<>();
			int mouseX = r.mouseX();
			int mouseY = r.mouseY();
			Transition tt = new Transition() {
				{
					setCycleDuration(javafx.util.Duration.millis(d.toMillis()));
				}

				@Override
				protected void interpolate(double frac) {
					r.mouseMoveTo((int) (mouseX + dx * frac), (int) (mouseY + dy * frac));
				}
			};
			tt.setOnFinished(e -> b.release(null));
			tt.play();
			r.block(b);
			return r;
		};
	}

	/**
	 * Move the cursor to the x/y position on the screen
	 * 
	 * @param x
	 *            the absolute x coordinate on the screen
	 * @param y
	 *            the absolute y coordinate on the screen
	 * @return operation
	 */
	public static Operation to(double x, double y) {
		return (r) -> {
			r.mouseMoveTo((int) x, (int) y);
			return r;
		};
	}

	/**
	 * Move the cursor to the x/y position on the screen
	 * 
	 * @param d
	 *            the duration it takes to reach the provided position
	 * 
	 * @param x
	 *            the absolute x coordinate on the screen
	 * @param y
	 *            the absolute y coordinate on the screen
	 * @return operation
	 */
	public static Operation to(Duration d, double x, double y) {
		return (r) -> {
			BlockCondition<Void> b = new BlockCondition<>();
			int mouseX = r.mouseX();
			int mouseY = r.mouseY();
			double dx = x - mouseX;
			double dy = y - mouseY;
			Transition tt = new Transition() {
				{
					setCycleDuration(javafx.util.Duration.millis(d.toMillis()));
				}

				@Override
				protected void interpolate(double frac) {
					r.mouseMoveTo((int) (mouseX + dx * frac), (int) (mouseY + dy * frac));
				}
			};
			tt.setOnFinished(e -> b.release(null));
			tt.play();
			r.block(b);
			return r;
		};
	}

	/**
	 * Move the cursor with the provided x/y velocity for the provided time
	 * 
	 * @param d
	 *            the duration
	 * @param vx
	 *            the x velocity
	 * @param vy
	 *            the y velocity
	 * @return the operation
	 */
	public static Operation with(Duration d, double vx, double vy) {
		return to(d, vx * d.toMillis(), vy * d.toMillis());
	}

	/**
	 * Direct move actions
	 * 
	 * @param <C>
	 *            the context owner type
	 */
	public interface Moveable<C> {
		/**
		 * Move to a location relative to the upper left corner
		 * 
		 * @param x
		 *            the x relative to upper left corner
		 * @param y
		 *            the y relative to upper left corner
		 * @return the owner
		 */
		public C moveTo(double x, double y);

		/**
		 * Move to a location relative to the upper left corner in the provided duration
		 * 
		 * @param d
		 *            the duration
		 * @param x
		 *            the x relative to upper left corner
		 * @param y
		 *            the y relative to upper left corner
		 * @return the owner
		 */
		public C moveTo(Duration d, double x, double y);

		/**
		 * Move to a location relative to the reference position provided
		 * 
		 * @param referencePoint
		 *            the duration
		 * @param x
		 *            the x relative to the position provided
		 * @param y
		 *            the y relative to the position provided
		 * @return the owner
		 */
		public C moveTo(Pos referencePoint, double x, double y);

		/**
		 * Move to a location relative to the reference position provided in the
		 * provided duration
		 * 
		 * @param d
		 *            the duration
		 * @param referencePoint
		 *            the reference point
		 * @param x
		 *            the x relative to the position provided
		 * @param y
		 *            the y relative to the position provided
		 * @return the owner
		 */
		public C moveTo(Duration d, Pos referencePoint, double x, double y);

		/**
		 * Move to the center of the owner
		 * 
		 * @return the owner
		 */
		public C moveToCenter();

		/**
		 * Move to the center of the owner in the provided duration
		 * 
		 * @param d
		 *            the duraion
		 * @return the owner
		 */
		public C moveToCenter(Duration d);		
	}
}

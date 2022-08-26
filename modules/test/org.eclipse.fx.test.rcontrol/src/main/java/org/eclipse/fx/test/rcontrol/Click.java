/*******************************************************************************
 * Copyright (c) 2019 BestSolution.at and others.
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
package org.eclipse.fx.test.rcontrol;

import javafx.scene.input.MouseButton;

/**
 * Click operations
 */
public interface Click {

	/**
	 * Create a click operation with the {@link MouseButton#PRIMARY} at the current
	 * cursor location
	 * 
	 * @return operation
	 */
	public static Operation click() {
		return click(MouseButton.PRIMARY);
	}

	/**
	 * Create a click operation with the provided {@link MouseButton} at the current
	 * cursor location
	 * 
	 * @param button
	 *            the button
	 * @return operation
	 */
	public static Operation click(MouseButton button) {
		return (r) -> {
			r.press(button);
			r.release(button);
			return r;
		};
	}

	/**
	 * Create a click operation with the {@link MouseButton#PRIMARY} at the provided
	 * x/y location on screen
	 * 
	 * @param x
	 *            the x coordinate on screen
	 * @param y
	 *            the y coordinate on screen
	 * @return operation
	 */
	public static Operation click(double x, double y) {
		return click(MouseButton.PRIMARY);
	}

	/**
	 * Create a click operation with the provided {@link MouseButton} at the
	 * provided x/y location on screen
	 * 
	 * @param button
	 *            the mouse button
	 * 
	 * @param x
	 *            the x coordinate on screen
	 * @param y
	 *            the y coordinate on screen
	 * @return operation
	 */
	public static Operation click(MouseButton button, double x, double y) {
		return (r) -> {
			r.mouseMoveTo((int) x, (int) y);
			r.press(button);
			r.release(button);
			return r;
		};
	}

	/**
	 * Create a double click operation with the {@link MouseButton#PRIMARY} at the
	 * current mouse location
	 * 
	 * @return operation
	 */
	public static Operation doubleClick() {
		return doubleClick(MouseButton.PRIMARY);
	}

	/**
	 * Create a double click operation with the provided {@link MouseButton} at the
	 * current mouse location
	 * 
	 * @param button
	 *            the button type
	 * 
	 * @return operation
	 */
	public static Operation doubleClick(MouseButton button) {
		return (r) -> {
			r.press(button);
			r.release(button);

			r.press(button);
			r.release(button);
			return r;
		};
	}

	/**
	 * Create a double click operation with the {@link MouseButton#PRIMARY} at the
	 * provided x/y coordinate on the screen
	 * 
	 * @param x
	 *            the x coordinate on the screen
	 * @param y
	 *            the y coordinate on the screen
	 * @return operation
	 */
	public static Operation doubleClick(double x, double y) {
		return doubleClick(MouseButton.PRIMARY, x, y);
	}

	/**
	 * Create a double click operation with the provided {@link MouseButton} at the
	 * provided x/y coordinate on the screen
	 * 
	 * @param button
	 *            the button type
	 * 
	 * @param x
	 *            the x coordinate on the screen
	 * @param y
	 *            the y coordinate on the screen
	 * @return operation
	 */
	public static Operation doubleClick(MouseButton button, double x, double y) {
		return (r) -> {
			r.mouseMoveTo((int) x, (int) y);
			r.press(button);
			r.release(button);

			r.press(button);
			r.release(button);
			return r;
		};
	}

	/**
	 * Direct click actions
	 * 
	 * @param <C>
	 *            the context owner type
	 */
	public interface Clickable<C> {
		/**
		 * Click the {@link MouseButton#PRIMARY} at the center of the context
		 * 
		 * @return the owner
		 */
		public C click();

		/**
		 * Click the {@link MouseButton} at the center of the node
		 * 
		 * @param button
		 *            the button
		 * @return the owner
		 */
		public C click(MouseButton button);

		/**
		 * Click the {@link MouseButton#PRIMARY} at the x/y coordinates relative the
		 * left-upper corner of the context
		 * 
		 * @param x
		 *            the x difference to the left upper corner in the context
		 * @param y
		 *            the y difference to the left upper corner in the context
		 * @return the owner
		 */
		public C click(double x, double y);

		/**
		 * Click the {@link MouseButton} at the x/y coordinates relative the left-upper
		 * corner of the context
		 * 
		 * @param button
		 *            the button type
		 * 
		 * @param x
		 *            the x difference to the left upper corner in the context
		 * @param y
		 *            the y difference to the left upper corner in the context
		 * @return the owner
		 */
		public C click(MouseButton button, double x, double y);

		/**
		 * Double click the {@link MouseButton#PRIMARY} at the center of the context
		 * 
		 * @return the owner
		 */
		public C doubleClick();

		/**
		 * Double click the {@link MouseButton} at the center of the context
		 * 
		 * @param button
		 *            the button type
		 * 
		 * @return the owner
		 */
		public C doubleClick(MouseButton button);

		/**
		 * Double click the {@link MouseButton#PRIMARY} at the x/y coordinates relative
		 * the left-upper corner of the context
		 * 
		 * @param x
		 *            the x difference to the left upper corner in the context
		 * @param y
		 *            the y difference to the left upper corner in the context
		 * 
		 * @return the owner
		 */
		public C doubleClick(double x, double y);

		/**
		 * Double click the {@link MouseButton} at the x/y coordinates relative the
		 * left-upper corner of the context
		 * 
		 * @param button
		 *            the button
		 * 
		 * @param x
		 *            the x difference to the left upper corner in the context
		 * @param y
		 *            the y difference to the left upper corner in the context
		 * 
		 * @return the owner
		 */
		public C doubleClick(MouseButton button, double x, double y);
	}
}

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

import java.time.Duration;

import org.eclipse.fx.core.ThreadSynchronize.BlockCondition;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.MouseButton;

/**
 * The roboter interface
 */
public interface RRobot {
	/**
	 * Sleep for the specified duration (without halting the event loop)
	 * 
	 * @param duration
	 *            the duration
	 * @return self
	 */
	public RController sleep(Duration duration);

	/**
	 * @return x coordinate of the mouse cursor on screen
	 */
	public int mouseX();

	/**
	 * @return y coordinate of the mouse cursor on screen
	 */
	public int mouseY();

	/**
	 * Move the mouse to the provided position
	 * 
	 * @param x
	 *            the x coordinate of the cursor on screen
	 * @param y
	 *            the y coordinate of the cursor on screen
	 * @return self
	 */
	public RController mouseMoveTo(int x, int y);

	/**
	 * Press the button
	 * 
	 * @param button
	 *            the button type
	 * @return self
	 */
	public RController press(MouseButton button);

	/**
	 * Release the button
	 * 
	 * @param button
	 *            the button
	 * @return self
	 */
	public RController release(MouseButton button);

	/**
	 * Sleep for the provided milliseconds
	 * 
	 * @param milli
	 *            the milliseconds
	 * @return self
	 */
	public RController sleep(long milli);

	/**
	 * Block program flow until the condition is released
	 * 
	 * @param b
	 *            the block condition
	 * @return self
	 */
	public RController block(BlockCondition<Void> b);

	/**
	 * Type the provided key codes
	 * 
	 * @param codes
	 *            the codes
	 * @return self
	 */
	public RController type(KeyCode... codes);

	/**
	 * Type the provided key combinations
	 * 
	 * @param combinations
	 *            the combinations
	 * @return self
	 */
	public RController type(KeyCodeCombination... combinations);

	/**
	 * Type the provided text
	 * 
	 * @param text
	 *            the text
	 * @return self
	 */
	public RController text(String text);
}

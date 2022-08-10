/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
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
package org.eclipse.fx.ui.keybindings;

/**
 * A key stroke
 */
public interface KeyStroke extends Trigger {
	/**
	 * @return has an alt key modifier
	 */
	boolean hasAltModifier();

	/**
	 * @return has a control key modifier
	 */
	boolean hasCtrlModifier();

	/**
	 * @return has a shift modifier
	 */
	boolean hasShiftModifier();
	
	/**
	 * @return has a command modifier
	 */
	boolean hasCommandModifier();
	
	/**
	 * @return the key code
	 */
	int getKeyCode();

}

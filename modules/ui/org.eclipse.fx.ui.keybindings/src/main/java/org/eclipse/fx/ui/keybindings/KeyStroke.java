/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

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
package org.eclipse.fx.ui.controls.demo;

import javafx.scene.Node;

/**
 * Interface to be implemented by demo element
 * <p>
 * This is interface is subject to change
 * </p>
 * @noimplement
 */
public interface ControlDemo {
	/**
	 * @return the label presented to the user
	 */
	public CharSequence getLabel();
	/**
	 * @return create the demo node
	 */
	public Node createNode();
}

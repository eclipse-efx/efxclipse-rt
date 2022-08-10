/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
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

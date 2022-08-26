/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.stage;

import javafx.scene.Node;

/**
 * Interface implemented by a window pane to support adding trim area
 * 
 * @since 2.0
 */
public interface TrimmedWindow extends Window {
	/**
	 * Set a top trim node
	 * 
	 * @param node
	 *            the node
	 */
	public void setTopTrim(Node node);

	/**
	 * Set a left trim node
	 * 
	 * @param node
	 *            the node
	 */
	public void setLeftTrim(Node node);

	/**
	 * Set a right trim node
	 * 
	 * @param node
	 *            the node
	 */
	public void setRightTrim(Node node);

	/**
	 * Set a bottom trim node
	 * 
	 * @param node
	 *            the node
	 */
	public void setBottomTrim(Node node);
}

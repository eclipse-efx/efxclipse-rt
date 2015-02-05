/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.stage;

import javafx.scene.Node;

/**
 * Optional interface implemented by a window pane to support adding trim area
 */
public interface TrimmedWindow {
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

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
 * A pane representing a window
 *
 * @since 2.0
 */
public interface Window extends Frame {
	/**
	 * Set if the dialog is resizable
	 *
	 * @param resizable
	 *            <code>true</code> to support resizable
	 */
	public void setResizeable(boolean resizable);

	/**
	 * Set if the dialog is minimizable
	 *
	 * @param minimizable
	 *            <code>true</code> to support minimizable
	 */
	public void setMinimizable(boolean minimizable);

	/**
	 * Set if the dialog is maximizable
	 *
	 * @param maximizable
	 *            <code>true</code> to support maximizable
	 */
	public void setMaximizable(boolean maximizable);

	/**
	 * Set menu bar
	 *
	 * @param n
	 *            the menu bar node
	 */
	public abstract void setMenuBar(Node n);

}
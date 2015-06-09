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

import javafx.event.EventTarget;
import javafx.scene.Node;

/**
 * Base interface for all window structures
 * 
 * @since 2.0
 */
public interface Frame extends EventTarget {
	/**
	 * Set the title
	 * 
	 * @param title
	 *            the title
	 */
	public abstract void setTitle(String title);

	/**
	 * Set the client area node
	 * 
	 * @param node
	 *            the client area node
	 */
	public abstract void setClientArea(Node node);

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
}

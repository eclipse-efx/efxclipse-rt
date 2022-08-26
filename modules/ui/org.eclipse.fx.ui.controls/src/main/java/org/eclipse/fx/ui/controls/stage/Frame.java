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
	 * Close the window
	 */
	public void close();
}

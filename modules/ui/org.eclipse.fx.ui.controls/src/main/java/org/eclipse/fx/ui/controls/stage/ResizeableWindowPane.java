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

import javafx.beans.property.ObjectProperty;
import javafx.scene.Node;

/**
 * A window pane who has handles at the borders to resize it
 *
 * @since 2.0
 */
public abstract class ResizeableWindowPane extends ResizeableFramePane implements Window {
	/**
	 * Create a new pane
	 */
	public ResizeableWindowPane() {
		super();
	}

	/**
	 * Create a new pane
	 *
	 * @param lightweight
	 *            <code>true</code> to mark it lightweight
	 * @since 2.4.0
	 */
	public ResizeableWindowPane(boolean lightweight) {
		super(lightweight);
	}

	@Override
	public final void setMenuBar(Node node) {
		menuBarProperty().set(node);
	}

	/**
	 * @return the menu bar
	 */
	public final Node getMenuBar() {
		return menuBarProperty().get();
	}

	/**
	 * @return the menu bar property
	 */
	public final ObjectProperty<Node> menuBarProperty() {
		return impl_menuBarProperty();
	}

	/**
	 * @return the real menubar property
	 */
	protected abstract ObjectProperty<Node> impl_menuBarProperty();
}

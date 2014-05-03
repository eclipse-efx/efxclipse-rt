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
package org.eclipse.fx.ui.workbench.renderers.fx.widget;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;

/**
 * A tool-menu item
 */
public class ToolItemMenu {
	private SplitMenuButton button;
	@SuppressWarnings("unused")
	private Object userData;
	@SuppressWarnings("unused")
	private String id;
	@SuppressWarnings("unused")
	private String text;
	private ObservableList<String> styleClass = FXCollections.observableArrayList();

	/**
	 * Create instance
	 * 
	 * @param button
	 *            the menu button
	 */
	public ToolItemMenu(SplitMenuButton button) {
		this.button = button;
	}

	/**
	 * @param userData
	 *            the user data to store
	 */
	public void setUserData(Object userData) {
		this.userData = userData;
	}

	/**
	 * @param id
	 *            the id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param text
	 *            the label
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return list of all style classes
	 */
	public ObservableList<String> getStyleClass() {
		return this.styleClass;
	}

	/**
	 * @return list of all menu items
	 */
	public ObservableList<MenuItem> getItems() {
		return this.button.getItems();
	}

}
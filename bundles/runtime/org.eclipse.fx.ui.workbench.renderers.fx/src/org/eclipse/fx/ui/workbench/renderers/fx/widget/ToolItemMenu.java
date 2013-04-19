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

public class ToolItemMenu {
	private SplitMenuButton button;
	private Object userData;
	private String id;
	private String text;
	private ObservableList<String> styleClass = FXCollections.observableArrayList();
	
	public ToolItemMenu(SplitMenuButton button) {
		this.button = button;
	}

	public void setUserData(Object userData) {
		this.userData = userData;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ObservableList<String> getStyleClass() {
		return styleClass;
	}

	public ObservableList<MenuItem> getItems() {
		return button.getItems();
	}
	
	
}

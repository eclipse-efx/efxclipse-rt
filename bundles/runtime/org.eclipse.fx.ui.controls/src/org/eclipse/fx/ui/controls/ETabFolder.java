/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls;

import org.eclipse.fx.ui.controls.internal.ETabFolderSkin;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Skin;

/**
 * A tab folder which special features
 */
public class ETabFolder extends Control {
	public enum State {
		DEFAULT,
		MINIMIZED,
		MAXIMIZED
	}
	
	public enum ToolDisplay {
		END,
		END_WRAP,
		FILL
	}
	
	private ObservableList<ETab> tabs = FXCollections.observableArrayList();
	private ObservableList<Node> toolItems = FXCollections.observableArrayList();
	private ObservableList<MenuItem> menuItems = FXCollections.observableArrayList();
	private ObjectProperty<State> state = new SimpleObjectProperty<ETabFolder.State>(this, "state", State.DEFAULT);
	private ObjectProperty<ToolDisplay> tooldisplay = new SimpleObjectProperty<ETabFolder.ToolDisplay>(this, "tooldisplay", ToolDisplay.END);
	
	public ObservableList<ETab> getTabs() {
		return tabs;
	}
	
	public ObservableList<Node> getToolItems() {
		return toolItems;
	}
	
	public ObservableList<MenuItem> getMenuItems() {
		return menuItems;
	}
	
	public ObjectProperty<State> stateProperty() {
		return state;
	}
	
	public void setState(State state) {
		this.state.set(state);
	}
	
	public State getState() {
		return state.get();
	}
	
	public ObjectProperty<ToolDisplay> toolDisplayProperty() {
		return tooldisplay;
	}
	
	public void setTooldisplay(ToolDisplay tooldisplay) {
		this.tooldisplay.set(tooldisplay);
	}
	
	public ToolDisplay getTooldisplay() {
		return this.tooldisplay.get();
	}
	
	@Override
	protected Skin<?> createDefaultSkin() {
		return new ETabFolderSkin(this);
	}
}

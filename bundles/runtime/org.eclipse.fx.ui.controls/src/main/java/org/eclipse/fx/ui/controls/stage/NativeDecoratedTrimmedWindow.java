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

import org.eclipse.fx.ui.controls.Util;

import javafx.beans.property.ObjectProperty;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * A trimmed window who delegates to the real window
 * 
 * @since 2.0
 */
public class NativeDecoratedTrimmedWindow extends BorderPane implements TrimmedWindow {
	private BorderPane trimPane;
	private javafx.stage.Stage w;
	private boolean resizable;
	private boolean minizable;
	private boolean maximizable;
	private String title;

	/**
	 * Create a new window
	 */
	public NativeDecoratedTrimmedWindow() {
		this.trimPane = new BorderPane();
		setCenter(this.trimPane);
		Util.windowProperty(this).addListener((o, oldV, newV) -> {
			this.w = (Stage) newV;
			updateWindow();
		});
	}

	private void updateWindow() {
		if (this.w != null) {
			this.w.setMaximized(this.maximizable);
			// this.w.setMinizable();
			this.w.setResizable(this.resizable);
			this.w.setTitle(this.title);
		}
	}

	/**
	 * Property to put the content to
	 * 
	 * @return the property
	 */
	protected ObjectProperty<Node> contentProperty() {
		return this.trimPane.centerProperty();
	}

	/**
	 * Property to put the menubar to
	 * 
	 * @return the property
	 */
	protected ObjectProperty<Node> menuBarProperty() {
		return topProperty();
	}

	/**
	 * Property to put the top trim to
	 * 
	 * @return the property
	 */
	protected ObjectProperty<Node> topTrimProperty() {
		return this.trimPane.topProperty();
	}

	/**
	 * Property to put the left trim
	 * 
	 * @return the property
	 */
	protected ObjectProperty<Node> leftTrimProperty() {
		return this.trimPane.leftProperty();
	}

	/**
	 * Property to put the right trim
	 * 
	 * @return the property
	 */
	protected ObjectProperty<Node> rightTrimProperty() {
		return this.trimPane.rightProperty();
	}

	/**
	 * Property to put the bottom trim
	 * 
	 * @return the property
	 */
	protected ObjectProperty<Node> bottomTrimProperty() {
		return this.trimPane.bottomProperty();
	}

	@Override
	public final void setMenuBar(Node n) {
		menuBarProperty().set(n);
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void setClientArea(Node node) {
		contentProperty().set(node);
	}

	@Override
	public void setResizeable(boolean resizable) {
		this.resizable = resizable;
		updateWindow();
	}

	@Override
	public void setMinimizable(boolean minimizable) {
		this.minizable = minimizable;
		updateWindow();
	}

	@Override
	public void setMaximizable(boolean maximizable) {
		this.maximizable = maximizable;
		updateWindow();
	}

	@Override
	public final void setTopTrim(Node node) {
		topTrimProperty().set(node);
	}

	@Override
	public final void setLeftTrim(Node node) {
		leftProperty().set(node);
	}

	@Override
	public final void setRightTrim(Node node) {
		rightProperty().set(node);
	}

	@Override
	public final void setBottomTrim(Node node) {
		bottomProperty().set(node);
	}

	@Override
	public void close() {
		this.w.close();
	}
}

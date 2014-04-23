/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation, BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   IBM Corporation - initial API
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.widgets;

import java.awt.Point;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Device.NoOpDrawableGC;
import org.eclipse.swt.graphics.Drawable.DrawableGC;
import org.eclipse.swt.internal.Util;

import javafx.scene.control.TitledPane;

public class Group extends Composite {
	private TitledPane pane;
	private FXLayoutPane layoutPane;
	
	public Group(Composite parent, int style) {
		super(parent, style);
	}
	
	@Override
	protected TitledPane createWidget() {
		pane = new TitledPane();
		pane.setCollapsible(false);
		layoutPane = new FXLayoutPane(this);
		pane.setContent(layoutPane);
		return pane;
	}
	
	@Override
	public Rectangle computeTrim(int x, int y, int width, int height) {
		int w = (int) Math.ceil(pane.prefWidth(javafx.scene.control.Control.USE_COMPUTED_SIZE));
		int h = (int) Math.ceil(pane.prefHeight(javafx.scene.control.Control.USE_COMPUTED_SIZE));
		return super.computeTrim(x, y, w, h);
	}
	
	@Override
	public Rectangle getClientArea() {
		return new Rectangle(0, 0, (int)layoutPane.getWidth(), (int)layoutPane.getHeight());
	}
	
	@Override
	public TitledPane internal_getNativeObject() {
		return pane;
	}
	
	public String getText () {
		checkWidget();
		return notNullString(pane.getText());
	}
	
	@Override
	protected void internal_attachControl(Control c) {
		layoutPane.getChildren().add(c.internal_getNativeObject());
	}
	
	@Override
	protected void internal_detachControl(Control c) {
		layoutPane.getChildren().remove(c.internal_getNativeObject());
	}
	
	@Override
	protected double internal_getHeight() {
		return pane.getHeight();
	}
	
	@Override
	protected double internal_getPrefHeight() {
		return pane.prefHeight(javafx.scene.control.Control.USE_COMPUTED_SIZE);
	}
	
	@Override
	protected double internal_getPrefWidth() {
		return pane.prefWidth(javafx.scene.control.Control.USE_COMPUTED_SIZE);
	}
	
	@Override
	protected double internal_getWidth() {
		return pane.getWidth();
	}
	
	@Override
	protected void internal_setLayout(Layout layout) {
		layoutPane.setLayout(layout);
	}
	
	public void setText (String string) {
		checkWidget ();
		if (string == null) error (SWT.ERROR_NULL_ARGUMENT);
		pane.setText(string);
	}
	
	@Override
	protected void internal_doLayout() {
		pane.layout();
	}
	
	@Override
	public void internal_dispose_GC(DrawableGC gc) {
		
	}
	
}

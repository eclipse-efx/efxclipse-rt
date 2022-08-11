/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation, BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	   IBM Corporation - initial API
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.widgets;

import javafx.scene.Node;

import org.eclipse.swt.graphics.Image;

public abstract class Item extends Widget {
	private Image image;
	private String text = "";
	
	public Item(Widget parent, int style) {
		super(parent, style);
	}
	
	public Item (Widget parent, int style, int index) {
		super(parent,style);
	}

	public Image getImage () {
		checkWidget();
		return image;
	}
	
	public void setImage (Image image) {
		checkWidget();
		this.image = image;
	}
	
	public String getText() {
		checkWidget();
		return this.text;
	}

	public void setText(String string) {
		checkWidget();
		this.text = string;
	}

	protected Object createWidget() {
		//Not needed for items
		return null;
	}
	
	public Object internal_getNativeObject() {
		return null;
	}
}

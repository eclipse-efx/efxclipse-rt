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

import javafx.scene.control.Tab;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;

public class TabItem extends Item {
	private Tab tab;
	private Control control;
	private TabFolder parent;
	
	public TabItem(TabFolder parent, int style) {
		super(parent, style);
		parent.internal_addTabItem(this);
		this.parent = parent;
	}
	
	public TabItem(TabFolder parent, int style, int index) {
		super(parent, style);
		parent.internal_addTabItem(this, index);
		this.parent = parent;
	}

	public TabFolder getParent() {
		return parent;
	}
	
	@Override
	public void setImage(Image image) {
		super.setImage(image);
		
		if( image != null ) {
			tab.setGraphic(new ImageView(image.internal_getImage()));	
		} else {
			tab.setGraphic(null);
		}
	}
	
	@Override
	public void setText(String string) {
		checkWidget();
		if (string == null) error (SWT.ERROR_NULL_ARGUMENT);
		super.setText(string);
		tab.setText(string);
	}

	@Override
	protected Tab createWidget() {
		this.tab = new Tab();
		this.tab.setClosable((style & SWT.CLOSE) == SWT.CLOSE );
		return tab;
	}

	@Override
	public Tab internal_getNativeObject() {
		return tab;
	}
	
	public void setControl(Control control) {
		this.control = control;
		tab.setContent(control.internal_getNativeObject());
	}
	
	public Control getControl() {
		return control;
	}
	
	public String getToolTipText () {
		String rv = null;
		Tooltip t = tab.getTooltip();
		if( t != null ) {
			rv = t.getText();
		}
		return rv;
	}
	
	public void setToolTipText (String string) {
		if( string == null || string.isEmpty() ) {
			tab.setTooltip(null);
		} else {
			Tooltip t = tab.getTooltip();
			if( t == null ) {
				tab.setTooltip(new Tooltip(string));
			} else {
				t.setText(string);
			}
		}
	}
}
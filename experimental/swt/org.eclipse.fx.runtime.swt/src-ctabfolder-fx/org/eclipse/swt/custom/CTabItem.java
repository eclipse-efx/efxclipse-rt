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
package org.eclipse.swt.custom;

import javafx.scene.control.Tab;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.Util;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Item;

public class CTabItem extends Item {
	private Tab tab;
	private Control control;
	private CTabFolder parent;
	
	public CTabItem(CTabFolder parent, int style) {
		super(parent, style);
		parent.internal_addTabItem(this);
		this.parent = parent;
	}

	public CTabItem(CTabFolder parent, int style, int index) {
		super(parent, style, index);
		parent.internal_addTabItem(this, index);
		this.parent = parent;
	}
	
	@Override
	protected Tab createWidget() {
		this.tab = new Tab();
		this.tab.setClosable((getStyle() & SWT.CLOSE) == SWT.CLOSE );
		return tab;
	}

	@Override
	public Tab internal_getNativeObject() {
		return tab;
	}
	
	public Rectangle getBounds () {
		Util.logNotImplemented();
		return new Rectangle(0, 0, 0, 0);
	}
	
	public Control getControl () {
		return control;
	}
	
	public Image getDisabledImage(){
		Util.logNotImplemented();
		return null;
	}
	
	public Font getFont() {
		return parent.getFont();
	}
	
	public CTabFolder getParent () {
		return parent;
	}
	
	public boolean getShowClose() {
		return tab.isClosable();
	}
	
	public String getToolTipText () {
		String rv = null;
		Tooltip t = tab.getTooltip();
		if( t != null ) {
			rv = t.getText();
		}
		return rv;
	}
	
	public boolean isShowing () {
		Util.logNotImplemented();
		return true;
	}
	
	public void setControl (Control control) {
		this.control = control;
		tab.setContent(control.internal_getNativeObject());
	}
	
	public void setDisabledImage (Image image) {
		Util.logNotImplemented();
	}
	
	public void setFont (Font font){
		Util.logNotImplemented();
	}
	
	public void setImage (Image image) {
		super.setImage(image);
		
		if( image != null ) {
			tab.setGraphic(new ImageView(image.internal_getImage()));	
		} else {
			tab.setGraphic(null);
		}
	}
	
	public void setShowClose(boolean close) {
		tab.setClosable(close);
	}
	
	public void setText (String string) {
		super.setText(string);
		tab.setText(string);
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

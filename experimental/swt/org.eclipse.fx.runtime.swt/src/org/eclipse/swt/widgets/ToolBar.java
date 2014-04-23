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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Device.NoOpDrawableGC;
import org.eclipse.swt.graphics.Point;

public class ToolBar extends Composite {
	private javafx.scene.control.ToolBar toolbar;
	private List<ToolItem> items = new ArrayList<ToolItem>();
	
	public ToolBar(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected javafx.scene.control.ToolBar createWidget() {
		toolbar = new javafx.scene.control.ToolBar();
		toolbar.getStyleClass().add("swt-toolbar");
		return toolbar;
	}
	
	boolean internal_mouseAsFilter() {
		return true;
	}
	
	@Override
	public javafx.scene.control.ToolBar internal_getNativeObject() {
		return toolbar;
	}
	
	@Override
	protected void internal_attachControl(Control c) {
	}
	
	@Override
	protected void internal_attachControl(int idx, Control c) {
	}
	
	@Override
	protected void internal_detachControl(Control c) {
	}

	void internal_itemAdded(ToolItem item) {
		items.add(item);
		toolbar.getItems().add(item.internal_getNativeObject());
	}

	void internal_itemAdded(ToolItem item, int index) {
		items.add(item);
		toolbar.getItems().add(index, item.internal_getNativeObject());
	}

	void internal_itemRemoved(ToolItem item) {
		items.remove(item);
		toolbar.getItems().remove(item.internal_getNativeObject());
	}
	
	public ToolItem getItem (int index) {
		return items.get(index);
	}
	
	public ToolItem getItem (Point point) {
		for( ToolItem i : items ) {
			if( i.internal_getNativeObject().getBoundsInParent().contains(point.x, point.y) ) {
				return i;
			}
		}
		return null;
	}
	
	public int getItemCount () {
		return items.size();
	}
	
	public ToolItem [] getItems () {
		return items.toArray(new ToolItem[0]);
	}
	
//	public int getRowCount () {
//		
//	}
	
	public int indexOf (ToolItem item) {
		return items.indexOf(item);
	}
	
	public void pack() {
		forceSizeProcessing();
		setSize((int)internal_getNativeControl().prefWidth(-1), (int)internal_getNativeControl().prefHeight(-1));
	}
	
	@Override
	public void internal_dispose_GC(DrawableGC gc) {
		
	}
	

}

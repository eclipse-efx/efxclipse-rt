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

import java.util.ArrayList;
import java.util.List;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TabPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Device.NoOpDrawableGC;
import org.eclipse.swt.graphics.Drawable.DrawableGC;
import org.eclipse.swt.internal.Util;

public class TabFolder extends Composite {
	private List<TabItem> items = new ArrayList<TabItem>();
	
	private TabPane tabPane;
	
	public TabFolder(Composite parent, int style) {
		super(parent, style);
	}
	
	@Override
	protected TabPane createWidget() {
		tabPane = new TabPane();
		return tabPane;
	}

	@Override
	public TabPane internal_getNativeObject() {
		return tabPane;
	}
	
	@Override
	protected void initListeners() {
		super.initListeners();
		tabPane.getSelectionModel().selectedIndexProperty().addListener(createTabChangeListener());
	}
	
	private InvalidationListener createTabChangeListener() {
		return new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				Event e = new Event();
				e.index = tabPane.getSelectionModel().getSelectedIndex();
				e.item = getItem(tabPane.getSelectionModel().getSelectedIndex());
				internal_sendEvent(SWT.Selection, e, true);
			}
		};
	}
	
	void internal_addTabItem(TabItem item) {
		this.items.add(item);
		tabPane.getTabs().add(item.internal_getNativeObject());
	}
	
	void internal_addTabItem(TabItem item, int index) {
		this.items.add(item);
		tabPane.getTabs().add(index,item.internal_getNativeObject());
	}
	
	@Override
	protected double internal_getHeight() {
		return tabPane.getHeight();
	}
	
	@Override
	protected double internal_getWidth() {
		return tabPane.getWidth();
	}
	
	@Override
	protected Canvas internal_initCanvas() {
		Util.logNotImplemented();
		return null;
	}
	
	@Override
	protected void internal_attachControl(Control c) {
		// Not needed
	}
	
	@Override
	protected void internal_attachControl(int idx, Control c) {
		// Not needed
	}
	
	@Override
	protected void internal_detachControl(Control c) {
		// Not needed
	}
	
	@Override
	protected void internal_setLayout(Layout layout) {
		// Not needed
	}
	
	@Override
	protected double internal_getPrefHeight() {
		return tabPane.prefHeight(javafx.scene.control.Control.USE_COMPUTED_SIZE);
	}
	
	@Override
	protected double internal_getPrefWidth() {
		return tabPane.prefWidth(javafx.scene.control.Control.USE_COMPUTED_SIZE);
	}
	
	public void addSelectionListener(SelectionListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener(listener);
		registerListener(SWT.Selection,typedListener);
		registerListener(SWT.DefaultSelection,typedListener);
	}
	
	public TabItem getItem (int index) {
		checkWidget ();
		if (!(0 <= index && index < items.size())) error (SWT.ERROR_INVALID_RANGE);
		return items.get(index);
	}
	
//	public TabItem getItem (Point point) {
//		checkWidget ();
//		if (point == null) error (SWT.ERROR_NULL_ARGUMENT);
//	}
	
	public int getItemCount () {
		checkWidget ();
		return items.size();
	}
	
	public TabItem [] getItems () {
		checkWidget ();
		return items.toArray(new TabItem[0]);
	}
	
	public TabItem [] getSelection () {
		checkWidget ();
		return new TabItem[]{items.get(getSelectionIndex())};
	}
	
	public int getSelectionIndex () {
		checkWidget ();
		return tabPane.getSelectionModel().getSelectedIndex();
	}
	
	public int indexOf (TabItem item) {
		checkWidget ();
		if (item == null) error (SWT.ERROR_NULL_ARGUMENT);
		return items.indexOf(item);
	}
	
	public void removeSelectionListener (SelectionListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		unregisterListener(SWT.Selection,listener);
		unregisterListener(SWT.DefaultSelection,listener);
	}
	
	public void setSelection (int index) {
		checkWidget ();
		internal_runNoEvent(() -> tabPane.getSelectionModel().select(index));
	}
	
	public void setSelection (TabItem item) {
		checkWidget ();
		if (item == null) error (SWT.ERROR_NULL_ARGUMENT);
		setSelection(indexOf(item));
	}
	
	public void setSelection (TabItem [] items) {
		checkWidget ();
		if (items == null) error (SWT.ERROR_NULL_ARGUMENT);
		for( TabItem i : items ) {
			setSelection(i);	
		}
	}
	
	@Override
	protected void internal_doLayout() {
//		super.internal_doLayout();
	}
	
	@Override
	public void internal_dispose_GC(DrawableGC gc) {
		
	}
	
}

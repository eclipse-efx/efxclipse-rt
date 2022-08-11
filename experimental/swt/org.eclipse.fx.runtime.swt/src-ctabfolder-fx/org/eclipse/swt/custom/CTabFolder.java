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

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.TabPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.internal.Util;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.TypedListener;

public class CTabFolder extends Composite {
	private List<CTabItem> items = new ArrayList<CTabItem>();
	private TabPane tabPane;

	public CTabFolder(Composite parent, int style) {
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
	
	void internal_addTabItem(CTabItem item) {
		this.items.add(item);
		tabPane.getTabs().add(item.internal_getNativeObject());
	}
	
	void internal_addTabItem(CTabItem item, int index) {
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
	
	
	
	public void addCTabFolder2Listener(CTabFolder2Listener listener) {
		Util.logNotImplemented();
	}
	
	public void addCTabFolderListener(CTabFolderListener listener) {
		Util.logNotImplemented();
	}
	
	public void addSelectionListener(SelectionListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener(listener);
		registerListener(SWT.Selection,typedListener);
		registerListener(SWT.DefaultSelection,typedListener);
	}
	
	public boolean getBorderVisible() {
		Util.logNotImplemented();
		return false;
	}
	
	public CTabItem getItem (int index) {
		checkWidget ();
		if (!(0 <= index && index < items.size())) error (SWT.ERROR_INVALID_RANGE);
		return items.get(index);
	}
	
//	public CTabItem getItem (Point pt) {
//		
//	}
	
	public int getItemCount(){
		checkWidget ();
		return items.size();
	}
	
	public CTabItem [] getItems() {
		checkWidget ();
		return items.toArray(new CTabItem[0]);
	}
	
	public boolean getMaximized() {
		Util.logNotImplemented();
		return false;
	}
	
	public boolean getMaximizeVisible() {
		Util.logNotImplemented();
		return false;
	}
	
	public boolean getMinimized() {
		Util.logNotImplemented();
		return false;
	}
	
	public boolean getMinimizeVisible() {
		Util.logNotImplemented();
		return false;
	}
	
	public int getMinimumCharacters() {
		Util.logNotImplemented();
		return 20;
	}
	
	public boolean getMRUVisible() {
		Util.logNotImplemented();
		return false;
	}
	
//	public CTabFolderRenderer getRenderer() {
//		
//	}
	
	public CTabItem getSelection() {
		checkWidget ();
		return getSelectionIndex() != -1 ? items.get(getSelectionIndex()) : null;
	}
	
	public Color getSelectionBackground() {
		Util.logNotImplemented();
		return null;
	}
	
	public Color getSelectionForeground() {
		Util.logNotImplemented();
		return null;
	}
	
	public int getSelectionIndex() {
		checkWidget ();
		return tabPane.getSelectionModel().getSelectedIndex();
	}
	
	public boolean getSimple() {
		Util.logNotImplemented();
		return false;
	}
	
	public boolean getSingle() {
		Util.logNotImplemented();
		return false;
	}
	
	public int getTabHeight(){
		Util.logNotImplemented();
		return -1;
	}
	
	public int getTabPosition(){
		Util.logNotImplemented();
		return -1;
	}
	
	public Control getTopRight() {
		Util.logNotImplemented();
		return null;
	}
	
	public int getTopRightAlignment() {
		Util.logNotImplemented();
		return -1;
	}
	
	public boolean getUnselectedCloseVisible() {
		Util.logNotImplemented();
		return false;
	}
	
	public boolean getUnselectedImageVisible() {
		Util.logNotImplemented();
		return false;
	}
	
	public int indexOf(CTabItem item) {
		checkWidget ();
		if (item == null) error (SWT.ERROR_NULL_ARGUMENT);
		return items.indexOf(item);
	}
	
	public void removeCTabFolder2Listener(CTabFolder2Listener listener) {
		Util.logNotImplemented();
	}
	
	public void removeCTabFolderListener(CTabFolderListener listener) {
		Util.logNotImplemented();
	}
	
	public void removeSelectionListener(SelectionListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		unregisterListener(SWT.Selection,listener);
		unregisterListener(SWT.DefaultSelection,listener);
	}
	
	public void setBackground(Color[] colors, int[] percents) {
		Util.logNotImplemented();
	}
	
	public void setBackground(Color[] colors, int[] percents, boolean vertical) {
		Util.logNotImplemented();
	}
	
	public void setBorderVisible(boolean show) {
		Util.logNotImplemented();
	}
	
	public void setInsertMark(CTabItem item, boolean after) {
		Util.logNotImplemented();
	}
	
	public void setInsertMark(int index, boolean after) {
		Util.logNotImplemented();
	}
	
	public void setLayout (Layout layout) {
		// do nothing
	}
	
	public void setMaximized(boolean maximize) {
		Util.logNotImplemented();
	}
	
	public void setMaximizeVisible(boolean visible) {
		Util.logNotImplemented();
	}
	
	public void setMinimized(boolean minimize) {
		Util.logNotImplemented();	
	}
	
	public void setMinimizeVisible(boolean visible) {
		Util.logNotImplemented();
	}
	
	public void setMinimumCharacters(int count) {
		Util.logNotImplemented();
	}
	
	public void setMRUVisible(boolean show) {
		Util.logNotImplemented();
	}
	
//	public void setRenderer(CTabFolderRenderer renderer) {
//		
//	}
	
	public void setSelection(CTabItem item) {
		checkWidget ();
		if (item == null) error (SWT.ERROR_NULL_ARGUMENT);
		setSelection(indexOf(item));
	}
	
	public void setSelection(int index) {
		checkWidget ();
		internal_runNoEvent(() -> tabPane.getSelectionModel().select(index));
	}
	
	public void setSelectionBackground (Color color) {
		Util.logNotImplemented();	
	}
	
	public void setSelectionBackground(Color[] colors, int[] percents) {
		Util.logNotImplemented();
	}
	
	public void setSelectionBackground(Color[] colors, int[] percents, boolean vertical) {
		Util.logNotImplemented();
	}
	
	public void setSelectionBackground(Image image) {
		Util.logNotImplemented();
	}
	
	public void setSelectionForeground (Color color) {
		Util.logNotImplemented();
	}
	
	public void setSimple(boolean simple) {
		Util.logNotImplemented();
	}
	
	public void setSingle(boolean single) {
		Util.logNotImplemented();
	}
	
	public void setTabHeight(int height) {
		Util.logNotImplemented();
	}
	
	public void setTabPosition(int position) {
		Util.logNotImplemented();
	}
	
	public void setTopRight(Control control) {
		Util.logNotImplemented();
	}
	
	public void setTopRight(Control control, int alignment) {
		Util.logNotImplemented();
	}
	
	public void setUnselectedCloseVisible(boolean visible) {
		Util.logNotImplemented();
	}
	
	public void setUnselectedImageVisible(boolean visible) {
		Util.logNotImplemented();
	}
	
	public void showItem (CTabItem item) {
		Util.logNotImplemented();
	}
	
	public void showSelection () {
		Util.logNotImplemented();
	}

	public CTabFolderRenderer getRenderer() {
		Util.logNotImplemented();
		return null;
	}

	public void setRenderer(CTabFolderRenderer object) {
		Util.logNotImplemented();
	}

	public CTabItem getItem(Point cp) {
		Util.logNotImplemented();
		return null;
	}
}

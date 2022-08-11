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

import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.internal.Util;

import javafx.scene.control.TreeTableColumn;

public class TreeColumn extends Item {
	private TreeTableColumn<TreeItem, ColumnItem> column;
	private Tree parent;
	private int index;
	private String tooltipText;
	
	public TreeColumn (Tree parent, int style) {
		super(parent, style);
		index = parent.getColumnCount();
	}
	
	public TreeColumn (Tree parent, int style, int index) {
		super(parent, style);
		this.index = index;
	}
	
	@Override
	protected TreeTableColumn<TreeItem, ColumnItem> createWidget() {
		column = new TreeTableColumn<>();
		return column;
	}
	
	@Override
	public TreeTableColumn<TreeItem, ColumnItem> internal_getNativeObject() {
		return column;
	}
	
	public void addControlListener(ControlListener listener) {
		Util.logNotImplemented();
	}
	
	public void addSelectionListener (SelectionListener listener) {
		Util.logNotImplemented();
	}
	
//	public int getAlignment () {
//		
//	}
	
	public Tree getParent () {
		return parent;
	}
	
	public boolean getMoveable () {
		Util.logNotImplemented();
		return true;
	}
	
	public boolean getResizable () {
		return column.isResizable();
	}
	
	public String getToolTipText () {
		Util.logNotImplemented();
		return tooltipText;
	}
	
	public int getWidth () {
		return (int) column.getWidth();
	}
	
	public void pack () {
		Util.logNotImplemented();
	}
	
	public void removeControlListener (ControlListener listener) {
		Util.logNotImplemented();
	}
	
	public void removeSelectionListener(SelectionListener listener) {
		Util.logNotImplemented();		
	}
	
//	public void setAlignment (int alignment) {
//		
//	}
//	
//	public void setImage (Image image) {
//		
//	}
//	
	public void setMoveable (boolean moveable) {
		Util.logNotImplemented();
	}
	
	public void setResizable (boolean resizable) {
		column.setResizable(resizable);
	}
//	
//	public void setText (String string) {
//		
//	}
	
	public void setToolTipText (String string) {
		Util.logNotImplemented();
		this.tooltipText = string;
	}
	
	public void setWidth (int width) {
		column.setPrefWidth(width);
	}
	
	static class ColumnItem {
		
	}
}

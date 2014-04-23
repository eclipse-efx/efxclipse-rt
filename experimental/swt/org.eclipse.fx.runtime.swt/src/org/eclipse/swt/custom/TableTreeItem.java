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
package org.eclipse.swt.custom;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.Util;
import org.eclipse.swt.widgets.Item;

public class TableTreeItem extends Item {

	public TableTreeItem(TableTree tree, int style) {
		super(tree, style);
	}

	public TableTreeItem(TableTreeItem parent, int style, int idx) {
		super(parent,style);
	}

	public TableTreeItem(TableTree parent, int style, int idx) {
		super(parent,style);
	}

	public TableTreeItem(TableTreeItem parent, int style) {
		super(parent,style);
	}

	public void setBackground(Color background) {
		Util.logNotImplemented();
	}

	public void setForeground(Color foreground) {
		Util.logNotImplemented();
	}

	public void setFont(Font font) {
		Util.logNotImplemented();
	}

	public Rectangle getBounds(int columnNumber) {
		Util.logNotImplemented();
		return null;
	}

	public void setText(int column, String text) {
		Util.logNotImplemented();
	}

	public Image getImage(int column) {
		Util.logNotImplemented();
		return null;
	}

	public void setImage(int column, Image image) {
		Util.logNotImplemented();
	}

	public Item[] getItems() {
		Util.logNotImplemented();
		return null;
	}

	public Item getItem(int index) {
		Util.logNotImplemented();
		return null;
	}

	public boolean getExpanded() {
		Util.logNotImplemented();
		return false;
	}

	public int getItemCount() {
		Util.logNotImplemented();
		return 0;
	}

	public Item getParentItem() {
		Util.logNotImplemented();
		return null;
	}

	public void setExpanded(boolean expand) {
		Util.logNotImplemented();
	}

}

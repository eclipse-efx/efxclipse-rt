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

import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.internal.Util;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Table;

public class TableTree extends Composite {

	public TableTree(Composite parent, int style) {
		super(parent, style);
	}

	public int getItemHeight() {
		Util.logNotImplemented();
		return 0;
	}

	public TableTreeItem getItem(Point point) {
		Util.logNotImplemented();
		return null;
	}

	public void setSelection(TableTreeItem[] tableTreeItems) {
		Util.logNotImplemented();
	}

	public Table getTable() {
		Util.logNotImplemented();
		return null;
	}

	public Item[] getSelection() {
		Util.logNotImplemented();
		return null;
	}

	public void showSelection() {
		Util.logNotImplemented();
	}

	public void addTreeListener(TreeListener listener) {
		Util.logNotImplemented();
	}

	public TableTreeItem[] getItems() {
		Util.logNotImplemented();
		return null;
	}

	public Item getItem(int index) {
		Util.logNotImplemented();
		return null;
	}

	public int getItemCount() {
		Util.logNotImplemented();
		return 0;
	}

	public void removeAll() {
		Util.logNotImplemented();
	}

	public void showItem(TableTreeItem item) {
		Util.logNotImplemented();
	}

}

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

import javafx.application.Platform;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Table.SWTTableRow;
import org.eclipse.swt.widgets.Tree.SWTTreeRow;
import org.eclipse.swt.widgets.TableItem;

public class TableEditor extends ControlEditor {
	private Table table;
	private TableItem item;
	private int column;
	
	private boolean groupUpdate;
	
	private DisposeListener l = new DisposeListener() {
		@Override
		public void widgetDisposed(DisposeEvent e) {
			if( item != null ) {
				SWTTableRow row = table.internal_getTableRow(item);
				row.hideEditor(column);
			}
		}
	};
	
	public TableEditor(Table parent) {
		super(parent);
		this.table = parent;
	}

	public void setEditor (final Control editor, final TableItem item, final int column) {
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					groupUpdate = true;
					if( TableEditor.this.item != null ) {
						SWTTableRow row = table.internal_getTableRow(TableEditor.this.item);
						row.hideEditor(column);
					}
					
					setItem(item);
					setColumn(column);
					setEditor(editor);
					
					if( TableEditor.this.item != null ) {
						SWTTableRow row = table.internal_getTableRow(TableEditor.this.item);
						row.showEditor(editor,column);
					}
				} finally {
					groupUpdate = false;
				}
			}
		});
		
		
	}
	
	public void setItem (TableItem item) {
		this.item = item;
	}
	
	public void setEditor (Control editor) {
		if( getEditor() != null ) {
			getEditor().removeDisposeListener(l);
		}
		super.setEditor(editor);
		if( editor != null ) {
			editor.addDisposeListener(l);
		}
	}
	
	public TableItem getItem() {
		return item;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
}

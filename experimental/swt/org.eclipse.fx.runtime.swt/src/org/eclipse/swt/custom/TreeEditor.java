package org.eclipse.swt.custom;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Tree.SWTTreeRow;
import org.eclipse.swt.widgets.TreeItem;

public class TreeEditor extends ControlEditor {
	private Tree tree;
	private int column;
	private TreeItem item;
	private boolean groupUpdate;
	
	private DisposeListener l = new DisposeListener() {
		@Override
		public void widgetDisposed(DisposeEvent e) {
			if( item != null ) {
				SWTTreeRow row = tree.internal_getTreeRow(item);
				row.swt_hideEditor(column);
			}
		}
	};

	public TreeEditor (final Tree tree) {
		super(tree);
		this.tree = tree;
		Listener l = new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				if( item != null ) {
					SWTTreeRow row = tree.internal_getTreeRow(item);
					row.swt_hideEditor(column);
				}
			}
		};
		this.tree.addListener(SWT.Expand, l);
		this.tree.addListener(SWT.Collapse, l);
	}
	
	public int getColumn () {
		return column;
	}
	
	public TreeItem getItem () {
		return item;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
	
	public void setItem (TreeItem item) {
		this.item = item;
	}
	
	public void setEditor (Control editor, TreeItem item) {
		setEditor(editor, item, 0);
	}
	
	public void setEditor (Control editor, TreeItem item, int column) {
		try {
			groupUpdate = true;
			if( this.item != null ) {
				System.err.println(this.item.getText());
				SWTTreeRow row = tree.internal_getTreeRow(this.item);
				row.swt_hideEditor(column);
			}
			
			setItem(item);
			setColumn(column);
			setEditor(editor);
			
			if( this.item != null ) {
				SWTTreeRow row = tree.internal_getTreeRow(this.item);
				row.swt_showEditor(editor,column);
			}
		} finally {
			groupUpdate = false;
		}
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
}

package org.eclipse.swt.widgets;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TabPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Device.NoOpDrawableGC;
import org.eclipse.swt.graphics.Drawable.DrawableGC;

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
	}
	
	public void setSelection (TabItem item) {
		checkWidget ();
		if (item == null) error (SWT.ERROR_NULL_ARGUMENT);
	}
	
	public void setSelection (TabItem [] items) {
		checkWidget ();
		if (items == null) error (SWT.ERROR_NULL_ARGUMENT);
	}
	
	@Override
	protected void internal_doLayout() {
//		super.internal_doLayout();
	}
	
	@Override
	public void internal_dispose_GC(DrawableGC gc) {
		
	}
	
	@Override
	public DrawableGC internal_new_GC() {
		return new NoOpDrawableGC(this,getFont());
	}
}

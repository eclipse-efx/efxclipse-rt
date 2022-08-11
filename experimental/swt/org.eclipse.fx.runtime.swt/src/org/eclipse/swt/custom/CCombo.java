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

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.IndexRange;
import javafx.scene.layout.Region;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.internal.Util;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.TypedListener;

public class CCombo extends Composite {
	private ObservableList<String> items;

	public CCombo(Composite parent, int style) {
		super(parent, style);
	}
	
	@Override
	protected Region createWidget() {
		ComboBox<String> control = new ComboBox<>();
		control.setEditable((getStyle() & SWT.READ_ONLY) != SWT.READ_ONLY);
		items = FXCollections.observableArrayList();
		control.setItems(items);
		return control;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ComboBox<String> internal_getNativeObject() {
		return (ComboBox<String>) nativeObject;
	}
	
	@Override
	protected void initListeners() {
		super.initListeners();
		internal_getNativeObject().getSelectionModel().selectedIndexProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				Event evt = new Event();
				internal_sendEvent(SWT.Selection, evt, true); 
			}
		});
	}

	public void add (String string) {
		items.add(string);
	}
	
	public void add (String string, int index) {
		items.add(index, string);
	}
	
	public void addModifyListener (ModifyListener listener) {
		checkWidget();
		if (listener == null) SWT.error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener (listener);
		addListener (SWT.Modify, typedListener);
	}
	
	public void addSelectionListener(SelectionListener listener) {
		checkWidget();
		if (listener == null) SWT.error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener (listener);
		addListener (SWT.Selection,typedListener);
		addListener (SWT.DefaultSelection,typedListener);
	}
	
	public void addVerifyListener (VerifyListener listener) {
		checkWidget();
		if (listener == null) SWT.error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener (listener);
		addListener (SWT.Verify,typedListener);	
	}
	
	public void clearSelection () {
		internal_getNativeObject().getSelectionModel().clearSelection();
	}
	
	public void copy () {
		internal_getNativeObject().getEditor().copy();
	}
	
	public void cut () {
		internal_getNativeObject().getEditor().cut();
	}
	
	public void deselect (int index) {
		internal_getNativeObject().getSelectionModel().clearSelection(index);
	}
	
	public void deselectAll () {
		internal_getNativeObject().getSelectionModel().clearSelection();
	}
	
	public boolean getEditable () {
		return internal_getNativeObject().isEditable();
	}
	
	public String getItem (int index) {
		return items.get(index);
	}
	
	public int getItemCount () {
		return items.size();
	}
	
	public int getItemHeight () {
		Util.logNotImplemented();
		return 0;
	}
	
	public String [] getItems () {
		return items.toArray(new String[0]);
	}
	
	public boolean getListVisible () {
		return internal_getNativeObject().showingProperty().get();
	}
	
	public Point getSelection () {
		if( internal_getNativeObject().getEditor() != null ) {
			IndexRange range = internal_getNativeObject().getEditor().getSelection();
			return new Point(range.getStart(),range.getEnd());
		}
		return new Point(0, 0);
	}
	
	public int getSelectionIndex () {
		return internal_getNativeObject().getSelectionModel().getSelectedIndex();
	}
	
	public String getText () {
		if( internal_getNativeObject().getEditor() != null ) {
			return internal_getNativeObject().getEditor().getText();
		}
		return internal_getNativeObject().getSelectionModel().getSelectedItem();
	}
	
	public int getTextHeight () {
		//TODO Implement
		Util.logNotImplemented();
		return 0;
	}
	
	public int getTextLimit () {
		//TODO Implement
		Util.logNotImplemented();
		return 0;
	}
	
	public int getVisibleItemCount () {
		//TODO Implement
		Util.logNotImplemented();
		return 0;
	}
	
	public int indexOf (String string) {
		return items.indexOf(string);
	}
	
	public int indexOf (String string, int start) {
		return items.subList(start, items.size()-1).indexOf(string);
	}
	
	public void paste () {
		if( internal_getNativeObject().getEditor() != null ) {
			internal_getNativeObject().getEditor().paste();
		}
	}
	
	public void remove (int index) {
		items.remove(index);
	}
	
	public void remove (int start, int end) {
		items.subList(start, end).clear();
	}
	
	public void remove (String string) {
		items.remove(string);
	}
	
	public void removeAll () {
		items.clear();
	}
	
	public void removeModifyListener (ModifyListener listener) {
		checkWidget();
		if (listener == null) SWT.error (SWT.ERROR_NULL_ARGUMENT);
		removeListener(SWT.Modify, listener);			
	}
	
	public void removeSelectionListener (SelectionListener listener) {
		checkWidget();
		if (listener == null) SWT.error (SWT.ERROR_NULL_ARGUMENT);
		removeListener(SWT.Selection, listener);
		removeListener(SWT.DefaultSelection,listener);	
	}
	
	public void removeVerifyListener (VerifyListener listener) {
		checkWidget();
		if (listener == null) SWT.error (SWT.ERROR_NULL_ARGUMENT);
		removeListener(SWT.Verify, listener);
	}
	
	public void select (final int index) {
		internal_runNoEvent(new Runnable() {
			
			@Override
			public void run() {
				internal_getNativeObject().getSelectionModel().select(index);
			}
		});
	}
	
	public void setEditable (boolean editable) {
		internal_getNativeObject().setEditable(editable);
	}
	
	public void setItem (int index, String string) {
		items.add(index, string);
	}
	
	public void setItems (String [] items) {
		this.items.setAll(items);
	}
	
	public void setListVisible (boolean visible) {
		if( visible ) {
			internal_getNativeObject().show();	
		} else {
			internal_getNativeObject().hide();
		}
		
	}
	
	public void setSelection (Point selection) {
		if( internal_getNativeObject().getEditor() != null ) {
			internal_getNativeObject().getEditor().selectRange(selection.x, selection.y);
		}
	}
	
	public void setText (final String string) {
		if( internal_getNativeObject().getEditor() != null ) {
			internal_runNoEvent(new Runnable() {
				
				@Override
				public void run() {
					internal_getNativeObject().getEditor().setText(string);
				}
			});
		}
	}
	
	public void setTextLimit (int limit) {
		//TODO Implement
		Util.logNotImplemented();
	}
	
	public void setVisibleItemCount (int count) {
		//TODO Implement
		Util.logNotImplemented();
	}
}

package org.eclipse.swt.widgets;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.IndexRange;
import javafx.scene.input.KeyEvent;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SegmentListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.internal.Util;

public class Combo extends Composite {
	private ComboBox<String> control;
	private ObservableList<String> items;
	private static EventHandler<KeyEvent> DEFAULT_SELECTION_HANDLER;
	
	public Combo(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected ComboBox<String> createWidget() {
		control = new ComboBox<String>();
		control.setEditable((style & SWT.READ_ONLY) != SWT.READ_ONLY);
		items = FXCollections.observableArrayList();
		control.setItems(items);
		return control;
	}
	
	@Override
	protected void initListeners() {
		super.initListeners();
		control.getSelectionModel().selectedIndexProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				Event evt = new Event();
				internal_sendEvent(SWT.Selection, evt, true); 
			}
		});
		if( control.isEditable() ) {
			registerConnection(control.getEditor());
			control.getEditor().addEventHandler(KeyEvent.KEY_TYPED, getDefaultSelecionHandler());
		}
	}
	
	private static EventHandler<KeyEvent> getDefaultSelecionHandler() {
		if(DEFAULT_SELECTION_HANDLER==null){
			DEFAULT_SELECTION_HANDLER = new EventHandler<KeyEvent>() {
				
				@Override
				public void handle(KeyEvent event) {
					if(event.getCharacter().contains("\r") || event.getCharacter().contains("\n")) {
						Event evt = new Event();
						Widget.getWidget(event.getSource()).internal_sendEvent(SWT.DefaultSelection, evt, true);
					}
				}
			};
		}
		return DEFAULT_SELECTION_HANDLER;
	}
	
	@Override
	protected void internal_attachControl(Control c) {
		throw new UnsupportedOperationException("Combo does not support children");
	}
	
	protected void internal_attachControl(int idx, Control c) {
		throw new UnsupportedOperationException("Combo does not support children");
	}
	
	@Override
	protected void internal_detachControl(Control c) {
		throw new UnsupportedOperationException("Combo does not support children");
	}
	
	@Override
	public ComboBox<String> internal_getNativeObject() {
		return control;
	}
	
	@Override
	protected double internal_getHeight() {
		return control.getHeight();
	}
	
	@Override
	protected double internal_getPrefHeight() {
		return control.prefHeight(javafx.scene.control.Control.USE_COMPUTED_SIZE);
	}
	
	@Override
	protected double internal_getPrefWidth() {
		return control.prefWidth(javafx.scene.control.Control.USE_COMPUTED_SIZE);
	}
	
	@Override
	protected double internal_getWidth() {
		return control.getWidth();
	}
	
	@Override
	protected void internal_setLayout(Layout layout) {
		// No children supported
	}
	
	public void add (String string) {
		items.add(string);
	}
	
	public void add (String string, int index) {
		items.add(index, string);
	}
	
	public void addSegmentListener(SegmentListener segmentListener) {
		Util.logNotImplemented();
	}
	
	public void addModifyListener (ModifyListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener (listener);
		addListener (SWT.Modify, typedListener);
	}
	
	public void addSelectionListener(SelectionListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener (listener);
		addListener (SWT.Selection,typedListener);
		addListener (SWT.DefaultSelection,typedListener);
	}
	
	public void addVerifyListener (VerifyListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener (listener);
		addListener (SWT.Verify, typedListener);
	}
	
	public void clearSelection () {
		checkWidget ();
		control.getSelectionModel().clearSelection();
	}
	
	public void copy () {
		//TODO Not implemented
		Util.logNotImplemented();
	}
	
	public void cut () {
		//TODO Not implemented
		Util.logNotImplemented();
	}
	
	public void deselect (int index) {
		checkWidget();
		control.getSelectionModel().clearSelection(index);
	}
	
	public void deselectAll () {
		control.getSelectionModel().clearSelection();
	}
	
	public Point getCaretLocation () {
		//TODO Not implemented
		Util.logNotImplemented();
		return null;
	}
	
	public int getCaretPosition () {
		//TODO Not implemented
		Util.logNotImplemented();
		return 0;
	}
	
	public String getItem (int index) {
		checkWidget();
		return items.get(index);
	}
	
	public int getItemCount () {
		return items.size();
	}
	
	public int getItemHeight () {
		//TODO Not implemented
		Util.logNotImplemented();
		return 0;
	}
	
	public String [] getItems () {
		return items.toArray(new String[0]);
	}
	
	public boolean getListVisible () {
		checkWidget();
		return control.isShowing();
	}
	
	public Point getSelection () {
		if( (style & SWT.READ_ONLY) == SWT.READ_ONLY ) {
			return new Point(0, control.getSelectionModel().getSelectedItem() == null ? 0 : control.getSelectionModel().getSelectedItem().length());
		} else {
			IndexRange range = control.getEditor().getSelection();
			return new Point(range.getStart(),range.getEnd());
		}
	}
	
	public int getSelectionIndex () {
		checkWidget();
		return control.getSelectionModel().getSelectedIndex();
	}
	
	public String getText () {
		checkWidget();
		return Util.notNull(control.getValue());
	}
	
	public int getTextHeight () {
		//TODO Not implemented
		Util.logNotImplemented();
		return 0;
	}
	
	public int getTextLimit () {
		//TODO Not implemented
		Util.logNotImplemented();
		return 0;
	}
	
	public int getVisibleItemCount () {
		checkWidget();
		return control.getVisibleRowCount();
	}
	
	public int indexOf (String string) {
		checkWidget();
		return items.indexOf(string);
	}
	
	public int indexOf (String string, int start) {
		checkWidget();
		return items.subList(start, items.size()-1).indexOf(string);
	}
	
	public void paste () {
		checkWidget ();
		//TODO No JavaFX API yet
		throw new UnsupportedOperationException();
	}
	
	public void remove (int index) {
		checkWidget();
		items.remove(index);
	}
	
	public void remove (int start, int end) {
		checkWidget();
		items.remove(start, end);
	}
	
	public void remove (String string) {
		checkWidget();
		items.remove(string);
	}
	
	public void removeAll () {
		checkWidget();
		items.clear();
	}
	
	public void removeSegmentListener(SegmentListener segmentListener) {
		Util.logNotImplemented();
	}
	
	public void removeModifyListener (ModifyListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		unregisterListener(SWT.Modify, listener);
	}
	
	public void removeSelectionListener (SelectionListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		unregisterListener(SWT.Selection, listener);
		unregisterListener(SWT.DefaultSelection,listener);	
	}
	
	public void removeVerifyListener (VerifyListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		unregisterListener(SWT.Verify, listener);
	}
	
	public void select (int index) {
		checkWidget ();
		internal_runNoEvent(() -> control.getSelectionModel().select(index));
	}
	
	public void setItem (int index, String string) {
		checkWidget ();
		this.items.set(index, string);
	}
	
	public void setItems (String [] items) {
		checkWidget ();
		this.items.setAll(items);
	}
	
	public void setListVisible (boolean visible) {
		checkWidget ();
		if( visible ) {
			control.show();	
		} else {
			control.hide();
		}
	}
	
	public void setSelection (Point selection) {
		//TODO Not implemented
		Util.logNotImplemented();
	}
	
	public void setText (String string) {
		checkWidget ();
		control.setValue(string);
	}
	
	public void setTextLimit (int limit) {
		//TODO Not implemented
		Util.logNotImplemented();
	}
	
	public void setVisibleItemCount (int count) {
		checkWidget ();
		control.setVisibleRowCount(count);
	}
	
	@Override
	protected void internal_doLayout() {
		
	}
}

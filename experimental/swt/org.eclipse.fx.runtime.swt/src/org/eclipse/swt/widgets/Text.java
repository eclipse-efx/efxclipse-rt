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

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.IndexRange;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyEvent;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SegmentListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Device.NoOpDrawableGC;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.internal.Util;

public class Text extends Scrollable {
	public static final int LIMIT;
	public static final String DELIMITER;
	
	private char echoChar;
	private boolean doubleClick;
	private int tabs  = 8;
	private int textLimit = LIMIT;
	
	private static EventHandler<ActionEvent> DEFAULT_SELECTION_HANDLER;
	private static EventHandler<KeyEvent> LIMIT_VERIFY_HANDLER;
	
	static {
		LIMIT = Integer.MAX_VALUE; //FIXME Check with JavaFX people
		DELIMITER = System.getProperty("line.separator");
	}
	
	private TextInputControl control;
	
	public Text(Composite parent, int style) {
		super(parent,style);
	}
	
	@Override
	protected Node createWidget() {
		if( (style & SWT.MULTI) != 0 || (style & SWT.V_SCROLL) != 0 || (style & SWT.H_SCROLL) != 0 ) {
			control = new TextArea();
			if( (style & SWT.CENTER) == SWT.CENTER ) {
				Util.logNotImplemented();
			} else if( (style & SWT.RIGHT) == SWT.RIGHT ) {
				Util.logNotImplemented();
			}
			
			if( (style & SWT.V_SCROLL) == SWT.V_SCROLL ) {
				Util.logNotImplemented();
			}
			
			if( (style & SWT.H_SCROLL) == SWT.H_SCROLL ) {
				Util.logNotImplemented();
			}
			
			if( (style & SWT.WRAP) == SWT.WRAP ) {
				((TextArea)control).setWrapText(true);
			}
		} else if( (getStyle() & SWT.PASSWORD) != 0 ) {
			control = new PasswordField();
			if( (style & SWT.CENTER) == SWT.CENTER ) {
				((PasswordField)control).setAlignment(Pos.CENTER);
			} else if( (style & SWT.RIGHT) == SWT.RIGHT ) {
				((PasswordField)control).setAlignment(Pos.CENTER_RIGHT);
			}
		} else {
			control = new TextField();
			if( (style & SWT.CENTER) == SWT.CENTER ) {
				((TextField)control).setAlignment(Pos.CENTER);
			} else if( (style & SWT.RIGHT) == SWT.RIGHT ) {
				((TextField)control).setAlignment(Pos.CENTER_RIGHT);
			}
		}
		
		if( (getStyle() & SWT.READ_ONLY) != 0 ) {
			control.setEditable(false);
		}
		return control;
	}
	
	protected void initListeners() {
		control.addEventFilter(KeyEvent.KEY_TYPED, getLimitVerifyHandler());
		control.textProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				enforceLimit();
				if( textLimit == LIMIT || control.getText().length() <= textLimit ) {
					Event evt = new Event();
					internal_sendEvent(SWT.Modify, evt, true);
				}
			}
		});
	}
	
	@Override
	public void addListener(int eventType, Listener listener) {
		super.addListener(eventType, listener);
		if( eventType == SWT.DefaultSelection ) {
			if( control instanceof TextField && ((TextField)control).getOnAction() == null ) {
				//TODO This consumes the event (e.g. when there's a default button it is NOT called)
				((TextField)control).setOnAction(getDefaultSelectionHandler());
			}
		}
	}
	
	private static EventHandler<ActionEvent> getDefaultSelectionHandler() {
		if( DEFAULT_SELECTION_HANDLER == null ) {
			DEFAULT_SELECTION_HANDLER = new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					Widget.getWidget(event.getSource()).internal_sendEvent(SWT.DefaultSelection, new Event(), true);
				}
			};
		}
		return DEFAULT_SELECTION_HANDLER;
	}
	
	private static EventHandler<KeyEvent> getLimitVerifyHandler() {
		if( LIMIT_VERIFY_HANDLER == null ) {
			LIMIT_VERIFY_HANDLER = new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent event) {
					Text t = Widget.getWidget(event.getSource());
					if( LIMIT != t.textLimit ) {
						if( t.getText().length()+1 > t.textLimit ) {
							event.consume();
							return;
						}
					}
					//TODO We need to deal with CTRL+V!!!
					Event evt = new Event();
					evt.text = event.getCharacter();
					t.internal_sendEvent(SWT.Verify, evt, true);
					if( ! evt.doit ) {
						event.consume();
					}
				}
			};
		}
		return LIMIT_VERIFY_HANDLER;
	}
	
	void enforceLimit() {
		if( textLimit != LIMIT ) {
			if( control.getText().length() > textLimit ) {
				control.setText(control.getText().substring(0,textLimit));
			}	
		}
	}

	@Override
	public TextInputControl internal_getNativeObject() {
		return control;
	}
	
	public void addModifyListener (ModifyListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener (listener);
		registerListener (SWT.Modify, typedListener);
	}
	
	public void addSegmentListener (SegmentListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		registerListener (SWT.Segments, new TypedListener (listener));
	}
	
	public void addSelectionListener (SelectionListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener (listener);
		registerListener (SWT.Selection,typedListener);
		registerListener (SWT.DefaultSelection,typedListener);
	}
	
	public void addVerifyListener (VerifyListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener (listener);
		registerListener (SWT.Verify, typedListener);
	}
	
	public void append (String string) {
		checkWidget ();
		if (string == null) error (SWT.ERROR_NULL_ARGUMENT);
		control.appendText(string);
	}
	
	public void clearSelection () {
		checkWidget ();
		control.deselect();
	}

	@Override
	public Point computeSize(int wHint, int hHint, boolean flushCache) {
		checkWidget ();
		forceSizeProcessing();
		int width = (int) internal_getNativeObject().prefWidth(javafx.scene.control.Control.USE_COMPUTED_SIZE);
		int height = (int) internal_getNativeObject().prefHeight(javafx.scene.control.Control.USE_COMPUTED_SIZE);
		
		if (wHint != SWT.DEFAULT) width = wHint;
		if (hHint != SWT.DEFAULT) height = hHint;
				
		return new Point(width, height);
	}
	
	public String getText() {
		checkWidget ();
		return control.getText();
	}
	
	public void copy () {
		checkWidget ();
		control.copy();
	}
	
	public void cut () {
		checkWidget ();
		if ((getStyle() & SWT.READ_ONLY) != 0) return;
		control.cut();
	}
	
	public int getCaretLineNumber () {
		checkWidget ();
		// FIXME Check if 0 or 1 based value
		if( control instanceof TextArea ) {
			return 1;
		} else {
			Util.logNotImplemented();
			return 0;
		}
	}
	
	public Point getCaretLocation () {
		checkWidget ();
		Util.logNotImplemented();
		return new Point(0, 0);
	}
	
	public int getCaretPosition () {
		checkWidget ();
		return control.getCaretPosition();
	}
	
	public int getCharCount () {
		checkWidget ();
		return control.getLength();
	}
	
	public boolean getDoubleClickEnabled () {
		checkWidget ();
		return doubleClick;
	}
	
	public char getEchoChar () {
		checkWidget ();
		return echoChar;
	}
	
	public boolean getEditable () {
		checkWidget ();
		return control.isEditable();
	}
	
	public int getLineCount () {
		checkWidget ();
		if( control instanceof TextField ) {
			return 1;
		} else {
			return ((TextArea)control).getParagraphs().size();
		}
	}
	
	public String getLineDelimiter () {
		checkWidget ();
		return DELIMITER;
	}
	
	public int getLineHeight () {
		checkWidget ();
		Util.logNotImplemented();
		return 0;
	}
	
	public String getMessage () {
		checkWidget ();
		if( control instanceof TextField ) {
			return ((TextField) control).getPromptText();
		} else {
			Util.logNotImplemented();
			return "";
		}
	}
	
	public Point getSelection () {
		checkWidget ();
		IndexRange r = control.getSelection();
		return new Point(r.getStart(),r.getEnd());
	}
	
	public int getSelectionCount () {
		checkWidget ();
		return control.getSelection().getLength();
	}
	
	public String getSelectionText () {
		checkWidget ();
		return control.getSelectedText();
	}
	
	public int getTabs () {
		return tabs;	
	}
	
	public String getText (int start, int end) {
		checkWidget();
		return control.getText(start, end);
	}
	
	public char[] getTextChars () {
		checkWidget();
		return control.getText().toCharArray();
	}
	
	public int getTextLimit () {
		checkWidget();
		return textLimit;
	}
	
	public int getTopIndex () {
		if( control instanceof TextField ) {
			return 0;
		} else {
			Util.logNotImplemented();
			return 0;
		}
	}
	
	public int getTopPixel () {
		if( control instanceof TextField ) {
			return 0;
		} else {
			return (int)((TextArea) control).getScrollTop();
		}
	}
	
	public void insert (String string) {
		checkWidget();
		if (string == null) error (SWT.ERROR_NULL_ARGUMENT);
		control.insertText(control.getCaretPosition(), string);
	}

	public void paste () {
		checkWidget();
		if ((getStyle() & SWT.READ_ONLY) != 0) return;
		control.paste();
	}
	
	public void removeModifyListener (ModifyListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		unregisterListener(SWT.Modify, listener);
	}
	
	public void removeSegmentListener (SegmentListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		unregisterListener (SWT.Segments, listener);
	}
	
	public void removeSelectionListener (SelectionListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		unregisterListener (SWT.Selection, listener);
		unregisterListener (SWT.DefaultSelection,listener);	
	}
	
	public void removeVerifyListener (VerifyListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		unregisterListener (SWT.Verify, listener);	
	}
	
	public void selectAll () {
		control.selectAll();
	}
	
	public void setDoubleClickEnabled (boolean doubleClick) {
		Util.logNotImplemented();
		this.doubleClick = doubleClick;
	}
	
	public void setEchoChar (char echo) {
		Util.logNotImplemented();
		this.echoChar = echo;
	}
	
	public void setEditable (boolean editable) {
		control.setEditable(editable);
	}
	
	public void setMessage (String message) {
		checkWidget();
		if (message == null) error (SWT.ERROR_NULL_ARGUMENT);
		if( control instanceof TextField ) {
			((TextField)control).setPromptText(message);	
		} else {
			Util.logNotImplemented();
		}
	}
	
	public void setSelection (int start) {
		checkWidget();
		control.positionCaret(start);
	}
	
	public void setSelection (int start, int end) {
		checkWidget();
		control.selectRange(start, end);
	}
	
	public void setSelection (Point selection) {
		checkWidget();
		if (selection == null) error (SWT.ERROR_NULL_ARGUMENT);
		setSelection(selection.x, selection.y);
	}
	
	public void setTabs (int tabs) {
		Util.logNotImplemented();
		this.tabs = tabs;
	}
	
	public void setText (String string) {
		control.setText(string);
	}
	
	public void setTextChars (char[] text) {
		setText(String.valueOf(text));
	}
	
	public void setTextLimit (int limit) {
		this.textLimit = limit;
		enforceLimit();
	}
	
	public void setTopIndex (int index) {
		Util.logNotImplemented();		
	}
	
	public void showSelection () {
		Util.logNotImplemented();
	}
		
	@Override
	public void internal_dispose_GC(DrawableGC gc) {
		
	}
	
	@Override
	public DrawableGC internal_new_GC() {
		return new NoOpDrawableGC(this,getFont());
	}
	
	@Override
	protected Font getDefaultFont() {
		if( control.getFont() != null ) {
			return new Font(getDisplay(), control.getFont());	
		}
		return super.getDefaultFont();
	}

}

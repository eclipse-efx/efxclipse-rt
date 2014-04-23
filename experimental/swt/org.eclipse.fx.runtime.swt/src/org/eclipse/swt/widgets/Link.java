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
package org.eclipse.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.internal.Util;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Link extends Control {
	private String text = "";
	private StackPane p;
	private TextFlow flow;
	private Point[] offsets;
	private String[] ids;
	private int[] mnemonics;

	public Link(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void internal_dispose_GC(DrawableGC gc) {
		
	}

	@Override
	public Region internal_getNativeObject() {
		return p;
	}

	@Override
	protected Object createWidget() {
		p = new StackPane();
		flow = new TextFlow();
		p.getChildren().add(flow);
		return p;
	}
	
	public void addSelectionListener (SelectionListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener(listener);
		registerListener(SWT.Selection,typedListener);
		registerListener(SWT.DefaultSelection,typedListener);
	}
	
	public String getText () {
		return text;
	}

	public void removeSelectionListener (SelectionListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		unregisterListener(SWT.Selection,listener);
		unregisterListener(SWT.DefaultSelection,listener);
	}
	
	public void setText (String string) {
		Util.logNotImplemented();
		this.text = string;
		
		flow.getChildren().clear();
		if( string.contains("<a") ) {
			while( string.contains("<a") ) {
				int start = string.indexOf("<a");
				int end = string.indexOf(">");
				int endIdx = string.indexOf("</a>");
				
				if( start > 0 ) {
					flow.getChildren().add(new Text(string.substring(0,start)));		
				}
				
				Text t = new Text(string.substring(end+1, endIdx));
				t.getStyleClass().add("swt-link-part");	
				t.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						Event e = new Event();
						internal_sendEvent(SWT.Selection, e, true);
					}
				});
				flow.getChildren().add(t);
				
				string = string.substring(endIdx+4);
			}
			
			if( string.length() > 0 ) {
				flow.getChildren().add(new Text(string));
			}
		} else {
			flow.getChildren().add(new Text(string));	
		}

	}
	
}

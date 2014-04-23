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

import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.internal.Util;

public class ToolTip extends Widget {
	private Shell parent;
	private Tooltip nativeObject;
	private javafx.scene.control.Label text;
	private javafx.scene.control.Label message;
	private VBox container;
	
	public ToolTip(Shell parent, int style) {
		super(parent.getDisplay(), style);
		this.parent = parent;
	}

	@Override
	protected Object createWidget() {
		nativeObject = new Tooltip();
		nativeObject.setAutoHide(true);
		nativeObject.getScene().getStylesheets().add(getClass().getClassLoader().getResource("org/eclipse/swt/internal/swt.css").toExternalForm());
		container = new VBox();
		container.getStyleClass().add("swt-tooltip");
		nativeObject.setGraphic(container);
		
		int icon = style & (SWT.ICON_ERROR | SWT.ICON_INFORMATION | SWT.ICON_WARNING);
		switch (icon) {
		case SWT.ICON_ERROR:
			container.getStyleClass().add("swt-tooltip-error");
			break;
		case SWT.ICON_INFORMATION:
			container.getStyleClass().add("swt-tooltip-information");
			break;
		case SWT.ICON_WARNING:
			container.getStyleClass().add("swt-tooltip-warning");
			break;
		default:
			break;
		}
		
		if( (style & SWT.BALLOON) == SWT.BALLOON ) {
			container.getStyleClass().add("swt-tooltip-ballon");
		}
		
		return nativeObject;
	}

	@Override
	public Object internal_getNativeObject() {
		return nativeObject;
	}

	public void addSelectionListener (SelectionListener listener) {
		Util.logNotImplemented();
	}
	
	public boolean getAutoHide () {
		return nativeObject.isAutoHide();
	}
	
	public String getMessage () {
		return message != null ? message.getText() : "";
	}
	
	public Shell getParent () {
		return parent;
	}
	
	public String getText () {
		return text != null ? text.getText() : "";
	}
	
	public boolean getVisible () {
		return nativeObject.isShowing();
	}
	
	public boolean isVisible () {
		return getVisible();
	}
	
	public void removeSelectionListener (SelectionListener listener) {
		Util.logNotImplemented();
	}
	
	public void setAutoHide (boolean autoHide) {
		nativeObject.setAutoHide(autoHide);
	}
	
	public void setLocation (int x, int y) {
		nativeObject.setX(x);
		nativeObject.setY(y);
	}
	
	public void setLocation (Point location) {
		setLocation(location.x, location.y);
	}
	
	public void setMessage (String string) {
		this.message = null;
		if( ! string.isEmpty() ) {
			this.message = new Label(string);
			this.message.getStyleClass().add("message-element");
		}
	}
	
	public void setText (String string) {
		this.text = null;
		if( ! string.isEmpty() ) {
			this.text = new Label(string);
			this.text.getStyleClass().add("text-element");
			int icon = style & (SWT.ICON_ERROR | SWT.ICON_INFORMATION | SWT.ICON_WARNING);
			switch (icon) {
			case SWT.ICON_ERROR:
				text.getStyleClass().add("swt-text-error");
				break;
			case SWT.ICON_INFORMATION:
				text.getStyleClass().add("swt-text-information");
				break;
			case SWT.ICON_WARNING:
				text.getStyleClass().add("swt-text-warning");
				break;
			default:
				break;
			}
		}
	}
	
	public void setVisible (boolean visible) {
		if( visible ) {
			container.getChildren().clear();
			
			if( text != null ) {
				container.getChildren().add(text);	
			}
			
			if( message != null ) {
				container.getChildren().add(message);
			}
			
			nativeObject.show(parent.internal_getWindow());
		} else {
			nativeObject.hide();
		}
	}
}

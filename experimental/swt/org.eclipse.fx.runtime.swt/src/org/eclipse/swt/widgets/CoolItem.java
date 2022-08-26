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

import javafx.scene.layout.Region;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

public class CoolItem extends Item {
	private Control control;
	private CoolBar parent;
	boolean ideal;
	
	private int minimumWidth;
	private int minimumHeight;
	int prefWidth;
	int prefHeight;
	int requestedWidth;
	
	static final int MARGIN_WIDTH = 4;
	static final int GRABBER_WIDTH = 2;
	static final int MINIMUM_WIDTH = (2 * MARGIN_WIDTH) + GRABBER_WIDTH;
	
	private Rectangle rect = new Rectangle(0, 0, 0, 0);
	
	public CoolItem(CoolBar coolbar, int style) {
		super(coolbar, style);
		this.parent = coolbar;
		this.parent.internal_registerItem(this);
	}

	public CoolItem(CoolBar coolbar, int style, int index) {
		super(coolbar, style);
		this.parent.internal_registerItem(this, index);
	}
	
	public void addSelectionListener(SelectionListener listener) {
		checkWidget();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener (listener);
		addListener (SWT.Selection,typedListener);
		addListener (SWT.DefaultSelection,typedListener);
	}
	
	public Point computeSize (int wHint, int hHint) {
		int width = wHint, height = hHint;
		if (wHint == SWT.DEFAULT) width = 32;
		if (hHint == SWT.DEFAULT) height = 32;
		if ((parent.style & SWT.VERTICAL) != 0) {
			height += MINIMUM_WIDTH;
		} else {
			width += MINIMUM_WIDTH;
		}	
		return new Point (width, height);
	}
	
	public Rectangle getBounds () {
		return rect;
	}
	
	public Control getControl () {
		return control;
	}
	
	public Point getMinimumSize () {
		return fixPoint(minimumWidth, minimumHeight);
	}
	
	public CoolBar getParent () {
		return parent;
	}
	
	public Point getPreferredSize () {
		return fixPoint(prefWidth, prefHeight);
	}
	
	public Point getSize () {
		return new Point(rect.width, rect.height);
	}
//	
//	public void removeSelectionListener(SelectionListener listener) {
//		checkWidget();
//		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
//		if (eventTable == null) return;
//		eventTable.unhook (SWT.Selection, listener);
//		eventTable.unhook (SWT.DefaultSelection,listener);	
//	}
	
	public void setControl (Control control) {
		this.control = control;
		if( ideal ) {
//			control.internal_getNativeObject().setManaged(true);
//			control.internal_getNativeObject().setVisible(true);
//			Region r = (Region)control.internal_getNativeObject();
//			r.setPrefSize(prefWidth, prefHeight);
		}
		parent.internal_controlUpdated(this);
	}
	
	public void setMinimumSize (int width, int height) {
		Point p = fixPoint(width, height);
		minimumWidth = p.x;
		minimumHeight = p.y;
	}
	
	public void setMinimumSize (Point size) {
		setMinimumSize(size.x,size.y);
	}
	
	public void setPreferredSize (int width, int height) {
		ideal = true;
		Point p = fixPoint(width, height);
		prefWidth = p.x;
		prefHeight = p.y;
		if( control != null ) {
			Region r = (Region)control.internal_getNativeObject();
			r.setPrefSize(prefWidth, prefHeight);
		}
	}
	
	public void setPreferredSize (Point size) {
		setPreferredSize(size.x, size.y);
	}
	
	public void setSize (int width, int height) {
		Point p = fixPoint(width, height);
		width = Math.max(p.x, minimumWidth+MINIMUM_WIDTH);
		height = p.y;
		if(!ideal) {
			prefWidth = width;
			prefHeight = height;
		}
		rect.width = requestedWidth = width;
		rect.height = height;
		
	}
	
	public void setSize (Point size) {
		setSize(size.x, size.y);
	}
	
	private Point fixPoint(int x, int y) {
		if( (parent.style & SWT.VERTICAL) == SWT.VERTICAL ) {
			return new Point(y, x);
		}
		return new Point(x, y);
	}
	
	Rectangle fixRectangle (int x, int y, int width, int height) {
		if ((parent.style & SWT.VERTICAL) != 0) {
			return new Rectangle(y, x, height, width);
		}
		return new Rectangle(x, y, width, height);
	}
}

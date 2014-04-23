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

import javafx.scene.Cursor;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Device.NoOpDrawableGC;

public class Sash extends Control {
	private Region nativeControl;
	
	private final static int INCREMENT = 1;
	private final static int PAGE_INCREMENT = 9;
	
	private int lastX;
	private int lastY;
	private int startX;
	private int startY;
	private boolean inDrag;
	
	public Sash(Composite parent, int style) {
		super(parent, style);
	}

	public void addSelectionListener(SelectionListener listener) {
		checkWidget();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener(listener);
		addListener(SWT.Selection,typedListener);
		addListener(SWT.DefaultSelection,typedListener);
	}
	
	public void removeSelectionListener(SelectionListener listener) {
		checkWidget();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		removeListener(SWT.Selection, listener);
		removeListener(SWT.DefaultSelection,listener);
	}

	@Override
	public void internal_dispose_GC(DrawableGC gc) {
		
	}

	@Override
	public Region internal_getNativeObject() {
		return nativeControl;
	}

	@Override
	protected Object createWidget() {
		nativeControl = new Region();
//		nativeControl.setStyle("-fx-background-color: red;");
//		nativeControl.setFocusTraversable(true);
		nativeControl.setCursor((style & SWT.VERTICAL) == SWT.VERTICAL ? Cursor.H_RESIZE : Cursor.V_RESIZE );
		return nativeControl;
	}

	public Point computeSize (int wHint, int hHint, boolean changed) {
		checkWidget();
		int width = 0, height = 0;
		if ((style & SWT.HORIZONTAL) != 0) {
			width += DEFAULT_WIDTH;  height += 5;
		} else {
			width += 5; height += DEFAULT_HEIGHT;
		}
		if (wHint != SWT.DEFAULT) width = wHint;
		if (hHint != SWT.DEFAULT) height = hHint;
		return new Point (width, height);
	}
	
	@Override
	void sendKeyEvent(KeyEvent event) {
		super.sendKeyEvent(event);
		
		if( event.getEventType() == KeyEvent.KEY_RELEASED ) {
			return;
		}
		
		if( event.getCode().isArrowKey() ) {
			int stepSize = PAGE_INCREMENT;
			if( event.isControlDown()  ) {
				stepSize = INCREMENT;
			}
			
			int xChange = 0;
			int yChange = 0;
			
			switch (event.getCode()) {
			case UP:
				yChange = -stepSize;
				break;
			case DOWN:
				yChange = stepSize;
				break;
			case LEFT:
				xChange = -stepSize;
				break;
			case RIGHT:
				xChange = stepSize;
				break;
			default:
				break;
			}
			
			Rectangle bounds = getBounds ();
			int width = bounds.width;
			int height = bounds.height;
			
			Rectangle parentBounds = getParent().getBounds ();
			int parentWidth = parentBounds.width;
			int parentHeight = parentBounds.height;
			
			int newX = lastX;
			int newY = lastY;
			if( (getStyle() & SWT.VERTICAL) == SWT.VERTICAL ) {
				newX = Math.min (Math.max (0, lastX + xChange), parentWidth - width);
			} else {
				newY = Math.min (Math.max (0, lastY + yChange), parentHeight - height);
			}
			if (newX == lastX && newY == lastY) return;
			
			Event evt = new Event();
			evt.x = newX;
			evt.y = newY;
			evt.width = width;
			evt.height = height;
			internal_sendEvent(SWT.Selection, evt, true);
			if( evt.doit ) {
				setBounds(evt.x, evt.y, evt.width, evt.height);
				int cursorX = evt.x;
				int cursorY = evt.y;
				if ((getStyle() & SWT.VERTICAL) != 0) {
					cursorX += 1;
					cursorY += height / 2;
				} else {
					cursorX += width / 2;
					cursorY += 1;
				}
				getDisplay().setCursorLocation(getParent().toDisplay(cursorX, cursorY));
			}
		}
		
		
	}
	
	@Override
	void sendMouseEvent(int type, MouseEvent event) {
		super.sendMouseEvent(type, event);
		
		if( event.getEventType() == MouseEvent.MOUSE_PRESSED ) {
			startX = (int) event.getX();
			startY = (int) event.getY();
			Event evt = new Event();
			Rectangle b = getBounds(); 
			evt.x = b.x;
			evt.y = b.y;
			evt.width = b.width;
			evt.height = b.height;
			internal_sendEvent(SWT.Selection, evt, true);
			if( evt.doit ) {
				lastX = evt.x;
				lastY = evt.y;
				inDrag = true;
			}
		} else if( event.getEventType() == MouseEvent.MOUSE_DRAGGED ) {
			if( ! inDrag ) {
				return;
			}
			int newX = lastX;
			int newY = lastY;
			Rectangle b = getBounds(); 
			if ((style & SWT.VERTICAL) != 0) {
				newX = Math.min (Math.max (0, (int)(event.getX() + b.x - startX)), (int)(getParent().getBounds().width - b.width));
			} else {
				newY = Math.min (Math.max (0, (int)(event.getY() + b.y - startY)), (int)(getParent().getBounds().height - b.height));
			}
			if (newX == lastX && newY == lastY) return;
			Event evt = new Event ();
			evt.x = newX;
			evt.y = newY;
			evt.width = (int)b.width;
			evt.height = (int)b.height;
			
			internal_sendEvent(SWT.Selection, evt, true);
			if (evt.doit) {
				lastX = evt.x;
				lastY = evt.y;
				setBounds (evt.x, evt.y, (int)b.width, (int)b.height);
			}
		} else if( event.getEventType() == MouseEvent.MOUSE_RELEASED ) {
			inDrag = false;
			Rectangle b = getBounds(); 
			Event evt = new Event();
			evt.x = lastX;
			evt.y = lastY;
			evt.width = b.width;
			evt.height = b.height;
			internal_sendEvent(SWT.Selection, evt, true);
			if( evt.doit ) {
				setBounds(evt.x, evt.y, evt.width, evt.height);
			}
		}
	}
	
	@Override
	public void setLocation(int x, int y) {
		this.lastX = x;
		this.lastY = y;
		super.setLocation(x, y);
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height) {
		this.lastX = x;
		this.lastY = y;
		super.setBounds(x, y, width, height);
	}
}

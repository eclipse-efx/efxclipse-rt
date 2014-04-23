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

import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Rectangle;

public class Tracker extends Widget {
	private Composite parent;
	private Rectangle[] rectangles = new Rectangle[0];
	private Rectangle bounds;
	
	public Tracker(Display display, int style) {
		super(display, style);
	}

	public Tracker(Composite parent, int style) {
		super(parent.getDisplay(), style);
		this.parent = parent;
	}
	
	@Override
	protected Object createWidget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object internal_getNativeObject() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addControlListener (ControlListener listener) {
		
	}
	
	public void addKeyListener(KeyListener listener) {
		
	}
	
	public void close () {
		
	}
	
	public Rectangle [] getRectangles () {
		Rectangle[] result = new Rectangle[rectangles.length];
		for( int i = 0; i < result.length; i++ ) {
			result[i] = new Rectangle(rectangles[i].x, rectangles[i].y, rectangles[i].width, rectangles[i].height);
		}
		return result;
	}
	
//	public boolean getStippled () {
//		
//	}
	
	public boolean open () {
		Stage s = new Stage(StageStyle.TRANSPARENT);
		return false;
	}
	
	public void removeControlListener (ControlListener listener) {
		
	}
	
	public void removeKeyListener(KeyListener listener) {
		
	}
	
	public void setCursor (Cursor newCursor) {
		
	}
	
	public void setRectangles (Rectangle [] rectangles) {
		this.rectangles = new Rectangle[rectangles.length];
		for( int i = 0; i < rectangles.length; i++ ) {
			this.rectangles[i] = new Rectangle(rectangles[i].x, rectangles[i].y, rectangles[i].width, rectangles[i].height);
		}
		
		if( rectangles.length == 0 ) {
			bounds = null;	
		} else {
			int xMin = rectangles[0].x;
			int yMin = rectangles[0].y;
			int xMax = rectangles[0].x + rectangles[0].width;
			int yMax = rectangles[0].y + rectangles[0].height;
			
			for( int i = 1; i < rectangles.length; i++ ) {
				xMin = Math.min(rectangles[i].x, xMin);
				yMin = Math.min(rectangles[i].y, yMin);
				xMax = Math.max(rectangles[i].x+rectangles[i].width, xMax);
				yMax = Math.max(rectangles[i].y+rectangles[i].height, yMax);
			}
			bounds = new Rectangle(xMin, yMin, xMax, yMax);
		}		
	}
	
	public void setStippled (boolean stippled) {
		
	}
}

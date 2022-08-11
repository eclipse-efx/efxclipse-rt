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
package org.eclipse.swt.graphics;

import javafx.scene.shape.Rectangle;

import com.sun.javafx.geom.Arc2D;
import com.sun.javafx.geom.Path2D;
import com.sun.javafx.geom.RectBounds;
import com.sun.javafx.geom.RoundRectangle2D;
import com.sun.javafx.geom.Shape;
import com.sun.javafx.scene.text.TextLayout;
import com.sun.javafx.scene.text.TextLayoutFactory;
import com.sun.javafx.tk.Toolkit;

public class Path extends Resource {
	private Path2D path;
	
	public Path(Device device) {
		super(device);
		path = new Path2D();
	}
	
	public Path2D internal_getNativeObject() {
		return path;
	}
	
	public void addArc(float x, float y, float width, float height, float startAngle, float arcAngle) {
		Arc2D arc2d = new Arc2D(x, y, width, height, startAngle, arcAngle, Arc2D.OPEN);
		path.append(arc2d, false);
	}
	
	public void addPath(Path path) {
		this.path.append(path.internal_getNativeObject().getPathIterator(null), false);
	}
	
	public void addRectangle(float x, float y, float width, float height) {
		RoundRectangle2D rect = new RoundRectangle2D(x, y, width, height, 0, 0);
		path.append((Shape)rect, false);
	}
	
	public void addString(String string, float x, float y, Font font) {
		int type = TextLayout.TYPE_TEXT | TextLayout.TYPE_TOP;
		TextLayoutFactory factory = Toolkit.getToolkit().getTextLayoutFactory();
		TextLayout layout = factory.createLayout();
		layout.setContent(string, font.internal_getNativeObject().impl_getNativeFont());
		path.append(layout.getShape(type, null),false);
	}
	
	public void close() {
		path.closePath();
	}
	
	public boolean contains(float x, float y, GC gc, boolean outline) {
		// FIXME what are gc and outline used for?
		return path.contains(x, y);
	}
//	
//	public void cubicTo(float cx1, float cy1, float cx2, float cy2, float x, float y) {
//		
//	}
	
	public void getBounds(float[] bounds) {
		RectBounds pathBounds = path.getBounds();
		bounds[0] = pathBounds.getMinX();
		bounds[1] = pathBounds.getMinY();
		bounds[2] = pathBounds.getWidth();
		bounds[3] = pathBounds.getHeight();
	}
	
	public void getCurrentPoint(float[] point) {
		point[0] = path.getCurrentX();
		point[1] = path.getCurrentY();
	}

//	public PathData getPathData() {
//		
//	}
//	
	public void lineTo(float x, float y) {
		path.lineTo(x, y);
	}
	
	public void moveTo(float x, float y) {
		path.moveTo(x, y);
	}
	
	public void quadTo(float cx, float cy, float x, float y) {
		path.quadTo(cx, cy, x, y);
	}
	
	@Override
	public void dispose() {
		path = null;
	}

	@Override
	public boolean isDisposed() {
		return path == null;
	}

}

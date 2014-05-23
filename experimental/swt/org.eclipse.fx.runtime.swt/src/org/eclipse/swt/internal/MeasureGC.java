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
package org.eclipse.swt.internal;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Drawable.DrawableGC;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Control;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.Shape;
import com.sun.javafx.scene.text.TextLayout;
import com.sun.javafx.scene.text.TextLayoutFactory;
import com.sun.javafx.tk.Toolkit;

public class MeasureGC implements DrawableGC {
	private Control control;
	private Font font;
	
	public MeasureGC(Control control) {
		this.control = control;
	}
	
	@Override
	public void setBackground(Color color) {
		// Not applicable
	}

	@Override
	public void fillRectangle(int x, int y, int width, int height) {
		// Not applicable
	}

	@Override
	public void drawRectangle(int x, int y, int width, int height) {
		// Not applicable
	}

	@Override
	public void fillOval(int x, int y, int width, int height) {
		// Not applicable
	}

	@Override
	public void setAlpha(int alpha) {
		// Not applicable
	}

	@Override
	public void setTransform(Transform transform) {
		// Not applicable
	}
	
	@Override
	public void getTransform(Transform transform) {
		// Not applicable
	}

	@Override
	public void setForeground(Color color) {
		// Not applicable
	}

	@Override
	public void fillPath(Path path) {
		// Not applicable
	}

	@Override
	public void drawPath(Path path) {
		// Not applicable
	}

	@Override
	public void drawImage(Image image, int srcX, int srcY, int srcWidth,
			int srcHeight, int destX, int destY, int destWidth, int destHeight) {
		// Not applicable
	}

	@Override
	public void setLineWidth(int lineWidth) {
		// Not applicable
	}
	
	@Override
	public int getLineWidth() {
		return 0;
	}

	@Override
	public void drawLine(int x1, int y1, int x2, int y2) {
		// Not applicable
	}

	@Override
	public void drawImage(Image image, int x, int y) {
		// Not applicable
	}

	@Override
	public void drawText(String string, int x, int y, int flags) {
		// Not applicable
	}

	@Override
	public void drawPolyline(int[] pointArray) {
		// Not applicable
	}

	@Override
	public Point textExtent(String string, int flags) {
		//TODO Deal with flags
		TextLayoutFactory factory = Toolkit.getToolkit().getTextLayoutFactory();
		TextLayout layout = factory.createLayout();
		layout.setContent(string, getFont().internal_getNativeObject().impl_getNativeFont());
		BaseBounds b = layout.getBounds();
						
		return new Point((int)b.getWidth(), (int)b.getHeight());
	}

	@Override
	public void setFont(Font font) {
		this.font = font;
	}

	@Override
	public Font getFont() {
		return this.font == null ? control.getFont() : this.font;
	}

	@Override
	public void fillGradientRectangle(int x, int y, int width, int height,
			boolean vertical) {
		// Not applicable
	}

	@Override
	public void setClipping(Region region) {
		// Not applicable
	}

	@Override
	public void fillPolygon(int[] pointArray) {
		// Not applicable
	}

	@Override
	public void drawPolygon(int[] pointArray) {
		// Not applicable
	}

	@Override
	public void drawRoundRectangle(int x, int y, int width, int height,
			int arcWidth, int arcHeight) {
		// Not applicable
	}

	@Override
	public void fillRoundRectangle(int x, int y, int width, int height,
			int arcWidth, int arcHeight) {
		// Not applicable
	}

	@Override
	public void drawPoint(int x, int y) {
		// Not applicable
	}

	@Override
	public void drawFocus(int x, int y, int width, int height) {
		// Not applicable
	}

	@Override
	public Color getBackground() {
		// Not applicable
		return null;
	}

	@Override
	public Color getForeground() {
		// Not applicable
		return null;
	}

	@Override
	public void copyArea(Image image, int x, int y) {
		// Not applicable
	}

	@Override
	public void fillArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		// Not applicable
	}

	@Override
	public Point stringExtent(String string) {
		TextLayoutFactory factory = Toolkit.getToolkit().getTextLayoutFactory();
		TextLayout layout = factory.createLayout();
		layout.setContent(string, getFont().internal_getNativeObject().impl_getNativeFont());
		BaseBounds b = layout.getBounds();
				
		return new Point((int)Math.ceil(b.getWidth()), (int)Math.ceil(b.getHeight()));

	}

	@Override
	public void drawArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		// Not applicable
	}

	@Override
	public void setLineCap(int cap) {
		// Not applicable
	}

	@Override
	public void setLineJoin(int join) {
		// Not applicable
	}

	@Override
	public void drawShape(int x, int y, Shape shape) {
		// Not applicable
	}

	@Override
	public void setLineStyle(int lineStyle) {
		// Not applicable
	}
	
	@Override
	public int getLineStyle() {
		// Not applicable
		return SWT.LINE_SOLID;
	}

	@Override
	public void dispose() {
		// Not applicable
	}

	@Override
	public void setBackgroundPattern(Pattern pattern) {
		// Not applicable
	}

	@Override
	public void setForegroundPattern(Pattern pattern) {
		// Not applicable
	}

	@Override
	public void drawOval(int x, int y, int width, int height) {
		// Not applicable
	}
	
	@Override
	public int getTextAntialias() {
		return SWT.DEFAULT;
	}
}
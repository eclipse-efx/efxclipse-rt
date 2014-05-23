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
package org.eclipse.swt.graphics;

import com.sun.javafx.geom.Shape;


public interface Drawable {
	public interface DrawableGC {
		public void setBackground(Color color);
		public void fillRectangle(int x, int y, int width, int height);
		public void drawRectangle(int x, int y, int width, int height);
		public void fillOval(int x, int y, int width, int height);
		public void setAlpha(int alpha);
		public void setTransform(Transform transform);
		public void setForeground(Color color);
		public void fillPath(Path path);
		public void drawPath(Path path);
		public void drawImage(Image image, int srcX, int srcY, int srcWidth,
				int srcHeight, int destX, int destY, int destWidth,
				int destHeight);
		public void setLineWidth(int lineWidth);
		public void drawLine(int x1, int y1, int x2, int y2);
		public void drawImage(Image image, int x, int y);
		public void drawText (String string, int x, int y, int flags);
		public void drawPolyline(int[] pointArray);
		public Point textExtent(String string, int flags);
		public void setFont(Font font);
		public Font getFont();
		public void fillGradientRectangle(int x, int y, int width, int height,
				boolean vertical);
		public void setClipping(Region region);
		public void fillPolygon(int[] pointArray);
		public void drawPolygon(int[] pointArray);
		public void drawRoundRectangle(int x, int y, int width, int height,
				int arcWidth, int arcHeight);
		public void fillRoundRectangle(int x, int y, int width, int height,
				int arcWidth, int arcHeight);
		public void drawPoint(int x, int y);
		public void drawFocus(int x, int y, int width, int height);
		public Color getBackground();
		public Color getForeground();
		public void copyArea(Image image, int x, int y);
		public void fillArc(int x, int y, int width, int height,
				int startAngle, int arcAngle);
		public Point stringExtent(String string);
		public void drawArc(int x, int y, int width, int height,
				int startAngle, int arcAngle);
//		public void setClipping(Rectangle rect);
		public void setLineCap(int cap);
		public void setLineJoin(int join);
		public void drawShape(int x, int y, Shape shape);
		public void setLineStyle(int lineStyle);
//		public void setClipping(int x, int y, int width, int height);
		public void dispose();
		public void setBackgroundPattern(Pattern pattern);
		public void setForegroundPattern(Pattern pattern);
		public void drawOval(int x, int y, int width, int height);
		public void getTransform(Transform transform);
		public int getTextAntialias();
		public int getLineWidth();
		public int getLineStyle();
		public Pattern getBackgroundPattern();
		public void setLineDash(int[] dashes);
	}
	
	public DrawableGC internal_new_GC();
	public void internal_dispose_GC(DrawableGC gc);
	public Rectangle getBounds();
}

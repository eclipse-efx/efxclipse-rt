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


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Drawable.DrawableGC;
import org.eclipse.swt.internal.Util;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;

import com.sun.javafx.font.Metrics;
import com.sun.javafx.font.PrismFontLoader;
import com.sun.javafx.font.PrismFontUtils;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.Shape;
import com.sun.javafx.scene.text.TextLayout;
import com.sun.javafx.scene.text.TextLayoutFactory;
import com.sun.javafx.tk.Toolkit;

public class GC extends Resource {
	private Drawable drawable;
	private DrawableGC gc;
	private Region clipping;
	private int style;
	private int antialias;
	private int alpha = 0;
	
	public GC(Drawable drawable) {
		super(getDevice(drawable));
		this.drawable = drawable;
		gc = drawable.internal_new_GC();
	}
	
	public GC(Drawable drawable, int style) {
		this(drawable);
		this.style = style;
	}
	
	private static Device getDevice(Drawable drawable) {
		if( drawable instanceof Device ) {
			return (Device) drawable;
		} else if( drawable instanceof Widget ) {
			return ((Widget) drawable).getDisplay();
		} else if( drawable instanceof Resource ) {
			return ((Resource)drawable).getDevice();
		} else {
			return Display.getCurrent();
		}
	}
	
	public void dispose() {
		drawable.internal_dispose_GC(gc);
	}
	
	@Override
	public boolean isDisposed() {
		// TODO Auto-generated method stub
		return false;
	}

	public void internal_drawShape(int x, int y, Shape shape) {
		gc.drawShape(x,y,shape);
	}
	
	public void copyArea(Image image, int x, int y) {
		gc.copyArea(image,x,y);
	}
//	
//	public void copyArea(int srcX, int srcY, int width, int height, int destX, int destY) {
//		
//	}
//	
//	public void copyArea(int srcX, int srcY, int width, int height, int destX, int destY, boolean paint) {
//		
//	}
//	
	public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
		gc.drawArc(x,y,width,height,startAngle,arcAngle);
	}
	
	public void drawFocus(int x, int y, int width, int height) {
		gc.drawFocus( x,  y,  width,  height);
	}
	
	public void drawImage(Image image, int srcX, int srcY, int srcWidth, int srcHeight, int destX, int destY, int destWidth, int destHeight) {
		gc.drawImage(image,srcX,srcY,srcWidth,srcHeight, destX, destY,destWidth,destHeight);
	}
	
	public void drawImage(Image image, int x, int y) {
		gc.drawImage(image, x, y);
	}
	
	public void drawLine(int x1, int y1, int x2, int y2) {
		gc.drawLine(x1,y1,x2,y2);
	}
	
	public void drawOval(int x, int y, int width, int height) {
		gc.drawOval(x,y,width,height);
	}
	
	public void drawPath(Path path) {
		gc.drawPath(path);
	}
	
	public void drawPoint(int x, int y) {
		gc.drawPoint(x,y);
	}
	
	public void drawPolygon(int[] pointArray) {
		gc.drawPolygon(pointArray);
	}
	
	public void drawPolyline(int[] pointArray) {
		gc.drawPolyline(pointArray);
	}
	
	public void drawRectangle(int x, int y, int width, int height) {
		gc.drawRectangle(x,y,width,height);
	}
	
	public void drawRectangle(Rectangle rect) {
		drawRectangle(rect.x, rect.y, rect.width, rect.height);
	}
	
	public void drawRoundRectangle(int x, int y, int width, int height, int arcWidth, int arcHeight) {
		gc.drawRoundRectangle( x,  y,  width,  height,  arcWidth,  arcHeight);
	}
	
	public void drawString (String string, int x, int y) {
		drawString(string,x,y, false);
	}
	
	public void drawString(String string, int x, int y, boolean isTransparent) {
		drawText(string, x, y, isTransparent ? SWT.DRAW_TRANSPARENT : 0);
	}
	
	public void drawText(String string, int x, int y) {
		drawText(string, x, y, SWT.DRAW_DELIMITER | SWT.DRAW_TAB);
	}
	
	public void drawText(String string, int x, int y, boolean isTransparent) {
		int flags = SWT.DRAW_DELIMITER | SWT.DRAW_TAB;
		if (isTransparent) flags |= SWT.DRAW_TRANSPARENT;
		drawText(string, x, y, flags);
	}
	
	public void drawText (String string, int x, int y, int flags) {
		gc.drawText(string, x, y, flags);
	}
	
	public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
		gc.fillArc(x,y,width,height,startAngle,arcAngle);
	}
	
	public void fillGradientRectangle(int x, int y, int width, int height, boolean vertical) {
		gc.fillGradientRectangle(x,y,width,height,vertical);
	}
	
	public void fillOval(int x, int y, int width, int height) {
		gc.fillOval(x, y, width, height);
	}
	
	public void fillPath(Path path) {
		gc.fillPath(path);
	}
	
	public void fillPolygon(int[] pointArray) {
		gc.fillPolygon(pointArray);
	}
	
	public void fillRectangle(int x, int y, int width, int height) {
		gc.fillRectangle(x, y, width, height);
	}
	
	public void fillRectangle(Rectangle rect) {
		fillRectangle(rect.x, rect.y, rect.width, rect.height);
	}
	
	public void fillRoundRectangle(int x, int y, int width, int height, int arcWidth, int arcHeight) {
		gc.fillRoundRectangle( x,  y,  width,  height,  arcWidth,  arcHeight);
	}
	
	public int getAdvanceWidth(char ch) {
		return stringExtent(new String(new char[]{ch})).x;
	}
	
	public Color getBackground() {
		return gc.getBackground();
	}
	
	public Pattern getBackgroundPattern() {	
		return gc.getBackgroundPattern();
	}
	
	public boolean getAdvanced() {
		return true;
	}
	
	public int getAlpha() {
		return alpha;
	}
	
	public int getAntialias() {
		return antialias;
	}
//	
//	public int getCharWidth(char ch) {
//		
//	}
//	
	public Rectangle getClipping() {
		Rectangle r = drawable.getBounds();
//		if( drawable instanceof Control ) {
//			r = ((Control) drawable).getBounds();
//		} else if( drawable instanceof Image ) {
//			r = ((Image) drawable).getBounds();
//		} else {
//			r = new Rectangle(0, 0, 0, 0);
//		}
		Region reg = new Region();
		reg.add(r);
		if( clipping != null ) {
			reg.intersect(clipping);
		}
		return reg.getBounds();
	}
	
	public void getClipping(Region region) {
		region.subtract(region);
		region.add(drawable.getBounds());
		if( clipping != null ) {
			region.intersect(clipping);
		}
	}
//	
//	public int getFillRule() {
//		
//	}
//	
	public Font getFont() {
		return gc.getFont();
	}
	
	@SuppressWarnings("restriction")
	public FontMetrics getFontMetrics() {
		org.eclipse.swt.graphics.Font f = Display.getCurrent().getSystemFont();
		if( drawable instanceof Control ) {
			f = ((Control) drawable).getFont();
		}
		
		String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  //$NON-NLS-1$
		TextLayoutFactory factory = Toolkit.getToolkit().getTextLayoutFactory();
		TextLayout layout = factory.createLayout();
		layout.setContent(s, f.internal_getNativeObject().impl_getNativeFont());
		BaseBounds bounds = layout.getBounds();
		int averageCharWidth = (int)(Math.ceil(bounds.getWidth()) / s.length());
		
		com.sun.javafx.tk.FontMetrics fontMetrics = PrismFontLoader.getInstance().getFontMetrics(f.internal_getNativeObject());
		
		return new FontMetrics((int)fontMetrics.getAscent(), (int)fontMetrics.getDescent(), averageCharWidth, (int)fontMetrics.getLeading(), (int)fontMetrics.getLineHeight());
	}
	
	public Color getForeground() {	
		return gc.getForeground();
	}
	
//	public Pattern getForegroundPattern() {	
//		
//	}
//	
//	public GCData getGCData() {	
//		
//	}
//	
//	public int getInterpolation() {
//		
//	}
//	
//	public LineAttributes getLineAttributes() {
//		
//	}
//	
//	public int getLineCap() {
//		
//	}
//	
	public int[] getLineDash() {
		return gc.getLineDash();
	}
//	
//	public int getLineJoin() {
//		
//	}
//	
	public int getLineStyle() {
		return gc.getLineStyle();
	}
	
	public int getLineWidth() {
		return gc.getLineWidth();
	}
	
	public int getStyle () {
		return style;
	}
	
	public int getTextAntialias() {
		return gc.getTextAntialias();
	}
	
	public void getTransform (Transform transform) {
		gc.getTransform(transform);
	}
//	
//	public boolean getXORMode() {
//		
//	}
//	
//	public boolean isClipped() {
//		
//	}
//	
//	public boolean isDisposed() {
//		
//	}
//	
	public void setAdvanced(boolean advanced) {
	}
	
	public void setAlpha(int alpha) {
		this.alpha = alpha;
		gc.setAlpha(alpha);
	}
	
	public void setAntialias(int antialias) {
		// Not supported on FX
		this.antialias = antialias;
	}
	
	public void setBackground(Color color) {
		gc.setBackground(color);
	}
	
	public void setBackgroundPattern(Pattern pattern) {
		gc.setBackgroundPattern(pattern);
	}
	
//	public void setClipping(Path path) {
//		
//	}
//	
	public void setClipping(int x, int y, int width, int height) {
		Region r = new Region();
		r.add(x, y, width, height);
		setClipping(r);
	}
	
	public void setClipping(Rectangle rect) {
		if( rect != null ) {
			Region r = new Region();
			r.add(rect);
			setClipping(r);
		} else {
			setClipping((Region)null);
		}
		
	}
	
	public void setClipping(Region region) {
		this.clipping = region;
		gc.setClipping(region);
	}
//	
//	public void setFillRule(int rule) {
//		
//	}
//	
	public void setFont(org.eclipse.swt.graphics.Font font) {
		gc.setFont(font);
	}
	
	public void setForeground(Color color) {	
		gc.setForeground(color);
	}
	
	public void setForegroundPattern(Pattern pattern) {
		gc.setForegroundPattern(pattern);
	}
	
//	public void setInterpolation(int interpolation) {
//		
//	}
//	
//	public void setLineAttributes(LineAttributes attributes) {
//		
//	}
//	
	public void setLineCap(int cap) {
		gc.setLineCap(cap);
	}
	
	public void setLineDash(int[] dashes) {
		gc.setLineDash(dashes);
	}
	
	public void setLineJoin(int join) {
		gc.setLineJoin(join);
	}
	
	public void setLineStyle(int lineStyle) {
		gc.setLineStyle(lineStyle);
	}
	
	public void setLineWidth(int lineWidth) {
		gc.setLineWidth(lineWidth);
	}
	
//	public void setXORMode(boolean xor) {
//		
//	}
//	
	public void setTextAntialias(int antialias) {
		// keep the API method, but JavaFX will always antialias text
	}
	
	public void setTransform(Transform transform) {
		gc.setTransform(transform);
	}
	
	public Point stringExtent(String string) {
		return gc.stringExtent(string);
	}
	
	public Point textExtent(String string) {
		return textExtent(string, SWT.DRAW_DELIMITER | SWT.DRAW_TAB);
	}
	
	public Point textExtent(String string, int flags) {
		return gc.textExtent(string,flags);
	}
	
}

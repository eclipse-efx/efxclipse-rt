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

import java.util.List;

import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;

import org.eclipse.swt.SWT;
import org.eclipse.swt.internal.Util;
import org.eclipse.swt.widgets.Control;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.Shape;
import com.sun.javafx.scene.text.TextLayout;
import com.sun.javafx.scene.text.TextLayoutFactory;
import com.sun.javafx.tk.Toolkit;

public abstract class Device implements Drawable {
	public static boolean DEBUG;
	
	DeviceColor COLOR_BLACK, COLOR_DARK_RED, COLOR_DARK_GREEN, COLOR_DARK_YELLOW, COLOR_DARK_BLUE;
	DeviceColor COLOR_DARK_MAGENTA, COLOR_DARK_CYAN, COLOR_GRAY, COLOR_DARK_GRAY, COLOR_RED;
	DeviceColor COLOR_GREEN, COLOR_YELLOW, COLOR_BLUE, COLOR_MAGENTA, COLOR_CYAN, COLOR_WHITE;

	private Font SYSTEM_FONT;
	private volatile boolean disposed;
	
	public Device() {
		this(null);
	}
	
	public Device(DeviceData data) {
		init();
	}
	
	protected void init() {
		COLOR_BLACK = new DeviceColor (this, 0,0,0);
		COLOR_DARK_RED = new DeviceColor (this, 0x80,0,0);
		COLOR_DARK_GREEN = new DeviceColor (this, 0,0x80,0);
		COLOR_DARK_YELLOW = new DeviceColor (this, 0x80,0x80,0);
		COLOR_DARK_BLUE = new DeviceColor (this, 0,0,0x80);
		COLOR_DARK_MAGENTA = new DeviceColor (this, 0x80,0,0x80);
		COLOR_DARK_CYAN = new DeviceColor (this, 0,0x80,0x80);
		COLOR_GRAY = new DeviceColor (this, 0xC0,0xC0,0xC0);
		COLOR_DARK_GRAY = new DeviceColor (this, 0x80,0x80,0x80);
		COLOR_RED = new DeviceColor (this, 0xFF,0,0);
		COLOR_GREEN = new DeviceColor (this, 0,0xFF,0);
		COLOR_YELLOW = new DeviceColor (this, 0xFF,0xFF,0);
		COLOR_BLUE = new DeviceColor (this, 0,0,0xFF);
		COLOR_MAGENTA = new DeviceColor (this, 0xFF,0,0xFF);
		COLOR_CYAN = new DeviceColor (this, 0,0xFF,0xFF);
		COLOR_WHITE = new DeviceColor (this, 0xFF,0xFF,0xFF);
		
		SYSTEM_FONT = new DeviceFont(this,javafx.scene.text.Font.getDefault());
	}
	
	@Override
	public DrawableGC internal_new_GC() {
		return new NoOpDrawableGC(this, getSystemFont());
	}

	@Override
	public void internal_dispose_GC(DrawableGC gc) {
		// TODO Auto-generated method stub
		
	}
	
	public Font getSystemFont () {
		return SYSTEM_FONT;
	}
	
	public FontData[] getFontList(String name, boolean scalable) {
		if (!scalable) return new FontData[0];
		List<String> fontNames = javafx.scene.text.Font.getFontNames(name);
		FontData[] rv = new FontData[fontNames.size()];
		for( int i = 0; i < rv.length; i++ ) {
			int style = SWT.NORMAL;
			if( fontNames.get(i).toLowerCase().contains("bold") ) {
				style |= SWT.BOLD;
			}
			if( fontNames.get(i).toLowerCase().contains("italic") ) {
				style |= SWT.ITALIC;
			}
			rv[i] = new FontData(fontNames.get(i),0,style);
		}
		return rv;
	}
	
	public void dispose() {
		disposed = true;
	}
	
	public boolean isDisposed() {
		return disposed;
	}

	public static class NoOpDrawableGC implements DrawableGC {
		private Font font;
		private Drawable d;
		
		public NoOpDrawableGC(Drawable d, Font font) {
			this.d = d;
			this.font = font;
		}
		
		@Override
		public void setBackground(Color color) {
			Util.logNotImplemented();
		}
		
		@Override
		public void fillRectangle(int x, int y, int width, int height) {
			Util.logNotImplemented();
		}
		
		@Override
		public void drawRectangle(int x, int y, int width, int height) {
			Util.logNotImplemented();
		}

		@Override
		public void fillOval(int x, int y, int width, int height) {
			Util.logNotImplemented();
		}
		
		@Override
		public void setAlpha(int alpha) {
			Util.logNotImplemented();
		}
		
		@Override
		public void setTransform(Transform transform) {
			Util.logNotImplemented();
		}
		
		@Override
		public void getTransform(Transform transform) {
			Util.logNotImplemented();
		}
		
		@Override
		public void setForeground(Color color) {
			Util.logNotImplemented();
		}
		
		@Override
		public void fillPath(Path path) {
			Util.logNotImplemented();
		}
		
		@Override
		public void drawPath(Path path) {
			Util.logNotImplemented();
		}
		
		@Override
		public void drawImage(Image image, int srcX, int srcY, int srcWidth,
				int srcHeight, int destX, int destY, int destWidth,
				int destHeight) {
			Util.logNotImplemented();
		}
		
		@Override
		public void setLineWidth(int lineWidth) {
			Util.logNotImplemented();
		}
		
		@Override
		public void drawLine(int x1, int y1, int x2, int y2) {
			Util.logNotImplemented();
		}
		
		@Override
		public void drawImage(Image image, int x, int y) {
			Util.logNotImplemented();
		}
		
		@Override
		public void drawText (String string, int x, int y, int flags) {
			Util.logNotImplemented();
		}
		
		@Override
		public void drawPolyline(int[] pointArray) {
			Util.logNotImplemented();
		}
		
		@Override
		public Point textExtent(String string, int flags) {
			TextLayoutFactory factory = Toolkit.getToolkit().getTextLayoutFactory();
			TextLayout layout = factory.createLayout();
			layout.setContent(string, getFont().internal_getNativeObject().impl_getNativeFont());
			BaseBounds b = layout.getBounds();
					
			return new Point((int)b.getWidth(), (int)b.getHeight());
		}
		
		@Override
		public void setFont(org.eclipse.swt.graphics.Font font) {
			this.font = font;
		}
		
		@Override
		public Font getFont() {
			return font;
		}
		
		@Override
		public void fillGradientRectangle(int x, int y, int width, int height,
				boolean vertical) {
			Util.logNotImplemented();
		}
		
		@Override
		public void setClipping(Region region) {
			Util.logNotImplemented();
		}
		
		@Override
		public void fillPolygon(int[] pointArray) {
			Util.logNotImplemented();
		}
		
		@Override
		public void drawPolygon(int[] pointArray) {
			Util.logNotImplemented();
		}
		
		@Override
		public void drawRoundRectangle(int x, int y, int width, int height,
				int arcWidth, int arcHeight) {
			Util.logNotImplemented();
		}
		
		@Override
		public void fillRoundRectangle(int x, int y, int width, int height,
				int arcWidth, int arcHeight) {
			Util.logNotImplemented();
		}
		
		@Override
		public void drawPoint(int x, int y) {
			Util.logNotImplemented();
		}
		
		@Override
		public void drawFocus(int x, int y, int width, int height) {
			Util.logNotImplemented();
		}
		
		@Override
		public Color getBackground() {
			Util.logNotImplemented();
			return null;
		}
		
		@Override
		public Color getForeground() {
			Util.logNotImplemented();
			return null;
		}
		
		@Override
		public void fillArc(int x, int y, int width, int height,
				int startAngle, int arcAngle) {
			Util.logNotImplemented();
		}
		
		@Override
		public void copyArea(Image image, int x, int y) {
			if( d instanceof Control ) {
				javafx.scene.layout.Region nativeObject = ((Control) d).internal_getNativeControl();
				SnapshotParameters p = new SnapshotParameters();
				p.setViewport(new Rectangle2D(x, y, image.getBounds().width, image.getBounds().height));
				nativeObject.snapshot(p, (WritableImage) image.internal_getImage());
			}
		}
		
		@Override
		public void drawArc(int x, int y, int width, int height,
				int startAngle, int arcAngle) {
			Util.logNotImplemented();
		}
		
		@Override
		public Point stringExtent(String string) {
			TextLayoutFactory factory = Toolkit.getToolkit().getTextLayoutFactory();
			TextLayout layout = factory.createLayout();
			layout.setContent(string, getFont().internal_getNativeObject().impl_getNativeFont());
			BaseBounds b = layout.getBounds();
					
			return new Point((int)b.getWidth(), (int)b.getHeight());
		}
				
		@Override
		public void setLineCap(int cap) {
			Util.logNotImplemented();
		}
		
		@Override
		public void setLineJoin(int join) {
			Util.logNotImplemented();
		}

		@Override
		public void drawShape(int x, int y, Shape shape) {
			Util.logNotImplemented();
		}
		
		@Override
		public void setLineStyle(int lineStyle) {
			Util.logNotImplemented();
		}
		
		@Override
		public void setBackgroundPattern(Pattern pattern) {
			Util.logNotImplemented();
		}
		
		@Override
		public void setForegroundPattern(Pattern pattern) {
			Util.logNotImplemented();
		}
		
		@Override
		public void dispose() {
			Util.logNotImplemented();
		}
		
		@Override
		public void drawOval(int x, int y, int width, int height) {
			Util.logNotImplemented();
		}
	}
	
	public Color getSystemColor (int id) {
		switch (id) {
			case SWT.COLOR_BLACK: 				return COLOR_BLACK;
			case SWT.COLOR_DARK_RED: 			return COLOR_DARK_RED;
			case SWT.COLOR_DARK_GREEN:	 		return COLOR_DARK_GREEN;
			case SWT.COLOR_DARK_YELLOW: 		return COLOR_DARK_YELLOW;
			case SWT.COLOR_DARK_BLUE: 			return COLOR_DARK_BLUE;
			case SWT.COLOR_DARK_MAGENTA: 		return COLOR_DARK_MAGENTA;
			case SWT.COLOR_DARK_CYAN: 			return COLOR_DARK_CYAN;
			case SWT.COLOR_GRAY: 				return COLOR_GRAY;
			case SWT.COLOR_DARK_GRAY: 			return COLOR_DARK_GRAY;
			case SWT.COLOR_RED: 				return COLOR_RED;
			case SWT.COLOR_GREEN: 				return COLOR_GREEN;
			case SWT.COLOR_YELLOW: 				return COLOR_YELLOW;
			case SWT.COLOR_BLUE: 				return COLOR_BLUE;
			case SWT.COLOR_MAGENTA: 			return COLOR_MAGENTA;
			case SWT.COLOR_CYAN: 				return COLOR_CYAN;
			case SWT.COLOR_WHITE: 				return COLOR_WHITE;
		}
		return COLOR_BLACK;
	}
	
	static class DeviceColor extends Color {

		public DeviceColor(Device device, int red, int green, int blue) {
			super(device, red, green, blue);
		}
		
		@Override
		public void dispose() {
			// not disposable
		}
	}
	
	static class DeviceFont extends Font {
		public DeviceFont(Device device, javafx.scene.text.Font font) {
			super(device,font);
		}
		
		@Override
		public void dispose() {
			// not disposable
		}
	}
}

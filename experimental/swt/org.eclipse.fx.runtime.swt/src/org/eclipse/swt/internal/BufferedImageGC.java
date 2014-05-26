package org.eclipse.swt.internal;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.RenderingHints;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.VPos;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.LinearGradient;
import javafx.scene.transform.Affine;

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

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.Path2D;
import com.sun.javafx.geom.PathIterator;
import com.sun.javafx.geom.RectBounds;
import com.sun.javafx.geom.Shape;
import com.sun.javafx.scene.text.GlyphList;
import com.sun.javafx.scene.text.TextLayout;
import com.sun.javafx.scene.text.TextLayoutFactory;
import com.sun.javafx.tk.Toolkit;

public class BufferedImageGC implements DrawableGC {
	private BufferedImage bufferedImage;
	private Graphics2D graphics2D;
	
	private final Canvas canvas;
	private final WritableImage image;
	
	private java.awt.Color defaultBackground =java.awt.Color.BLACK;
	private java.awt.Color defaultForeground = java.awt.Color.BLACK;
	
	//TODO Need to pass those values
	private Font receiverFont;
	private Color receiverBackground;
	private Color receiverForeground;
	
	private Font font;
	private Color foregroundColor;
	private Color backgroundColor;
	
	private boolean activeClip;
	private int lineStyle = SWT.LINE_SOLID;
	private Pattern backgroundPattern;
	
	public BufferedImageGC(Canvas canvas, Font receiverFont, Color receiverBackground, Color receiverForeground) {
		this.canvas = canvas;
		this.bufferedImage = new BufferedImage(Math.max(1,(int)canvas.getWidth()), Math.max(1,(int)canvas.getHeight()), BufferedImage.TYPE_INT_ARGB);
		this.graphics2D = bufferedImage.createGraphics();
//		this.graphics2D.setFont(new java.awt.Font("Verdana", java.awt.Font.PLAIN, 14));
		this.graphics2D.setPaint(java.awt.Color.WHITE);
		this.graphics2D.fillRect(0, 0, this.bufferedImage.getWidth(), this.bufferedImage.getHeight());
		this.receiverFont = receiverFont;
		this.receiverForeground = receiverForeground;
		this.receiverBackground = receiverBackground;
		this.image = null;
		setFont(receiverFont);
	}
	
	@Override
	public void setBackground(Color color) {
		this.graphics2D.setPaint(toAWT(color));
	}

	@Override
	public void fillRectangle(int x, int y, int width, int height) {
		this.graphics2D.fillRect(x, y, width, height);
	}

	@Override
	public void drawRectangle(int x, int y, int width, int height) {
		this.graphics2D.drawRect(x, y, width, height);
	}

	@Override
	public void fillOval(int x, int y, int width, int height) {
		this.graphics2D.drawOval(x, y, width, height);
	}

	@Override
	public void setAlpha(int alpha) {
		Util.logNotImplemented();
	}

	@Override
	public void setTransform(Transform transform) {
		Affine a = transform.internal_getNativeObject();
		this.graphics2D.setTransform(new AffineTransform(a.getMxx(), a.getMxy(), a.getTx(), a.getMyx(), a.getMyy(), a.getTy()));
	}

	@Override
	public void setForeground(Color color) {
		this.graphics2D.setColor(toAWT(color));
	}

	private java.awt.Color toAWT(Color color) {
		return new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue());
	}
	
	@Override
	public void fillPath(Path path) {
		path(path.internal_getNativeObject(), true);
	}
	
	private void path(Path2D path, boolean fill) {
		PathIterator pathIterator = path.getPathIterator(null);
		path(pathIterator,fill);
	}
	
	private void path(PathIterator pathIterator, boolean fill) {
		java.awt.geom.Path2D.Float p = new java.awt.geom.Path2D.Float();
		float coords[] = new float[6];
		float x = 0;
		float y = 0;
		boolean flag = false;
		
		while( ! pathIterator.isDone() ) {
			flag = true;
			switch (pathIterator.currentSegment(coords)) {
			case PathIterator.SEG_CLOSE:
				p.lineTo(x, y);
				break;
			case PathIterator.SEG_CUBICTO:
				p.curveTo(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]);
				break;
			case PathIterator.SEG_LINETO:
				p.lineTo(coords[0], coords[1]);
				break;
			case PathIterator.SEG_MOVETO:
				p.moveTo(coords[0], coords[1]);
				x = coords[0];
				y = coords[1];
				break;
			case PathIterator.SEG_QUADTO:
				p.quadTo(coords[0], coords[1], coords[2], coords[3]);
				break;
			default:
				break;
			}
			pathIterator.next();
		}
		if( fill ) {
			this.graphics2D.fill(p);
		} else {
			this.graphics2D.draw(p);
		}
	}

	@Override
	public void drawPath(Path path) {
		path(path.internal_getNativeObject(), false);
	}

	@Override
	public void drawImage(Image image, int srcX, int srcY, int srcWidth,
			int srcHeight, int destX, int destY, int destWidth, int destHeight) {
		this.graphics2D.drawImage(SwingFXUtils.fromFXImage(image.internal_getImage(), null), destX, destY, destX+destWidth, destY+destHeight, srcX, srcY, srcX+srcWidth, srcY+srcHeight, null);
	}

	@Override
	public void setLineWidth(int lineWidth) {
		this.graphics2D.setStroke(new BasicStroke(lineWidth));
	}

	@Override
	public void drawLine(int x1, int y1, int x2, int y2) {
		this.graphics2D.drawLine(x1, y1, x2, y2);
	}

	@Override
	public void drawImage(Image image, int x, int y) {
		this.graphics2D.drawImage(SwingFXUtils.fromFXImage(image.internal_getImage(),null), x, y, null);
	}
	
	@SuppressWarnings("restriction")
	@Override
	public void drawText(String string, int x, int y, int flags) {
		this.graphics2D.setColor(java.awt.Color.BLACK);
//		TextLayoutFactory factory = Toolkit.getToolkit().getTextLayoutFactory();
//		TextLayout layout = factory.createLayout();
//		layout.setContent(string, canvas.getGraphicsContext2D().getFont().impl_getNativeFont());
//		Canvas c = new Canvas(layout.getBounds().getWidth(),layout.getBounds().getHeight());
//		c.getGraphicsContext2D().setFont(canvas.getGraphicsContext2D().getFont());
////		c.getGraphicsContext2D().setFill(javafx.scene.paint.Color.TRANSPARENT);
////		c.getGraphicsContext2D().fillRect(0, 0, c.getWidth(), c.getHeight());
//		c.getGraphicsContext2D().setFill(javafx.scene.paint.Color.BLACK);
//		c.getGraphicsContext2D().setTextBaseline(VPos.TOP);
//		c.getGraphicsContext2D().fillText(string, 0, 0);
//		SnapshotParameters snapshotParameters = new SnapshotParameters();
//		snapshotParameters.setFill(javafx.scene.paint.Color.TRANSPARENT);
//		this.graphics2D.drawImage(SwingFXUtils.fromFXImage(c.snapshot(snapshotParameters, null),null),x,y,null);
		
//		this.graphics2D.setTransform(AffineTransform.getTranslateInstance(x, y));
//		path(layout.getShape(TextLayout.TYPE_TEXT, null).getPathIterator(null),false);
		
//		GlyphList[] runs = layout.getRuns();
		
//		Standard
//		this.graphics2D.drawGlyphVector(g, x, y);
		
//		this.graphics2D.setTransform(new AffineTransform());
		this.graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
        RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
		this.graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_LCD_CONTRAST,100);
		this.graphics2D.drawString(string, x, y+10);
	}

	@Override
	public void drawPolyline(int[] pointArray) {
		int[] x = new int[pointArray.length/2];
		int[] y = new int[pointArray.length/2];
		for( int i = 0; i < pointArray.length/2; i++ ) {
			x[i] = pointArray[i*2];
			y[i] = pointArray[i*2+1];
		}
		this.graphics2D.drawPolyline(x, y, x.length);
	}

	@Override
	public Point textExtent(String string, int flags) {
		TextLayoutFactory factory = Toolkit.getToolkit().getTextLayoutFactory();
		TextLayout layout = factory.createLayout();
		layout.setContent(string, canvas.getGraphicsContext2D().getFont().impl_getNativeFont());
		BaseBounds b = layout.getBounds();
				
		return new Point((int)Math.ceil(b.getWidth()), (int)Math.ceil(b.getHeight()));
	}

	@Override
	public void setFont(Font font) {
		this.font = font;
		if( font == null ) {
			canvas.getGraphicsContext2D().setFont(receiverFont.internal_getNativeObject());
			this.graphics2D.setFont(new java.awt.Font(receiverFont.internal_getNativeObject().getName(), java.awt.Font.PLAIN, (int)receiverFont.internal_getNativeObject().getSize()));
		} else {
			canvas.getGraphicsContext2D().setFont(font.internal_getNativeObject());	
			this.graphics2D.setFont(new java.awt.Font(font.internal_getNativeObject().getName(), java.awt.Font.PLAIN, (int)font.internal_getNativeObject().getSize()));
		}
	}

	@Override
	public Font getFont() {
		return font;
	}

	@Override
	public void fillGradientRectangle(int x, int y, int width, int height,
			boolean vertical) {
		this.graphics2D.setPaint(new LinearGradientPaint(x, y, x+width, y+height, new float[] {0.0f,1.0f}, new java.awt.Color[] { toAWT(getForeground()), toAWT(getBackground()) }, java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE));
		this.graphics2D.fillRect(x, y, width, height);
	}

	@SuppressWarnings("restriction")
	@Override
	public void setClipping(Region region) {
		if( region.internal_getNativeObject().isRectangular() ) {
			RectBounds bounds = region.internal_getNativeObject().getBounds();
			this.graphics2D.setClip((int)bounds.getMinX(), (int)bounds.getMinY(), (int)bounds.getWidth(), (int)bounds.getHeight());
		} else {
			setClipping((PathIterator)(region != null ? region.internal_getNativeObject().getPathIterator(null) : null));	
		}
	}

	private void setClipping(PathIterator pathIterator) {
		java.awt.geom.Path2D.Float p = new java.awt.geom.Path2D.Float();
		float coords[] = new float[6];
		float x = 0;
		float y = 0;
		
		while( ! pathIterator.isDone() ) {
			switch (pathIterator.currentSegment(coords)) {
			case PathIterator.SEG_CLOSE:
				p.lineTo(x, y);
				break;
			case PathIterator.SEG_CUBICTO:
				p.curveTo(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]);
				break;
			case PathIterator.SEG_LINETO:
				p.lineTo(coords[0], coords[1]);
				break;
			case PathIterator.SEG_MOVETO:
				p.moveTo(coords[0], coords[1]);
				x = coords[0];
				y = coords[1];
				break;
			case PathIterator.SEG_QUADTO:
				p.quadTo(coords[0], coords[1], coords[2], coords[3]);
				break;
			default:
				break;
			}
			pathIterator.next();
		}
		this.graphics2D.setClip(p);
	}

	@Override
	public void fillPolygon(int[] pointArray) {
		int[] xPoints = new int[pointArray.length/2];
		int[] yPoints = new int[pointArray.length/2];
		int idx = 0;
		for( int i = 0; i < pointArray.length; i++ ) {
			if( i % 2 == 0 ) {
				xPoints[idx] = pointArray[i];	
			} else {
				yPoints[idx] = pointArray[i];
				idx++;
			}
		}
		this.graphics2D.fillPolygon(xPoints, yPoints, xPoints.length);
	}

	@Override
	public void drawPolygon(int[] pointArray) {
		int[] xPoints = new int[pointArray.length/2];
		int[] yPoints = new int[pointArray.length/2];
		int idx = 0;
		for( int i = 0; i < pointArray.length; i++ ) {
			if( i % 2 == 0 ) {
				xPoints[idx] = pointArray[i];	
			} else {
				yPoints[idx] = pointArray[i];
				idx++;
			}
		}
		this.graphics2D.drawPolygon(xPoints, yPoints, xPoints.length);
	}

	@Override
	public void drawRoundRectangle(int x, int y, int width, int height,
			int arcWidth, int arcHeight) {
		this.graphics2D.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
	}

	@Override
	public void fillRoundRectangle(int x, int y, int width, int height,
			int arcWidth, int arcHeight) {
		this.graphics2D.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
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
		return backgroundColor == null ? receiverBackground : backgroundColor;
	}

	@Override
	public Color getForeground() {
		return foregroundColor == null ? receiverForeground : foregroundColor;
	}

	@Override
	public void copyArea(Image image, int x, int y) {
		Util.logNotImplemented();
	}

	@Override
	public void fillArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		this.graphics2D.fillArc(x, y, width, height, startAngle, arcAngle);
	}

	@Override
	public Point stringExtent(String string) {
		TextLayoutFactory factory = Toolkit.getToolkit().getTextLayoutFactory();
		TextLayout layout = factory.createLayout();
		layout.setContent(string, canvas.getGraphicsContext2D().getFont().impl_getNativeFont());
		BaseBounds b = layout.getBounds();
				
		return new Point((int)Math.ceil(b.getWidth()), (int)Math.ceil(b.getHeight()));
	}

	@Override
	public void drawArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		this.graphics2D.drawArc(x, y, width, height, startAngle, arcAngle);
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
		// TODO Auto-generated method stub
		Util.logNotImplemented();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		canvas.getGraphicsContext2D().drawImage(SwingFXUtils.toFXImage(bufferedImage, null),0,0);
	}

	@Override
	public void setBackgroundPattern(Pattern pattern) {
		this.backgroundPattern = pattern;
		if( pattern == null ) {
			this.graphics2D.setPaint(null);
		} else {
			if( pattern.internal_getImage() != null ) {
//				this.graphics2D.setPaint(new ImagePattern(pattern.internal_getImage()));	
			} else {
//				this.graphics2D.setPaint(new LinearGradientPaint(pattern.internal_getX1(), pattern.internal_getY1(), pattern.internal_getX2(), pattern.internal_getY2(), false, CycleMethod.NO_CYCLE));
			}				
		}
	}

	@Override
	public void setForegroundPattern(Pattern pattern) {
		// TODO Auto-generated method stub
		Util.logNotImplemented();
	}

	@Override
	public void drawOval(int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		this.graphics2D.drawOval(x, y, width, height);
	}

	@Override
	public void getTransform(Transform transform) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTextAntialias() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLineWidth() {
		return 1;
	}

	@Override
	public int getLineStyle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pattern getBackgroundPattern() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLineDash(int[] dashes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] getLineDash() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

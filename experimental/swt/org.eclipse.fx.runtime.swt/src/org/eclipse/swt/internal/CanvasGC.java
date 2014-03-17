package org.eclipse.swt.internal;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Translate;

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
import org.eclipse.swt.widgets.Display;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.Path2D;
import com.sun.javafx.geom.PathIterator;
import com.sun.javafx.geom.Shape;
import com.sun.javafx.scene.text.TextLayout;
import com.sun.javafx.scene.text.TextLayoutFactory;
import com.sun.javafx.tk.Toolkit;

@SuppressWarnings("restriction")
public class CanvasGC implements DrawableGC {
	private final Canvas canvas;
	private final WritableImage image;
	
	private javafx.scene.paint.Color defaultBackground = javafx.scene.paint.Color.BLACK;
	private javafx.scene.paint.Color defaultForeground = javafx.scene.paint.Color.BLACK;
	private Affine defaultTransform = new Affine();
	
	//TODO Need to pass those values
	private Font receiverFont;
	private Color receiverBackground;
	private Color receiverForeground;
	
	private Font font;
	private Color foregroundColor;
	private Color backgroundColor;
	
	private boolean activeClip;
	
	public CanvasGC(Canvas canvas, Font receiverFont, Color receiverBackground, Color receiverForeground) {
		this.canvas = canvas;
		this.receiverFont = receiverFont;
		this.receiverForeground = receiverForeground;
		this.receiverBackground = receiverBackground;
		this.image = null;
		reset();
		setFont(receiverFont);
	}
	
	
	private void reset() {
		GraphicsContext gc = this.canvas.getGraphicsContext2D();
		gc.restore();
		gc.save();
	}
	
	public CanvasGC(WritableImage image) {
		this.canvas = new Canvas(image.getWidth(), image.getHeight());
		this.receiverFont = Display.getCurrent().getSystemFont();
		this.receiverForeground = Display.getCurrent().getSystemColor(SWT.COLOR_BLACK);
		this.receiverBackground = Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);
		this.image = image;
	}
	
	private void snapshot() {
		if( image != null ) {
			canvas.snapshot(null, image);
		}
	}
	
	@Override
	public void setBackground(Color color) {
		this.backgroundColor = color;
		canvas.getGraphicsContext2D().setFill(color != null ? color.internal_getNativeObject() : defaultBackground);
	}
	
	@Override
	public void fillRectangle(int x, int y, int width, int height) {
		canvas.getGraphicsContext2D().fillRect(x, y, width, height);
		snapshot();
	}
	
	@Override
	public void drawRectangle(int x, int y, int width, int height) {
		canvas.getGraphicsContext2D().strokeRect(x, y, width, height);
		snapshot();
	}
	
	@Override
	public void fillOval(int x, int y, int width, int height) {
		canvas.getGraphicsContext2D().fillOval(x, y, width, height);
		snapshot();
	}
	
	@Override
	public void setAlpha(int alpha) {
		canvas.getGraphicsContext2D().setGlobalAlpha(alpha / 255.0);
	}
	
	@Override
	public void setTransform(Transform transform) {
		canvas.getGraphicsContext2D().setTransform(transform.internal_getNativeObject());
	}
	
	@Override
	public void setForeground(Color color) {
		this.foregroundColor = color;
		canvas.getGraphicsContext2D().setStroke(color != null ? color.internal_getNativeObject() : defaultForeground );
	}
	
	@Override
	public void drawPath(Path path) {
		path(path.internal_getNativeObject(), false);
		snapshot();
	}
	
	public void fillPath(Path path) {
		path(path.internal_getNativeObject(), true);
		snapshot();
	}
	
	private void path(Path2D path, boolean fill) {
		PathIterator pathIterator = path.getPathIterator(null);
		path(pathIterator,fill);
	}
	
	private void path(PathIterator pathIterator, boolean fill) {
		float coords[] = new float[6];
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.beginPath();
		
		float x = 0;
		float y = 0;
		boolean flag = false;
		
		while( ! pathIterator.isDone() ) {
			flag = true;
			switch (pathIterator.currentSegment(coords)) {
			case PathIterator.SEG_CLOSE:
				gc.lineTo(x, y);
				break;
			case PathIterator.SEG_CUBICTO:
				gc.bezierCurveTo(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]);
				break;
			case PathIterator.SEG_LINETO:
				gc.lineTo(coords[0], coords[1]);
				break;
			case PathIterator.SEG_MOVETO:
				gc.moveTo(coords[0], coords[1]);
				x = coords[0];
				y = coords[1];
				break;
			case PathIterator.SEG_QUADTO:
				gc.quadraticCurveTo(coords[0], coords[1], coords[2], coords[3]);
				break;
			default:
				break;
			}
			pathIterator.next();
		}
		
		if( fill ) {
			gc.fill();
		} else {
			gc.stroke();
		}
		if( flag ) {
			gc.closePath();
		}
	}
	
	@Override
	public void drawImage(Image image, int srcX, int srcY, int srcWidth,
			int srcHeight, int destX, int destY, int destWidth, int destHeight) {
		canvas.getGraphicsContext2D().drawImage(image.internal_getImage(), srcX, srcY, srcWidth, srcHeight, destX, destY, destWidth, destHeight);
		snapshot();
	}
	
	@Override
	public void setLineWidth(int lineWidth) {
		canvas.getGraphicsContext2D().setLineWidth(lineWidth);
	}
	
	@Override
	public void drawLine(int x1, int y1, int x2, int y2) {
		canvas.getGraphicsContext2D().strokeLine(x1, y1, x2, y2);
		snapshot();
	}
	
	@Override
	public void drawImage(Image image, int x, int y) {
		canvas.getGraphicsContext2D().drawImage(image.internal_getImage(), x, y);
		snapshot();
	}
	
	@Override
	public void drawText (String string, int x, int y, int flags) {
		//TODO Deal with flags
		if( (flags & SWT.DRAW_TRANSPARENT) != SWT.DRAW_TRANSPARENT ) {
			TextLayoutFactory factory = Toolkit.getToolkit().getTextLayoutFactory();
			TextLayout layout = factory.createLayout();
			layout.setContent(string, canvas.getGraphicsContext2D().getFont().impl_getNativeFont());	
			
			BaseBounds b = layout.getBounds();
			canvas.getGraphicsContext2D().setFill(getBackground().internal_getNativeObject());
			canvas.getGraphicsContext2D().fillRect(x, y, b.getWidth(), b.getHeight());
		}
		canvas.getGraphicsContext2D().setFill(canvas.getGraphicsContext2D().getStroke());
		canvas.getGraphicsContext2D().setTextBaseline(VPos.TOP);
		canvas.getGraphicsContext2D().fillText(string, x, y);
		snapshot();
	}
	
	@Override
	public void drawPolyline(int[] pointArray) {
		double[] x = new double[pointArray.length/2];
		double[] y = new double[pointArray.length/2];
		for( int i = 0; i < pointArray.length/2; i++ ) {
			x[i] = pointArray[i*2];
			y[i] = pointArray[i*2+1];
		}
		canvas.getGraphicsContext2D().strokePolyline(x, y, x.length);
	}
	
	@Override
	public Point textExtent(String string, int flags) {
		//TODO Deal with flags
		TextLayoutFactory factory = Toolkit.getToolkit().getTextLayoutFactory();
		TextLayout layout = factory.createLayout();
		layout.setContent(string, getFont().internal_getNativeObject().impl_getNativeFont());
		BaseBounds b = layout.getBounds();
				
		return new Point((int)Math.ceil(b.getWidth()), (int)Math.ceil(b.getHeight()));
	}
	
	@Override
	public void setFont(Font font) {
		this.font = font;
		if( font == null ) {
			canvas.getGraphicsContext2D().setFont(receiverFont.internal_getNativeObject());
		} else {
			canvas.getGraphicsContext2D().setFont(font.internal_getNativeObject());	
		}
	}
	
	@Override
	public Font getFont() {
		return font;
	}
	
	@Override
	public void fillGradientRectangle(int x, int y, int width, int height,
			boolean vertical) {
		if( vertical ) {
			canvas.getGraphicsContext2D().setFill(new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop(0, getForeground().internal_getNativeObject()), new Stop(1, getBackground().internal_getNativeObject())));	
		} else {
			canvas.getGraphicsContext2D().setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, new Stop(0, getForeground().internal_getNativeObject()), new Stop(1, getBackground().internal_getNativeObject())));
		}
		
		canvas.getGraphicsContext2D().fillRect(x, y, width, height);
	}
	
	public Color getBackground() {
		return backgroundColor == null ? receiverBackground : backgroundColor;
	}
	
	public Color getForeground() {
		return foregroundColor == null ? receiverForeground : foregroundColor;
	}
	
	@Override
	public void fillPolygon(int[] pointArray) {
		double[] xPoints = new double[pointArray.length/2];
		double[] yPoints = new double[pointArray.length/2];
		int idx = 0;
		for( int i = 0; i < pointArray.length; i++ ) {
			if( i % 2 == 0 ) {
				xPoints[idx] = pointArray[i];	
			} else {
				yPoints[idx] = pointArray[i];
				idx++;
			}
		}

		canvas.getGraphicsContext2D().fillPolygon(xPoints, yPoints, pointArray.length/2);
		snapshot();
	}
	
	@Override
	public void drawPolygon(int[] pointArray) {
		double[] xPoints = new double[pointArray.length/2];
		double[] yPoints = new double[pointArray.length/2];
		int idx = 0;
		for( int i = 0; i < pointArray.length; i++ ) {
			if( i % 2 == 0 ) {
				xPoints[idx] = pointArray[i];	
			} else {
				yPoints[idx] = pointArray[i];
				idx++;
			}
		}
		canvas.getGraphicsContext2D().strokePolygon(xPoints, yPoints, pointArray.length/2);
		snapshot();
	}
	
	@Override
	public void drawRoundRectangle(int x, int y, int width, int height,
			int arcWidth, int arcHeight) {
		canvas.getGraphicsContext2D().strokeRoundRect(x, y, width, height, arcWidth, arcHeight);
		snapshot();
	}
	
	@Override
	public void fillRoundRectangle(int x, int y, int width, int height,
			int arcWidth, int arcHeight) {
		canvas.getGraphicsContext2D().fillRoundRect(x, y, width, height, arcWidth, arcHeight);
		snapshot();
	}
	
	@Override
	public void drawPoint(int x, int y) {
		//TODO 
		Util.logNotImplemented();
	}
	
	@Override
	public void drawFocus(int x, int y, int width, int height) {
		//TODO 
		Util.logNotImplemented();		
	}
	
	@Override
	public void copyArea(Image image, int x, int y) {
		//TODO 
		Util.logNotImplemented();
	}
	
	@Override
	public void fillArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		canvas.getGraphicsContext2D().fillArc(x, y, width, height, startAngle, arcAngle, ArcType.CHORD); 
		snapshot();
	}
	
	@Override
	public void drawArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		canvas.getGraphicsContext2D().strokeArc(x, y, width, height, startAngle, arcAngle, ArcType.CHORD);
	}
	
	@Override
	public Point stringExtent(String string) {
		TextLayoutFactory factory = Toolkit.getToolkit().getTextLayoutFactory();
		TextLayout layout = factory.createLayout();
		layout.setContent(string, getFont().internal_getNativeObject().impl_getNativeFont());
		BaseBounds b = layout.getBounds();
				
		return new Point((int)Math.ceil(b.getWidth()), (int)Math.ceil(b.getHeight()));
	}
	
//	@Override
//	public void setClipping(Rectangle rect) {
//		if( rect != null ) {
//			setClipping(rect.x,rect.y,rect.width,rect.height);	
//		} else {
//			resetClip();
//		}
//	}
//	
//	@Override
//	public void setClipping(int x, int y, int width, int height) {
//		resetClip();
//		
//		GraphicsContext gc = canvas.getGraphicsContext2D();
//		gc.save();
//		
//		gc.beginPath();
//		gc.moveTo(x, y);
//		gc.lineTo(x+width, y);
//		gc.lineTo(x+width, y+height);
//		gc.lineTo(x, y+height);
//		gc.lineTo(x, y);
//		gc.clip();
//		gc.closePath();
//		activeClip = true;
//	}
	
	@Override
	public void setClipping(Region region) {
		setClipping((PathIterator)(region != null ? region.internal_getNativeObject().getPathIterator(null) : null));
	}
	
	private void setClipping(PathIterator pathIterator) {
		resetClip();
		if( pathIterator == null ) {
			return;
		}
		
		activeClip = true;
		
		float coords[] = new float[6];
		GraphicsContext gc = canvas.getGraphicsContext2D();
//		try {
//			Field field = gc.getClass().getDeclaredField("clipStack");
//			field.setAccessible(true);
//			System.err.println("BEGINNING: " + field.get(gc));
//		} catch (NoSuchFieldException | SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		gc.save();
		gc.beginPath();
		
		float x = 0;
		float y = 0;
		
		
		gc.moveTo(0, 0);
		
		while( ! pathIterator.isDone() ) {
			switch (pathIterator.currentSegment(coords)) {
			case PathIterator.SEG_CLOSE:
				gc.lineTo(x, y);
				break;
			case PathIterator.SEG_CUBICTO:
				gc.bezierCurveTo(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]);
				break;
			case PathIterator.SEG_LINETO:
				gc.lineTo(coords[0], coords[1]);
				break;
			case PathIterator.SEG_MOVETO:
				gc.moveTo(coords[0], coords[1]);
				x = coords[0];
				y = coords[1];
				break;
			case PathIterator.SEG_QUADTO:
				gc.quadraticCurveTo(coords[0], coords[1], coords[2], coords[3]);
				break;
			default:
				break;
			}
			pathIterator.next();
		}
		
		gc.clip();
		gc.closePath();
	}
	
	private void resetClip() {
		if( activeClip ) {
			// Read state of other values
			GraphicsContext gc = canvas.getGraphicsContext2D();
	        double globalAlpha = gc.getGlobalAlpha();
	        BlendMode blendop = gc.getGlobalBlendMode();
	        Affine transform = gc.getTransform();
	        Paint fill = gc.getFill();
	        Paint stroke = gc.getStroke();
	        double linewidth = gc.getLineWidth();
	        StrokeLineCap linecap = gc.getLineCap();
	        StrokeLineJoin linejoin = gc.getLineJoin();
	        double miterlimit = gc.getMiterLimit();
	        javafx.scene.text.Font font = gc.getFont();
	        TextAlignment textalign = gc.getTextAlign();
	        VPos textbaseline = gc.getTextBaseline();
	        FillRule fillRule = gc.getFillRule();
			
	        gc.restore();
//	        try {
//				Field field = gc.getClass().getDeclaredField("clipStack");
//				field.setAccessible(true);
//				System.err.println(field.get(gc));
//			} catch (NoSuchFieldException | SecurityException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalArgumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
	        gc.setGlobalAlpha(globalAlpha);
	        gc.setGlobalBlendMode(blendop);
	        gc.setTransform(transform);
	        gc.setFill(fill);
	        gc.setStroke(stroke);
	        gc.setLineWidth(linewidth);
	        gc.setLineCap(linecap);
	        gc.setLineJoin(linejoin);
	        gc.setMiterLimit(miterlimit);
	        gc.setFont(font);
	        gc.setTextAlign(textalign);
	        gc.setTextBaseline(textbaseline);
	        gc.setFillRule(fillRule);
			
			activeClip = false;
		}
	}
	
	@Override
	public void setLineCap(int cap) {
		switch (cap) {
		case SWT.CAP_FLAT:
			canvas.getGraphicsContext2D().setLineCap(StrokeLineCap.BUTT);
			break;
		case SWT.CAP_ROUND:
			canvas.getGraphicsContext2D().setLineCap(StrokeLineCap.ROUND);
			break;
		case SWT.CAP_SQUARE:
			canvas.getGraphicsContext2D().setLineCap(StrokeLineCap.SQUARE);
			break;
		default:
			canvas.getGraphicsContext2D().setLineCap(StrokeLineCap.BUTT);
			break;
		}
	}
	
	@Override
	public void setLineJoin(int join) {
		switch (join) {
		case SWT.JOIN_BEVEL:
			canvas.getGraphicsContext2D().setLineJoin(StrokeLineJoin.BEVEL);
			break;
		case SWT.JOIN_MITER:
			canvas.getGraphicsContext2D().setLineJoin(StrokeLineJoin.MITER);
			break;
		case SWT.JOIN_ROUND:
			canvas.getGraphicsContext2D().setLineJoin(StrokeLineJoin.ROUND);
			break;
		default:
			canvas.getGraphicsContext2D().setLineJoin(StrokeLineJoin.BEVEL);
			break;
		}
	}
	
	@Override
	public void drawShape(int xDelta, int yDelta, Shape shape) {
		Affine transform = canvas.getGraphicsContext2D().getTransform();
		Translate translate = Affine.translate(xDelta, yDelta);
		
		canvas.getGraphicsContext2D().setTransform(
				translate.getMxx(),translate.getMyx(),
				translate.getMxy(),translate.getMyy(),
				translate.getTx(),translate.getTy());
		path(shape.getPathIterator(null), true);
		canvas.getGraphicsContext2D().setTransform(transform);
	}
	
	@Override
	public void setLineStyle(int lineStyle) {
//		switch (lineStyle) {
//		case SWT.LINE_SOLID:
//			break;
//		case SWT.LINE_DASH:
//			break;
//		case SWT.LINE_DOT:
//			break;
//		case SWT.LINE_DASHDOT:
//			break;
//		case SWT.LINE_DASHDOTDOT:
//			break;
//		case SWT.LINE_CUSTOM:
//			break;
//		default:
//			break;
//		}
		Util.logNotImplemented();
	}
	
	@Override
	public void setBackgroundPattern(Pattern pattern) {
		if( pattern == null ) {
			canvas.getGraphicsContext2D().setFill(defaultBackground);
		} else {
			if( pattern.internal_getImage() != null ) {
				canvas.getGraphicsContext2D().setFill(new ImagePattern(pattern.internal_getImage()));	
			} else {
				canvas.getGraphicsContext2D().setFill(new LinearGradient(pattern.internal_getX1(), pattern.internal_getY1(), pattern.internal_getX2(), pattern.internal_getY2(), false, CycleMethod.NO_CYCLE));
			}				
		}
	}
	
	@Override
	public void setForegroundPattern(Pattern pattern) {
		if( pattern == null ) {
			canvas.getGraphicsContext2D().setStroke(defaultForeground);
		} else {
			if( pattern.internal_getImage() != null ) {
				canvas.getGraphicsContext2D().setStroke(new ImagePattern(pattern.internal_getImage()));
			} else {
				canvas.getGraphicsContext2D().setStroke(new LinearGradient(pattern.internal_getX1(), pattern.internal_getY1(), pattern.internal_getX2(), pattern.internal_getY2(), false, CycleMethod.NO_CYCLE));
			}
		}
	}
	
	@Override
	public void dispose() {
		resetClip();
	}
}

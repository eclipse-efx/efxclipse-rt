package org.eclipse.swt.graphics;

import org.eclipse.swt.internal.Util;

import com.sun.javafx.geom.Path2D;
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
	
//	public void addArc(float x, float y, float width, float height, float startAngle, float arcAngle) {
//
//	}
//	
//	public void addPath(Path path) {
//		
//	}
//	
//	public void addRectangle(float x, float y, float width, float height) {
//		
//	}
//	
	public void addString(String string, float x, float y, Font font) {
		int type = TextLayout.TYPE_TEXT | TextLayout.TYPE_TOP;
		TextLayoutFactory factory = Toolkit.getToolkit().getTextLayoutFactory();
		TextLayout layout = factory.createLayout();
		layout.setContent(string, font.internal_getNativeObject().impl_getNativeFont());
		path.append(layout.getShape(type, null),false);
	}
	
	public void close() {
		
	}
	
//	public boolean contains(float x, float y, GC gc, boolean outline) {
//		
//	}
//	
//	public void cubicTo(float cx1, float cy1, float cx2, float cy2, float x, float y) {
//		
//	}
//	
//	public void getBounds(float[] bounds) {
//		
//	}
//	
//	public void getCurrentPoint(float[] point) {
//		
//	}
//
//	public PathData getPathData() {
//		
//	}
//	
//	public void lineTo(float x, float y) {
//		
//	}
//	
//	public void moveTo(float x, float y) {
//		
//	}
//	
//	public void quadTo(float cx, float cy, float x, float y) {
//		
//	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDisposed() {
		// TODO Auto-generated method stub
		return false;
	}

}

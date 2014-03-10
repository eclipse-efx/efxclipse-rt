package org.eclipse.swt.graphics;

import javafx.scene.shape.Polygon;

import com.sun.javafx.geom.Area;
import com.sun.javafx.geom.RectBounds;
import com.sun.javafx.geom.RoundRectangle2D;
import com.sun.javafx.geom.transform.Affine2D;

@SuppressWarnings("restriction")
public class Region extends Resource {
	private Area area;
	
	public Region() {
		this(null);
	}
	
	public Region(Device device) {
		super(device);
		area = new Area();
	}
	
	public Area internal_getNativeObject() {
		return area;
	}
	
	public void add (int[] pointArray) {
		double[] points = new double[pointArray.length];
		for( int i = 0; i < pointArray.length; i++ ) {
			points[i] = pointArray[i];
		}
		area.add(new Area(new Polygon(points).impl_configShape()));
	}
	
	public void add(Rectangle rect) {
		add(rect.x, rect.y, rect.width, rect.height);
	}
	
	public void add(int x, int y, int width, int height) {
		area.add(new Area(new RoundRectangle2D(x, y, width, height, 0, 0)));
	}
	
	public void add(Region region) {
		area.add(region.area);
	}
	
	public boolean contains(int x, int y) {
		return area.contains(x, y);
	}
	
	public boolean contains(Point pt) {
		return contains(pt.x, pt.y);
	}
	
	public Rectangle getBounds() {
		RectBounds bounds = area.getBounds();
		return new Rectangle((int)bounds.getMinX(), (int)bounds.getMinY(), (int)bounds.getWidth(), (int)bounds.getHeight());
	}
	
	public void intersect(Rectangle rect) {
		intersect(rect.x, rect.y, rect.width, rect.height);
	}
	
	public void intersect(int x, int y, int width, int height) {
		area.intersect(new Area(new RoundRectangle2D(x, y, width, height,0,0)));
	}
	
	public void intersect(Region region) {
		area.intersect(region.area);
	}
	
	public boolean intersects (int x, int y, int width, int height) {
		return area.intersects(new RectBounds(x, y, width, height));
	}
	
	public boolean intersects(Rectangle rect) {
		return intersects(rect.x, rect.y, rect.width, rect.height);
	}
	
	public boolean isEmpty() {
		return area.isEmpty();
	}
	
	public void subtract (int[] pointArray) {
		double[] points = new double[pointArray.length];
		for( int i = 0; i < pointArray.length; i++ ) {
			points[i] = pointArray[i];
		}
		area.subtract(new Area(new Polygon(points).impl_configShape()));
	}
	
	public void subtract(Rectangle rect) {
		subtract(rect.x, rect.y, rect.width, rect.height);
	}
	
	public void subtract(int x, int y, int width, int height) {
		area.subtract(new Area(new RoundRectangle2D(x, y, width, height, 0, 0)));
	}
	
	public void subtract(Region region) {
		area.subtract(region.area);
	}
	
	public void translate (int x, int y) {
		area.transform(Affine2D.getTranslateInstance(x, y));
	}
	
	public void translate (Point pt) {
		translate(pt.x, pt.y);
	}

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

package org.eclipse.swt.graphics;

public class Point {
	public int x;
	public int y;
	
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals (Object object) {
		if (object == this) return true;
		if (!(object instanceof Point)) return false;
		Point p = (Point)object;
		return (p.x == this.x) && (p.y == this.y);
	}
	
	public int hashCode () {
		return x ^ y;
	}
	
	public String toString () {
		return "Point {" + x + ", " + y + "}"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
}

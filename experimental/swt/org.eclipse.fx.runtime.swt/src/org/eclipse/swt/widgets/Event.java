package org.eclipse.swt.widgets;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;

public class Event {
	public Display display;

	public Widget widget;

	public int type;

	public int detail;

	public Widget item;

	public int index;

	public GC gc;

	public int x;

	public int y;

	public int width;

	public int height;

	public int count;

	public int time;

	public int button;

	public char character;

	public int keyCode;

	public int keyLocation;

	public int stateMask;

	public int start, end;

	public String text;

	public int[] segments;

	public char[] segmentsChars;

	public boolean doit = true;

	public Object data;

	public Touch[] touches;

	public int xDirection;

	public int yDirection;

	public double magnification;

	public double rotation;

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

	public void setBounds(Rectangle rect) {
		this.x = rect.x;
		this.y = rect.y;
		this.width = rect.width;
		this.height = rect.height;
	}

	public String toString() {
		return "Event {type=" + type + " " + widget + " time=" + time + " data=" + data + " x=" + x + " y=" + y + " width=" + width + " height=" + height + " detail=" + detail + "}"; //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
	}
}

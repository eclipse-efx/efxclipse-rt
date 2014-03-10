package org.eclipse.swt.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;

public class RowData {
	/**
	 * width specifies the desired width in pixels. This value
	 * is the wHint passed into Control.computeSize(int, int, boolean) 
	 * to determine the preferred size of the control.
	 *
	 * The default value is SWT.DEFAULT.
	 *
	 * @see org.eclipse.swt.widgets.Control#computeSize(int, int, boolean)
	 */
	public int width = SWT.DEFAULT;
	/**
	 * height specifies the preferred height in pixels. This value
	 * is the hHint passed into Control.computeSize(int, int, boolean) 
	 * to determine the preferred size of the control.
	 *
	 * The default value is SWT.DEFAULT.
	 *
	 * @see org.eclipse.swt.widgets.Control#computeSize(int, int, boolean)
	 */
	public int height = SWT.DEFAULT;
	
	/**
	 * exclude informs the layout to ignore this control when sizing
	 * and positioning controls.  If this value is <code>true</code>,
	 * the size and position of the control will not be managed by the
	 * layout.  If this	value is <code>false</code>, the size and 
	 * position of the control will be computed and assigned.
	 * 
	 * The default value is <code>false</code>.
	 * 
	 * @since 3.1
	 */
	public boolean exclude = false;
	
	public RowData () {
	}

	public RowData (int width, int height) {
		this.width = width;
		this.height = height;
	}

	public RowData (Point point) {
		this (point.x, point.y);
	}
	
	String getName () {
		String string = getClass ().getName ();
		int index = string.lastIndexOf ('.');
		if (index == -1) return string;
		return string.substring (index + 1, string.length ());
	}

	public String toString () {
		String string = getName ()+" {";
		if (width != SWT.DEFAULT) string += "width="+width+" ";
		if (height != SWT.DEFAULT) string += "height="+height+" ";
		if (exclude) string += "exclude="+exclude+" ";
		string = string.trim();
		string += "}";
		return string;
	}
}

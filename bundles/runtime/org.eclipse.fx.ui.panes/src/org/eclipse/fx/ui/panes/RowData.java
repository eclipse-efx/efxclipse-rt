/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.panes;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import static org.eclipse.fx.ui.panes.AbstractLayoutPane.*;

public class RowData {
	/**
	 * width specifies the desired width in pixels. This value is the wHint
	 * passed into Control.computeSize(int, int, boolean) to determine the
	 * preferred size of the control.
	 * 
	 * The default value is SWT.DEFAULT.
	 * 
	 * @see org.eclipse.swt.widgets.Control#computeSize(int, int, boolean)
	 */
	public IntegerProperty width = new SimpleIntegerProperty(this, "width", FX_DEFAULT);
	/**
	 * height specifies the preferred height in pixels. This value is the hHint
	 * passed into Control.computeSize(int, int, boolean) to determine the
	 * preferred size of the control.
	 * 
	 * The default value is SWT.DEFAULT.
	 * 
	 * @see org.eclipse.swt.widgets.Control#computeSize(int, int, boolean)
	 */
	public IntegerProperty height = new SimpleIntegerProperty(this, "height", FX_DEFAULT);

	/**
	 * exclude informs the layout to ignore this control when sizing and
	 * positioning controls. If this value is <code>true</code>, the size and
	 * position of the control will not be managed by the layout. If this value
	 * is <code>false</code>, the size and position of the control will be
	 * computed and assigned.
	 * 
	 * The default value is <code>false</code>.
	 * 
	 * @since 3.1
	 */
	public BooleanProperty exclude = new SimpleBooleanProperty(this, "exclude", false);

	/**
	 * Constructs a new instance of RowData using default values.
	 */
	public RowData() {
	}

	/**
	 * Constructs a new instance of RowData according to the parameters. A value
	 * of SWT.DEFAULT indicates that no minimum width or no minimum height is
	 * specified.
	 * 
	 * @param width
	 *            a minimum width for the control
	 * @param height
	 *            a minimum height for the control
	 */
	public RowData(int width, int height) {
		this.width.set(width);
		this.height.set(height);
	}

	String getName() {
		String string = getClass().getName();
		int index = string.lastIndexOf('.');
		if (index == -1)
			return string;
		return string.substring(index + 1, string.length());
	}

	// ----
	public void setExclude(boolean value) {
		exclude.set(value);
	}

	public boolean isExclude() {
		return exclude.get();
	}

	public BooleanProperty excludeProperty() {
		return exclude;
	}

	// ----
	public void setHeight(int value) {
		height.set(value);
	}

	public int getHeight() {
		return height.get();
	}

	public IntegerProperty heightProperty() {
		return height;
	}

	// ----
	public void setWidth(int value) {
		width.set(value);
	}

	public int getWidth() {
		return width.get();
	}

	public IntegerProperty widthProperty() {
		return width;
	}

	/**
	 * Returns a string containing a concise, human-readable description of the
	 * receiver.
	 * 
	 * @return a string representation of the RowData object
	 */
	public String toString() {
		String string = getName() + " {";
		if (width.get() != FX_DEFAULT)
			string += "width=" + width + " ";
		if (height.get() != FX_DEFAULT)
			string += "height=" + height + " ";
		if (exclude.get())
			string += "exclude=" + exclude + " ";
		string = string.trim();
		string += "}";
		return string;
	}
}
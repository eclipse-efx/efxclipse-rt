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

/**
 * Row data constraint
 */
public class RowData {
	private IntegerProperty width = new SimpleIntegerProperty(this, "width", FX_DEFAULT); //$NON-NLS-1$
	private IntegerProperty height = new SimpleIntegerProperty(this, "height", FX_DEFAULT); //$NON-NLS-1$
	private BooleanProperty exclude = new SimpleBooleanProperty(this, "exclude", false); //$NON-NLS-1$

	/**
	 * Constructs a new instance of RowData using default values.
	 */
	public RowData() {
	}

	/**
	 * Constructs a new instance of RowData according to the parameters. A value
	 * of {@link AbstractLayoutPane#FX_DEFAULT} indicates that no minimum width
	 * or no minimum height is specified.
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

	/**
	 * Exclude the element from layouting
	 * 
	 * @param value
	 *            <code>true</code> to exclude
	 */
	public void setExclude(boolean value) {
		excludeProperty().set(value);
	}

	/**
	 * @return <code>true</code> when excluded
	 */
	public boolean isExclude() {
		return excludeProperty().get();
	}

	/**
	 * @return the exclude property
	 */
	public BooleanProperty excludeProperty() {
		return this.exclude;
	}

	/**
	 * Set the height to use
	 * 
	 * @param value
	 *            the new height or {@link AbstractLayoutPane#FX_DEFAULT} for
	 *            the default
	 */
	public void setHeight(int value) {
		heightProperty().set(value);
	}

	/**
	 * @return the current height
	 */
	public int getHeight() {
		return heightProperty().get();
	}

	/**
	 * @return the height property
	 */
	public IntegerProperty heightProperty() {
		return this.height;
	}

	/**
	 * Set a new width
	 * 
	 * @param value
	 *            the new width or {@link AbstractLayoutPane#FX_DEFAULT}
	 */
	public void setWidth(int value) {
		widthProperty().set(value);
	}

	/**
	 * @return the current width
	 */
	public int getWidth() {
		return widthProperty().get();
	}

	/**
	 * @return the width property
	 */
	public IntegerProperty widthProperty() {
		return this.width;
	}

	/**
	 * Returns a string containing a concise, human-readable description of the
	 * receiver.
	 * 
	 * @return a string representation of the RowData object
	 */
	@Override
	public String toString() {
		String string = getName() + " {"; //$NON-NLS-1$
		if (getWidth() != FX_DEFAULT)
			string += "width=" + getWidth() + " "; //$NON-NLS-1$ //$NON-NLS-2$
		if (getHeight() != FX_DEFAULT)
			string += "height=" + getHeight() + " "; //$NON-NLS-1$ //$NON-NLS-2$
		if (isExclude())
			string += "exclude=" + isExclude() + " "; //$NON-NLS-1$ //$NON-NLS-2$
		string = string.trim();
		string += "}"; //$NON-NLS-1$
		return string;
	}
}
/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;

public final class GridData {
	public int verticalAlignment = CENTER;

	public int horizontalAlignment = BEGINNING;

	public int widthHint = SWT.DEFAULT;

	public int heightHint = SWT.DEFAULT;

	public int horizontalIndent = 0;

	public int verticalIndent = 0;

	public int horizontalSpan = 1;

	public int verticalSpan = 1;

	public boolean grabExcessHorizontalSpace = false;

	public boolean grabExcessVerticalSpace = false;

	public int minimumWidth = 0;

	public int minimumHeight = 0;

	public boolean exclude = false;

	public static final int BEGINNING = SWT.BEGINNING;

	public static final int CENTER = 2;

	public static final int END = 3;

	public static final int FILL = SWT.FILL;

	public static final int VERTICAL_ALIGN_BEGINNING = 1 << 1;

	public static final int VERTICAL_ALIGN_CENTER = 1 << 2;

	public static final int VERTICAL_ALIGN_END = 1 << 3;

	public static final int VERTICAL_ALIGN_FILL = 1 << 4;

	public static final int HORIZONTAL_ALIGN_BEGINNING = 1 << 5;

	public static final int HORIZONTAL_ALIGN_CENTER = 1 << 6;

	public static final int HORIZONTAL_ALIGN_END = 1 << 7;

	public static final int HORIZONTAL_ALIGN_FILL = 1 << 8;

	public static final int GRAB_HORIZONTAL = 1 << 9;

	public static final int GRAB_VERTICAL = 1 << 10;

	public static final int FILL_VERTICAL = VERTICAL_ALIGN_FILL | GRAB_VERTICAL;

	public static final int FILL_HORIZONTAL = HORIZONTAL_ALIGN_FILL | GRAB_HORIZONTAL;

	public static final int FILL_BOTH = FILL_VERTICAL | FILL_HORIZONTAL;

	int cacheWidth = -1, cacheHeight = -1;
	int defaultWhint, defaultHhint, defaultWidth = -1, defaultHeight = -1;
	int currentWhint, currentHhint, currentWidth = -1, currentHeight = -1;

	public GridData() {
		super();
	}

	public GridData(int style) {
		super();
		if ((style & VERTICAL_ALIGN_BEGINNING) != 0)
			verticalAlignment = BEGINNING;
		if ((style & VERTICAL_ALIGN_CENTER) != 0)
			verticalAlignment = CENTER;
		if ((style & VERTICAL_ALIGN_FILL) != 0)
			verticalAlignment = FILL;
		if ((style & VERTICAL_ALIGN_END) != 0)
			verticalAlignment = END;
		if ((style & HORIZONTAL_ALIGN_BEGINNING) != 0)
			horizontalAlignment = BEGINNING;
		if ((style & HORIZONTAL_ALIGN_CENTER) != 0)
			horizontalAlignment = CENTER;
		if ((style & HORIZONTAL_ALIGN_FILL) != 0)
			horizontalAlignment = FILL;
		if ((style & HORIZONTAL_ALIGN_END) != 0)
			horizontalAlignment = END;
		grabExcessHorizontalSpace = (style & GRAB_HORIZONTAL) != 0;
		grabExcessVerticalSpace = (style & GRAB_VERTICAL) != 0;
	}

	public GridData(int horizontalAlignment, int verticalAlignment, boolean grabExcessHorizontalSpace, boolean grabExcessVerticalSpace) {
		this(horizontalAlignment, verticalAlignment, grabExcessHorizontalSpace, grabExcessVerticalSpace, 1, 1);
	}

	public GridData(int horizontalAlignment, int verticalAlignment, boolean grabExcessHorizontalSpace, boolean grabExcessVerticalSpace, int horizontalSpan, int verticalSpan) {
		super();
		this.horizontalAlignment = horizontalAlignment;
		this.verticalAlignment = verticalAlignment;
		this.grabExcessHorizontalSpace = grabExcessHorizontalSpace;
		this.grabExcessVerticalSpace = grabExcessVerticalSpace;
		this.horizontalSpan = horizontalSpan;
		this.verticalSpan = verticalSpan;
	}

	public GridData(int width, int height) {
		super();
		this.widthHint = width;
		this.heightHint = height;
	}

	void computeSize(Control control, int wHint, int hHint, boolean flushCache) {
		if (cacheWidth != -1 && cacheHeight != -1)
			return;
		if (wHint == this.widthHint && hHint == this.heightHint) {
			if (defaultWidth == -1 || defaultHeight == -1 || wHint != defaultWhint || hHint != defaultHhint) {
				Point size = control.computeSize(wHint, hHint, flushCache);
				defaultWhint = wHint;
				defaultHhint = hHint;
				defaultWidth = size.x;
				defaultHeight = size.y;
			}
			cacheWidth = defaultWidth;
			cacheHeight = defaultHeight;
			return;
		}
		if (currentWidth == -1 || currentHeight == -1 || wHint != currentWhint || hHint != currentHhint) {
			Point size = control.computeSize(wHint, hHint, flushCache);
			currentWhint = wHint;
			currentHhint = hHint;
			currentWidth = size.x;
			currentHeight = size.y;
		}
		cacheWidth = currentWidth;
		cacheHeight = currentHeight;
	}

	void flushCache() {
		cacheWidth = cacheHeight = -1;
		defaultWidth = defaultHeight = -1;
		currentWidth = currentHeight = -1;
	}

	String getName() {
		String string = getClass().getName();
		int index = string.lastIndexOf('.');
		if (index == -1)
			return string;
		return string.substring(index + 1, string.length());
	}

	/**
	 * Returns a string containing a concise, human-readable description of the
	 * receiver.
	 * 
	 * @return a string representation of the GridData object
	 */
	public String toString() {
		String hAlign = "";
		switch (horizontalAlignment) {
		case SWT.FILL:
			hAlign = "SWT.FILL";
			break;
		case SWT.BEGINNING:
			hAlign = "SWT.BEGINNING";
			break;
		case SWT.LEFT:
			hAlign = "SWT.LEFT";
			break;
		case SWT.END:
			hAlign = "SWT.END";
			break;
		case END:
			hAlign = "GridData.END";
			break;
		case SWT.RIGHT:
			hAlign = "SWT.RIGHT";
			break;
		case SWT.CENTER:
			hAlign = "SWT.CENTER";
			break;
		case CENTER:
			hAlign = "GridData.CENTER";
			break;
		default:
			hAlign = "Undefined " + horizontalAlignment;
			break;
		}
		String vAlign = "";
		switch (verticalAlignment) {
		case SWT.FILL:
			vAlign = "SWT.FILL";
			break;
		case SWT.BEGINNING:
			vAlign = "SWT.BEGINNING";
			break;
		case SWT.TOP:
			vAlign = "SWT.TOP";
			break;
		case SWT.END:
			vAlign = "SWT.END";
			break;
		case END:
			vAlign = "GridData.END";
			break;
		case SWT.BOTTOM:
			vAlign = "SWT.BOTTOM";
			break;
		case SWT.CENTER:
			vAlign = "SWT.CENTER";
			break;
		case CENTER:
			vAlign = "GridData.CENTER";
			break;
		default:
			vAlign = "Undefined " + verticalAlignment;
			break;
		}
		String string = getName() + " {";
		string += "horizontalAlignment=" + hAlign + " ";
		if (horizontalIndent != 0)
			string += "horizontalIndent=" + horizontalIndent + " ";
		if (horizontalSpan != 1)
			string += "horizontalSpan=" + horizontalSpan + " ";
		if (grabExcessHorizontalSpace)
			string += "grabExcessHorizontalSpace=" + grabExcessHorizontalSpace + " ";
		if (widthHint != SWT.DEFAULT)
			string += "widthHint=" + widthHint + " ";
		if (minimumWidth != 0)
			string += "minimumWidth=" + minimumWidth + " ";
		string += "verticalAlignment=" + vAlign + " ";
		if (verticalIndent != 0)
			string += "verticalIndent=" + verticalIndent + " ";
		if (verticalSpan != 1)
			string += "verticalSpan=" + verticalSpan + " ";
		if (grabExcessVerticalSpace)
			string += "grabExcessVerticalSpace=" + grabExcessVerticalSpace + " ";
		if (heightHint != SWT.DEFAULT)
			string += "heightHint=" + heightHint + " ";
		if (minimumHeight != 0)
			string += "minimumHeight=" + minimumHeight + " ";
		if (exclude)
			string += "exclude=" + exclude + " ";
		string = string.trim();
		string += "}";
		return string;
	}
}
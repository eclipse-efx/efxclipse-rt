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
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.WritableBooleanValue;
import javafx.scene.Node;
import static org.eclipse.fx.ui.panes.AbstractLayoutPane.*;

public class GridData {
	public enum Alignment {
		BEGINNING,
		CENTER,
		END,
		FILL
	}
	
	private ObjectProperty<Alignment> verticalAlignment = new SimpleObjectProperty<Alignment>(this, "verticalAlignment", Alignment.CENTER);

	private ObjectProperty<Alignment> horizontalAlignment = new SimpleObjectProperty<Alignment>(this, "horizontalAlignment", Alignment.BEGINNING);

	private IntegerProperty widthHint = new SimpleIntegerProperty(this, "widthHint", FX_DEFAULT);

	private IntegerProperty heightHint = new SimpleIntegerProperty(this, "heightHint", FX_DEFAULT);

	private IntegerProperty horizontalIndent = new SimpleIntegerProperty(this, "horizontalIndent");

	private IntegerProperty verticalIndent = new SimpleIntegerProperty(this, "verticalIndent");

	private IntegerProperty horizontalSpan = new SimpleIntegerProperty(this, "horizontalSpan", 1);

	private IntegerProperty verticalSpan = new SimpleIntegerProperty(this, "verticalSpan", 1);

	private BooleanProperty grabExcessHorizontalSpace = new SimpleBooleanProperty(this, "grabExcessHorizontalSpace", false);

	private BooleanProperty grabExcessVerticalSpace = new SimpleBooleanProperty(this, "grabExcessVerticalSpace", false);

	private IntegerProperty minimumWidth = new SimpleIntegerProperty(this, "minimumWidth", 0);

	private IntegerProperty minimumHeight = new SimpleIntegerProperty(this, "minimumHeight", 0);

	private BooleanProperty exclude = new SimpleBooleanProperty(this, "exclude", false);

	/**
	 * Style bit for <code>new GridData(int)</code>. Position the control at the
	 * top of the cell. Not recommended. Use
	 * <code>new GridData(int, SWT.BEGINNING, boolean, boolean)</code> instead.
	 */
	public static final int VERTICAL_ALIGN_BEGINNING = 1 << 1;

	/**
	 * Style bit for <code>new GridData(int)</code> to position the control in
	 * the vertical center of the cell. Not recommended. Use
	 * <code>new GridData(int, SWT.CENTER, boolean, boolean)</code> instead.
	 */
	public static final int VERTICAL_ALIGN_CENTER = 1 << 2;

	/**
	 * Style bit for <code>new GridData(int)</code> to position the control at
	 * the bottom of the cell. Not recommended. Use
	 * <code>new GridData(int, SWT.END, boolean, boolean)</code> instead.
	 */
	public static final int VERTICAL_ALIGN_END = 1 << 3;

	/**
	 * Style bit for <code>new GridData(int)</code> to resize the control to
	 * fill the cell vertically. Not recommended. Use
	 * <code>new GridData(int, SWT.FILL, boolean, boolean)</code> instead
	 */
	public static final int VERTICAL_ALIGN_FILL = 1 << 4;

	/**
	 * Style bit for <code>new GridData(int)</code> to position the control at
	 * the left of the cell. Not recommended. Use
	 * <code>new GridData(SWT.BEGINNING, int, boolean, boolean)</code> instead.
	 */
	public static final int HORIZONTAL_ALIGN_BEGINNING = 1 << 5;

	/**
	 * Style bit for <code>new GridData(int)</code> to position the control in
	 * the horizontal center of the cell. Not recommended. Use
	 * <code>new GridData(SWT.CENTER, int, boolean, boolean)</code> instead.
	 */
	public static final int HORIZONTAL_ALIGN_CENTER = 1 << 6;

	/**
	 * Style bit for <code>new GridData(int)</code> to position the control at
	 * the right of the cell. Not recommended. Use
	 * <code>new GridData(SWT.END, int, boolean, boolean)</code> instead.
	 */
	public static final int HORIZONTAL_ALIGN_END = 1 << 7;

	/**
	 * Style bit for <code>new GridData(int)</code> to resize the control to
	 * fill the cell horizontally. Not recommended. Use
	 * <code>new GridData(SWT.FILL, int, boolean, boolean)</code> instead.
	 */
	public static final int HORIZONTAL_ALIGN_FILL = 1 << 8;

	/**
	 * Style bit for <code>new GridData(int)</code> to resize the control to fit
	 * the remaining horizontal space. Not recommended. Use
	 * <code>new GridData(int, int, true, boolean)</code> instead.
	 */
	public static final int GRAB_HORIZONTAL = 1 << 9;

	/**
	 * Style bit for <code>new GridData(int)</code> to resize the control to fit
	 * the remaining vertical space. Not recommended. Use
	 * <code>new GridData(int, int, boolean, true)</code> instead.
	 */
	public static final int GRAB_VERTICAL = 1 << 10;

	/**
	 * Style bit for <code>new GridData(int)</code> to resize the control to
	 * fill the cell vertically and to fit the remaining vertical space.
	 * FILL_VERTICAL = VERTICAL_ALIGN_FILL | GRAB_VERTICAL Not recommended. Use
	 * <code>new GridData(int, SWT.FILL, boolean, true)</code> instead.
	 */
	public static final int FILL_VERTICAL = VERTICAL_ALIGN_FILL | GRAB_VERTICAL;

	/**
	 * Style bit for <code>new GridData(int)</code> to resize the control to
	 * fill the cell horizontally and to fit the remaining horizontal space.
	 * FILL_HORIZONTAL = HORIZONTAL_ALIGN_FILL | GRAB_HORIZONTAL Not
	 * recommended. Use <code>new GridData(SWT.FILL, int, true, boolean)</code>
	 * instead.
	 */
	public static final int FILL_HORIZONTAL = HORIZONTAL_ALIGN_FILL | GRAB_HORIZONTAL;

	/**
	 * Style bit for <code>new GridData(int)</code> to resize the control to
	 * fill the cell horizontally and vertically and to fit the remaining
	 * horizontal and vertical space. FILL_BOTH = FILL_VERTICAL |
	 * FILL_HORIZONTAL Not recommended. Use
	 * <code>new GridData(SWT.FILL, SWT.FILL, true, true)</code> instead.
	 */
	public static final int FILL_BOTH = FILL_VERTICAL | FILL_HORIZONTAL;

	double cacheWidth = -1, cacheHeight = -1;
	double defaultWhint, defaultHhint, defaultWidth = -1, defaultHeight = -1;
	double currentWhint, currentHhint, currentWidth = -1, currentHeight = -1;

	/**
	 * Constructs a new instance of GridData using default values.
	 */
	public GridData() {
		super();
	}

	/**
	 * Constructs a new instance based on the GridData style. This constructor
	 * is not recommended.
	 * 
	 * @param style
	 *            the GridData style
	 */
	public GridData(int style) {
		super();
		if ((style & VERTICAL_ALIGN_BEGINNING) != 0)
			verticalAlignment.set(Alignment.BEGINNING);
		if ((style & VERTICAL_ALIGN_CENTER) != 0)
			verticalAlignment.set(Alignment.CENTER);
		if ((style & VERTICAL_ALIGN_FILL) != 0)
			verticalAlignment.set(Alignment.FILL);
		if ((style & VERTICAL_ALIGN_END) != 0)
			verticalAlignment.set(Alignment.END);
		if ((style & HORIZONTAL_ALIGN_BEGINNING) != 0)
			horizontalAlignment.set(Alignment.BEGINNING);
		if ((style & HORIZONTAL_ALIGN_CENTER) != 0)
			horizontalAlignment.set(Alignment.CENTER);
		if ((style & HORIZONTAL_ALIGN_FILL) != 0)
			horizontalAlignment.set(Alignment.FILL);
		if ((style & HORIZONTAL_ALIGN_END) != 0)
			horizontalAlignment.set(Alignment.END);
		grabExcessHorizontalSpace.set((style & GRAB_HORIZONTAL) != 0);
		grabExcessVerticalSpace.set((style & GRAB_VERTICAL) != 0);
	}

	/**
	 * Constructs a new instance of GridData according to the parameters.
	 * 
	 * @param horizontalAlignment
	 *            how control will be positioned horizontally within a cell, one
	 *            of: SWT.BEGINNING (or SWT.LEFT), SWT.CENTER, SWT.END (or
	 *            SWT.RIGHT), or SWT.FILL
	 * @param verticalAlignment
	 *            how control will be positioned vertically within a cell, one
	 *            of: SWT.BEGINNING (or SWT.TOP), SWT.CENTER, SWT.END (or
	 *            SWT.BOTTOM), or SWT.FILL
	 * @param grabExcessHorizontalSpace
	 *            whether cell will be made wide enough to fit the remaining
	 *            horizontal space
	 * @param grabExcessVerticalSpace
	 *            whether cell will be made high enough to fit the remaining
	 *            vertical space
	 * 
	 * @since 3.0
	 */
	public GridData(Alignment horizontalAlignment, Alignment verticalAlignment, boolean grabExcessHorizontalSpace, boolean grabExcessVerticalSpace) {
		this(horizontalAlignment, verticalAlignment, grabExcessHorizontalSpace, grabExcessVerticalSpace, 1, 1);
	}

	/**
	 * Constructs a new instance of GridData according to the parameters.
	 * 
	 * @param horizontalAlignment
	 *            how control will be positioned horizontally within a cell, one
	 *            of: SWT.BEGINNING (or SWT.LEFT), SWT.CENTER, SWT.END (or
	 *            SWT.RIGHT), or SWT.FILL
	 * @param verticalAlignment
	 *            how control will be positioned vertically within a cell, one
	 *            of: SWT.BEGINNING (or SWT.TOP), SWT.CENTER, SWT.END (or
	 *            SWT.BOTTOM), or SWT.FILL
	 * @param grabExcessHorizontalSpace
	 *            whether cell will be made wide enough to fit the remaining
	 *            horizontal space
	 * @param grabExcessVerticalSpace
	 *            whether cell will be made high enough to fit the remaining
	 *            vertical space
	 * @param horizontalSpan
	 *            the number of column cells that the control will take up
	 * @param verticalSpan
	 *            the number of row cells that the control will take up
	 * 
	 * @since 3.0
	 */
	public GridData(Alignment horizontalAlignment, Alignment verticalAlignment, boolean grabExcessHorizontalSpace, boolean grabExcessVerticalSpace, int horizontalSpan, int verticalSpan) {
		super();
		this.horizontalAlignment.set(horizontalAlignment);
		this.verticalAlignment.set(verticalAlignment);
		this.grabExcessHorizontalSpace.set(grabExcessHorizontalSpace);
		this.grabExcessVerticalSpace.set(grabExcessVerticalSpace);
		this.horizontalSpan.set(horizontalSpan);
		this.verticalSpan.set(verticalSpan);
	}

	/**
	 * Constructs a new instance of GridData according to the parameters. A
	 * value of SWT.DEFAULT indicates that no minimum width or no minimum height
	 * is specified.
	 * 
	 * @param width
	 *            a minimum width for the column
	 * @param height
	 *            a minimum height for the row
	 * 
	 * @since 3.0
	 */
	public GridData(int width, int height) {
		super();
		this.widthHint.set(width);
		this.heightHint.set(height);
	}

	void computeSize(Node control, int wHint, int hHint, boolean flushCache) {
		if (cacheWidth != -1 && cacheHeight != -1)
			return;
		
		if (wHint == this.widthHint.get() && hHint == this.heightHint.get()) {
			if (defaultWidth == -1 || defaultHeight == -1 || wHint != defaultWhint || hHint != defaultHhint) {
				// Point size = control.computeSize (wHint, hHint, flushCache);
				defaultWhint = wHint;
				defaultHhint = hHint;
				defaultWidth = wHint == -1 ? control.prefWidth(hHint) : defaultWhint;
				defaultHeight = hHint == -1 ? control.prefHeight(wHint) : defaultHhint;
			}
			cacheWidth = defaultWidth;
			cacheHeight = defaultHeight;
			return;
		}
		if (currentWidth == -1 || currentHeight == -1 || wHint != currentWhint || hHint != currentHhint) {
			// Point size = control.computeSize (wHint, hHint, flushCache);
			currentWhint = wHint;
			currentHhint = hHint;
			currentWidth = control.getLayoutBounds().getWidth();
			currentHeight = control.getLayoutBounds().getHeight();
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
	public void setGrabExcessHorizontalSpace(boolean value) {
		grabExcessHorizontalSpace.set(value);
	}

	public boolean isGrabExcessHorizontalSpace() {
		return grabExcessHorizontalSpace.get();
	}

	public BooleanProperty grabExcessHorizontalSpaceProperty() {
		return grabExcessHorizontalSpace;
	}

	// ----
	public void setGrabVerticalSpace(boolean value) {
		grabExcessVerticalSpace.set(value);
	}

	public boolean isGrabVerticalSapce() {
		return grabExcessVerticalSpace.get();
	}

	public BooleanProperty grabExcessVerticalSpaceProperty() {
		return grabExcessVerticalSpace;
	}

	// ----
	public void setHeightHint(int value) {
		heightHint.set(value);
	}

	public int getHeightHint() {
		return heightHint.get();
	}

	public IntegerProperty heightHintProperty() {
		return heightHint;
	}

	// ----
	public void setHorizontalAlignment(Alignment value) {
		horizontalAlignment.set(value);
	}

	public Alignment getHorizontalAlignment() {
		return horizontalAlignment.get();
	}

	public ObjectProperty<Alignment> horizontalAlignmentProperty() {
		return horizontalAlignment;
	}

	// ----
	public void setHorizontalIndent(int value) {
		horizontalIndent.set(value);
	}

	public int getHorizontalnIdent() {
		return horizontalIndent.get();
	}

	public IntegerProperty horizontalIndentProperty() {
		return horizontalIndent;
	}

	// ----
	public void setHorizontalSpan(int value) {
		horizontalSpan.set(value);
	}

	public int getHorizontalSpan() {
		return horizontalSpan.get();
	}

	public IntegerProperty horizontalSpanProperty() {
		return horizontalSpan;
	}

	// ----
	public void setMinimumHeight(int value) {
		minimumHeight.set(value);
	}

	public int getMinimumHeight() {
		return minimumHeight.get();
	}

	public IntegerProperty minimumHeightProperty() {
		return minimumHeight;
	}

	// ----
	public void setMinimumWidth(int value) {
		minimumWidth.set(value);
	}

	public int getMinimumWidth() {
		return minimumWidth.get();
	}

	public IntegerProperty minimumWidthProperty() {
		return minimumWidth;
	}

	// ----
	public void setVerticalAlignment(Alignment value) {
		verticalAlignment.set(value);
	}

	public Alignment getVerticalAlignment() {
		return verticalAlignment.get();
	}

	public ObjectProperty<Alignment> verticalAlignmentProperty() {
		return verticalAlignment;
	}
	
	// ----
	public void setVerticalIndent(int value) {
		verticalIndent.set(value);
	}

	public int getVerticalIndent() {
		return verticalIndent.get();
	}

	public IntegerProperty verticalIndentProperty() {
		return verticalIndent;
	}

	// ----
	public void setVerticalSpan(int value) {
		verticalSpan.set(value);
	}

	public int getVerticalSpan() {
		return verticalSpan.get();
	}

	public IntegerProperty verticalSpanProperty() {
		return verticalSpan;
	}

	// ----
	public void setWidthHint(int value) {
		widthHint.set(value);
	}

	public int getWidthHint() {
		return widthHint.get();
	}

	public IntegerProperty widthHintProperty() {
		return widthHint;
	}

	/**
	 * Returns a string containing a concise, human-readable description of the
	 * receiver.
	 * 
	 * @return a string representation of the GridData object
	 */
	public String toString() {
		String hAlign = "";
		switch (horizontalAlignment.get()) {
		case FILL:
			hAlign = "SWT.FILL";
			break;
		case BEGINNING:
			hAlign = "SWT.BEGINNING";
			break;
		case END:
			hAlign = "GridData.END";
			break;
		case CENTER:
			hAlign = "GridData.CENTER";
			break;
		default:
			hAlign = "Undefined " + horizontalAlignment;
			break;
		}
		
		String vAlign = "";
		switch (verticalAlignment.get()) {
		case FILL:
			vAlign = "SWT.FILL";
			break;
		case BEGINNING:
			vAlign = "SWT.BEGINNING";
			break;
		case END:
			vAlign = "SWT.END";
			break;
		case CENTER:
			vAlign = "SWT.CENTER";
			break;
		default:
			vAlign = "Undefined " + verticalAlignment;
			break;
		}
		
		String string = getName() + " {";
		string += "horizontalAlignment=" + hAlign + " ";
		if (horizontalIndent.get() != 0)
			string += "horizontalIndent=" + horizontalIndent.get() + " ";
		if (horizontalSpan.get() != 1)
			string += "horizontalSpan=" + horizontalSpan.get() + " ";
		if (grabExcessHorizontalSpace.get())
			string += "grabExcessHorizontalSpace=" + grabExcessHorizontalSpace.get() + " ";
		if (widthHint.get() != FX_DEFAULT)
			string += "widthHint=" + widthHint.get() + " ";
		if (minimumWidth.get() != 0)
			string += "minimumWidth=" + minimumWidth.get() + " ";
		string += "verticalAlignment=" + vAlign + " ";
		if (verticalIndent.get() != 0)
			string += "verticalIndent=" + verticalIndent .get()+ " ";
		if (verticalSpan.get() != 1)
			string += "verticalSpan=" + verticalSpan.get() + " ";
		if (grabExcessVerticalSpace.get())
			string += "grabExcessVerticalSpace=" + grabExcessVerticalSpace.get() + " ";
		if (heightHint.get() != FX_DEFAULT)
			string += "heightHint=" + heightHint.get() + " ";
		if (minimumHeight.get() != 0)
			string += "minimumHeight=" + minimumHeight.get() + " ";
		if (exclude.get())
			string += "exclude=" + exclude.get() + " ";
		string = string.trim();
		string += "}";
		return string;
	}

	

}
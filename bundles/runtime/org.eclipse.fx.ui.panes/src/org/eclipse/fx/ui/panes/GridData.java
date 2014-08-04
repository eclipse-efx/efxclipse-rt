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

import static org.eclipse.fx.ui.panes.AbstractLayoutPane.FX_DEFAULT;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;

/**
 * Constraints for grid elements
 */
public class GridData {

	/**
	 * The alignment of the item in the cell
	 */
	public enum Alignment {
		/**
		 * At the beginning
		 */
		BEGINNING,
		/**
		 * At the center
		 */
		CENTER,
		/**
		 * At the end
		 */
		END,
		/**
		 * Fill the cell
		 */
		FILL
	}

	private ObjectProperty<Alignment> verticalAlignment = new SimpleObjectProperty<Alignment>(this, "verticalAlignment", Alignment.CENTER); //$NON-NLS-1$

	private ObjectProperty<Alignment> horizontalAlignment = new SimpleObjectProperty<Alignment>(this, "horizontalAlignment", Alignment.BEGINNING); //$NON-NLS-1$

	private IntegerProperty widthHint = new SimpleIntegerProperty(this, "widthHint", FX_DEFAULT); //$NON-NLS-1$

	private IntegerProperty heightHint = new SimpleIntegerProperty(this, "heightHint", FX_DEFAULT); //$NON-NLS-1$

	private IntegerProperty horizontalIndent = new SimpleIntegerProperty(this, "horizontalIndent"); //$NON-NLS-1$

	private IntegerProperty verticalIndent = new SimpleIntegerProperty(this, "verticalIndent"); //$NON-NLS-1$

	private IntegerProperty horizontalSpan = new SimpleIntegerProperty(this, "horizontalSpan", 1); //$NON-NLS-1$

	private IntegerProperty verticalSpan = new SimpleIntegerProperty(this, "verticalSpan", 1); //$NON-NLS-1$

	private BooleanProperty grabExcessHorizontalSpace = new SimpleBooleanProperty(this, "grabExcessHorizontalSpace", false); //$NON-NLS-1$

	private BooleanProperty grabExcessVerticalSpace = new SimpleBooleanProperty(this, "grabExcessVerticalSpace", false); //$NON-NLS-1$

	private IntegerProperty minimumWidth = new SimpleIntegerProperty(this, "minimumWidth", 0); //$NON-NLS-1$

	private IntegerProperty minimumHeight = new SimpleIntegerProperty(this, "minimumHeight", 0); //$NON-NLS-1$

	private BooleanProperty exclude = new SimpleBooleanProperty(this, "exclude", false); //$NON-NLS-1$

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
			setVerticalAlignment(Alignment.BEGINNING);
		if ((style & VERTICAL_ALIGN_CENTER) != 0)
			setVerticalAlignment(Alignment.CENTER);
		if ((style & VERTICAL_ALIGN_FILL) != 0)
			setVerticalAlignment(Alignment.FILL);
		if ((style & VERTICAL_ALIGN_END) != 0)
			setVerticalAlignment(Alignment.END);
		if ((style & HORIZONTAL_ALIGN_BEGINNING) != 0)
			setHorizontalAlignment(Alignment.BEGINNING);
		if ((style & HORIZONTAL_ALIGN_CENTER) != 0)
			setHorizontalAlignment(Alignment.CENTER);
		if ((style & HORIZONTAL_ALIGN_FILL) != 0)
			setHorizontalAlignment(Alignment.FILL);
		if ((style & HORIZONTAL_ALIGN_END) != 0)
			setHorizontalAlignment(Alignment.END);
		setGrabExcessHorizontalSpace((style & GRAB_HORIZONTAL) != 0);
		setGrabExcessVerticalSpace((style & GRAB_VERTICAL) != 0);
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
		setHorizontalAlignment(horizontalAlignment);
		setVerticalAlignment(verticalAlignment);
		setGrabExcessHorizontalSpace(grabExcessHorizontalSpace);
		setGrabExcessVerticalSpace(grabExcessVerticalSpace);
		setHorizontalSpan(horizontalSpan);
		setVerticalSpan(verticalSpan);
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
		setWidthHint(width);
		setHeightHint(height);
	}

	void computeSize(Node control, int wHint, int hHint, boolean flushCache) {
		if (this.cacheWidth != -1 && this.cacheHeight != -1)
			return;

		if (wHint == getWidthHint() && hHint == getHeightHint()) {
			if (this.defaultWidth == -1 || this.defaultHeight == -1 || wHint != this.defaultWhint || hHint != this.defaultHhint) {
				// Point size = control.computeSize (wHint, hHint, flushCache);
				this.defaultWhint = wHint;
				this.defaultHhint = hHint;
				this.defaultWidth = wHint == -1 ? Math.ceil(control.prefWidth(hHint)) : Math.ceil(this.defaultWhint);
				this.defaultHeight = hHint == -1 ? Math.ceil(control.prefHeight(wHint)) : Math.ceil(this.defaultHhint);
			}
			this.cacheWidth = this.defaultWidth;
			this.cacheHeight = this.defaultHeight;
			return;
		}
		if (this.currentWidth == -1 || this.currentHeight == -1 || wHint != this.currentWhint || hHint != this.currentHhint) {
			// Point size = control.computeSize (wHint, hHint, flushCache);
			this.currentWhint = wHint;
			this.currentHhint = hHint;
			this.currentWidth = Math.ceil(control.getLayoutBounds().getWidth());
			this.currentHeight = Math.ceil(control.getLayoutBounds().getHeight());
		}
		this.cacheWidth = this.currentWidth;
		this.cacheHeight = this.currentHeight;
	}

	void flushCache() {
		this.cacheWidth = this.cacheHeight = -1;
		this.defaultWidth = this.defaultHeight = -1;
		this.currentWidth = this.currentHeight = -1;
	}

	String getName() {
		String string = getClass().getName();
		int index = string.lastIndexOf('.');
		if (index == -1)
			return string;
		return string.substring(index + 1, string.length());
	}

	/**
	 * Exclude the node when layouting
	 * 
	 * @param value
	 *            the new value
	 */
	public void setExclude(boolean value) {
		excludeProperty().set(value);
	}

	/**
	 * @return Exclude the node when layouting
	 */
	public boolean isExclude() {
		return excludeProperty().get();
	}

	/**
	 * @return Exclude the node when layouting
	 */
	public BooleanProperty excludeProperty() {
		return this.exclude;
	}

	/**
	 * Grab all available horizontal space
	 * 
	 * @param value
	 *            <code>true</code> to grab space
	 */
	public void setGrabExcessHorizontalSpace(boolean value) {
		grabExcessHorizontalSpaceProperty().set(value);
	}

	/**
	 * @return <code>true</code> if space is grabbed
	 */
	public boolean isGrabExcessHorizontalSpace() {
		return grabExcessHorizontalSpaceProperty().get();
	}

	/**
	 * @return Grab all available horizontal space
	 */
	public BooleanProperty grabExcessHorizontalSpaceProperty() {
		return this.grabExcessHorizontalSpace;
	}

	/**
	 * Grab vertical space if available
	 * 
	 * @param value
	 *            <code>true</code> to grab space
	 */
	public void setGrabExcessVerticalSpace(boolean value) {
		grabExcessVerticalSpaceProperty().set(value);
	}

	/**
	 * @return <code>true</code> is space is grabbed
	 */
	public boolean isGrabExcessVerticalSpace() {
		return grabExcessVerticalSpaceProperty().get();
	}

	/**
	 * @return <code>true</code> is space is grabbed
	 */
	public BooleanProperty grabExcessVerticalSpaceProperty() {
		return this.grabExcessVerticalSpace;
	}

	/**
	 * Set a height hint
	 * 
	 * @param value
	 *            the hint of or {@link AbstractLayoutPane#FX_DEFAULT} to set
	 *            back
	 */
	public void setHeightHint(int value) {
		heightHintProperty().set(value);
	}

	/**
	 * @return the current height hint
	 */
	public int getHeightHint() {
		return heightHintProperty().get();
	}

	/**
	 * @return the height property
	 */
	public IntegerProperty heightHintProperty() {
		return this.heightHint;
	}

	/**
	 * Set a horizontal alignment
	 * 
	 * @param value
	 *            the alignment
	 */
	public void setHorizontalAlignment(Alignment value) {
		horizontalAlignmentProperty().set(value);
	}

	/**
	 * @return the current horizontal alignment
	 */
	public Alignment getHorizontalAlignment() {
		return horizontalAlignmentProperty().get();
	}

	/**
	 * @return the horizontal alignment property
	 */
	public ObjectProperty<Alignment> horizontalAlignmentProperty() {
		return this.horizontalAlignment;
	}

	/**
	 * Set the horizontal indent
	 * 
	 * @param value
	 *            the indent
	 */
	public void setHorizontalIndent(int value) {
		horizontalIndentProperty().set(value);
	}

	/**
	 * @return the horizontal indent
	 */
	public int getHorizontalIndent() {
		return horizontalIndentProperty().get();
	}

	/**
	 * @return the horizontal indent property
	 */
	public IntegerProperty horizontalIndentProperty() {
		return this.horizontalIndent;
	}

	/**
	 * Set a horizontal span
	 * 
	 * @param value
	 *            the horizontal span
	 */
	public void setHorizontalSpan(int value) {
		horizontalSpanProperty().set(value);
	}

	/**
	 * @return the current horizontal span
	 */
	public int getHorizontalSpan() {
		return horizontalSpanProperty().get();
	}

	/**
	 * @return the horizontal span property
	 */
	public IntegerProperty horizontalSpanProperty() {
		return this.horizontalSpan;
	}

	/**
	 * Set a minimum height
	 * 
	 * @param value
	 *            the value or {@link AbstractLayoutPane#FX_DEFAULT} for the
	 *            default
	 */
	public void setMinimumHeight(int value) {
		minimumHeightProperty().set(value);
	}

	/**
	 * @return the current minimum height
	 */
	public int getMinimumHeight() {
		return minimumHeightProperty().get();
	}

	/**
	 * @return the current minimum height property
	 */
	public IntegerProperty minimumHeightProperty() {
		return this.minimumHeight;
	}

	/**
	 * Set a minimum width
	 * 
	 * @param value
	 *            the new minimum width or {@link AbstractLayoutPane#FX_DEFAULT}
	 *            for the default
	 */
	public void setMinimumWidth(int value) {
		minimumWidthProperty().set(value);
	}

	/**
	 * @return the current minimum width
	 */
	public int getMinimumWidth() {
		return minimumWidthProperty().get();
	}

	/**
	 * @return the current minimum width property
	 */
	public IntegerProperty minimumWidthProperty() {
		return this.minimumWidth;
	}

	/**
	 * Set a vertical alignment
	 * 
	 * @param value
	 *            the new alignment
	 */
	public void setVerticalAlignment(Alignment value) {
		verticalAlignmentProperty().set(value);
	}

	/**
	 * @return the current vertical alignment
	 */
	public Alignment getVerticalAlignment() {
		return verticalAlignmentProperty().get();
	}

	/**
	 * @return the vertical alignment property
	 */
	public ObjectProperty<Alignment> verticalAlignmentProperty() {
		return this.verticalAlignment;
	}

	/**
	 * Set a vertical indent
	 * 
	 * @param value
	 *            the indent
	 */
	public void setVerticalIndent(int value) {
		verticalIndentProperty().set(value);
	}

	/**
	 * @return The current vertical indent
	 */
	public int getVerticalIndent() {
		return verticalIndentProperty().get();
	}

	/**
	 * @return the vertical indent property
	 */
	public IntegerProperty verticalIndentProperty() {
		return this.verticalIndent;
	}

	/**
	 * Set the vertical span
	 * 
	 * @param value
	 *            the new vertical span
	 */
	public void setVerticalSpan(int value) {
		verticalSpanProperty().set(value);
	}

	/**
	 * @return the current vertical span
	 */
	public int getVerticalSpan() {
		return verticalSpanProperty().get();
	}

	/**
	 * @return the vertical span property
	 */
	public IntegerProperty verticalSpanProperty() {
		return this.verticalSpan;
	}

	/**
	 * Set the width hint
	 * 
	 * @param value
	 *            the width hint or {@link AbstractLayoutPane#FX_DEFAULT}
	 */
	public void setWidthHint(int value) {
		widthHintProperty().set(value);
	}

	/**
	 * @return the current width hint
	 */
	public int getWidthHint() {
		return widthHintProperty().get();
	}

	/**
	 * @return the width hint property
	 */
	public IntegerProperty widthHintProperty() {
		return this.widthHint;
	}

	/**
	 * Returns a string containing a concise, human-readable description of the
	 * receiver.
	 * 
	 * @return a string representation of the GridData object
	 */
	@Override
	public String toString() {
		String hAlign = ""; //$NON-NLS-1$
		switch (this.getHorizontalAlignment()) {
		case FILL:
			hAlign = "SWT.FILL"; //$NON-NLS-1$
			break;
		case BEGINNING:
			hAlign = "SWT.BEGINNING"; //$NON-NLS-1$
			break;
		case END:
			hAlign = "GridData.END"; //$NON-NLS-1$
			break;
		case CENTER:
			hAlign = "GridData.CENTER"; //$NON-NLS-1$
			break;
		default:
			hAlign = "Undefined " + getHorizontalAlignment(); //$NON-NLS-1$
			break;
		}

		String vAlign = ""; //$NON-NLS-1$
		switch (this.getVerticalAlignment()) {
		case FILL:
			vAlign = "SWT.FILL"; //$NON-NLS-1$
			break;
		case BEGINNING:
			vAlign = "SWT.BEGINNING"; //$NON-NLS-1$
			break;
		case END:
			vAlign = "SWT.END"; //$NON-NLS-1$
			break;
		case CENTER:
			vAlign = "SWT.CENTER"; //$NON-NLS-1$
			break;
		default:
			vAlign = "Undefined " + getVerticalAlignment(); //$NON-NLS-1$
			break;
		}

		String string = getName() + " {"; //$NON-NLS-1$
		string += "horizontalAlignment=" + hAlign + " ";  //$NON-NLS-1$//$NON-NLS-2$
		if (getHorizontalIndent() != 0)
			string += "horizontalIndent=" + getHorizontalIndent() + " ";  //$NON-NLS-1$//$NON-NLS-2$
		if (getHorizontalSpan() != 1)
			string += "horizontalSpan=" + getHorizontalSpan() + " ";  //$NON-NLS-1$//$NON-NLS-2$
		if (isGrabExcessHorizontalSpace())
			string += "grabExcessHorizontalSpace=" + isGrabExcessHorizontalSpace() + " "; //$NON-NLS-1$ //$NON-NLS-2$
		if (getWidthHint() != FX_DEFAULT)
			string += "widthHint=" + getWidthHint() + " "; //$NON-NLS-1$ //$NON-NLS-2$
		if (getMinimumWidth() != 0)
			string += "minimumWidth=" + getMinimumWidth() + " "; //$NON-NLS-1$ //$NON-NLS-2$
		string += "verticalAlignment=" + vAlign + " "; //$NON-NLS-1$ //$NON-NLS-2$
		if (getVerticalIndent() != 0)
			string += "verticalIndent=" + getVerticalIndent() + " ";  //$NON-NLS-1$//$NON-NLS-2$
		if (getVerticalSpan() != 1)
			string += "verticalSpan=" + getVerticalSpan() + " ";  //$NON-NLS-1$//$NON-NLS-2$
		if (isGrabExcessVerticalSpace())
			string += "grabExcessVerticalSpace=" + isGrabExcessVerticalSpace() + " "; //$NON-NLS-1$ //$NON-NLS-2$
		if (getHeightHint() != FX_DEFAULT)
			string += "heightHint=" + getHeightHint() + " "; //$NON-NLS-1$ //$NON-NLS-2$
		if (getMinimumHeight() != 0)
			string += "minimumHeight=" + getMinimumHeight() + " "; //$NON-NLS-1$ //$NON-NLS-2$
		if (isExclude())
			string += "exclude=" + isExclude() + " "; //$NON-NLS-1$ //$NON-NLS-2$
		string = string.trim();
		string += "}"; //$NON-NLS-1$
		return string;
	}

}
/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext;

import javafx.scene.paint.Color;

/**
 * <code>StyleRange</code> defines a set of styles for a specified range of
 * text.
 * <p>
 * The hashCode() method in this class uses the values of the public fields to
 * compute the hash value. When storing instances of the class in hashed
 * collections, do not modify these fields after the object has been inserted.
 * </p>
 * <p>
 * 
 * <b>This is an experimental component provided as a preview we'll improve and
 * fix problems in up coming releases</b>
 * </p>
 * @noreference
 */
public class StyleRange extends TextStyle implements Cloneable {
	/**
	 * The font style constant indicating a normal weight, non-italic font
	 * (value is 0). This constant is also used with <code>ProgressBar</code> to
	 * indicate a normal state.
	 * <b>Used By:</b>
	 * <ul>
	 * <li><code>ProgressBar</code></li>
	 * </ul>
	 */
	public static final int NORMAL = 0;

	/**
	 * The font style constant indicating a bold weight font (value is
	 * 1&lt;&lt;0).
	 */
	public static final int BOLD = 1 << 0;

	/**
	 * The font style constant indicating an italic font (value is 1&lt;&lt;1).
	 */
	public static final int ITALIC = 1 << 1;

	/**
	 * the start offset of the range, zero-based from the document start
	 */
	public int start;

	/**
	 * the length of the range
	 */
	public int length;

	/**
	 * the font style of the range. It may be a combination of SWT.NORMAL,
	 * SWT.ITALIC or SWT.BOLD
	 *
	 * Note: the font style is not used if the <code>font</code> attribute is
	 * set
	 */
	public int fontStyle = NORMAL;

	/**
	 * Create a new style range with no styles
	 *
	 * @param stylename
	 *            the css stylename
	 *
	 * @since 3.2
	 */
	public StyleRange(String stylename) {
		super(stylename);
	}

	/**
	 * Create a new style range from an existing text style.
	 *
	 * @param style
	 *            the text style to copy
	 *
	 * @since 3.4
	 */
	public StyleRange(TextStyle style) {
		super(style);
	}

	/**
	 * Create a new style range.
	 *
	 * @param stylename
	 *            the css stylename
	 *
	 * @param start
	 *            start offset of the style
	 * @param length
	 *            length of the style
	 * @param foreground
	 *            foreground color of the style, null if none
	 * @param background
	 *            background color of the style, null if none
	 */
	public StyleRange(String stylename, int start, int length,
			Color foreground, Color background) {
		super(stylename, null, foreground, background);
		this.start = start;
		this.length = length;
	}

	/**
	 * Create a new style range.
	 *
	 * @param stylename
	 *            the css stylename
	 *
	 * @param start
	 *            start offset of the style
	 * @param length
	 *            length of the style
	 * @param foreground
	 *            foreground color of the style, null if none
	 * @param background
	 *            background color of the style, null if none
	 * @param fontStyle
	 *            font style of the style, may be SWT.NORMAL, SWT.ITALIC or
	 *            SWT.BOLD
	 */
	public StyleRange(String stylename, int start, int length,
			Color foreground, Color background, int fontStyle) {
		this(stylename, start, length, foreground, background);
		this.fontStyle = fontStyle;
	}

	/**
	 * Compares the argument to the receiver, and returns true if they represent
	 * the <em>same</em> object using a class specific comparison.
	 *
	 * @param object
	 *            the object to compare with this object
	 * @return <code>true</code> if the object is the same as this object and
	 *         <code>false</code> otherwise
	 *
	 * @see #hashCode()
	 */
	@Override
	public boolean equals(Object object) {
		if (object == this)
			return true;
		if (object instanceof StyleRange) {
			StyleRange style = (StyleRange) object;
			if (this.start != style.start)
				return false;
			if (this.length != style.length)
				return false;
			return similarTo(style);
		}
		return false;
	}

	/**
	 * Returns an integer hash code for the receiver. Any two objects that
	 * return <code>true</code> when passed to <code>equals</code> must return
	 * the same value for this method.
	 *
	 * @return the receiver's hash
	 *
	 * @see #equals(Object)
	 */
	@Override
	public int hashCode() {
		return super.hashCode() ^ this.fontStyle;
	}

	boolean isVariableHeight() {
		return this.font != null /* || metrics != null */|| this.rise != 0;
	}

	/**
	 * Returns whether or not the receiver is unstyled (i.e., does not have any
	 * style attributes specified).
	 *
	 * @return true if the receiver is unstyled, false otherwise.
	 */
	public boolean isUnstyled() {
		if (this.font != null)
			return false;
		if (this.rise != 0)
			return false;
		// if (metrics != null) return false;
		if (this.stylename != null)
			return false;
		if (this.foreground != null)
			return false;
		if (this.background != null)
			return false;
		if (this.fontStyle != NORMAL)
			return false;
		if (this.underline)
			return false;
		if (this.strikeout)
			return false;
		if (this.borderStyle != NONE)
			return false;
		return true;
	}

	/**
	 * Compares the specified object to this StyleRange and answer if the two
	 * are similar. The object must be an instance of StyleRange and have the
	 * same field values for except for start and length.
	 *
	 * @param style
	 *            the object to compare with this object
	 * @return true if the objects are similar, false otherwise
	 */
	public boolean similarTo(StyleRange style) {
		if (!super.equals(style))
			return false;
		if (this.fontStyle != style.fontStyle)
			return false;
		return true;
	}

	/**
	 * Returns a new StyleRange with the same values as this StyleRange.
	 *
	 * @return a shallow copy of this StyleRange
	 */
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	/**
	 * Returns a string containing a concise, human-readable description of the
	 * receiver.
	 *
	 * @return a string representation of the StyleRange
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("StyleRange {"); //$NON-NLS-1$
		buffer.append(this.start);
		buffer.append(", "); //$NON-NLS-1$
		buffer.append(this.length);
		buffer.append(", fontStyle="); //$NON-NLS-1$
		switch (this.fontStyle) {
		case BOLD:
			buffer.append("bold"); //$NON-NLS-1$
			break;
		case ITALIC:
			buffer.append("italic"); //$NON-NLS-1$
			break;
		case BOLD | ITALIC:
			buffer.append("bold-italic"); //$NON-NLS-1$
			break;
		default:
			buffer.append("normal"); //$NON-NLS-1$
		}
		String str = super.toString();
		int index = str.indexOf('{');
		str = str.substring(index + 1);
		if (str.length() > 1)
			buffer.append(", "); //$NON-NLS-1$
		buffer.append(str);
		return buffer.toString();
	}
}

/*******************************************************************************
 * Copyright (c) 2000, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext_ng;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * <code>TextStyle</code> defines a set of styles that can be applied to a range
 * of text.
 * <p>
 * The hashCode() method in this class uses the values of the public fields to
 * compute the hash value. When storing instances of the class in hashed
 * collections, do not modify these fields after the object has been inserted.
 * </p>
 * <p>
 * Application code does <em>not</em> need to explicitly release the resources
 * managed by each instance when those instances are no longer required, and
 * thus no <code>dispose()</code> method is provided.
 * </p>
 *
 * <b>This is an experimental component provided as a preview we'll improve and
 * fix problems in up coming releases</b>
 * </p>
 * 
 * @noreference
 */
public class TextStyle {
	/**
	 * No styling
	 */
	public static final int NONE = 0;

	/**
	 * Style constant to indicate single underline (value is 0).
	 * <p>
	 * <b>Used By:</b>
	 * </p>
	 * <ul>
	 * <li><code>TextStyle</code></li>
	 * </ul>
	 *
	 * @since 3.4
	 */
	public static final int UNDERLINE_SINGLE = 0;

	/**
	 * Style constant to indicate double underline (value is 1).
	 * <p>
	 * <b>Used By:</b>
	 * </p>
	 * <ul>
	 * <li><code>TextStyle</code></li>
	 * </ul>
	 *
	 * @since 3.4
	 */
	public static final int UNDERLINE_DOUBLE = 1;

	/**
	 * Style constant to indicate error underline (value is 2).
	 * <p>
	 * <b>Used By:</b>
	 * </p>
	 * <ul>
	 * <li><code>TextStyle</code></li>
	 * </ul>
	 *
	 * @since 3.4
	 */
	public static final int UNDERLINE_ERROR = 2;

	/**
	 * Style constant to indicate squiggle underline (value is 3).
	 * <p>
	 * <b>Used By:</b>
	 * </p>
	 * <ul>
	 * <li><code>TextStyle</code></li>
	 * </ul>
	 *
	 * @since 3.4
	 */
	public static final int UNDERLINE_SQUIGGLE = 3;

	/**
	 * Style constant to indicate link underline (value is 0).
	 * <p>
	 * If the text color or the underline color are not set in the range the
	 * usage of <code>UNDERLINE_LINK</code> will change these colors to the
	 * preferred link color of the platform.<br>
	 * Note that clients that use this style, such as <code>StyledText</code>,
	 * will include code to track the mouse and change the cursor to the hand
	 * cursor when mouse is over the link.
	 * </p>
	 * <p>
	 * <b>Used By:</b>
	 * </p>
	 * <ul>
	 * <li><code>TextStyle</code></li>
	 * </ul>
	 *
	 * @since 3.5
	 */
	public static final int UNDERLINE_LINK = 4;

	/**
	 * Style constant to indicate solid border (value is 1).
	 * <p>
	 * <b>Used By:</b>
	 * </p>
	 * <ul>
	 * <li><code>TextStyle</code></li>
	 * </ul>
	 *
	 * @since 3.4
	 */
	public static final int BORDER_SOLID = 1;

	/**
	 * Style constant to indicate dashed border (value is 2).
	 * <p>
	 * <b>Used By:</b>
	 * </p>
	 * <ul>
	 * <li><code>TextStyle</code></li>
	 * </ul>
	 *
	 * @since 3.4
	 */
	public static final int BORDER_DASH = 2;

	/**
	 * Style constant to indicate dotted border (value is 4).
	 * <p>
	 * <b>Used By:</b>
	 * </p>
	 * <ul>
	 * <li><code>TextStyle</code></li>
	 * </ul>
	 *
	 * @since 3.4
	 */
	public static final int BORDER_DOT = 4;

	/**
	 * the font of the style
	 */
	public Font font;

	/**
	 * the foreground of the style
	 */
	public Color foreground;

	/**
	 * the background of the style
	 */
	public Color background;

	/**
	 * the underline flag of the style. The default underline style is
	 * <code>TextStyle.UNDERLINE_SINGLE</code>.
	 *
	 *
	 * @since 3.1
	 */
	public boolean underline;

	/**
	 * the underline color of the style
	 *
	 * @since 3.4
	 */
	public Color underlineColor;

	/**
	 * the underline style. This style is ignored when <code>underline</code> is
	 * false.
	 *
	 * @see TextStyle#UNDERLINE_SINGLE
	 * @see TextStyle#UNDERLINE_DOUBLE
	 * @see TextStyle#UNDERLINE_ERROR
	 * @see TextStyle#UNDERLINE_SQUIGGLE
	 * @see TextStyle#UNDERLINE_LINK
	 *
	 * @since 3.4
	 */
	public int underlineStyle;

	/**
	 * the strikeout flag of the style
	 *
	 * @since 3.1
	 */
	public boolean strikeout;

	/**
	 * the strikeout color of the style
	 *
	 * @since 3.4
	 */
	public Color strikeoutColor;

	/**
	 * the border style. The default border style is <code>SWT.NONE</code>.
	 * <p>
	 * This value should be one of <code>SWT.BORDER_SOLID</code>,
	 * <code>SWT.BORDER_DASH</code>,<code>SWT.BORDER_DOT</code> or
	 * <code>SWT.NONE</code>.
	 * </p>
	 *
	 * @since 3.4
	 */
	public int borderStyle;

	/**
	 * the border color of the style
	 *
	 * @since 3.4
	 */
	public Color borderColor;

	// /**
	// * the GlyphMetrics of the style
	// *
	// * @since 3.2
	// */
	// public GlyphMetrics metrics;

	/**
	 * the baseline rise of the style.
	 *
	 * @since 3.2
	 */
	public int rise;

	/**
	 * the data. An user data field. It can be used to hold the HREF when the
	 * range is used as a link or the embed object when the range is used with
	 * <code>GlyphMetrics</code>.
	 *
	 * @since 3.5
	 */
	public Object data;

	/**
	 * The css stylename to use
	 */
	public String stylename;

	/**
	 *
	 */
	public List<String> decorationStyleClasses;

	/**
	 * The style named to used for hovering
	 */
	public String hoverStylename;

	/**
	 * Create an empty text style.
	 *
	 * @param stylename
	 *            the css stylename
	 *
	 * @since 3.4
	 */
	public TextStyle(String stylename) {
		this.stylename = stylename;
	}

//	/**
//	 * Add a decoration class
//	 * 
//	 * @param styleClass
//	 *            the style class for the decorator
//	 */
//	public void addStyleClass(String styleClass) {
//		if (this.decorationStyleClasses == null) {
//			this.decorationStyleClasses = new ArrayList<>();
//		}
//		this.decorationStyleClasses.add(styleClass);
//	}

	/**
	 * Create a new text style with the specified font, foreground and
	 * background.
	 *
	 * @param stylename
	 *            the css stylename
	 *
	 * @param font
	 *            the font of the style, <code>null</code> if none
	 * @param foreground
	 *            the foreground color of the style, <code>null</code> if none
	 * @param background
	 *            the background color of the style, <code>null</code> if none
	 */
	public TextStyle(String stylename, Font font, Color foreground, Color background) {
		// if (font != null && font.isDisposed()) SWT.error
		// (SWT.ERROR_INVALID_ARGUMENT);
		// if (foreground != null && foreground.isDisposed()) SWT.error
		// (SWT.ERROR_INVALID_ARGUMENT);
		// if (background != null && background.isDisposed()) SWT.error
		// (SWT.ERROR_INVALID_ARGUMENT);
		this.stylename = stylename;
		this.font = font;
		this.foreground = foreground;
		this.background = background;
	}

	/**
	 * Create a new text style from an existing text style.
	 *
	 * @param style
	 *            the style to copy
	 *
	 * @since 3.4
	 */
	public TextStyle(TextStyle style) {
		if (style == null)
			throw new IllegalStateException();
		this.stylename = style.stylename;
		this.decorationStyleClasses = this.decorationStyleClasses == null ? null : new ArrayList<>(style.decorationStyleClasses);
		this.font = style.font;
		this.foreground = style.foreground;
		this.background = style.background;
		this.underline = style.underline;
		this.underlineColor = style.underlineColor;
		this.underlineStyle = style.underlineStyle;
		this.strikeout = style.strikeout;
		this.strikeoutColor = style.strikeoutColor;
		this.borderStyle = style.borderStyle;
		this.borderColor = style.borderColor;
		// metrics = style.metrics;
		this.rise = style.rise;
		this.data = style.data;
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
		if (object == null)
			return false;
		if (!(object instanceof TextStyle))
			return false;
		TextStyle style = (TextStyle) object;

		if (this.stylename != null) {
			if (!this.stylename.equals(style.stylename))
				return false;
		} else if (style.stylename != null) {
			return false;
		}

		if (this.foreground != null) {
			if (!this.foreground.equals(style.foreground))
				return false;
		} else if (style.foreground != null)
			return false;
		if (this.background != null) {
			if (!this.background.equals(style.background))
				return false;
		} else if (style.background != null)
			return false;
		if (this.font != null) {
			if (!this.font.equals(style.font))
				return false;
		} else if (style.font != null)
			return false;
		// if (metrics != null || style.metrics != null) return false;
		if (this.underline != style.underline)
			return false;
		if (this.underlineStyle != style.underlineStyle)
			return false;
		if (this.borderStyle != style.borderStyle)
			return false;
		if (this.strikeout != style.strikeout)
			return false;
		if (this.rise != style.rise)
			return false;
		if (this.underlineColor != null) {
			if (!this.underlineColor.equals(style.underlineColor))
				return false;
		} else if (style.underlineColor != null)
			return false;
		if (this.strikeoutColor != null) {
			if (!this.strikeoutColor.equals(style.strikeoutColor))
				return false;
		} else if (style.strikeoutColor != null)
			return false;
		if (this.underlineStyle != style.underlineStyle)
			return false;
		if (this.borderColor != null) {
			if (!this.borderColor.equals(style.borderColor))
				return false;
		} else if (style.borderColor != null)
			return false;
		if (this.data != null) {
			if (!this.data.equals(style.data))
				return false;
		} else if (style.data != null)
			return false;
		return true;
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
		int hash = 0;
		if (this.stylename != null)
			hash ^= this.stylename.hashCode();
		if (this.foreground != null)
			hash ^= this.foreground.hashCode();
		if (this.background != null)
			hash ^= this.background.hashCode();
		if (this.font != null)
			hash ^= this.font.hashCode();
		// if (metrics != null) hash ^= metrics.hashCode();
		if (this.underline)
			hash ^= (hash << 1);
		if (this.strikeout)
			hash ^= (hash << 2);
		hash ^= this.rise;
		if (this.underlineColor != null)
			hash ^= this.underlineColor.hashCode();
		if (this.strikeoutColor != null)
			hash ^= this.strikeoutColor.hashCode();
		if (this.borderColor != null)
			hash ^= this.borderColor.hashCode();
		hash ^= this.underlineStyle;
		return hash;
	}

	boolean isAdherentBorder(TextStyle style) {
		if (this == style)
			return true;
		if (style == null)
			return false;
		if (this.borderStyle != style.borderStyle)
			return false;
		if (this.borderColor != null) {
			if (!this.borderColor.equals(style.borderColor))
				return false;
		} else {
			if (style.borderColor != null)
				return false;
			if (this.foreground != null) {
				if (!this.foreground.equals(style.foreground))
					return false;
			} else if (style.foreground != null)
				return false;
		}
		return true;
	}

	boolean isAdherentUnderline(TextStyle style) {
		if (this == style)
			return true;
		if (style == null)
			return false;
		if (this.underline != style.underline)
			return false;
		if (this.underlineStyle != style.underlineStyle)
			return false;
		if (this.underlineColor != null) {
			if (!this.underlineColor.equals(style.underlineColor))
				return false;
		} else {
			if (style.underlineColor != null)
				return false;
			if (this.foreground != null) {
				if (!this.foreground.equals(style.foreground))
					return false;
			} else if (style.foreground != null)
				return false;
		}
		return true;
	}

	boolean isAdherentStrikeout(TextStyle style) {
		if (this == style)
			return true;
		if (style == null)
			return false;
		if (this.strikeout != style.strikeout)
			return false;
		if (this.strikeoutColor != null) {
			if (!this.strikeoutColor.equals(style.strikeoutColor))
				return false;
		} else {
			if (style.strikeoutColor != null)
				return false;
			if (this.foreground != null) {
				if (!this.foreground.equals(style.foreground))
					return false;
			} else if (style.foreground != null)
				return false;
		}
		return true;
	}

	/**
	 * Returns a string containing a concise, human-readable description of the
	 * receiver.
	 *
	 * @return a string representation of the <code>TextStyle</code>
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("TextStyle {"); //$NON-NLS-1$
		int startLength = buffer.length();
		if (this.stylename != null) {
			if (buffer.length() > startLength)
				buffer.append(", "); //$NON-NLS-1$
			buffer.append("stylename="); //$NON-NLS-1$
			buffer.append(this.stylename);
		}
		if (this.font != null) {
			if (buffer.length() > startLength)
				buffer.append(", "); //$NON-NLS-1$
			buffer.append("font="); //$NON-NLS-1$
			buffer.append(this.font);
		}
		if (this.foreground != null) {
			if (buffer.length() > startLength)
				buffer.append(", "); //$NON-NLS-1$
			buffer.append("foreground="); //$NON-NLS-1$
			buffer.append(this.foreground);
		}
		if (this.background != null) {
			if (buffer.length() > startLength)
				buffer.append(", "); //$NON-NLS-1$
			buffer.append("background="); //$NON-NLS-1$
			buffer.append(this.background);
		}
		if (this.underline) {
			if (buffer.length() > startLength)
				buffer.append(", "); //$NON-NLS-1$
			buffer.append("underline="); //$NON-NLS-1$
			switch (this.underlineStyle) {
			case UNDERLINE_SINGLE:
				buffer.append("single"); //$NON-NLS-1$
				break;
			case UNDERLINE_DOUBLE:
				buffer.append("double"); //$NON-NLS-1$
				break;
			case UNDERLINE_SQUIGGLE:
				buffer.append("squiggle"); //$NON-NLS-1$
				break;
			case UNDERLINE_ERROR:
				buffer.append("error"); //$NON-NLS-1$
				break;
			case UNDERLINE_LINK:
				buffer.append("link"); //$NON-NLS-1$
				break;
			}
			if (this.underlineColor != null) {
				buffer.append(", underlineColor="); //$NON-NLS-1$
				buffer.append(this.underlineColor);
			}
		}
		if (this.strikeout) {
			if (buffer.length() > startLength)
				buffer.append(", "); //$NON-NLS-1$
			buffer.append("striked out"); //$NON-NLS-1$
			if (this.strikeoutColor != null) {
				buffer.append(", strikeoutColor="); //$NON-NLS-1$
				buffer.append(this.strikeoutColor);
			}
		}
		if (this.borderStyle != NONE) {
			if (buffer.length() > startLength)
				buffer.append(", "); //$NON-NLS-1$
			buffer.append("border="); //$NON-NLS-1$
			switch (this.borderStyle) {
			case BORDER_SOLID:
				buffer.append("solid"); //$NON-NLS-1$
				break;
			case BORDER_DOT:
				buffer.append("dot"); //$NON-NLS-1$
				break;
			case BORDER_DASH:
				buffer.append("dash"); //$NON-NLS-1$
				break;
			}
			if (this.borderColor != null) {
				buffer.append(", borderColor="); //$NON-NLS-1$
				buffer.append(this.borderColor);
			}
		}
		if (this.rise != 0) {
			if (buffer.length() > startLength)
				buffer.append(", "); //$NON-NLS-1$
			buffer.append("rise="); //$NON-NLS-1$
			buffer.append(this.rise);
		}
		// if (metrics != null) {
		// if (buffer.length() > startLength) buffer.append(", "); //$NON-NLS-1$
		// buffer.append("metrics="); //$NON-NLS-1$
		// buffer.append(metrics);
		// }
		buffer.append("}"); //$NON-NLS-1$
		return buffer.toString();
	}

}

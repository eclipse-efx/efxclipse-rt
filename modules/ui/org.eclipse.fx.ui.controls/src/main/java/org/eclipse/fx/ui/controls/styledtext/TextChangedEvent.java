/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext;

/**
 * Event sent when text has changed
 * <p>
 * <b>This is an experimental component provided as a preview we'll improve and
 * fix problems in up coming releases</b>
 * </p>
 *
 * @noreference
 */
public class TextChangedEvent {

	/**
	 * The source
	 */
	public final StyledTextContent source;

	/**
	 * The offset
	 */
	public final int offset;
	/**
	 * The number of replaced chars
	 */
	public final int replaceCharCount;
	/**
	 * The number of replaced lines
	 */
	public final int replaceLineCount;
	/**
	 * The new text
	 */
	public final String newText;
	/**
	 * The new char count
	 */
	public final int newCharCount;
	/**
	 * The new line count
	 */
	public final int newLineCount;

	private TextChangedEvent(StyledTextContent source, int offset, int replaceCharCount, int replaceLineCount, String newText, int newCharCount, int newLineCount) {
		this.source = source;
		this.offset = offset;
		this.replaceCharCount = replaceCharCount;
		this.replaceLineCount = replaceLineCount;
		this.newText = newText;
		this.newCharCount = newCharCount;
		this.newLineCount = newLineCount;
	}

	/**
	 * Create a text changed event
	 *
	 * @param source
	 *            the source
	 * @return the event
	 */
	public static TextChangedEvent textChanged(StyledTextContent source) {
		return new TextChangedEvent(source, 0, 0, 0, null, 0, 0);
	}

	/**
	 * Create a text changed event
	 *
	 * @param source
	 *            the source
	 * @param offset
	 *            the offset
	 * @param replaceLength
	 *            the replacement length
	 * @param newText
	 *            the new text
	 * @return the event
	 * @since 2.3.0
	 */
	public static TextChangedEvent textChanged(StyledTextContent source, int offset, int replaceLength, String newText) {
		return new TextChangedEvent(source, offset, replaceLength, -1, newText, newText.length(), -1);
	}

	/**
	 * Create the text set event
	 *
	 * @param source
	 *            the source
	 * @return the event
	 */
	public static TextChangedEvent textSet(StyledTextContent source) {
		return new TextChangedEvent(source, 0, 0, 0, null, 0, 0);
	}

	@Override
	public String toString() {
		return "TextChangedEvent(offset=" + this.offset + ", replaceCharCount=" + this.replaceCharCount + ", replaceText=" + (this.newText == null ? "null" : "\"" + this.newText + "\"") + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
	}

}

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
 * Event informing about text changing
 *
 * <b>This is an experimental component provided as a preview we'll improve and
 * fix problems in up coming releases</b>
 * </p>
 * @noreference
 */
public class TextChangingEvent {

	/**
	 * The source
	 */
	public final StyledTextContent source;

	/**
	 * The offset
	 */
	public int offset;
	/**
	 * The number of replaced chars
	 */
	public int replaceCharCount;
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

	private TextChangingEvent(StyledTextContent source, int offset, int replaceCharCount, int replaceLineCount, String newText, int newCharCount, int newLineCount) {
		this.source = source;
		this.offset = offset;
		this.replaceCharCount = replaceCharCount;
		this.replaceLineCount = replaceLineCount;
		this.newText = newText;
		this.newCharCount = newCharCount;
		this.newLineCount = newLineCount;
	}

	/**
	 * Create a new event
	 *
	 * @param source
	 *            the source
	 * @param offset
	 *            the offset
	 * @param replaceCharCount
	 *            the number of replaced chars
	 * @param replaceLineCount
	 *            the number of replaced lines
	 * @param newText
	 *            the new text
	 * @param newCharCount
	 *            the new char count
	 * @param newLineCount
	 *            the new line count
	 * @return the event
	 */
	public static TextChangingEvent textChanging(StyledTextContent source, int offset, int replaceCharCount, int replaceLineCount, String newText, int newCharCount, int newLineCount) {
		return new TextChangingEvent(source, offset, replaceCharCount, replaceLineCount, newText, newCharCount, newLineCount);
	}

	@Override
	public String toString() {
		return "TextChangingEvent(offset="+this.offset+", replaceCharCount="+this.replaceCharCount+", replaceText=" + (this.newText == null ? "null" : "\""+this.newText+"\"") + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
	}
}

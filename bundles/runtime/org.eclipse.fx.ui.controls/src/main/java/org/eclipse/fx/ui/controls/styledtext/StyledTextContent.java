/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext;

import org.eclipse.fx.core.text.TextUtil.IterableCharSequence;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Content of the styled text area
 *
 * <b>This is an experimental component provided as a preview we'll improve and
 * fix problems in up coming releases</b>
 * </p>
 * @noreference
 */
public interface StyledTextContent extends IterableCharSequence {
	/**
	 * Get the content of the line with the given index
	 *
	 * @param index
	 *            the index
	 * @return the line content
	 */
	public @NonNull String getLine(int index);

	/**
	 * Get the content for the given range
	 *
	 * @param start
	 *            the start
	 * @param length
	 *            the length
	 * @return the content
	 */
	public @NonNull String getTextRange(int start, int length);

	/**
	 * Set a new text content
	 *
	 * @param text
	 *            the text
	 */
	public void setText(@NonNull String text);

	/**
	 * @return number of chars
	 */
	public int getCharCount();

	/**
	 * @return number of lines
	 */
	public int getLineCount();

	/**
	 * Get the offset of the line
	 *
	 * @param lineIndex
	 *            the line index
	 * @return the offset
	 */
	public int getOffsetAtLine(int lineIndex);

	/**
	 * Get the line index for the char
	 *
	 * @param charPosition
	 *            the char position
	 * @return the line index
	 */
	public int getLineAtOffset(int charPosition);

	/**
	 * Replace the content in range
	 *
	 * @param start
	 *            the start
	 * @param replaceLength
	 *            the replaced length
	 * @param newText
	 *            the new text
	 */
	public void replaceTextRange(int start, int replaceLength, @NonNull String newText);

	/**
	 * Attach a change listener
	 *
	 * @param listener
	 *            the listener
	 */
	public void addTextChangeListener(TextChangeListener listener);

	/**
	 * Remove a change listener
	 *
	 * @param listener
	 *            the listener
	 */
	public void removeTextChangeListener(TextChangeListener listener);

	/**
	 * Listener informed above modifications
	 */
	public interface TextChangeListener {
		/**
		 * Called after the text has changed
		 *
		 * @param event
		 *            the event
		 */
		public void textChanged(TextChangedEvent event);

		/**
		 * Called after the text has been set
		 *
		 * @param event
		 *            the event
		 */
		public void textSet(TextChangedEvent event);

		/**
		 * Called when the text is changing
		 *
		 * @param event
		 *            the event
		 */
		public void textChanging(TextChangingEvent event);
	}

	@Override
	public default int length() {
		return getCharCount();
	}

	@Override
	public default char charAt(int index) {
		return getTextRange(index, 1).charAt(0);
	}

	@Override
	public default CharSequence subSequence(int start, int end) {
		return getTextRange(start, end - start);
	}
}

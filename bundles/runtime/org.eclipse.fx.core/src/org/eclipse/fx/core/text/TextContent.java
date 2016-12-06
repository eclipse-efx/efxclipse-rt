package org.eclipse.fx.core.text;

import org.eclipse.jdt.annotation.NonNull;

public interface TextContent {
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
}

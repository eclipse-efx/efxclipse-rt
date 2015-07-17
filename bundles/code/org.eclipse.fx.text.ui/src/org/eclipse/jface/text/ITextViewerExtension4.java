package org.eclipse.jface.text;

public interface ITextViewerExtension4 {
	/**
	 * Adds the given text presentation listener to this text viewer.
	 * This call has no effect if the listener is already registered
	 * with this text viewer.
	 *
	 * @param listener the text presentation listener
	 */
	void addTextPresentationListener(ITextPresentationListener listener);

	/**
	 * Removes the given text presentation listener from this text viewer.
	 * This call has no effect if the listener is not registered with this
	 * text viewer.
	 *
	 * @param listener the text presentation listener
	 */
	void removeTextPresentationListener(ITextPresentationListener listener);
}

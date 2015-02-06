package org.eclipse.jface.text;

public interface ITextViewerExtension2 {
	/**
	 * Invalidates the viewer's text presentation for the given range.
	 *
	 * @param offset the offset of the first character to be redrawn
	 * @param length the length of the range to be redrawn
	 */
	void invalidateTextPresentation(int offset, int length);

}

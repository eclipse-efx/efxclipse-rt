/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.text.ui;

public interface ITextViewerExtension2 {
	final int DEFAULT_HOVER_STATE_MASK= 0xff;

	/**
	 * Invalidates the viewer's text presentation for the given range.
	 *
	 * @param offset the offset of the first character to be redrawn
	 * @param length the length of the range to be redrawn
	 */
	void invalidateTextPresentation(int offset, int length);

	/**
	 * Sets this viewer's text hover for the given content type and the given state mask. If the given text hover
	 * is <code>null</code>, any hover installed for the given content type and state mask is removed.
	 *
	 * @param textViewerHover the new hover or <code>null</code>
	 * @param contentType the type for which the hover is to be registered or unregistered
	 * @param stateMask the SWT event state mask; <code>DEFAULT_HOVER_STATE_MASK</code> indicates that
	 * 			the hover is installed as the default hover.
	 */
	void setTextHover(ITextHover textViewerHover, String contentType, int stateMask);

	/**
	 * Removes all text hovers for the given content type independent from their state mask.
	 * <p>
	 * Note: To remove a hover for a given content type and state mask
	 * use {@link #setTextHover(ITextHover, String, int)} with <code>null</code>
	 * as parameter for the text hover.
	 * </p>
	 * @param contentType the type for which all text hovers are to be unregistered
	 */
	void removeTextHovers(String contentType);

//	/**
//	 * Returns the currently displayed text hover if any, <code>null</code> otherwise.
//	 *
//	 * @return the currently displayed text hover or <code>null</code>
//	 */
//	ITextHover getCurrentTextHover();

}

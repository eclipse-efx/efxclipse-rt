/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.text.ui;

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

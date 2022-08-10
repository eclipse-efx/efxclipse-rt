/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
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
package org.eclipse.fx.text.ui.contentassist;

import org.eclipse.fx.text.ui.ITextViewer;

/**
 * A context information validator is used to determine if a displayed context
 * information is still valid or should be dismissed.
 * <p>
 * The interface can be implemented by clients.
 * </p>
 *
 * @see IContextInformationPresenter
 */
public interface IContextInformationValidator {

	/**
	 * Installs this validator for the given context information.
	 *
	 * @param info
	 *            the context information which this validator should check
	 * @param viewer
	 *            the text viewer on which the information is presented
	 * @param offset
	 *            the document offset for which the information has been
	 *            computed
	 */
	void install(IContextInformation info, ITextViewer viewer, int offset);

	/**
	 * Returns whether the information this validator is installed on is still
	 * valid at the given document position.
	 *
	 * @param offset
	 *            the current offset within the document
	 * @return <code>true</code> if the information also valid at the given
	 *         document position
	 */
	boolean isContextInformationValid(int offset);

	/**
	 * Retrieve the new display string after validation has succeeded
	 *
	 * @param offset
	 *            the offset
	 * @return the charsequence
	 */
	default CharSequence getInformationDisplayString(int offset) {
		return null;
	}
}

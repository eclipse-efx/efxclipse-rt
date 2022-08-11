/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.text;

/**
 * {@link TextEditAction} constants for source editing
 *
 */
public enum SourceTextEditActions implements TextEditAction {

	/**
	 * Action triggered on autocomplete
	 */
	PROPOSAL_REQUEST(true),

	/**
	 * Action to increase font zoom
	 */
	FONT_ZOOM_IN(false),
	/**
	 * Action to decrease font zoom
	 */
	FONT_ZOOM_OUT(false),
	/**
	 * Action to reset font zoom
	 */
	FONT_ZOOM_RESET(false);


	private boolean modification;

	private SourceTextEditActions(boolean modification) {
		this.modification = modification;
	}

	@Override
	public boolean isModification() {
		return this.modification;
	}
}
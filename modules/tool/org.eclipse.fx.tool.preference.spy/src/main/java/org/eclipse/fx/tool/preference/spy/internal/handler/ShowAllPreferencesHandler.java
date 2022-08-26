/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Thomas Fahrmeyer (lauritziu_ii@yahoo.de) - initial API and implementation
*/
package org.eclipse.fx.tool.preference.spy.internal.handler;

import org.eclipse.fx.tool.preference.spy.internal.model.PreferenceSpyViewModel;
import org.eclipse.e4.core.di.annotations.Execute;

/**
 * Handler for command collapse all 
 */
public class ShowAllPreferencesHandler {

	/**
	 * delegates the task to the preference spy model
	 * 
	 * @param preferenceSpyViewModel
	 */
	@Execute
	public void execute(PreferenceSpyViewModel preferenceSpyViewModel ) {
		preferenceSpyViewModel.loadPreferences();
	}

}

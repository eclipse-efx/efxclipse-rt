/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

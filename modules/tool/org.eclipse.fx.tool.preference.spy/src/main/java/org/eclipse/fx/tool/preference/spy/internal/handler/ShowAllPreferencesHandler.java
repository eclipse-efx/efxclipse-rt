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
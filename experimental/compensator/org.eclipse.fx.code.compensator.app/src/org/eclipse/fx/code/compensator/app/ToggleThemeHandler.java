package org.eclipse.fx.code.compensator.app;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.fx.ui.services.theme.ThemeManager;

@SuppressWarnings("restriction")
public class ToggleThemeHandler {
	@Preference
	IEclipsePreferences preference;
	
	@Execute
	public void toggleTheme(ThemeManager manager) {
		if( "default".equals(manager.getCurrentTheme().getId())) {
			System.err.println("SETTING DARK");
			manager.setCurrentThemeId("dark");
		} else {
			System.err.println("SETTING DEFAULT");
			manager.setCurrentThemeId("default");
		}
	}
}

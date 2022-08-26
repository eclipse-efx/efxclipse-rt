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
package org.eclipse.fx.code.compensator.app;

import javax.inject.Named;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.fx.ui.services.theme.ThemeManager;

@SuppressWarnings("restriction")
public class ToggleThemeHandler {
	@Preference
	IEclipsePreferences preference;

	@Execute
	public void toggleTheme(ThemeManager manager, @Named("themeId") String themeId) {
		manager.setCurrentThemeId(themeId);
	}
}

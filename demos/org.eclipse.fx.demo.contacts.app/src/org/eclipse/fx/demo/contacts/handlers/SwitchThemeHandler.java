/*******************************************************************************
 * Copyright (c) 2010 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *     Kai T��dter - Adoption to contacts demo
 ******************************************************************************/
package org.eclipse.fx.demo.contacts.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.fx.ui.services.theme.ThemeManager;

@SuppressWarnings("restriction")
public class SwitchThemeHandler {
	@Execute
	public void switchTheme(@Named("contacts.commands.switchtheme.themeid") String themeId,
			@Optional ThemeManager themeManager) {
		if (themeManager != null) {
			themeManager.setCurrentThemeId(themeId);
		}
	}
}
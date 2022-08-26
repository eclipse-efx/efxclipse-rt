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

package org.eclipse.fx.testcases.l10n.app;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.nls.ILocaleChangeService;
import org.eclipse.e4.core.services.translation.TranslationService;

public class SwitchLang {
	@Execute
	public void execute(ILocaleChangeService s, @Named(TranslationService.LOCALE) String locale) {
		if( "en".equals(locale) ) {
			s.changeApplicationLocale("de");
		} else {
			s.changeApplicationLocale("en");
		}
	}

}
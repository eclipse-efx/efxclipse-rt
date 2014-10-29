
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
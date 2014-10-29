package org.eclipse.fx.core.di.context.internal;

import java.util.Locale;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.translation.TranslationService;
import org.eclipse.fx.core.text.LocaleProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class LocaleProviderFunction extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context) {
		return new LocaleProviderImpl(context);
	}

	static class LocaleProviderImpl implements LocaleProvider {
		private final IEclipseContext context;
		private String currentLocaleString;
		private Locale currentLocale;

		public LocaleProviderImpl(IEclipseContext context) {
			this.context = context;
		}

		@SuppressWarnings("null")
		@Override
		public Locale getLocale() {
			String l = (String) this.context.get(TranslationService.LOCALE);
			if( this.currentLocaleString == null || ! this.currentLocaleString.equals(l) ) {
				this.currentLocale = toLocale(l, Locale.getDefault());
			}
			return this.currentLocale;
		}


		private static @NonNull Locale toLocale(@Nullable String str, @NonNull Locale defaultLocale) {
			if (str == null) {
				return defaultLocale;
			}

			String language = ""; //$NON-NLS-1$
			String country = ""; //$NON-NLS-1$
			String variant = ""; //$NON-NLS-1$

			String[] localeParts = str.split("_"); //$NON-NLS-1$
			if (localeParts.length == 0 || localeParts.length > 3 || (localeParts.length == 1 && localeParts[0].length() == 0)) {
				return defaultLocale;
			} else {
				if (localeParts[0].length() == 1 || localeParts[0].length() > 2) {
					return defaultLocale;
				} else if (localeParts[0].length() == 2) {
					char ch0 = localeParts[0].charAt(0);
					char ch1 = localeParts[0].charAt(1);
					if (ch0 < 'a' || ch0 > 'z' || ch1 < 'a' || ch1 > 'z') {
						return defaultLocale;
					}
				}

				language = localeParts[0];

				if (localeParts.length > 1) {
					if (localeParts[1].length() == 1 || localeParts[1].length() > 2) {
						return new Locale(language);
					} else if (localeParts[1].length() == 2) {
						char ch3 = localeParts[1].charAt(0);
						char ch4 = localeParts[1].charAt(1);
						if (ch3 < 'A' || ch3 > 'Z' || ch4 < 'A' || ch4 > 'Z') {
							return new Locale(language);
						}
					}

					country = localeParts[1];
				}

				if (localeParts.length == 3) {
					if (localeParts[0].length() == 0 && localeParts[1].length() == 0) {
						return new Locale(language, country);
					}
					variant = localeParts[2];
				}
			}

			return new Locale(language, country, variant);
		}
	}
}

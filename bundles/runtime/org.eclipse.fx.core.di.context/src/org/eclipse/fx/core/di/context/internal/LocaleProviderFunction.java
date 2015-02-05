/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di.context.internal;

import java.util.Locale;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.translation.TranslationService;
import org.eclipse.fx.core.text.LocaleProvider;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Context function contributing a {@link LocaleProvider}
 */
public class LocaleProviderFunction extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context) {
		return new LocaleProviderImpl(context);
	}

	static class LocaleProviderImpl implements LocaleProvider {
		private final IEclipseContext context;

		public LocaleProviderImpl(IEclipseContext context) {
			this.context = context;
		}

		@SuppressWarnings("null")
		@Override
		public Locale getLocale() {
			Object locale = this.context.get(TranslationService.LOCALE);
			if( locale  == null || !(locale instanceof Locale) ) {
				return Locale.getDefault();
			}
			return (@NonNull Locale) locale;
		}
	}
}

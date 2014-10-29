/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di.text;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import javax.inject.Inject;

import org.eclipse.fx.core.text.Formatter;
import org.eclipse.fx.core.text.LocaleProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Formatter based on {@link DateTimeFormatter}
 *
 * @since 1.1.0
 */
public class TemporalAccessorFormatter implements Formatter<TemporalAccessor> {
	@NonNull
	private final LocaleProvider localeProvider;

	/**
	 * Create a temporal access formatter
	 *
	 * @param localeProvider
	 *            the locale provider
	 */
	@Inject
	public TemporalAccessorFormatter(@NonNull LocaleProvider localeProvider) {
		this.localeProvider = localeProvider;
	}

	@Override
	public @NonNull String format(@Nullable TemporalAccessor object, @NonNull String format) {
		String rv = DateTimeFormatter.ofPattern(format, this.localeProvider.getLocale()).format(object);
		return rv == null ? "" : rv; //$NON-NLS-1$
	}

}

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
package org.eclipse.fx.core.text;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Formatter based on {@link SimpleDateFormat}
 *
 * @since 1.1.0
 */
public class DateFormatter implements Formatter<@Nullable Date> {
	@NonNull
	private final LocaleProvider localeProvider;

	/**
	 * Create a new date formatter
	 *
	 * @param localeProvider
	 *            the locale provider
	 */
	@Inject
	public DateFormatter(@NonNull LocaleProvider localeProvider) {
		this.localeProvider = localeProvider;
	}

	@Override
	public @NonNull String format(@Nullable Date object, @NonNull String format) {
		String rv = new SimpleDateFormat(format, this.localeProvider.getLocale()).format(object);
		return rv == null ? "" : rv; //$NON-NLS-1$
	}
}

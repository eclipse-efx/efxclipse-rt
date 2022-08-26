/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.text;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.inject.Inject;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Formatter based on {@link DecimalFormat}
 *
 * @since 1.1.0
 */
public class NumberFormatter implements Formatter<Number> {
	@NonNull
	private final LocaleProvider localeProvider;

	/**
	 * Create number formatter
	 *
	 * @param localeProvider
	 *            the locale provider
	 */
	@Inject
	public NumberFormatter(@NonNull LocaleProvider localeProvider) {
		this.localeProvider = localeProvider;
	}

	@Override
	public @NonNull String format(@Nullable Number object, @NonNull String format) {
		String rv = new DecimalFormat(format, DecimalFormatSymbols.getInstance(this.localeProvider.getLocale())).format(object);
		return rv == null ? "" : rv; //$NON-NLS-1$
	}
}

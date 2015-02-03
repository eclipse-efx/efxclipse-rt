/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.text;

import java.util.function.Function;

import org.apache.commons.lang.text.StrLookup;
import org.apache.commons.lang.text.StrSubstitutor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Factory to create message formatter
 *
 * @since 1.1.0
 */
public class MessageFormatter {

	/**
	 * Create a formatter function
	 *
	 * @param dataProvider
	 *            provides the dynamic data
	 * @param formatProvider
	 *            provides the dynamic formatters
	 * @return a formatting function
	 */
	public static @NonNull Function<Object, String> create(@NonNull Function<@NonNull String, @Nullable Object> dataProvider, @NonNull Function<@NonNull String, @Nullable Formatter<@Nullable ?>> formatProvider) {
		StrSubstitutor strSubstitutor = new StrSubstitutor(new LookupImpl(dataProvider, formatProvider));
		return strSubstitutor::replace;
	}

	private static class LookupImpl extends StrLookup {
		@NonNull
		private final Function<@NonNull String, @Nullable Object> dataProvider;

		@NonNull
		private final Function<@NonNull String, @Nullable Formatter<@Nullable ?>> formatProvider;

		public LookupImpl(@NonNull Function<@NonNull String, @Nullable Object> dataProvider, @NonNull Function<@NonNull String, @Nullable Formatter<@Nullable ?>> formatProvider) {
			this.dataProvider = dataProvider;
			this.formatProvider = formatProvider;
		}

		@SuppressWarnings("null")
		@Override
		public String lookup(String subValue) {
			String key = subValue.substring(0, subValue.indexOf(','));
			String formatData = subValue.substring(subValue.indexOf(',') + 1);
			String formatter = formatData.substring(0, formatData.indexOf(','));
			String format = formatData.substring(formatData.indexOf(',') + 1);

			Object object = this.dataProvider.apply(key);
			@SuppressWarnings("unchecked")
			Formatter<@Nullable Object> formatterInstance = (Formatter<@Nullable Object>) this.formatProvider.apply(formatter);
			if (formatterInstance == null) {
				return object + ""; //$NON-NLS-1$
			}

			return formatterInstance.format(object, format);
		}

	}
}

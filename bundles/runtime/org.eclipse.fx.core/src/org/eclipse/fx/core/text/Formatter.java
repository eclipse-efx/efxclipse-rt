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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Formatter interface
 *
 * @param <T>
 *            the type to format
 * @since 1.1.0
 */
public interface Formatter<@Nullable T> {
	/**
	 * Format the given object
	 *
	 * @param object
	 *            the object to format
	 * @param format
	 *            the format
	 * @return the formated value
	 */
	public @NonNull String format(@Nullable T object, @NonNull String format);

	/**
	 * A formatter who simply creates a string from the object
	 */
	public static Formatter<@Nullable Object> TO_STRING = new Formatter<@Nullable Object>() {

		@SuppressWarnings("null")
		@Override
		public @NonNull String format(@Nullable Object object, @NonNull String format) {
			return object == null ? "" : object.toString(); //$NON-NLS-1$
		}
	};

}

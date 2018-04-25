/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.log;

import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A logging context to capture information and log them
 * 
 * @since 3.3.0
 * @noimplement
 */
public interface FluentLogContext {
	/**
	 * Attach an exception to the log statement
	 * 
	 * @param t
	 *            the throwable
	 * @return the context
	 */
	public FluentLogContext withException(Throwable t);

	/**
	 * Log the provided message
	 * 
	 * @param message
	 *            the message
	 */
	public void log(@NonNull CharSequence message);

	/**
	 * Log the formatted message
	 * <p>
	 * For formatting {@link String#format(String, Object...)} is used
	 * </p>
	 * 
	 * @param pattern
	 *            the message format
	 * @param arguments
	 *            the message arguments
	 */
	public void log(@NonNull String pattern, Object... arguments);

	/**
	 * Log the message computed by the supplier
	 * 
	 * @param messageSupplier
	 *            the message supplier
	 */
	public void log(@NonNull Supplier<@NonNull CharSequence> messageSupplier);

	/**
	 * Log the message computed by the function
	 * 
	 * @param messageSupplier
	 *            the function to compute the message
	 * @param argument
	 *            the argument passed to the function
	 */
	public <T> void log(@NonNull Function<T, @NonNull CharSequence> messageSupplier, T argument);

}

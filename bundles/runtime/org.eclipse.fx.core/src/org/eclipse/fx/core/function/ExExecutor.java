/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.function;

import java.util.function.Function;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Utility class to execute functions with who throw checked exceptions and wrap
 * them in a runtime exception
 *
 * @since 1.2
 */
public final class ExExecutor {
	private ExExecutor() {
	}

	@NonNull
	private static RuntimeException wrap(@NonNull Throwable e,
			@NonNull String message) {
		return new RuntimeException(message, e);
	}

	/**
	 * Execute the runnable and
	 * <ul>
	 * <li>wrap checked exceptions into a {@link RuntimeException} using the
	 * given message</li>
	 * <li>re-throw runtime exceptions as is</li>
	 * </ul>
	 *
	 * @param r
	 *            the runnable
	 * @param message
	 *            the message to use
	 */
	public static void executeRunnable(@NonNull ExRunnable r,
			@NonNull String message) {
		executeRunnable(r, (e) -> wrap(e, message));
	}

	/**
	 * Execute the runnable and
	 * <ul>
	 * <li>use the converter for checked exceptions</li>
	 * <li>re-throw runtime exceptions as is</li>
	 * </ul>
	 *
	 * @param r
	 *            the runnable
	 * @param exceptionConverter
	 *            function to convert checked exceptions into runtime exceptions
	 */
	public static void executeRunnable(
			@NonNull ExRunnable r,
			@NonNull Function<@NonNull Throwable, @NonNull RuntimeException> exceptionConverter) {
		try {
			r.wrappedRun();
		} catch (Throwable e) {
			if (e instanceof RuntimeException) {
				throw (RuntimeException) e;
			} else {
				throw exceptionConverter.apply(e);
			}
		}
	}

	/**
	 * Execute the supplier and
	 * <ul>
	 * <li>wrap checked exceptions into a {@link RuntimeException} using the
	 * given message</li>
	 * <li>re-throw runtime exceptions as is</li>
	 * </ul>
	 *
	 * @param r
	 *            the supplier
	 * @param message
	 *            the message to use
	 * @return the value provided by the supplier
	 */
	public static <@Nullable V> V executeSupplier(@NonNull ExSupplier<V> r,
			@NonNull String message) {
		return executeSupplier(r, (e) -> wrap(e, message));
	}

	/**
	 * Execute the supplier and
	 * <ul>
	 * <li>use the converter for checked exceptions</li>
	 * <li>re-throw runtime exceptions as is</li>
	 * </ul>
	 *
	 * @param r
	 *            the runnable
	 * @param exceptionConverter
	 *            function to convert checked exceptions into runtime exceptions
	 * @return the value provided by the supplier
	 */
	public static <@Nullable V> V executeSupplier(
			@NonNull ExSupplier<V> r,
			@NonNull Function<@NonNull Throwable, @NonNull RuntimeException> exceptionConverter) {
		try {
			return r.wrappedGet();
		} catch (Throwable e) {
			if (e instanceof RuntimeException) {
				throw (RuntimeException) e;
			} else {
				throw exceptionConverter.apply(e);
			}
		}
	}

	/**
	 * Execute the consumer and
	 * <ul>
	 * <li>wrap checked exceptions into a {@link RuntimeException} using the
	 * given message</li>
	 * <li>re-throw runtime exceptions as is</li>
	 * </ul>
	 *
	 * @param value
	 *            the value to pass to the consumer
	 * @param r
	 *            the consumer
	 * @param message
	 *            the message to use
	 */
	public static <@Nullable T> void executeConsumer(T value,
			@NonNull ExConsumer<T> r, @NonNull String message) {
		executeConsumer(value, r, (e) -> wrap(e, message));
	}

	/**
	 * Execute the consumer and
	 * <ul>
	 * <li>use the converter for checked exceptions</li>
	 * <li>re-throw runtime exceptions as is</li>
	 * </ul>
	 *
	 * @param value
	 *            the value to pass to the consumer
	 * @param r
	 *            the consumer
	 * @param exceptionConverter
	 *            function to convert checked exceptions into runtime exceptions
	 */
	public static <@Nullable T> void executeConsumer(
			T value,
			@NonNull ExConsumer<T> r,
			@NonNull Function<@NonNull Throwable, @NonNull RuntimeException> exceptionConverter) {
		try {
			r.wrappedAccept(value);
		} catch (Throwable e) {
			if (e instanceof RuntimeException) {
				throw (RuntimeException) e;
			} else {
				throw exceptionConverter.apply(e);
			}
		}
	}

	/**
	 * Execute the function and
	 * <ul>
	 * <li>wrap checked exceptions into a {@link RuntimeException} using the
	 * given message</li>
	 * <li>re-throw runtime exceptions as is</li>
	 * </ul>
	 *
	 * @param value
	 *            the value to pass to the function
	 * @param r
	 *            the function
	 * @param message
	 *            the message to use
	 * @return the return value of the function
	 */
	public static <@Nullable V, @Nullable R> R executeFunction(V value, @NonNull ExFunction<V, R> r,
			@NonNull String message) {
		return executeFunction(value, r, (e) -> wrap(e, message));
	}

	/**
	 * Execute the function and
	 * <ul>
	 * <li>use the converter for checked exceptions</li>
	 * <li>re-throw runtime exceptions as is</li>
	 * </ul>
	 *
	 * @param value
	 *            the value to pass to the function
	 * @param r
	 *            the function
	 * @param exceptionConverter
	 *            function to convert checked exceptions into runtime exceptions
	 * @return the return value of the function
	 */
	public static <@Nullable V, @Nullable R> R executeFunction(
			V value,
			@NonNull ExFunction<V, R> r,
			@NonNull Function<@NonNull Throwable, @NonNull RuntimeException> exceptionConverter) {
		try {
			return r.wrappedApply(value);
		} catch (Throwable e) {
			if (e instanceof RuntimeException) {
				throw (RuntimeException) e;
			} else {
				throw exceptionConverter.apply(e);
			}
		}
	}
}

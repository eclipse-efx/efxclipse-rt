/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.function;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerCreator;
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
	private static RuntimeException wrap(@NonNull Throwable e, @NonNull String message) {
		return new RuntimeException(message, e);
	}

	/**
	 * Execute the runnable and
	 * <ul>
	 * <li>wrap checked exceptions into a {@link RuntimeException} using the given
	 * message</li>
	 * <li>re-throw runtime exceptions as is</li>
	 * </ul>
	 *
	 * @param r
	 *            the runnable
	 * @param message
	 *            the message to use
	 */
	public static void executeRunnable(@NonNull ExRunnable r, @NonNull String message) {
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
	public static void executeRunnable(@NonNull ExRunnable r,
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
	 * Execute the runnable and log the exception with the given logger but <b>don't
	 * rethrow it</b>
	 *
	 * @param r
	 *            the runnable
	 * @param logger
	 *            the logger
	 * @since 2.2.0
	 */
	public static void executeRunnable(@NonNull ExRunnable r, Logger logger) {
		try {
			r.wrappedRun();
		} catch (Throwable t) {
			Logger l = logger;
			if (l == null) {
				l = LoggerCreator.createLogger(ExExecutor.class);
			}
			l.error("Unable to execute" + r, t); //$NON-NLS-1$
		}
	}

	/**
	 * Execute the runnable and log the exception but <b>don't rethrow it</b>
	 *
	 * @param r
	 *            the runnable
	 * @since 2.2.0
	 */
	public static void executeRunnable(@NonNull ExRunnable r) {
		executeRunnable(r, (Logger) null);
	}

	/**
	 * Execute the supplier and
	 * <ul>
	 * <li>wrap checked exceptions into a {@link RuntimeException} using the given
	 * message</li>
	 * <li>re-throw runtime exceptions as is</li>
	 * </ul>
	 *
	 * @param r
	 *            the supplier
	 * @param message
	 *            the message to use
	 * @return the value provided by the supplier
	 */
	public static <@Nullable V> Optional<V> executeSupplier(@NonNull ExSupplier<V> r, @NonNull String message) {
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
	public static <@Nullable V> Optional<V> executeSupplier(@NonNull ExSupplier<V> r,
			@NonNull Function<@NonNull Throwable, @NonNull RuntimeException> exceptionConverter) {
		try {
			return Optional.ofNullable(r.wrappedGet());
		} catch (Throwable e) {
			if (e instanceof RuntimeException) {
				throw (RuntimeException) e;
			} else {
				throw exceptionConverter.apply(e);
			}
		}
	}

	/**
	 * Execute the supplier and if an exception occurs handle the exception with
	 * provides handler to provide a default value
	 *
	 * @param r
	 *            the supplier
	 * @param exceptionHandler
	 *            the exception handler
	 * @return the value
	 */
	public static <@Nullable V> Optional<V> executeSupplierOrDefault(@NonNull ExSupplier<V> r,
			Function<Throwable, V> exceptionHandler) {
		try {
			return Optional.of(r.wrappedGet());
		} catch (Throwable t) {
			LoggerCreator.createLogger(ExExecutor.class).error("Failed to execute supplier", t); //$NON-NLS-1$
			return Optional.ofNullable(exceptionHandler.apply(t));
		}
	}

	/**
	 * Execute the supplier and if an exception occurs return an empty
	 * {@link Optional}
	 *
	 * @param r
	 *            the supplier
	 * @return the value
	 * @since 3.1.0
	 */
	public static <@Nullable V> Optional<V> accept(@NonNull ExSupplier<V> r) {
		try {
			return Optional.of(r.wrappedGet());
		} catch (Throwable t) {
			return Optional.empty();
		}
	}

	/**
	 * Execute the consumer and
	 * <ul>
	 * <li>wrap checked exceptions into a {@link RuntimeException} using the given
	 * message</li>
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
	public static <@Nullable T> void executeConsumer(T value, @NonNull ExConsumer<T> r, @NonNull String message) {
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
	public static <@Nullable T> void executeConsumer(T value, @NonNull ExConsumer<T> r,
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
	 * Execute the consumer and log the exception if one occurs
	 * 
	 * @param value
	 *            the value passed to the consumer
	 * @param r
	 *            the consumer
	 * @since 3.1.0
	 */
	public static <@Nullable T> void get(T value, @NonNull ExConsumer<T> r) {
		try {
			r.wrappedAccept(value);
		} catch (Throwable e) {
			LoggerCreator.createLogger(ExExecutor.class).error("Failed to execute consumer", e); //$NON-NLS-1$
		}
	}

	/**
	 * Execute the function and
	 * <ul>
	 * <li>wrap checked exceptions into a {@link RuntimeException} using the given
	 * message</li>
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
	public static <@Nullable V, @Nullable R> Optional<R> executeFunction(V value, @NonNull ExFunction<V, R> r,
			@NonNull String message) {
		return executeFunction(value, r, (e) -> wrap(e, message));
	}

	/**
	 * Execute the function and in case of an exception
	 *
	 * @param value
	 *            the value to pass to the function
	 * @param r
	 *            the function
	 * @param exceptionHandler
	 *            handle an exception and return a value
	 * @return the value returned by the function or the exception handler
	 */
	public static <@Nullable V, @Nullable R> Optional<R> executeFunctionOrDefault(V value, @NonNull ExFunction<V, R> r,
			BiFunction<Throwable, V, R> exceptionHandler) {
		try {
			return Optional.of(r.wrappedApply(value));
		} catch (Throwable t) {
			return Optional.ofNullable(exceptionHandler.apply(t, value));
		}
	}

	/**
	 * Execute the function and in case of an exception return an empty
	 * {@link Optional}
	 * 
	 * @param value
	 *            the value to pass to the function
	 * @param f
	 *            the function
	 * @return the value returned by the function wrapped in an optional
	 * @since 3.1.0
	 */
	public static <@Nullable V, @Nullable R> Optional<R> apply(V value, @NonNull ExFunction<V, R> f) {
		try {
			return Optional.of(f.wrappedApply(value));
		} catch (Throwable t) {
			LoggerCreator.createLogger(ExExecutor.class).error("Failed to execute function", t); //$NON-NLS-1$
			return Optional.empty();
		}
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
	public static <@Nullable V, @Nullable R> Optional<R> executeFunction(V value, @NonNull ExFunction<V, R> r,
			@NonNull Function<@NonNull Throwable, @NonNull RuntimeException> exceptionConverter) {
		try {
			return Optional.ofNullable(r.wrappedApply(value));
		} catch (Throwable e) {
			if (e instanceof RuntimeException) {
				throw (RuntimeException) e;
			} else {
				throw exceptionConverter.apply(e);
			}
		}
	}
}

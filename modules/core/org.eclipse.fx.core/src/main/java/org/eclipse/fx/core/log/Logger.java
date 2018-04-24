/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *     Christoph Caks <ccaks@bestsolution.at> - initial API and documentation
 *******************************************************************************/
package org.eclipse.fx.core.log;

import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Logger interface delegating to real log framework implementation like log4j,
 * java.util.logging, ...
 */
public interface Logger {

	/**
	 * logs a message in the specified log level.
	 *
	 * @param level
	 *            the Log Level
	 * @param message
	 *            the message
	 */
	public void log(@NonNull Level level, @NonNull String message);
	
	/**
	 * logs a message in the specified log level.
	 *
	 * @param level
	 *            the Log Level
	 * @param message
	 *            the message
	 * @since 3.3.0
	 */
	@SuppressWarnings("null")
	public default void log(@NonNull Level level, @NonNull CharSequence message) {
		log(level,message.toString());
	}

	/**
	 * logs a message in the specified log level
	 *
	 * @param level
	 *            the log level
	 * @param messageSupplier
	 *            the message supplier
	 * @since 2.2.0
	 */
	default void log(@NonNull Level level, @NonNull Supplier<@NonNull String> messageSupplier) {
		if (isEnabled(level)) {
			log(level, messageSupplier.get());
		}
	}

	/**
	 * logs a dynamically created message in the specified log level
	 *
	 * @param level
	 *            the level
	 * @param value
	 *            the value
	 * @param messageCreator
	 *            function to create the log message
	 * @return the value passed in
	 * @since 3.0.0
	 */
	default <T> @Nullable T  log(@NonNull Level level, @Nullable T value,
			Function<@Nullable T, @NonNull String> messageCreator) {
		if (isEnabled(level)) {
			log(level, messageCreator.apply(value));
		}
		return value;
	}

	/**
	 * logs a message and an exception in the specified log level
	 *
	 * @param level
	 *            the Log Level
	 * @param message
	 *            the message
	 * @param t
	 *            the Exception
	 */
	public void log(@NonNull Level level, @NonNull String message, @NonNull Throwable t);
	
	/**
	 * logs a message and an exception in the specified log level
	 *
	 * @param level
	 *            the Log Level
	 * @param message
	 *            the message
	 * @param t
	 *            the Exception
	 * @since 3.3.0
	 */
	@SuppressWarnings("null")
	public default void log(@NonNull Level level, @NonNull CharSequence message, @NonNull Throwable t) {
		log(level, message.toString(), t);
	}

	/**
	 * logs a message and an exception in the specified log level
	 *
	 * @param level
	 *            the Log Level
	 * @param messageSupplier
	 *            the message supplier
	 * @param t
	 *            the exception
	 * @since 2.2.0
	 */
	default void log(@NonNull Level level, @NonNull Supplier<@NonNull String> messageSupplier, @NonNull Throwable t) {
		if (isEnabled(level)) {
			log(level, messageSupplier.get(), t);
		}
	}

	/**
	 * logs a dynamically created message and an exception in the specified log
	 * level
	 *
	 * @param level
	 *            the level
	 * @param value
	 *            the value to log
	 * @param messageCreator
	 *            function to create a message
	 * @param t
	 *            the exception
	 * @return the value passed in
	 * @since 3.0.0
	 */
	default <T> @Nullable T log(@NonNull Level level, @Nullable T value,
			@NonNull Function<@Nullable T, @NonNull String> messageCreator, @NonNull Throwable t) {
		if (isEnabled(level)) {
			log(level, messageCreator.apply(value), t);
		}
		return value;
	}

	/**
	 * logs a formatted message in the specified log level.
	 * <p>
	 * For formatting {@link String#format(String, Object...)} is used. The
	 * following two method calls yield the same result, but the logf call
	 * allows the underlying implementation to prevent the formatting if the log
	 * level is disabled. <code><br>
	 *  logf(Level.TRACE, "%5.3f", num);<br>
	 *  log(Level.TRACE, String.format("%5.3", num));
	 * </code>
	 * </p>
	 *
	 * @see String#format(String, Object...)
	 * @param level
	 *            the Log Level
	 * @param pattern
	 *            the message format
	 * @param args
	 *            the message arguments
	 */
	public void logf(@NonNull Level level, @NonNull String pattern, Object... args);

	/**
	 * logs a formatted message in the specified log level.
	 * <p>
	 * For formatting {@link String#format(String, Object...)} is used. The
	 * following two method calls yield the same result, but the logf call
	 * allows the underlying implementation to prevent the formatting if the log
	 * level is disabled. <code><br>
	 *  logf(Level.TRACE, "%5.3f", num);<br>
	 *  log(Level.TRACE, String.format("%5.3", num));
	 * </code>
	 * </p>
	 *
	 * @see String#format(String, Object...)
	 * @param level
	 *            the Log Level
	 * @param pattern
	 *            the message format
	 * @param t
	 *            the exception
	 * @param args
	 *            the message arguments
	 */
	public void logf(@NonNull Level level, @NonNull String pattern, @NonNull Throwable t, Object... args);

	/**
	 * convenience method for {@link #log(Level, String)} with
	 * {@link Level#TRACE}.
	 *
	 * @see #log(Level, String)
	 * @param message
	 *            the message
	 */
	public void trace(@NonNull String message);

	/**
	 * convenience method for {@link #log(Level, String)} with
	 * {@link Level#TRACE}.
	 *
	 * @param messageSupplier
	 *            the message supplier
	 * @since 2.2.0
	 */
	default void trace(@NonNull Supplier<@NonNull String> messageSupplier) {
		if (isEnabled(Level.TRACE)) {
			trace(messageSupplier.get());
		}
	}

	/**
	 * convenience method for {@link #log(Level, Object, Function)} with
	 * {@link Level#TRACE}
	 *
	 * @param value
	 *            the value
	 * @param messageCreator
	 *            the message creator
	 * @return the value passed in
	 * @since 3.0.0
	 */
	default <T> @Nullable T  trace(@Nullable T value, @NonNull Function<@Nullable T, @NonNull String> messageCreator) {
		if (isEnabled(Level.TRACE)) {
			trace(messageCreator.apply(value));
		}

		return value;
	}

	/**
	 * convenience method for {@link #log(Level, String)} with
	 * {@link Level#DEBUG}.
	 *
	 * @see #log(Level, String)
	 * @param message
	 *            the message
	 */
	public void debug(@NonNull String message);

	/**
	 * convenience method for {@link #log(Level, String)} with
	 * {@link Level#DEBUG}.
	 *
	 * @param messageSupplier
	 *            the message supplier
	 * @since 2.2.0
	 */
	default void debug(@NonNull Supplier<@NonNull String> messageSupplier) {
		if (isEnabled(Level.DEBUG)) {
			debug(messageSupplier.get());
		}
	}

	/**
	 * convenience method for {@link #log(Level, Object, Function)} with
	 * {@link Level#DEBUG}.
	 *
	 * @param value
	 *            the value
	 *
	 * @param messageCreator
	 *            the message creator
	 * @return the value passed in
	 * @since 3.0.0
	 */
	default <T> @Nullable T debug(@Nullable T value, @NonNull Function<@Nullable T, @NonNull String> messageCreator) {
		if (isEnabled(Level.DEBUG)) {
			debug(messageCreator.apply(value));
		}
		return value;
	}

	/**
	 * convenience method for {@link #log(Level, String)} with
	 * {@link Level#INFO}.
	 *
	 * @see #log(Level, String)
	 * @param message
	 *            the message
	 */
	public void info(@NonNull String message);

	/**
	 * convenience method for {@link #log(Level, String)} with
	 * {@link Level#INFO}.
	 *
	 * @param messageSupplier
	 *            the message supplier
	 * @since 2.2.0
	 */
	default void info(@NonNull Supplier<@NonNull String> messageSupplier) {
		if (isEnabled(Level.INFO)) {
			info(messageSupplier.get());
		}
	}

	/**
	 * convenience method for {@link #log(Level, Object, Function)} with
	 * {@link Level#INFO}.
	 *
	 * @param value
	 *            the value
	 *
	 * @param messageCreator
	 *            the message creator
	 * @return the value passed in
	 * @since 3.0.0
	 */
	default <T> @Nullable T  info(@Nullable T value, @NonNull Function<@Nullable T, @NonNull String> messageCreator) {
		if (isEnabled(Level.INFO)) {
			info(messageCreator.apply(value));
		}

		return value;
	}

	/**
	 * convenience method for {@link #log(Level, String)} with
	 * {@link Level#WARNING}.
	 *
	 * @see #log(Level, String)
	 * @param message
	 *            the message
	 */
	public void warning(@NonNull String message);

	/**
	 * convenience method for {@link #log(Level, String)} with
	 * {@link Level#WARNING}.
	 *
	 * @param messageSupplier
	 *            the message supplier
	 * @since 2.2.0
	 */
	default void warning(@NonNull Supplier<@NonNull String> messageSupplier) {
		if (isEnabled(Level.WARNING)) {
			warning(messageSupplier.get());
		}
	}

	/**
	 * convenience method for {@link #log(Level, Object, Function)} with
	 * {@link Level#WARNING}.
	 *
	 * @param value
	 *            the value
	 *
	 * @param messageCreator
	 *            the message supplier
	 * @return the value passed in
	 * @since 3.0.0
	 */
	default <T> @Nullable T  warning(@Nullable T value, @NonNull Function<@Nullable T, @NonNull String> messageCreator) {
		if (isEnabled(Level.WARNING)) {
			warning(messageCreator.apply(value));
		}
		return value;
	}

	/**
	 * convenience method for {@link #log(Level, String)} with
	 * {@link Level#ERROR}.
	 *
	 * @see #log(Level, String)
	 * @param message
	 *            the message
	 */
	public void error(@NonNull String message);

	/**
	 * convenience method for {@link #log(Level, String)} with
	 * {@link Level#ERROR}.
	 *
	 * @param messageSupplier
	 *            the message supplier
	 * @since 2.2.0
	 */
	default void error(@NonNull Supplier<@NonNull String> messageSupplier) {
		if (isEnabled(Level.ERROR)) {
			error(messageSupplier.get());
		}
	}

	/**
	 * convenience method for {@link #log(Level, Object, Function)} with
	 * {@link Level#ERROR}.
	 *
	 * @param value
	 *            the value
	 *
	 * @param messageCreator
	 *            the message creator
	 * @return the value passed in
	 * @since 3.0.0
	 */
	default <T> @Nullable T  error(@Nullable T value, @NonNull Function<@Nullable T, @NonNull String> messageCreator) {
		if (isEnabled(Level.ERROR)) {
			error(messageCreator.apply(value));
		}
		return value;
	}

	/**
	 * convenience method for {@link #log(Level, String)} with
	 * {@link Level#FATAL}.
	 *
	 * @see #log(Level, String)
	 * @param message
	 *            the message
	 */
	public void fatal(@NonNull String message);

	/**
	 * convenience method for {@link #log(Level, String)} with
	 * {@link Level#FATAL}.
	 *
	 * @param messageSupplier
	 *            the message supplier
	 * @since 2.2.0
	 */
	default void fatal(@NonNull Supplier<@NonNull String> messageSupplier) {
		if (isEnabled(Level.FATAL)) {
			fatal(messageSupplier.get());
		}
	}

	/**
	 * convenience method for {@link #log(Level, Object, Function)} with
	 * {@link Level#FATAL}.
	 *
	 * @param value
	 *            the value
	 *
	 * @param messageCreator
	 *            the message creator
	 * @return the value passed in
	 * @since 3.0.0
	 */
	default <T> @Nullable T  fatal(@Nullable T value, @NonNull Function<@Nullable T, @NonNull String> messageCreator) {
		if (isEnabled(Level.FATAL)) {
			fatal(messageCreator.apply(value));
		}

		return value;
	}

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with
	 * {@link Level#TRACE}.
	 *
	 * @see #log(Level, String, Throwable)
	 * @param message
	 *            the message
	 * @param t
	 *            the Exception
	 */
	public void trace(@NonNull String message, @NonNull Throwable t);

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with
	 * {@link Level#TRACE}.
	 *
	 * @param messageSupplier
	 *            the message supplier
	 * @param t
	 *            the exception
	 * @since 2.2.0
	 */
	default void trace(@NonNull Supplier<@NonNull String> messageSupplier, @NonNull Throwable t) {
		if (isEnabled(Level.TRACE)) {
			trace(messageSupplier.get(), t);
		}
	}

	/**
	 * convenience method for {@link #log(Level, Object, Function, Throwable)}
	 * with {@link Level#TRACE}.
	 *
	 * @param value
	 *            the value
	 *
	 * @param messageCreator
	 *            the message creator
	 * @param t
	 *            the exception
	 * @return the value passed in
	 * @since 3.0.0
	 */
	default <T> @Nullable T  trace(@Nullable T value, @NonNull Function<@Nullable T, @NonNull String> messageCreator,
			@NonNull Throwable t) {
		if (isEnabled(Level.TRACE)) {
			trace(messageCreator.apply(value), t);
		}
		return value;
	}

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with
	 * {@link Level#DEBUG}.
	 *
	 * @see #log(Level, String, Throwable)
	 * @param message
	 *            the message
	 * @param t
	 *            the Exception
	 */
	public void debug(@NonNull String message, @NonNull Throwable t);

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with
	 * {@link Level#DEBUG}.
	 *
	 * @param messageSupplier
	 *            the message supplier
	 * @param t
	 *            the exception
	 * @since 2.2.0
	 */
	default void debug(@NonNull Supplier<@NonNull String> messageSupplier, @NonNull Throwable t) {
		if (isEnabled(Level.DEBUG)) {
			debug(messageSupplier.get(), t);
		}
	}

	/**
	 * convenience method for {@link #log(Level, Object, Function, Throwable)}
	 * with {@link Level#DEBUG}.
	 *
	 * @param value
	 *            the value
	 *
	 * @param messageCreator
	 *            the message creator
	 * @param t
	 *            the exception
	 * @return the value passed in
	 * @since 3.0.0
	 */
	default <T> @Nullable T  debug(@Nullable T value, @NonNull Function<@Nullable T, @NonNull String> messageCreator,
			@NonNull Throwable t) {
		if (isEnabled(Level.DEBUG)) {
			debug(messageCreator.apply(value), t);
		}
		return value;
	}

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with
	 * {@link Level#INFO}.
	 *
	 * @see #log(Level, String, Throwable)
	 * @param message
	 *            the message
	 * @param t
	 *            the Exception
	 */
	public void info(@NonNull String message, @NonNull Throwable t);

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with
	 * {@link Level#INFO}.
	 *
	 * @param messageSupplier
	 *            the message supplier
	 * @param t
	 *            the exception
	 * @since 2.2.0
	 */
	default void info(@NonNull Supplier<@NonNull String> messageSupplier, @NonNull Throwable t) {
		if (isEnabled(Level.INFO)) {
			info(messageSupplier.get(), t);
		}
	}

	/**
	 * convenience method for {@link #log(Level, Object, Function, Throwable)}
	 * with {@link Level#INFO}.
	 *
	 * @param value
	 *            the value
	 *
	 * @param messageCreator
	 *            the message supplier
	 * @param t
	 *            the exception
	 * @return the value passed in
	 * @since 3.0.0
	 */
	default <T> @Nullable T  info(@Nullable T value, @NonNull Function<@Nullable T, @NonNull String> messageCreator,
			@NonNull Throwable t) {
		if (isEnabled(Level.INFO)) {
			info(messageCreator.apply(value), t);
		}

		return value;
	}

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with
	 * {@link Level#WARNING}.
	 *
	 * @see #log(Level, String, Throwable)
	 * @param message
	 *            the message
	 * @param t
	 *            the Exception
	 */
	public void warning(@NonNull String message, @NonNull Throwable t);

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with
	 * {@link Level#WARNING}.
	 *
	 * @param messageSupplier
	 *            the message supplier
	 * @param t
	 *            the exception
	 * @since 2.2.0
	 */
	default void warning(@NonNull Supplier<@NonNull String> messageSupplier, @NonNull Throwable t) {
		if (isEnabled(Level.WARNING)) {
			warning(messageSupplier.get(), t);
		}
	}

	/**
	 * convenience method for {@link #log(Level, Object, Function, Throwable)} with
	 * {@link Level#WARNING}.
	 *
	 * @param value
	 *            the value
	 *
	 * @param messageCreator
	 *            the message creator
	 * @param t
	 *            the exception
	 * @return the value passed in
	 * @since 3.0.0
	 */
	default <T> @Nullable T  warning(@Nullable T value, @NonNull Function<@Nullable T, @NonNull String> messageCreator,
			@NonNull Throwable t) {
		if (isEnabled(Level.WARNING)) {
			warning(messageCreator.apply(value), t);
		}

		return value;
	}

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with
	 * {@link Level#ERROR}.
	 *
	 * @see #log(Level, String, Throwable)
	 * @param message
	 *            the message
	 * @param t
	 *            the Exception
	 */
	public void error(@NonNull String message, @NonNull Throwable t);

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with
	 * {@link Level#ERROR}.
	 *
	 * @param messageSupplier
	 *            the message supplier
	 * @param t
	 *            the Exception
	 * @since 2.2.0
	 */
	default void error(@NonNull Supplier<@NonNull String> messageSupplier, @NonNull Throwable t) {
		if (isEnabled(Level.ERROR)) {
			error(messageSupplier.get(), t);
		}
	}

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with
	 * {@link Level#ERROR}.
	 *
	 * @param value
	 *            the value
	 *
	 * @param messageCreator
	 *            the message creator
	 * @param t
	 *            the Exception
	 * @return the value passed in
	 * @since 3.0.0
	 */
	default <T> @Nullable T  error(@Nullable T value, @NonNull Function<@Nullable T, @NonNull String> messageCreator,
			@NonNull Throwable t) {
		if (isEnabled(Level.ERROR)) {
			error(messageCreator.apply(value), t);
		}

		return value;
	}

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with
	 * {@link Level#FATAL}.
	 *
	 * @see #log(Level, String, Throwable)
	 * @param message
	 *            the message
	 * @param t
	 *            the Exception
	 */
	public void fatal(@NonNull String message, @NonNull Throwable t);

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with
	 * {@link Level#FATAL}.
	 *
	 * @param messageSupplier
	 *            the message supplier
	 * @param t
	 *            the Exception
	 * @since 2.2.0
	 */
	default void fatal(@NonNull Supplier<@NonNull String> messageSupplier, @NonNull Throwable t) {
		if (isEnabled(Level.FATAL)) {
			fatal(messageSupplier.get(), t);
		}
	}

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with
	 * {@link Level#FATAL}.
	 *
	 * @param value
	 *            the value
	 *
	 * @param messageCreator
	 *            the message creator
	 * @param t
	 *            the Exception
	 * @return the value passed in
	 * @since 3.0.0
	 */
	default <T> @Nullable T  fatal(@Nullable T value, @NonNull Function<@Nullable T, @NonNull String> messageCreator,
			@NonNull Throwable t) {
		if (isEnabled(Level.FATAL)) {
			fatal(messageCreator.apply(value), t);
		}

		return value;
	}

	/**
	 * convenience method for {@link #logf(Level, String, Object...)} with
	 * {@link Level#TRACE}.
	 *
	 * @see #logf(Level, String, Object...)
	 * @see String#format(String, Object...)
	 * @param pattern
	 *            the message format
	 * @param args
	 *            the message arguments
	 */
	public void tracef(@NonNull String pattern, Object... args);

	/**
	 * convenience method for {@link #logf(Level, String, Object...)} with
	 * {@link Level#DEBUG}.
	 *
	 * @see #logf(Level, String, Object...)
	 * @see String#format(String, Object...)
	 * @param pattern
	 *            the message format
	 * @param args
	 *            the message arguments
	 */
	public void debugf(@NonNull String pattern, Object... args);

	/**
	 * convenience method for {@link #logf(Level, String, Object...)} with
	 * {@link Level#INFO}.
	 *
	 * @see #logf(Level, String, Object...)
	 * @see String#format(String, Object...)
	 * @param pattern
	 *            the message format
	 * @param args
	 *            the message arguments
	 */
	public void infof(@NonNull String pattern, Object... args);

	/**
	 * convenience method for {@link #logf(Level, String, Object...)} with
	 * {@link Level#WARNING}.
	 *
	 * @see #logf(Level, String, Object...)
	 * @see String#format(String, Object...)
	 * @param pattern
	 *            the message format
	 * @param args
	 *            the message arguments
	 */
	public void warningf(@NonNull String pattern, Object... args);

	/**
	 * convenience method for {@link #logf(Level, String, Object...)} with
	 * {@link Level#ERROR}.
	 *
	 * @see #logf(Level, String, Object...)
	 * @see String#format(String, Object...)
	 * @param pattern
	 *            the message format
	 * @param args
	 *            the message arguments
	 */
	public void errorf(@NonNull String pattern, Object... args);

	/**
	 * convenience method for {@link #logf(Level, String, Object...)} with
	 * {@link Level#FATAL}.
	 *
	 * @see #logf(Level, String, Object...)
	 * @see String#format(String, Object...)
	 * @param pattern
	 *            the message format
	 * @param args
	 *            the message arguments
	 */
	public void fatalf(@NonNull String pattern, Object... args);

	/**
	 * convenience method for {@link #logf(Level, String, Throwable, Object...)}
	 * with {@link Level#TRACE}.
	 *
	 * @see #logf(Level, String, Throwable, Object...)
	 * @see String#format(String, Object...)
	 * @param pattern
	 *            the message format
	 * @param t
	 *            the Exception
	 * @param args
	 *            the message arguments
	 */
	public void tracef(@NonNull String pattern, @NonNull Throwable t, Object... args);

	/**
	 * convenience method for {@link #logf(Level, String, Throwable, Object...)}
	 * with {@link Level#DEBUG}.
	 *
	 * @see #logf(Level, String, Throwable, Object...)
	 * @see String#format(String, Object...)
	 * @param pattern
	 *            the message format
	 * @param t
	 *            the Exception
	 * @param args
	 *            the message arguments
	 */
	public void debugf(@NonNull String pattern, @NonNull Throwable t, Object... args);

	/**
	 * convenience method for {@link #logf(Level, String, Throwable, Object...)}
	 * with {@link Level#INFO}.
	 *
	 * @see #logf(Level, String, Throwable, Object...)
	 * @see String#format(String, Object...)
	 * @param pattern
	 *            the message format
	 * @param t
	 *            the Exception
	 * @param args
	 *            the message arguments
	 */
	public void infof(@NonNull String pattern, @NonNull Throwable t, Object... args);

	/**
	 * convenience method for {@link #logf(Level, String, Throwable, Object...)}
	 * with {@link Level#WARNING}.
	 *
	 * @see #logf(Level, String, Throwable, Object...)
	 * @see String#format(String, Object...)
	 * @param pattern
	 *            the message format
	 * @param t
	 *            the Exception
	 * @param args
	 *            the message arguments
	 */
	public void warningf(@NonNull String pattern, @NonNull Throwable t, Object... args);

	/**
	 * convenience method for {@link #logf(Level, String, Throwable, Object...)}
	 * with {@link Level#ERROR}.
	 *
	 * @see #logf(Level, String, Throwable, Object...)
	 * @see String#format(String, Object...)
	 * @param pattern
	 *            the message format
	 * @param t
	 *            the Exception
	 * @param args
	 *            the message arguments
	 */
	public void errorf(@NonNull String pattern, @NonNull Throwable t, Object... args);

	/**
	 * convenience method for {@link #logf(Level, String, Throwable, Object...)}
	 * with {@link Level#FATAL}.
	 *
	 * @see #logf(Level, String, Throwable, Object...)
	 * @see String#format(String, Object...)
	 * @param pattern
	 *            the message format
	 * @param t
	 *            the Exception
	 * @param args
	 *            the message arguments
	 */
	public void fatalf(@NonNull String pattern, @NonNull Throwable t, Object... args);

	/**
	 * checks whether the given log level is enabled for this logger.
	 *
	 * @param level
	 *            the log level to check against
	 * @return true if the log level is enabled
	 */
	public boolean isEnabled(Level level);

	/**
	 * The log levels
	 */
	public enum Level {
		/**
		 * Trace: Use this log level when you want to track things line by line
		 */
		TRACE,
		/**
		 * Debug: Use this log level to help developers debug your application
		 */
		DEBUG,
		/**
		 * Info: Use this log level for normal log statements like (request
		 * received, ...)
		 */
		INFO,
		/**
		 * Warning: Use this log level for problems like informing about a
		 * resource pool is getting low, ...
		 */
		WARNING,
		/**
		 * Error: Use this log level if something goes wrong e.g. an SQL-Query
		 * could not be executed, ...
		 */
		ERROR,
		/**
		 * Fatal: Use this log level in case of a sever error
		 */
		FATAL
	}
}
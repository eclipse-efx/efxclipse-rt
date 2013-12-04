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

import org.eclipse.jdt.annotation.NonNull;

/**
 * Logger interface delegating to real log framework implementation like log4j, java.util.logging, ...
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
	 * logs a formatted message in the specified log level.
	 * <p>
	 * For formatting {@link String#format(String, Object...)} is used. The following two method calls yield
	 * the same result, but the logf call allows the underlying implementation to prevent the formatting if
	 * the log level is disabled. <code><br>
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
	 * For formatting {@link String#format(String, Object...)} is used. The following two method calls yield
	 * the same result, but the logf call allows the underlying implementation to prevent the formatting if
	 * the log level is disabled. <code><br>
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
	 * convenience method for {@link #log(Level, String)} with {@link Level#TRACE}.
	 * 
	 * @see #log(Level, String)
	 * @param message
	 *            the message
	 */
	public void trace(@NonNull String message);

	/**
	 * convenience method for {@link #log(Level, String)} with {@link Level#DEBUG}.
	 * 
	 * @see #log(Level, String)
	 * @param message
	 *            the message
	 */
	public void debug(@NonNull String message);

	/**
	 * convenience method for {@link #log(Level, String)} with {@link Level#INFO}.
	 * 
	 * @see #log(Level, String)
	 * @param message
	 *            the message
	 */
	public void info(@NonNull String message);

	/**
	 * convenience method for {@link #log(Level, String)} with {@link Level#WARNING}.
	 * 
	 * @see #log(Level, String)
	 * @param message
	 *            the message
	 */
	public void warning(@NonNull String message);

	/**
	 * convenience method for {@link #log(Level, String)} with {@link Level#ERROR}.
	 * 
	 * @see #log(Level, String)
	 * @param message
	 *            the message
	 */
	public void error(@NonNull String message);

	/**
	 * convenience method for {@link #log(Level, String)} with {@link Level#FATAL}.
	 * 
	 * @see #log(Level, String)
	 * @param message
	 *            the message
	 */
	public void fatal(@NonNull String message);

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with {@link Level#TRACE}.
	 * 
	 * @see #log(Level, String, Throwable)
	 * @param message
	 *            the message
	 * @param t
	 *            the Exception
	 */
	public void trace(@NonNull String message, @NonNull Throwable t);

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with {@link Level#DEBUG}.
	 * 
	 * @see #log(Level, String, Throwable)
	 * @param message
	 *            the message
	 * @param t
	 *            the Exception
	 */
	public void debug(@NonNull String message, @NonNull Throwable t);

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with {@link Level#INFO}.
	 * 
	 * @see #log(Level, String, Throwable)
	 * @param message
	 *            the message
	 * @param t
	 *            the Exception
	 */
	public void info(@NonNull String message, @NonNull Throwable t);

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with {@link Level#WARNING}.
	 * 
	 * @see #log(Level, String, Throwable)
	 * @param message
	 *            the message
	 * @param t
	 *            the Exception
	 */
	public void warning(@NonNull String message, @NonNull Throwable t);

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with {@link Level#ERROR}.
	 * 
	 * @see #log(Level, String, Throwable)
	 * @param message
	 *            the message
	 * @param t
	 *            the Exception
	 */
	public void error(@NonNull String message, @NonNull Throwable t);

	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with {@link Level#FATAL}.
	 * 
	 * @see #log(Level, String, Throwable)
	 * @param message
	 *            the message
	 * @param t
	 *            the Exception
	 */
	public void fatal(@NonNull String message, @NonNull Throwable t);

	/**
	 * convenience method for {@link #logf(Level, String, Object...)} with {@link Level#TRACE}.
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
	 * convenience method for {@link #logf(Level, String, Object...)} with {@link Level#DEBUG}.
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
	 * convenience method for {@link #logf(Level, String, Object...)} with {@link Level#INFO}.
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
	 * convenience method for {@link #logf(Level, String, Object...)} with {@link Level#WARNING}.
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
	 * convenience method for {@link #logf(Level, String, Object...)} with {@link Level#ERROR}.
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
	 * convenience method for {@link #logf(Level, String, Object...)} with {@link Level#FATAL}.
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
	 * convenience method for {@link #logf(Level, String, Throwable, Object...)} with {@link Level#TRACE}.
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
	 * convenience method for {@link #logf(Level, String, Throwable, Object...)} with {@link Level#DEBUG}.
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
	 * convenience method for {@link #logf(Level, String, Throwable, Object...)} with {@link Level#INFO}.
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
	 * convenience method for {@link #logf(Level, String, Throwable, Object...)} with {@link Level#WARNING}.
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
	 * convenience method for {@link #logf(Level, String, Throwable, Object...)} with {@link Level#ERROR}.
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
	 * convenience method for {@link #logf(Level, String, Throwable, Object...)} with {@link Level#FATAL}.
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
		 * Info: Use this log level for normal log statements like (request received, ...)
		 */
		INFO,
		/**
		 * Warning: Use this log level for problems like informing about a resource pool is getting low, ...
		 */
		WARNING,
		/**
		 * Error: Use this log level if something goes wrong e.g. an SQL-Query could not be executed, ...
		 */
		ERROR,
		/**
		 * Fatal: Use this log level in case of a sever error
		 */
		FATAL
	}
}
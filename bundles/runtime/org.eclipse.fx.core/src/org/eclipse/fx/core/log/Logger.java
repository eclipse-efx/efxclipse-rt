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

public interface Logger {
	
	/**
	 * logs a message in the specified log level.
	 * @param level the Log Level
	 * @param message the message
	 */
	public void log(Level level, String message);
	/**
	 * logs a message and an exception in the specified log level
	 * @param level the Log Level
	 * @param message the message
	 * @param t the Exception
	 */
	public void log(Level level, String message, Throwable t);
	
	/**
	 * logs a formatted message in the specified log level.
	 * <p>
	 * For formatting {@link String#format(String, Object...)} is used.
	 * The following two method calls yield the same result, but the
	 * logf call allows the underlying implementation to prevent the formatting
	 * if the log level is disabled.
	 * <code><br>
	 *  logf(Level.TRACE, "%5.3f", num);<br>
	 *  log(Level.TRACE, String.format("%5.3", num));
	 * </code>
	 * </p>
	 * @see String#format(String, Object...)
	 * @param level the Log Level
	 * @param pattern the message format
	 * @param args the message arguments
	 */
	public void logf(Level level, String pattern, Object...args);
	public void logf(Level level, String pattern, Throwable t, Object...args);
	
	/**
	 * convenience method for {@link #log(Level, String)} with {@link Level#TRACE}.
	 * @see #log(Level, String)
	 * @param message the message
	 */
	public void trace(String message);
	/**
	 * convenience method for {@link #log(Level, String)} with {@link Level#DEBUG}.
	 * @see #log(Level, String)
	 * @param message the message
	 */
	public void debug(String message);
	/**
	 * convenience method for {@link #log(Level, String)} with {@link Level#INFO}.
	 * @see #log(Level, String)
	 * @param message the message
	 */
	public void info(String message);
	/**
	 * convenience method for {@link #log(Level, String)} with {@link Level#WARNING}.
	 * @see #log(Level, String)
	 * @param message the message
	 */
	public void warning(String message);
	/**
	 * convenience method for {@link #log(Level, String)} with {@link Level#ERROR}.
	 * @see #log(Level, String)
	 * @param message the message
	 */
	public void error(String message);
	/**
	 * convenience method for {@link #log(Level, String)} with {@link Level#FATAL}.
	 * @see #log(Level, String)
	 * @param message the message
	 */
	public void fatal(String message);
	
	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with {@link Level#TRACE}.
	 * @see #log(Level, String, Throwable)
	 * @param message the message
	 * @param t the Exception
	 */
	public void trace(String message, Throwable t);
	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with {@link Level#DEBUG}.
	 * @see #log(Level, String, Throwable)
	 * @param message the message
	 * @param t the Exception
	 */
	public void debug(String message, Throwable t);
	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with {@link Level#INFO}.
	 * @see #log(Level, String, Throwable)
	 * @param message the message
	 * @param t the Exception
	 */
	public void info(String message, Throwable t);
	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with {@link Level#WARNING}.
	 * @see #log(Level, String, Throwable)
	 * @param message the message
	 * @param t the Exception
	 */
	public void warning(String message, Throwable t);
	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with {@link Level#ERROR}.
	 * @see #log(Level, String, Throwable)
	 * @param message the message
	 * @param t the Exception
	 */
	public void error(String message, Throwable t);
	/**
	 * convenience method for {@link #log(Level, String, Throwable)} with {@link Level#FATAL}.
	 * @see #log(Level, String, Throwable)
	 * @param message the message
	 * @param t the Exception
	 */
	public void fatal(String message, Throwable t);
	
	
	/**
	 * convenience method for {@link #logf(Level, String, Object..)} with {@link Level#TRACE}.
	 * @see #logf(Level, String, Object..)
	 * @see String#format(String, Object...)
	 * @param pattern the message format
	 * @param args the message arguments
	 */
	public void tracef(String pattern, Object...args);
	
	/**
	 * convenience method for {@link #logf(Level, String, Object..)} with {@link Level#DEBUG}.
	 * @see #logf(Level, String, Object..)
	 * @see String#format(String, Object...)
	 * @param pattern the message format
	 * @param args the message arguments
	 */
	public void debugf(String pattern, Object...args);
	
	/**
	 * convenience method for {@link #logf(Level, String, Object..)} with {@link Level#INFO}.
	 * @see #logf(Level, String, Object..)
	 * @see String#format(String, Object...)
	 * @param pattern the message format
	 * @param args the message arguments
	 */
	public void infof(String pattern, Object...args);
	
	/**
	 * convenience method for {@link #logf(Level, String, Object..)} with {@link Level#WARNING}.
	 * @see #logf(Level, String, Object..)
	 * @see String#format(String, Object...)
	 * @param pattern the message format
	 * @param args the message arguments
	 */
	public void warningf(String pattern, Object...args);
	
	/**
	 * convenience method for {@link #logf(Level, String, Object..)} with {@link Level#ERROR}.
	 * @see #logf(Level, String, Object..)
	 * @see String#format(String, Object...)
	 * @param pattern the message format
	 * @param args the message arguments
	 */
	public void errorf(String pattern, Object...args);
	
	/**
	 * convenience method for {@link #logf(Level, String, Object..)} with {@link Level#FATAL}.
	 * @see #logf(Level, String, Object..)
	 * @see String#format(String, Object...)
	 * @param pattern the message format
	 * @param args the message arguments
	 */
	public void fatalf(String pattern, Object...args);
	
	/**
	 * convenience method for {@link #logf(Level, String, Throwable, Object..)} with {@link Level#TRACE}.
	 * @see #logf(Level, String, Throwable, Object..)
	 * @see String#format(String, Object...)
	 * @param pattern the message format
	 * @param t the Exception
	 * @param args the message arguments
	 */
	public void tracef(String pattern, Throwable t, Object...args);
	/**
	 * convenience method for {@link #logf(Level, String, Throwable, Object..)} with {@link Level#DEBUG}.
	 * @see #logf(Level, String, Throwable, Object..)
	 * @see String#format(String, Object...)
	 * @param pattern the message format
	 * @param t the Exception
	 * @param args the message arguments
	 */
	public void debugf(String pattern, Throwable t, Object...args);
	/**
	 * convenience method for {@link #logf(Level, String, Throwable, Object..)} with {@link Level#INFO}.
	 * @see #logf(Level, String, Throwable, Object..)
	 * @see String#format(String, Object...)
	 * @param pattern the message format
	 * @param t the Exception
	 * @param args the message arguments
	 */
	public void infof(String pattern, Throwable t, Object...args);
	/**
	 * convenience method for {@link #logf(Level, String, Throwable, Object..)} with {@link Level#WARNING}.
	 * @see #logf(Level, String, Throwable, Object..)
	 * @see String#format(String, Object...)
	 * @param pattern the message format
	 * @param t the Exception
	 * @param args the message arguments
	 */
	public void warningf(String pattern, Throwable t, Object...args);
	/**
	 * convenience method for {@link #logf(Level, String, Throwable, Object..)} with {@link Level#ERROR}.
	 * @see #logf(Level, String, Throwable, Object..)
	 * @see String#format(String, Object...)
	 * @param pattern the message format
	 * @param t the Exception
	 * @param args the message arguments
	 */
	public void errorf(String pattern, Throwable t, Object...args);
	/**
	 * convenience method for {@link #logf(Level, String, Throwable, Object..)} with {@link Level#FATAL}.
	 * @see #logf(Level, String, Throwable, Object..)
	 * @see String#format(String, Object...)
	 * @param pattern the message format
	 * @param t the Exception
	 * @param args the message arguments
	 */
	public void fatalf(String pattern, Throwable t, Object...args);
	
	/**
	 * checks whether the given log level is enabled for this logger.
	 * @param level the log level to check against
	 * @return true if the log level is enabled
	 */
	public boolean isEnabled(Level level);
	
	public enum Level {
		TRACE,
		DEBUG,
		INFO,
		WARNING,
		ERROR,
		FATAL
	}
}

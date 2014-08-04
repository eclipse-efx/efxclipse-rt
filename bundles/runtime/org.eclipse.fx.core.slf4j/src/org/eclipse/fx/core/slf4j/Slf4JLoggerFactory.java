/*******************************************************************************
 * Copyright (c) 2014 EM-SOFTWARE GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Keimel<c.keimel@emsw.de> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.slf4j;

import java.text.MessageFormat;

import javax.inject.Provider;

import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Factory to create a logger backed by slf4j
 */
public class Slf4JLoggerFactory implements LoggerFactory, Provider<LoggerFactory> {

	@Override
	public LoggerFactory get() {
		return this;
	}
	
	@Override @NonNull 
	public Logger createLogger(@NonNull String name) {
		return new LoggerImpl(name);
	}

	static class LoggerImpl implements Logger {
		private org.slf4j.Logger logger;
		
		private String name;
		
		public LoggerImpl(@NonNull String name) {
			this.name = name;
		}
		
		private org.slf4j.Logger getLogger() {
			if( this.logger == null ) {
				this.logger = org.slf4j.LoggerFactory.getLogger(this.name);
			}
			return this.logger;
		}
		
		@Override
		public void log(@NonNull Level level, @NonNull String message) {
			switch (level) {
			case TRACE:
				getLogger().trace(message);
				break;
			case DEBUG:
				getLogger().debug(message);
				break;
			case INFO:
				getLogger().info(message);
				break;
			case WARNING:
				getLogger().warn(message);
				break;
			case ERROR:
			case FATAL:
				getLogger().error(message);
				break;
			}
		}

		@Override
		public void log(@NonNull Level level, @NonNull String message, @NonNull Throwable t) {
			switch (level) {
			case TRACE:
				getLogger().trace(message, t);
				break;
			case DEBUG:
				getLogger().debug(message, t);
				break;
			case INFO:
				getLogger().info(message, t);
				break;
			case WARNING:
				getLogger().warn(message, t);
				break;
			case ERROR:
			case FATAL:
				getLogger().error(message, t);
				break;
			}
		}

		@SuppressWarnings("null")
		@Override
		public void logf(@NonNull Level level, @NonNull String pattern, Object... args) {
			if(isEnabled(level)) {
				log(level, MessageFormat.format(pattern, args));
			}
		}

		@SuppressWarnings("null")
		@Override
		public void logf(@NonNull Level level, @NonNull String pattern, @NonNull Throwable t, Object... args) {
			if(isEnabled(level)) {
				log(level, MessageFormat.format(pattern, args), t);
			}
		}

		@SuppressWarnings("all")
		@Override
		public void trace(@NonNull String message) {
			log(Level.TRACE, message);
		}

		@SuppressWarnings("all")
		@Override
		public void debug(@NonNull String message) {
			log(Level.DEBUG, message);
		}

		@SuppressWarnings("all")
		@Override
		public void info(@NonNull String message) {
			log(Level.INFO,message);
		}

		@SuppressWarnings("all")
		@Override
		public void warning(@NonNull String message) {
			log(Level.WARNING,message);
		}

		@SuppressWarnings("all")
		@Override
		public void error(@NonNull String message) {
			log(Level.ERROR,message);
		}

		@SuppressWarnings("all")
		@Override
		public void fatal(@NonNull String message) {
			log(Level.FATAL,message);
		}

		@SuppressWarnings("all")
		@Override
		public void trace(@NonNull String message, @NonNull Throwable t) {
			log(Level.TRACE,message,t);
		}

		@SuppressWarnings("all")
		@Override
		public void debug(@NonNull String message, @NonNull Throwable t) {
			log(Level.DEBUG,message,t);
		}

		@SuppressWarnings("all")
		@Override
		public void info(@NonNull String message, @NonNull Throwable t) {
			log(Level.INFO,message,t);
		}

		@SuppressWarnings("all")
		@Override
		public void warning(@NonNull String message, @NonNull Throwable t) {
			log(Level.WARNING,message,t);
		}

		@SuppressWarnings("all")
		@Override
		public void error(@NonNull String message, @NonNull Throwable t) {
			log(Level.ERROR,message,t);
		}

		@SuppressWarnings("all")
		@Override
		public void fatal(@NonNull String message, @NonNull Throwable t) {
			log(Level.FATAL,message,t);
		}

		@SuppressWarnings("all")
		@Override
		public void tracef(String pattern, Object... args) {
			logf(Level.TRACE, pattern, args);
		}

		@SuppressWarnings("all")
		@Override
		public void debugf(@NonNull String pattern, Object... args) {
			logf(Level.DEBUG,pattern,args);
		}

		@SuppressWarnings("all")
		@Override
		public void infof(@NonNull String pattern, Object... args) {
			logf(Level.INFO,pattern,args);
		}
		
		@SuppressWarnings("all")
		@Override
		public void warningf(@NonNull String pattern, Object... args) {
			logf(Level.WARNING,pattern,args);
		}

		@SuppressWarnings("all")
		@Override
		public void errorf(@NonNull String pattern, Object... args) {
			logf(Level.ERROR,pattern,args);
		}

		@SuppressWarnings("all")
		@Override
		public void fatalf(@NonNull String pattern, Object... args) {
			logf(Level.FATAL,pattern,args);
		}

		@SuppressWarnings("all")
		@Override
		public void tracef(@NonNull String pattern, @NonNull Throwable t, Object... args) {
			logf(Level.TRACE,pattern,t,args);
		}

		@SuppressWarnings("all")
		@Override
		public void debugf(@NonNull String pattern, @NonNull Throwable t, Object... args) {
			logf(Level.DEBUG,pattern,t,args);
		}

		@SuppressWarnings("all")
		@Override
		public void infof(@NonNull String pattern, @NonNull Throwable t, Object... args) {
			logf(Level.INFO,pattern,t,args);
		}

		@SuppressWarnings("all")
		@Override
		public void warningf(@NonNull String pattern, @NonNull Throwable t, Object... args) {
			logf(Level.WARNING,pattern,t,args);
		}

		@SuppressWarnings("all")
		@Override
		public void errorf(@NonNull String pattern, @NonNull Throwable t, Object... args) {
			logf(Level.ERROR,pattern,t,args);
		}

		@SuppressWarnings("all")
		@Override
		public void fatalf(@NonNull String pattern, @NonNull Throwable t, Object... args) {
			logf(Level.FATAL,pattern,t,args);
		}

		@Override
		public boolean isEnabled(Level level) {
			switch (level) {
			case TRACE:
				return getLogger().isTraceEnabled();
			case DEBUG:
				return getLogger().isDebugEnabled();
			case INFO:
				return getLogger().isInfoEnabled();
			case WARNING:
				return getLogger().isWarnEnabled();
			case ERROR:
			case FATAL:
				return getLogger().isErrorEnabled();
			}
			return true;
		}
		
	}
}

/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.log4j;

import java.text.MessageFormat;

import javax.inject.Provider;

import org.apache.log4j.Appender;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.fx.core.RankedService;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * Factory to create a logger backed by log4j
 */
@Component(service = LoggerFactory.class, property = "service.ranking:Integer=1")
public class Log4JLoggerFactory implements LoggerFactory, Provider<LoggerFactory>, RankedService {

	/**
	 * Create a new instance
	 */
	public Log4JLoggerFactory() {
		String properties = System.getProperty("efxclipse.log4.properties"); //$NON-NLS-1$
		if (properties != null) {
			PropertyConfigurator.configure(properties);
		}
	}

	/**
	 * Add an appender
	 * 
	 * @param appender
	 *            the appender to add
	 */
	@SuppressWarnings("static-method")
	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY)
	public void registerAppender(Appender appender) {
		org.apache.log4j.Logger.getRootLogger().addAppender(appender);
	}

	/**
	 * Remove the appender
	 * 
	 * @param appender
	 *            the appender to remove
	 */
	@SuppressWarnings("static-method")
	public void unregisterAppender(Appender appender) {
		org.apache.log4j.Logger.getRootLogger().addAppender(appender);
	}

	@Override
	public int getRanking() {
		return 1;
	}

	@Override
	public LoggerFactory get() {
		return this;
	}

	@Override
	public Logger createLogger(String name) {
		return new LoggerImpl(name);
	}

	static class LoggerImpl implements Logger {
		private org.apache.log4j.Logger logger;

		private String name;

		public LoggerImpl(String name) {
			this.name = name;
		}

		private org.apache.log4j.Logger getLogger() {
			if (this.logger == null) {
				this.logger = org.apache.log4j.Logger.getLogger(this.name);
			}
			return this.logger;
		}

		private static org.apache.log4j.Level toLog4JLevel(Level level) {
			switch (level) {
			case DEBUG:
				return org.apache.log4j.Level.DEBUG;
			case ERROR:
				return org.apache.log4j.Level.ERROR;
			case FATAL:
				return org.apache.log4j.Level.FATAL;
			case INFO:
				return org.apache.log4j.Level.INFO;
			case TRACE:
				return org.apache.log4j.Level.TRACE;
			case WARNING:
				return org.apache.log4j.Level.WARN;
			default:
				return org.apache.log4j.Level.ERROR;
			}
		}

		@Override
		public void log(Level level, String message) {
			getLogger().log(toLog4JLevel(level), message);
		}

		@Override
		public void log(Level level, String message, Throwable t) {
			getLogger().log(toLog4JLevel(level), message, t);
		}

		@Override
		public void logf(Level level, String pattern, Object... args) {
			org.apache.log4j.Level log4jLevel = toLog4JLevel(level);
			if (getLogger().isEnabledFor(log4jLevel)) {
				getLogger().log(log4jLevel, MessageFormat.format(pattern, args));
			}
		}

		@Override
		public void logf(Level level, String pattern, Throwable t, Object... args) {
			org.apache.log4j.Level log4jLevel = toLog4JLevel(level);
			if (getLogger().isEnabledFor(log4jLevel)) {
				getLogger().log(log4jLevel, MessageFormat.format(pattern, args), t);
			}
		}

		@SuppressWarnings("all")
		@Override
		public void trace(String message) {
			log(Level.TRACE, message);
		}

		@SuppressWarnings("all")
		@Override
		public void debug(String message) {
			log(Level.DEBUG, message);
		}

		@SuppressWarnings("all")
		@Override
		public void info(String message) {
			log(Level.INFO, message);
		}

		@SuppressWarnings("all")
		@Override
		public void warning(String message) {
			log(Level.WARNING, message);
		}

		@SuppressWarnings("all")
		@Override
		public void error(String message) {
			log(Level.ERROR, message);
		}

		@SuppressWarnings("all")
		@Override
		public void fatal(String message) {
			log(Level.FATAL, message);
		}

		@SuppressWarnings("all")
		@Override
		public void trace(String message, Throwable t) {
			log(Level.TRACE, message, t);
		}

		@SuppressWarnings("all")
		@Override
		public void debug(String message, Throwable t) {
			log(Level.DEBUG, message, t);
		}

		@SuppressWarnings("all")
		@Override
		public void info(String message, Throwable t) {
			log(Level.INFO, message, t);
		}

		@SuppressWarnings("all")
		@Override
		public void warning(String message, Throwable t) {
			log(Level.WARNING, message, t);
		}

		@SuppressWarnings("all")
		@Override
		public void error(String message, Throwable t) {
			log(Level.ERROR, message, t);
		}

		@SuppressWarnings("all")
		@Override
		public void fatal(String message, Throwable t) {
			log(Level.FATAL, message, t);
		}

		@SuppressWarnings("all")
		@Override
		public void tracef(String pattern, Object... args) {
			logf(Level.TRACE, pattern, args);
		}

		@SuppressWarnings("all")
		@Override
		public void debugf(String pattern, Object... args) {
			logf(Level.DEBUG, pattern, args);
		}

		@SuppressWarnings("all")
		@Override
		public void infof(String pattern, Object... args) {
			logf(Level.INFO, pattern, args);
		}

		@SuppressWarnings("all")
		@Override
		public void warningf(String pattern, Object... args) {
			logf(Level.WARNING, pattern, args);
		}

		@SuppressWarnings("all")
		@Override
		public void errorf(String pattern, Object... args) {
			logf(Level.ERROR, pattern, args);
		}

		@SuppressWarnings("all")
		@Override
		public void fatalf(String pattern, Object... args) {
			logf(Level.FATAL, pattern, args);
		}

		@SuppressWarnings("all")
		@Override
		public void tracef(String pattern, Throwable t, Object... args) {
			logf(Level.TRACE, pattern, t, args);
		}

		@SuppressWarnings("all")
		@Override
		public void debugf(String pattern, Throwable t, Object... args) {
			logf(Level.DEBUG, pattern, t, args);
		}

		@SuppressWarnings("all")
		@Override
		public void infof(String pattern, Throwable t, Object... args) {
			logf(Level.INFO, pattern, t, args);
		}

		@SuppressWarnings("all")
		@Override
		public void warningf(String pattern, Throwable t, Object... args) {
			logf(Level.WARNING, pattern, t, args);
		}

		@SuppressWarnings("all")
		@Override
		public void errorf(String pattern, Throwable t, Object... args) {
			logf(Level.ERROR, pattern, t, args);
		}

		@SuppressWarnings("all")
		@Override
		public void fatalf(String pattern, Throwable t, Object... args) {
			logf(Level.FATAL, pattern, t, args);
		}

		@Override
		public boolean isEnabled(Level level) {
			return getLogger().isEnabledFor(toLog4JLevel(level));
		}

	}
}

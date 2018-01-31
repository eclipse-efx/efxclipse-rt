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
package org.eclipse.fx.core.internal;

import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Handler;

import javax.inject.Provider;

import org.eclipse.fx.core.RankedService;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * Concrete implementation for a logger factory using
 * {@link java.util.logging.Logger}
 */
@Component(service = LoggerFactory.class)
public class JUtilLoggerFactory implements LoggerFactory, Provider<LoggerFactory>, RankedService {

	private CopyOnWriteArrayList<java.util.logging.Handler> handlers = new CopyOnWriteArrayList<>();
	private WeakHashMap<LoggerImpl, Boolean> activeLoggers = new WeakHashMap<>();

	/**
	 * Register a handler
	 *
	 * @param handler
	 *            the new handler
	 */
	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY)
	public void registerHandler(Handler handler) {
		this.handlers.add(handler);
		synchronized (this.activeLoggers) {
			this.activeLoggers.keySet().forEach((l) -> l.getLogger().addHandler(handler));
		}
	}

	/**
	 * Unregister a handler
	 *
	 * @param handler
	 *            the new handler
	 */
	public void unregisterHandler(Handler handler) {
		this.handlers.add(handler);
		synchronized (this.activeLoggers) {
			this.activeLoggers.keySet().forEach((l) -> l.getLogger().removeHandler(handler));
		}
	}

	@Override
	public int getRanking() {
		return 0;
	}

	@Override
	public LoggerFactory get() {
		return this;
	}

	@Override
	public Logger createLogger(String name) {
		LoggerImpl loggerImpl = new LoggerImpl(name);
		if (!this.handlers.isEmpty()) {
			java.util.logging.Logger logger = loggerImpl.getLogger();
			this.handlers.forEach(logger::addHandler);
			synchronized (this.activeLoggers) {
				this.activeLoggers.put(loggerImpl, Boolean.TRUE);
			}
		}
		return loggerImpl;
	}

	static class LoggerImpl implements Logger {
		private java.util.logging.Logger logger;

		private String name;

		public LoggerImpl(String name) {
			this.name = name;
		}

		java.util.logging.Logger getLogger() {
			if (this.logger == null) {
				this.logger = java.util.logging.Logger.getLogger(this.name);
			}
			return this.logger;
		}

		private static java.util.logging.Level toLogLevel(Level level) {
			switch (level) {
			case TRACE:
				return java.util.logging.Level.FINEST;
			case DEBUG:
				return java.util.logging.Level.FINE;
			case INFO:
				return java.util.logging.Level.INFO;
			case WARNING:
				return java.util.logging.Level.WARNING;
			case ERROR:
				return java.util.logging.Level.SEVERE;
			case FATAL:
				return java.util.logging.Level.SEVERE;
			default:
				return java.util.logging.Level.SEVERE;
			}
		}

		private void logInternal(Level level, String message, Throwable t) {

			java.util.logging.Level jlevel = toLogLevel(level);

			StackTraceElement frame = null;
			StackTraceElement[] e = Thread.currentThread().getStackTrace();
			if (e.length > 2) {
				for (int i = 2; i < e.length; i++) {
					if (getClass().getName().equals(e[i].getClassName())) {
						continue;
					} else {
						frame = e[i];
						break;
					}
				}
			}

			if (t == null) {
				if (frame != null) {
					getLogger().logp(jlevel, frame.getClassName(), frame.getMethodName(), message);
				} else {
					getLogger().log(jlevel, message);
				}
			} else {
				if (frame != null) {
					getLogger().logp(jlevel, frame.getClassName(), frame.getMethodName(), message, t);
				} else {
					getLogger().log(jlevel, message, t);
				}
			}

		}

		@Override
		public void log(Level level, String message) {
			if (!isEnabled(level)) {
				return;
			}
			logInternal(level, message, null);
		}

		@Override
		public void logf(Level level, String pattern, Throwable t, Object... args) {
			if (!isEnabled(level)) {
				return;
			}
			logInternal(level, String.format(pattern, args), t);
		}

		@Override
		public void logf(Level level, String pattern, Object... args) {
			if (!isEnabled(level)) {
				return;
			}
			logInternal(level, String.format(pattern, args), null);
		}

		@Override
		public void log(Level level, String message, Throwable t) {
			if (!isEnabled(level)) {
				return;
			}
			logInternal(level, message, t);
		}

		@Override
		public void trace(String message) {
			if (!isEnabled(Level.TRACE)) {
				return;
			}
			logInternal(Level.TRACE, message, null);
		}

		@Override
		public void trace(String message, Throwable t) {
			if (!isEnabled(Level.TRACE)) {
				return;
			}
			logInternal(Level.TRACE, message, t);
		}

		@Override
		public void debug(String message) {
			if (!isEnabled(Level.DEBUG)) {
				return;
			}
			logInternal(Level.DEBUG, message, null);
		}

		@Override
		public void debug(String message, Throwable t) {
			if (!isEnabled(Level.DEBUG)) {
				return;
			}
			logInternal(Level.DEBUG, message, t);
		}

		@Override
		public void info(String message) {
			if (!isEnabled(Level.INFO)) {
				return;
			}
			logInternal(Level.INFO, message, null);
		}

		@Override
		public void info(String message, Throwable t) {
			if (!isEnabled(Level.INFO)) {
				return;
			}
			logInternal(Level.INFO, message, t);
		}

		@Override
		public void warning(String message) {
			if (!isEnabled(Level.WARNING)) {
				return;
			}
			logInternal(Level.WARNING, message, null);
		}

		@Override
		public void warning(String message, Throwable t) {
			if (!isEnabled(Level.WARNING)) {
				return;
			}
			logInternal(Level.WARNING, message, t);
		}

		@Override
		public void error(String message) {
			if (!isEnabled(Level.ERROR)) {
				return;
			}
			logInternal(Level.ERROR, message, null);
		}

		@Override
		public void error(String message, Throwable t) {
			if (!isEnabled(Level.ERROR)) {
				return;
			}
			logInternal(Level.ERROR, message, t);
		}

		@Override
		public void fatal(String message) {
			if (!isEnabled(Level.FATAL)) {
				return;
			}
			logInternal(Level.FATAL, message, null);
		}

		@Override
		public void fatal(String message, Throwable t) {
			if (!isEnabled(Level.FATAL)) {
				return;
			}
			logInternal(Level.FATAL, message, t);
		}

		@Override
		public void tracef(String pattern, Object... args) {
			if (!isEnabled(Level.TRACE)) {
				return;
			}
			logInternal(Level.TRACE, String.format(pattern, args), null);
		}

		@Override
		public void tracef(String pattern, Throwable t, Object... args) {
			if (!isEnabled(Level.TRACE)) {
				return;
			}
			logInternal(Level.TRACE, String.format(pattern, args), t);
		}

		@Override
		public void debugf(String pattern, Object... args) {
			if (!isEnabled(Level.DEBUG)) {
				return;
			}
			logInternal(Level.DEBUG, String.format(pattern, args), null);
		}

		@Override
		public void debugf(String pattern, Throwable t, Object... args) {
			if (!isEnabled(Level.DEBUG)) {
				return;
			}
			logInternal(Level.DEBUG, String.format(pattern, args), t);
		}

		@Override
		public void infof(String pattern, Object... args) {
			if (!isEnabled(Level.INFO)) {
				return;
			}
			logInternal(Level.INFO, String.format(pattern, args), null);
		}

		@Override
		public void infof(String pattern, Throwable t, Object... args) {
			if (!isEnabled(Level.INFO)) {
				return;
			}
			logInternal(Level.INFO, String.format(pattern, args), t);
		}

		@Override
		public void warningf(String pattern, Object... args) {
			if (!isEnabled(Level.WARNING)) {
				return;
			}
			logInternal(Level.WARNING, String.format(pattern, args), null);
		}

		@Override
		public void warningf(String pattern, Throwable t, Object... args) {
			if (!isEnabled(Level.WARNING)) {
				return;
			}
			logInternal(Level.WARNING, String.format(pattern, args), t);
		}

		@Override
		public void errorf(String pattern, Object... args) {
			if (!isEnabled(Level.ERROR)) {
				return;
			}
			logInternal(Level.ERROR, String.format(pattern, args), null);
		}

		@Override
		public void errorf(String pattern, Throwable t, Object... args) {
			if (!isEnabled(Level.ERROR)) {
				return;
			}
			logInternal(Level.ERROR, String.format(pattern, args), t);
		}

		@Override
		public void fatalf(String pattern, Object... args) {
			if (!isEnabled(Level.FATAL)) {
				return;
			}
			logInternal(Level.FATAL, String.format(pattern, args), null);
		}

		@Override
		public void fatalf(String pattern, Throwable t, Object... args) {
			if (!isEnabled(Level.FATAL)) {
				return;
			}
			logInternal(Level.FATAL, String.format(pattern, args), t);
		}

		@Override
		public boolean isEnabled(Level level) {
			return getLogger().isLoggable(toLogLevel(level));
		}
	}
}
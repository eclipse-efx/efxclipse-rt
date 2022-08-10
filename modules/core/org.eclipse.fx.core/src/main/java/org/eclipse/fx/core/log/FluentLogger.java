/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
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
package org.eclipse.fx.core.log;

import org.eclipse.fx.core.log.Logger.Level;
import org.eclipse.fx.core.log.internal.FluentLoggerImpl;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A fluent logger API inspired by https://github.com/google/flogger/
 * 
 * @since 3.3.0
 * @noimplement
 */
public interface FluentLogger {
	/**
	 * Adapt the {@link Logger} to a fluent API
	 * 
	 * @param logger
	 *            the logger
	 * @return a fluent logger
	 */
	public static FluentLogger of(@NonNull Logger logger) {
		return new FluentLoggerImpl(logger);
	}

	/**
	 * Create a {@link FluentLogContext} for the specific level
	 * 
	 * @param level
	 *            the level
	 * @return the context
	 */
	public FluentLogContext at(@NonNull Level level);

	/**
	 * @return context at level {@link Level#TRACE}
	 */
	public default FluentLogContext atTrace() {
		return at(Level.TRACE);
	}

	/**
	 * @return context at level {@link Level#DEBUG}
	 */
	public default FluentLogContext atDebug() {
		return at(Level.DEBUG);
	}

	/**
	 * @return context at level {@link Level#INFO}
	 */
	public default FluentLogContext atInfo() {
		return at(Level.INFO);
	}

	/**
	 * @return context at level {@link Level#WARNING}
	 */
	public default FluentLogContext atWarning() {
		return at(Level.WARNING);
	}

	/**
	 * @return context at level {@link Level#ERROR}
	 */
	public default FluentLogContext atError() {
		return at(Level.ERROR);
	}

	/**
	 * @return context at level {@link Level#FATAL}
	 */
	public default FluentLogContext atFatal() {
		return at(Level.FATAL);
	}
}

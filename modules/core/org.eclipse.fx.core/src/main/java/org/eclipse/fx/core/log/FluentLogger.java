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

import org.eclipse.fx.core.log.Logger.Level;
import org.eclipse.fx.core.log.internal.FluentLoggerImpl;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A fluent logger API inspired by https://github.com/google/flogger/
 * 
 * @param <C>
 *            the context type
 * 
 * @since 3.3.0
 * @noimplement
 */
public interface FluentLogger<C extends FluentLogContext<C>> {
	/**
	 * Adapt the {@link Logger} to a fluent API
	 * 
	 * @param logger
	 *            the logger
	 * @return a fluent logger
	 */
	public static FluentLogger<FluentLogContext.Default> of(@NonNull Logger logger) {
		return new FluentLoggerImpl(logger);
	}

	/**
	 * Create a {@link FluentLogContext} for the specific level
	 * 
	 * @param level
	 *            the level
	 * @return the context
	 */
	public C at(@NonNull Level level);

	/**
	 * @return context at level {@link Level#TRACE}
	 */
	public default C atTrace() {
		return at(Level.TRACE);
	}

	/**
	 * @return context at level {@link Level#DEBUG}
	 */
	public default C atDebug() {
		return at(Level.DEBUG);
	}

	/**
	 * @return context at level {@link Level#INFO}
	 */
	public default C atInfo() {
		return at(Level.INFO);
	}

	/**
	 * @return context at level {@link Level#WARNING}
	 */
	public default C atWarning() {
		return at(Level.WARNING);
	}

	/**
	 * @return context at level {@link Level#ERROR}
	 */
	public default C atError() {
		return at(Level.ERROR);
	}

	/**
	 * @return context at level {@link Level#FATAL}
	 */
	public default C atFatal() {
		return at(Level.FATAL);
	}
}

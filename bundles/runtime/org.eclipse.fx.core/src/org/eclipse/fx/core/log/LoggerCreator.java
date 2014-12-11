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
package org.eclipse.fx.core.log;

import org.eclipse.fx.core.Util;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Allows to create a logger
 *
 * @since 1.2
 */
public class LoggerCreator {
	/**
	 * Create a logger for the given class
	 *
	 * @param clazz
	 *            the clazz
	 * @return the logger created
	 */
	@SuppressWarnings("null")
	@NonNull
	public static Logger createLogger(@NonNull Class<?> clazz) {
		@Nullable
		LoggerFactory factory = Util.lookupService(LoggerFactory.class);

		if(factory == null) {
			factory = new JUtilLoggerFactory();
		}
		return factory.createLogger(clazz.getName());
	}
}

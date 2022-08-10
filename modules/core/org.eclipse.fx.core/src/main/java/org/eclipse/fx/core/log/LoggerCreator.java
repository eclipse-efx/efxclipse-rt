/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
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

import org.eclipse.fx.core.ServiceUtils;
import org.eclipse.fx.core.internal.JUtilLoggerFactory;
import org.eclipse.jdt.annotation.NonNull;

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
		LoggerFactory factory = ServiceUtils.getService(LoggerFactory.class).orElse(new JUtilLoggerFactory());
		return factory.createLogger(clazz.getName());
	}
}

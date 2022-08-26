/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core;

/**
 * Utilities to deal with exceptions
 *
 * @since 3.0.0
 */
public class ExceptionUtils {
	/**
	 * Wraps the given {@link Throwable} into a {@link RuntimeException} if
	 * necessary
	 *
	 * @param t
	 *            the throwable
	 * @return a runtime exception
	 */
	public static RuntimeException wrap(Throwable t) {
		if (t instanceof RuntimeException) {
			return (RuntimeException) t;
		} else {
			return new RuntimeException(t);
		}
	}
}

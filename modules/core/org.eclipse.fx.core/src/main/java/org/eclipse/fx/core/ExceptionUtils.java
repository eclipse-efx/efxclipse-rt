/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

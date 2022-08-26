/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
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
package org.eclipse.fx.core.function;

/**
 * Operation that accepts a single value
 *
 * @param <T>
 *            the consumed type
 * @since 1.2
 */
@FunctionalInterface
public interface ExConsumer<T> {
	/**
	 * Method called to consume the value
	 *
	 * @param value
	 *            the value
	 * @throws Throwable
	 *             exception if something goes wrong
	 */
	public void wrappedAccept(T value) throws Throwable;
}

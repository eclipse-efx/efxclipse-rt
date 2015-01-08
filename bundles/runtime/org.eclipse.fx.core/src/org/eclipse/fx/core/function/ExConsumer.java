/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

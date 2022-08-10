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
 * Operation to retrieve a value
 *
 * @param <V>
 *            the value
 * @since 1.2
 */
@FunctionalInterface
public interface ExSupplier<V> {
	/**
	 * Called to request the value
	 *
	 * @return the value
	 * @throws Throwable
	 *             exception if something wrong
	 */
	public V wrappedGet() throws Throwable;
}

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
package org.eclipse.fx.core;

import java.util.function.Predicate;

/**
 * Service to create an instance based on the selector instance
 *
 * @param <S>
 *            the selector type
 * @param <T>
 *            the created type
 * @since 2.1
 */
public interface ObjectFactoryService<S, T> extends Predicate<S> {

	/**
	 * Create an instance for the selector
	 *
	 * @param s
	 *            the selector
	 * @return the type
	 */
	public T create(S s);
}

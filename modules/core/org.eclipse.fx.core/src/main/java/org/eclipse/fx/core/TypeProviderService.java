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
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core;

import java.util.function.Predicate;

/**
 * A service who provides a type based upon a selector value
 *
 * @param <S>
 *            the selector value type
 * @param <T>
 *            the type
 * @since 2.1
 */
public interface TypeProviderService<S, T> extends Predicate<S> {

	/**
	 * Get the type for the selector
	 *
	 * @param s
	 *            the selector
	 * @return the type
	 */
	public Class<? extends T> getType(S s);
}

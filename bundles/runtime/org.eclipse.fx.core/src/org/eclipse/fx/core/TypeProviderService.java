/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core;

import java.util.function.Predicate;

/**
 * A service who provides a type based upon selector type
 *
 * @param <S>
 *            the selector type
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

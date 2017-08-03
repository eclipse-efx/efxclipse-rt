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

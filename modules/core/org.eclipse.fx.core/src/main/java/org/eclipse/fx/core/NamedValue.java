/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
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

import org.eclipse.jdt.annotation.NonNull;

/**
 * Basic interface for a named value representation
 *
 * @param <T>
 *            the named value
 * @since 2.4.0
 */
public interface NamedValue<T> {
	/**
	 * @return the name
	 */
	public @NonNull String getName();

	/**
	 * @return the value
	 */
	public T getValue();
}

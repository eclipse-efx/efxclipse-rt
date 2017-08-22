/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

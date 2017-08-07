/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core;

import org.eclipse.jdt.annotation.Nullable;

/**
 * A simply callback class with a value
 * 
 * @param <T>
 *            the type passed to {@link #call(Object)}
 */
public interface Callback<T> {
	/**
	 * Method invoked
	 * 
	 * @param value
	 *            the value
	 */
	public void call(@Nullable T value);
}

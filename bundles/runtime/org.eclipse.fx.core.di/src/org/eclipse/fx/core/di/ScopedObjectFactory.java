/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An object factory is bound to the local context and is able to create
 * instances using a the backing DI container
 */
public interface ScopedObjectFactory {
	/**
	 * Create a new instance of the class
	 * 
	 * @param c
	 *            the class
	 * @return the instance
	 */
	public <C> C newInstance(@NonNull Class<@NonNull C> c);

	/**
	 * Create a child of the scoped object factory
	 * 
	 * @param name
	 *            the name
	 * 
	 * @return the child
	 */
	public @NonNull ScopedObjectFactory createChild(@NonNull String name);

	/**
	 * Push a new value
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void put(@NonNull String key, @NonNull Object value);

	/**
	 * Push a new value
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public <O> void put(@NonNull Class<@NonNull O> key, @NonNull O value);	
}

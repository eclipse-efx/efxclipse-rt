/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
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
package org.eclipse.fx.core.di;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An object factory is bound to the local context and is able to create
 * instances using a the backing DI container
 */
public interface ScopedObjectFactory {
	/**
	 * EventBroker topic published when key is modified
	 */
	public static String KEYMODIFED_TOPIC = "org/eclipse/fx/context/key"; //$NON-NLS-1$

	/**
	 * Create a new instance of the class
	 *
	 * @param c
	 *            the class
	 * @param <C>
	 *            the type
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
	 * @param <O>
	 *            the value type
	 */
	public <O> void put(@NonNull Class<@NonNull O> key, @NonNull O value);

	/**
	 * Invoke a method annotated with {@link Invoke}
	 *
	 * @param instance
	 *            the instance on which the method is invoked
	 * @param <O>
	 *            the value type
	 * @return the return value
	 * @throws IllegalStateException
	 *             in case there's no method that could be invoked
	 */
	public <O> @Nullable O invoke(@NonNull Object instance) throws IllegalStateException;

	/**
	 * Dispose the factory
	 */
	public void dispose();
}

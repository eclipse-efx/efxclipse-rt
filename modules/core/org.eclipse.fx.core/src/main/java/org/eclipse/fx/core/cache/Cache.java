/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
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
package org.eclipse.fx.core.cache;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * Basic interface for a cache
 *
 * <p>
 * This is provisional API and subject to change
 * </p>
 *
 * @param <K>
 *            the key
 * @param <V>
 *            the value
 * @since 3.0
 */
public interface Cache<K, V> {
	/**
	 * Retrieve the value associated with the provided key
	 *
	 * @param key
	 *            the key
	 * @return the associated value wrapped into an {@link Optional} or an empty
	 *         optional
	 */
	public Optional<V> get(K key);

	/**
	 * Compute the value if not present
	 *
	 * @param key
	 *            the to use
	 * @param function
	 *            the function to compute the value
	 * @return future with the result of the computation
	 */
	public CompletableFuture<V> computeIfAbsent(K key, Function<K, V> function);

	/**
	 * Associate the provided value with the object
	 *
	 * @param key
	 *            the key
	 * @param object
	 *            the value
	 */
	public void put(K key, V object);

	/**
	 * Remove the value associated with the key from the cache
	 *
	 * @param key
	 *            the key
	 */
	public void evict(K key);
}

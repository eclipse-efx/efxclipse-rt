/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.cache.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import org.eclipse.fx.core.cache.Cache;

/**
 * An implementation backed by a {@link HashMap}
 *
 * @param <K>
 *            the key type
 * @param <V>
 *            the value type
 */
public class SimpleMapCache<K, V> implements Cache<K, V> {

	private Map<K, V> map = new HashMap<>();

	@Override
	public Optional<V> get(K key) {
		synchronized (this.map) {
			return Optional.ofNullable(this.map.get(key));
		}
	}

	@Override
	public CompletableFuture<V> computeIfAbsent(K key, Function<K, V> function) {
		synchronized (this.map) {
			if (this.map.containsKey(key)) {
				return CompletableFuture.completedFuture(this.map.get(key));
			}
		}

		return CompletableFuture.supplyAsync(() -> {
			V v = function.apply(key);
			put(key, v);
			return v;
		});
	}

	@Override
	public void put(K key, V object) {
		synchronized (this.map) {
			this.map.put(key, object);
		}
	}

	@Override
	public void evict(K key) {
		synchronized (this.map) {
			// TODO If there's a computation running for this key we need to
			// cancel that
			this.map.remove(key);
		}
	}
}
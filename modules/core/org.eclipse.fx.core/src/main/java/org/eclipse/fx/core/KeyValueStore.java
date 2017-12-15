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

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A simple key value store
 *
 * @param <K>
 *            the key
 * @param <V>
 *            the value
 */
public interface KeyValueStore<K, V> {
	/**
	 * The value stored at this key
	 *
	 * @param key
	 *            the key
	 * @return the value
	 * @throws IllegalArgumentException
	 *             thrown if there's no value for this key
	 */
	public V get(K key) throws IllegalArgumentException;

	/**
	 * Check if there's a value for the key
	 *
	 * @param key
	 *            the key
	 * @return <code>true</code> if there's a value (even a null) stored at this key
	 */
	public boolean contains(K key);

	/**
	 * @return all keys
	 */
	public Set<K> getKeys();

	/**
	 * @return all values
	 */
	public Collection<V> getValues();

	/**
	 * @return the key value store as a map
	 */
	public default Map<K, V> toMap() {
		Map<K, V> map = new HashMap<>();
		for (K k : getKeys()) {
			map.put(k, get(k));
		}
		return map;
	}

	/**
	 * Create a store from the map
	 * 
	 * @param <K>
	 *            the key type
	 * @param <V>
	 *            the value type
	 * @param map
	 *            the map
	 * @return a key value store backed by the map
	 */
	public static <K, V> KeyValueStore<K, V> fromMap(Map<K, V> map) {
		return new KeyValueStore<K, V>() {

			@Override
			public V get(K key) {
				V v = map.get(key);
				if (v == null) {
					if (!contains(key)) {
						throw new IllegalArgumentException("The key '" + key + "' is not known"); //$NON-NLS-1$//$NON-NLS-2$
					}
				}
				return v;
			}

			@Override
			public Set<K> getKeys() {
				return map.keySet();
			}

			@Override
			public Collection<V> getValues() {
				return map.values();
			}

			@Override
			public boolean contains(K key) {
				return map.containsKey(key);
			}

			@Override
			public Map<K, V> toMap() {
				return Collections.unmodifiableMap(map);
			}
		};
	}
}

/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
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
package org.eclipse.fx.core.preferences;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Factory interface to create instance of a type with the information from the
 * preferences
 *
 * @param <O>
 *            the type
 */
public interface PreferenceDefaultValueFactory<O> {
	/**
	 * Create a value
	 *
	 * @param preference
	 *            the preference
	 * @return the created instance
	 */
	public O create(Preference preference);

	/**
	 * Empty list factory
	 *
	 * @param <O>
	 *            list element type
	 */
	public static class EmptyListFactory<O> implements PreferenceDefaultValueFactory<List<O>> {

		@Override
		public List<O> create(Preference preference) {
			return Collections.emptyList();
		}
	}

	/**
	 * Empty set factory
	 *
	 * @param <O>
	 *            the set type
	 */
	public static class EmptySetFactory<O> implements PreferenceDefaultValueFactory<Set<O>> {

		@Override
		public Set<O> create(Preference preference) {
			return Collections.emptySet();
		}
	}

	/**
	 * Empty map factory
	 *
	 * @param <K>
	 *            the key type
	 * @param <V>
	 *            the value type
	 */
	public static class EmptyMapFactory<K, V> implements PreferenceDefaultValueFactory<Map<K, V>> {

		@Override
		public Map<K, V> create(Preference preference) {
			return Collections.emptyMap();
		}
	}
}

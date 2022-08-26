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

/**
 * Factory to create a cache instance
 *
 * @since 3.0
 */
public interface CacheFactory {
	/**
	 * Create a new cache instance
	 *
	 * @param configurationName
	 *            the configuration name used to configure the cache instance
	 * @return a new cache instance
	 */
	public <K, V> Cache<K, V> createCache(String configurationName);
}

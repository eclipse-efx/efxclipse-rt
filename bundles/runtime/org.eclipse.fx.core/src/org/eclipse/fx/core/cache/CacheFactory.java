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

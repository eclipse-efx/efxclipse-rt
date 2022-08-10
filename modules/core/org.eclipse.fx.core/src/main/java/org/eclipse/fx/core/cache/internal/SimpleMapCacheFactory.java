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
package org.eclipse.fx.core.cache.internal;

import org.eclipse.fx.core.cache.Cache;
import org.eclipse.fx.core.cache.CacheFactory;
import org.osgi.service.component.annotations.Component;

/**
 * Factory to create a simple cache
 */
@Component
public class SimpleMapCacheFactory implements CacheFactory {

	@Override
	public <K, V> Cache<K, V> createCache(String configurationName) {
		return new SimpleMapCache<>();
	}

}

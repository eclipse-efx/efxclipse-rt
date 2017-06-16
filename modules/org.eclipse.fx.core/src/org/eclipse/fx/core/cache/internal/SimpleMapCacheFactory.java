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

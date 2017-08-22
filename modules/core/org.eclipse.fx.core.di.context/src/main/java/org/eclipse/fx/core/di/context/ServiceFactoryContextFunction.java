/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di.context;

import java.util.Optional;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.ObjectFactoryService;

/**
 * Service function who uses a {@link ObjectFactoryService} to create an
 * instance
 *
 * @param <S>
 *            the selector type
 * @param <T>
 *            the type to be created
 * @param <O>
 *            the factory service type
 */
public abstract class ServiceFactoryContextFunction<S, T, O extends ObjectFactoryService<S, T>>
		extends ServiceContextFunction<O> {

	private String selectorTypeKey;

	/**
	 * Create a new instance
	 *
	 * @param selectorTypeKey
	 *            the key used to extract the type from the context
	 */
	protected ServiceFactoryContextFunction(String selectorTypeKey) {
		this.selectorTypeKey = selectorTypeKey;
	}

	/**
	 * @return the cache key
	 */
	protected String getCacheKey() {
		return "__cached_type_" + getClass().getName(); //$NON-NLS-1$
	}

	@Override
	public final Object compute(IEclipseContext context) {
		String cacheKey = getCacheKey();
		Object o = context.get(cacheKey);

		if (o != null) {
			return o;
		}

		@SuppressWarnings("unchecked")
		S sourceValue = (S) context.get(this.selectorTypeKey);

		Optional<T> value;
		synchronized (this.registry) {
			value = this.registry.unsynchronizedStream().filter(d -> d.test(sourceValue)).findFirst()
					.map(d -> d.create(sourceValue));
		}

		if (value.isPresent()) {
			o = value.get();
			context.set(cacheKey, o);
			return o;
		} else {
			throw new IllegalStateException("Unable to find a service factory for the source value '"+sourceValue+"'");  //$NON-NLS-1$//$NON-NLS-2$
		}
	}

	@Override
	public final Object compute(IEclipseContext context, String contextKey) {
		return super.compute(context, contextKey);
	}
}
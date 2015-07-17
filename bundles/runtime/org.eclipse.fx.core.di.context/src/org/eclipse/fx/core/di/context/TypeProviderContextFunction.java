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

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.TypeProviderService;

/**
 * A context function who creates a type through the provided type
 *
 * @param <S>
 *            the selector type
 * @param <T>
 *            the target type
 * @param
 * 			<P>
 *            the provider service
 */
public abstract class TypeProviderContextFunction<S, T, P extends TypeProviderService<S, T>>
		extends ServiceContextFunction<P> {
	static class Registration<P> implements Comparable<Registration<P>> {
		final int rank;
		final P provider;

		public Registration(int rank, P provider) {
			this.rank = rank;
			this.provider = provider;
		}

		@Override
		public int compareTo(Registration<P> o) {
			int v = Integer.compare(this.rank, o.rank);
			if (v == 0) {
				v = this.provider.getClass().toString().compareTo(o.provider.getClass().getName());
			}
			return v;
		}
	}

	private final String selectorTypeKey;

	/**
	 * Create a new function
	 *
	 * @param selectorTypeKey
	 *            the key to extract the selector from the context
	 */
	public TypeProviderContextFunction(String selectorTypeKey) {
		this.selectorTypeKey = selectorTypeKey;
	}

	/**
	 * @return the cache key to be used
	 */
	protected String getCacheKey() {
		return "__cached_type_" + getClass().getName(); //$NON-NLS-1$
	}

	/**
	 * Called before the extraction and creation of the instance is done
	 *
	 * @param context
	 *            the context
	 */
	protected void preTypeCreation(IEclipseContext context) {
		// do nothing by default
	}

	@Override
	public final Object compute(IEclipseContext context) {
		String cacheKey = getCacheKey();
		Object o = context.get(cacheKey);

		if (o != null) {
			return o;
		}

		preTypeCreation(context);

		@SuppressWarnings("unchecked")
		S s = (S) context.get(this.selectorTypeKey);

		Optional<? extends T> value;
		synchronized (this.registry) {
			value = this.registry.unsynchronizedStream().filter(p -> p.test(s)).findFirst()
					.map(p -> ContextInjectionFactory.make(p.getType(s), context));
		}

		if (value.isPresent()) {
			T v = value.get();
			context.set(cacheKey, v);
			return v;
		} else {
			return null;
		}
	}

	@Override
	public final Object compute(IEclipseContext context, String contextKey) {
		return super.compute(context, contextKey);
	}
}
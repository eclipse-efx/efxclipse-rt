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
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di.context;

import java.util.Optional;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.TypeProviderService;
import org.eclipse.jdt.annotation.NonNull;

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
public abstract class TypeProviderContextFunction<S, T, P extends TypeProviderService<S, T>> extends ServiceContextFunction<P> {

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
	public final Object compute(IEclipseContext _context) {
		if (_context == null) {
			return null;
		}
		IEclipseContext context = getTargetContext(_context);
		String cacheKey = getCacheKey();
		Object o = context.get(cacheKey);

		if (o != null) {
			return o;
		}

		preTypeCreation(context);

		S s = getSelectorValue(context);

		if( s == null ) {
			return null;
		}

		Optional<? extends T> value;
		synchronized (this.registry) {
			value = this.registry.unsynchronizedStream().filter(p -> p.test(s)).findFirst().map(p -> ContextInjectionFactory.make(p.getType(s), context));
		}

		if (value.isPresent()) {
			T v = value.get();
			if (v != null) {
				postInstanceCreation(v, context);
			}
			context.set(cacheKey, v);
			return v;
		} else {
			T v = createDefault(context);
			if (v != null) {
				postInstanceCreation(v, context);
			}
			context.set(cacheKey, v);
			return v;
		}
	}

	/**
	 * Create a default value if no provider matched
	 *
	 * @param context
	 *            the context
	 * @return the default or <code>null</code>
	 * @since 2.4.0
	 */
	@SuppressWarnings("null")
	protected T createDefault(IEclipseContext context) {
		return (T) null;
	}

	/**
	 * Post process the created instance
	 *
	 * @param type
	 *            the type
	 * @param context
	 *            the context the instance is created on
	 * @since 2.2.0
	 */
	protected void postInstanceCreation(@NonNull T type, IEclipseContext context) {
		// nothing by default
	}

	/**
	 * Extract the target context
	 *
	 * @param context
	 *            the context
	 * @return the context
	 */
	@SuppressWarnings("static-method")
	protected @NonNull IEclipseContext getTargetContext(@NonNull IEclipseContext context) {
		return context;
	}

	/**
	 * Get the selector value
	 *
	 * @param context
	 *            the context
	 * @return the value
	 */
	@SuppressWarnings("unchecked")
	protected S getSelectorValue(IEclipseContext context) {
		return (S) context.get(this.selectorTypeKey);
	}

	@Override
	public final Object compute(IEclipseContext context, String contextKey) {
		return super.compute(context, contextKey);
	}
}
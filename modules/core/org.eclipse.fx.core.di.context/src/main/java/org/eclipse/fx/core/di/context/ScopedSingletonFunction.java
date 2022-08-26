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
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di.context;

import java.util.Optional;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;

/**
 * <p>
 * Base class for {@link IContextFunction}s who compute a singleton in a certain
 * context.
 * </p>
 * <p>
 * Implementing a Window-Singleton Function for an Eclipse 4 application would look like this:
 * </p>
 * 
 * <code><pre>
 * class WindowSingletonFunction extends ScopedSingletonFunction&lt;MyService&gt; {
 *   public Optional&lt;IEclipseContext&gt; computeSingletonContext(IEclipseContext context) {
 *     return context.get(MWindow.class).getContext();
 *   }
 *   
 *   public MyService create(IEclipseContext context) {
 *     return ContextInjectionFactory.make(MyWindowServiceImpl.class, context);
 *   }
 * }
 * </pre></code>
 * 
 * @param <T>
 *            the computed type
 * @since 3.2.0
 */
public abstract class ScopedSingletonFunction<T> extends ContextFunction {
	/**
	 * Compute the singleton context
	 * 
	 * @param context
	 *            the current local context
	 * @return the computed context, if an empty {@link Optional} is returned the
	 *         provided context is used as the singleton context
	 */
	protected abstract Optional<IEclipseContext> computeSingletonContext(IEclipseContext context);

	/**
	 * Create the instance
	 * 
	 * @param context
	 *            the context the singleton instance is created on
	 * @return the instance
	 */
	protected abstract T create(IEclipseContext context);

	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		String key = "singleton_" + contextKey; //$NON-NLS-1$

	
			Optional<IEclipseContext> singletonContext = computeSingletonContext(context);
			if (!singletonContext.isPresent() || singletonContext.get() == context) {
				Object object = context.getLocal(key);
				if(object!=null) {
					return object;
				}
				T instance = create(context);
				context.set(key, instance);
				return instance;
			} else {
				return singletonContext.get().get(contextKey);
			}
		
	}

	@Override
	public final Object compute(IEclipseContext context) {
		return super.compute(context);
	}
}

/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di.context.internal;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.di.ScopedObjectFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Context function to create requested object factory
 */
public class ScopedObjectFactoryFunction extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		return new ScopedObjectFactoryImpl(context);
	}
	
	static class ScopedObjectFactoryImpl implements ScopedObjectFactory {
		private final IEclipseContext context;
		
		ScopedObjectFactoryImpl(IEclipseContext context) {
			this.context = context;
		}
		
		@Override
		public <C> C newInstance(Class<C> c) {
			return ContextInjectionFactory.make(c, this.context);
		}

		@Override
		public @NonNull ScopedObjectFactory createChild(@NonNull String name) {
			return new ScopedObjectFactoryImpl(this.context.createChild(name));
		}
		
		@Override
		public <O> void put(@NonNull Class<@NonNull O> key, @NonNull O value) {
			this.context.set(key, value);
		}
		
		@Override
		public void put(@NonNull String key, @NonNull Object value) {
			this.context.set(key, value);
		}
	}
}

/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.di.ScopedObjectFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Context function who creates a singleton instance
 *
 * @param <T>
 *            the type to create
 * @since 1.1
 */
public abstract class ContextSingletonFunction<T> extends ContextFunction {
	@NonNull
	private final Class<@NonNull T> type;

	/**
	 * Create a function who creates an instance of the object only once
	 *
	 * @param type
	 *            the type
	 */
	public ContextSingletonFunction(@NonNull Class<@NonNull T> type) {
		this.type = type;
	}

	@Override
	public Object compute(IEclipseContext context) {
		String key = "local_" + this.type; //$NON-NLS-1$
		@SuppressWarnings("unchecked")
		T rv = (T) context.get(key);
		if (rv == null) {
			ScopedObjectFactory factory = context.get(ScopedObjectFactory.class);
			rv = factory.newInstance(this.type);
			context.modify(key, rv);
		}
		return rv;
	}
}

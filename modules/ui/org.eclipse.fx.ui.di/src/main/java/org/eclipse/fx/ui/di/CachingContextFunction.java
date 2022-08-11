/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
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
package org.eclipse.fx.ui.di;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;

/**
 * A context function which caches the value so that child contexts don't create
 * an instance them selfes
 */
public abstract class CachingContextFunction extends ContextFunction {
	private final Class<?> clazz;

	/**
	 * Create a instance
	 * 
	 * @param clazz
	 *            the class to create an instance of
	 */
	public CachingContextFunction(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public final Object compute(IEclipseContext context) {
		Object rv = context.get("cached_" + this.clazz.getName()); //$NON-NLS-1$
		if (rv == null) {
			rv = ContextInjectionFactory.make(this.clazz, context);
			context.set("cached_" + this.clazz.getName(), rv); //$NON-NLS-1$
		}
		return rv;
	}
	
	@Override
	public final Object compute(IEclipseContext context, String contextKey) {
		return super.compute(context, contextKey);
	}
}
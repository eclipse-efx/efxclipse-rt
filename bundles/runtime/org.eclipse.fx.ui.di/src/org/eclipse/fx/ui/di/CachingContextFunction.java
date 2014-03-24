/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	public Object compute(IEclipseContext context) {
		Object rv = context.get("cached_" + this.clazz.getName()); //$NON-NLS-1$
		if (rv == null) {
			rv = ContextInjectionFactory.make(this.clazz, context);
			context.set("cached_" + this.clazz.getName(), rv); //$NON-NLS-1$
		}
		return rv;
	}
}
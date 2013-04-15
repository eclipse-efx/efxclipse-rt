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

@SuppressWarnings("restriction")
public abstract class CachingContextFunction extends ContextFunction {
	private final Class<?> clazz;
	
	public CachingContextFunction(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public Object compute(IEclipseContext context) {
		Object rv = context.get("cached_" + clazz.getName());
		if( rv == null ) {
			rv = ContextInjectionFactory.make(clazz, context);
			context.set("cached_" + clazz.getName(), rv);
		}
		return rv;
	}	
}
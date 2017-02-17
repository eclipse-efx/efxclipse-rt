/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di.context;

import java.util.Map;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.di.ObjectFactory;
import org.eclipse.fx.core.di.ScopedObjectFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Context function who delegates to an OSGi-Service to create instances.
 * <p>
 * The OSGi-Function is searched by appending "Factory" to the type named provided
 * as {@link IContextFunction#SERVICE_CONTEXT_KEY}. e.g. <code>PersonListService</code> is assumed
 * to be created by <code>PersonListServiceFactory</code>
 * </p>
 * @since 1.1
 */
public class FactoryContextFunction extends ContextFunction {
	private String factoryClass;
	private String type;
	private boolean singleton;

	/**
	 * Key to be used in registry to require singleton
	 */
	public static final String SINGLETON = "org.eclipse.fx.context.singleton"; //$NON-NLS-1$

	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		if( this.singleton ) {
			String key = "singleton_" + this.type; //$NON-NLS-1$
			Object rv = context.get(key);
			if (rv == null) {
				ScopedObjectFactory factory = context.get(ScopedObjectFactory.class);
				ObjectFactory<@NonNull ?> f = (ObjectFactory<@NonNull ?>) context.get(this.factoryClass);
				if( f != null && factory != null ) {
					rv = f.create(factory);
					context.modify(key, rv);
				}
			}
			return rv;
		} else {
			ScopedObjectFactory factory = context.get(ScopedObjectFactory.class);
			ObjectFactory<@NonNull ?> f = (ObjectFactory<@NonNull ?>) context.get(this.factoryClass);
			if( f != null && factory != null ) {
				return f.create(factory);
			}
		}
		return null;
	}

	/**
	 * Called by OSGi when activating the component
	 *
	 * @param config
	 *            the config
	 */
	public void activate(Map<String, Object> config) {
		this.type = (String) config.get(SERVICE_CONTEXT_KEY);
		this.factoryClass = this.type + "Factory"; //$NON-NLS-1$
		this.singleton = config.get(SINGLETON) == Boolean.TRUE;
	}
}

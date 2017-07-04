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

import static org.eclipse.fx.core.RankedObjectRegistry.getOSGiServiceRank;

import java.util.Map;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.fx.core.RankedObjectRegistry;

/**
 * Service function who stores services
 *
 * @param <S>
 *            the service type
 */
public abstract class ServiceContextFunction<S> extends ContextFunction {
	/**
	 * Registry with the services
	 */
	protected final RankedObjectRegistry<S> registry = new RankedObjectRegistry<>();

	/**
	 * Register a service
	 *
	 * @param service
	 *            the service
	 * @param properties
	 *            the properties
	 */
	protected void _registerService(S service, Map<String, Object> properties) {
		this.registry.registerObject(getOSGiServiceRank(properties), service);
	}

	/**
	 * Unregister a service
	 *
	 * @param service
	 *            the service
	 */
	protected void _unregisterService(S service) {
		this.registry.unregisterObject(service);
	}
}

/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.guice;

import org.eclipse.fx.core.log.LoggerFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import com.google.inject.Provider;

/**
 * A logger provider who is backed by the OSGi-Service registry
 */
public class OSGiLoggerFactoryProvider implements Provider<LoggerFactory> {

	private LoggerFactory instance = null;

	@Override
	public LoggerFactory get() {
		if (this.instance == null) {
			BundleContext context = FrameworkUtil.getBundle(getClass()).getBundleContext();
			ServiceReference<LoggerFactory> ref = context.getServiceReference(LoggerFactory.class);
			this.instance = context.getService(ref);
		}
		return this.instance;
	}

}
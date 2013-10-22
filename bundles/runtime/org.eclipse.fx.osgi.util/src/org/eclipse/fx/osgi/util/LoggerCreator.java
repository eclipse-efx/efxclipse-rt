/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.osgi.util;

import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

public class LoggerCreator {
	public static Logger createLogger(Class<?> clazz) {
		Bundle b = FrameworkUtil.getBundle(clazz);
		BundleContext ctx = null;
		if (b != null) {
			ctx = b.getBundleContext();
		}

		if (ctx == null) {
			b = FrameworkUtil.getBundle(LoggerCreator.class);

			if (b != null) {
				ctx = b.getBundleContext();
			}
		}

		ServiceReference<LoggerFactory> ref = ctx.getServiceReference(LoggerFactory.class);
		return ctx.getService(ref).createLogger(clazz.getName());
	}
}

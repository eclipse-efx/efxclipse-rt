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
package org.eclipse.fx.core;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

/**
 * Class with static utility methods
 */
public class Util {
	/**
	 * @return <code>true</code> if we are on JavaFX 2
	 */
	public static boolean isFX2() {
		return System.getProperty("javafx.version") != null && System.getProperty("javafx.version").startsWith("2"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	private static Boolean isOSGi;

	/**
	 * @return <code>true</code> if running on OSGi
	 */
	public static boolean isOsgiEnv() {
		if (isOSGi == null) {
			isOSGi = Boolean.FALSE;
			try {
				Class.forName("org.osgi.framework.FrameworkUtil"); //$NON-NLS-1$
				if( org.osgi.framework.FrameworkUtil.getBundle(Util.class) != null ) {
					isOSGi = Boolean.TRUE;
				}
			} catch (Throwable e) {
				// nothing
			}
		}
		return isOSGi.booleanValue();
	}

	/**
	 * Look up the service with the given type
	 *
	 * @param serviceClass
	 *            the service class type
	 * @return the service with the highest rank or <code>null</code>
	 */
	public static <@Nullable S> @Nullable S lookupService(Class<S> serviceClass) {
		if (isOsgiEnv()) {
			Bundle b = FrameworkUtil.getBundle(serviceClass);
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

			if (ctx == null) {
				throw new IllegalStateException("Unable to get a bundle context"); //$NON-NLS-1$
			}

			ServiceReference<S> serviceReference = ctx.getServiceReference(serviceClass);
			if (serviceReference != null) {
				return ctx.getService(serviceReference);
			}
			return null;
		} else {
			ServiceLoader<S> serviceLoader = ServiceLoader.load(serviceClass);
			Iterator<S> iterator = serviceLoader.iterator();
			S rv = null;
			int cur = 0;
			while (iterator.hasNext()) {
				@Nullable
				S next = iterator.next();
				if (rv == null) {
					rv = next;

					if (rv instanceof RankedService) {
						cur = ((RankedService) rv).getRanking();
					}
				} else if (next instanceof RankedService) {
					int ranking = ((RankedService) next).getRanking();
					if (cur < ranking) {
						rv = next;
						cur = ranking;
					}
				}
			}
			return rv;
		}
	}

}

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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
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
				if (org.osgi.framework.FrameworkUtil.getBundle(Util.class) != null) {
					isOSGi = Boolean.TRUE;
				}
			} catch (Throwable e) {
				// nothing
			}
		}
		return isOSGi.booleanValue();
	}

	private static BundleContext getContext(List<Class<?>> classList) {
		for( Class<?> cl : classList ) {
			Bundle b = FrameworkUtil.getBundle(cl);
			BundleContext ctx = null;
			if (b != null) {
				ctx = b.getBundleContext();
				if( ctx != null ) {
					return ctx;
				}
			}
		}

		Bundle b = FrameworkUtil.getBundle(Util.class);
		BundleContext ctx = null;

		if (b != null) {
			ctx = b.getBundleContext();
		}

		if (ctx == null) {
			throw new IllegalStateException(
					"Unable to get a bundle context"); //$NON-NLS-1$
		}

		return ctx;
	}

	@SuppressWarnings("null")
	private static <S> @Nullable S _lookupService(
			@Nullable Class<?> requestor, @NonNull Class<S> serviceClass) {
		List<@NonNull S> _lookupServiceList = _lookupServiceList(requestor, serviceClass);
		if( ! _lookupServiceList.isEmpty() ) {
			return _lookupServiceList.get(0);
		}
		return null;
	}

	static class CompareableService<@NonNull S> implements Comparable<CompareableService<S>> {
		private final ServiceReference<S> r;
		final S instance;

		public CompareableService(ServiceReference<S> r, S instance) {
			this.r = r;
			this.instance = instance;
		}

		private static int getRanking(ServiceReference<?> r) {
			Object v = r.getProperty("service.ranking"); //$NON-NLS-1$
			if( v instanceof Integer ) {
				return ((Integer)v).intValue();
			}
			return 0;
		}

		@Override
		public int compareTo(CompareableService<S> o) {
			int i1;
			int i2;
			if( this.instance instanceof RankedService && o.instance instanceof RankedService ) {
				i1 = ((RankedService)this.instance).getRanking();
				i2 = ((RankedService)o.instance).getRanking();
			} else {
				i1 = getRanking(this.r);
				i2 = getRanking(o.r);
			}
			return Integer.compare(i1, i2);
		}
	}

	private static Map<Class<?>, ServiceLoader<?>> LOADER_CACHE = new HashMap<Class<?>, ServiceLoader<?>>();

	@SuppressWarnings("unchecked")
	private static <S> ServiceLoader<S> getLoader(Class<S> clazz) {
		ServiceLoader<S> l = (ServiceLoader<S>) LOADER_CACHE.get(clazz);
		if( l == null ) {
			l = ServiceLoader.load(clazz);
			LOADER_CACHE.put(clazz, l);
		}
		return l;
	}

	@SuppressWarnings("null")
	private static <S> @NonNull List<@NonNull S> _lookupServiceList(
			@Nullable Class<?> requestor, @NonNull Class<S> serviceClass) {
		if (isOsgiEnv()) {
			List<Class<?>> cl = new ArrayList<>();
			if( requestor != null ) {
				cl.add(requestor);
			}
			cl.add(serviceClass);
			BundleContext ctx = getContext(cl);

			try {
				@SuppressWarnings("unchecked")
				ServiceReference<S>[] serviceReferences = (ServiceReference<S>[]) ctx.getServiceReferences(serviceClass.getName(), null);
				return Stream.of(serviceReferences).map( r -> new CompareableService<>(r,ctx.getService(r))).sorted().map(s -> s.instance).collect(Collectors.toList());
			} catch (InvalidSyntaxException e) {
				throw new IllegalStateException(e);
			}

		} else {
			ServiceLoader<S> serviceLoader = getLoader(serviceClass);
			Iterator<S> iterator = serviceLoader.iterator();
			List<S> rv = new ArrayList<>();
			while (iterator.hasNext()) {
				rv.add(iterator.next());
			}
			Collections.sort(rv,  (o1,o2) -> {
				if(o1 instanceof RankedService && o2 instanceof RankedService) {
					return Integer.compare(((RankedService)o1).getRanking(), ((RankedService)o2).getRanking());
				} else {
					return 0;
				}
			});
			return rv;
		}
	}

	/**
	 * Look up the service with the given type
	 *
	 * @param requestor
	 *            the class requesting the service
	 *
	 * @param serviceClass
	 *            the service class type
	 * @return the service with the highest rank or <code>null</code>
	 * @since 1.2
	 */
	@SuppressWarnings("null")
	public static <S> @Nullable S lookupService(@NonNull Class<?> requestor,
			@NonNull Class<S> serviceClass) {
		return _lookupService(requestor, serviceClass);
	}

	/**
	 * Look up the service with the given type
	 *
	 * @param serviceClass
	 *            the service class type
	 * @return the service with the highest rank or <code>null</code>
	 * @since 1.2
	 */
	@SuppressWarnings("null")
	public static <S> @Nullable S lookupService(@NonNull Class<S> serviceClass) {
		return _lookupService(null, serviceClass);
	}

	/**
	 * Look up all service with the given type
	 *
	 * @param requestor
	 *            the class requesting the service
	 *
	 * @param serviceClass
	 *            the service class type
	 * @return the service with the highest rank or <code>null</code>
	 * @since 1.2
	 */
	@SuppressWarnings("null")
	public static <S> @NonNull List<@NonNull S> lookupServiceList(@NonNull Class<?> requestor,
			@NonNull Class<S> serviceClass) {
		return _lookupServiceList(requestor, serviceClass);
	}

	/**
	 * Look up all service with the given type
	 *
	 * @param serviceClass
	 *            the service class type
	 * @return the service with the highest rank or <code>null</code>
	 * @since 1.2
	 */
	@SuppressWarnings("null")
	public static <S> @NonNull List<@NonNull S> lookupServiceList(@NonNull Class<S> serviceClass) {
		return _lookupServiceList(null, serviceClass);
	}

}

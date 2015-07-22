/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

class OSGiUtil {
	@SuppressWarnings("null")
	public static <S> @NonNull List<@NonNull S> lookupServiceList(@Nullable Class<?> requestor,
			@NonNull Class<S> serviceClass) {
		List<Class<?>> cl = new ArrayList<>();
		if (requestor != null) {
			cl.add(requestor);
		}
		cl.add(serviceClass);
		BundleContext ctx = getContext(cl);

		try {
			@SuppressWarnings("unchecked")
			ServiceReference<S>[] serviceReferences = (ServiceReference<S>[]) ctx
					.getServiceReferences(serviceClass.getName(), null);
			if (serviceReferences == null) {
				return Collections.emptyList();
			}
			return Stream.of(serviceReferences).map(r -> new CompareableService<>(r, ctx.getService(r))).sorted()
					.map(s -> s.instance).collect(Collectors.toList());
		} catch (InvalidSyntaxException e) {
			throw new IllegalStateException(e);
		}
	}

	private static BundleContext getContext(List<Class<?>> classList) {
		for (Class<?> cl : classList) {
			Bundle b = FrameworkUtil.getBundle(cl);
			BundleContext ctx = null;
			if (b != null) {
				ctx = b.getBundleContext();
				if (ctx != null) {
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
			throw new IllegalStateException("Unable to get a bundle context"); //$NON-NLS-1$
		}

		return ctx;
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
			if (v instanceof Integer) {
				return ((Integer) v).intValue();
			}
			return 0;
		}

		@Override
		public int compareTo(CompareableService<S> o) {
			int i1;
			int i2;
			if (this.instance instanceof RankedService && o.instance instanceof RankedService) {
				i1 = ((RankedService) this.instance).getRanking();
				i2 = ((RankedService) o.instance).getRanking();
			} else {
				i1 = getRanking(this.r);
				i2 = getRanking(o.r);
			}
			return -1 * Integer.compare(i1, i2);
		}
	}
}

/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.eclipse.fx.core.internal.JavaDSServiceProcessor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Utilities to look up OSGi-Declarative services in and outside OSGi
 *
 * @since 3.0
 */
public class ServiceUtils {
	static <S> @Nullable S _lookupService(@Nullable Class<?> requestor, @NonNull Class<S> serviceClass) {
		List<@NonNull S> _lookupServiceList = _lookupServiceList(requestor, serviceClass);
		if (!_lookupServiceList.isEmpty()) {
			return _lookupServiceList.get(0);
		}
		return null;
	}

	static <S> @Nullable S _lookupService(@Nullable Class<?> requestor, @NonNull String serviceClass) {
		List<@NonNull S> _lookupServiceList = _lookupServiceList(requestor, serviceClass);
		if (!_lookupServiceList.isEmpty()) {
			return _lookupServiceList.get(0);
		}
		return null;
	}

	static <S> @NonNull List<@NonNull S> _lookupServiceList(@Nullable Class<?> requestor,
			@NonNull Class<S> serviceClass) {
		if (SystemUtils.isOsgiEnv()) {
			return OSGiUtil.lookupServiceList(requestor, serviceClass);
		} else {
			return JavaDSServiceProcessor.lookupServiceList(requestor, serviceClass);
		}
	}

	@SuppressWarnings("null")
	static <S> @NonNull List<@NonNull S> _lookupServiceList(@Nullable Class<?> requestor,
			@NonNull String serviceClass) {
		if (SystemUtils.isOsgiEnv()) {
			// return OSGiUtil.lookupServiceList(requestor, serviceClass);
			return Collections.emptyList();
		} else {
			return JavaDSServiceProcessor.lookupServiceList(requestor, serviceClass);
		}
	}

	/**
	 * Lookup the service with the given type
	 *
	 * @param serviceClass
	 *            the service class type
	 * @return the service with the highest rank as an optional
	 * @since 2.2.0
	 */
	@SuppressWarnings("null")
	public static <S> @NonNull Optional<S> getService(@NonNull Class<S> serviceClass) {
		@Nullable
		S v = _lookupService(null, serviceClass);
		if (v == null) {
			return Optional.empty();
		} else {
			return Optional.of(v);
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
	 * @since 2.2.0
	 */
	@SuppressWarnings("null")
	public static <S> @NonNull Optional<S> getService(@NonNull Class<?> requestor, @NonNull Class<S> serviceClass) {
		@Nullable
		S v = _lookupService(requestor, serviceClass);
		if (v == null) {
			return Optional.empty();
		} else {
			return Optional.of(v);
		}
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
	public static <S> @NonNull List<@NonNull S> getServiceList(@NonNull Class<?> requestor,
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
	public static <S> @NonNull List<@NonNull S> getServiceList(@NonNull Class<S> serviceClass) {
		return _lookupServiceList(null, serviceClass);
	}

	/**
	 * Look up the highest ranked service reference for the provided type
	 *
	 * @param clazz
	 *            the service class type
	 * @return the service reference with the highest rank as an optional
	 */
	public static <S> Optional<ServiceReference<S>> getServiceReference(Class<S> clazz) {
		List<ServiceReference<S>> list = getServiceReferenceList(clazz);
		if (list.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(list.get(0));
	}

	/**
	 * Look up the highest ranked service reference for the provided type
	 *
	 * @param requestor
	 *            the requestor
	 *
	 * @param clazz
	 *            the service class type
	 * @return the service reference with the highest rank as an optional
	 */
	public static <S> Optional<ServiceReference<S>> getServiceReference(Class<?> requestor, Class<S> clazz) {
		List<ServiceReference<S>> list = getServiceReferenceList(requestor, clazz);
		if (list.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(list.get(0));
	}

	/**
	 * Look up all service references for the provided type
	 *
	 * @param clazz
	 *            the service class type
	 * @return list of service references
	 */
	public static <S> List<ServiceReference<S>> getServiceReferenceList(Class<S> clazz) {
		if (SystemUtils.isOsgiEnv()) {
			return OSGiUtil.lookupServiceReferenceList(null, clazz);
		} else {
			return JavaDSServiceProcessor.lookupServiceReferenceList(null, clazz);
		}
	}

	/**
	 * Look up all service references for the provided type
	 *
	 * @param requestor
	 *            the requestor
	 *
	 * @param clazz
	 *            the service class type
	 * @return list of service references
	 */
	public static <S> List<ServiceReference<S>> getServiceReferenceList(Class<?> requestor, Class<S> clazz) {
		if (SystemUtils.isOsgiEnv()) {
			return OSGiUtil.lookupServiceReferenceList(requestor, clazz);
		} else {
			return JavaDSServiceProcessor.lookupServiceReferenceList(null, clazz);
		}
	}

	/**
	 * Look up the service by its FQN-String name
	 *
	 * @param serviceClass
	 *            the FQN service class name
	 * @return the highest ranked service as an optional
	 */
	public static <S> Optional<S> getService(@NonNull String serviceClass) {
		@SuppressWarnings("null")
		S rv = _lookupService(null, serviceClass);
		return rv == null ? Optional.empty() : Optional.of(rv);
	}

	/**
	 * A service reference
	 *
	 * @param <S>
	 *            the service type
	 */
	public interface ServiceReference<S> extends Comparable<ServiceReference<S>> {
		/**
		 * @return the service instance
		 */
		public S get();

		/**
		 * @return the ranking of the service
		 */
		public int getRanking();

		/**
		 * @return the properties
		 */
		public KeyValueStore<String, Object> getProperties();

		@Override
		default int compareTo(ServiceReference<S> o) {
			return Integer.compare(getRanking(), o.getRanking());
		}
	}
}
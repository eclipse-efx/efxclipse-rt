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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

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

	/**
	 * Make use the value is not null
	 *
	 * @param value
	 *            the nullable value
	 * @param defaultValue
	 *            the default if the value is null
	 * @return a nonnull string
	 * @since 2.0
	 */
	@NonNull
	public static String notNull(@Nullable String value, @NonNull String defaultValue) {
		return value == null ? defaultValue : value;
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

	private static <S> @Nullable S _lookupService(@Nullable Class<?> requestor, @NonNull Class<S> serviceClass) {
		List<@NonNull S> _lookupServiceList = _lookupServiceList(requestor, serviceClass);
		if (!_lookupServiceList.isEmpty()) {
			return _lookupServiceList.get(0);
		}
		return null;
	}

	private static Map<Class<?>, ServiceLoader<?>> LOADER_CACHE = new HashMap<Class<?>, ServiceLoader<?>>();

	@SuppressWarnings("unchecked")
	private static <S> ServiceLoader<S> getLoader(Class<S> clazz) {
		ServiceLoader<S> l = (ServiceLoader<S>) LOADER_CACHE.get(clazz);
		if (l == null) {
			l = ServiceLoader.load(clazz);
			LOADER_CACHE.put(clazz, l);
		}
		return l;
	}

	@SuppressWarnings("null")
	private static <S> @NonNull List<@NonNull S> _lookupServiceList(@Nullable Class<?> requestor, @NonNull Class<S> serviceClass) {
		if (isOsgiEnv()) {
			return OSGiUtil.lookupServiceList(requestor, serviceClass);
		} else {
			ServiceLoader<S> serviceLoader = getLoader(serviceClass);
			Iterator<S> iterator = serviceLoader.iterator();
			List<S> rv = new ArrayList<>();
			while (iterator.hasNext()) {
				rv.add(iterator.next());
			}
			Collections.sort(rv, (o1, o2) -> {
				if (o1 instanceof RankedService && o2 instanceof RankedService) {
					return -1 * Integer.compare(((RankedService) o1).getRanking(), ((RankedService) o2).getRanking());
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
	public static <S> @Nullable S lookupService(@NonNull Class<?> requestor, @NonNull Class<S> serviceClass) {
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
	public static <S> @Nullable S lookupService(@NonNull Class<S> serviceClass) {
		return _lookupService(null, serviceClass);
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
	public static <S> @NonNull List<@NonNull S> lookupServiceList(@NonNull Class<?> requestor, @NonNull Class<S> serviceClass) {
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
	public static <S> @NonNull List<@NonNull S> lookupServiceList(@NonNull Class<S> serviceClass) {
		return _lookupServiceList(null, serviceClass);
	}

	/**
	 * Read the content for the given path
	 *
	 * @param path
	 *            the path
	 * @return the content
	 * @throws IOException
	 *             if an I/O error occurs
	 * @since 2.0
	 */
	public static String slurpFileContent(Path path) throws IOException {
		byte[] buf = new byte[(int) Files.size(path)];

		try (InputStream in = Files.newInputStream(path)) {
			in.read(buf);
			return new String(buf);
		}
	}

	/**
	 * Read the input stream into a string
	 *
	 * @param in
	 *            the stream
	 * @param charset
	 *            the charset to be used
	 * @return the string
	 */
	public static String readToString(InputStream in, Charset charset) {
		return readToString(in, 1024, charset);
	}

	/**
	 * Read the input stream into a string
	 *
	 * @param in
	 *            the stream
	 * @param bufferLength
	 *            the buffer length
	 * @param charset
	 *            the charset
	 * @return the string
	 */
	public static String readToString(InputStream in, int bufferLength, Charset charset) {
		StringBuilder b = new StringBuilder();
		char[] buf = new char[bufferLength];
		InputStreamReader r = new InputStreamReader(in, charset);
		int l;
		try {
			while ((l = r.read(buf, 0, bufferLength)) != -1) {
				b.append(buf, 0, l);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return b.toString();
	}

	/**
	 * @return <code>true</code> if running on OS-X
	 * @since 2.2.0
	 */
	public static boolean isMacOS() {
		return "Mac OS X".equals(System.getProperty("os.name")); //$NON-NLS-1$//$NON-NLS-2$
	}

	/**
	 * Constraint the given value to the upper and lower bound
	 *
	 * @param v
	 *            the value to constraint
	 * @param min
	 *            the lower bound (only values >= 0 are applied)
	 * @param max
	 *            the upper bound (only values >= 0 are applied)
	 * @return the value
	 * @since 2.2.0
	 */
	public static double unsignedConstraintValue(double v, double min, double max) {
		double rv = v;
		if (min >= 0) {
			rv = Math.max(rv, min);
		}

		if (max >= 0) {
			rv = Math.min(rv, max);
		}
		return rv;
	}
}

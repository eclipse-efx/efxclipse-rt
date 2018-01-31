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

import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Registry of objects ranked
 *
 * @param <T>
 *            the type
 * @since 2.1
 */
public class RankedObjectRegistry<T> {
	private final TreeSet<Registration<T>> objectList = new TreeSet<>();

	static class Registration<T> implements Comparable<Registration<T>> {
		final int rank;
		final T object;

		public Registration(int rank, T object) {
			this.rank = rank;
			this.object = object;
		}

		@Override
		public int compareTo(Registration<T> o) {
			int v = Integer.compare(this.rank, o.rank);
			if (v == 0) {
				v = this.object.getClass().toString().compareTo(o.object.getClass().getName());
			}
			return v * -1;
		}

		@Override
		public String toString() {
			return "RankedObjectRegistry@" + Integer.toHexString(hashCode()) + "( ranking: " + this.rank + "," //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					+ this.object + ")"; //$NON-NLS-1$
		}
	}

	/**
	 * Register an object
	 *
	 * @param rank
	 *            the rank of the object
	 * @param object
	 *            the object
	 */
	public synchronized void registerObject(int rank, T object) {
		this.objectList.add(new Registration<>(rank, object));
	}

	/**
	 * Unregister an object
	 *
	 * @param object
	 *            the object
	 */
	public synchronized void unregisterObject(T object) {
		this.objectList.removeIf(r -> r.object == object);
	}

	/**
	 * @return all ranked objects
	 */
	public synchronized List<T> getRankedElements() {
		return this.objectList.stream().map(r -> r.object).collect(Collectors.toList());
	}

	/**
	 * Create a stream who is based on a defensive copy
	 *
	 * @return the stream
	 */
	public Stream<T> threadSafeStream() {
		return new TreeSet<>(this.objectList).stream().map(r -> r.object);
	}

	/**
	 * Create a stream who operates in the direct list and users need to make sure
	 * no concurrent modifications happen in between
	 *
	 * @return the stream
	 */
	public Stream<T> unsynchronizedStream() {
		return this.objectList.stream().map(r -> r.object);
	}

	/**
	 * Extract the rank from the OSGi-Service properties
	 *
	 * @param properties
	 *            the properties
	 * @return the rank
	 */
	public static int getOSGiServiceRank(Map<String, Object> properties) {
		return getServiceRank(properties, "service.ranking"); //$NON-NLS-1$
	}

	/**
	 * Extract the rank from the given property name
	 *
	 * @param properties
	 *            the properties
	 * @param property
	 *            the property
	 * @return the rank
	 */
	public static int getServiceRank(Map<String, Object> properties, String property) {
		Object object = properties.get(property);
		if (object == null || !(object instanceof Number)) {
			if (object instanceof String) {
				try {
					return Integer.parseInt((String) object);
				} catch (Throwable t) {
					// Nothing to do
				}

			}
			return 0;
		}

		return ((Number) object).intValue();
	}
}
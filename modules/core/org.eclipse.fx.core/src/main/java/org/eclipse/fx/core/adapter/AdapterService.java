/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.adapter;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Service which allows to adapt an instance to another type.
 */
public interface AdapterService {
	/**
	 * Check if the instance can be adapted to the target type
	 * 
	 * @param sourceObject
	 *            the source object
	 * @param targetType
	 *            the target type
	 * @return <code>true</code> if object can be adapted, else
	 *         <code>false</code>
	 */
	public boolean canAdapt(@Nullable Object sourceObject, @NonNull Class<?> targetType);

	/**
	 * Adapt the source object to the target type
	 * 
	 * @param sourceObject
	 *            the source object
	 * @param targetType
	 *            the target type
	 * @param valueAccesses
	 *            value access
	 * @param <A>
	 *            the type adapted to
	 * @return the adapted object or <code>null</code> if adaption was not
	 *         possible
	 */
	@Nullable
	public <A> A adapt(@Nullable Object sourceObject, @NonNull Class<A> targetType, ValueAccess... valueAccesses);

	/**
	 * Provides access to values
	 */
	public interface ValueAccess {
		/**
		 * Getting the value
		 * 
		 * @param key
		 *            the key
		 * @param <O>
		 *            the value type
		 * @return the value or <code>null</code>
		 */
		@Nullable
		public <O> O getValue(@NonNull String key);

		/**
		 * Getting the value
		 * 
		 * @param key
		 *            the key
		 * @param <O>
		 *            the value type
		 * @return the value
		 */
		@Nullable
		public <O> O getValue(@NonNull Class<O> key);
	}
}

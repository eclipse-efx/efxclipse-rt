/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.adapter;

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
	 * @return <code>true</code> if object can be adapted, else <code>false</code>
	 */
	public boolean canAdapt(Object sourceObject, Class<?> targetType);

	/**
	 * Adapt the source object to the target type
	 * 
	 * @param sourceObject
	 *            the source object
	 * @param targetType
	 *            the target type
	 * @param valueAccesses
	 *            value access
	 * @return the adapted object or <code>null</code> if adaption was not possible
	 */
	public <A> A adapt(Object sourceObject, Class<A> targetType, ValueAccess... valueAccesses);

	/**
	 * Provides access to values
	 */
	public interface ValueAccess {
		/**
		 * Getting the value
		 * 
		 * @param key
		 *            the key
		 * @return the value or <code>null</code>
		 */
		public <O> O getValue(String key);

		/**
		 * Getting the value
		 * 
		 * @param key
		 *            the key
		 * @return the value
		 */
		public <O> O getValue(Class<O> key);
	}
}

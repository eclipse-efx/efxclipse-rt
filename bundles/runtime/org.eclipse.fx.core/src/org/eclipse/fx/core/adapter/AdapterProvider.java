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

import org.eclipse.fx.core.adapter.AdapterService.ValueAccess;

/**
 * Service which adapts an instance to a given type
 * 
 * @param <S>
 *            the source type
 * @param <T>
 *            the target type
 */
public interface AdapterProvider<S, T> {
	/**
	 * @return the accepted source type
	 */
	public Class<S> getSourceType();

	/**
	 * @return the accepted target type
	 */
	public Class<T> getTargetType();

	/**
	 * Check if the instance can really be adapted
	 * 
	 * @param sourceObject
	 *            the source object
	 * @param targetType
	 *            the target type
	 * @return <code>true</code> if adaption is possible, else <code>false</code>
	 */
	public boolean canAdapt(S sourceObject, Class<T> targetType);

	/**
	 * Adapt the source object to the target type
	 * 
	 * @param sourceObject
	 *            the source object
	 * @param targetType
	 *            the target type
	 * @param valueAccess
	 *            the value access
	 * @return the adapted object or <code>null</code> if adaption was not possible
	 */
	public T adapt(S sourceObject, Class<T> targetType, ValueAccess... valueAccess);
}

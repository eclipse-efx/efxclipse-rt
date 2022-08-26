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
 * Interface implement by object who can be adapted to a different type.
 */
public interface Adaptable {
	/**
	 * Adapts the type to the target type or <code>null</code> if adapting is
	 * not possible
	 * 
	 * @param adapt
	 *            the type to adapt to
	 * @param <A>
	 *            the tyoe adapted to
	 * @return the adapted object
	 */
	@Nullable
	public <A> A adaptTo(@NonNull Class<A> adapt);

	/**
	 * Test if the instance can be adapted to the target
	 * 
	 * @param adapt
	 *            the type to adapt to
	 * @return <code>true</code> if adaption is possible, else
	 *         <code>false</code>
	 */
	public boolean canAdaptTo(@NonNull Class<?> adapt);
}

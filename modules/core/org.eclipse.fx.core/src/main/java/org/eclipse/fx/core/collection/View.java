/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.collection;

import org.eclipse.jdt.annotation.Nullable;

/**
 * Base interface of {@link IndexRangeView} and {@link IndexView}
 * 
 * @param <T>
 *            the type
 */
public interface View<@Nullable T> {
	/**
	 * Move the view by the given delta
	 * 
	 * @param delta
	 *            the delta
	 */
	public void moveBy(long delta);
}

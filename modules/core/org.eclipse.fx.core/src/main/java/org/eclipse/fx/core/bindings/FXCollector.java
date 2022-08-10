/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Christoph Caks<ccaks@bestsolution.at> - initial API and implementation
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.bindings;

/**
 * Collectors for {@link BindingStream}
 *
 * @param <T>
 *            the stream type
 * @param <R>
 *            the return type
 * @since 3.0
 */
public interface FXCollector<T, R> {
	/**
	 * Method to construct the final stream result
	 *
	 * @param stream
	 *            the stream
	 * @return the return type
	 */
	public R finish(BindingStream<T> stream);
}
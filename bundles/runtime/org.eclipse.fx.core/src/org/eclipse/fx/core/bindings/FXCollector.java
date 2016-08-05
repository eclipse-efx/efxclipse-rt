/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
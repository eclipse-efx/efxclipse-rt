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
package org.eclipse.fx.core.log;

/**
 * Base class for all {@link FluentLogContext#with(java.util.function.Function)}
 * condition builders
 * 
 * @since 3.3.0
 */
public abstract class Condition {
	/**
	 * The context
	 */
	protected final FluentLogContext context;

	/**
	 * Create a new condition
	 * 
	 * @param context
	 *            the context
	 */
	public Condition(FluentLogContext context) {
		this.context = context;
	}
}

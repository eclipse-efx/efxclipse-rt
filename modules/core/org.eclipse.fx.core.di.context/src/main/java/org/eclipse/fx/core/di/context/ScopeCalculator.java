/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di.context;

import java.util.Optional;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.di.ContextScope;

/**
 * Service to compute the {@link IEclipseContext} for the provided scope
 */
public interface ScopeCalculator {
	/**
	 * Compute the scope
	 * 
	 * @param localContext
	 *            the local-context
	 * @param scope
	 *            the scope
	 * @return the context of an empty optional
	 */
	public Optional<IEclipseContext> getContext(IEclipseContext localContext, ContextScope scope);
}

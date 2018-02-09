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
package org.eclipse.fx.core.di.context.internal;

import java.util.Optional;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.di.ContextScope;
import org.eclipse.fx.core.di.context.ScopeCalculator;
import org.osgi.service.component.annotations.Component;

/**
 * default implementation to compute the scope
 */
@Component
public class DefaultScopeCalculator implements ScopeCalculator {

	@Override
	public Optional<IEclipseContext> getContext(IEclipseContext localContext, ContextScope scope) {
		if( scope == ContextScope.APPLICATION ) {
			IEclipseContext c = localContext;
			while( c.getParent() != null ) {
				c = localContext.getParent();
			}
			return Optional.of(c);
		}

		return Optional.empty();
	}

}

/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.internal.lifecycle;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.ui.lifecycle.ELifecycleService;

/**
 * Context function creating a {@link ELifecycleService}
 */
public class LifecycleContextFunction extends ContextFunction {
	
	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		return ContextInjectionFactory.make(LifecycleServiceImpl.class, context);
	}

}
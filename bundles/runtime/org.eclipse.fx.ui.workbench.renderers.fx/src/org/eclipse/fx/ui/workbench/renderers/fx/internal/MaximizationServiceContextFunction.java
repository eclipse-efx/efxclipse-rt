/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sun Volland<sun.volland@free.fr>
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MContext;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;

/**
 * Context function to resolve the maximization service for the current perspective.
 */
public class MaximizationServiceContextFunction implements IContextFunction {

	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		
		// find MPerspective
		MPerspective perspective = findPerspective(context);		
		if(perspective == null) {
			MApplication mApp = context.get(MApplication.class);
			if(mApp != null) {
				perspective = findPerspective(mApp.getContext().getActiveLeaf());
			}
		}
		
		PerspectiveMaximizationServiceImpl service = null;
		if (perspective != null) {
			IEclipseContext perspectiveContext = perspective.getContext();
			service = perspectiveContext.getLocal(PerspectiveMaximizationServiceImpl.class);
			if (service == null) {
				service = ContextInjectionFactory.make(PerspectiveMaximizationServiceImpl.class, perspectiveContext);
				perspectiveContext.set(PerspectiveMaximizationServiceImpl.class, service);
			}
		}
		return service;
	}
	
	/**
	 * Returns the context's perspective, if any.
	 * @param context Context
	 * @return perspective or {@code null}
	 */
	private static MPerspective findPerspective(IEclipseContext context) {
		MPerspective perspective = null;
		IEclipseContext current = context;
		while(current != null && perspective == null) {
			MContext model = current.get(MContext.class);
			if (model instanceof MPerspective) {
				perspective = (MPerspective) model;
			}
			current = current.getParent();
		}
		return perspective;
	}

}

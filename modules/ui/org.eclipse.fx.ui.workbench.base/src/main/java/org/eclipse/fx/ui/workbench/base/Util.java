/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.base;

import java.util.Map;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.model.application.ui.MContext;
import org.eclipse.fx.ui.workbench.services.ELifecycleService;
import org.eclipse.fx.ui.workbench.services.lifecycle.annotation.InitContext;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Utility methods
 *
 * @since 2.2.0
 */
public class Util {
	/**
	 * Associate the context and the model, initializing context information
	 * from the model
	 *
	 * @param model
	 *            the model
	 * @param context
	 *            the context
	 * @since 2.2.0
	 */
	public static void setup(MContext model, IEclipseContext context) {
		populateModelInterfaces(model, context, model.getClass().getInterfaces());

		for (String variable : model.getVariables()) {
			context.declareModifiable(variable);
		}

		Map<String, String> props = model.getProperties();
		for (String key : props.keySet()) {
			context.set(key, props.get(key));
		}

		model.setContext(context);
		
		ELifecycleService service = context.get(ELifecycleService.class);
		if( service != null ) {
			MApplication app = context.get(MApplication.class);
			IEclipseContext appContext = app != null ? app.getContext() : null;
			IEclipseContext localContext = appContext != null ? appContext.getActiveChild() : null;
			service.validateAnnotation(InitContext.class, (MApplicationElement) model, context, localContext );
		}
	}

	private static void populateModelInterfaces(MContext contextModel, IEclipseContext context, Class<?>[] interfaces) {
		for (Class<?> intf : interfaces) {
			context.set(intf.getName(), contextModel);

			populateModelInterfaces(contextModel, context, intf.getInterfaces());
		}
	}
}

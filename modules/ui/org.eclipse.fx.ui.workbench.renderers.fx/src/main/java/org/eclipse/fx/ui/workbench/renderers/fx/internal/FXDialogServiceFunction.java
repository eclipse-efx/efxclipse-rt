/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
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
package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.ui.workbench.renderers.base.Util;
import org.osgi.service.component.annotations.Component;

@SuppressWarnings("javadoc")
@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.fx.ui.services.dialog.LightWeightDialogService"})
public class FXDialogServiceFunction extends ContextFunction {
	@SuppressWarnings("null")
	@Override
	public Object compute(IEclipseContext context) {
		if( ! Util.isLocalHandlerContext(context) ) {
			return ContextInjectionFactory.make(FXDialogService.class, context);	
		} else {
			return ContextInjectionFactory.make(FXDialogService.class, Util.getActiveHandlerContext(context));
		}
	}
}

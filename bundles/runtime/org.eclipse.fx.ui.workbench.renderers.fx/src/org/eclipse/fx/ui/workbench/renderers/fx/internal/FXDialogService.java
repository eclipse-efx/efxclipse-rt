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
package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import java.util.function.BiFunction;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.workbench.renderers.base.services.LightWeightDialogService;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDialogHost;

public class FXDialogService implements LightWeightDialogService {
	private final IEclipseContext context;
	
	@Log
	@Inject
	private Logger logger;
	
	@Inject
	public FXDialogService(IEclipseContext context) {
		this.context = context;
	}
	
	@Override
	public <T> void openDialog(Class<?> dialogClass, ModalityScope scope, BiFunction<Status, T, Boolean> result) {
		WDialogHost host = null;
		
		if( scope == ModalityScope.WINDOW ) {
			MWindow window = this.context.get(MWindow.class);
			host = (WDialogHost) window.getWidget();
		} else if( scope == ModalityScope.PERSPECTIVE ) {
			MPerspective perspective = this.context.get(MPerspective.class);
			if( perspective == null ) {
				MWindow window = this.context.get(MWindow.class);
				host = (WDialogHost) window.getWidget();
			} else {
				host = (WDialogHost) perspective.getWidget();
			}
		} else if( scope == ModalityScope.PART ) {
			MPart part = this.context.get(MPart.class);
			if( part == null ) {
				MPerspective perspective = this.context.get(MPerspective.class);
				if( perspective == null ) {
					MWindow window = this.context.get(MWindow.class);
					host = (WDialogHost) window.getWidget();
				} else {
					host = (WDialogHost) perspective.getWidget();
				}
			} else {
				host = (WDialogHost) part.getWidget();
			}
		} 
		
		if( host != null ) {
			WDialogHost fhost = host;
			IEclipseContext dialogContext = this.context.createChild();
			BiFunction<Status, T, Boolean> wrapper = (s,t) -> {
				fhost.setDialog(null);
				return result.apply(s,t);
			};
			dialogContext.set("resultFunction", wrapper); //$NON-NLS-1$
			ContextInjectionFactory.make(dialogClass, dialogContext);
		} else {
			this.logger.error("Could not find a host for '"+dialogClass+"'");  //$NON-NLS-1$//$NON-NLS-2$
		}
	}
}

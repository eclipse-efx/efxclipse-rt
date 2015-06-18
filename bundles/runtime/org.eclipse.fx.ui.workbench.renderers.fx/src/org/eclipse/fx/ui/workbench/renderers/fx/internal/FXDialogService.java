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

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.controls.stage.Frame;
import org.eclipse.fx.ui.controls.stage.FrameEvent;
import org.eclipse.fx.ui.services.dialog.LightWeightDialogService;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDialogHost;

import javafx.scene.Node;

/**
 * Basic service used to display dialogs in the UI
 */
public class FXDialogService implements LightWeightDialogService {
	private final IEclipseContext context;

	@Log
	@Inject
	private Logger logger;

	/**
	 * Create a new instance
	 * 
	 * @param context
	 *            the context
	 */
	@Inject
	public FXDialogService(IEclipseContext context) {
		this.context = context;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Node & Frame> T openDialog(Class<T> dialogClass, ModalityScope scope) {
		WDialogHost host = null;

		if (scope == ModalityScope.WINDOW) {
			MWindow window = this.context.get(MWindow.class);
			host = (WDialogHost) window.getWidget();
		} else if (scope == ModalityScope.PERSPECTIVE) {
			MPerspective perspective = this.context.get(MPerspective.class);

			if (perspective == null) {
				return openDialog(dialogClass, ModalityScope.WINDOW);
			} else {
				host = (WDialogHost) perspective.getWidget();
			}
		} else if (scope == ModalityScope.PART) {
			MPart part = this.context.get(MPart.class);

			if (part == null) {
				return openDialog(dialogClass, ModalityScope.PERSPECTIVE);
			} else {
				host = (WDialogHost) part.getWidget();
			}
		}

		if (host != null) {
			WDialogHost fhost = host;
			IEclipseContext dialogContext = this.context.createChild();
			Node dialogInstance = (Node) ContextInjectionFactory.make(dialogClass, dialogContext);
			dialogInstance.addEventHandler(FrameEvent.CLOSED, e -> {
				fhost.setDialog(null);
			});

			fhost.setDialog(dialogInstance);
			return (T) dialogInstance;
		} else {
			this.logger.error("Could not find a host for '" + dialogClass + "'"); //$NON-NLS-1$//$NON-NLS-2$
			throw new IllegalStateException();
		}
	}
}

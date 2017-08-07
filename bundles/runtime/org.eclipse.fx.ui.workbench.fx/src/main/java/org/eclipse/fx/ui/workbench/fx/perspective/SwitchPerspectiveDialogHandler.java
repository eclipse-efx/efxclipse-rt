/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.fx.perspective;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.fx.ui.services.dialog.LightWeightDialogService;
import org.eclipse.fx.ui.services.dialog.LightWeightDialogService.ModalityScope;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;

import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * Handler to register to switch perspectives with the help of
 * {@link PerspectiveSwitcherDialog} or {@link LwPerspectiveSwitcherDialog}
 *
 * @since 2.4.0
 */
public class SwitchPerspectiveDialogHandler {
	/**
	 * Show the perspective switcher
	 *
	 * @param dialogService
	 *            the dialog service
	 * @param fxWindow
	 *            the javafx window
	 * @param window
	 *            the window model element
	 * @param modelService
	 *            the model service
	 * @param graphicsLoader
	 *            the graphics loader
	 * @param partService
	 *            the part service
	 */
	@SuppressWarnings("static-method")
	@Execute
	public void switchPerspective(LightWeightDialogService dialogService,
			@Named(IServiceConstants.ACTIVE_SHELL) Stage fxWindow, MWindow window, EModelService modelService, GraphicsLoader graphicsLoader, EPartService partService) {
		if (window.getTags().contains("efx-lightweight-dialogs")) { //$NON-NLS-1$
			LwPerspectiveSwitcherDialog dialog = new LwPerspectiveSwitcherDialog(window, modelService, graphicsLoader, partService) {
				{
					setPrefSize(400, 400);
				}
			};
			dialogService.openDialog(dialog, ModalityScope.WINDOW);
		} else {
			PerspectiveSwitcherDialog dialog = new PerspectiveSwitcherDialog(fxWindow, window, modelService, graphicsLoader, partService) {
				@Override
				protected Point2D getInitialSize(Parent rootContainer) {
					return new Point2D(400, 400);
				}
			};
			dialog.open();
		}
	}
}

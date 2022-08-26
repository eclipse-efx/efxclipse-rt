/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
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
package org.eclipse.fx.ui.workbench.fx.perspective;

import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.fx.ui.controls.dialog.TitleAreaDialog;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;

import javafx.scene.layout.BorderPane;

/**
 * Lightweight dialog to open the perspective
 *
 * @since 2.4.0
 */
@SuppressWarnings("restriction")
public class LwPerspectiveSwitcherDialog extends TitleAreaDialog {
	private final MWindow window;
	private final EModelService modelService;
	private final GraphicsLoader graphicsLoader;
	private MPerspective perspectiveToOpen;
	private final EPartService partService;

	/**
	 * Create a new dialog
	 *
	 * @param window
	 *            the main window
	 * @param modelService
	 *            the model service
	 * @param graphicsLoader
	 *            the graphics loader
	 * @param partService
	 *            the part service
	 */
	@Inject
	public LwPerspectiveSwitcherDialog(MWindow window, EModelService modelService, GraphicsLoader graphicsLoader, EPartService partService) {
		super("Switch perspective", "Switch perspective", "Select a perspective you want to switch to"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		this.window = window;
		this.modelService = modelService;
		this.graphicsLoader = graphicsLoader;
		this.partService = partService;
		setClientArea(createClient());
		addDefaultButtons();
		getStyleClass().add("efx-perspective-switch-dialog"); //$NON-NLS-1$
	}

	private BorderPane createClient() {
		BorderPane parent = new BorderPane();
		PerspectiveListView view = new PerspectiveListView(this.window, this.modelService, this.graphicsLoader);
		view.setOpenConsumer(o -> {
			this.perspectiveToOpen = o;
			handleOk();
		});
		view.setSelectionConsumer(o -> {
			this.perspectiveToOpen = o;
		});
		view.init(parent);
		return parent;
	}

	@Override
	protected void handleOk() {
		if (this.perspectiveToOpen != null) {
			super.handleOk();
			this.partService.switchPerspective(this.perspectiveToOpen);
		}
	}
}

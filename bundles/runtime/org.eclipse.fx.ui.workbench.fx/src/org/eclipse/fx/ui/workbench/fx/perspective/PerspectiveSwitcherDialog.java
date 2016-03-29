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

import java.net.URL;

import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.fx.ui.dialogs.TitleAreaDialog;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.jdt.annotation.Nullable;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.stage.Window;

/**
 * Dialog to open the perspective
 *
 * @since 2.4.0
 */
public class PerspectiveSwitcherDialog extends TitleAreaDialog {
	private final MWindow window;
	private final EModelService modelService;
	private final GraphicsLoader graphicsLoader;
	private MPerspective perspectiveToOpen;
	private final EPartService partService;

	/**
	 * Create a new dialog
	 *
	 * @param parent
	 *            the parent window
	 * @param window
	 *            the model the perspective switching should be done
	 * @param modelService
	 *            the model service
	 * @param graphicsLoader
	 *            the graphics loading service
	 * @param partService
	 *            the part service
	 */
	@Inject
	public PerspectiveSwitcherDialog(@Nullable Window parent, MWindow window, EModelService modelService, GraphicsLoader graphicsLoader, EPartService partService) {
		super(parent, "Switch perspective", "Switch perspective", "Select a perspective you want to switch to", (URL) null); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		this.window = window;
		this.modelService = modelService;
		this.graphicsLoader = graphicsLoader;
		this.partService = partService;
	}

	@Override
	protected Node createDialogContent() {
		BorderPane parent = new BorderPane();
		PerspectiveListView view = new PerspectiveListView(this.window, this.modelService, this.graphicsLoader);
		view.setOpenConsumer(o -> {
			this.perspectiveToOpen = o;
			okPressed();
		});
		view.setSelectionConsumer(o -> {
			this.perspectiveToOpen = o;
		});
		view.init(parent);

		return parent;
	}

	@Override
	protected void okPressed() {
		if (this.perspectiveToOpen != null) {
			super.okPressed();
			this.partService.switchPerspective(this.perspectiveToOpen);
		}
	}
}
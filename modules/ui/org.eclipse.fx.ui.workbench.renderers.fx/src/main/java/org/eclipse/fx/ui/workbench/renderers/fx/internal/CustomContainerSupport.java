/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import java.util.List;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.contributions.IContributionFactory;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.panes.FillLayoutPane;
import org.eclipse.fx.ui.panes.GridLayoutPane;
import org.eclipse.fx.ui.panes.RowLayoutPane;
import org.eclipse.fx.ui.workbench.renderers.base.BaseRenderer;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Helper class to construct the appropriate container
 */
@SuppressWarnings("restriction")
public class CustomContainerSupport {
	private static final String WIDGET_ANCHORPANE_TAG = "Container:AnchorPane"; //$NON-NLS-1$
	private static final String WIDGET_FLOWPANE_TAG = "Container:FlowPane"; //$NON-NLS-1$
	private static final String WIDGET_GRIDPANE_TAG = "Container:GridPane"; //$NON-NLS-1$
	private static final String WIDGET_HBOX_TAG = "Container:HBox"; //$NON-NLS-1$
	private static final String WIDGET_STACKPANE_TAG = "Container:StackPane"; //$NON-NLS-1$
	private static final String WIDGET_VBOX_TAG = "Container:VBox"; //$NON-NLS-1$

	private static final String WIDGET_EFX_FILL_TAG = "Container:FillLayoutPane"; //$NON-NLS-1$
	private static final String WIDGET_EFX_GRID_TAG = "Container:GridLayoutPane"; //$NON-NLS-1$
	private static final String WIDGET_EFX_ROW_TAG = "Container:RowLayoutPane"; //$NON-NLS-1$

	private static final String WIDGET_URLPANE_TAG = "Container:UrlPane:"; //$NON-NLS-1$

	/**
	 * Create a container pane
	 * 
	 * @param logger
	 *            the logger to use for error reporting
	 * @param context
	 *            the context the pane is created in
	 * @return the pane
	 */
	@Nullable
	public static Pane createContainerPane(@NonNull Logger logger, @NonNull IEclipseContext context) {
		List<String> tags = ((MUIElement) context.get(BaseRenderer.CONTEXT_DOM_ELEMENT)).getTags();
		Pane tmp = null;
		if (tags.contains(WIDGET_ANCHORPANE_TAG)) {
			tmp = new AnchorPane();
		} else if (tags.contains(WIDGET_FLOWPANE_TAG)) {
			tmp = new FlowPane();
		} else if (tags.contains(WIDGET_GRIDPANE_TAG)) {
			tmp = new GridPane();
		} else if (tags.contains(WIDGET_HBOX_TAG)) {
			tmp = new HBox();
		} else if (tags.contains(WIDGET_STACKPANE_TAG)) {
			tmp = new StackPane();
		} else if (tags.contains(WIDGET_VBOX_TAG)) {
			tmp = new VBox();
		} else if (tags.contains(WIDGET_EFX_FILL_TAG)) {
			tmp = new FillLayoutPane();
		} else if (tags.contains(WIDGET_EFX_GRID_TAG)) {
			tmp = new GridLayoutPane();
		} else if (tags.contains(WIDGET_EFX_ROW_TAG)) {
			tmp = new RowLayoutPane();
		}

		if (tmp == null) {
			for (String t : tags) {
				if (t.startsWith(WIDGET_URLPANE_TAG)) {
					try {
						tmp = (Pane) context.get(IContributionFactory.class).create(t.substring((WIDGET_URLPANE_TAG).length()), context);
						break;
					} catch (Exception e) {
						logger.error("Unable to create pane from URL", e); //$NON-NLS-1$
					}
				}
			}
		}

		return tmp;
	}
}

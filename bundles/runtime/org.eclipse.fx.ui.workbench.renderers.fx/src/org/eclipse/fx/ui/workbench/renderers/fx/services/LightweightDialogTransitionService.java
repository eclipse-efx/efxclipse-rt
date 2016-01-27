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
package org.eclipse.fx.ui.workbench.renderers.fx.services;

import org.eclipse.e4.ui.model.application.ui.MUIElement;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public interface LightweightDialogTransitionService {
	public void showDialog(MUIElement container, Pane containerNode, Pane dialogOverlayContainer, Node grayArea, Node dialog, Runnable finished);
	public void hideDialog(MUIElement container, Pane containerNode, Pane dialogOverlayContainer, Node grayArea, Node dialog, Runnable finished);
}

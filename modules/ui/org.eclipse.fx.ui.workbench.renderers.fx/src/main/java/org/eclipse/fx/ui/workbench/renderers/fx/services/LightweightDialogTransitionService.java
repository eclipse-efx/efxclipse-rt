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
package org.eclipse.fx.ui.workbench.renderers.fx.services;

import org.eclipse.e4.ui.model.application.ui.MUIElement;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public interface LightweightDialogTransitionService {
	public void showDialog(MUIElement container, Pane containerNode, Pane dialogOverlayContainer, Node grayArea, Node dialog, Runnable finished);
	public void hideDialog(MUIElement container, Pane containerNode, Pane dialogOverlayContainer, Node grayArea, Node dialog, Runnable finished);
}

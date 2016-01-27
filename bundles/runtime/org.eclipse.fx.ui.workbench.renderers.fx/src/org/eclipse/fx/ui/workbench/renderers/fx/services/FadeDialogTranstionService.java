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

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public abstract class FadeDialogTranstionService implements LightweightDialogTransitionService {

	@Override
	public void showDialog(MUIElement container, Pane containerNode, Pane dialogOverlayContainer, Node grayArea, Node dialog, Runnable finished) {
		dialogOverlayContainer.setOpacity(0);
		FadeTransition fd = new FadeTransition(Duration.millis(300),dialogOverlayContainer);
		fd.setFromValue(0);
		fd.setToValue(1);
		configureFadeIn(fd);
		if( finished != null ) {
			fd.setOnFinished( e -> finished.run());
		}
		fd.play();
	}

	protected void configureFadeIn(FadeTransition transition) {

	}

	@Override
	public void hideDialog(MUIElement container, Pane containerNode, Pane dialogOverlayContainer, Node grayArea, Node dialog, Runnable finished) {
		FadeTransition fd = new FadeTransition(Duration.millis(300),dialogOverlayContainer);
		fd.setFromValue(1);
		fd.setToValue(0);
		configureFadeOut(fd);
		if( finished != null ) {
			fd.setOnFinished( e -> finished.run());
		}
		fd.play();
	}

	protected void configureFadeOut(FadeTransition transition) {

	}
}

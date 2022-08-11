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

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class FlyInTransitionService implements LightweightDialogTransitionService {
	private boolean fadeGrayArea;

	public FlyInTransitionService() {
		this(false);
	}

	public FlyInTransitionService(boolean fadeGrayArea) {
		this.fadeGrayArea = fadeGrayArea;
	}

	@Override
	public void showDialog(MUIElement container, Pane containerNode, Pane dialogOverlayContainer, Node grayArea, Node dialog, Runnable finished) {
		FadeTransition fd = new FadeTransition(Duration.millis(300), dialogOverlayContainer);
		fd.setFromValue(0.0);
		fd.setToValue(1.0);

		TranslateTransition t = new TranslateTransition(Duration.millis(300),dialog);

		t.setFromY(-1 * (dialog.getLayoutY() + dialog.prefHeight(-1)));
		t.setToY(0);
		t.setInterpolator(Interpolator.EASE_OUT);
		if( finished != null ) {
			t.setOnFinished( e -> {
				finished.run();
			});
		}
		ParallelTransition p = new ParallelTransition(t);
		if( this.fadeGrayArea ) {
			p.getChildren().add(fd);
		}

		p.play();
	}

	@Override
	public void hideDialog(MUIElement container, Pane containerNode, Pane dialogOverlayContainer, Node grayArea, Node dialog, Runnable finished) {
		FadeTransition fd = new FadeTransition(Duration.millis(300), dialogOverlayContainer);
		fd.setFromValue(1.0);
		fd.setToValue(0.0);

		TranslateTransition t = new TranslateTransition(Duration.millis(300),dialog);
		t.setFromY(0);
		t.setToY(-1 * (dialog.getLayoutY() + dialog.prefHeight(-1)));
		t.setInterpolator(Interpolator.EASE_IN);
		if( finished != null ) {
			t.setOnFinished( e -> {
				finished.run();
			});
		}

		ParallelTransition p = new ParallelTransition(t);
		if( this.fadeGrayArea ) {
			p.getChildren().add(fd);
		}

		p.play();
	}
}

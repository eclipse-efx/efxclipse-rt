/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.animation.pagetransition.animation;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

import org.eclipse.fx.ui.animation.pagetransition.CenterSwitchAnimation;

/**
 * Zoom and slide animations
 */
public class ZoomSlideAnimation extends CenterSwitchAnimation {

	@Override
	protected Animation createAndPrepareAnimation(Node curNode, Node newNode) {
		double deltaX = -curNode.getBoundsInLocal().getWidth();
		newNode.setTranslateX(-deltaX);

		return new SequentialTransition(
		// zoom out
				new ParallelTransition(zoomOut(curNode), zoomOut(newNode)),
				// slide
				new ParallelTransition(slide(curNode, deltaX), slide(newNode, deltaX)),
				// zoom in
				new ParallelTransition(zoomIn(curNode), zoomIn(newNode)));
	}

	private static TranslateTransition slide(Node n, double deltaX) {
		TranslateTransition t = new TranslateTransition(Duration.millis(300), n);
		t.setInterpolator(Interpolator.EASE_BOTH);
		t.setByX(deltaX);
		return t;
	}

	private static ScaleTransition zoomIn(Node n) {
		ScaleTransition zoomIn = new ScaleTransition(Duration.millis(300), n);
		zoomIn.setToX(1);
		zoomIn.setToY(1);
		zoomIn.setInterpolator(Interpolator.EASE_BOTH);
		return zoomIn;
	}

	private static ScaleTransition zoomOut(Node n) {
		ScaleTransition zoomIn = new ScaleTransition(Duration.millis(300), n);
		zoomIn.setToX(0.7);
		zoomIn.setToY(0.7);
		zoomIn.setInterpolator(Interpolator.EASE_BOTH);
		return zoomIn;
	}

	@Override
	protected void resetProperties(Node curNode, Node newNode) {
		newNode.setTranslateX(0);
		newNode.setScaleX(1);
		newNode.setScaleY(1);
		curNode.setTranslateX(0);
		curNode.setScaleX(1);
		curNode.setScaleY(1);

		curNode.setEffect(null);
		newNode.setEffect(null);
	}

}

/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
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
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import org.eclipse.fx.ui.animation.pagetransition.CenterSwitchAnimation;

/**
 * A page change animation
 */
public class PageChangeAnimation extends CenterSwitchAnimation {

	@Override
	protected Animation createAndPrepareAnimation(Node curNode, Node newNode) {
		Bounds b = curNode.getBoundsInLocal();
		double cX = b.getMinX() + b.getWidth() / 2;
		double cY = b.getMinY() + b.getHeight() / 2;

		double val = 200;

		CubicCurve cIn = new CubicCurve(cX - val, cY, cX - val, cY - val, cX, cY - val, cX, cY);
		CubicCurve cOut = new CubicCurve(cX, cY, cX, cY + val, cX + val, cY + val, cX + val, cY + 0);

		Animation main = new ParallelTransition(
		// zoom
				zoomOut(curNode), zoomIn(newNode),
				// move
				move(newNode, cIn), move(curNode, cOut),
				// fade
				fadeOut(curNode), fadeIn(newNode));
		return new SequentialTransition(
		// zoom out
				new ParallelTransition(zoomOut1(curNode), zoomOut1(newNode)),
				// main
				main,
				// zoom in
				new ParallelTransition(zoomIn1(curNode), zoomIn1(newNode)));
	}

	private static final PathTransition move(Node n, Shape path) {
		return new PathTransition(Duration.millis(1000), path, n);
	}

	private static final ScaleTransition zoomIn(Node n) {
		ScaleTransition t = new ScaleTransition(Duration.millis(1000), n);
		t.setInterpolator(Interpolator.EASE_BOTH);
		t.setFromX(0.2);
		t.setFromY(0.2);
		t.setToX(0.7);
		t.setToY(0.7);
		return t;
	}

	private static final ScaleTransition zoomOut(Node n) {
		ScaleTransition t = new ScaleTransition(Duration.millis(1000), n);
		t.setInterpolator(Interpolator.EASE_BOTH);
		t.setToX(0.2);
		t.setToY(0.2);
		return t;
	}

	private static final FadeTransition fadeOut(Node n) {
		FadeTransition t = new FadeTransition(Duration.millis(1000), n);
		t.setFromValue(1);
		t.setToValue(0);
		return t;
	}

	private static final FadeTransition fadeIn(Node n) {
		FadeTransition t = new FadeTransition(Duration.millis(1000), n);
		t.setFromValue(0);
		t.setToValue(1);
		return t;
	}

	private static final ScaleTransition zoomOut1(Node n) {
		ScaleTransition s = new ScaleTransition(Duration.millis(300), n);
		s.setToX(0.7);
		s.setToY(0.7);
		s.setInterpolator(Interpolator.EASE_BOTH);
		return s;
	}

	private static final ScaleTransition zoomIn1(Node n) {
		ScaleTransition s = new ScaleTransition(Duration.millis(300), n);
		s.setToX(1);
		s.setToY(1);
		s.setInterpolator(Interpolator.EASE_BOTH);
		return s;
	}

	@Override
	protected void resetProperties(Node curNode, Node newNode) {
		newNode.setTranslateZ(0);
		curNode.setTranslateZ(0);
		newNode.setRotate(0);
		curNode.setRotate(0);

		curNode.setScaleX(1);
		curNode.setScaleY(1);
		curNode.setOpacity(1);
		curNode.setTranslateX(0);
		curNode.setTranslateY(0);
		newNode.setScaleX(1);
		newNode.setScaleY(1);
		newNode.setOpacity(1);
		newNode.setTranslateX(0);
		newNode.setTranslateY(0);
	}

}

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
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

import org.eclipse.fx.ui.animation.pagetransition.CenterSwitchAnimation;

/**
 * Slide transition
 */
public class SlideAnimation extends CenterSwitchAnimation {

	@Override
	protected Animation createAndPrepareAnimation(Node curNode, Node newNode) {
		newNode.setOpacity(1);
		
		double deltaX = -curNode.getBoundsInLocal().getWidth();
		newNode.setTranslateX(-deltaX);
		
		return new ParallelTransition(createTransition(curNode, deltaX), createTransition(newNode, deltaX));
	}

	private static TranslateTransition createTransition(Node n, double deltaX) {
		TranslateTransition t = new TranslateTransition(Duration.millis(1000),n);
		t.setInterpolator(Interpolator.EASE_BOTH);
		t.setByX(deltaX);
		return t;
	}
	
	@Override
	protected void resetProperties(Node curNode, Node newNode) {
		newNode.setTranslateX(0);
		curNode.setTranslateX(0);
	}

}

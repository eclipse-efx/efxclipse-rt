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

import org.eclipse.fx.ui.animation.pagetransition.CenterSwitchAnimation;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * Animation which fades between 2 nodes
 */
public class FadeAnimation extends CenterSwitchAnimation {

	@Override
	protected Animation createAndPrepareAnimation(Node curNode, Node newNode) {
		FadeTransition t = new FadeTransition(Duration.millis(1000), curNode);
		t.setInterpolator(Interpolator.EASE_BOTH);
		t.setFromValue(1.0);
		t.setToValue(0.0);
		return t;
	}

	@Override
	protected void resetProperties(Node curNode, Node newNode) {
		curNode.setOpacity(1);
		newNode.setOpacity(1);
	}

}

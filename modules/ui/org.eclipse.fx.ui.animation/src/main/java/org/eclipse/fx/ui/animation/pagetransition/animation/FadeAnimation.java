/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
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

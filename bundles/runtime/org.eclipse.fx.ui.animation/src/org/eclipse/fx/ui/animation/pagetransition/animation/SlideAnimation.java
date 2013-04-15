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
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransitionBuilder;
import javafx.animation.TranslateTransitionBuilder;
import javafx.scene.Node;
import javafx.util.Duration;

public class SlideAnimation extends CenterSwitchAnimation {

	@Override
	protected Animation createAndPrepareAnimation(Node curNode, Node newNode) {
		newNode.setOpacity(1);
		
		double deltaX = -curNode.getBoundsInLocal().getWidth();
		newNode.setTranslateX(-deltaX);
		
		
		TranslateTransitionBuilder builder = TranslateTransitionBuilder.create()
			.interpolator(Interpolator.EASE_BOTH)
			.byX(deltaX)
			.duration(new Duration(1000));
			
		return ParallelTransitionBuilder.create().children(builder.node(curNode).build(), builder.node(newNode).build()).build();
	}

	@Override
	protected void resetProperties(Node curNode, Node newNode) {
		newNode.setTranslateX(0);
		curNode.setTranslateX(0);
	}

}

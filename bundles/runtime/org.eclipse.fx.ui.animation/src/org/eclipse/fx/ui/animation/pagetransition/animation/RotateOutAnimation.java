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
import javafx.animation.ParallelTransitionBuilder;
import javafx.animation.RotateTransitionBuilder;
import javafx.animation.ScaleTransitionBuilder;
import javafx.scene.Node;
import javafx.util.Duration;

public class RotateOutAnimation extends CenterSwitchAnimation {

	@Override
	protected Animation createAndPrepareAnimation(Node curNode, Node newNode) {
		
		return ParallelTransitionBuilder.create()
			.children(
				RotateTransitionBuilder.create()
					.node(curNode)
					.byAngle(360)
					.duration(new Duration(600))
					.build(),
				ScaleTransitionBuilder.create()
					.node(curNode)
					.toX(0)
					.toY(0)
					.duration(new Duration(600))
					.build()
			)
			.build();
	}
	
	@Override
	protected void resetProperties(Node curNode, Node newNode) {
		curNode.setRotate(0);
		curNode.setScaleX(1);
		curNode.setScaleY(1);
	}

}

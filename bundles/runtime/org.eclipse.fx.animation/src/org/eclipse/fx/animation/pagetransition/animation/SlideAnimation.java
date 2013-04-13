package org.eclipse.fx.animation.pagetransition.animation;


import org.eclipse.fx.animation.pagetransition.CenterSwitchAnimation;

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

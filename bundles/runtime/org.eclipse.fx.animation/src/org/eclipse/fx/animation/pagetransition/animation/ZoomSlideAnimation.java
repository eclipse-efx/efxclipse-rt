package org.eclipse.fx.animation.pagetransition.animation;


import org.eclipse.fx.animation.pagetransition.CenterSwitchAnimation;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransitionBuilder;
import javafx.animation.ScaleTransitionBuilder;
import javafx.animation.SequentialTransitionBuilder;
import javafx.animation.TranslateTransitionBuilder;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class ZoomSlideAnimation extends CenterSwitchAnimation {

	public ZoomSlideAnimation() {
		
		
	}
	
	@Override
	protected Animation createAndPrepareAnimation(Node curNode, Node newNode) {
		double deltaX = -curNode.getBoundsInLocal().getWidth();
		newNode.setTranslateX(-deltaX);
		
		
//		curNode.setEffect(new DropShadow(2, 2, 2, Color.RED));
//		newNode.setEffect(new DropShadow(2, 2, 2, Color.RED));
		
		TranslateTransitionBuilder slide = TranslateTransitionBuilder.create()
			.interpolator(Interpolator.EASE_BOTH)
			.byX(deltaX)
			.duration(new Duration(300));
		
		ScaleTransitionBuilder zoomOut = ScaleTransitionBuilder.create()
			.duration(new Duration(300))
			.toX(0.7)
			.toY(0.7)
			.interpolator(Interpolator.EASE_BOTH);
		ScaleTransitionBuilder zoomIn = ScaleTransitionBuilder.create()
			.duration(new Duration(300))
			.toX(1)
			.toY(1)
			.interpolator(Interpolator.EASE_BOTH);
		
		return SequentialTransitionBuilder.create()
			.children(
				ParallelTransitionBuilder.create().children(
					zoomOut.node(curNode).build(),
					zoomOut.node(newNode).build()
				).build(),
				ParallelTransitionBuilder.create().children(
					slide.node(curNode).build(),
					slide.node(newNode).build()
				).build(),
				ParallelTransitionBuilder.create().children(
					zoomIn.node(curNode).build(),
					zoomIn.node(newNode).build()
				).build()
			)
			.build();
			
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

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
package org.eclipse.fx.animation.pagetransition.animation;


import org.eclipse.fx.animation.pagetransition.CenterSwitchAnimation;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransitionBuilder;
import javafx.animation.RotateTransitionBuilder;
import javafx.animation.ScaleTransitionBuilder;
import javafx.animation.SequentialTransitionBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class FlipAnimation extends CenterSwitchAnimation {

	@Override
	public void animate(final BorderPane pane, final Node newNode) {
		pane.setDepthTest(DepthTest.DISABLE);
		final Node curNode = pane.getCenter();
		
		pane.setCenter(null);
		
		final Group area = new Group();
		area.setDepthTest(DepthTest.ENABLE);
		
		Bounds b = curNode.getBoundsInParent();
		newNode.resizeRelocate(b.getMinX(), b.getMinY(), b.getWidth(), b.getHeight());
		area.getChildren().add(newNode);
		area.getChildren().add(curNode);
		
		newNode.setTranslateZ(0.1);
		curNode.setTranslateZ(-0.1);
		newNode.setRotationAxis(Rotate.Y_AXIS);
		newNode.setRotate(180);
		
		pane.setCenter(area);
		
		if (imageView != null) {
			pane.getChildren().add(0,imageView);
		}
		
		Animation animation = createAndPrepareAnimation(area, null);
		
		animation.onFinishedProperty().set(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				pane.getChildren().remove(curNode);
				pane.getChildren().remove(newNode);
				pane.setCenter(newNode);
				resetProperties(curNode, newNode);
				
				if (imageView != null) {
					pane.getChildren().remove(imageView);
				}
			}
		});
		
		animation.play();
	}
	
	@Override
	protected Animation createAndPrepareAnimation(Node area, Node newNode) {
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
							zoomOut.node(area).build(),
						RotateTransitionBuilder.create()
						.axis(Rotate.Y_AXIS)
						.node(area)
						.byAngle(180)
						.duration(new Duration(8000))
						.interpolator(Interpolator.EASE_BOTH).build(),
						zoomIn.node(area).build()
					)
					.build();
//		return RotateTransitionBuilder.create()
//			.axis(Rotate.Y_AXIS)
//			.node(area)
//			.byAngle(180)
//			.duration(new Duration(4000))
//			.interpolator(Interpolator.EASE_BOTH).build();
				
	}

	@Override
	protected void resetProperties(Node curNode, Node newNode) {
		newNode.setTranslateZ(0);
		curNode.setTranslateZ(0);
			newNode.setRotate(0);
			curNode.setRotate(0);
	}

}

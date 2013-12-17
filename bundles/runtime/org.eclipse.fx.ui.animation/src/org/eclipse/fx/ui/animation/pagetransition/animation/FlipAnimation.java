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
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import org.eclipse.fx.ui.animation.pagetransition.CenterSwitchAnimation;

/**
 * Flip between 2 nodes
 */
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
		
		if (this.imageView != null) {
			pane.getChildren().add(0,this.imageView);
		}
		
		Animation animation = createAndPrepareAnimation(area, null);
		
		animation.onFinishedProperty().set(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				pane.getChildren().remove(curNode);
				pane.getChildren().remove(newNode);
				pane.setCenter(newNode);
				resetProperties(curNode, newNode);
				
				if (FlipAnimation.this.imageView != null) {
					pane.getChildren().remove(FlipAnimation.this.imageView);
				}
			}
		});
		
		animation.play();
	}
	
	@Override
	protected Animation createAndPrepareAnimation(Node area, Node newNode) {
		ScaleTransition zoomOut = new ScaleTransition(Duration.millis(300));
		zoomOut.setToX(0.7);
		zoomOut.setToY(0.7);
		zoomOut.setInterpolator(Interpolator.EASE_BOTH);
		
		ScaleTransition zoomIn = new ScaleTransition(Duration.millis(300));
		zoomIn.setToX(1);
		zoomIn.setToY(1);
		zoomIn.setInterpolator(Interpolator.EASE_BOTH);
		
		RotateTransition rt = new RotateTransition(Duration.millis(8000));
		rt.setAxis(Rotate.Y_AXIS);
		rt.setByAngle(180);
		rt.setInterpolator(Interpolator.EASE_BOTH);
		
		return new SequentialTransition(area, zoomOut, rt, zoomIn);
				
	}

	@Override
	protected void resetProperties(Node curNode, Node newNode) {
		newNode.setTranslateZ(0);
		curNode.setTranslateZ(0);
			newNode.setRotate(0);
			curNode.setRotate(0);
	}

}

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
import javafx.animation.FadeTransitionBuilder;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransitionBuilder;
import javafx.animation.PathTransitionBuilder;
import javafx.animation.ScaleTransitionBuilder;
import javafx.animation.SequentialTransitionBuilder;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.shape.CubicCurve;
import javafx.util.Duration;

import org.eclipse.fx.ui.animation.pagetransition.CenterSwitchAnimation;

public class PageChangeAnimation extends CenterSwitchAnimation {

//	@Override
//	public void animate(final BorderPane pane, final Node newNode) {
//		pane.setDepthTest(DepthTest.DISABLE);
//		final Node curNode = pane.getCenter();
//		
//		pane.setCenter(null);
//		
//		final Group area = new Group();
//		area.setDepthTest(DepthTest.ENABLE);
//		
//		Bounds b = curNode.getBoundsInParent();
//		newNode.resizeRelocate(b.getMinX(), b.getMinY(), b.getWidth(), b.getHeight());
//		area.getChildren().add(newNode);
//		area.getChildren().add(curNode);
//		
//		newNode.setTranslateZ(0.1);
//		curNode.setTranslateZ(-0.1);
//		newNode.setRotationAxis(Rotate.Y_AXIS);
//		newNode.setRotate(180);
//		
//		
//		
//		pane.setCenter(area);
//		
//		if (imageView != null) {
//			pane.getChildren().add(0,imageView);
//		}
//		
//		Animation animation = createAndPrepareAnimation(area, null);
//		
//		animation.onFinishedProperty().set(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent event) {
//				pane.getChildren().remove(curNode);
//				pane.getChildren().remove(newNode);
//				pane.setCenter(newNode);
//				resetProperties(curNode, newNode);
//				
//				if (imageView != null) {
//					pane.getChildren().remove(imageView);
//				}
//			}
//		});
//		
//		animation.play();
//	}
	
	@Override
	protected Animation createAndPrepareAnimation(Node curNode, Node newNode) {
		Bounds b = curNode.getBoundsInLocal();
		double cX = b.getMinX() + b.getWidth()/2;
		double cY = b.getMinY() + b.getHeight()/2;
		
		double val = 200;
		
		CubicCurve cIn = new CubicCurve(cX - val, cY, cX - val, cY - val, cX, cY - val, cX, cY);
		CubicCurve cOut = new CubicCurve(cX, cY, cX, cY + val, cX + val, cY + val, cX + val, cY + 0);
//		cIn.setRotationAxis(Rotate.X_AXIS);
//		cIn.setRotate(70);
//		cOut.setRotationAxis(Rotate.X_AXIS);
//		cOut.setRotate(70);
		PathTransitionBuilder moveOut = PathTransitionBuilder.create()
				.duration(new Duration(1000))
				.node(curNode)
				.path(cOut)
				;
		
		PathTransitionBuilder moveIn = PathTransitionBuilder.create()
				.duration(new Duration(1000))
				.node(newNode)
				.path(cIn)
				;
			
		
		ScaleTransitionBuilder zoomOut = ScaleTransitionBuilder.create()
				.duration(new Duration(1000))
				.toX(0.2)
				.toY(0.2)
				.interpolator(Interpolator.EASE_BOTH);
			ScaleTransitionBuilder zoomIn = ScaleTransitionBuilder.create()
				.duration(new Duration(1000))
				.fromX(0.2)
				.fromY(0.2)
				.toX(0.7)
				.toY(0.7)
				.interpolator(Interpolator.EASE_BOTH);
			
			Animation main = ParallelTransitionBuilder.create()
					.children(
						zoomOut.node(curNode).build(),
						zoomIn.node(newNode).build(),
						moveIn.build(),
						moveOut.build()
						,
						FadeTransitionBuilder.create()
							.node(curNode)
							.duration(new Duration(1000))
							.fromValue(1)
							.toValue(0)
							.build(),
						moveOut.build(),
						FadeTransitionBuilder.create()
						.node(newNode)
						.duration(new Duration(1000))
						.fromValue(0)
						.toValue(1)
						.build()
					)
					.build();
			
			ScaleTransitionBuilder zoomOut1 = ScaleTransitionBuilder.create()
					.duration(new Duration(300))
					.toX(0.7)
					.toY(0.7)
					.interpolator(Interpolator.EASE_BOTH);
				ScaleTransitionBuilder zoomIn1 = ScaleTransitionBuilder.create()
					.duration(new Duration(300))
					.toX(1)
					.toY(1)
					.interpolator(Interpolator.EASE_BOTH);
				
				return SequentialTransitionBuilder.create()
					.children(
						ParallelTransitionBuilder.create().children(
							zoomOut1.node(curNode).build(),
							zoomOut1.node(newNode).build()
						).build(),
						main,
						ParallelTransitionBuilder.create().children(
							zoomIn1.node(curNode).build(),
							zoomIn1.node(newNode).build()
						).build()
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

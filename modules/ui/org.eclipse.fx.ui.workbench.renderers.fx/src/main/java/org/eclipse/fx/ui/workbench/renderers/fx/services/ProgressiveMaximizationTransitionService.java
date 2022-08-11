/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Sun Volland<sun.volland@free.fr>
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx.services;

import org.eclipse.fx.ui.workbench.renderers.base.services.MaximizationTransitionService;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.util.Duration;

/**
 *
 * Maximization transition performing growing/shrinking of the maximized
 * component until maximize/original size is reached.
 *
 * @since 2.2.0
 */
public class ProgressiveMaximizationTransitionService implements MaximizationTransitionService<Pane, Region> {

	@Override
	public void maximize(Pane commonRoot, Pane greyPane, Pane containerPane, Region node, Runnable finished) {

		Bounds bounds = getBoundsInParent(commonRoot, node);

		Pane pane = new Pane();
		pane.getChildren().add(node);
		node.setTranslateX(bounds.getMinX());
		node.setTranslateY(bounds.getMinY());
		node.setPrefWidth(node.getWidth());
		node.setPrefHeight(node.getHeight());
		containerPane.getChildren().add(pane);

		Timeline timeline = new Timeline();
		timeline.setCycleCount(1);

		double duration = 300;
		Interpolator interpolator = Interpolator.EASE_BOTH;

		KeyValue kvOpacity = new KeyValue(greyPane.opacityProperty(), Double.valueOf(1.0), interpolator);
		KeyFrame kfOpacity = new KeyFrame(Duration.millis(duration), kvOpacity);
		timeline.getKeyFrames().add(kfOpacity);

		KeyValue kv = new KeyValue(node.translateXProperty(), Double.valueOf(0.0), interpolator);
		KeyFrame kf = new KeyFrame(Duration.millis(duration), kv);
		timeline.getKeyFrames().add(kf);

		KeyValue kvY = new KeyValue(node.translateYProperty(), Double.valueOf(0.0), interpolator);
		KeyFrame kfY = new KeyFrame(Duration.millis(duration), kvY);
		timeline.getKeyFrames().add(kfY);

		KeyValue kvYWidth = new KeyValue(node.prefWidthProperty(), Double.valueOf(commonRoot.getWidth()), interpolator);
		KeyFrame kfYWidth = new KeyFrame(Duration.millis(duration), kvYWidth);
		timeline.getKeyFrames().add(kfYWidth);

		KeyValue kvYHeight = new KeyValue(node.prefHeightProperty(), Double.valueOf(commonRoot.getHeight()), interpolator);
		KeyFrame kfYHeight = new KeyFrame(Duration.millis(duration), kvYHeight);
		timeline.getKeyFrames().add(kfYHeight);

		timeline.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				node.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
				node.setTranslateX(0);
				node.setTranslateY(0);
				finished.run();
			}
		});

		timeline.play();
	}

	@Override
	public void restore(Pane commonRoot, Pane greyPane, Pane containerPane, Pane nodeContainer, Region node, Runnable finished) {

		Bounds bounds = getBoundsInParent(commonRoot, nodeContainer);

		Pane pane = new Pane();
		pane.getChildren().add(node);
		node.setPrefSize(node.getWidth(), node.getHeight());
		containerPane.getChildren().add(pane);

		Timeline timeline = new Timeline();
		timeline.setCycleCount(1);

		double duration = 300;
		Interpolator interpolator = Interpolator.EASE_BOTH;

		KeyValue kvOpacity = new KeyValue(greyPane.opacityProperty(), Double.valueOf(0.0), interpolator);
		final KeyFrame kfOpacity = new KeyFrame(Duration.millis(duration), kvOpacity);
		timeline.getKeyFrames().add(kfOpacity);

		KeyValue kv = new KeyValue(node.translateXProperty(), Double.valueOf(bounds.getMinX()), interpolator);
		KeyFrame kf = new KeyFrame(Duration.millis(duration), kv);
		timeline.getKeyFrames().add(kf);
		KeyValue kvY = new KeyValue(node.translateYProperty(), Double.valueOf(bounds.getMinY()), interpolator);
		KeyFrame kfY = new KeyFrame(Duration.millis(duration), kvY);
		timeline.getKeyFrames().add(kfY);

		KeyValue kvYWidth = new KeyValue(node.prefWidthProperty(), Double.valueOf(bounds.getWidth()), interpolator);
		KeyFrame kfYWidth = new KeyFrame(Duration.millis(duration), kvYWidth);
		timeline.getKeyFrames().add(kfYWidth);

		KeyValue kvYHeight = new KeyValue(node.prefHeightProperty(), Double.valueOf(bounds.getHeight()), interpolator);
		KeyFrame kfYHeight = new KeyFrame(Duration.millis(duration), kvYHeight);
		timeline.getKeyFrames().add(kfYHeight);

		timeline.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				node.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
				node.setTranslateX(0);
				node.setTranslateY(0);
				finished.run();
			}
		});

		timeline.play();
	}

	/**
	 * Utility to get a child's bound relative to an ancestor.
	 *
	 * @param parentNode
	 *            ancestor to get child bounds for
	 * @param childNode
	 *            child
	 * @return bounds of child relative to ancestor
	 */
	private static Bounds getBoundsInParent(Node parentNode, Node childNode) {
		Node child = childNode;
		Bounds bounds = child.getLayoutBounds();
		while (child != null && child != parentNode) {
			bounds = child.localToParent(bounds);
			child = child.getParent();
		}
		return bounds;
	}
}

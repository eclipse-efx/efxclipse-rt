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
package org.eclipse.fx.ui.animation.pagetransition;

import org.eclipse.jdt.annotation.NonNull;

import javafx.animation.Animation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 * Basic animation API
 */
public abstract class CenterSwitchAnimation {

	/**
	 * The image view
	 */
	public ImageView imageView = null;

	/**
	 * Animate to the new node
	 * 
	 * @param pane
	 *            the pane the animation is happening on
	 * @param newNode
	 *            the new node
	 * @param animationFinished
	 *            runnable to run when finished
	 */
	public void animate(final BorderPane pane, final Node newNode, Runnable animationFinished) {

		final Node curNode = pane.getCenter();

		pane.setCenter(null);

		Bounds b = curNode.getBoundsInParent();
		newNode.resizeRelocate(b.getMinX(), b.getMinY(), b.getWidth(), b.getHeight());

		pane.getChildren().add(0, newNode);
		pane.getChildren().add(1, curNode);

		if (this.imageView != null) {
			pane.getChildren().add(0, this.imageView);
		}

		Animation animation = createAndPrepareAnimation(curNode, newNode);

		animation.onFinishedProperty().set(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				pane.getChildren().remove(curNode);
				pane.getChildren().remove(newNode);
				pane.setCenter(newNode);
				resetProperties(curNode, newNode);

				if (CenterSwitchAnimation.this.imageView != null) {
					pane.getChildren().remove(CenterSwitchAnimation.this.imageView);
				}
				
				if( animationFinished != null ) {
					animationFinished.run();	
				}
			}
		});

		animation.play();

	}

	/**
	 * Create an animation and prepare it for execution - but don't execute!
	 * 
	 * @param curNode
	 *            the current node (node moved out!)
	 * @param newNode
	 *            the replacement node (node moved in)
	 * @return the animation
	 */
	@NonNull
	protected abstract Animation createAndPrepareAnimation(@NonNull Node curNode, @NonNull Node newNode);

	/**
	 * Reset properties to their default after the animation has finished
	 * 
	 * @param curNode
	 *            the current node (node moved out!)
	 * @param newNode
	 *            the new node (node moved in)
	 */
	protected abstract void resetProperties(@NonNull Node curNode, @NonNull Node newNode);
}

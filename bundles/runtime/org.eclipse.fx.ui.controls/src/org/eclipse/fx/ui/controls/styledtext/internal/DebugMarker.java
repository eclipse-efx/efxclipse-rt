/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.internal;

import javafx.animation.FillTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class DebugMarker extends Rectangle {

	private FillTransition transition;


	public DebugMarker(Color color, long millis) {
		this.setFill(Color.TRANSPARENT);

		this.setMouseTransparent(true);

		this.transition = new FillTransition();
		this.transition.setFromValue(color);
		this.transition.setToValue(Color.TRANSPARENT);
		this.transition.setShape(this);
		this.transition.setDuration(Duration.millis(millis));

		this.setOpacity(0.5);


	}


	public void play() {
		this.transition.playFromStart();
	}

	@Override
	public void resize(double width, double height) {
		this.setWidth(width);
		this.setHeight(height);
	}

}

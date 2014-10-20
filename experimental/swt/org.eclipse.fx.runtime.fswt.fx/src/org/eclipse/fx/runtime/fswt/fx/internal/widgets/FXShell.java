/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.runtime.fswt.fx.internal.widgets;

import javafx.animation.Transition;
import javafx.beans.property.DoubleProperty;
import javafx.stage.Stage;
import javafx.util.Duration;

import org.eclipse.fx.runtime.fswt.fx.internal.FXSWTObject;
import org.eclipse.fx.runtime.fswt.graphics.FFadeTransition;
import org.eclipse.fx.runtime.fswt.graphics.FFill;
import org.eclipse.fx.runtime.fswt.graphics.FTransition;
import org.eclipse.fx.runtime.fswt.widgets.FShell;
import org.eclipse.swt.widgets.Shell;

public class FXShell<T extends Shell> extends FXSWTObject<T> implements
		FShell<T> {

	public FXShell(T nativeInstance) {
		super(nativeInstance);
	}

	@Override
	public void openBlocking() {
		Stage s = (Stage) getNativeInstance().internal_getWindow();
		s.showAndWait();
	}

	@Override
	public FShell<T> background(FFill fill) {
		getNativeInstance().internal_getNativeObject().setBackground(
				createBackground(fill));
		return this;
	}

	@Override
	public void openBlocking(FTransition transition, Runnable completed) {
		transitionExecutionPre(transition, this::createTransition, completed, () -> openBlocking());
	}

	@Override
	public FShell<T> show(FTransition transition, Runnable completed) {
		transitionExecutionPre(transition, this::createTransition, completed, () -> getNativeInstance().setVisible(true));
		return this;
	}

	@Override
	public FShell<T> hide(FTransition transition, Runnable completed) {
		transitionExecutionPost(transition, this::createTransition, completed, () -> getNativeInstance().setVisible(false));
		return this;
	}

	@Override
	public FShell<T> dispose(FTransition transition, Runnable completed) {
		transitionExecutionPost(transition, this::createTransition, completed, () -> getNativeInstance().dispose());
		return this;
	}

//	private FShell<T> transitionExecution(FTransition transition, Runnable completed, Runnable code) {
//		Transition tr = createTransition(transition);
//
//		tr.setOnFinished((e) -> completed.run());
//		tr.play();
//
//		code.run();
//
//		return this;
//	}

	private Transition createTransition(FTransition transition) {
		if( transition instanceof FFadeTransition.Basic ) {
			FFadeTransition.Basic b = (FFadeTransition.Basic) transition;
			return new DoublePropertyTransition(Duration.millis(b.duration), getNativeInstance().internal_getWindow().opacityProperty(), b.fromOpacity, b.toOpacity);
		}

		throw new IllegalArgumentException("Unknown transition '"+transition+"'");
	}

	static class DoublePropertyTransition extends Transition {
		private DoubleProperty p;
		private double start;
		private double delta;

		public DoublePropertyTransition(Duration d, DoubleProperty p, double start,
				double end) {
			this.p = p;
			this.start = start;
			this.delta = end - start;
			setCycleDuration(d);
		}

		@Override
		protected void interpolate(double frac) {
			final double newValue = Math.max(0.0,
					Math.min(start + frac * delta, 1.0));
			p.set(newValue);
		}
	}
}

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
package org.eclipse.fx.runtime.fswt.fx.internal;

import java.util.function.Function;

import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import org.eclipse.fx.runtime.fswt.FSWT;
import org.eclipse.fx.runtime.fswt.FSWTObject;
import org.eclipse.fx.runtime.fswt.graphics.FFadeTransition;
import org.eclipse.fx.runtime.fswt.graphics.FFill;
import org.eclipse.fx.runtime.fswt.graphics.FSolidFill;
import org.eclipse.fx.runtime.fswt.graphics.FTransition;

public class FXSWTObject<T> implements FSWTObject<T> {
	private final T nativeInstance;

	private final FSWT fswt;

	public FXSWTObject(T nativeInstance, FSWT fswt) {
		this.nativeInstance = nativeInstance;
		this.fswt = fswt;
	}

	@Override
	public T getNativeInstance() {
		return nativeInstance;
	}

	public FSWT getFSWT() {
		return fswt;
	}

	public static final Background createBackground(FFill fill) {
		if( fill instanceof FSolidFill ) {
			FSolidFill sf = (FSolidFill) fill;
			return new Background(new BackgroundFill(Color.rgb(sf.red, sf.green, sf.blue, sf.opacity), CornerRadii.EMPTY, Insets.EMPTY));
		}
		throw new IllegalArgumentException("Unsupported fill type '"+fill+"'");
	}

	public static void transitionExecutionPre(FTransition transition, Function<FTransition, Transition> transitionFactory, Runnable completed, Runnable code) {
		Transition tr = transitionFactory.apply(transition);

		tr.setOnFinished((e) -> completed.run());
		tr.play();

		code.run();
	}

	public static void transitionExecutionPost(FTransition transition, Function<FTransition, Transition> transitionFactory, Runnable completed, Runnable code) {
		Transition tr = transitionFactory.apply(transition);

		tr.setOnFinished((e) -> {
			code.run();
			completed.run();
		});
		tr.play();
	}


	public static final Transition createTransition(FTransition transition, Node node) {
		if( transition instanceof FFadeTransition ) {
			if( transition instanceof FFadeTransition.Basic ) {
				FFadeTransition.Basic t = (FFadeTransition.Basic) transition;
				FadeTransition rv = new FadeTransition(Duration.millis(t.duration),node);
				rv.setFromValue(t.fromOpacity);
				rv.setToValue(t.toOpacity);
				return rv;
			}
		}

		throw new IllegalArgumentException("Unsupported transition type '"+transition+"'");
	}
}

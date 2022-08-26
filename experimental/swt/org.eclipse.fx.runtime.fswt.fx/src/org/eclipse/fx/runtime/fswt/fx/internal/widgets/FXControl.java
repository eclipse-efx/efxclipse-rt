/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.runtime.fswt.fx.internal.widgets;

import javafx.animation.Transition;

import org.eclipse.fx.runtime.fswt.FSWT;
import org.eclipse.fx.runtime.fswt.fx.internal.FXSWTObject;
import org.eclipse.fx.runtime.fswt.graphics.FFill;
import org.eclipse.fx.runtime.fswt.graphics.FTransition;
import org.eclipse.fx.runtime.fswt.widgets.FControl;
import org.eclipse.swt.widgets.Control;

public class FXControl<T extends Control> extends FXSWTObject<T> implements FControl<T> {

	public FXControl(T nativeInstance, FSWT fswt) {
		super(nativeInstance,fswt);
	}

	@Override
	public FControl<T> background(FFill fill) {
		getNativeInstance().internal_getNativeObject().setBackground(createBackground(fill));
		return this;
	}

	@Override
	public FControl<T> show(FTransition transition, Runnable completed) {
		transitionExecutionPre(transition, this::createTransition, completed, () -> getNativeInstance().setVisible(true));
		return this;
	}

	@Override
	public FControl<T> hide(FTransition transition, Runnable completed) {
		transitionExecutionPost(transition, this::createTransition, completed, () -> getNativeInstance().setVisible(false));
		return this;
	}

	@Override
	public FControl<T> dispose(FTransition transition, Runnable completed) {
		transitionExecutionPost(transition, this::createTransition, completed, () -> getNativeInstance().dispose());
		return this;
	}

	private Transition createTransition(FTransition transition) {
		return createTransition(transition, getNativeInstance().internal_getNativeObject());
	}
}

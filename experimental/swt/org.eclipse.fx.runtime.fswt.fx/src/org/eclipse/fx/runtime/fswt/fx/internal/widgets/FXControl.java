package org.eclipse.fx.runtime.fswt.fx.internal.widgets;

import javafx.animation.Transition;

import org.eclipse.fx.runtime.fswt.fx.internal.FXSWTObject;
import org.eclipse.fx.runtime.fswt.graphics.FFill;
import org.eclipse.fx.runtime.fswt.graphics.FTransition;
import org.eclipse.fx.runtime.fswt.widgets.FControl;
import org.eclipse.swt.widgets.Control;

public class FXControl<T extends Control> extends FXSWTObject<T> implements FControl<T> {

	public FXControl(T nativeInstance) {
		super(nativeInstance);
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

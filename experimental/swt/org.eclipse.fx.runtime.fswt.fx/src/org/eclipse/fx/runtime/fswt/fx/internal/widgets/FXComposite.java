package org.eclipse.fx.runtime.fswt.fx.internal.widgets;

import javafx.animation.Transition;

import org.eclipse.fx.runtime.fswt.fx.internal.FXSWTObject;
import org.eclipse.fx.runtime.fswt.graphics.FFill;
import org.eclipse.fx.runtime.fswt.graphics.FTransition;
import org.eclipse.fx.runtime.fswt.widgets.FComposite;
import org.eclipse.swt.widgets.Composite;

public class FXComposite<T extends Composite> extends FXSWTObject<T> implements FComposite<T> {

	public FXComposite(T nativeInstance) {
		super(nativeInstance);
	}

	@Override
	public FComposite<T> background(FFill fill) {
		getNativeInstance().internal_getNativeObject().setBackground(createBackground(fill));
		return this;
	}

	@Override
	public FXComposite<T> show(FTransition transition, Runnable completed) {
		transitionExecutionPre(transition, this::createTransition, completed, () -> getNativeInstance().setVisible(true));
		return this;
	}

	@Override
	public FXComposite<T> hide(FTransition transition, Runnable completed) {
		transitionExecutionPost(transition, this::createTransition, completed, () -> getNativeInstance().setVisible(false));
		return this;
	}

	@Override
	public FXComposite<T> dispose(FTransition transition, Runnable completed) {
		transitionExecutionPost(transition, this::createTransition, completed, () -> getNativeInstance().dispose());
		return this;
	}

	private Transition createTransition(FTransition transition) {
		return createTransition(transition, getNativeInstance().internal_getNativeObject());
	}
}

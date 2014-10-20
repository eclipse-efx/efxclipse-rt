package org.eclipse.fx.runtime.fswt.noop.internal.widgets;

import org.eclipse.fx.runtime.fswt.graphics.FFill;
import org.eclipse.fx.runtime.fswt.graphics.FTransition;
import org.eclipse.fx.runtime.fswt.noop.internal.NSWTObject;
import org.eclipse.fx.runtime.fswt.widgets.FControl;
import org.eclipse.swt.widgets.Control;

public class NControl<T extends Control> extends NSWTObject<T> implements FControl<T> {

	public NControl(T instance) {
		super(instance);
	}

	@Override
	public FControl<T> background(FFill fill) {
		return this;
	}

	@Override
	public FControl<T> show(FTransition transition, Runnable completed) {
		getNativeInstance().setVisible(true);
		completed.run();
		return this;
	}

	@Override
	public FControl<T> hide(FTransition transition, Runnable completed) {
		getNativeInstance().setVisible(false);
		completed.run();
		return this;
	}

	@Override
	public FControl<T> dispose(FTransition transition, Runnable completed) {
		getNativeInstance().dispose();
		completed.run();
		return this;
	}


}

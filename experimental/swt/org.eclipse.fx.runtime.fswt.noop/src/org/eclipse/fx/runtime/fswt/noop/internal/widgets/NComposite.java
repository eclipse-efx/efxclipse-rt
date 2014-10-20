package org.eclipse.fx.runtime.fswt.noop.internal.widgets;

import org.eclipse.fx.runtime.fswt.graphics.FFill;
import org.eclipse.fx.runtime.fswt.graphics.FTransition;
import org.eclipse.fx.runtime.fswt.noop.internal.NSWTObject;
import org.eclipse.fx.runtime.fswt.widgets.FComposite;
import org.eclipse.swt.widgets.Composite;

public class NComposite<T extends Composite> extends NSWTObject<T> implements FComposite<T> {

	public NComposite(T instance) {
		super(instance);
	}

	@Override
	public FComposite<T> background(FFill fill) {
		return this;
	}

	@Override
	public FComposite<T> show(FTransition transition, Runnable completed) {
		getNativeInstance().setVisible(true);
		completed.run();
		return this;
	}

	@Override
	public FComposite<T> hide(FTransition transition, Runnable completed) {
		getNativeInstance().setVisible(false);
		completed.run();
		return this;
	}

	@Override
	public FComposite<T> dispose(FTransition transition, Runnable completed) {
		getNativeInstance().dispose();
		completed.run();
		return this;
	}

}

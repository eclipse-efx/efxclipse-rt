package org.eclipse.fx.runtime.fswt.widgets;

import org.eclipse.fx.runtime.fswt.graphics.FFill;
import org.eclipse.fx.runtime.fswt.graphics.FTransition;
import org.eclipse.swt.widgets.Control;

public interface FControl<T extends Control> extends FWidget<T> {
	public FControl<T> background(FFill fill);

	public FControl<T> show(FTransition transition, Runnable completed);
	public FControl<T> hide(FTransition transition, Runnable completed);
	public FControl<T> dispose(FTransition transition, Runnable completed);
}

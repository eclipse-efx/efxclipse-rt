package org.eclipse.fx.runtime.fswt.widgets;

import org.eclipse.fx.runtime.fswt.graphics.FFill;
import org.eclipse.fx.runtime.fswt.graphics.FTransition;
import org.eclipse.swt.widgets.Composite;

public interface FComposite<T extends Composite> extends FControl<T> {
	public FComposite<T> background(FFill fill);
	public FComposite<T> show(FTransition transition, Runnable completed);
	public FComposite<T> hide(FTransition transition, Runnable completed);
	public FComposite<T> dispose(FTransition transition, Runnable completed);
}

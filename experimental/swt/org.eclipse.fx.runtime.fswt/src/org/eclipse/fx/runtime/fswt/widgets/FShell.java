package org.eclipse.fx.runtime.fswt.widgets;

import org.eclipse.fx.runtime.fswt.graphics.FFill;
import org.eclipse.fx.runtime.fswt.graphics.FTransition;
import org.eclipse.swt.widgets.Shell;

public interface FShell<T extends Shell> extends FComposite<T> {
	public void openBlocking();
	public void openBlocking(FTransition transition, Runnable completed);

	public FShell<T> background(FFill fill);
	public FShell<T> show(FTransition transition, Runnable completed);
	public FShell<T> hide(FTransition transition, Runnable completed);
	public FShell<T> dispose(FTransition transition, Runnable completed);
}

package org.eclipse.fx.runtime.fswt;

import org.eclipse.fx.runtime.fswt.widgets.FDisplay;
import org.eclipse.fx.runtime.fswt.widgets.FWidget;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;

public interface FSWT {
	public int getRanking();
	public <T extends Widget,F extends FWidget<T>> F adapt(T widget, Class<F> clazz);
	public void boostrap(FCallback<FDisplay<Display>,FBlockCondition> initialize);
}

package org.eclipse.fx.runtime.fswt.widgets;

import org.eclipse.fx.runtime.fswt.FBlockCondition;
import org.eclipse.fx.runtime.fswt.FSWTObject;
import org.eclipse.swt.widgets.Display;

public interface FDisplay<T extends Display> extends FSWTObject<T> {
	public void block(FBlockCondition blockCondition);
}

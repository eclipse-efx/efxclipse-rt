package org.eclipse.fx.runtime.fswt.fx.internal.widgets;

import org.eclipse.fx.runtime.fswt.FBlockCondition;
import org.eclipse.fx.runtime.fswt.fx.FXSWT.DefaultBlockCondition;
import org.eclipse.fx.runtime.fswt.fx.internal.FXSWTObject;
import org.eclipse.fx.runtime.fswt.widgets.FDisplay;
import org.eclipse.swt.widgets.Display;

public class FXDisplay<T extends Display> extends FXSWTObject<T> implements FDisplay<T> {

	public FXDisplay(T nativeInstance) {
		super(nativeInstance);
	}

	public void block(FBlockCondition condition) {
		DefaultBlockCondition fCondition = (DefaultBlockCondition) condition;
		Display d = getNativeInstance();
		while( fCondition.isBlocked() ) {
			if( !d.readAndDispatch() ) {
				d.sleep();
			}
		}
	}
}

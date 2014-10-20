package org.eclipse.fx.runtime.fswt.noop.internal.widgets;

import org.eclipse.fx.runtime.fswt.FBlockCondition;
import org.eclipse.fx.runtime.fswt.noop.internal.NSWTObject;
import org.eclipse.fx.runtime.fswt.widgets.FDisplay;
import org.eclipse.swt.widgets.Display;

public class NDisplay<T extends Display> extends NSWTObject<T> implements FDisplay<T> {

	public NDisplay(T instance) {
		super(instance);
	}

	@Override
	public void block(FBlockCondition condition) {
		DefaultBlockCondition fCondition = (DefaultBlockCondition) condition;
		Display d = getNativeInstance();
		while( fCondition.isBlocked() ) {
			if( !d.readAndDispatch() ) {
				d.sleep();
			}
		}
	}

	public static class DefaultBlockCondition implements FBlockCondition {
		private boolean blocked = true;

		public final synchronized void unblock() {
			this.blocked = false;
		}

		public synchronized boolean isBlocked() {
			return blocked;
		}
	}
}

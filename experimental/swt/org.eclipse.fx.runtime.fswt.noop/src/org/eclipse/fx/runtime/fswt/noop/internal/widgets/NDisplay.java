/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
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

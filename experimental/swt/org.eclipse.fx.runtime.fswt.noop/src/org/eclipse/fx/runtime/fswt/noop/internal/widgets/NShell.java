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

import org.eclipse.fx.runtime.fswt.FSWT;
import org.eclipse.fx.runtime.fswt.graphics.FFill;
import org.eclipse.fx.runtime.fswt.graphics.FTransition;
import org.eclipse.fx.runtime.fswt.noop.internal.NSWTObject;
import org.eclipse.fx.runtime.fswt.widgets.FShell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class NShell<T extends Shell> extends NSWTObject<T> implements FShell<T> {

	public NShell(T instance, FSWT fswt) {
		super(instance,fswt);
	}

	@Override
	public void openBlocking() {
		Shell s = getNativeInstance();
		Display d = s.getDisplay();
		while( ! s.isDisposed() ) {
			if( ! d.readAndDispatch() ) {
				d.sleep();
			}
		}
	}

	@Override
	public void openBlocking(FTransition transition, Runnable completed) {
		completed.run();
		openBlocking();
	}

	@Override
	public FShell<T> background(FFill fill) {
		return this;
	}

	@Override
	public FShell<T> show(FTransition transition, Runnable completed) {
		getNativeInstance().setVisible(true);
		completed.run();
		return this;
	}

	@Override
	public FShell<T> hide(FTransition transition, Runnable completed) {
		getNativeInstance().setVisible(false);
		completed.run();
		return this;
	}

	@Override
	public FShell<T> dispose(FTransition transition, Runnable completed) {
		getNativeInstance().dispose();
		completed.run();
		return this;
	}

}

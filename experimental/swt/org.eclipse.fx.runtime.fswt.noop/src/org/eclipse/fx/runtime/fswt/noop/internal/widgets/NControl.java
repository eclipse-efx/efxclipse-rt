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
import org.eclipse.fx.runtime.fswt.widgets.FControl;
import org.eclipse.swt.widgets.Control;

public class NControl<T extends Control> extends NSWTObject<T> implements FControl<T> {

	public NControl(T instance, FSWT fswt) {
		super(instance,fswt);
	}

	@Override
	public FControl<T> background(FFill fill) {
		return this;
	}

	@Override
	public FControl<T> show(FTransition transition, Runnable completed) {
		getNativeInstance().setVisible(true);
		completed.run();
		return this;
	}

	@Override
	public FControl<T> hide(FTransition transition, Runnable completed) {
		getNativeInstance().setVisible(false);
		completed.run();
		return this;
	}

	@Override
	public FControl<T> dispose(FTransition transition, Runnable completed) {
		getNativeInstance().dispose();
		completed.run();
		return this;
	}


}

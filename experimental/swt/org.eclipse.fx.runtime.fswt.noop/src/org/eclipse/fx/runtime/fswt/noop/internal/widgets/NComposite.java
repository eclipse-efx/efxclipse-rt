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

import org.eclipse.fx.runtime.fswt.graphics.FFill;
import org.eclipse.fx.runtime.fswt.graphics.FTransition;
import org.eclipse.fx.runtime.fswt.noop.internal.NSWTObject;
import org.eclipse.fx.runtime.fswt.widgets.FComposite;
import org.eclipse.swt.widgets.Composite;

public class NComposite<T extends Composite> extends NSWTObject<T> implements FComposite<T> {

	public NComposite(T instance) {
		super(instance);
	}

	@Override
	public FComposite<T> background(FFill fill) {
		return this;
	}

	@Override
	public FComposite<T> show(FTransition transition, Runnable completed) {
		getNativeInstance().setVisible(true);
		completed.run();
		return this;
	}

	@Override
	public FComposite<T> hide(FTransition transition, Runnable completed) {
		getNativeInstance().setVisible(false);
		completed.run();
		return this;
	}

	@Override
	public FComposite<T> dispose(FTransition transition, Runnable completed) {
		getNativeInstance().dispose();
		completed.run();
		return this;
	}

}

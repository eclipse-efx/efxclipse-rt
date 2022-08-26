/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
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

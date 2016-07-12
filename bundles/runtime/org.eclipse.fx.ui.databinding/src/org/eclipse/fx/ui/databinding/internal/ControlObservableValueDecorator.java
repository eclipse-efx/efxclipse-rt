/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.databinding.internal;

import org.eclipse.core.databinding.observable.value.DecoratingObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.fx.ui.databinding.IJFXControlValueObservable;

@SuppressWarnings("javadoc")
public class ControlObservableValueDecorator<T> extends DecoratingObservableValue<T> implements IJFXControlValueObservable<T> {

	/**
	 * @param decorated
	 */
	public ControlObservableValueDecorator(IObservableValue<T> decorated) {
		super(decorated, true);
	}

}

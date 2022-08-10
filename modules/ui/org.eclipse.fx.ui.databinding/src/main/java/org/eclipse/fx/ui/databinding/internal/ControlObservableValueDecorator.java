/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
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

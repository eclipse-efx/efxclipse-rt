/*******************************************************************************
 * Copyright (c) 2007, 2008 Brad Reynolds and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Brad Reynolds - initial API and implementation
 *     Matthew Hall - bug 246625
 ******************************************************************************/

package org.eclipse.fx.core.databinding.internal;

import java.beans.PropertyDescriptor;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.DecoratingObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.fx.core.databinding.IJFXBeanObservable;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;


/**
 * {@link IJFXBeanObservable} decorator for an {@link IObservableValue}.
 * 
 * @since 3.3
 */
public class FXBeanObservableValueDecorator extends DecoratingObservableValue
		implements IJFXBeanObservable {
	@Nullable
	private PropertyDescriptor propertyDescriptor;

	/**
	 * @param decorated
	 * @param propertyDescriptor
	 */
	public FXBeanObservableValueDecorator(@NonNull IObservableValue decorated,
			@Nullable PropertyDescriptor propertyDescriptor) {
		super(decorated, true);
		this.propertyDescriptor = propertyDescriptor;
	}

	@Override
	public synchronized void dispose() {
		this.propertyDescriptor = null;
		super.dispose();
	}

	@Override
	@Nullable
	public Object getObserved() {
		IObservable decorated = getDecorated();
		if (decorated instanceof IObserving)
			return ((IObserving) decorated).getObserved();
		return null;
	}

	@Override
	@Nullable
	public PropertyDescriptor getPropertyDescriptor() {
		return this.propertyDescriptor;
	}
}

/*******************************************************************************
 * Copyright (c) 2007, 2008 Brad Reynolds and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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


/**
 * {@link IJFXBeanObservable} decorator for an {@link IObservableValue}.
 * 
 * @since 3.3
 */
public class FXBeanObservableValueDecorator extends DecoratingObservableValue
		implements IJFXBeanObservable {
	private PropertyDescriptor propertyDescriptor;

	/**
	 * @param decorated
	 * @param propertyDescriptor
	 */
	public FXBeanObservableValueDecorator(IObservableValue decorated,
			PropertyDescriptor propertyDescriptor) {
		super(decorated, true);
		this.propertyDescriptor = propertyDescriptor;
	}

	public synchronized void dispose() {
		this.propertyDescriptor = null;
		super.dispose();
	}

	public Object getObserved() {
		IObservable decorated = getDecorated();
		if (decorated instanceof IObserving)
			return ((IObserving) decorated).getObserved();
		return null;
	}

	public PropertyDescriptor getPropertyDescriptor() {
		return propertyDescriptor;
	}
}

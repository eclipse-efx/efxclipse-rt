/*******************************************************************************
 * Copyright (c) 2008, 2009 Matthew Hall and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Matthew Hall - initial API and implementation (bug 194734)
 *     Matthew Hall - bug 195222, 264307, 265561
 ******************************************************************************/

package org.eclipse.fx.core.databinding.internal;

import java.beans.PropertyDescriptor;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IDiff;
import org.eclipse.core.databinding.property.INativePropertyListener;
import org.eclipse.core.databinding.property.ISimplePropertyListener;
import org.eclipse.core.databinding.property.value.SimpleValueProperty;

/**
 * @since 3.3
 * 
 */
public class FXBeanValueProperty extends SimpleValueProperty {
	private final PropertyDescriptor propertyDescriptor;
	private final Class<?> valueType;

	/**
	 * Create a new value property
	 * 
	 * @param propertyDescriptor
	 *            the descriptor
	 * @param valueType
	 *            the value type
	 */
	public FXBeanValueProperty(PropertyDescriptor propertyDescriptor, Class<?> valueType) {
		this.propertyDescriptor = propertyDescriptor;
		this.valueType = valueType == null ? propertyDescriptor.getPropertyType() : valueType;
	}

	@Override
	public Object getValueType() {
		return this.valueType;
	}

	@Override
	protected Object doGetValue(Object source) {
		return FXBeanPropertyHelper.readProperty(source, this.propertyDescriptor);
	}

	@Override
	protected void doSetValue(Object source, Object value) {
		FXBeanPropertyHelper.writeProperty(source, this.propertyDescriptor, value);
	}

	@Override
	public INativePropertyListener adaptListener(final ISimplePropertyListener listener) {
		return new FXBeanPropertyListener(this, this.propertyDescriptor, listener) {
			@Override
			protected IDiff computeDiff(Object oldValue, Object newValue) {
				return Diffs.createValueDiff(oldValue, newValue);
			}
		};
	}

	@Override
	public String toString() {
		String s = FXBeanPropertyHelper.propertyName(this.propertyDescriptor);
		if (this.valueType != null)
			s += "<" + FXBeanPropertyHelper.shortClassName(this.valueType) + ">"; //$NON-NLS-1$//$NON-NLS-2$
		return s;
	}
}

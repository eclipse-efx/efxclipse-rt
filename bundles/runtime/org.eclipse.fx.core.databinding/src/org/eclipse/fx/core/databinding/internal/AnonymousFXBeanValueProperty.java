/*******************************************************************************
 * Copyright (c) 2008, 2009 Matthew Hall and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Matthew Hall - initial API and implementation (bug 247997)
 *     Matthew Hall - bugs 264307, 264619
 ******************************************************************************/

package org.eclipse.fx.core.databinding.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.masterdetail.MasterDetailObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.DelegatingValueProperty;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.fx.core.databinding.JFXBeanProperties;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;


/**
 * @since 3.3
 * 
 */
public class AnonymousFXBeanValueProperty extends DelegatingValueProperty {
	@NonNull
	private final String propertyName;

	@NonNull
	private Map<Class<?>,IValueProperty> delegates;

	/**
	 * @param propertyName
	 * @param valueType
	 */
	public AnonymousFXBeanValueProperty(String propertyName, @Nullable Class<?> valueType) {
		super(valueType);
		this.propertyName = propertyName;
		this.delegates = new HashMap<Class<?>,IValueProperty>();
	}

	@Override
	@Nullable
	protected IValueProperty doGetDelegate(Object source) {
		return getClassDelegate(source.getClass());
	}

	private IValueProperty getClassDelegate(Class<?> beanClass) {
		if (this.delegates.containsKey(beanClass))
			return this.delegates.get(beanClass);

		IValueProperty delegate;
		try {
			delegate = JFXBeanProperties.value(beanClass, this.propertyName,
					(Class<?>) getValueType());
		} catch (IllegalArgumentException noSuchProperty) {
			delegate = null;
		}
		this.delegates.put(beanClass, delegate);
		return delegate;
	}

	@Override
	public IObservableValue observeDetail(IObservableValue master) {
		Object valueType = getValueType();
		if (valueType == null)
			valueType = inferValueType(master.getValueType());
		return MasterDetailObservables.detailValue(master, valueFactory(master
				.getRealm()), valueType);
	}

	private Object inferValueType(Object masterObservableValueType) {
		if (masterObservableValueType instanceof Class) {
			return getClassDelegate((Class<?>) masterObservableValueType)
					.getValueType();
		}
		return null;
	}

	@Override
	public String toString() {
		String s = "?." + this.propertyName; //$NON-NLS-1$
		Class<?> valueType = (Class<?>) getValueType();
		if (valueType != null)
			s += "<" + FXBeanPropertyHelper.shortClassName(valueType) + ">"; //$NON-NLS-1$//$NON-NLS-2$
		return s;
	}
}

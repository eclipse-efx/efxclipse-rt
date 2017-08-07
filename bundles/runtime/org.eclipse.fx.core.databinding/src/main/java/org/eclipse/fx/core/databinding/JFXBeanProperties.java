/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.databinding;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.fx.core.databinding.internal.AnonymousFXBeanValueProperty;
import org.eclipse.fx.core.databinding.internal.FXBeanPropertyHelper;
import org.eclipse.fx.core.databinding.internal.FXBeanValueProperty;
import org.eclipse.fx.core.databinding.internal.FXBeanValuePropertyDecorator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Factory to create property descriptions
 */
public class JFXBeanProperties {
	/**
	 * Create a single value property without a type
	 * 
	 * @param propertyName
	 *            the name of the property (nested properties are separated with a .)
	 * @return the property
	 */
	public static @NonNull IJFXBeanValueProperty value(@NonNull String propertyName) {
		return value(null, propertyName, null);
	}

	/**
	 * Create a single value property with a type
	 * 
	 * @param propertyName
	 *            the name of the property (nested properties are separated with a .)
	 * @param valueType
	 *            the type
	 * @return the property
	 */
	public static @NonNull IJFXBeanValueProperty value(@NonNull String propertyName, Class<?> valueType) {
		return value(null, propertyName, valueType);
	}

	/**
	 * Create a property on a class
	 * 
	 * @param beanClass
	 *            the bean type the property is created on
	 * @param propertyName
	 *            the property name
	 * @param _valueType
	 *            the type
	 * @return the property
	 */
	public static @NonNull IJFXBeanValueProperty value(@Nullable Class<?> beanClass, @NonNull String propertyName, @Nullable Class<?> _valueType) {
		Class<?> valueType = _valueType;
		@NonNull String[] propertyNames = split(propertyName);
		if (propertyNames.length > 1) {
			valueType = null;
		}

		PropertyDescriptor propertyDescriptor;
		IValueProperty property;
		if (beanClass == null) {
			propertyDescriptor = null;
			property = new AnonymousFXBeanValueProperty(propertyNames[0], valueType);
		} else {
			propertyDescriptor = FXBeanPropertyHelper.getPropertyDescriptor(beanClass, propertyNames[0]);
			property = new FXBeanValueProperty(propertyDescriptor, valueType);
		}

		@NonNull
		IJFXBeanValueProperty beanProperty = new FXBeanValuePropertyDecorator(property, propertyDescriptor);
		for (int i = 1; i < propertyNames.length; i++) {
			beanProperty = beanProperty.value(propertyNames[i]);
		}
		return beanProperty;
	}

	@SuppressWarnings("null")
	private static @NonNull String[] split(@NonNull String _propertyName) {
		String propertyName = _propertyName;
		if (propertyName.indexOf('.') == -1)
			return new String[] { propertyName };
		List<String> propertyNames = new ArrayList<String>();
		int index;
		while ((index = propertyName.indexOf('.')) != -1) {
			propertyNames.add(propertyName.substring(0, index));
			propertyName = propertyName.substring(index + 1);
		}
		propertyNames.add(propertyName);
		return (String[]) propertyNames.toArray(new String[propertyNames.size()]);
	}
}

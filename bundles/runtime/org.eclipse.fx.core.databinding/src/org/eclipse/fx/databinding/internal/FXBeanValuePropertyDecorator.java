/*******************************************************************************
 * Copyright (c) 2008, 2010 Matthew Hall and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Matthew Hall - initial API and implementation (bug 195222)
 *     Matthew Hall - bug 264307
 ******************************************************************************/

package org.eclipse.fx.databinding.internal;

import java.beans.PropertyDescriptor;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.core.databinding.property.value.ValueProperty;
import org.eclipse.fx.databinding.IJFXBeanValueProperty;
import org.eclipse.fx.databinding.JFXBeanProperties;


/**
 * @since 3.3
 * 
 */
public class FXBeanValuePropertyDecorator extends ValueProperty implements
		IJFXBeanValueProperty {
	private final IValueProperty delegate;
	private final PropertyDescriptor propertyDescriptor;

	/**
	 * @param delegate
	 * @param propertyDescriptor
	 */
	public FXBeanValuePropertyDecorator(IValueProperty delegate,
			PropertyDescriptor propertyDescriptor) {
		this.delegate = delegate;
		this.propertyDescriptor = propertyDescriptor;
	}

	public PropertyDescriptor getPropertyDescriptor() {
		return propertyDescriptor;
	}

	public Object getValueType() {
		return delegate.getValueType();
	}

	protected Object doGetValue(Object source) {
		return delegate.getValue(source);
	}

	protected void doSetValue(Object source, Object value) {
		delegate.setValue(source, value);
	}

	public IJFXBeanValueProperty value(String propertyName) {
		return value(propertyName, null);
	}

	public IJFXBeanValueProperty value(String propertyName, Class valueType) {
		Class beanClass = (Class) delegate.getValueType();
		return value(JFXBeanProperties.value(beanClass, propertyName, valueType));
	}

	public IJFXBeanValueProperty value(IJFXBeanValueProperty property) {
		return new FXBeanValuePropertyDecorator(super.value(property),
				property.getPropertyDescriptor());
	}

	/*public IBeanListProperty list(String propertyName) {
		return list(propertyName, null);
	}

	public IBeanListProperty list(String propertyName, Class elementType) {
		Class beanClass = (Class) delegate.getValueType();
		return list(BeanProperties.list(beanClass, propertyName, elementType));
	}

	public IBeanListProperty list(IBeanListProperty property) {
		return new BeanListPropertyDecorator(super.list(property),
				property.getPropertyDescriptor());
	}

	public IBeanSetProperty set(String propertyName) {
		return set(propertyName, null);
	}

	public IBeanSetProperty set(String propertyName, Class elementType) {
		Class beanClass = (Class) delegate.getValueType();
		return set(BeanProperties.set(beanClass, propertyName, elementType));
	}

	public IBeanSetProperty set(IBeanSetProperty property) {
		return new BeanSetPropertyDecorator(super.set(property),
				property.getPropertyDescriptor());
	}

	public IBeanMapProperty map(String propertyName) {
		return map(propertyName, null, null);
	}

	public IBeanMapProperty map(String propertyName, Class keyType,
			Class valueType) {
		Class beanClass = (Class) delegate.getValueType();
		return map(BeanProperties.map(beanClass, propertyName, keyType,
				valueType));
	}

	public IBeanMapProperty map(IBeanMapProperty property) {
		return new BeanMapPropertyDecorator(super.map(property),
				property.getPropertyDescriptor());
	}*/

	public IObservableValue observe(Object source) {
		return new FXBeanObservableValueDecorator(delegate.observe(source),
				propertyDescriptor);
	}

	public IObservableValue observe(Realm realm, Object source) {
		return new FXBeanObservableValueDecorator(
				delegate.observe(realm, source), propertyDescriptor);
	}

	public IObservableValue observeDetail(IObservableValue master) {
		return new FXBeanObservableValueDecorator(delegate.observeDetail(master),
				propertyDescriptor);
	}

	/*public IObservableList observeDetail(IObservableList master) {
		return new FXBeanObservableListDecorator(delegate.observeDetail(master),
				propertyDescriptor);
	}

	public IObservableMap observeDetail(IObservableSet master) {
		return new FXBeanObservableMapDecorator(delegate.observeDetail(master),
				propertyDescriptor);
	}

	public IObservableMap observeDetail(IObservableMap master) {
		return new FXBeanObservableMapDecorator(delegate.observeDetail(master),
				propertyDescriptor);
	}*/

	public String toString() {
		return delegate.toString();
	}
}

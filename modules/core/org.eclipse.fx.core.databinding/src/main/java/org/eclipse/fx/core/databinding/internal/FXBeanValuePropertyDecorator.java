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

package org.eclipse.fx.core.databinding.internal;

import java.beans.PropertyDescriptor;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.core.databinding.property.value.ValueProperty;
import org.eclipse.fx.core.databinding.IJFXBeanValueProperty;
import org.eclipse.fx.core.databinding.JFXBeanProperties;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * @since 3.3
 * 
 */
public class FXBeanValuePropertyDecorator extends ValueProperty implements IJFXBeanValueProperty {
	@NonNull
	private final IValueProperty delegate;

	@Nullable
	private final PropertyDescriptor propertyDescriptor;

	/**
	 * Create a new decorator
	 * 
	 * @param delegate
	 *            the delegate
	 * @param propertyDescriptor
	 *            the descriptor
	 */
	public FXBeanValuePropertyDecorator(@NonNull IValueProperty delegate,
			@Nullable PropertyDescriptor propertyDescriptor) {
		this.delegate = delegate;
		this.propertyDescriptor = propertyDescriptor;
	}

	@Override
	public PropertyDescriptor getPropertyDescriptor() {
		return this.propertyDescriptor;
	}

	@Override
	public Object getValueType() {
		return this.delegate.getValueType();
	}

	@Override
	protected Object doGetValue(Object source) {
		return this.delegate.getValue(source);
	}

	@Override
	protected void doSetValue(Object source, Object value) {
		this.delegate.setValue(source, value);
	}

	@Override
	public IJFXBeanValueProperty value(String propertyName) {
		return value(propertyName, null);
	}

	@Override
	public IJFXBeanValueProperty value(String propertyName, Class<?> valueType) {
		Class<?> beanClass = (Class<?>) this.delegate.getValueType();
		return value(JFXBeanProperties.value(beanClass, propertyName, valueType));
	}

	@SuppressWarnings("null")
	@Override
	public IJFXBeanValueProperty value(IJFXBeanValueProperty property) {
		return new FXBeanValuePropertyDecorator(super.value(property), property.getPropertyDescriptor());
	}

	/*
	 * public IBeanListProperty list(String propertyName) { return
	 * list(propertyName, null); }
	 * 
	 * public IBeanListProperty list(String propertyName, Class elementType) { Class
	 * beanClass = (Class) delegate.getValueType(); return
	 * list(BeanProperties.list(beanClass, propertyName, elementType)); }
	 * 
	 * public IBeanListProperty list(IBeanListProperty property) { return new
	 * BeanListPropertyDecorator(super.list(property),
	 * property.getPropertyDescriptor()); }
	 * 
	 * public IBeanSetProperty set(String propertyName) { return set(propertyName,
	 * null); }
	 * 
	 * public IBeanSetProperty set(String propertyName, Class elementType) { Class
	 * beanClass = (Class) delegate.getValueType(); return
	 * set(BeanProperties.set(beanClass, propertyName, elementType)); }
	 * 
	 * public IBeanSetProperty set(IBeanSetProperty property) { return new
	 * BeanSetPropertyDecorator(super.set(property),
	 * property.getPropertyDescriptor()); }
	 * 
	 * public IBeanMapProperty map(String propertyName) { return map(propertyName,
	 * null, null); }
	 * 
	 * public IBeanMapProperty map(String propertyName, Class keyType, Class
	 * valueType) { Class beanClass = (Class) delegate.getValueType(); return
	 * map(BeanProperties.map(beanClass, propertyName, keyType, valueType)); }
	 * 
	 * public IBeanMapProperty map(IBeanMapProperty property) { return new
	 * BeanMapPropertyDecorator(super.map(property),
	 * property.getPropertyDescriptor()); }
	 */

	@SuppressWarnings("null")
	@Override
	public IObservableValue observe(Object source) {
		return new FXBeanObservableValueDecorator(this.delegate.observe(source), this.propertyDescriptor);
	}

	@SuppressWarnings("null")
	@Override
	public IObservableValue observe(Realm realm, Object source) {
		return new FXBeanObservableValueDecorator(this.delegate.observe(realm, source), this.propertyDescriptor);
	}

	@SuppressWarnings("null")
	@Override
	public IObservableValue observeDetail(IObservableValue master) {
		return new FXBeanObservableValueDecorator(this.delegate.observeDetail(master), this.propertyDescriptor);
	}

	/*
	 * public IObservableList observeDetail(IObservableList master) { return new
	 * FXBeanObservableListDecorator(delegate.observeDetail(master),
	 * propertyDescriptor); }
	 * 
	 * public IObservableMap observeDetail(IObservableSet master) { return new
	 * FXBeanObservableMapDecorator(delegate.observeDetail(master),
	 * propertyDescriptor); }
	 * 
	 * public IObservableMap observeDetail(IObservableMap master) { return new
	 * FXBeanObservableMapDecorator(delegate.observeDetail(master),
	 * propertyDescriptor); }
	 */

	@Override
	public String toString() {
		return this.delegate.toString();
	}
}

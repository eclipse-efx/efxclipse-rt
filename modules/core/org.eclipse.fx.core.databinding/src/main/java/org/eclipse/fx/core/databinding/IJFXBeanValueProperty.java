/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
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
package org.eclipse.fx.core.databinding;

import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Single valued property
 */
public interface IJFXBeanValueProperty extends IJFXBeanProperty, IValueProperty {
	/**
	 * Create a child property without a type
	 * 
	 * @param propertyName
	 *            the name
	 * @return child property
	 */
	public @NonNull IJFXBeanValueProperty value(@NonNull String propertyName);

	/**
	 * Create a child property with a type
	 * 
	 * @param propertyName
	 *            the name
	 * @param valueType
	 *            the type
	 * @return child property
	 */
	public @NonNull IJFXBeanValueProperty value(@NonNull String propertyName, Class<?> valueType);

	/**
	 * Create a child property from a property
	 * 
	 * @param property
	 *            the property
	 * @return the child property
	 */
	public @NonNull IJFXBeanValueProperty value(@NonNull IJFXBeanValueProperty property);
}

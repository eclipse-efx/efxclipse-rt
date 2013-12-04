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

import org.eclipse.core.databinding.property.value.IValueProperty;

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
	public IJFXBeanValueProperty value(String propertyName);

	/**
	 * Create a child property with a type
	 * 
	 * @param propertyName
	 *            the name
	 * @param valueType
	 *            the type
	 * @return child property
	 */
	public IJFXBeanValueProperty value(String propertyName, Class<?> valueType);

	/**
	 * Create a child property from a property
	 * 
	 * @param property
	 *            the property
	 * @return the child property
	 */
	public IJFXBeanValueProperty value(IJFXBeanValueProperty property);
}

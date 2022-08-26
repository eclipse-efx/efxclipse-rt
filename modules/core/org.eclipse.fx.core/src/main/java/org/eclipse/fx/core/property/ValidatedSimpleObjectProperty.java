/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
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
package org.eclipse.fx.core.property;

import javafx.beans.property.ObjectProperty;

/**
 * A validated property using {@link ObjectProperty}
 *
 * @param <T>
 *            the type of the wrapped object
 * @since 2.4.0
 */
public class ValidatedSimpleObjectProperty<T> extends ValidatedPropertyBase<T> implements ValidatedObjectProperty<T> {
	/**
	 * Create a new wrapper
	 *
	 * @param domainProperty
	 *            the domain property
	 */
	public ValidatedSimpleObjectProperty(ObjectProperty<T> domainProperty) {
		super(domainProperty);
	}

	@Override
	public ObjectProperty<T> bindProperty() {
		return (ObjectProperty<T>) this.domainProperty;
	}
}

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

import javafx.beans.property.IntegerProperty;

/**
 * A validated property using {@link IntegerProperty}
 *
 * @since 2.4.0
 */
public class ValidatedSimpleIntegerProperty extends ValidatedPropertyBase<Number> implements ValidatedIntegerProperty {
	/**
	 * Create a new wrapper
	 *
	 * @param domainProperty
	 *            the domain property
	 */
	public ValidatedSimpleIntegerProperty(IntegerProperty domainProperty) {
		super(domainProperty);
	}

	@Override
	public IntegerProperty bindProperty() {
		return (IntegerProperty) this.domainProperty;
	}
}
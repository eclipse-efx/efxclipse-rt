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

import javafx.beans.property.StringProperty;

/**
 * A validated property using {@link StringProperty}
 *
 * @since 2.4.0
 */
public class ValidatedSimpleStringProperty extends ValidatedPropertyBase<String> implements ValidatedStringProperty {
	/**
	 * Create a new wrapper
	 *
	 * @param domainProperty
	 *            the domain property
	 */
	public ValidatedSimpleStringProperty(StringProperty domainProperty) {
		super(domainProperty);
	}

	@Override
	public StringProperty bindProperty() {
		return (StringProperty) this.domainProperty;
	}
}

/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;

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
	public LongProperty bindProperty() {
		return (LongProperty) this.domainProperty;
	}
}
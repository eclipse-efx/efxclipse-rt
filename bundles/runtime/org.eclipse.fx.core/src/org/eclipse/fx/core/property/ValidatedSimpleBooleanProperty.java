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

import javafx.beans.property.BooleanProperty;

/**
 * A validated property using {@link BooleanProperty}
 *
 * @since 2.4.0
 */
public class ValidatedSimpleBooleanProperty extends ValidatedPropertyBase<Boolean> implements ValidatedBooleanProperty {
	/**
	 * Create a new wrapper
	 *
	 * @param domainProperty
	 *            the domain property
	 */
	public ValidatedSimpleBooleanProperty(BooleanProperty domainProperty) {
		super(domainProperty);
	}

	@Override
	public BooleanProperty bindProperty() {
		return (BooleanProperty) this.domainProperty;
	}
}
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

import javafx.beans.property.SetProperty;
import javafx.collections.ObservableSet;

/**
 * A validated property using {@link SetProperty}
 *
 * @param <E>
 *            the set type
 * @since 2.4.0
 */
public class ValidatedSimpleSetProperty<E> extends ValidatedPropertyBase<ObservableSet<E>>
		implements ValidatedSetProperty<E> {
	/**
	 * Create a new wrapper
	 *
	 * @param domainProperty
	 *            the domain property
	 */
	public ValidatedSimpleSetProperty(SetProperty<E> domainProperty) {
		super(domainProperty);
	}

	@Override
	public SetProperty<E> bindProperty() {
		return (SetProperty<E>) this.domainProperty;
	}
}

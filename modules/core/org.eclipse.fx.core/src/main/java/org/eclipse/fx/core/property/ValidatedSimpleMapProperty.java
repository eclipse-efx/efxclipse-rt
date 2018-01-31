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

import javafx.beans.property.MapProperty;
import javafx.collections.ObservableMap;

/**
 * A validated property using {@link MapProperty}
 *
 * @param <K>
 *            the key type
 * @param <V>
 *            the value type
 * @since 2.4.0
 */
public class ValidatedSimpleMapProperty<K, V> extends ValidatedPropertyBase<ObservableMap<K, V>>
		implements ValidatedMapProperty<K, V> {
	/**
	 * Create a new wrapper
	 *
	 * @param domainProperty
	 *            the domain property
	 */
	public ValidatedSimpleMapProperty(MapProperty<K, V> domainProperty) {
		super(domainProperty);
	}

	@SuppressWarnings("unchecked")
	@Override
	public MapProperty<K, V> bindProperty() {
		return (MapProperty<K, V>) this.domainProperty;
	}
}

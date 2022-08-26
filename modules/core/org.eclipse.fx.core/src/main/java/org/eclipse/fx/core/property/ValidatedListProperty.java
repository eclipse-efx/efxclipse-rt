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

import javafx.beans.property.ListProperty;
import javafx.collections.ObservableList;

/**
 * A validated property using {@link ListProperty}
 *
 * @param <E>
 *            the set type
 * @since 2.4.0
 */
public interface ValidatedListProperty<E> extends ValidatedProperty<ObservableList<E>> {
	@Override
	public ListProperty<E> bindProperty();
}

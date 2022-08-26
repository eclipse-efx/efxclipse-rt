/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
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
package org.eclipse.fx.core.collection;

import org.eclipse.jdt.annotation.Nullable;

import javafx.beans.value.ObservableLongValue;
import javafx.beans.value.ObservableObjectValue;

/**
 * View of an index
 * 
 * @param <T>
 *            the type
 */
public interface IndexView<@Nullable T> extends ObservableObjectValue<T>, View<T> {
	/**
	 * @return the index
	 */
	public ObservableLongValue index();
}

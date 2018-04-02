/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

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

import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableLongValue;
import javafx.collections.ObservableList;

/**
 * View of an index range
 * 
 * @param <T>
 *            the element type
 */
public interface IndexRangeView<@Nullable T> extends ObservableList<T>, View<T> {
	/**
	 * @return the start index
	 */
	public ObservableLongValue startIndex();

	/**
	 * @return the end index
	 */
	public ObservableLongValue endIndex();

	/**
	 * @return the length
	 */
	public ObservableIntegerValue length();

	/**
	 * Shrink the view by the given delta
	 * 
	 * @param delta
	 *            the delta
	 */
	public void shrinkBy(int delta);

	/**
	 * Graw the view by the given delta
	 * 
	 * @param delta
	 *            the delta
	 */
	public void growBy(int delta);
}

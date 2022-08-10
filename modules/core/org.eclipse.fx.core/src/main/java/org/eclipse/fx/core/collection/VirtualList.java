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

import java.util.OptionalLong;

import org.eclipse.fx.core.collection.internal.VirtualObservableList;
import org.eclipse.jdt.annotation.Nullable;

import javafx.beans.value.ObservableLongValue;
import javafx.collections.ObservableList;

/**
 * Interface for a list who is completely virtual
 * 
 * @param <T> the type
 */
public interface VirtualList<@Nullable T> {
	/**
	 * @return the length
	 */
	public ObservableLongValue length();

	/**
	 * Get the value at the current index
	 * 
	 * @param index the index
	 * @return the value the value
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *                                   (<tt>index &lt; 0 || index &gt;= size()</tt>)
	 */
	public T get(long index);

	/**
	 * Get an observable view for the given index
	 * 
	 * @param index the index (might even be larger than current length)
	 * @return an observable view
	 */
	public IndexView<T> getView(long index);

	/**
	 * Get an observable view for an index range
	 * 
	 * @param startIndex the start index
	 * @param length     the length
	 * @return the index range
	 */
	public IndexRangeView<T> getView(long startIndex, int length);

	/**
	 * Get the index of the provided object
	 * 
	 * @param o the index
	 * @return optional with index or <code>empty optional</code>
	 */
	public default OptionalLong index(T o) {
		IndexRangeView<T> range = getView(0L, (int) length().get());
		int idx = range.indexOf(o);
		return idx == -1 ? OptionalLong.empty() : OptionalLong.of(idx);
	}

	/**
	 * Create a {@link VirtualList} from an {@link ObservableList}
	 * 
	 * @param list the source list
	 * @return the virtual list
	 */
	public static <@Nullable T> VirtualList<T> of(ObservableList<T> list) {
		return new VirtualObservableList<>(list);
	}
}

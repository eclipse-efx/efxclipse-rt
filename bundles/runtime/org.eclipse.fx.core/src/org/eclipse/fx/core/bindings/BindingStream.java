/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Caks<ccaks@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.bindings;

import java.util.function.Function;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.value.ObservableValue;

/**
 * allows chaining of binding operations
 *
 * @param <T>
 */
public interface BindingStream<T> {

	/**
	 * applies a mapping function to another observable value.
	 *
	 * @param map
	 * @return the {@link BindingStream}
	 */
	<S> BindingStream<S> map(Function<T, ObservableValue<S>> map);

	/**
	 * applies a mapping function to a non observable value.
	 * changes won't be tracked!
	 * @param map
	 * @return the {@link BindingStream}
	 */
	<S> BindingStream<S> mapNoObservalbe(Function<T, S> map);

	/**
	 * creates the {@link ObjectBinding}
	 * @return the binding
	 */
	ObjectBinding<T> toBinding();

}

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
 *     Christoph Caks<ccaks@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.bindings;

import java.util.function.Function;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

/**
 * allows chaining of binding operations
 *
 * @param <T> the stream type
 *
 * @since 3.0
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
	<S> BindingStream<S> mapNoObservable(Function<T, S> map);

	/**
	 * creates the {@link ObjectBinding}
	 * @return the binding
	 */
	@Deprecated
	ObjectBinding<T> toBinding();

	@Deprecated
	<S> Property<S> toProperty(Function<T, Property<S>> map);
	@Deprecated
	<S> ObjectProperty<S> toObjectProperty(Function<T, ObjectProperty<S>> map);
	@Deprecated
	StringProperty toStringProperty(Function<T, StringProperty> map);
	@Deprecated
	DoubleProperty toDoubleProperty(Function<T, DoubleProperty> map);
	@Deprecated
	BooleanProperty toBooleanProperty(Function<T, BooleanProperty> map);
	@Deprecated
	FloatProperty toFloatProperty(Function<T, FloatProperty> map);
	@Deprecated
	LongProperty toLongProperty(Function<T, LongProperty> map);
	@Deprecated
	IntegerProperty toIntegerProperty(Function<T, IntegerProperty> map);

	/**
	 * Collect the stream
	 * @param collector
	 * @return the terminal type
	 */
	<R> R collect(FXCollector<T,R> collector);
}

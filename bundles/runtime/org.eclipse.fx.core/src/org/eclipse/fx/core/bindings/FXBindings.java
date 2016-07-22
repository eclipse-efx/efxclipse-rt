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

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.core.bindings.internal.ConcatListBinding;
import org.eclipse.fx.core.bindings.internal.FlatMapListBinding;
import org.eclipse.fx.core.bindings.internal.FlatMapValueListBinding;
import org.eclipse.fx.core.bindings.internal.MapListBinding;
import org.eclipse.fx.core.bindings.internal.SyncListBinding;
import org.eclipse.fx.core.bindings.internal.SyncObjectBinding;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ListBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;

/**
 * Collection of JavaFX bean bindings.
 * @author ccaks
 * @since 3.0.0
 *
 */
public class FXBindings {

	/**
	 * Concatenates multiple observable lists together.
	 * @param sources
	 * @return
	 */
	public static <A> ListBinding<A> concat(ObservableList<A>... sources) {
		return new ConcatListBinding<>(sources);
	}

	/**
	 * Maps an obserbable list
	 * @param source
	 * @param map
	 * @return
	 */
	public static <A, B> ListBinding<B> map(ObservableList<A> source, Function<A, B> map) {
		return new MapListBinding(source, map);
	}

	/**
	 * Flat maps an observable list with observable lists
	 * @param source
	 * @param map
	 * @return
	 */
	public static <A, B> ListBinding<B> flatMapList(ObservableList<A> source, Function<A, ObservableList<B>> map) {
		return new FlatMapListBinding<A, B>(source, map);
	}

	/**
	 * Flat maps an observable list with observable values
	 * @param source
	 * @param map
	 * @return
	 */
	public static <A, B> ListBinding<B> flatMapValue(ObservableList<A> source, Function<A, ObservableValue<B>> map) {
		return new FlatMapValueListBinding<>(source, map);
	}

	/**
	 * allows to sync between threads
	 * @param source
	 * @param thread
	 * @return
	 */
	public static <A> ListBinding<A> syncList(ObservableList<A> source, ThreadSynchronize thread) {
		return new SyncListBinding<>(source, thread);
	}

	/**
	 * allows to sync between threads
	 * @param source
	 * @param thread
	 * @return
	 */
	public static <A> ObjectBinding<A> syncValue(ObservableValue<A> source, ThreadSynchronize thread) {
		return new SyncObjectBinding<>(source, thread);
	}

}

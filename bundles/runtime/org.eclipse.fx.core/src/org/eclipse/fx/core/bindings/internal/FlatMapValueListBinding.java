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
package org.eclipse.fx.core.bindings.internal;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.ListBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FlatMapValueListBinding<A, B> extends ListBinding<B> {

	private Set<ObservableValue<?>> cur = new HashSet<>();

	private ObservableList<A> source;
	private Function<A, ObservableValue<B>> map;

	private InvalidationListener onInvalidate = obs -> this.invalidate();

	public FlatMapValueListBinding(ObservableList<A> list, Function<A, ObservableValue<B>> map) {
		this.source = list;
		this.map = map;
		this.source.addListener(this.onInvalidate);
		this.fixListener();
	}

	private void fixListener() {
		Set<ObservableValue<?>> toWatch = this.source.stream().map(this.map).collect(Collectors.toSet());
		Set<ObservableValue<?>> toDispose = new HashSet<>(this.cur); toDispose.removeIf(x->toWatch.stream().anyMatch(c->System.identityHashCode(c) == System.identityHashCode(x)));
		Set<ObservableValue<?>> toAdd = new HashSet<>(toWatch); toAdd.removeIf(x->this.cur.stream().anyMatch(c->System.identityHashCode(c) == System.identityHashCode(x)));

		for (ObservableValue<?> d : toDispose) {
			d.removeListener(this.onInvalidate);

		}
		for (ObservableValue<?> a : toAdd) {
			a.addListener(this.onInvalidate);
		}

		this.cur = toWatch;
	}

	@Override
	protected ObservableList<B> computeValue() {
		this.fixListener();
		return FXCollections.observableList(this.source.stream().map(this.map).map(v->v.getValue()).collect(Collectors.toList()));
	}

	@Override
	public void dispose() {
		super.dispose();

		for (ObservableValue<?> d : this.cur) {
			d.removeListener(this.onInvalidate);
		}

		this.source.removeListener(this.onInvalidate);
	}
}
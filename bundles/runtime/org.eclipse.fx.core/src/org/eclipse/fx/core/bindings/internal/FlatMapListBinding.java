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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@SuppressWarnings("javadoc")
public class FlatMapListBinding<A, B> extends ListBinding<B> {

	private Set<ObservableList<?>> cur = new HashSet<>();

	private ObservableList<A> source;
	private Function<A, ObservableList<B>> map;

	private InvalidationListener onInvalidate = obs -> this.invalidate();


	public FlatMapListBinding(ObservableList<A> source, Function<A, ObservableList<B>> map) {
		this.source = source;
		this.map = map;
		this.source.addListener(this.onInvalidate);
		this.fixListener();
	}

	private void fixListener() {
		Set<ObservableList<?>> toWatch = this.source.stream().map(this.map).collect(Collectors.toSet());
		Set<ObservableList<?>> toDispose = new HashSet<>(this.cur); toDispose.removeIf(x->toWatch.stream().anyMatch(c->System.identityHashCode(c) == System.identityHashCode(x)));
		Set<ObservableList<?>> toAdd = new HashSet<>(toWatch); toAdd.removeIf(x->this.cur.stream().anyMatch(c->System.identityHashCode(c) == System.identityHashCode(x)));

		for (ObservableList<?> d : toDispose) {
			d.removeListener(this.onInvalidate);

		}
		for (ObservableList<?> a : toAdd) {
			a.addListener(this.onInvalidate);
		}

		this.cur = toWatch;
	}


	@Override
	protected ObservableList<B> computeValue() {
		this.fixListener();
		return FXCollections.observableList(this.source.stream().map(this.map).flatMap(o->o.stream()).collect(Collectors.toList()));
	}

	@Override
	public void dispose() {
		super.dispose();

		for (ObservableList<?> d : this.cur) {
			d.removeListener(this.onInvalidate);
		}

		this.source.removeListener(this.onInvalidate);
	}
}
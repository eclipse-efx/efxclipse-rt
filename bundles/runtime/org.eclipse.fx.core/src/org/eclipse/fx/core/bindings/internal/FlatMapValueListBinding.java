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

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javafx.beans.Observable;
import javafx.beans.binding.ListBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@SuppressWarnings("javadoc")
public class FlatMapValueListBinding<A, B> extends ListBinding<B> {

	private Observable[] currentDependencies;

	private ObservableList<A> source;
	private Function<A, ObservableValue<B>> map;

	public FlatMapValueListBinding(ObservableList<A> list, Function<A, ObservableValue<B>> map) {
		this.source = list;
		this.map = map;
		this.updateDependencies();
	}

	private Observable[] computeDependencies() {
		Set<Observable> toWatch = this.source.stream().map(this.map).collect(Collectors.toSet());
		toWatch.add(this.source);
		return toWatch.toArray(new Observable[0]);
	}

	private void updateDependencies() {
		if (this.currentDependencies != null) {
			unbind(this.currentDependencies);
		}
		this.currentDependencies = computeDependencies();
		bind(this.currentDependencies);
	}


	@Override
	protected ObservableList<B> computeValue() {
		this.updateDependencies();
		return FXCollections.observableList(this.source.stream().map(this.map).map(v->v.getValue()).collect(Collectors.toList()));
	}

	@Override
	public void dispose() {
		if (this.currentDependencies != null) {
			unbind(this.currentDependencies);
			this.currentDependencies = null;
		}
		super.dispose();
	}
}
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
package org.eclipse.fx.core.bindings.internal;

import java.util.function.Function;
import java.util.stream.Collectors;

import javafx.beans.binding.ListBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@SuppressWarnings("javadoc")
public class MapListBinding<A, B> extends ListBinding<B> {

	private ObservableList<A> source;
	private Function<A, B> map;

	public MapListBinding(ObservableList<A> source, Function<A, B> map) {
		this.source = source;
		this.map = map;
		bind(this.source);
	}

	@Override
	protected ObservableList<B> computeValue() {
		return FXCollections.observableArrayList(this.source.stream().map(this.map).collect(Collectors.toList()));
	}

	@Override
	public void dispose() {
		unbind(this.source);
		super.dispose();
	}
}
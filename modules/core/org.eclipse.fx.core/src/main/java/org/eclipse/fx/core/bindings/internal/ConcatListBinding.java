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

import java.util.Arrays;
import java.util.stream.Collectors;

import javafx.beans.binding.ListBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


@SuppressWarnings("javadoc")
public class ConcatListBinding<A> extends ListBinding<A> {

	private ObservableList<A>[] source;

	@SuppressWarnings("unchecked")
	public ConcatListBinding(ObservableList<? extends A>... source) {
		this.source = Arrays.stream(source).map(e -> (ObservableList<A>) e).collect(Collectors.toList())
				.toArray(new ObservableList[0]);
		bind(this.source);
	}

	@Override
	protected ObservableList<A> computeValue() {
		return FXCollections.concat(this.source);
	}

	@Override
	public void dispose() {
		unbind(this.source);
		super.dispose();
	}

}
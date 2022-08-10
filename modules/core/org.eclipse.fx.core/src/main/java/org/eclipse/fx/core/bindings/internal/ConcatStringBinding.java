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
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.bindings.internal;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.beans.binding.StringBinding;
import javafx.beans.value.ObservableValue;

@SuppressWarnings("javadoc")
public class ConcatStringBinding<T> extends StringBinding {
	private final String delimiter;
	private final ObservableValue<T>[] sources;

	@SafeVarargs
	public ConcatStringBinding(String delimiter, ObservableValue<T>... sources) {
		this.delimiter = delimiter;
		this.sources = sources;
		bind(sources);
	}

	@Override
	protected String computeValue() {
		return Stream.of(this.sources)
					.map( s -> s.getValue())
					.map( v -> v == null ? "" : v.toString()) //$NON-NLS-1$
					.filter( v -> ! v.isEmpty())
					.collect(Collectors.joining(this.delimiter));
	}
}

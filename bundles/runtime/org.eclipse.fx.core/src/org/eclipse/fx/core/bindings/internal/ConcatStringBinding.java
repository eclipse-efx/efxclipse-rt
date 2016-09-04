/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
					.filter( v -> v.toString().isEmpty())
					.collect(Collectors.joining(this.delimiter));
	}
}

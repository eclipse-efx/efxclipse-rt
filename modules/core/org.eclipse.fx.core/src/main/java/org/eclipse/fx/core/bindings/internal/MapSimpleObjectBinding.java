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

import javafx.beans.Observable;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.value.ObservableValue;

@SuppressWarnings("javadoc")
public class MapSimpleObjectBinding<A, B> extends ObjectBinding<B> {

	private ObservableValue<A> source;
	private Function<A, B> map;

	private Observable next = null;

	public MapSimpleObjectBinding(ObservableValue<A> source, Function<A, B> map) {
		this.source = source;
		this.map = map;
		bind(this.source);
	}


	@SuppressWarnings("null")
	@Override
	protected B computeValue() {
		if (this.next != null) {
			unbind(this.next);
		}
		A sourceVal = this.source.getValue();
		if (sourceVal != null) {
			B apply = this.map.apply(sourceVal);
			return apply;
		}
		else {
			return (B) null;
		}
	}

	@Override
	public void dispose() {
		unbind(this.source);
		super.dispose();
	}
}
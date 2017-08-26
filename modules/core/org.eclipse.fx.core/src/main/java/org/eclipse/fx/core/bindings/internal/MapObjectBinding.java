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

import java.util.function.Function;

import javafx.beans.Observable;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.value.ObservableValue;

@SuppressWarnings("javadoc")
public class MapObjectBinding<A, B> extends ObjectBinding<B> {

	private ObservableValue<A> source;
	private Function<A, ObservableValue<B>> map;

	private Observable next = null;

	public MapObjectBinding(ObservableValue<A> source, Function<A, ObservableValue<B>> map) {
		this.source = source;
		this.map = map;
		bind(this.source);
	}

	@SuppressWarnings("null")
	@Override
	protected B computeValue() {
		clearNextReference();
		A sourceVal = this.source.getValue();
		if (sourceVal != null) {
			ObservableValue<B> apply = this.map.apply(sourceVal);
			this.next = apply;
			bind(this.next);
			return apply.getValue();
		} else {
			return (B) null;
		}
	}

	private void clearNextReference() {
		if (this.next != null) {
			unbind(this.next);
			this.next = null;
		}
	}

	@Override
	protected void onInvalidating() {
		clearNextReference();
	}

	@Override
	public void dispose() {
		clearNextReference();
		unbind(this.source);
		super.dispose();
	}
}
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

import org.eclipse.jdt.annotation.Nullable;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;

@SuppressWarnings("javadoc")
public class TenaryBinding<T> extends ObjectBinding<T> {
	private final ObservableBooleanValue condition;
	@Nullable
	private final ObservableValue<T> obsThen;
	@Nullable
	private final ObservableValue<T> _obsElse;

	@Nullable
	private final T then;
	@Nullable
	private final T _else;

	public TenaryBinding(ObservableBooleanValue condition, ObservableValue<T> then, ObservableValue<T> _else) {
		this.condition = condition;
		this.then = null;
		this._else = null;
		this._obsElse = _else;
		this.obsThen = then;
		bind(condition, then, _else);
	}

	public TenaryBinding(ObservableBooleanValue condition, T then, T _else) {
		this.condition = condition;
		this.obsThen = null;
		this._obsElse = null;
		this.then = then;
		this._else = _else;
		bind(condition);
	}

	@Override
	protected T computeValue() {
		ObservableValue<T> obsThen = this.obsThen;
		ObservableValue<T> _obsElse = this._obsElse;
		return this.condition.get() ? (obsThen == null ? this.then : obsThen.getValue())
				: (_obsElse == null ? this._else : _obsElse.getValue());
	}
}

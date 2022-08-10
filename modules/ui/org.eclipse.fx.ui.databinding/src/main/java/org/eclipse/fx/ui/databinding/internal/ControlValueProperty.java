/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
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
package org.eclipse.fx.ui.databinding.internal;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.SimpleValueProperty;
import org.eclipse.fx.ui.databinding.IJFXControlValueObservable;
import org.eclipse.fx.ui.databinding.IJFXControlValueProperty;
import org.eclipse.jdt.annotation.NonNull;

import javafx.scene.Node;

@SuppressWarnings("javadoc")
public abstract class ControlValueProperty<S, T> extends SimpleValueProperty<S, T>
		implements IJFXControlValueProperty<S, T> {

	@Override
	public IJFXControlValueObservable<T> observeDelayed(int delay, S control) {
		IObservableValue<T> v = Observables.observeDelayedValue(delay, observe(control));
		return new ControlDelayedObservableValueDecorator<>(v, (Node) control);
	}

	// ---

	@Override
	public @NonNull IJFXControlValueObservable<T> observe(S control) {
		IObservableValue<T> v = super.observe(Realm.getDefault(), control);
		return new ControlObservableValueDecorator<>(v);
	}

	// ---

	@Override
	public IJFXControlValueObservable<T> observe(Realm realm, S control) {
		IObservableValue<T> v = super.observe(realm, control);
		return new ControlObservableValueDecorator<>(v);
	}

}

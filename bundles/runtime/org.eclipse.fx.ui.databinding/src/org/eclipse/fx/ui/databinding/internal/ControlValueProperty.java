/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.databinding.internal;

import javafx.scene.Node;
import javafx.scene.control.Control;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.SimpleValueProperty;
import org.eclipse.fx.ui.databinding.IJFXControlValueObservable;
import org.eclipse.fx.ui.databinding.IJFXControlValueProperty;
import org.eclipse.jdt.annotation.NonNull;

/**
 *
 */
public abstract class ControlValueProperty extends SimpleValueProperty implements IJFXControlValueProperty {

	@Override
	public IJFXControlValueObservable observeDelayed(int delay, Control control) {
		IObservableValue v = observe(control);
		return new ControlDelayedObservableValueDecorator(Observables.observeDelayedValue(delay, v), control);
	}

	@Override
	public IJFXControlValueObservable observeDelayed(int delay, @NonNull Node control) {
		IObservableValue v = observe(control);
		return new ControlDelayedObservableValueDecorator(Observables.observeDelayedValue(delay, v), control);
	}

	// ---

	@Override
	public IJFXControlValueObservable observe(Control control) {
		IObservableValue v = super.observe(Realm.getDefault(), control);
		return new ControlObservableValueDecorator(v);
	}

	@Override
	public @NonNull IJFXControlValueObservable observe(@NonNull Node control) {
		IObservableValue v = super.observe(Realm.getDefault(), control);
		return new ControlObservableValueDecorator(v);
	}

	// ---

	@Override
	public IJFXControlValueObservable observe(Realm realm, Control control) {
		IObservableValue v = super.observe(realm, control);
		return new ControlObservableValueDecorator(v);
	}

	@Override
	public IJFXControlValueObservable observe(@NonNull Realm realm, @NonNull Node control) {
		IObservableValue v = super.observe(realm, control);
		return new ControlObservableValueDecorator(v);
	}

	@Override
	public IJFXControlValueObservable observe(Realm realm, Object source) {
		if( realm == null ) {
			throw new IllegalArgumentException("Realm can not be null"); //$NON-NLS-1$
		}
		if( source == null ) {
			throw new IllegalArgumentException("Source can not be null"); //$NON-NLS-1$
		}
		return observe(realm, (Control)source);
	}

	@Override
	public IJFXControlValueObservable observe(Object source) {
		if( source == null ) {
			throw new IllegalArgumentException("Source can not be null"); //$NON-NLS-1$
		}
		return observe((Control)source);
	}
}

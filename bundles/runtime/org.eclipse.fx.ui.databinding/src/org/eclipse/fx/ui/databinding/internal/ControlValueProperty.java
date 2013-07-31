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

import javafx.scene.control.Control;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.SimpleValueProperty;
import org.eclipse.fx.core.databinding.JFXRealm;
import org.eclipse.fx.ui.databinding.IJFXControlValueObservable;
import org.eclipse.fx.ui.databinding.IJFXControlValueProperty;

public abstract class ControlValueProperty extends SimpleValueProperty implements IJFXControlValueProperty {

	@Override
	public IJFXControlValueObservable observeDelayed(int delay, Control control) {
		IObservableValue v = observe(control);
		return new ControlObservableValueDecorator(Observables.observeDelayedValue(delay, v));
	}
	
	@Override
	public IJFXControlValueObservable observe(Control control) {
		IObservableValue v = super.observe(JFXRealm.getDefault(), control);
		return new ControlObservableValueDecorator(v);
	}

	@Override
	public IJFXControlValueObservable observe(Realm realm, Control control) {
		IObservableValue v = super.observe(realm, control);
		return new ControlObservableValueDecorator(v);
	}
	
	@Override
	public IJFXControlValueObservable observe(Realm realm, Object source) {
		return observe(realm, (Control)source);
	}
	
	@Override
	public IJFXControlValueObservable observe(Object source) {
		return observe((Control)source);
	}
}

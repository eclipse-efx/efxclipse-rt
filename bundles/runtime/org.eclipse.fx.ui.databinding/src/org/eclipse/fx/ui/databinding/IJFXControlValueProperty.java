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
package org.eclipse.fx.ui.databinding;

import javafx.scene.control.Control;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.property.value.IValueProperty;

public interface IJFXControlValueProperty extends IValueProperty {
	public IJFXControlValueObservable observe(Control control);
	public IJFXControlValueObservable observe(Realm realm, Control control);
	public IJFXControlValueObservable observeDelayed(int delay, Control control);
}

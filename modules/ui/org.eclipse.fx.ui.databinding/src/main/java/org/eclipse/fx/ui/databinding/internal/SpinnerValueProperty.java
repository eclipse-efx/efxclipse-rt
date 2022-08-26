/*******************************************************************************
 * Copyright (c) 2019 vogella GmbH and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Simon Scholz <simon.scholz@vogella.com> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.databinding.internal;

import org.eclipse.jdt.annotation.NonNull;

import javafx.beans.property.ReadOnlyProperty;
import javafx.scene.control.Spinner;

@SuppressWarnings("javadoc")
public class SpinnerValueProperty<@NonNull S,T> extends ControlReadOnlyPropertyValueProperty<S,T> {

	@Override
	public Object getValueType() {
		return null;
	}

	@SuppressWarnings({ "null", "unchecked" })
	@Override
	protected ReadOnlyProperty<T> getProperty(S source) {
		if( source instanceof Spinner ) {
			return ((Spinner<T>) source).valueProperty();
		}
		throw new IllegalArgumentException("Unable to get Spinner-Property from " + source); //$NON-NLS-1$
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doSetValue(S source, T value) {
		if( source instanceof Spinner ) {
			((Spinner<T>) source).getValueFactory().setValue(value);
			return;
		}
		throw new IllegalArgumentException("Unable to set "+ value +" on " + source); //$NON-NLS-1$ //$NON-NLS-2$
	}
}

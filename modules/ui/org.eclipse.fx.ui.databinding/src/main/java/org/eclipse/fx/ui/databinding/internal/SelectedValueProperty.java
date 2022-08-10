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

import javafx.beans.property.BooleanProperty;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ToggleButton;

@SuppressWarnings("javadoc")
public class SelectedValueProperty<S> extends ControlPropertyValueProperty<S, Boolean> {

	@Override
	public Object getValueType() {
		return Boolean.class;
	}

	@SuppressWarnings("null")
	@Override
	protected @NonNull BooleanProperty getProperty(S source) {
		if( source instanceof CheckBox ) {
			return ((CheckBox) source).selectedProperty();
		} else if (source instanceof ToggleButton) {
			return ((ToggleButton) source).selectedProperty();
		} else if (source instanceof CheckMenuItem) {
			return ((CheckMenuItem) source).selectedProperty();
		}
		throw new IllegalArgumentException("Unable to get Selected-Property from " + source); //$NON-NLS-1$
	}
}

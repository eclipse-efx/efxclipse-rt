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

import javafx.beans.property.Property;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

@SuppressWarnings("javadoc")
public class ColorValueProperty<@NonNull S> extends ControlPropertyValueProperty<S,Color> {

	@Override
	public Object getValueType() {
		return Color.class;
	}

	@SuppressWarnings("null")
	@Override
	protected Property<Color> getProperty(S source) {
		if( source instanceof ColorPicker ) {
			return ((ColorPicker) source).valueProperty();
		}
		throw new IllegalArgumentException("Unable to get Color-Property from " + source); //$NON-NLS-1$
	}

}

/*******************************************************************************
 * Copyright (c) 2019 vogella GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

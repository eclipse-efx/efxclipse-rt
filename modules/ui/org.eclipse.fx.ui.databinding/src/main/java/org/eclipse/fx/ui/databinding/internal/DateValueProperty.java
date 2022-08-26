/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.databinding.internal;

import java.time.LocalDate;

import org.eclipse.jdt.annotation.NonNull;

import javafx.beans.property.Property;
import javafx.scene.control.DatePicker;

@SuppressWarnings("javadoc")
public class DateValueProperty<@NonNull S> extends ControlPropertyValueProperty<S,LocalDate> {

	@Override
	public Object getValueType() {
		return LocalDate.class;
	}

	@SuppressWarnings("null")
	@Override
	protected Property<LocalDate> getProperty(S source) {
		if( source instanceof DatePicker ) {
			return ((DatePicker) source).valueProperty();
		}
		throw new IllegalArgumentException("Unable to get Date-Property from " + source); //$NON-NLS-1$
	}

}

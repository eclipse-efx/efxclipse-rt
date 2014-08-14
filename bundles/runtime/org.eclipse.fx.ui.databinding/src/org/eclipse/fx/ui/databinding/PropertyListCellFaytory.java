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

import java.text.MessageFormat;

import javafx.scene.control.Cell;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.fx.ui.databinding.internal.TemplateTextOnlyPropertyListCell;
import org.eclipse.fx.ui.databinding.internal.TextOnlyPropertyListCell;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Factory for list cells
 * 
 * @param <O>
 *            the type
 */
public interface PropertyListCellFaytory<O> extends Callback<ListView<O>, ListCell<O>> {
	/**
	 * Create a factory who uses the given property as the cells text content
	 * 
	 * @param textProperty
	 *            the property
	 * @param <O>
	 *            the type
	 * @return a factory instance
	 * @see #textCell(IValueProperty)
	 */
	@NonNull
	public static <O> PropertyListCellFaytory<O> textFactory(@NonNull final IValueProperty textProperty) {
		return (param) -> textCell(textProperty);
	}

	/**
	 * Create a factory who uses the given properties and the template as cells
	 * text content
	 * 
	 * @param template
	 *            the template
	 * @param textProperties
	 *            the properties
	 * @param <O>
	 *            the type
	 * @return a factory instance
	 */
	@NonNull
	public static <O> PropertyListCellFaytory<O> textFactory(@NonNull final String template, @NonNull final IValueProperty... textProperties) {
		return (param) -> textCell(template, textProperties);
	}

	/**
	 * Create a text cell who sets the {@link Cell#textProperty()} to the
	 * property value
	 * 
	 * @param textProperty
	 *            the text property
	 * @param <O>
	 *            the type
	 * @return the list cell
	 */
	@NonNull
	public static <O> ListCell<O> textCell(@NonNull final IValueProperty textProperty) {
		return new TextOnlyPropertyListCell<>(textProperty);
	}

	/**
	 * Create a text cell who sets the {@link Cell#textProperty()} to the value
	 * of the properties formatted using the provided template using
	 * {@link MessageFormat}
	 * 
	 * @param template
	 *            the template
	 * @param textProperties
	 *            the properties
	 * @param <O>
	 *            the type
	 * @return the list cell
	 */
	@NonNull
	public static <O> ListCell<O> textCell(@NonNull String template, @NonNull IValueProperty... textProperties) {
		return new TemplateTextOnlyPropertyListCell<>(template, textProperties);
	}

}

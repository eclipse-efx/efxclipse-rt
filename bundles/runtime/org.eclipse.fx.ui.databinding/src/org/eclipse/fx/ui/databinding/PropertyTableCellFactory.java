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

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.fx.ui.databinding.internal.TemplateTextOnlyPropertyTableCell;
import org.eclipse.fx.ui.databinding.internal.TextOnlyPropertyTableCell;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Factory for table cells
 * 
 * @param <S>
 *            the row value type
 * @param <T>
 *            the cell value type
 */
public interface PropertyTableCellFactory<S, T> extends
		Callback<TableColumn<S, T>, TableCell<S, T>> {
	/**
	 * Create a factory who uses the given property for the text
	 * 
	 * @param property
	 *            the property
	 * @return the factory instance
	 * @see #textCell(IValueProperty)
	 */
	@NonNull
	public static <S, T> PropertyTableCellFactory<S, T> textFactory(
			@NonNull final IValueProperty property) {
		return (param) -> textCell(property);
	}

	/**
	 * Create a factory who uses the given properties and the template for the
	 * text using {@link MessageFormat}
	 * 
	 * @param template
	 *            the template
	 * @param property
	 *            the property
	 * @return the factory instance
	 * @see #textCell(String, IValueProperty...)
	 */
	@NonNull
	public static <S, T> PropertyTableCellFactory<S, T> textFactory(
			@NonNull final String template, @NonNull final IValueProperty... property) {
		return (param) -> textCell(template, property);
	}

	/**
	 * Create a table cell using the property for the text
	 * 
	 * @param property
	 *            the property
	 * @return the table cell
	 */
	@NonNull
	public static <S, T> TableCell<S, T> textCell(@NonNull IValueProperty property) {
		return new TextOnlyPropertyTableCell<>(property);
	}

	/**
	 * Create a table cell using the properties and the template for the text
	 * using {@link MessageFormat}
	 * 
	 * @param template
	 *            the template
	 * @param property
	 *            the property
	 * @return the table cell
	 */
	@NonNull 
	public static <S, T> TableCell<S, T> textCell(@NonNull String template,
			@NonNull IValueProperty... property) {
		return new TemplateTextOnlyPropertyTableCell<>(template, property);
	}
}

/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.databinding;

import java.text.MessageFormat;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Utility to setup a {@link TableView} with {@link TableColumn}
 */
public class TableUtil {
	/**
	 * Setup a table column using the property for the cell text
	 * 
	 * @param column
	 *            the column
	 * @param property
	 *            the property
	 * @param <S>
	 *            row and cell type
	 * @see PropertyTableCellFactory#textFactory(IValueProperty)
	 */
	public static <S> void setupColumn(@NonNull TableColumn<S, S> column, @NonNull IValueProperty property) {
		column.setCellValueFactory((param) -> new SimpleObjectProperty<S>(param.getValue()));
		column.setCellFactory(PropertyTableCellFactory.<S, S> textFactory(property));
	}

	/**
	 * Setup a table column using the properties and the template for the cell
	 * text using {@link MessageFormat}
	 * 
	 * @param column
	 *            the column
	 * @param template
	 *            the template
	 * @param property
	 *            the properties
	 * @param <S>
	 *            row and cell type
	 * @see PropertyTableCellFactory#textFactory(String, IValueProperty...)
	 */
	public static <S> void setupColumn(@NonNull TableColumn<S, S> column, @NonNull String template, @NonNull IValueProperty... property) {
		column.setCellValueFactory((param) -> new SimpleObjectProperty<S>(param.getValue()));
		column.setCellFactory(PropertyTableCellFactory.<S, S> textFactory(template, property));
	}
}

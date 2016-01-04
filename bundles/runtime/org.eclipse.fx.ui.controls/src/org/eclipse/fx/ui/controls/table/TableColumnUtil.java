/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.table;

import java.util.function.Function;

import org.eclipse.jdt.annotation.NonNull;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;

/**
 * A set of helpers to set up {@link TableColumn} instances
 *
 * @since 2.3.0
 */
public class TableColumnUtil {
	/**
	 * Create a column
	 *
	 * @param label
	 *            the label
	 * @param prefWidth
	 *            the preferred width
	 * @param valueExtractor
	 *            function to extract the value
	 * @return the column instance
	 */
	public static <S, T> TableColumn<S, T> createColumn(String label, double prefWidth, Function<S, T> valueExtractor) {
		TableColumn<S, T> c = new TableColumn<>();
		c.setText(label);
		c.setPrefWidth(prefWidth);
		c.setCellValueFactory(f -> new SimpleObjectProperty<>(valueExtractor.apply(f.getValue())));
		return c;
	}

	/**
	 * Setup a table column with the provided value extractor
	 *
	 * @param c
	 *            the column to configure
	 * @param valueExtractor
	 *            function to extract the value
	 * @return the column instance itself
	 */
	public static <S, T> TableColumn<S, T> setupColumn(TableColumn<S, T> c, Function<S, T> valueExtractor) {
		c.setCellValueFactory(f -> new SimpleObjectProperty<>(valueExtractor.apply(f.getValue())));
		return c;
	}

	/**
	 * Setup a table column with the provided value extractor
	 *
	 * @param c
	 *            the column to configure
	 * @param valueExtractor
	 *            function to extract the value
	 * @param labelConverter
	 *            the label converter
	 * @return the column instance itself
	 */
	public static <S, T> TableColumn<S, T> setupColumn(TableColumn<S, T> c, Function<S, T> valueExtractor, Function<T, @NonNull CharSequence> labelConverter) {
		c.setCellValueFactory(f -> new SimpleObjectProperty<>(valueExtractor.apply(f.getValue())));
		c.setCellFactory(cc -> new TableCell<S, T>() {
			@Override
			protected void updateItem(T item, boolean empty) {
				super.updateItem(item, empty);
				if (item == null || empty) {
					setText(""); //$NON-NLS-1$
					setGraphic(null);
				} else {
					setText(labelConverter.apply(item).toString());
				}
			}
		});
		return c;
	}
}

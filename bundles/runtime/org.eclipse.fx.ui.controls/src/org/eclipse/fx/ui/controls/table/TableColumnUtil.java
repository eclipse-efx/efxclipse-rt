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

import javafx.beans.property.SimpleObjectProperty;
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
}

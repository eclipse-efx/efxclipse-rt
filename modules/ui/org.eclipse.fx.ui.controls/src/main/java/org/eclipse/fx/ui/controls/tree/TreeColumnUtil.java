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
package org.eclipse.fx.ui.controls.tree;

import java.util.function.Function;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TreeTableColumn;

/**
 * Set of helpers to create {@link TreeTableColumn} instances
 */
public class TreeColumnUtil {
	/**
	 * Create a column
	 * 
	 * @param label
	 *            the label
	 * @param prefWidth
	 *            the preferred width
	 * @param valueExtractor
	 *            function to extract the cell value
	 * @return the column instance
	 */
	public static <S, T> TreeTableColumn<S, T> createColumn(String label, double prefWidth, Function<S, T> valueExtractor) {
		TreeTableColumn<S, T> c = new TreeTableColumn<>();
		c.setText(label);
		c.setPrefWidth(prefWidth);
		c.setCellValueFactory(f -> new SimpleObjectProperty<>(valueExtractor.apply(f.getValue().getValue())));
		return c;
	}
}

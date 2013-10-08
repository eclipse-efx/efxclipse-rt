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

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

import org.eclipse.core.databinding.property.value.IValueProperty;

public class TableUtil {
	public static <S> void setupColumn(TableColumn<S, S> column, IValueProperty property) {
		column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<S,S>, ObservableValue<S>>() {

			@Override
			public ObservableValue<S> call(CellDataFeatures<S, S> param) {
				return new SimpleObjectProperty<S>(param.getValue());
			}
		});
		column.setCellFactory(PropertyTableCellFactory.<S,S>textFactory(property));
	}
	
	public static <S> void setupColumn(TableColumn<S, S> column, String template, IValueProperty... property) {
		column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<S,S>, ObservableValue<S>>() {

			@Override
			public ObservableValue<S> call(CellDataFeatures<S, S> param) {
				return new SimpleObjectProperty<S>(param.getValue());
			}
		});
		column.setCellFactory(PropertyTableCellFactory.<S,S>textFactory(template,property));
	}
}

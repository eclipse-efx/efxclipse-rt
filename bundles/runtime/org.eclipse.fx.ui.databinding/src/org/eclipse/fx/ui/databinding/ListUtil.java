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

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.fx.core.databinding.AdapterFactory;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

/**
 * Utility to setup {@link ListView} and {@link ComboBox}
 */
public class ListUtil {
	/**
	 * Setup a list where cell text is bound to the given property
	 * 
	 * @param listView
	 *            the list view
	 * @param property
	 *            the text property
	 */
	public static <T> void setupList(ListView<T> listView, IValueProperty property) {
		listView.setCellFactory(PropertyListCellFaytory.<T> textFactory(property));
	}

	public static <T> void setupList(ListView<T> listView, String template, IValueProperty... properties) {
		listView.setCellFactory(PropertyListCellFaytory.<T> textFactory(template, properties));
	}

	public static <T> void setupComboBox(ComboBox<T> comboBox, IValueProperty property) {
		comboBox.setCellFactory(PropertyListCellFaytory.<T> textFactory(property));
		comboBox.setButtonCell(PropertyListCellFaytory.<T> textCell(property));
	}

	public static <T> void setupComboBox(ComboBox<T> comboBox, String template, IValueProperty... properties) {
		comboBox.setCellFactory(PropertyListCellFaytory.<T> textFactory(template, properties));
		comboBox.setButtonCell(PropertyListCellFaytory.<T> textCell(template, properties));
	}

	public static <T> void setupComboBox(IObservableList list, ComboBox<T> comboBox, IValueProperty property) {
		comboBox.setCellFactory(PropertyListCellFaytory.<T> textFactory(property));
		comboBox.setButtonCell(PropertyListCellFaytory.<T> textCell(property));
		comboBox.setItems(AdapterFactory.<T> adapt(list));
	}

	public static <T> void setupComboBox(IObservableList list, ComboBox<T> comboBox, String template, IValueProperty... properties) {
		comboBox.setCellFactory(PropertyListCellFaytory.<T> textFactory(template, properties));
		comboBox.setButtonCell(PropertyListCellFaytory.<T> textCell(template, properties));
		comboBox.setItems(AdapterFactory.<T> adapt(list));
	}
}

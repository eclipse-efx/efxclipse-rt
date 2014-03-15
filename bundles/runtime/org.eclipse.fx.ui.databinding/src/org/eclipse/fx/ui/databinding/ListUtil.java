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
	 * @see PropertyListCellFaytory#textFactory(IValueProperty)
	 */
	public static <T> void setupList(ListView<T> listView,
			IValueProperty property) {
		listView.setCellFactory(PropertyListCellFaytory
				.<T> textFactory(property));
	}

	/**
	 * Setup a list where the template is used to format the property values
	 * 
	 * @param listView
	 *            the list view
	 * @param template
	 *            the template to use
	 * @param properties
	 *            the properties to display
	 * @see PropertyListCellFaytory#textCell(String, IValueProperty...)
	 */
	public static <T> void setupList(ListView<T> listView, String template,
			IValueProperty... properties) {
		listView.setCellFactory(PropertyListCellFaytory.<T> textFactory(
				template, properties));
	}

	/**
	 * Setup a list where the cell text is bound to a given property
	 * 
	 * @param listView
	 *            the list view
	 * @param list
	 *            the list to set as the input
	 * @param property
	 *            the property
	 * @see #setupList(ListView, IValueProperty)
	 */
	public static <T> void setupList(ListView<T> listView,
			IObservableList list, IValueProperty property) {
		setupList(listView, property);
		listView.setItems(AdapterFactory.<T> adapt(list));
	}

	/**
	 * Setup a list where the template is used to format the property values
	 * 
	 * @param listView
	 *            the list view
	 * @param list
	 *            the list to set as the input
	 * @param template
	 *            the template
	 * @param properties
	 *            the properties to display
	 * @see #setupList(ListView, String, IValueProperty...)
	 */
	public static <T> void setupList(ListView<T> listView,
			IObservableList list, String template, IValueProperty... properties) {
		setupList(listView, template, properties);
		listView.setItems(AdapterFactory.<T> adapt(list));
	}

	/**
	 * Setup a combo box where the cell text is bound to the given property
	 * 
	 * @param comboBox
	 *            the combo box
	 * @param property
	 *            the property
	 * @see PropertyListCellFaytory#textFactory(IValueProperty)
	 * @see PropertyListCellFaytory#textCell(IValueProperty)
	 */
	public static <T> void setupComboBox(ComboBox<T> comboBox,
			IValueProperty property) {
		comboBox.setCellFactory(PropertyListCellFaytory
				.<T> textFactory(property));
		comboBox.setButtonCell(PropertyListCellFaytory.<T> textCell(property));
	}

	/**
	 * Setup a combo box where the template is used to format the property
	 * values
	 * 
	 * @param comboBox
	 *            the combo box
	 * @param template
	 *            the template to use
	 * @param properties
	 *            the properties to display
	 * @see PropertyListCellFaytory#textFactory(String, IValueProperty...)
	 * @see PropertyListCellFaytory#textCell(String, IValueProperty...)
	 */
	public static <T> void setupComboBox(ComboBox<T> comboBox, String template,
			IValueProperty... properties) {
		comboBox.setCellFactory(PropertyListCellFaytory.<T> textFactory(
				template, properties));
		comboBox.setButtonCell(PropertyListCellFaytory.<T> textCell(template,
				properties));
	}

	/**
	 * Setup a combo box where the cell text is bound to the given property
	 * 
	 * @param list
	 *            the list to set as the input
	 * @param comboBox
	 *            the combo box
	 * @param property
	 *            the property
	 * @see #setupComboBox(ComboBox, IValueProperty)
	 */
	public static <T> void setupComboBox(IObservableList list,
			ComboBox<T> comboBox, IValueProperty property) {
		setupComboBox(comboBox, property);
		comboBox.setItems(AdapterFactory.<T> adapt(list));
	}

	/**
	 * Setup a combo box where the template is used to format the property
	 * values
	 * 
	 * @param comboBox
	 *            the combo box
	 * @param list
	 *            the list to set as the input
	 * @param template
	 *            the template to use
	 * @param properties
	 *            the properties to display
	 * @see #setupComboBox(ComboBox, String, IValueProperty...)
	 */
	public static <T> void setupComboBox(ComboBox<T> comboBox,
			IObservableList list, String template, IValueProperty... properties) {
		setupComboBox(comboBox, template, properties);
		comboBox.setItems(AdapterFactory.<T> adapt(list));
	}
}

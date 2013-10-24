package org.eclipse.fx.ui.databinding;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.fx.core.databinding.AdapterFactory;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class ListUtil {
	public static <T> void setupList(ListView<T> listView, IValueProperty property) {
		listView.setCellFactory(PropertyListCellFaytory.<T>textFactory(property));
	}
	
	public static <T> void setupList(ListView<T> listView, String template, IValueProperty... properties) {
		listView.setCellFactory(PropertyListCellFaytory.<T>textFactory(template, properties));
	}
	
	public static <T> void setupComboBox(ComboBox<T> comboBox, IValueProperty property) {
		comboBox.setCellFactory(PropertyListCellFaytory.<T>textFactory(property)); 
		comboBox.setButtonCell(PropertyListCellFaytory.<T>textCell(property));
	}
	
	public static <T> void setupComboBox(ComboBox<T> comboBox, String template, IValueProperty... properties) {
		comboBox.setCellFactory(PropertyListCellFaytory.<T>textFactory(template,properties));
		comboBox.setButtonCell(PropertyListCellFaytory.<T>textCell(template,properties));
	}
	
	public static <T> void setupComboBox(IObservableList list, ComboBox<T> comboBox, IValueProperty property) {
		comboBox.setCellFactory(PropertyListCellFaytory.<T>textFactory(property));
		comboBox.setButtonCell(PropertyListCellFaytory.<T>textCell(property));
		comboBox.setItems(AdapterFactory.<T>adapt(list));
	}
	
	public static <T> void setupComboBox(IObservableList list, ComboBox<T> comboBox, String template, IValueProperty... properties) {
		comboBox.setCellFactory(PropertyListCellFaytory.<T>textFactory(template,properties));
		comboBox.setButtonCell(PropertyListCellFaytory.<T>textCell(template,properties));
		comboBox.setItems(AdapterFactory.<T>adapt(list));
	}
}

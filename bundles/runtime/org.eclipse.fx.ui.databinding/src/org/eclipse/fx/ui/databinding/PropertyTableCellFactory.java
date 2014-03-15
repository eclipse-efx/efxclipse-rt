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

import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.fx.core.databinding.AdapterFactory;
import org.eclipse.fx.core.databinding.ObservableWritableValue;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Factory for table cells
 * 
 * @param <S>
 *            the row value type
 * @param <T>
 *            the cell value type
 */
public abstract class PropertyTableCellFactory<S, T> implements
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
		return new PropertyTableCellFactory<S, T>() {

			@Override
			public TableCell<S, T> call(TableColumn<S, T> param) {
				return textCell(property);
			}
		};
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
		return new PropertyTableCellFactory<S, T>() {

			@Override
			public TableCell<S, T> call(TableColumn<S, T> param) {
				return textCell(template, property);
			}
		};
	}

	/**
	 * Create a table cell using the property for the text
	 * 
	 * @param property
	 *            the property
	 * @return the table cell
	 */
	@NonNull
	public static <S, T> TableCell<S, T> textCell(IValueProperty property) {
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
	public static <S, T> TableCell<S, T> textCell(String template,
			IValueProperty... property) {
		return new TemplateTextOnlyPropertyListCell<>(template, property);
	}

	static class TextOnlyPropertyTableCell<S, T> extends TableCell<S, T> {
		private IObservableValue currentObservable;
		@NonNull
		private IValueProperty textProperty;

		public TextOnlyPropertyTableCell(@NonNull IValueProperty textProperty) {
			this.textProperty = textProperty;
		}

		@Override
		protected void updateItem(T item, boolean empty) {
			super.updateItem(item, empty);

			IObservableValue oldObservable = this.currentObservable;
			textProperty().unbind();

			if (item != null && !empty) {
				this.currentObservable = this.textProperty.observe(item); 
				ObservableWritableValue<String> adapt = AdapterFactory
						.<String> adapt(this.currentObservable);
				textProperty().bind(adapt);
			} else {
				setText(null);
			}

			if (oldObservable != null) {
				oldObservable.dispose();
			}
		}
	}

	static class TemplateTextOnlyPropertyListCell<S, T> extends TableCell<S, T> {
		private IObservableValue currentObservable;
		@NonNull
		private IValueProperty[] properties;
		@NonNull
		private String template;

		public TemplateTextOnlyPropertyListCell(@NonNull String template,
				@NonNull IValueProperty... properties) {
			this.template = template;
			this.properties = properties;
		}

		@Override
		protected void updateItem(T item, boolean empty) {
			super.updateItem(item, empty);

			IObservableValue oldObservable = this.currentObservable;
			textProperty().unbind();

			if (item != null && !empty) {
				this.currentObservable = new TemplateComputedValue(item, this.template,
						this.properties);
				ObservableWritableValue<String> adapt = AdapterFactory
						.<String> adapt(this.currentObservable);
				textProperty().bind(adapt);
			} else {
				setText(null);
			}

			if (oldObservable != null)
				oldObservable.dispose();
		}
	}

	static class TemplateComputedValue extends ComputedValue {
		private IObservableValue[] values;
		@NonNull 
		private String template;

		public TemplateComputedValue(@NonNull Object o, @NonNull String template,
				@NonNull IValueProperty[] properties) {
			this.template = template;
			this.values = new IObservableValue[properties.length];
			for (int i = 0; i < this.values.length; i++) {
				this.values[i] = properties[i].observe(o);
			}
		}

		@Override
		protected Object calculate() {
			Object[] v = new Object[this.values.length];
			for (int i = 0; i < this.values.length; i++) {
				v[i] = this.values[i].getValue();
			}
			return MessageFormat.format(this.template, v);
		}

		@Override
		public synchronized void dispose() {
			super.dispose();
			for (IObservableValue v : this.values) {
				v.dispose();
			}
		}
	}
}

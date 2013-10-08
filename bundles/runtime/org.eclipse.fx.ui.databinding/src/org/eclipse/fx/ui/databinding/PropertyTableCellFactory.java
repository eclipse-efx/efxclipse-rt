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

public abstract class PropertyTableCellFactory<S,T> implements Callback<TableColumn<S,T>, TableCell<S,T>> {
	public static <S,T> PropertyTableCellFactory<S,T> textFactory(final IValueProperty property) {
		return new PropertyTableCellFactory<S,T>() {

			@Override
			public TableCell<S, T> call(TableColumn<S, T> param) {
				return textCell(property);
			}
		};
	}
	
	public static <S,T> PropertyTableCellFactory<S,T> textFactory(final String template, final IValueProperty... property) {
		return new PropertyTableCellFactory<S,T>() {

			@Override
			public TableCell<S, T> call(TableColumn<S, T> param) {
				return textCell(template, property);
			}
		};
	}
	
	public static <S,T> TableCell<S,T> textCell(IValueProperty property) {
		return new TextOnlyPropertyTableCell<>(property);
	}
	
	public static <S,T> TableCell<S,T> textCell(String template, IValueProperty... property) {
		return new TemplateTextOnlyPropertyListCell<>(template,property);
	}
	
	static class TextOnlyPropertyTableCell<S,T> extends TableCell<S,T> {
		private IObservableValue currentObservable;
		private IValueProperty textProperty;
		
		public TextOnlyPropertyTableCell(IValueProperty textProperty) {
			this.textProperty = textProperty;
		}
		
		@Override
		protected void updateItem(T item, boolean empty) {
			super.updateItem(item, empty);
			
			IObservableValue oldObservable = currentObservable;
			textProperty().unbind();
			
			if( item != null && ! empty ) {
				currentObservable = textProperty.observe(item);
				ObservableWritableValue<String> adapt = AdapterFactory.<String>adapt(currentObservable);
				textProperty().bind(adapt);
			}
			
			if( oldObservable != null ) {
				oldObservable.dispose();	
			}
		}
	}
	
	static class TemplateTextOnlyPropertyListCell<S,T> extends TableCell<S,T> {
		private IObservableValue currentObservable;
		private IValueProperty[] properties;
		private String template;
		
		public TemplateTextOnlyPropertyListCell(String template, IValueProperty... properties) {
			this.template = template;
			this.properties = properties;
		}
		
		@Override
		protected void updateItem(T item, boolean empty) {
			super.updateItem(item, empty);
			
			IObservableValue oldObservable = currentObservable;
			textProperty().unbind();
			
			if( item != null && ! empty ) {
				currentObservable = new TemplateComputedValue(item, template, properties);
				ObservableWritableValue<String> adapt = AdapterFactory.<String>adapt(currentObservable);
				textProperty().bind(adapt);
			}
			
			if( oldObservable != null )
				oldObservable.dispose();
		}
	}
	
	static class TemplateComputedValue extends ComputedValue {
		private IObservableValue[] values;
		private String template;
		
		public TemplateComputedValue(Object o, String template, IValueProperty[] properties) {
			this.template = template;
			this.values = new IObservableValue[properties.length];
			for( int i = 0; i < values.length; i++ ) {
				values[i] = properties[i].observe(o);
			}
		}
		
		@Override
		protected Object calculate() {
			Object[] v = new Object[values.length];
			for( int i = 0; i < values.length; i++ ) {
				v[i] = values[i].getValue();
			}
			return MessageFormat.format(template, v);
		}
		
		@Override
		public synchronized void dispose() {
			super.dispose();
			for( IObservableValue v : values ) {
				v.dispose();
			}
		}
	}
}

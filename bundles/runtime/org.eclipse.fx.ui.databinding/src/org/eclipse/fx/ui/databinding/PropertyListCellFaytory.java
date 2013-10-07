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

import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.fx.core.databinding.AdapterFactory;
import org.eclipse.fx.core.databinding.ObservableWritableValue;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public abstract class PropertyListCellFaytory<O> implements Callback<ListView<O>, ListCell<O>> {
	public static <O> PropertyListCellFaytory<O> textFactory(final IValueProperty textProperty) {
		return new PropertyListCellFaytory<O>() {

			@Override
			public ListCell<O> call(ListView<O> param) {
				return textCell(textProperty);
			}
		};
	}
	
	public static <O> PropertyListCellFaytory<O> textFactory(final String template, final IValueProperty... textProperties) {
		return new PropertyListCellFaytory<O>() {

			@Override
			public ListCell<O> call(ListView<O> param) {
				return textCell(template, textProperties);
			}
			
		};
	}
	
	public static <O> ListCell<O> textCell(final IValueProperty textProperty) {
		return new TextOnlyPropertyListCell<>(textProperty);
	}
	
	public static <O> ListCell<O> textCell(String template, IValueProperty... textProperties) {
		return new TemplateTextOnlyPropertyListCell<>(template, textProperties);
	}
	
	static class TextOnlyPropertyListCell<O> extends ListCell<O> {
		private IObservableValue currentObservable;
		private IValueProperty textProperty;
		
		public TextOnlyPropertyListCell(IValueProperty textProperty) {
			this.textProperty = textProperty;
		}
		
		@Override
		protected void updateItem(O item, boolean empty) {
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
	
	static class TemplateTextOnlyPropertyListCell<O> extends ListCell<O> {
		private IObservableValue currentObservable;
		private IValueProperty[] properties;
		private String template;
		
		public TemplateTextOnlyPropertyListCell(String template, IValueProperty... properties) {
			this.template = template;
			this.properties = properties;
		}
		
		@Override
		protected void updateItem(O item, boolean empty) {
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

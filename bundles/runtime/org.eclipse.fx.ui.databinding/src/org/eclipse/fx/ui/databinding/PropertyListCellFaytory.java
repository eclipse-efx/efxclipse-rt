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

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.fx.core.databinding.AdapterFactory;
import org.eclipse.fx.core.databinding.ObservableWritableValue;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public abstract class PropertyListCellFaytory<O> implements Callback<ListView<O>, ListCell<O>> {
	
	public static <O> PropertyListCellFaytory<O> text(final IValueProperty textProperty) {
		return new PropertyListCellFaytory<O>() {

			@Override
			public ListCell<O> call(ListView<O> param) {
				return new TextOnlyPropertyListCell<>(textProperty);
			}
		};
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
				ObservableWritableValue<String> adapt = AdapterFactory.<String>adapt(textProperty.observe(item));
				textProperty().bind(adapt);
			}
			
			if( oldObservable != null ) {
				oldObservable.dispose();	
			}
		}
	}
}

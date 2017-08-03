/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.databinding.internal;

import javafx.scene.control.ListCell;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.fx.core.databinding.AdapterFactory;
import org.eclipse.fx.core.databinding.ObservableWritableValue;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A {@link ListCell} where the text is bound to the given property
 * 
 * @param <O>
 *            the type
 */
public final class TextOnlyPropertyListCell<O> extends ListCell<O> {
	private IObservableValue currentObservable;
	@NonNull
	private IValueProperty textProperty;

	/**
	 * Create a new cell
	 * 
	 * @param textProperty
	 *            the property to bind
	 */
	public TextOnlyPropertyListCell(@NonNull IValueProperty textProperty) {
		this.textProperty = textProperty;
	}

	@Override
	protected void updateItem(O item, boolean empty) {
		super.updateItem(item, empty);

		IObservableValue oldObservable = this.currentObservable;
		textProperty().unbind();

		if (item != null && !empty) {
			this.currentObservable = this.textProperty.observe(item);
			ObservableWritableValue<String> adapt = AdapterFactory.<String> adapt(this.currentObservable);
			textProperty().bind(adapt);
		} else {
			setText(null);
		}

		if (oldObservable != null) {
			oldObservable.dispose();
		}
	}
}
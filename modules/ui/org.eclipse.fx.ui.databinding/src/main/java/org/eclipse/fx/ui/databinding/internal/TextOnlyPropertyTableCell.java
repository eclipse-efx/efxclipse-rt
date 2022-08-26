/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.databinding.internal;

import javafx.scene.control.TableCell;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.fx.core.databinding.AdapterFactory;
import org.eclipse.fx.core.databinding.ObservableWritableValue;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A {@link TableCell} where the text is bound to the give property
 * 
 * @param <S>
 *            the row type
 * @param <T>
 *            the cell value type
 */
public final class TextOnlyPropertyTableCell<S, T> extends TableCell<S, T> {
	private IObservableValue currentObservable;
	@NonNull
	private IValueProperty textProperty;

	/**
	 * Create a new cell
	 * 
	 * @param textProperty
	 *            the property to bind to
	 */
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
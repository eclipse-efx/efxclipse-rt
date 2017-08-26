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

import java.util.function.BiFunction;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.fx.core.databinding.AdapterFactory;
import org.eclipse.fx.core.databinding.ObservableWritableValue;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A {@link ListCell} only updating the text-property
 *
 * @param <O>
 *            the type
 */
public final class TemplateTextOnlyPropertyListCell<O> extends ListCell<O> {
	private IObservableValue currentObservable;
	@NonNull
	private final IValueProperty[] properties;
	@NonNull
	private final String template;
	@Nullable
	private final BiFunction<@NonNull IValueProperty, @Nullable Object, @Nullable Object> converter;

	/**
	 * Create a new cell
	 *
	 * @param template
	 *            the template to use
	 * @param properties
	 *            the properties
	 */
	public TemplateTextOnlyPropertyListCell(@NonNull String template, @NonNull IValueProperty... properties) {
		this.template = template;
		this.properties = properties;
		this.converter = null;
	}

	/**
	 * Create a new cell
	 *
	 * @param template
	 *            the template to use
	 * @param converter
	 *            converter for property values
	 * @param properties
	 *            the properties
	 * @since 2.1.0
	 */
	public TemplateTextOnlyPropertyListCell(@NonNull String template,
			@NonNull BiFunction<@NonNull IValueProperty, @Nullable Object, @Nullable Object> converter,
			@NonNull IValueProperty... properties) {
		this.template = template;
		this.converter = converter;
		this.properties = properties;
	}

	@Override
	protected void updateItem(O item, boolean empty) {
		super.updateItem(item, empty);

		IObservableValue oldObservable = this.currentObservable;
		textProperty().unbind();

		if (item != null && !empty) {
			if( this.converter != null ) {
				this.currentObservable = new TemplateComputedValue(item, this.template, this.properties, this.converter);
			} else {
				this.currentObservable = new TemplateComputedValue(item, this.template, this.properties);
			}
			ObservableWritableValue<String> adapt = AdapterFactory.<String> adapt(this.currentObservable);
			textProperty().bind(adapt);
		} else {
			setText(null);
		}

		if (oldObservable != null)
			oldObservable.dispose();
	}
}
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

import java.text.MessageFormat;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A computed value using the the message template
 */
public final class TemplateComputedValue extends ComputedValue<String> {
	@NonNull
	private final List<@NonNull Struct> values;
	@NonNull
	private final String template;
	@NonNull
	private final BiFunction<IValueProperty, Object, Object> converter;

	final static class Struct {
		final IValueProperty property;
		final IObservableValue value;

		public Struct(IValueProperty property, Object o) {
			this.property = property;
			this.value = property.observe(o);
		}
	}

	/**
	 * Create a template value
	 *
	 * @param o
	 *            the value
	 * @param template
	 *            the template
	 * @param properties
	 *            the properties
	 */
	public TemplateComputedValue(@NonNull Object o, @NonNull String template, @NonNull IValueProperty[] properties) {
		this(o, template, properties, (p, v) -> v);
	}

	/**
	 * Create a template value
	 *
	 * @param o
	 *            the value
	 * @param template
	 *            the template
	 * @param properties
	 *            the properties
	 * @param converter
	 *            the converter
	 * @since 2.2.0
	 */
	@SuppressWarnings("null")
	public TemplateComputedValue(@NonNull Object o, @NonNull String template, @NonNull IValueProperty[] properties,
			@NonNull BiFunction<@NonNull IValueProperty, @Nullable Object, @Nullable Object> converter) {
		this.template = template;
		this.values = Stream.of(properties).map((p) -> new Struct(p, o)).collect(Collectors.toList());
		this.converter = converter;
	}

	@Override
	protected String calculate() {
		Object[] v = this.values.stream().map((o) -> this.converter.apply(o.property, o.value.getValue())).toArray();
		return MessageFormat.format(this.template, v);
	}

	@Override
	public synchronized void dispose() {
		super.dispose();
		this.values.forEach((v) -> v.value.dispose());
	}
}
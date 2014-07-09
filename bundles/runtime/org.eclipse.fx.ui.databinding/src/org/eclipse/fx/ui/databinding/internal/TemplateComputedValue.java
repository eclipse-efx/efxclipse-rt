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
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A computed value using the the message template
 */
public final class TemplateComputedValue extends ComputedValue {
	@NonNull
	private List<@NonNull IObservableValue> values;
	@NonNull
	private String template;

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
	@SuppressWarnings("null")
	public TemplateComputedValue(@NonNull Object o, @NonNull String template, @NonNull IValueProperty[] properties) {
		this.template = template;
		this.values = Stream.of(properties).map((p) -> p.observe(o)).collect(Collectors.toList());
	}

	@Override
	protected Object calculate() {
		Object[] v = this.values.stream().map((o) -> o.getValue()).toArray();
		return MessageFormat.format(this.template, v);
	}

	@Override
	public synchronized void dispose() {
		super.dispose();
		this.values.forEach((v) -> v.dispose());
	}
}
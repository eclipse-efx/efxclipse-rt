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

import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A computed value using the the message template
 */
public final class TemplateComputedValue extends ComputedValue {
	@NonNull
	private IObservableValue[] values;
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
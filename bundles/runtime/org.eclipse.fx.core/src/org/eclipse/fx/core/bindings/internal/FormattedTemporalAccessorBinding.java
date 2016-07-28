/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.bindings.internal;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.StringBinding;
import javafx.beans.value.ObservableValue;

@SuppressWarnings("javadoc")
public class FormattedTemporalAccessorBinding extends StringBinding {
	private final String nullReplacement;
	private final DateTimeFormatter formatter;
	private final ObservableValue<? extends TemporalAccessor> source;

	private InvalidationListener onInvalidate = x -> {
		FormattedTemporalAccessorBinding.this.invalidate();
	};

	public FormattedTemporalAccessorBinding(ObservableValue<? extends TemporalAccessor> source, DateTimeFormatter formatter, String nullReplacement) {
		this.source = source;
		this.formatter = formatter;
		this.nullReplacement = nullReplacement;
		bind(source);
	}

	@Override
	public void dispose() {
		this.source.removeListener(this.onInvalidate);
		super.dispose();
	}

	@Override
	protected String computeValue() {
		return this.source.getValue() == null ? this.nullReplacement : this.formatter.format(this.source.getValue());
	}

}

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
package org.eclipse.fx.ui.databinding.internal;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.core.databinding.property.INativePropertyListener;
import org.eclipse.core.databinding.property.IProperty;
import org.eclipse.core.databinding.property.ISimplePropertyListener;
import org.eclipse.core.databinding.property.NativePropertyListener;
import org.eclipse.jdt.annotation.NonNull;

import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

@SuppressWarnings("javadoc")
public abstract class ControlReadOnlyPropertyValueProperty<S,T> extends ControlValueProperty<S,T> {

	@Override
	protected T doGetValue(S source) {
		ReadOnlyProperty<T> p = getProperty(source);
		return p.getValue();
	}

	/**
	 * Get the property
	 *
	 * @param source
	 *            the source
	 * @return the property
	 */
	protected abstract @NonNull ReadOnlyProperty<T> getProperty(S source);

	@Override
	public INativePropertyListener<S> adaptListener(ISimplePropertyListener<S, ValueDiff<? extends T>> listener) {
		return new ListenerImpl(this, listener);
	}

	class ListenerImpl extends NativePropertyListener<S, ValueDiff<? extends T>> implements ChangeListener<T> {
		private S owner;

		@SuppressWarnings("null")
		public ListenerImpl(IProperty property, ISimplePropertyListener<S, ValueDiff<? extends T>> listener) {
			super(property, listener);
		}

		@Override
		public void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {
			fireChange(this.owner, Diffs.createValueDiff(oldValue, newValue));
		}

		@Override
		protected void doAddTo(S source) {
			this.owner = source;
			ReadOnlyProperty<T> p = getProperty(source);
			p.addListener(this);
		}

		@SuppressWarnings("null")
		@Override
		protected void doRemoveFrom(S source) {
			this.owner = null;
			ReadOnlyProperty<T> p = getProperty(source);
			p.removeListener(this);
		}
	}
}
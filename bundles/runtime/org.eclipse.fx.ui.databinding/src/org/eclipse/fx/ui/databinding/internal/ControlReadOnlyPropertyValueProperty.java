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

import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.property.INativePropertyListener;
import org.eclipse.core.databinding.property.IProperty;
import org.eclipse.core.databinding.property.ISimplePropertyListener;
import org.eclipse.core.databinding.property.NativePropertyListener;
import org.eclipse.jdt.annotation.NonNull;

/**
 * @param <O>
 */
public abstract class ControlReadOnlyPropertyValueProperty<O> extends ControlValueProperty {

	@Override
	protected Object doGetValue(Object source) {
		ReadOnlyProperty<O> p = getProperty(source);
		return p.getValue();
	}

	/**
	 * Get the property
	 * 
	 * @param source
	 *            the source
	 * @return the property
	 */
	protected abstract @NonNull ReadOnlyProperty<O> getProperty(Object source);

	@Override
	public INativePropertyListener adaptListener(ISimplePropertyListener listener) {
		return new ListenerImpl(this, listener);
	}

	class ListenerImpl extends NativePropertyListener implements ChangeListener<Object> {
		private Object owner;

		public ListenerImpl(IProperty property, ISimplePropertyListener listener) {
			super(property, listener);
		}

		@Override
		public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
			fireChange(this.owner, Diffs.createValueDiff(oldValue, newValue));
		}

		@Override
		protected void doAddTo(Object source) {
			this.owner = source;
			ReadOnlyProperty<O> p = getProperty(source);
			p.addListener(this);
		}

		@Override
		protected void doRemoveFrom(Object source) {
			this.owner = null;
			ReadOnlyProperty<O> p = getProperty(source);
			p.removeListener(this);
		}
	}
}
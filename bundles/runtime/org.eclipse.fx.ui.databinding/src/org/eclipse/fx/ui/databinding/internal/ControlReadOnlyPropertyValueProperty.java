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

public abstract class ControlReadOnlyPropertyValueProperty extends ControlValueProperty {
	
	@Override
	protected Object doGetValue(Object source) {
		ReadOnlyProperty<Object> p = getProperty(source);
		return p != null ? p.getValue() : null;
	}
	
	protected abstract ReadOnlyProperty<Object> getProperty(Object source);
	
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
			fireChange(owner, Diffs.createValueDiff(oldValue, newValue));
		}

		@Override
		protected void doAddTo(Object source) {
			this.owner = source;
			ReadOnlyProperty<Object> p = getProperty(source);
			if( p != null ) {
				p.addListener(this);
			}
		}

		@Override
		protected void doRemoveFrom(Object source) {
			this.owner = null;
			ReadOnlyProperty<Object> p = getProperty(source);
			if( p != null ) {
				p.removeListener(this);
			}
		}		
	}
}
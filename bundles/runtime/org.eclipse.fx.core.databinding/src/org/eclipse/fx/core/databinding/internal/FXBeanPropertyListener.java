/*******************************************************************************
 * Copyright (c) 2009 Matthew Hall and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Matthew Hall - initial API and implementation (bug 265561)
 *     Matthew Hall - bug 268336
 ******************************************************************************/

package org.eclipse.fx.core.databinding.internal;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import org.eclipse.core.databinding.observable.IDiff;
import org.eclipse.core.databinding.property.IProperty;
import org.eclipse.core.databinding.property.ISimplePropertyListener;
import org.eclipse.core.databinding.property.NativePropertyListener;

/**
 * Wraps a native listener
 */
public abstract class FXBeanPropertyListener extends NativePropertyListener {
	private final PropertyDescriptor propertyDescriptor;
	private final Map<Object, ChangeListener<Object>> map = new HashMap<Object, ChangeListener<Object>>();

	protected FXBeanPropertyListener(IProperty property,
			PropertyDescriptor propertyDescriptor,
			ISimplePropertyListener listener) {
		super(property, listener);
		this.propertyDescriptor = propertyDescriptor;
	}

//	public void propertyChange(java.beans.PropertyChangeEvent evt) {
//		if (evt.getPropertyName() == null
//				|| propertyDescriptor.getName().equals(evt.getPropertyName())) {
//			Object oldValue = evt.getOldValue();
//			Object newValue = evt.getNewValue();
//			IDiff diff;
//			if (evt.getPropertyName() == null || oldValue == null
//					|| newValue == null)
//				diff = null;
//			else
//				diff = computeDiff(oldValue, newValue);
//			fireChange(evt.getSource(), diff);
//		}
//	}

	protected abstract IDiff computeDiff(Object oldValue, Object newValue);

	@Override
	protected void fireChange(Object source, IDiff diff) {
		super.fireChange(source, diff);
	}
	
	@Override
	protected void doAddTo(Object source) {
		if( ! this.map.containsKey(source) ) {
			ChangeListener<Object> l = new ChangeListener<Object>() {

				@Override
				public void changed(ObservableValue<? extends Object> source,
						Object oldValue, Object newValue) {
					IDiff diff;
					if (oldValue == null || newValue == null)
						diff = null;
					else
						diff = computeDiff(oldValue, newValue);
					fireChange(source, diff);
				}
			};
			this.map.put(source, l);
			FXBeanPropertyListenerSupport.hookListener(source,
					this.propertyDescriptor.getName(), l);
		}
		
	}

	@Override
	protected void doRemoveFrom(Object source) {
		ChangeListener<Object> l = this.map.get(source);
		if (l != null) {
			FXBeanPropertyListenerSupport.unhookListener(source,
					this.propertyDescriptor.getName(), l);
		}
	}
}
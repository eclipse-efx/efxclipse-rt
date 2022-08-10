/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di.context.internal;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;

import org.eclipse.fx.core.Callback;
import org.eclipse.fx.core.adapter.AdapterProvider;
import org.eclipse.fx.core.adapter.AdapterService.ValueAccess;
import org.eclipse.fx.core.di.ContextBoundValue;
import org.osgi.service.component.annotations.Component;

/**
 * JavaFX Property adapter provider
 */
@SuppressWarnings("rawtypes")
@Component
public class PropertyAdapterProvider implements AdapterProvider<ContextBoundValue, Property> {

	@Override
	public Class<ContextBoundValue> getSourceType() {
		return ContextBoundValue.class;
	}

	@Override
	public Class<Property> getTargetType() {
		return Property.class;
	}

	@Override
	public boolean canAdapt(ContextBoundValue sourceObject, Class<Property> targetType) {
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Property adapt(final ContextBoundValue sourceObject, Class<Property> targetType, ValueAccess... valueAccess) {
		final SimpleObjectProperty<Object> rv = new SimpleObjectProperty<>(sourceObject.getValue());
		final InvalidationListener l = new InvalidationListener() {

			@Override
			public void invalidated(Observable observable) {
				sourceObject.publish(rv.get());
			}
		};
		rv.addListener(l);
		sourceObject.subscribeOnValueChange(new Callback() {

			@Override
			public void call(Object value) {
				if (rv.get() == null && value == null)
					return;
				if (rv.get() != null && rv.get().equals(value))
					return;
				rv.set(value);
			}
		});
		sourceObject.subscribeOnDispose(new Callback() {

			@Override
			public void call(Object value) {
				rv.removeListener(l);
			}
		});
		return rv;
	}

}

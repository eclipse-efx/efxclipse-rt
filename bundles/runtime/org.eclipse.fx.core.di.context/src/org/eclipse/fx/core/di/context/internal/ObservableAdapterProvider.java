/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di.context.internal;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.fx.core.Callback;
import org.eclipse.fx.core.adapter.AdapterProvider;
import org.eclipse.fx.core.adapter.AdapterService.ValueAccess;
import org.eclipse.fx.core.di.ContextBoundValue;

/**
 * Eclipse Databinding Observable Adapter
 */
@SuppressWarnings("rawtypes")
public class ObservableAdapterProvider implements AdapterProvider<ContextBoundValue, IObservableValue> {

	@Override
	public Class<ContextBoundValue> getSourceType() {
		return ContextBoundValue.class;
	}

	@Override
	public Class<IObservableValue> getTargetType() {
		return IObservableValue.class;
	}

	@Override
	public boolean canAdapt(ContextBoundValue sourceObject, Class<IObservableValue> targetType) {
		return true;
	}

	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public IObservableValue adapt(final ContextBoundValue sourceObject, Class<IObservableValue> targetType, ValueAccess... valueAccess) {
		Realm r = null;
		
		for( ValueAccess a : valueAccess ) {
			r = a.getValue(Realm.class);
			if( r != null ) {
				break;
			}
		}
		
		if( r == null ) {
			r = Realm.getDefault();
		}
		
		if( r == null ) {
			r = new Realm() {
				private Thread t = Thread.currentThread();
				
				@Override
				public boolean isCurrent() {
					return this.t == Thread.currentThread();
				}
			};
		}
		
		final WritableValue w = new WritableValue(r);
		w.setValue(sourceObject.getValue());
		w.addValueChangeListener(new IValueChangeListener() {
			
			@Override
			public void handleValueChange(ValueChangeEvent event) {
				sourceObject.publish(event.diff.getNewValue());
			}
		});
		sourceObject.subscribeOnValueChange(new Callback() {

			@Override
			public void call(Object value) {
				w.setValue(value);
			}
		});
		sourceObject.subscribeOnDispose(new Callback<Void>() {

			@Override
			public void call(Void value) {
				w.dispose();
			}
		});
		return w;
	}
}
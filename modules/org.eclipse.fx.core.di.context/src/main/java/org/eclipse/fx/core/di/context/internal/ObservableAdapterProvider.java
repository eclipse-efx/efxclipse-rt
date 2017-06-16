/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *     Thorsten Hake <mail@thorsten-hake.com> - fix for Bug 477417
 *******************************************************************************/
package org.eclipse.fx.core.di.context.internal;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.fx.core.Callback;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.adapter.AdapterProvider;
import org.eclipse.fx.core.adapter.AdapterService.ValueAccess;
import org.eclipse.fx.core.di.ContextBoundValue;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.service.component.annotations.Component;

/**
 * Eclipse Databinding Observable Adapter
 */
@SuppressWarnings("rawtypes")
@Component
public class ObservableAdapterProvider implements AdapterProvider<ContextBoundValue, IObservableValue> {
	/**
	 * Private class that adapts represents an ContextBoundValue as an IObservableValue.
	 *
	 */
	private static class ContextBoundObservableValue extends AbstractObservableValue{
		private ContextBoundValue sourceObject;
		private Object valueType;

		private Subscription currentSubscription;

		final class ContextBoundValueChanged implements Callback{
			private Object lastValue = doGetValue();

			public ContextBoundValueChanged() {
				super();
			}

			@SuppressWarnings("synthetic-access")
			@Override
			public void call(@Nullable Object value) {
				//Make sure that we fire events in the correct realm
				getRealm().exec(() -> {
					if(this.lastValue != value){
						fireValueChange(Diffs.createValueDiff(this.lastValue, this.lastValue = value));
					}
				});
			}

		}

		public ContextBoundObservableValue(Realm realm, ContextBoundValue boundValue) {
			this(realm,boundValue,null);

		}
		public ContextBoundObservableValue( Realm realm, ContextBoundValue boundValue, Object valueType) {
			super(realm);
			this.sourceObject = boundValue;
			this.valueType = valueType;
		}

		@Override
		public Object getValueType() {
			return this.valueType;
		}

		@Override
		protected Object doGetValue() {
			return this.sourceObject.getValue();
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void doSetValue(Object value) {
			 this.sourceObject.publish(value);
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void firstListenerAdded(){
			this.currentSubscription = this.sourceObject.subscribeOnValueChange(new ContextBoundValueChanged());
		}
		@Override
		protected void lastListenerRemoved(){
			if(this.currentSubscription != null){
				this.currentSubscription.dispose();
				this.currentSubscription = null;
			}
		}
	}

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

	@SuppressWarnings({ "unchecked"})
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

				@Override
				public boolean isCurrent() {
					return true;
				}
			};
		}

		final IObservableValue w = new ContextBoundObservableValue(r,sourceObject);

		sourceObject.subscribeOnDispose(new Callback<Void>() {

			@Override
			public void call(Void value) {
				w.dispose();
			}
		});
		return w;
	}
}
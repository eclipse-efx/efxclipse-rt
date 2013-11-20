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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.contexts.RunAndTrack;
import org.eclipse.fx.core.Callback;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.adapter.AdapterService;
import org.eclipse.fx.core.adapter.AdapterService.ValueAccess;
import org.eclipse.fx.core.di.ContextBoundValue;

/**
 * Implementation of a ContextBoundValue
 */
public class EclipseContextBoundValue<T> implements ContextBoundValue<T> {
	private IEclipseContext context;
	private String contextKey;
	private List<Callback<T>> callbacks;
	private List<Callback<Void>> disposalCallbacks;
	private AdapterService adapterService;
	private T value;
	
	@Inject
	public EclipseContextBoundValue(IEclipseContext context, AdapterService adapterService) {
		this.context = context;
		this.adapterService = adapterService;
	}
	
	public void setContextKey(final String contextKey) {
		this.contextKey = contextKey;
		this.context.runAndTrack(new RunAndTrack() {
			
			@SuppressWarnings("unchecked")
			@Override
			public boolean changed(IEclipseContext context) {
				setCurrentValue((T) context.get(contextKey));
				return true;
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	private void setCurrentValue(T o) {
		this.value = o;
		if( callbacks != null ) {
			for( Callback<?> c : callbacks.toArray(new Callback<?>[0]) ) {
				((Callback<T>)c).call(o);
			}
		}
	}
	
	@Override
	public T getValue() {
		return value;
	}
	
	@Override
	public void publish(T value) {
		context.modify(contextKey, value);
	}

	@Override
	public Subscription subscribeOnValueChange(final Callback<T> callback) {
		if( callbacks == null ) {
			callbacks = new ArrayList<Callback<T>>();
		}
		callbacks.add(callback);
		return new Subscription() {
			
			@Override
			public void dispose() {
				callbacks.remove(callback);
			}
		};
	}
	
	@Override
	public Subscription subscribeOnDispose(final Callback<Void> callback) {
		if( disposalCallbacks == null ) {
			disposalCallbacks = new ArrayList<Callback<Void>>();
		}
		disposalCallbacks.add(callback);
		return new Subscription() {
			
			@Override
			public void dispose() {
				disposalCallbacks.remove(callback);
			}
		};
	}

	@Override
	public <A> A adaptTo(Class<A> adapt) {
		return adapterService.adapt(this, adapt, new ValueAccessImpl(context));
	}

	@Override
	public boolean canAdaptTo(Class<?> adapt) {
		return adapterService.canAdapt(this, adapt);
	}

	@PreDestroy
	void dispose() {
		if( disposalCallbacks != null ) {
			for(Callback<?> callback : disposalCallbacks.toArray(new Callback<?>[0])) {
				callback.call(null);
			}
			disposalCallbacks.clear();
		}
		if( callbacks != null ) {
			callbacks.clear();
		}
		value = null;
	}
	
	static class ValueAccessImpl implements ValueAccess {
		private final IEclipseContext context;
		
		public ValueAccessImpl(IEclipseContext context) {
			this.context = context;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public <O> O getValue(String key) {
			return (O) context.get(key);
		}

		@Override
		public <O> O getValue(Class<O> key) {
			return context.get(key);
		}
		
	}
}
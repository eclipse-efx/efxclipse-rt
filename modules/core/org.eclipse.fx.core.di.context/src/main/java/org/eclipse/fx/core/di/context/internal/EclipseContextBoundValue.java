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
import java.util.Collections;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.contexts.RunAndTrack;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.fx.core.Callback;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.adapter.AdapterService;
import org.eclipse.fx.core.adapter.AdapterService.ValueAccess;
import org.eclipse.fx.core.di.ContextBoundValue;
import org.eclipse.fx.core.di.ContextScope;
import org.eclipse.fx.core.di.ScopedObjectFactory;
import org.eclipse.fx.core.di.context.ScopeCalculator;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Implementation of a ContextBoundValue
 *
 * @param <T>
 *            the type
 */
public class EclipseContextBoundValue<T> implements ContextBoundValue<T> {
	@NonNull
	private IEclipseContext context;
	@Nullable
	private String contextKey;
	@Nullable
	List<Callback<T>> callbacks;
	@Nullable
	List<Callback<Void>> disposalCallbacks;
	@NonNull
	private AdapterService adapterService;

	@Inject
	@Optional
	@Nullable
	IEventBroker eventBroker;

	@Inject
	@Log
	private Logger logger;

	private ContextScope scope;

	@NonNull
	private final ScopeCalculator scopeCalculator;

	/**
	 * Create a new bound value
	 *
	 * @param context
	 *            the context
	 * @param adapterService
	 *            the adapter service
	 * @param scopeCalculator
	 *            service to calculate a scope
	 */
	@Inject
	public EclipseContextBoundValue(@NonNull IEclipseContext context, @NonNull AdapterService adapterService,
			@NonNull ScopeCalculator scopeCalculator) {
		this.context = context;
		this.adapterService = adapterService;
		this.scopeCalculator = scopeCalculator;
	}

	/**
	 * Setting the context key
	 *
	 * @param contextKey
	 *            the key
	 * @param scope
	 *            the scope
	 */
	public void setContextKey(@NonNull final String contextKey, final ContextScope scope) {
		this.contextKey = contextKey;
		this.scope = scope;
		this.context.runAndTrack(new RunAndTrack() {

			@Override
			public boolean changed(IEclipseContext context) {
				notifySubscriptions(getValue());
				return true;
			}
		});
	}

	@SuppressWarnings("unchecked")
	void notifySubscriptions(@Nullable T newValue) {
		if (this.callbacks != null) {
			for (Callback<?> c : this.callbacks.toArray(new Callback<?>[0])) {
				try {
					((Callback<T>) c).call(newValue);
				} catch (Throwable t) {
					this.logger.error("Failed while executing callback", t); //$NON-NLS-1$
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Nullable
	public T getValue() {
		if (this.contextKey == null) {
			// If no contextKey has been set, the value is always null.
			// This needs to be done in order to be conform to the
			// ContextBoundValue interface
			return null;
		}
		return (T) this.context.get(this.contextKey);
	}

	@Override
	public void publish(@Nullable T value) {
		if (this.scope == ContextScope.LOCAL) {
			this.context.set(this.contextKey, value);
		} else if (this.scope == ContextScope.APPLICATION) {
			this.scopeCalculator.getContext(this.context, this.scope).orElse(this.context).set(this.contextKey, value);
		} else {
			this.context.modify(this.contextKey, value);
		}

		if (this.eventBroker != null) {
			this.eventBroker.send(ScopedObjectFactory.KEYMODIFED_TOPIC,
					Collections.singletonMap(this.contextKey, value));
		}
	}

	@Override
	public Subscription subscribeOnValueChange(final Callback<T> callback) {
		if (this.callbacks == null) {
			this.callbacks = new ArrayList<Callback<T>>();
		}

		if (this.callbacks != null) {
			this.callbacks.add(callback);
		}

		return new Subscription() {

			@Override
			public void dispose() {
				List<Callback<T>> callbacks = EclipseContextBoundValue.this.callbacks;
				if (callbacks != null) {
					callbacks.remove(callback);
				}
			}
		};
	}

	@Override
	public Subscription subscribeOnDispose(final Callback<Void> callback) {
		if (this.disposalCallbacks == null) {
			this.disposalCallbacks = new ArrayList<Callback<Void>>();
		}
		if (this.disposalCallbacks != null) {
			this.disposalCallbacks.add(callback);
		}

		return new Subscription() {

			@Override
			public void dispose() {
				List<Callback<Void>> disposalCallbacks = EclipseContextBoundValue.this.disposalCallbacks;
				if (disposalCallbacks != null) {
					disposalCallbacks.remove(callback);
				}
			}
		};
	}

	@Override
	public <A> A adaptTo(@NonNull Class<A> adapt) {
		return this.adapterService.adapt(this, adapt, new ValueAccessImpl(this.context));
	}

	@Override
	public boolean canAdaptTo(Class<?> adapt) {
		return this.adapterService.canAdapt(this, adapt);
	}

	@PreDestroy
	void dispose() {
		List<Callback<Void>> disposalCallbacks = this.disposalCallbacks;
		if (disposalCallbacks != null) {
			for (Callback<?> callback : disposalCallbacks.toArray(new Callback<?>[0])) {
				try {
					callback.call(null);
				} catch (Throwable t) {
					this.logger.error("Failure while executing clean up callback", t); //$NON-NLS-1$
				}

			}
			disposalCallbacks.clear();
		}
		if (this.callbacks != null) {
			this.callbacks.clear();
		}
	}

	static class ValueAccessImpl implements ValueAccess {
		private final IEclipseContext context;

		public ValueAccessImpl(IEclipseContext context) {
			this.context = context;
		}

		@SuppressWarnings("unchecked")
		@Override
		public <O> O getValue(String key) {
			return (O) this.context.get(key);
		}

		@Override
		public <O> O getValue(@NonNull Class<O> key) {
			return this.context.get(key);
		}

	}
}
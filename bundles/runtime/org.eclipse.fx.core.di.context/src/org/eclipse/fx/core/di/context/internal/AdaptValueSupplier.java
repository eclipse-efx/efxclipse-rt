/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di.context.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.contexts.RunAndTrack;
import org.eclipse.e4.core.di.IInjector;
import org.eclipse.e4.core.di.suppliers.ExtendedObjectSupplier;
import org.eclipse.e4.core.di.suppliers.IObjectDescriptor;
import org.eclipse.e4.core.di.suppliers.IRequestor;
import org.eclipse.e4.core.internal.di.Requestor;
import org.eclipse.fx.core.adapter.Adapt;
import org.eclipse.fx.core.adapter.AdapterService;
import org.eclipse.fx.core.adapter.AdapterService.ValueAccess;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Supplier working for {@link Adapt}
 */
@SuppressWarnings("restriction")
public class AdaptValueSupplier extends ExtendedObjectSupplier {

	@Override
	public Object get(IObjectDescriptor descriptor, IRequestor requestor, boolean track, boolean group) {
		Requestor<?> r = (Requestor<?>) requestor;
		Class<?> desiredClass = getDesiredClass(descriptor.getDesiredType());
		if( desiredClass == null ) {
			return IInjector.NOT_A_VALUE;
		}

		final String key;
		if( descriptor.hasQualifier(Named.class) ) {
			key = descriptor.getQualifier(Named.class).value();
		} else {
			key = desiredClass.getName();
		}

		AtomicInteger i = new AtomicInteger();
		AtomicReference<Object> ref = new AtomicReference<>();
		Dummy dummy = r.getInjector().make(Dummy.class, r.getPrimarySupplier());
		if( track ) {
			dummy.context.runAndTrack(new RunAndTrack() {

				@Override
				public boolean changed(IEclipseContext context) {
					if( i.getAndIncrement() == 1 ) {
						requestor.resolveArguments(false);
						requestor.execute();
						return false;
					}
					ref.set(dummy.context.get(key));
					return true;
				}
			});
		} else {
			ref.set(dummy.context.get(key));
		}
		if( ref.get() != null ) {
			if( dummy.adapterService.canAdapt(ref.get(), desiredClass) ) {
				return dummy.adapterService.adapt(ref.get(), desiredClass, new ValueAccessImpl(dummy.context));
			}
		}

		return IInjector.NOT_A_VALUE;
	}

	private static @Nullable Class<?> getDesiredClass(Type desiredType) {
		if (desiredType instanceof Class<?>)
			return (Class<?>) desiredType;
		if (desiredType instanceof ParameterizedType) {
			Type rawType = ((ParameterizedType) desiredType).getRawType();
			if (rawType instanceof Class<?>)
				return (Class<?>) rawType;
		}
		return null;
	}

	static class Dummy {
		public AdapterService adapterService;

		public final IEclipseContext context;

		@Inject
		public Dummy(IEclipseContext context, AdapterService adapterService) {
			this.context = context;
			this.adapterService = adapterService;
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

		@SuppressWarnings("null")
		@Override
		public <O> O getValue(Class<O> key) {
			return this.context.get(key);
		}

	}
}

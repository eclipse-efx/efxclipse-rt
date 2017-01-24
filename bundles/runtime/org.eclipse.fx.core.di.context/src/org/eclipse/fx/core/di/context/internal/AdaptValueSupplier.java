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
import java.util.List;
import java.util.Set;
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
import org.eclipse.e4.core.internal.contexts.ContextObjectSupplier;
import org.eclipse.e4.core.internal.di.Requestor;
import org.eclipse.fx.core.ObjectSerializer;
import org.eclipse.fx.core.adapter.Adapt;
import org.eclipse.fx.core.adapter.AdapterService;
import org.eclipse.fx.core.adapter.AdapterService.ValueAccess;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.service.component.annotations.Component;

/**
 * Supplier working for {@link Adapt}
 */
@SuppressWarnings("restriction")
@Component(service=ExtendedObjectSupplier.class,property="dependency.injection.annotation:String=org.eclipse.fx.core.adapter.Adapt")
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

		ContextObjectSupplier primary = (ContextObjectSupplier) r.getPrimarySupplier();
		ContextObjectSupplier temp = (ContextObjectSupplier) r.getTempSupplier();

		IEclipseContext primaryContext = primary.getContext();
		IEclipseContext tempContext = temp != null ? temp.getContext() : null;

		if( track ) {
			primaryContext.runAndTrack(new RunAndTrack() {

				@Override
				public boolean changed(IEclipseContext context) {
					if( i.getAndIncrement() == 1 ) {
						requestor.resolveArguments(false);
						requestor.execute();
						return false;
					}
					ref.set(primaryContext.get(key));
					return true;
				}
			});
		} else {
			ref.set(primaryContext.get(key));
			if( ref.get() == null && tempContext != null ) {
				ref.set(tempContext.get(key));
			}
		}
		if( ref.get() != null ) {
			AdapterService adapterService = primaryContext.get(AdapterService.class);
			if( adapterService.canAdapt(ref.get(), desiredClass) ) {
				return adapterService.adapt(ref.get(), desiredClass, new ValueAccessImpl(primaryContext));
			}
		}

		try {
			Object object = ref.get();
			System.err.println("====> value: " + object);
			if( object instanceof String ) {
				ObjectSerializer s = primaryContext.get(ObjectSerializer.class);
				Type desiredType = descriptor.getDesiredType();
				if (desiredType instanceof ParameterizedType) {
					ParameterizedType t = (ParameterizedType) desiredType;
					if (t.getRawType() == Set.class) {
						return s.deserializeCollection(Set.class, (Class<?>)t.getActualTypeArguments()[0], (String)object);
					} else if(t.getRawType() == List.class) {
						return s.deserializeCollection(List.class, (Class<?>)t.getActualTypeArguments()[0], (String)object);
					} else {
						return s.deserialize((Class<?>)desiredType, (String)object);
					}
				} else {
					return s.deserialize((Class<?>)desiredType, (String)object);
				}
			}
		} catch( Throwable t ) {
			// omit
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

		@Override
		public <O> O getValue(Class<O> key) {
			return this.context.get(key);
		}

	}
}

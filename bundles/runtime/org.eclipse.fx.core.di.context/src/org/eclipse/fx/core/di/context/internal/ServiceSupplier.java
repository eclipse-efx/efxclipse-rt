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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Named;

import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.di.IInjector;
import org.eclipse.e4.core.di.suppliers.ExtendedObjectSupplier;
import org.eclipse.e4.core.di.suppliers.IObjectDescriptor;
import org.eclipse.e4.core.di.suppliers.IRequestor;
import org.eclipse.e4.core.internal.contexts.ContextObjectSupplier;
import org.eclipse.e4.core.internal.di.Requestor;
import org.eclipse.fx.core.di.Service;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Component;

/**
 * Supplier for {@link Service}
 *
 * @since 1.2
 */
@SuppressWarnings("restriction")
@Component(service=ExtendedObjectSupplier.class,property="dependency.injection.annotation:String=org.eclipse.fx.core.di.Service")
public class ServiceSupplier extends ExtendedObjectSupplier {

	static class ServiceHandler implements ServiceListener {
		private final IRequestor requestor;
		private final BundleContext bundleContext;
		private final Class<?> type;

		public ServiceHandler(IRequestor requestor, BundleContext bundleContext, Class<?> type) {
			this.requestor = requestor;
			this.bundleContext = bundleContext;
			this.type = type;
		}

		@Override
		public void serviceChanged(ServiceEvent event) {
			if (!this.requestor.isValid()) {
				this.bundleContext.removeServiceListener(this);
				return;
			}

			String[] data = (String[]) event.getServiceReference().getProperty(Constants.OBJECTCLASS);
			for (String d : data) {
				if (this.type.getName().equals(d)) {
					this.requestor.resolveArguments(false);
					break;
				} else if( d.equals(IContextFunction.SERVICE_NAME) && this.type.getName().equals(event.getServiceReference().getProperty(IContextFunction.SERVICE_CONTEXT_KEY)) ) {
					this.requestor.resolveArguments(false);
					break;
				}
			}
		}
	}

	@Override
	public Object get(IObjectDescriptor descriptor, IRequestor requestor, boolean track, boolean group) {
		Type desiredType = descriptor.getDesiredType();
		Bundle b = FrameworkUtil.getBundle(requestor.getRequestingObjectClass());

		if (desiredType instanceof ParameterizedType) {
			ParameterizedType t = (ParameterizedType) desiredType;
			if (t.getRawType() == Collections.class || t.getRawType() == List.class) {

				return handleCollection(b, t.getActualTypeArguments()[0], requestor, track && descriptor.getQualifier(Service.class).dynamic());
			}
		}

		return handleSingle(b, desiredType, requestor, descriptor, track && descriptor.getQualifier(Service.class).dynamic());
	}

	private Object handleSingle(Bundle bundle, Type t, IRequestor requestor, IObjectDescriptor descriptor, boolean track) {
		BundleContext context = bundle.getBundleContext();
		if (context == null) {
			context = FrameworkUtil.getBundle(getClass()).getBundleContext();
		}

		@SuppressWarnings("unchecked")
		Class<Object> cl = t instanceof ParameterizedType ? (Class<Object>) ((ParameterizedType) t).getRawType() : (Class<Object>) t;
		try {
			{
				ServiceReference<?>[] serviceReferences = context.getServiceReferences(cl.getName(), null);
				if( serviceReferences != null ) {
					Arrays.sort(serviceReferences);

					if( serviceReferences.length > 0 ) {
						return context.getService(serviceReferences[0]);
					}
				}
			}

			Requestor<?> rr = (Requestor<?>) requestor;
			ContextObjectSupplier cp = (ContextObjectSupplier) rr.getPrimarySupplier();

			Collection<ServiceReference<IContextFunction>> serviceReferences = context.getServiceReferences(IContextFunction.class, null);
			List<ServiceReference<IContextFunction>> l = new ArrayList<>(serviceReferences);
			Collections.sort(l);
			for( ServiceReference<IContextFunction> r : l ) {
				if( cl.getName().equals(r.getProperty(SERVICE_CONTEXT_KEY)) ) {
					Named qualifier = descriptor.getQualifier(Named.class);
					return context.getService(r).compute(cp.getContext(), qualifier == null ? cl.getName() : qualifier.value());
				}
			}

			if( track ) {
				context.addServiceListener(new ServiceHandler(requestor, context, cl));
			}
		} catch (InvalidSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return IInjector.NOT_A_VALUE;
	}

	private List<Object> handleCollection(Bundle bundle, Type t, IRequestor requestor, boolean track) {
		List<Object> rv = new ArrayList<>();

		BundleContext context = bundle.getBundleContext();
		if (context == null) {
			context = FrameworkUtil.getBundle(getClass()).getBundleContext();
		}

		@SuppressWarnings("unchecked")
		Class<Object> cl = t instanceof ParameterizedType ? (Class<Object>) ((ParameterizedType) t).getRawType() : (Class<Object>) t;
		try {
			ServiceReference<?>[] serviceReferences = context.getServiceReferences(cl.getName(), null);
			if( serviceReferences != null ) {
				Arrays.sort(serviceReferences);

				for (ServiceReference<?> serviceReference : serviceReferences) {
					rv.add(context.getService(serviceReference));
					if( track ) {
						context.addServiceListener(new ServiceHandler(requestor, context, cl));
					}
				}
			}
		} catch (InvalidSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rv;
	}
}

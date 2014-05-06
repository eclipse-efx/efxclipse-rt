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
package org.eclipse.fx.core.di.context.tests;

import java.util.Hashtable;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.adapter.Adapt;
import org.eclipse.fx.core.adapter.AdapterProvider;
import org.eclipse.fx.core.adapter.AdapterService.ValueAccess;
import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;

/**
 * 
 */
public class AdaptSupplierTestCase {
	static class Bean {
		@Inject
		@Adapt
		@Named("test")
		Integer integerValue;
		
		@Inject
		@Adapt
		@Named("test")
		Double doubleValue;
	}
	
	/**
	 * 
	 */
	@Test
	public void testAdapt() {
		BundleContext context = FrameworkUtil.getBundle(getClass()).getBundleContext();
		ServiceRegistration<AdapterProvider> r1 = context.registerService(AdapterProvider.class, new StringIntegerProvider(), new Hashtable<String,Object>());
		ServiceRegistration<AdapterProvider> r2 = context.registerService(AdapterProvider.class, new StringDoubleProvider(), new Hashtable<String,Object>());
		
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(context);
		serviceContext.set("test", "12");  //$NON-NLS-1$//$NON-NLS-2$
		Bean bean = ContextInjectionFactory.make(Bean.class, serviceContext);
		
		Assert.assertEquals(12,bean.integerValue.intValue());
		Assert.assertEquals(12.0,bean.doubleValue.doubleValue(),0.0);
		
		serviceContext.set("test", "14");

		Assert.assertEquals(14,bean.integerValue.intValue());
		Assert.assertEquals(14.0,bean.doubleValue.doubleValue(),0.0);

		serviceContext.set("test", "15");

		Assert.assertEquals(15,bean.integerValue.intValue());
		Assert.assertEquals(15.0,bean.doubleValue.doubleValue(),0.0);
		
		r1.unregister();
		r2.unregister();
	}
	
	static class StringIntegerProvider implements AdapterProvider<String, Integer> {

		@Override
		public Class<String> getSourceType() {
			return String.class;
		}

		@Override
		public Class<Integer> getTargetType() {
			return Integer.class;
		}

		@Override
		public boolean canAdapt(String sourceObject, Class<Integer> targetType) {
			try {
				Integer.parseInt(sourceObject);
				return true;
			} catch(Exception e) {
				// nothing
			}
			
			return false;
		}

		@Override
		public Integer adapt(String sourceObject, Class<Integer> targetType, ValueAccess... valueAccess) {
			return Integer.valueOf(sourceObject);
		}
	}
	
	static class StringDoubleProvider implements AdapterProvider<String, Double> {

		@Override
		public Class<String> getSourceType() {
			return String.class;
		}

		@Override
		public Class<Double> getTargetType() {
			return Double.class;
		}

		@Override
		public boolean canAdapt(String sourceObject, Class<Double> targetType) {
			try {
				Double.parseDouble(sourceObject);
				return true;
			} catch(Exception e) {
				// nothing
			}
			
			return false;
		}

		@Override
		public Double adapt(String sourceObject, Class<Double> targetType, ValueAccess... valueAccess) {
			return Double.valueOf(sourceObject);
		}
	}
}

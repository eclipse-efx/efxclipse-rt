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

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.fx.core.ObjectSerializer;
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

		@Inject
		@Adapt
		@Named("serializedObject")
		Pojo pojo;

		@Inject
		@Adapt
		@Named("serializedList")
		List<Pojo> pojoList;

		@Inject
		@Adapt
		@Named("serializedSet")
		Set<Pojo> pojoSet;

		@Inject
		@Adapt
		@Named("valueSerializer")
		LocalDateTime dateTime;

		int executeCalled;

		@Execute
		public void callMe(@Adapt @Named("test") Double doubleValue) {
			this.executeCalled++;
		}
	}

	@XmlRootElement
	public static class Pojo {
		private String value;

		public Pojo(String value) {
			this.value = value;
		}

		public Pojo() {
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pojo other = (Pojo) obj;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}
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
		ObjectSerializer serializer = serviceContext.get(ObjectSerializer.class);
		Pojo pojo = new Pojo("Pojo 1");
		serviceContext.set("serializedObject", serializer.serialize(pojo));
		serviceContext.set("serializedList",serializer.serializeCollection(Arrays.asList(new Pojo("Pojo 2")), Pojo.class)); //$NON-NLS-2$
		serviceContext.set("serializedSet", serializer.serializeCollection(Collections.singleton(new Pojo("Pojo 3")), Pojo.class)); //$NON-NLS-2$
		LocalDateTime dateTime = LocalDateTime.now();
		serviceContext.set("valueSerializer", dateTime.toString());
		serviceContext.set("test", "12");  //$NON-NLS-1$//$NON-NLS-2$

		Bean bean = ContextInjectionFactory.make(Bean.class, serviceContext);

		Assert.assertEquals(12,bean.integerValue.intValue());
		Assert.assertEquals(12.0,bean.doubleValue.doubleValue(),0.0);

		Assert.assertNotNull(bean.pojo);
		Assert.assertNotSame(pojo, bean.pojo);

		Assert.assertNotNull(bean.pojoList);
		Assert.assertEquals(1, bean.pojoList.size());

		Assert.assertNotNull(bean.pojoSet);
		Assert.assertEquals(1, bean.pojoSet.size());

		Assert.assertNotNull(bean.dateTime);
		Assert.assertEquals(bean.dateTime, dateTime);

		serviceContext.set("test", "14");

		Assert.assertEquals(14,bean.integerValue.intValue());
		Assert.assertEquals(14.0,bean.doubleValue.doubleValue(),0.0);

		serviceContext.set("test", "15");

		Assert.assertEquals(15,bean.integerValue.intValue());
		Assert.assertEquals(15.0,bean.doubleValue.doubleValue(),0.0);

		ContextInjectionFactory.invoke(bean, Execute.class, serviceContext);
		Assert.assertEquals(1,bean.executeCalled);

		serviceContext.set("test", "16");
		Assert.assertEquals(1,bean.executeCalled);

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

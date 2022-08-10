/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;

/**
 *
 */
public class AdaptSupplierTestCase {
	private ServiceRegistration<AdapterProvider> r1;
	private ServiceRegistration<AdapterProvider> r2;
	private IEclipseContext testContext;
	private static IEclipseContext SERVICE_CONTEXT;

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

		Double callMeValue;

		@Execute
		public void callMe(@Adapt @Named("test") Double doubleValue) {
			this.callMeValue = doubleValue;
			this.executeCalled++;
		}
	}

	public static class Bug510916 {
		int executeCalled;
		Double callMeValue;

		@Execute
		public void callMe(@Adapt @Named("bug510916") Double doubleValue) {
			this.callMeValue = doubleValue;
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

	@BeforeClass
	public static void init() {
		BundleContext context = FrameworkUtil.getBundle(AdaptSupplierTestCase.class).getBundleContext();
		SERVICE_CONTEXT = EclipseContextFactory.createServiceContext(context);
	}

	@Before
	public void setup() {
		BundleContext context = FrameworkUtil.getBundle(getClass()).getBundleContext();
		this.r1 = context.registerService(AdapterProvider.class, new StringIntegerProvider(), new Hashtable<String,Object>());
		this.r2 = context.registerService(AdapterProvider.class, new StringDoubleProvider(), new Hashtable<String,Object>());
		this.testContext = SERVICE_CONTEXT.createChild("Test Context");
	}

	@After
	public void cleanup() {
		this.r1.unregister();
		this.r2.unregister();
		this.testContext.dispose();
	}

	@AfterClass
	public static void shutdown() {
		SERVICE_CONTEXT.dispose();
	}

	/**
	 *
	 */
	@Test
	public void testAdapt() {
		ObjectSerializer serializer = testContext.get(ObjectSerializer.class);
		Pojo pojo = new Pojo("Pojo 1");
		testContext.set("serializedObject", serializer.serialize(pojo));
		testContext.set("serializedList",serializer.serializeCollection(Arrays.asList(new Pojo("Pojo 2")), Pojo.class)); //$NON-NLS-2$
		testContext.set("serializedSet", serializer.serializeCollection(Collections.singleton(new Pojo("Pojo 3")), Pojo.class)); //$NON-NLS-2$
		LocalDateTime dateTime = LocalDateTime.now();
		testContext.set("valueSerializer", dateTime.toString());
		testContext.set("test", "12");  //$NON-NLS-1$//$NON-NLS-2$

		Bean bean = ContextInjectionFactory.make(Bean.class, testContext);

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

		testContext.set("test", "14");

		Assert.assertEquals(14,bean.integerValue.intValue());
		Assert.assertEquals(14.0,bean.doubleValue.doubleValue(),0.0);

		testContext.set("test", "15");

		Assert.assertEquals(15,bean.integerValue.intValue());
		Assert.assertEquals(15.0,bean.doubleValue.doubleValue(),0.0);

		ContextInjectionFactory.invoke(bean, Execute.class, testContext);
		Assert.assertEquals(1,bean.executeCalled);
		Assert.assertEquals(15.0, bean.callMeValue.doubleValue(),0.0);

		testContext.set("test", "16");
		Assert.assertEquals(1,bean.executeCalled);
		Assert.assertEquals(15.0, bean.callMeValue.doubleValue(),0.0);

		ContextInjectionFactory.invoke(bean, Execute.class, testContext);
		Assert.assertEquals(2,bean.executeCalled);
		Assert.assertEquals(16.0, bean.callMeValue.doubleValue(),0.0);

	}

	@Test
	public void testBug510916() {
		IEclipseContext staticContext = EclipseContextFactory.create("Static Context"); //$NON-NLS-1$
		staticContext.set("bug510916", "17");  //$NON-NLS-1$//$NON-NLS-2$

		Bug510916 bean = ContextInjectionFactory.make(Bug510916.class, this.testContext);
		ContextInjectionFactory.invoke(bean, Execute.class, this.testContext, staticContext, null);

		Assert.assertEquals(1,bean.executeCalled);
		Assert.assertEquals(17.0, bean.callMeValue.doubleValue(),0.0);

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

/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di.context.tests;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.fx.core.di.LocalInstance;
import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.FrameworkUtil;

public class LocalInstanceTestCase {

	public static class MyTest {
		public boolean postConstruct;
		public boolean preDestroy;

		@PostConstruct
		void postConstruct() {
			this.postConstruct = true;
		}

		@PreDestroy
		void preDestory() {
			this.preDestroy = true;
		}
	}

	public interface SampleInterface {

	}

	public static class TestBean {
		@Inject
		@LocalInstance
		MyTest test;

		@Inject
		@Optional
		SampleInterface i;
	}

	/**
	 *
	 */
	@Test
	public void testTypeInstantiation() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());

		IEclipseContext child = serviceContext.createChild();
		TestBean bean = ContextInjectionFactory.make(TestBean.class, child);
		Assert.assertNotNull(bean);
		Assert.assertNotNull(bean.test);
		Assert.assertNull(bean.i);
		Assert.assertTrue(bean.test.postConstruct);
		Assert.assertFalse(bean.test.preDestroy);

		child.dispose();
		Assert.assertTrue(bean.test.preDestroy);
	}
}

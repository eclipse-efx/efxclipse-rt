package org.eclipse.fx.core.di.context.tests;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.di.Service;
import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

public class ServiceSupplierTestCase {
	public static class TestBean {
		TestService service;
		List<TestService> serviceList;

		@Inject
		public void setService(@Service TestService service) {
			this.service = service;
		}

		@Inject
		public void setServiceList(@Service List<TestService> serviceList) {
			this.serviceList = serviceList;
		}
	}

	@Test
	public void testInitialInject() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		TestBean bean = ContextInjectionFactory.make(TestBean.class, serviceContext);
		Assert.assertNotNull(bean.service);
		Assert.assertNotNull(bean.serviceList);
		Assert.assertSame(SampleServiceA.class,bean.service.getClass());
		Assert.assertEquals(2, bean.serviceList.size());
		Assert.assertSame(SampleServiceA.class,bean.serviceList.get(0).getClass());
		Assert.assertSame(SampleServiceB.class,bean.serviceList.get(1).getClass());
	}
}

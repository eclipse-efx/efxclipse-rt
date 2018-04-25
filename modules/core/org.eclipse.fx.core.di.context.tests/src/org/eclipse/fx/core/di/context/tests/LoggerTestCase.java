package org.eclipse.fx.core.di.context.tests;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.log.FluentLogger;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.junit.Test;
import org.osgi.framework.FrameworkUtil;

public class LoggerTestCase {
	public static class LogTestBean {
		@Inject
		@Log
		Logger logger;
		
		@Inject
		@Log
		FluentLogger fLogger;
	}
	
	@Test
	public void testLogger() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());

		IEclipseContext child = serviceContext.createChild();
		LogTestBean bean = ContextInjectionFactory.make(LogTestBean.class, child);
		assertNotNull(bean.logger);
		assertNotNull(bean.fLogger);		
	}
}

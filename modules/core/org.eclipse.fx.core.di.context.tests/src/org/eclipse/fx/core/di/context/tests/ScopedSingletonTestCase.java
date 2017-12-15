/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di.context.tests;

import java.util.Optional;

import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.di.context.ScopedSingletonFunction;
import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.FrameworkUtil;

public class ScopedSingletonTestCase {
	static class ContextHolder {
		final IEclipseContext context;
		
		public ContextHolder(IEclipseContext context) {
			this.context = context;
		}
	}
	
	@Test
	public void testScopedSingleton() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		serviceContext.set("singletonValue", new ScopedSingletonFunction<ContextHolder>() { //$NON-NLS-1$

			@Override
			protected Optional<IEclipseContext> computeSingletonContext(IEclipseContext context) {
				IEclipseContext localContext = context;
				do {
					if( Boolean.TRUE.equals(localContext.getLocal("singletonTarget")) ) { //$NON-NLS-1$
						return Optional.of(localContext);
					}
				} while( (localContext = localContext.getParent()) != null );
				
				return Optional.empty();
			}

			@Override
			protected ContextHolder create(IEclipseContext context) {
				return new ContextHolder(context);
			}
			
		});
		
		IEclipseContext singletonTarget = serviceContext.createChild();
		singletonTarget.set("singletonTarget", Boolean.TRUE);
		
		IEclipseContext childContext = singletonTarget.createChild();
		IEclipseContext siblingContext = singletonTarget.createChild();
		IEclipseContext subSiblingContext = siblingContext.createChild();
		
		ContextHolder value = (ContextHolder) childContext.get("singletonValue");
		Assert.assertNotNull(value);
		Assert.assertSame(singletonTarget, value.context);
		
		ContextHolder value2 = (ContextHolder) siblingContext.get("singletonValue");
		Assert.assertNotNull(value2);
		Assert.assertSame(singletonTarget, value2.context);
		
		ContextHolder value3 = (ContextHolder) subSiblingContext.get("singletonValue");
		Assert.assertNotNull(value3);
		Assert.assertSame(singletonTarget, value3.context);
		
		Assert.assertSame(value, value2);
		Assert.assertSame(value, value3);
	}
}

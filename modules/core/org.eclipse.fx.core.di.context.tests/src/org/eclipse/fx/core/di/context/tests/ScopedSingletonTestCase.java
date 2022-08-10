/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
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

import java.util.Optional;

import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.di.context.ScopedSingletonFunction;
import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.FrameworkUtil;

public class ScopedSingletonTestCase {
	private static final String SINGLETON_TARGET = "singletonTarget"; //$NON-NLS-1$
	private static final String SINGLETON_VALUE = "singletonValue"; //$NON-NLS-1$

	static class ContextHolder {
		final IEclipseContext context;
		
		public ContextHolder(IEclipseContext context) {
			this.context = context;
		}
	}
	
	@Test
	public void testScopedSingleton() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		serviceContext.set(SINGLETON_VALUE, createExampleContextFunction());
		
		IEclipseContext singletonTarget = serviceContext.createChild();
		singletonTarget.set(SINGLETON_TARGET, Boolean.TRUE);
		
		IEclipseContext childContext = singletonTarget.createChild();
		IEclipseContext siblingContext = singletonTarget.createChild();
		IEclipseContext subSiblingContext = siblingContext.createChild();
		
		ContextHolder value = (ContextHolder) childContext.get(SINGLETON_VALUE);
		Assert.assertNotNull(value);
		Assert.assertSame(singletonTarget, value.context);
		
		ContextHolder value2 = (ContextHolder) siblingContext.get(SINGLETON_VALUE);
		Assert.assertNotNull(value2);
		Assert.assertSame(singletonTarget, value2.context);
		
		ContextHolder value3 = (ContextHolder) subSiblingContext.get(SINGLETON_VALUE);
		Assert.assertNotNull(value3);
		Assert.assertSame(singletonTarget, value3.context);
		
		Assert.assertSame(value, value2);
		Assert.assertSame(value, value3);
	}
	
	/**
	 * Tests the ScopedSingletonFunction in a hierarchy, where a sub context is also defined as a Singleton Context.
	 */
	@Test
	public void testScopedSingletonInHierarchy() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		serviceContext.set(SINGLETON_VALUE, createExampleContextFunction());
		
		IEclipseContext singletonTarget = serviceContext.createChild();
		singletonTarget.set(SINGLETON_TARGET, Boolean.TRUE);
		
		IEclipseContext childContext = singletonTarget.createChild();
		
		IEclipseContext siblingSingletonTargetContext = singletonTarget.createChild();
		siblingSingletonTargetContext.set(SINGLETON_TARGET, Boolean.TRUE);
		
		IEclipseContext subSiblingSingletonTargetContext = siblingSingletonTargetContext.createChild();
		
		ContextHolder value = (ContextHolder) childContext.get(SINGLETON_VALUE);
		Assert.assertNotNull(value);
		Assert.assertSame(singletonTarget, value.context);
		
		ContextHolder value2 = (ContextHolder) siblingSingletonTargetContext.get(SINGLETON_VALUE);
		Assert.assertNotNull(value2);
		Assert.assertSame(siblingSingletonTargetContext, value2.context);
		
		ContextHolder value3 = (ContextHolder) subSiblingSingletonTargetContext.get(SINGLETON_VALUE);
		Assert.assertNotNull(value3);
		Assert.assertSame(siblingSingletonTargetContext, value3.context);
		
		Assert.assertSame(value2, value3);
	}

	private static ScopedSingletonFunction<ContextHolder> createExampleContextFunction() {
		return new ScopedSingletonFunction<ContextHolder>() { 

			@Override
			protected Optional<IEclipseContext> computeSingletonContext(IEclipseContext context) {
				IEclipseContext localContext = context;
				do {
					if( Boolean.TRUE.equals(localContext.getLocal(SINGLETON_TARGET)) ) { 
						return Optional.of(localContext);
					}
				} while( (localContext = localContext.getParent()) != null );
				
				return Optional.empty();
			}

			@Override
			protected ContextHolder create(IEclipseContext context) {
				return new ContextHolder(context);
			}
			
		};
	}
}

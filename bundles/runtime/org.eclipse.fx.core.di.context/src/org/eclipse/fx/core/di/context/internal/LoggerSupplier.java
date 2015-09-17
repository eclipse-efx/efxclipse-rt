/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di.context.internal;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.suppliers.ExtendedObjectSupplier;
import org.eclipse.e4.core.di.suppliers.IObjectDescriptor;
import org.eclipse.e4.core.di.suppliers.IRequestor;
import org.eclipse.e4.core.internal.contexts.ContextObjectSupplier;
import org.eclipse.e4.core.internal.di.Requestor;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.LoggerFactory;
import org.osgi.service.component.annotations.Component;

import com.google.common.base.Strings;

/**
 * DI Extension to inject {@link Log} into your DI-Bean
 */
@SuppressWarnings("restriction")
@Component(service=ExtendedObjectSupplier.class,property="dependency.injection.annotation:String=org.eclipse.fx.core.log.Log")
public class LoggerSupplier extends ExtendedObjectSupplier {

	@Override
	public Object get(IObjectDescriptor descriptor, IRequestor requestor, boolean track, boolean group) {
		Requestor<?> req = (Requestor<?>) requestor;
		ContextObjectSupplier sub = (ContextObjectSupplier) req
				.getPrimarySupplier();
		final IEclipseContext context = sub.getContext();

		String loggerName = descriptor.getQualifier(Log.class).value();

		if( Strings.isNullOrEmpty(loggerName) ) {
			loggerName = requestor.getRequestingObjectClass().getName();
		}

		if( loggerName == null ) {
			loggerName = "AnonymousLogger"; //$NON-NLS-1$
		}

		return context.get(LoggerFactory.class).createLogger(loggerName);
	}

}
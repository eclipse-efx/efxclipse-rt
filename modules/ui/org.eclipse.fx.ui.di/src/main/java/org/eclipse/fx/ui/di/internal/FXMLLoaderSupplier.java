/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.di.internal;

import java.io.InputStream;
import java.net.URL;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.IInjector;
import org.eclipse.e4.core.di.suppliers.ExtendedObjectSupplier;
import org.eclipse.e4.core.di.suppliers.IObjectDescriptor;
import org.eclipse.e4.core.di.suppliers.IRequestor;
import org.eclipse.e4.core.internal.contexts.ContextObjectSupplier;
import org.eclipse.e4.core.internal.di.Requestor;
import org.eclipse.fx.ui.di.FXMLBuilder;
import org.eclipse.fx.ui.di.FXMLLoader;
import org.eclipse.fx.ui.di.FXMLLoaderFactory;
import org.eclipse.fx.ui.di.InjectingFXMLLoader;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.component.annotations.Component;

/**
 * DI Supplier to inject {@link FXMLLoader} into your DI-Bean
 */
@SuppressWarnings("restriction")
@Component(service=ExtendedObjectSupplier.class,property="dependency.injection.annotation:String=org.eclipse.fx.ui.di.FXMLLoader")
public class FXMLLoaderSupplier extends ExtendedObjectSupplier {

	@Override
	public Object get(IObjectDescriptor descriptor, IRequestor requestor, boolean track, boolean group) {
		Requestor<?> req = (Requestor<?>) requestor;
		ContextObjectSupplier sub = (ContextObjectSupplier) req.getPrimarySupplier();
		final IEclipseContext context = sub.getContext();
		final Class<?> requestingClass = requestor.getRequestingObjectClass();
		if( context == null || requestingClass == null ) {
			return IInjector.NOT_A_VALUE;
		}
		final boolean extended = descriptor.getQualifier(FXMLLoader.class).useExtendedLoader();

		return new FXMLLoaderFactory() {

			@Override
			public <N> FXMLBuilder<N> loadRequestorRelative(@NonNull String relativePath) {
				return InjectingFXMLLoader.create(context, requestingClass, relativePath, extended);
			}

			@SuppressWarnings("null")
			@Override
			public <N> FXMLBuilder<N> loadBundleRelative(@NonNull String relativePath) {
				return InjectingFXMLLoader.create(context, FrameworkUtil.getBundle(requestingClass), relativePath, extended);
			}

			@SuppressWarnings("null")
			@Override
			public <N> @NonNull FXMLBuilder<N> loadFromInputStream(@NonNull InputStream stream, @Nullable URL path) {
				return InjectingFXMLLoader.create(context, requestingClass.getClassLoader(), stream, path);
			}

			@SuppressWarnings("null")
			@Override
			public <N> @NonNull FXMLBuilder<N> loadFromURL(@NonNull URL url) {
				return InjectingFXMLLoader.create(context, requestingClass.getClassLoader(), url);
			}
		};
	}

}

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
package org.eclipse.fx.ui.di;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.util.BuilderFactory;
import javafx.util.Callback;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.osgi.util.OSGiFXMLLoader;
import org.osgi.framework.Bundle;


@SuppressWarnings("restriction")
public abstract class InjectingFXMLLoader<N> implements FXMLBuilder<N> {
	ResourceBundle resourceBundle;
	BuilderFactory builderFactory;
	
	public static <N> InjectingFXMLLoader<N> create(final IEclipseContext context, final Class<?> requester, final String relativeFxmlPath) {
		return new InjectingFXMLLoader<N>() {

			public N load() throws IOException {
				return OSGiFXMLLoader.load(requester, relativeFxmlPath, resourceBundle, builderFactory, new ControllerFactory(context));
			}
			
		};
	}
	
	public static <N> InjectingFXMLLoader<N> create(final IEclipseContext context, final Bundle bundle, final String bundleRelativeFxmlPath) {
		return new InjectingFXMLLoader<N>() {

			public N load() throws IOException {
				return OSGiFXMLLoader.load(bundle, bundleRelativeFxmlPath, resourceBundle, builderFactory, new ControllerFactory(context));
			}
			
		};
	}
	
	public static <N> InjectingFXMLLoader<N> create(final IEclipseContext context, final ClassLoader classloader, final URL url) {
		return new InjectingFXMLLoader<N>() {

			public N load() throws IOException {
				return OSGiFXMLLoader.load(classloader, url, resourceBundle, builderFactory, new ControllerFactory(context));
			}
			
		};
	}
	
	public InjectingFXMLLoader<N> resourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
		return this;
	}
	
	public InjectingFXMLLoader<N> builderFactory(BuilderFactory builderFactory) {
		this.builderFactory = builderFactory;
		return this;
	}
	
	static class ControllerFactory implements Callback<Class<?>, Object> {

		private final IEclipseContext context;
		
		public ControllerFactory(IEclipseContext context) {
			this.context = context;
		}
		
		public Object call(Class<?> param) {
			Object o;
			if( param.isInterface() || (param.getModifiers() & Modifier.ABSTRACT) == Modifier.ABSTRACT ) {
				o = context.get(param.getName());
			} else {
				o = ContextInjectionFactory.make(param, context);
				context.set(o.getClass().getName(), o);
			}
			
			return o;
		}
		
	}
}

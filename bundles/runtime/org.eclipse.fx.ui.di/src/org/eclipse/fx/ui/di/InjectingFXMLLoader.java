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
import org.eclipse.fx.core.fxml.ExtendedFXMLLoader;
import org.eclipse.fx.osgi.util.OSGiFXMLLoader;
import org.eclipse.fx.osgi.util.OSGiFXMLLoader.FXMLData;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.wiring.BundleWire;
import org.osgi.framework.wiring.BundleWiring;


public abstract class InjectingFXMLLoader<N> implements FXMLBuilder<N> {
	ResourceBundle resourceBundle;
	BuilderFactory builderFactory;
	
	public static <N> InjectingFXMLLoader<N> create(final IEclipseContext context, final Class<?> requester, final String relativeFxmlPath) {
		return create(context, requester, relativeFxmlPath, false);
	}
	
	public static <N> InjectingFXMLLoader<N> create(final IEclipseContext context, final Class<?> requester, final String relativeFxmlPath, boolean useExtendedFXMLLoader) {
		if( useExtendedFXMLLoader ) {
			return create(context, FrameworkUtil.getBundle(requester), requester.getName().substring(0, requester.getName().lastIndexOf('.')).replace('.', '/')+"/" + relativeFxmlPath, useExtendedFXMLLoader); //$NON-NLS-1$
		} else {
			return new InjectingFXMLLoader<N>() {

				@Override
				public N load() throws IOException {
					return OSGiFXMLLoader.load(requester, relativeFxmlPath, this.resourceBundle, this.builderFactory, new ControllerFactory(context));
				}
				
				@Override
				public <C> Data<N,C> loadWithController() throws IOException {
					final FXMLData<N, C> d = OSGiFXMLLoader.loadWithController(requester, relativeFxmlPath, this.resourceBundle, this.builderFactory, new ControllerFactory(context));
					return new Data<N, C>() {
						@Override
						public C getController() {
							return d.controller;
						}
						
						@Override
						public N getNode() {
							return d.node;
						}
					};
				}
			};
		}
	}
	
	public static <N> InjectingFXMLLoader<N> create(final IEclipseContext context, final Bundle bundle, final String bundleRelativeFxmlPath) {
		return create(context, bundle, bundleRelativeFxmlPath, false);
	}
	
	public static <N> InjectingFXMLLoader<N> create(final IEclipseContext context, final Bundle bundle, final String bundleRelativeFxmlPath, boolean useExtendedFXMLLoader) {
		if( useExtendedFXMLLoader ) {
			final ExtendedFXMLLoader l = new ExtendedFXMLLoader();
			
			return new InjectingFXMLLoader<N>() {

				@Override
				public N load() throws IOException {
					return l.<N,Object>loadWithController(bundle.adapt(BundleWiring.class).getClassLoader(), resourceBundle, new ControllerFactory(context), bundleRelativeFxmlPath).getNode();
				}

				@Override
				public <C> org.eclipse.fx.ui.di.FXMLBuilder.Data loadWithController()
						throws IOException {
					final org.eclipse.fx.core.fxml.ExtendedFXMLLoader.Data<N, C> data = l.<N,C>loadWithController(bundle.adapt(BundleWiring.class).getClassLoader(), resourceBundle, new ControllerFactory(context), bundleRelativeFxmlPath);
					return new Data<N, C>() {

						@Override
						public N getNode() {
							return data.getNode();
						}

						@Override
						public C getController() {
							return data.getController();
						}
					};
				}
			};
		} else {
			return new InjectingFXMLLoader<N>() {

				@Override
				public N load() throws IOException {
					return OSGiFXMLLoader.load(bundle, bundleRelativeFxmlPath, this.resourceBundle, this.builderFactory, new ControllerFactory(context));
				}
				
				@Override
				public <C> Data<N,C> loadWithController() throws IOException {
					final FXMLData<N, C> d = OSGiFXMLLoader.loadWithController(bundle, bundleRelativeFxmlPath, this.resourceBundle, this.builderFactory, new ControllerFactory(context));
					return new Data<N, C>() {
						@Override
						public C getController() {
							return d.controller;
						}
						
						@Override
						public N getNode() {
							return d.node;
						}
					};
				}
			};
		}
	}
	
	public static <N> InjectingFXMLLoader<N> create(final IEclipseContext context, final ClassLoader classloader, final URL url) {
		return new InjectingFXMLLoader<N>() {

			@Override
			public N load() throws IOException {
				return OSGiFXMLLoader.load(classloader, url, this.resourceBundle, this.builderFactory, new ControllerFactory(context));
			}
			
			@Override
			public <C> Data<N,C> loadWithController() throws IOException {
				final FXMLData<N, C> d = OSGiFXMLLoader.loadWithController(classloader, url, this.resourceBundle, this.builderFactory, new ControllerFactory(context));
				return new Data<N, C>() {
					@Override
					public C getController() {
						return d.controller;
					}
					
					@Override
					public N getNode() {
						return d.node;
					}
				};
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

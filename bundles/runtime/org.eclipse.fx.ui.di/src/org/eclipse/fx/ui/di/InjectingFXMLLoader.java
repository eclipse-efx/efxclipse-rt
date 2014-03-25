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
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.wiring.BundleWiring;

/**
 * Allows to use Eclipse DI inside your controller to access services
 * 
 * @param <N>
 *            the root node
 */
public abstract class InjectingFXMLLoader<N> implements FXMLBuilder<N> {
	ResourceBundle resourceBundle;
	BuilderFactory builderFactory;

	/**
	 * Create a loader which operates relative to the requestor
	 * 
	 * @param context
	 *            the di context
	 * @param requester
	 *            the requestor
	 * @param relativeFxmlPath
	 *            the relative path
	 * @return the loader
	 */
	@NonNull
	public static <N> InjectingFXMLLoader<N> create(
			@NonNull final IEclipseContext context,
			@NonNull final Class<?> requester,
			@NonNull final String relativeFxmlPath) {
		return create(context, requester, relativeFxmlPath, false);
	}

	/**
	 * Create a loader which operates relative to the requestor and uses the
	 * {@link ExtendedFXMLLoader} if requested to do so
	 * 
	 * @param context
	 *            the di context
	 * @param requester
	 *            the requestor
	 * @param relativeFxmlPath
	 *            the relative path
	 * @param useExtendedFXMLLoader
	 *            <code>true</code> to use the {@link ExtendedFXMLLoader}
	 * @return the loader
	 */
	@NonNull
	public static <N> InjectingFXMLLoader<N> create(
			@NonNull final IEclipseContext context,
			@NonNull final Class<?> requester,
			@NonNull final String relativeFxmlPath,
			boolean useExtendedFXMLLoader) {
		if (useExtendedFXMLLoader) {
			return create(
					context,
					FrameworkUtil.getBundle(requester),
					requester.getName()
							.substring(0, requester.getName().lastIndexOf('.'))
							.replace('.', '/')
							+ "/" + relativeFxmlPath, useExtendedFXMLLoader); //$NON-NLS-1$
		} else {
			return new InjectingFXMLLoader<N>() {

				@Override
				public N load() throws IOException {
					return OSGiFXMLLoader.load(requester, relativeFxmlPath,
							this.resourceBundle, this.builderFactory,
							new ControllerFactory(context));
				}

				@Override
				public <C> Data<N, C> loadWithController() throws IOException {
					final FXMLData<N, C> d = OSGiFXMLLoader
							.loadWithController(requester, relativeFxmlPath,
									this.resourceBundle, this.builderFactory,
									new ControllerFactory(context));
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

	/**
	 * Create a loader which operates relative to the bundle classpath
	 * 
	 * @param context
	 *            the di context
	 * @param bundle
	 *            the bundle
	 * @param bundleRelativeFxmlPath
	 *            the relative path in the bundle
	 * @return the loader
	 */
	public static <N> InjectingFXMLLoader<N> create(
			final IEclipseContext context, final Bundle bundle,
			final String bundleRelativeFxmlPath) {
		return create(context, bundle, bundleRelativeFxmlPath, false);
	}

	/**
	 * Create a loader which operates relative to the bundle classpath and uses
	 * the {@link ExtendedFXMLLoader} if requested to do so
	 * 
	 * @param context
	 *            the di context
	 * @param bundle
	 *            the bundle
	 * @param bundleRelativeFxmlPath
	 *            the relative path in the bundle
	 * @param useExtendedFXMLLoader
	 *            <code>true</code> to use the {@link ExtendedFXMLLoader}
	 * @return the loader
	 */
	@NonNull
	public static <N> InjectingFXMLLoader<N> create(
			@NonNull final IEclipseContext context,
			@NonNull final Bundle bundle,
			@NonNull final String bundleRelativeFxmlPath,
			boolean useExtendedFXMLLoader) {
		if (useExtendedFXMLLoader) {
			return new InjectingFXMLLoader<N>() {

				@Override
				public N load() throws IOException {
					return ExtendedFXMLLoader.<N, Object> loadWithController(
							bundle.adapt(BundleWiring.class).getClassLoader(),
							this.resourceBundle,
							new ControllerFactory(context),
							bundleRelativeFxmlPath).getNode();
				}

				@Override
				public <C> Data<N, C> loadWithController() throws IOException {
					final org.eclipse.fx.core.fxml.ExtendedFXMLLoader.Data<N, C> data = ExtendedFXMLLoader
							.<N, C> loadWithController(
									bundle.adapt(BundleWiring.class)
											.getClassLoader(),
									this.resourceBundle, new ControllerFactory(
											context), bundleRelativeFxmlPath);
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
					return OSGiFXMLLoader.load(bundle, bundleRelativeFxmlPath,
							this.resourceBundle, this.builderFactory,
							new ControllerFactory(context));
				}

				@Override
				public <C> Data<N, C> loadWithController() throws IOException {
					final FXMLData<N, C> d = OSGiFXMLLoader.loadWithController(
							bundle, bundleRelativeFxmlPath,
							this.resourceBundle, this.builderFactory,
							new ControllerFactory(context));
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

	/**
	 * Create a loader which uses the given classloader
	 * 
	 * @param context
	 *            the di context
	 * @param classloader
	 *            the classloader
	 * @param url
	 *            the url to load
	 * @return a loader instance
	 */
	@NonNull
	public static <N> InjectingFXMLLoader<N> create(
			@NonNull final IEclipseContext context, 
			@NonNull final ClassLoader classloader,
			@NonNull final URL url) {
		return new InjectingFXMLLoader<N>() {

			@Override
			public N load() throws IOException {
				return OSGiFXMLLoader.load(classloader, url,
						this.resourceBundle, this.builderFactory,
						new ControllerFactory(context));
			}

			@Override
			public <C> Data<N, C> loadWithController() throws IOException {
				final FXMLData<N, C> d = OSGiFXMLLoader.loadWithController(
						classloader, url, this.resourceBundle,
						this.builderFactory, new ControllerFactory(context));
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

	@Override
	@NonNull
	public InjectingFXMLLoader<N> resourceBundle(@NonNull ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
		return this;
	}

	@Override
	@NonNull
	public InjectingFXMLLoader<N> builderFactory(@NonNull BuilderFactory builderFactory) {
		this.builderFactory = builderFactory;
		return this;
	}

	static class ControllerFactory implements Callback<Class<?>, Object> {

		private final IEclipseContext context;

		public ControllerFactory(IEclipseContext context) {
			this.context = context;
		}

		@Override
		public Object call(Class<?> param) {
			Object o;
			if (param.isInterface()
					|| (param.getModifiers() & Modifier.ABSTRACT) == Modifier.ABSTRACT) {
				o = this.context.get(param.getName());
			} else {
				o = ContextInjectionFactory.make(param, this.context);
				this.context.set(o.getClass().getName(), o);
			}

			return o;
		}

	}
}

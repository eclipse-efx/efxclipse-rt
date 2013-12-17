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
package org.eclipse.fx.osgi.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;
import javafx.util.Callback;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.Bundle;
import org.osgi.framework.wiring.BundleWiring;

/**
 * Helper class which is able to load FXML-Files in OSGi is an easy way
 */
public class OSGiFXMLLoader {
	/**
	 * Load a FXML file relative to the requested
	 * 
	 * @param requester
	 *            the requester
	 * @param relativeFxmlPath
	 *            the relative FXML-File Path
	 * @param resourceBundle
	 *            the translation to be used
	 * @param builderFactory
	 *            the builder factory to use
	 * @return the created scene graph
	 * @throws IOException
	 */
	public static <O> O load(@NonNull Class<?> requester, @NonNull String relativeFxmlPath, @Nullable ResourceBundle resourceBundle, @Nullable BuilderFactory builderFactory) throws IOException {
		URL url = requester.getResource(relativeFxmlPath);
		ClassLoader loader = requester.getClassLoader();
		return load(loader, url, resourceBundle, builderFactory);
	}

	/**
	 * Load a FXML file relative to the bundle
	 * 
	 * @param bundle
	 *            the bundle
	 * @param bundleRelativeFxmlPath
	 *            the bundle relative path
	 * @param resourceBundle
	 *            the translation to be used
	 * @param builderFactory
	 *            the builder factory to use
	 * @return the created scene graph
	 * @throws IOException
	 */
	public static <O> O load(@NonNull Bundle bundle, @NonNull String bundleRelativeFxmlPath, @Nullable ResourceBundle resourceBundle, @Nullable BuilderFactory builderFactory) throws IOException {
		URL url = bundle.getResource(bundleRelativeFxmlPath);
		ClassLoader loader = bundle.adapt(BundleWiring.class).getClassLoader();
		return load(loader, url, resourceBundle, builderFactory);
	}

	/**
	 * Load using the given classloader
	 * 
	 * @param classloader
	 *            the classloader
	 * @param url
	 *            the url of the fxml file
	 * @param resourceBundle
	 *            the translations
	 * @param builderFactory
	 *            the builder factory
	 * @return the created scene graph
	 * @throws IOException
	 */
	public static <O> O load(@NonNull ClassLoader classloader, @NonNull URL url, @Nullable ResourceBundle resourceBundle, @Nullable BuilderFactory builderFactory) throws IOException {
		return load(classloader, url, resourceBundle, builderFactory, null);
	}

	/**
	 * Load a FXML file relative to the requested
	 * 
	 * @param requester
	 *            the requester
	 * @param relativeFxmlPath
	 *            the relative FXML-File Path
	 * @param resourceBundle
	 *            the translation to be used
	 * @param builderFactory
	 *            the builder factory to use
	 * @param controllerFactory
	 *            the controller factory
	 * @return the created scene graph
	 * @throws IOException
	 */
	public static <O> O load(@NonNull Class<?> requester, @NonNull String relativeFxmlPath, @Nullable ResourceBundle resourceBundle, @Nullable BuilderFactory builderFactory, @Nullable Callback<Class<?>, Object> controllerFactory)
			throws IOException {
		URL url = requester.getResource(relativeFxmlPath);
		ClassLoader loader = requester.getClassLoader();
		return load(loader, url, resourceBundle, builderFactory, controllerFactory);
	}

	/**
	 * Load a FXML file relative to the bundle
	 * 
	 * @param bundle
	 *            the bundle
	 * @param bundleRelativeFxmlPath
	 *            the bundle relative path
	 * @param resourceBundle
	 *            the translation to be used
	 * @param builderFactory
	 *            the builder factory to use
	 * @param controllerFactory
	 *            the controller factory
	 * @return the created scene graph
	 * @throws IOException
	 */
	public static <O> O load(@NonNull Bundle bundle, @NonNull String bundleRelativeFxmlPath, @Nullable ResourceBundle resourceBundle, @Nullable BuilderFactory builderFactory, @Nullable Callback<Class<?>, Object> controllerFactory)
			throws IOException {
		URL url = bundle.getResource(bundleRelativeFxmlPath);
		ClassLoader loader = bundle.adapt(BundleWiring.class).getClassLoader();
		return load(loader, url, resourceBundle, builderFactory, controllerFactory);
	}

	/**
	 * Load using the given classloader
	 * 
	 * @param classloader
	 *            the classloader
	 * @param url
	 *            the url of the fxml file
	 * @param resourceBundle
	 *            the translations
	 * @param builderFactory
	 *            the builder factory
	 * @param controllerFactory
	 *            the controller factory
	 * @return the created scene graph
	 * @throws IOException
	 */
	public static <O> O load(@NonNull final ClassLoader classloader, @NonNull URL url, @Nullable ResourceBundle resourceBundle, @Nullable final BuilderFactory builderFactory, @Nullable Callback<Class<?>, Object> controllerFactory)
			throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(url);
		loader.setClassLoader(classloader);
		loader.setResources(resourceBundle);
		if (builderFactory == null) {
			loader.setBuilderFactory(new JavaFXBuilderFactory(classloader));
		} else {
			loader.setBuilderFactory(new BuilderFactory() {
				private JavaFXBuilderFactory orgBuilder = new JavaFXBuilderFactory(classloader);

				@Override
				public Builder<?> getBuilder(Class<?> type) {
					Builder<?> b = builderFactory.getBuilder(type);
					if (b == null) {
						b = this.orgBuilder.getBuilder(type);
					}
					return b;
				}
			});
		}

		if (controllerFactory != null) {
			loader.setControllerFactory(controllerFactory);
		}

		try( InputStream in = url.openStream() ) {
			@SuppressWarnings("unchecked")
			O value = (O) loader.load(in);
			in.close();
			return value;
		}
	}
}

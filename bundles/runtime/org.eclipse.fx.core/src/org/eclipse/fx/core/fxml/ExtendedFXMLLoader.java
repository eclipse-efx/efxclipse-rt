/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Callback;

import org.eclipse.fx.core.fxml.FXMLDocument.LoadData;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * The extended fxml loader tries to create an instance of a class with the same
 * FQN as the given FXML-File and falls back to use the {@link FXMLLoader} if
 * not found.
 * 
 * The greatly improves performance because a precompiled .class file can be
 * used whereas {@link FXMLLoader} has to use reflection to create instances at
 * runtime
 */
public class ExtendedFXMLLoader {
	/**
	 * Load the FXML file
	 * 
	 * @param cl
	 *            the classloader to use
	 * @param path
	 *            the path to the FXML-File
	 * @return the object graph constructed from the fxml or .class-File
	 * @throws IOException
	 */
	@NonNull
	public static <T> T load(@NonNull ClassLoader cl, @NonNull String path)
			throws IOException {
		return load(cl, null, path);
	}

	/**
	 * Load the FXML file
	 * 
	 * @param cl
	 *            the classloader to use
	 * @param resourceBundle
	 *            the l10n bundle for localization
	 * @param path
	 *            the path to the FXML-File
	 * @return the object graph constructed from the fxml or .class-File
	 * @throws IOException
	 */
	@NonNull
	public static <T> T load(@NonNull ClassLoader cl,
			@Nullable ResourceBundle resourceBundle, @NonNull String path)
			throws IOException {
		return ExtendedFXMLLoader.<T, Object> loadWithController(cl,
				resourceBundle, null, path).getNode();
	}
	
	/**
	 * Load the FXML file
	 * 
	 * @param cl
	 *            the classloader to use
	 * @param root
	 *            the root node if fx:root is used
	 * @param resourceBundle
	 *            the l10n bundle for localization
	 * @param path
	 *            the path to the FXML-File
	 * @return the object graph constructed from the fxml or .class-File
	 * @throws IOException
	 */
	@NonNull
	public static <T> T load(@NonNull ClassLoader cl,
			@Nullable ResourceBundle resourceBundle, T root, @NonNull String path)
			throws IOException {
		return ExtendedFXMLLoader.<T, Object> loadWithController(cl,
				resourceBundle, root, null, path).getNode();
	}
	
	/**
	 * Load the FXML file
	 * 
	 * @param cl
	 *            the classloader to use
	 * @param resourceBundle
	 *            the l10n bundle for localization
	 * @param controllerFactory
	 *            an optional controller factory
	 * @param path
	 *            the path to the FXML-File
	 * @return the object graph constructed from the fxml or .class-File
	 * @throws IOException
	 */
	public static <N, C> Data<N, C> loadWithController(@NonNull ClassLoader cl,
			@Nullable ResourceBundle resourceBundle,
			@Nullable Callback<Class<?>, Object> controllerFactory,
			@NonNull String path) throws IOException {
		return loadWithController(cl, resourceBundle, null, controllerFactory, path);
	}

	/**
	 * Load the FXML file
	 * 
	 * @param cl
	 *            the classloader to use
	 * @param resourceBundle
	 *            the l10n bundle for localization
	 * @param root
	 *            the root node if fx:root is used
	 * @param controllerFactory
	 *            an optional controller factory
	 * @param path
	 *            the path to the FXML-File
	 * @return the object graph constructed from the fxml or .class-File
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@NonNull
	public static <N, C> Data<N, C> loadWithController(@NonNull ClassLoader cl,
			@Nullable ResourceBundle resourceBundle, @Nullable N root,
			@Nullable Callback<Class<?>, Object> controllerFactory,
			@NonNull String path) throws IOException {
		try {
			String classname = path.substring(0, path.lastIndexOf('.'))
					.replace('/', '.');
			Class<?> clazz = cl.loadClass(classname);
			final FXMLDocument<N> d = (FXMLDocument<N>) clazz.newInstance();
			URL url = cl.getResource(path);
			if (url != null) {
				final N n = d.load(new LoadData<N>(url, resourceBundle,
						root,controllerFactory));
				return new Data<N, C>() {

					@Override
					public N getNode() {
						return n;
					}

					@Override
					public C getController() {
						return (C) d.getController();
					}
				};
			} else {
				throw new IOException(
						"Unable to get url for path '" + path + "'"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		} catch (ClassNotFoundException e) {
			final FXMLLoader loader = new FXMLLoader();
			loader.setBuilderFactory(new JavaFXBuilderFactory());
			loader.setResources(resourceBundle);
			loader.setLocation(cl.getResource(path));
			loader.setControllerFactory(controllerFactory);
			final N rv = (N) loader.load(cl.getResourceAsStream(path));
			if (rv != null) {
				return new Data<N, C>() {
					@Override
					public N getNode() {
						return rv;
					}

					@Override
					public C getController() {
						return loader.getController();
					}
				};
			}
			throw new IOException(
					"Unable to load fxml document from '" + path + "'"); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (InstantiationException e) {
			throw new IOException(e);
		} catch (IllegalAccessException e) {
			throw new IOException(e);
		}
	}

	/**
	 * Constructed information
	 * 
	 * @param <N>
	 *            the root node type
	 * @param <C>
	 *            the controller type
	 */
	public interface Data<N, C> {
		/**
		 * @return the node
		 */
		@NonNull
		public N getNode();

		/**
		 * @return the controller, might be <code>null</code>
		 */
		@Nullable
		public C getController();
	}
}

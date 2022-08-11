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
package org.eclipse.fx.ui.di;

import java.io.InputStream;
import java.net.URL;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Factory to build an {@link FXMLLoader}
 *
 * @deprecated use @LocalInstance {@link FXMLLoader}
 */
public interface FXMLLoaderFactory {
	/**
	 * Context key used
	 */
	public static final String CONTEXT_KEY = "fxmlcomponent"; //$NON-NLS-1$

	/**
	 * Load the fxml file relative to the bundle the loading class is in,
	 * similar to pure java {@link ClassLoader#getResource(String)}
	 *
	 * @param relativePath
	 *            the relative path to the bundle classpath
	 * @return the builder
	 */
	@NonNull
	public <N> FXMLBuilder<N> loadBundleRelative(@NonNull String relativePath);

	/**
	 * Load the fxml file relative to the class requesting the loading, similar
	 * to pure java {@link Class#getResource(String)}
	 *
	 * @param relativePath
	 *            the relative path from the class
	 * @return the builder
	 */
	@NonNull
	public <N> FXMLBuilder<N> loadRequestorRelative(@NonNull String relativePath);

	/**
	 * Load the fxml file from the given input stream
	 *
	 * @param stream
	 *            the stream
	 * @param path
	 *            the path to use for relative lookups like includes, image
	 *            sources, ...
	 * @return the builder
	 */
	@NonNull
	public <N> FXMLBuilder<N> loadFromInputStream(@NonNull InputStream stream, @Nullable URL path);

	/**
	 * Load the fxml file from the given url
	 *
	 * @param url
	 *            the url
	 * @return the builder
	 */
	@NonNull
	public <N> FXMLBuilder<N> loadFromURL(@NonNull URL url);
}
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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Factory to build an {@link FXMLLoader}
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
}

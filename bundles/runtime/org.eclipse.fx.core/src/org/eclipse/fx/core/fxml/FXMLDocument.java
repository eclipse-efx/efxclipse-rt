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

import java.net.URL;
import java.util.ResourceBundle;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Base class for FXML-File converted and loaded with {@link ExtendedFXMLLoader}
 * 
 * @param <T>
 *            the root type
 */
public abstract class FXMLDocument<T> {
	/**
	 * "Load" the document to create the SceneGraph
	 * 
	 * @param location
	 *            the location
	 * @param bundle
	 *            the bundle
	 * @return the created scene graph
	 */
	@NonNull
	public abstract T load(@NonNull URL location, @Nullable ResourceBundle bundle);

	/**
	 * @return the controller created, might be <code>null</code>
	 */
	@Nullable
	public abstract Object getController();
}

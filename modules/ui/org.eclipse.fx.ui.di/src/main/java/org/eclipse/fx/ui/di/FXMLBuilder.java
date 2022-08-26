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

import java.io.IOException;
import java.util.Map;
import java.util.ResourceBundle;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.util.BuilderFactory;

/**
 * Builder for an FXMLLoader
 * 
 * @param <N>
 *            the root type loaded by the builder
 */
public interface FXMLBuilder<N> {
	/**
	 * Associate a resource bundle with the loader
	 * 
	 * @param resourceBundle
	 *            the resource bundle
	 * @return the builder instance
	 */
	@NonNull
	FXMLBuilder<N> resourceBundle(@NonNull ResourceBundle resourceBundle);

	/**
	 * Associate a builder factory with the loader
	 * 
	 * @param builderFactory
	 *            the builder factory
	 * @return the builder instance
	 */
	@NonNull
	FXMLBuilder<N> builderFactory(@NonNull BuilderFactory builderFactory);

	/**
	 * Load the FXML-Document
	 * 
	 * @return the root node
	 * @throws IOException
	 *             if there is a problem loading the fxml
	 */
	@NonNull
	N load() throws IOException;

	/**
	 * Load the FXML and return the root node and the controller
	 * 
	 * @return a structure holding root node and controller
	 * @throws IOException
	 *             if there is a problem loading the fxml
	 */
	<C> Data<N,C> loadWithController() throws IOException;

	/**
	 * Data struct holing root node and controller
	 * 
	 * @param <N>
	 *            the root node type
	 * @param <C>
	 *            the controller type
	 */
	public interface Data<N, C> {
		/**
		 * @return the root node
		 */
		@NonNull
		public N getNode();

		/**
		 * @return the controller, might be <code>null</code> if the fxml is not
		 *         associated to a controller
		 */
		@Nullable
		public C getController();
		
		/**
		 * @return map of fx:id to real nodes
		 */
		@NonNull
		public Map<String,Object> getNamespace();
	}
}

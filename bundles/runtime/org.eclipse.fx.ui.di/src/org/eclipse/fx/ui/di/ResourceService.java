/*******************************************************************************
 * Copyright (c) 2011 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 ******************************************************************************/
package org.eclipse.fx.ui.di;

import java.io.IOException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.scene.image.Image;

/**
 * Service which provides a resource pool who cleans it up itself when going out
 * of scope
 */
public interface ResourceService {
	/**
	 * A resource in the pool
	 * 
	 * @param <T>
	 *            the type of resource
	 */
	public interface IPooledResource<T> {
		/**
		 * @return the native resource
		 */
		@Nullable
		public T getResource();

		/**
		 * @return the id of the resource
		 */
		@NonNull
		public String getId();

		/**
		 * Method to free the native resource
		 */
		public void dispose();
	}

	/**
	 * Interface implemented by a resource pool who can be disposed
	 */
	public interface IDiposeableResourcePool extends ResourcePool {
		/**
		 * Free all resources of the resource pool
		 */
		public void dispose();
	}

	/**
	 * Get the resource for the given key
	 * 
	 * @param key
	 *            the key
	 * @return the resource
	 * @throws IOException
	 *             if something goes wrong
	 */
	@NonNull
	public IPooledResource<Image> getImage(@NonNull String key)
			throws IOException;

	/**
	 * Get a resource pool to load resources
	 * 
	 * @return the pool instance for the current scope
	 */
	public IDiposeableResourcePool getResourcePool();
}
/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Interface wrapping a path allowing to resource temporary resources
 *
 * @param <O>
 *            the resource type
 *
 * @since 2.2.0
 */
public interface Resource<@NonNull O> {
	/**
	 * @return the path
	 */
	public O getNativeResource();

	/**
	 * Release the resource. The semantics what releaseing a resource means depends
	 * on the wrapped resource eg for a temp-file releaseing could mean it is
	 * deleted
	 *
	 * @return <code>true</code> if releasing was successfull
	 */
	public boolean release();

	/**
	 * Create a temporary resource
	 *
	 * @param path
	 *            the path
	 * @return the resource
	 */
	public static Resource<@NonNull Path> createTempResource(@NonNull Path path) {
		return new Resource<@NonNull Path>() {

			@Override
			public boolean release() {
				try {
					return Files.deleteIfExists(path);
				} catch (IOException e) {
					LoggerCreator.createLogger(Resource.class).error("Unable to delete path '" + path + "'", e); //$NON-NLS-1$//$NON-NLS-2$
				}
				return false;
			}

			@Override
			public Path getNativeResource() {
				return path;
			}
		};
	}

	/**
	 * Create a resource who won't be deleted if released
	 *
	 * @param path
	 *            the path
	 * @return the resource
	 */
	public static Resource<@NonNull Path> createResource(@NonNull Path path) {
		return new Resource<@NonNull Path>() {

			@Override
			public boolean release() {
				return true;
			}

			@Override
			public Path getNativeResource() {
				return path;
			}
		};
	}
}
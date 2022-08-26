/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
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
package org.eclipse.fx.core;

import java.nio.file.Path;
import java.util.function.BiConsumer;

/**
 * Service to deal with filesystems
 *
 * @since 1.2
 * @noimplement
 */
public interface FilesystemService {
	/**
	 * Modification kind
	 */
	public enum Kind {
		/**
		 * A new directory entry has been created
		 */
		CREATE,
		/**
		 * A directory entry has been modified
		 */
		MODIFY,
		/**
		 * A directory entry has been deleted
		 */
		DELETE
	}

	/**
	 * Observe a path and invoke the consumer when a modification happens
	 *
	 * @param path
	 *            the path
	 * @param consumer
	 *            the consumer
	 * @return subscription
	 */
	public Subscription observePath(URI path, BiConsumer<Kind, URI> consumer);

	/**
	 * Observe a path and invoke the consumer when a modification happens
	 *
	 * @param path
	 *            the path
	 * @param consumer
	 *            the consumer
	 * @return subscription
	 */
	public Subscription observePath(Path path, BiConsumer<Kind, Path> consumer);

	/**
	 * Check if the service applies to the given URI
	 *
	 * @param path
	 *            the path
	 * @return <code>true</code> if it applies
	 */
	public boolean applies(URI path);
}

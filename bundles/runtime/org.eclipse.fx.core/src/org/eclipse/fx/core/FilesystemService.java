/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core;

import java.nio.file.Path;
import java.util.function.BiConsumer;

import org.eclipse.fx.core.Subscription;

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
	public Subscription observePath(URI path, BiConsumer<Kind, Path> consumer);

	/**
	 * Check if the service applies to the given URI
	 *
	 * @param path
	 *            the path
	 * @return <code>true</code> if it applies
	 */
	public boolean applies(URI path);
}

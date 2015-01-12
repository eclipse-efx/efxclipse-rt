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
package org.eclipse.fx.ui.controls.filesystem;

import java.nio.file.Path;
import java.time.LocalDateTime;

import javafx.beans.property.ReadOnlyObjectProperty;

import org.eclipse.fx.ui.controls.filesystem.skin.PathItemImpl;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Base interface for file system resources
 *
 * @since 1.2
 */
public interface ResourceItem {
	/**
	 * @return base interface of a resource
	 */
	public String getName();

	/**
	 * @return the path to the resource
	 */
	public Path getPath();

	/**
	 * refresh the resource information
	 */
	public void refresh();

	/**
	 * Last modification of the resource
	 *
	 * @return the last modification property
	 */
	public ReadOnlyObjectProperty<@NonNull LocalDateTime> lastModifiedProperty();

	/**
	 * Create a root item
	 *
	 * @param path
	 *            the path
	 * @return the root dir
	 */
	public static RootDirItem createPath(Path path) {
		return PathItemImpl.createPath(path);
	}

	/**
	 * Create an observable path
	 *
	 * <p>
	 * It is important to dispose the root item once not needed any more because
	 * it unregisters listeners on the filesystem to track modifications
	 * </p>
	 *
	 * @param path
	 *            a path
	 * @return the root dir
	 */
	public static RootDirItem createObservedPath(Path path) {
		return PathItemImpl.createObservedPath(path);
	}
}

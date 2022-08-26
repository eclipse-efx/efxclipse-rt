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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.scene.image.Image;

/**
 * A resource pool attached to a context releasing the resources when disposed
 */
public interface ResourcePool {
	/**
	 * Get a registered image from the pool
	 * 
	 * @param imageKey
	 *            the image key
	 * @return the image
	 * @throws IOException
	 *             if there's a problem loading the image
	 */
	@NonNull
	public Image getImage(@NonNull String imageKey) throws IOException;

	/**
	 * Get a registered image or <code>null</code>
	 * 
	 * @param imageKey
	 *            the image key
	 * @return the image
	 */
	@Nullable
	public Image getImageUnchecked(@NonNull String imageKey);
}
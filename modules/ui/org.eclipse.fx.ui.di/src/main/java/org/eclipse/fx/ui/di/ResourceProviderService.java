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

import javafx.scene.image.Image;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Service who maps image keys to real images
 */
public interface ResourceProviderService {
	/**
	 * Get the image with the given key
	 * 
	 * @param key
	 *            the key
	 * @return the image
	 * @throws IOException
	 *             in case something goes wrong
	 */
	@Nullable
	public Image getImage(@NonNull String key) throws IOException;
}
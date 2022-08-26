/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.services.resources;

import java.io.IOException;
import java.util.List;

import org.eclipse.fx.core.URI;
import org.eclipse.jdt.annotation.NonNull;

import javafx.scene.image.Image;

/**
 * An image provider
 */
public interface ImageProvider {
	/**
	 * @return name of the provider
	 */
	@NonNull
	public String getName();

	/**
	 * @return the supported file suffixes
	 */
	@NonNull
	public List<@NonNull String> getFileSuffix();

	/**
	 * Loading the image from the given uri
	 * 
	 * @param uri
	 *            the uri
	 * @return the image
	 * @throws IOException
	 *             exception when loading fails
	 */
	@NonNull
	public Image getImage(@NonNull URI uri) throws IOException;
}

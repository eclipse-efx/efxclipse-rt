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
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.services.resources;

import java.util.Collections;
import java.util.List;

import javafx.geometry.Point2D;

import org.eclipse.fx.core.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Describes an image which is adorned on its 4 edges
 */
public class AdornedImageDescriptor {

	/**
	 * The location to place the adornment
	 */
	public enum Location {
		/**
		 * Place it to the left top
		 */
		LEFT_TOP,
		/**
		 * Place it to the left bottom
		 */
		LEFT_BOTTOM,
		/**
		 * Place it to the right top
		 */
		RIGHT_TOP,
		/**
		 * Place it to the right bottom
		 */
		RIGHT_BOTTOM
	}

	/**
	 * The adornment to place above the base image
	 */
	public static class Adornment {
		/**
		 * The location
		 */
		public final Location location;
		/**
		 * The uri
		 */
		public final @NonNull URI uri;

		/**
		 * Create a new adornment
		 *
		 * @param location
		 *            the location
		 * @param uri
		 *            the uri
		 */
		public Adornment(@NonNull Location location, @NonNull URI uri) {
			this.location = location;
			this.uri = uri;
		}
	}

	/**
	 * The base image
	 */
	public final @NonNull URI baseImage;
	/**
	 * The adornments
	 */
	public final @NonNull List<@NonNull Adornment> adornments;
	/**
	 * The size if <code>null</code> the size of the base image
	 */
	public final @Nullable Point2D size;

	/**
	 * Create a new descriptor
	 *
	 * @param baseImage
	 *            the base image
	 * @param adornments
	 *            adornments
	 * @param size
	 *            the size
	 */
	@SuppressWarnings("null")
	public AdornedImageDescriptor(@NonNull URI baseImage,
			@NonNull List<@NonNull Adornment> adornments, @Nullable Point2D size) {
		this.baseImage = baseImage;
		this.adornments = Collections.unmodifiableList(adornments);
		this.size = size;
	}

	/**
	 * Create a new descriptor
	 *
	 * @param baseImage
	 *            the base image
	 * @param adornments
	 *            adornments
	 */
	public AdornedImageDescriptor(@NonNull URI baseImage,
			@NonNull List<@NonNull Adornment> adornments) {
		this(baseImage, adornments, null);
	}
}
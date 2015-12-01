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

import java.net.URL;
import java.nio.file.Path;
import java.util.function.Predicate;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Resolve an URL to a local path
 */
public interface URLResolver extends Predicate<@NonNull URL> {
	/**
	 * Check if the provided URL is supported
	 */
	@Override
	boolean test(@NonNull URL t);

	/**
	 * Convert the url to a local path which eg can be fed into a JavaFX media
	 * player
	 *
	 * @param url
	 *            the url
	 * @return the local path
	 */
	public @NonNull Path resolveToLocalPath(URL url);
}

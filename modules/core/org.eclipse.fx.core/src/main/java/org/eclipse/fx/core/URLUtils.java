/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
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

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Optional;

import org.eclipse.fx.core.log.LoggerCreator;

/**
 * Utilties when working with {@link URL}
 */
public class URLUtils {
	/**
	 * Create a new URL instance from the provide value
	 *
	 * @param url
	 *            the url
	 * @return the url instance
	 * @throws IllegalArgumentException
	 *             if something wrong with the URL provided
	 * @since 2.3.0
	 */
	public static URL createUrl(String url) {
		try {
			return new URL(url);
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * Transform an {@link URI} to an {@link URL}
	 *
	 * @param uri
	 *            the uri
	 * @return the url
	 * @throws IllegalStateException
	 *             if the uri can not be converted
	 * @since 3.0.0
	 */
	public static URL toURL(URI uri) {
		try {
			return uri.toURL();
		} catch (MalformedURLException e) {
			throw new IllegalStateException(e);
		}
	}

	/**
	 * Create a new URL instance who provides an optional of the creation fails
	 *
	 * @param url
	 *            the url
	 * @param log
	 *            <code>true</code> if you want the exception to be logged
	 * @return the url wrapped in an optional
	 * @since 2.4.0
	 */
	public static Optional<URL> createUrl(String url, boolean log) {
		try {
			return Optional.of(new URL(url));
		} catch (Throwable e) {
			if (log) {
				LoggerCreator.createLogger(URLUtils.class).error("Failed to create url from '" + url + "'", e); //$NON-NLS-1$//$NON-NLS-2$
			}
			return Optional.empty();
		}
	}
}

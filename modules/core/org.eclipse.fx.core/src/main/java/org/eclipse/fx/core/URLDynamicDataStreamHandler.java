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

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.jdt.annotation.Nullable;

/**
 * Handler for dyndata: urls
 *
 * @since 2.2.0
 */
public interface URLDynamicDataStreamHandler {
	/**
	 * Parameter key to be used in the url
	 */
	public static final String DYNAMIC_DATA_KEY = "efx_DynamicDataHandlerId"; //$NON-NLS-1$

	/**
	 * the protocol
	 */
	public static final String PROTOCOL = "dyndata"; //$NON-NLS-1$

	/**
	 * A default handler who uses the query parameters to replace entries in the
	 * file. Dynamic keys are marked with _(KEY)
	 */
	public static final String TPL_HANDLER = "tplUrlHandler"; //$NON-NLS-1$

	/**
	 * Create a dynamic URL from the provided one
	 *
	 * @param url
	 *            the url
	 * @param handlerId
	 *            the handler id to be used
	 * @return the constructed url
	 */
	public static URL createDynamicDataStreamURL(URL url, String handlerId) {
		return createDynamicDataStreamURL(url, handlerId, Collections.emptyMap());
	}

	/**
	 * Create a dynamic URL from the provided one
	 *
	 * @param url
	 *            the url
	 * @param handlerId
	 *            the handler id to be used
	 * @param queryMap
	 *            query parameters that are attached
	 * @return the constructed url
	 */
	public static URL createDynamicDataStreamURL(URL url, String handlerId, Map<String, String> queryMap) {
		String query = queryMap.entrySet().stream().map(e -> {
			try {
				return URLEncoder.encode(e.getKey(), "UTF-8") + "=" + URLEncoder.encode(e.getValue(), "UTF-8"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			} catch (Exception e1) {
				throw new IllegalStateException(e1);
			}
		}).collect(Collectors.joining("&")); //$NON-NLS-1$
		String newUrl;
		if (url.getQuery() == null) {
			newUrl = PROTOCOL + ":" + url.toExternalForm() + "?" + DYNAMIC_DATA_KEY + "=" + handlerId; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		} else {
			newUrl = url.toExternalForm() + "&" + DYNAMIC_DATA_KEY + "=" + handlerId; //$NON-NLS-1$ //$NON-NLS-2$
		}

		if (!query.isEmpty()) {
			newUrl += "&" + query; //$NON-NLS-1$
		}

		try {
			return new URL(newUrl);
		} catch (MalformedURLException e1) {
			throw new IllegalStateException("Failed to create URL '" + newUrl + "'", e1); //$NON-NLS-1$//$NON-NLS-2$
		}
	}

	/**
	 * Check if the provided URL is a valid dynamic data-stream url
	 *
	 * @param url
	 *            the url
	 * @return <code>true</code> if is a valid URL
	 */
	public static boolean isValidDynamicDataStreamURL(URL url) {
		return PROTOCOL.equals(url.getProtocol()) && url.getQuery() != null
				&& url.getQuery().contains(DYNAMIC_DATA_KEY);
	}

	/**
	 * @return id of the handler
	 */
	public String getId();

	/**
	 * Create a data stream for the url
	 *
	 * @param url
	 *            the url
	 * @return the stream
	 */
	public @Nullable InputStream createDataStream(URL url);
}

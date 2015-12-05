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
package org.eclipse.fx.core.internal;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.eclipse.fx.core.URLDynamicDataStreamHandler;
import org.eclipse.fx.core.URLStreamHandler;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * Handler for the dyndata protocol
 */
@Component
public class DynamicDataStreamHandler implements URLStreamHandler {
	private Map<String, URLDynamicDataStreamHandler> map = new HashMap<>();

	/**
	 * Register handler
	 *
	 * @param handler
	 *            the handler
	 */
	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policyOption = ReferencePolicyOption.GREEDY)
	public void registerURLDynamicDataStreamHandler(URLDynamicDataStreamHandler handler) {
		this.map.put(handler.getId(), handler);
	}

	/**
	 * Unregister the handler
	 *
	 * @param handler
	 *            the handler
	 */
	public void unregisterURLDynamicDataStreamHandler(URLDynamicDataStreamHandler handler) {
		this.map.remove(handler.getId(), handler);
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getProtocol() {
		return URLDynamicDataStreamHandler.PROTOCOL;
	}

	@Override
	public @NonNull InputStream createStream(@NonNull URL url) throws IOException {
		if (URLDynamicDataStreamHandler.isValidDynamicDataStreamURL(url)) {
			InputStream inStream = Stream.of(url.getQuery().split("&")) //$NON-NLS-1$
					.filter(e -> e.startsWith(URLDynamicDataStreamHandler.DYNAMIC_DATA_KEY))
					.findFirst()
					.map( e -> e.split("=")[1]) //$NON-NLS-1$
					.map( id -> this.map.get(id))
					.map( h -> h.createDataStream(url))
					.orElse(null);
			if( inStream == null ) {
				throw new IOException("Could not create input stream for URL '"+url+"'");  //$NON-NLS-1$//$NON-NLS-2$
			}
			return inStream;
		} else {
			InputStream inStream = new URL(url.toExternalForm().substring(URLDynamicDataStreamHandler.PROTOCOL.length()+1)).openStream();
			if( inStream == null ) {
				throw new IOException("Could not create input stream for URL '"+url+"'");  //$NON-NLS-1$//$NON-NLS-2$
			}
			return inStream;
		}
	}

}

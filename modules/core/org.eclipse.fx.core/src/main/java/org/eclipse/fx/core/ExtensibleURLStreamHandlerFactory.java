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
package org.eclipse.fx.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.jdt.annotation.NonNull;

/**
 * {@link URLStreamHandlerFactory} who can be extended by registering
 * {@link org.eclipse.fx.core.URLStreamHandler} as services
 */
public class ExtensibleURLStreamHandlerFactory implements URLStreamHandlerFactory {

	private final Map<String, org.eclipse.fx.core.URLStreamHandler> handlerMap;

	private ExtensibleURLStreamHandlerFactory() {
		this.handlerMap = ServiceUtils.getServiceList(org.eclipse.fx.core.URLStreamHandler.class).stream().collect(Collectors.toMap(h -> h.getProtocol(), h -> h));
	}

	@Override
	public URLStreamHandler createURLStreamHandler(String protocol) {
		org.eclipse.fx.core.URLStreamHandler h = this.handlerMap.get(protocol);
		if (h != null) {
			return new URLStreamHandlerImpl(h);
		}
		return null;
	}

	/**
	 * Setup the extensible url handler
	 * <p>
	 * <b>Warning:</b>
	 * </p>
	 * <p>If you run in a framework like eg Equinox you should not run
	 * this code because the framework might already have set its custom handler
	 * </p>
	 */
	public static void setup() {
		URL.setURLStreamHandlerFactory(new ExtensibleURLStreamHandlerFactory());
	}

	static class URLStreamHandlerImpl extends URLStreamHandler {
		final org.eclipse.fx.core.@NonNull URLStreamHandler h;

		public URLStreamHandlerImpl(org.eclipse.fx.core.@NonNull URLStreamHandler h) {
			this.h = h;
		}

		@Override
		protected URLConnection openConnection(URL u) throws IOException {
			if( u == null ) {
				throw new IllegalStateException("The url must not be null"); //$NON-NLS-1$
			}
			return new URLConnectionImpl(u, this.h);
		}
	}

	static class URLConnectionImpl extends URLConnection {
		private final org.eclipse.fx.core.URLStreamHandler h;

		protected URLConnectionImpl(@NonNull URL url, org.eclipse.fx.core.@NonNull URLStreamHandler h) {
			super(url);
			this.h = h;
		}

		@Override
		public void connect() throws IOException {
			// keep it empty
		}

		@SuppressWarnings("null")
		@Override
		public InputStream getInputStream() throws IOException {
			return this.h.createStream(getURL());
		}
	}
}

/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.osgi.util.internal;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.eclipse.fx.core.URLStreamHandler;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.url.AbstractURLStreamHandlerService;
import org.osgi.service.url.URLStreamHandlerService;

@SuppressWarnings("javadoc")
public class DelegatingURLStreamHandlerService extends AbstractURLStreamHandlerService
		implements URLStreamHandlerService {
	public final URLStreamHandler h;

	public DelegatingURLStreamHandlerService(URLStreamHandler h) {
		this.h = h;
	}

	@Override
	public URLConnection openConnection(URL u) throws IOException {
		return new URLConnectionImpl(u, this.h);
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

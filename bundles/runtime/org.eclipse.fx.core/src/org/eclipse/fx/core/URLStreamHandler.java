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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Stream handler for a certain protocol
 *
 * @since 2.2.0
 */
public interface URLStreamHandler {
	/**
	 * @return the protocol
	 */
	public @NonNull String getProtocol();

	/**
	 * Create a stream for the provided url
	 *
	 * @param url
	 *            the url
	 * @return the stream
	 * @throws IOException
	 *             if there's a problem
	 */
	public @NonNull InputStream createStream(@NonNull URL url) throws IOException;
}

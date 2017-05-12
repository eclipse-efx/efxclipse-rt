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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang.text.StrSubstitutor;
import org.eclipse.fx.core.IOUtils;
import org.eclipse.fx.core.URLDynamicDataStreamHandler;
import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.service.component.annotations.Component;

/**
 * Replace values in the orginal sources with the query parameters provided
 */
@Component
public class TplURLDynamicDataStreamHandler implements URLDynamicDataStreamHandler {
	private static final String ID = URLDynamicDataStreamHandler.TPL_HANDLER;

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public @Nullable InputStream createDataStream(URL url) {
		try {
			URL realURL = new URL(url.getPath());
			String data;
			try (InputStream stream = realURL.openStream()) {
				data = StrSubstitutor.replace(IOUtils.readToString(stream, Charset.forName("UTF-8")), //$NON-NLS-1$
						map(url.getQuery()), "_(", ")"); //$NON-NLS-1$//$NON-NLS-2$
			}
			return new ByteArrayInputStream(data.getBytes());
		} catch (IOException e) {
			LoggerCreator.createLogger(TplURLDynamicDataStreamHandler.class).error("Failed to load real data", e); //$NON-NLS-1$
		}
		return null;
	}

	private static final Map<String, String> map(String query) {
		if (query != null) {
			return Stream.of(query.split("&")) //$NON-NLS-1$
					.map(e -> e.split("=")) //$NON-NLS-1$
					.collect(Collectors.toMap(e -> e[0], e -> e[1]));
		}
		return Collections.emptyMap();
	}
}

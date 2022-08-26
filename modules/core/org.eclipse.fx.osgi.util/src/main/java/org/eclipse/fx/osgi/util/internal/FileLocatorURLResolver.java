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
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.osgi.util.internal;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.fx.core.URLResolver;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.component.annotations.Component;

/**
 * Resolver for OSGi-FileLocator
 */
@Component
public class FileLocatorURLResolver implements URLResolver {

	@Override
	public boolean test(@NonNull URL t) {
		try {
			return FileLocator.resolve(t) != null;
		} catch (IOException e) {
			return false;
		}
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull Path resolveToLocalPath(URL url) {
		try {
			return Paths.get(FileLocator.toFileURL(url).toURI());
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull URL resolveToLocalURL(URL url) {
		try {
			return FileLocator.resolve(url);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.editor.services.internal;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.fx.core.adapter.AdapterProvider;
import org.eclipse.fx.core.adapter.AdapterService.ValueAccess;
import org.osgi.service.component.annotations.Component;

@Component
public class URLToPathAdapterProvider implements AdapterProvider<String, Path> {

	@Override
	public Class<String> getSourceType() {
		return String.class;
	}

	@Override
	public Class<Path> getTargetType() {
		return Path.class;
	}

	@Override
	public boolean canAdapt(String sourceObject, Class<Path> targetType) {
		try {
			URI uri = URI.create(sourceObject);
			Paths.get(uri);
			return true;
		} catch(Throwable t) {
		}
		return false;
	}

	@Override
	public Path adapt(String sourceObject, Class<Path> targetType, ValueAccess... valueAccess) {
		URI uri = URI.create(sourceObject);
		return Paths.get(uri);
	}

}

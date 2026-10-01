/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Martin Bluehweis<martin.bluehweis@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.osgi.fxloader.jpms;

import java.nio.file.Path;
import java.util.Objects;

/**
 * Combined module name and path
 * 
 * @param module module name
 * @param path   module path
 */
public record FXProviderBundle(String module, Path path) {
	/**
	 * Constructor, both arguments must not be {@code null}
	 */
	public FXProviderBundle {
		Objects.requireNonNull(module);
		Objects.requireNonNull(path);
	}
}

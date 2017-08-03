/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Factory service
 *
 * @param <T>
 *            the type
 * @since 1.1
 */
public interface ObjectFactory<@NonNull T> {
	/**
	 * Create instance
	 * @param factory
	 *            the factory
	 * @return the new instance
	 */
	public @NonNull T create(@NonNull ScopedObjectFactory factory);
}

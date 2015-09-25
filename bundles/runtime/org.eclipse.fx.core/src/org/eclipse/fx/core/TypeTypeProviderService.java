/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core;

/**
 * Service who provides a real type for an interface/abstract type
 *
 * @param <T>
 *            the type
 */
public interface TypeTypeProviderService<T> extends TypeProviderService<java.lang.reflect.Type, T> {
	/**
	 * If used with dependency injection and @LocalInstance
	 */
	public static final String DI_KEY = "localInstanceOwnerType"; //$NON-NLS-1$
}

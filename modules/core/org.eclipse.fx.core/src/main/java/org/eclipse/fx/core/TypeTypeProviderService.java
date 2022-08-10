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

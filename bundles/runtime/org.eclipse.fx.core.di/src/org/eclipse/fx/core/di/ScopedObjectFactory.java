/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di;

/**
 * An object factory is bound to the local context and is able to create instances using a the backing DI
 * container
 */
public interface ScopedObjectFactory {
	/**
	 * Create a new instance of the class
	 * 
	 * @param c
	 *            the class
	 * @return the instance
	 */
	public <C> C newInstance(Class<C> c);
}

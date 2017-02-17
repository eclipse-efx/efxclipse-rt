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
package org.eclipse.fx.core;

import java.util.ServiceLoader;

/**
 * Mixin to implement by services to allow ranking them in {@link ServiceLoader} environment
 *
 * @since 1.2
 */
public interface RankedService {
	/**
	 * @return the ranking value, bigger is better
	 */
	public int getRanking();
}

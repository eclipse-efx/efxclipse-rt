/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
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
package org.eclipse.fx.formats.svg.converter;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A key value pair
 */
public class Pair {
	/**
	 * the key
	 */
	public final String key;
	
	/**
	 * the value
	 */
	public final Object value;
	
	/**
	 * Create a new key/value pair
	 * @param key the key
	 * @param value the value
	 */
	public Pair(@NonNull String key, @NonNull Object value) {
		this.key = key;
		this.value = value;
	}
}

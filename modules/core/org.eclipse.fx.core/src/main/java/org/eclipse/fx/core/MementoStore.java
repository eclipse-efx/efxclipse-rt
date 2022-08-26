/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
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

import org.eclipse.jdt.annotation.NonNull;

/**
 * A persistent store for menentos
 * 
 * @noimplement
 */
public interface MementoStore {
	/**
	 * Get a memento at the specified location
	 * 
	 * @param path
	 *            the logical path to the memento in the store
	 * @return the memento
	 */
	public @NonNull Memento getMemento(String path);

	/**
	 * Remove the memento path
	 * 
	 * @param path
	 *            the path to remove
	 */
	public void remove(String path);
}

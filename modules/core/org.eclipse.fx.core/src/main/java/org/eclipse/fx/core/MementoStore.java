/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

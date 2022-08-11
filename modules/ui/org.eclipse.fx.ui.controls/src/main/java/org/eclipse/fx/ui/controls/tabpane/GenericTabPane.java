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
package org.eclipse.fx.ui.controls.tabpane;

/**
 * Interface to be implemented by tab-control
 */
public interface GenericTabPane {
	/**
	 * Get the index of the tab inde
	 * 
	 * @param t
	 *            the tab
	 * @return the index
	 */
	public int indexOf(GenericTab t);

	/**
	 * Remove the tab
	 * 
	 * @param t
	 *            the tab
	 * @return <code>true</code> if remove succeeded
	 */
	public boolean remove(GenericTab t);

	/**
	 * Add the tab
	 * 
	 * @param t
	 *            the tab
	 */
	public void add(GenericTab t);

	/**
	 * Add the tab at a given index
	 * 
	 * @param index
	 *            the index
	 * @param t
	 *            the tab
	 */
	public void add(int index, GenericTab t);
	
	/**
	 * @return the number of tab elements
	 */
	public int getTabNumber();
	
	/**
	 * Select the tab
	 * @param draggedTab
	 */
	public void select(GenericTab draggedTab);
}

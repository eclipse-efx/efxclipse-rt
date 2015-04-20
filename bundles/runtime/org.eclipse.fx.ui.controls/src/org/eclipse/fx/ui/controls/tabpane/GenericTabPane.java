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

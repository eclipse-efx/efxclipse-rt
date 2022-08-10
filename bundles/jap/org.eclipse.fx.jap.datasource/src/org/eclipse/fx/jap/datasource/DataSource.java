/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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
package org.eclipse.fx.jap.datasource;

/**
 * Basic datasource access interface
 */
public interface DataSource {
	/**
	 * A safe point
	 */
	public interface SavePoint {
		/**
		 * rollback to the point the save point has been created
		 */
		public void rollback();

		/**
		 * dispose the save point
		 */
		public void dispose();
	}

	/**
	 * Create a save point
	 * 
	 * @return the save point
	 */
	public SavePoint setSavePoint();

	// public IValueProperty createObservableValue(String propertyPath);
	//
	// public IListProperty createObservableList(String propertyPath);
	//
	// public void setPropertyValue(Object owner, Object value, String
	// propertyPath);
	//
	// public void addPropertyValue(Object owner, Object value, String
	// propertyPath);
	//
	// public void removePropertyValue(Object owner, Object value, String
	// propertyPath);
}
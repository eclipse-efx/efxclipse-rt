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
package org.eclipse.fx.jap.datasource;

/**
 * Service who provides the real implementation for a datasource interface
 */
public interface DataSourceProvider {
	/**
	 * Get the real implementation for a datasource interface
	 * 
	 * @param datasource
	 *            the datasource
	 * @return the datasource for the type of <code>null</code>
	 */
	public <D extends DataSource, R extends D> Class<R> getDatasourceClass(
			Class<D> datasource);
}

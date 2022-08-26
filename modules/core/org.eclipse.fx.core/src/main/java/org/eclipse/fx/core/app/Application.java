/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
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
package org.eclipse.fx.core.app;

/**
 * Interface implemented by applications
 *
 * <p>This provisional API and subject to change</p>
 *
 * @since 3.0
 * @noimplement
 * @noreference
 */
public interface Application {
	/**
	 * @return the application id
	 */
	public String getId();

	/**
	 * @return create a new application instance
	 */
	public ApplicationInstance create();
}

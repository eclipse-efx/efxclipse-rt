/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

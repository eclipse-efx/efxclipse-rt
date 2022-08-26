/*******************************************************************************
 * Copyright (c) 2014 EM-SOFTWARE and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Christoph Keimel <c.keimel@emsw.de> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.services.restart;

/**
 * Service for application restart and shutdown 
 */
public interface RestartService {

	/**
	 * Restarts the application
	 * 
	 * @param clear
	 *            if true the persisted state will be cleared on restart
	 */
	void restart(boolean clear);

	/**
	 * Closes the application
	 */
	public void shutdown();
}

/*******************************************************************************
 * Copyright (c) 2014 EM-SOFTWARE and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

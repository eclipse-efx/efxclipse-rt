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
package org.eclipse.fx.ui.workbench.base.restart;

import javax.inject.Inject;

import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.fx.ui.services.restart.RestartService;

/**
 * Service for common applications tasks like shutdown and restart
 */
public class RestartServiceImpl implements RestartService {

	@Inject
	private RestartPreferenceUtil util;
	@Inject
	private IWorkbench workbench;

	/**
	 * Restarts the application
	 * 
	 * @param clear
	 *            if true the persisted state will be cleared on restart
	 */
	@Override
	public void restart(boolean clear) {
		if (clear) {
			this.util.setClearPersistedStateOnRestart(true);
		}
		this.workbench.restart();
	}

	/**
	 * Closes the application
	 */
	@Override
	public void shutdown() {
		this.workbench.close();
	}
}

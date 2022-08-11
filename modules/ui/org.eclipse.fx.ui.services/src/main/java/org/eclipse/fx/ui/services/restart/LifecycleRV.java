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
 * Return value for lifecycle methods annotated with @PostContextCreate
 */
public enum LifecycleRV {
	/**
	 * Continue starting the application
	 */
	CONTINUE,
	/**
	 * Shut down the application
	 */
	SHUTDOWN,
	/**
	 * Restart the application
	 */
	RESTART,
	/**
	 * Restart the application with a cleared persisted state
	 */
	RESTART_CLEAR_STATE
}

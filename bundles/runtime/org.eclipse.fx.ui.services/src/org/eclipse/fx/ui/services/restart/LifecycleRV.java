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

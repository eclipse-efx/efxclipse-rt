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
 * The exit status of the application
 *
 * <p>This provisional API and subject to change</p>
 *
 * @since 3.0
 * @noimplement
 * @noreference
 */
public enum ExitStatus {
	/**
	 * Default exit
	 */
	OK,
	/**
	 * Restart the application
	 */
	RESTART
}

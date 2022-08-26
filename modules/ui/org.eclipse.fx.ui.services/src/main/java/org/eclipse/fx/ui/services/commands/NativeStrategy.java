/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.services.commands;

/**
 * Allows to specify if the key is event is blocked even if the command is not
 * executable
 */
public enum NativeStrategy {
	/**
	 * block and don't proceed with native handling
	 */
	BLOCK,
	/**
	 * proceed with native event handling
	 */
	PROCEED
}
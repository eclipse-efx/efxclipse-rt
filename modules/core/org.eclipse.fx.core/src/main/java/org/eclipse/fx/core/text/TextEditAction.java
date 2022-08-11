/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.text;

/**
 * marker interface for text edit actions
 */
public interface TextEditAction {

	/**
	 * no operation action for overriding defaults
	 */
	public final static TextEditAction NOOP = new TextEditAction() {
		// empty
	};

	/**
	 * @return true if the action modifies the text
	 */
	public default boolean isModification() {
		return false;
	}
}

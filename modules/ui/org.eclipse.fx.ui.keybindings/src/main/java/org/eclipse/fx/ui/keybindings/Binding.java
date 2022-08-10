/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
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
package org.eclipse.fx.ui.keybindings;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A binding between a trigger sequence and a command
 */
public interface Binding {
	/**
	 * System binding
	 */
	int SYSTEM = 0;
	/**
	 * User binding
	 */
	int USER = 1;
	
	/**
	 * @return the scheme id the binding is part of
	 */
	@NonNull String getSchemeId();
	
	/**
	 * @return the sequence
	 */
	@NonNull TriggerSequence getTriggerSequence();
	
	/**
	 * @return the command
	 */
	@NonNull ParameterizedCommand getParameterizedCommand();
	
	/**
	 * @return the context
	 */
	@NonNull String getContextId();
}

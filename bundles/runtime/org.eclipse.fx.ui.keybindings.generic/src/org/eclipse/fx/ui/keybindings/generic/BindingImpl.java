/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.keybindings.generic;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.fx.ui.keybindings.Binding;

public abstract class BindingImpl implements Binding {
	/**
	 * The parameterized command to which this binding applies. This value may
	 * be <code>null</code> if this binding is meant to "unbind" an existing
	 * binding.
	 */
	private final ParameterizedCommand command;

	/**
	 * The context identifier to which this binding applies. This context must
	 * be active before this key binding becomes active. This value will never
	 * be <code>null</code>.
	 */
	private final String contextId;
	
	/**
	 * The identifier of the scheme in which this binding applies. This value
	 * will never be <code>null</code>.
	 */
	private final String schemeId;
	
	public BindingImpl(ParameterizedCommand command, String schemeId, String contextId) {
		this.command = command;
		this.schemeId = schemeId;
		this.contextId = contextId;
	}
	
	@Override
	public String getContextId() {
		return contextId;
	}
	
	@Override
	public ParameterizedCommand getParameterizedCommand() {
		return command;
	}
	
	@Override
	public String getSchemeId() {
		return schemeId;
	}
}

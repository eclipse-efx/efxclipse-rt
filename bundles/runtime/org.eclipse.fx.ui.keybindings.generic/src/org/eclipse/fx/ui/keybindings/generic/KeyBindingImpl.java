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
import org.eclipse.fx.ui.keybindings.KeySequence;
import org.eclipse.fx.ui.keybindings.TriggerSequence;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A keybinding implementation
 */
public class KeyBindingImpl extends BindingImpl {
	@NonNull
	private final KeySequence keySequence;

	/**
	 * Create a binding
	 * 
	 * @param keySequence
	 * @param command
	 * @param schemeId
	 * @param contextId
	 */
	public KeyBindingImpl(@NonNull final KeySequence keySequence, @NonNull ParameterizedCommand command, @NonNull String schemeId, @NonNull String contextId) {
		super(command, schemeId, contextId);
		this.keySequence = keySequence;
	}

	@Override
	public TriggerSequence getTriggerSequence() {
		return this.keySequence;
	}

}

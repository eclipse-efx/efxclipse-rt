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
package org.eclipse.fx.ui.keybindings.generic;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.fx.ui.keybindings.Binding;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A binding implementation
 */
public abstract class BindingImpl implements Binding {
	/**
	 * The parameterized command to which this binding applies. This value may
	 * be <code>null</code> if this binding is meant to "unbind" an existing
	 * binding.
	 */
	@NonNull
	private final ParameterizedCommand command;

	/**
	 * The context identifier to which this binding applies. This context must
	 * be active before this key binding becomes active. This value will never
	 * be <code>null</code>.
	 */
	@NonNull
	private final String contextId;

	/**
	 * The identifier of the scheme in which this binding applies. This value
	 * will never be <code>null</code>.
	 */
	@NonNull
	private final String schemeId;

	/**
	 * Create a binding impl
	 *
	 * @param command
	 *            the command
	 * @param schemeId
	 *            the scheme
	 * @param contextId
	 *            the context id
	 */
	public BindingImpl(@NonNull ParameterizedCommand command, @NonNull String schemeId, @NonNull String contextId) {
		this.command = command;
		this.schemeId = schemeId;
		this.contextId = contextId;
	}

	@Override
	public String getContextId() {
		return this.contextId;
	}

	@Override
	public ParameterizedCommand getParameterizedCommand() {
		return this.command;
	}

	@Override
	public String getSchemeId() {
		return this.schemeId;
	}

	@SuppressWarnings("null")
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.command == null) ? 0 : this.command.hashCode());
		result = prime * result + ((this.contextId == null) ? 0 : this.contextId.hashCode());
		result = prime * result + ((this.schemeId == null) ? 0 : this.schemeId.hashCode());
		return result;
	}

	@SuppressWarnings({ "unused", "null" })
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BindingImpl other = (BindingImpl) obj;
		if (this.command == null) {
			if (other.command != null)
				return false;
		} else if (!this.command.equals(other.command))
			return false;
		if (this.contextId == null) {
			if (other.contextId != null)
				return false;
		} else if (!this.contextId.equals(other.contextId))
			return false;
		if (this.schemeId == null) {
			if (other.schemeId != null)
				return false;
		} else if (!this.schemeId.equals(other.schemeId))
			return false;
		return true;
	}
}

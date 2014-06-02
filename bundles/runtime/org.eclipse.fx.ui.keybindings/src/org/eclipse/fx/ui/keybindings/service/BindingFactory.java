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
package org.eclipse.fx.ui.keybindings.service;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.fx.ui.keybindings.Binding;
import org.eclipse.fx.ui.keybindings.KeyLookup;
import org.eclipse.fx.ui.keybindings.KeySequence;
import org.eclipse.fx.ui.keybindings.KeyStroke;
import org.eclipse.fx.ui.keybindings.ParseException;
import org.eclipse.fx.ui.keybindings.TriggerSequence;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Factory to create {@link KeySequence}, {@link Binding} and {@link KeyStroke}
 * instances
 */
public interface BindingFactory {

	/**
	 * Create a key sequence from the string representation
	 * 
	 * @param keylookup
	 *            the key lookup
	 * @param sequence
	 *            the sequence string
	 * @return the key sequence
	 * @throws ParseException
	 *             if the string can not be parsed
	 */
	@NonNull
	KeySequence getKeySequenceInstance(@NonNull KeyLookup keylookup, @NonNull String sequence) throws ParseException;

	/**
	 * @return a default sequence
	 */
	@NonNull
	KeySequence getKeySequenceInstance();

	/**
	 * Create a sequence from a stroke
	 * 
	 * @param keySequence
	 *            the original sequence
	 * @param stroke
	 *            the stroke
	 * @return the new sequence
	 */
	@NonNull
	KeySequence getKeySequenceInstance(@NonNull KeySequence keySequence, @NonNull KeyStroke stroke);

	/**
	 * Create a binding between the sequence and the command
	 * 
	 * @param sequence
	 *            the sequence
	 * @param command
	 *            the command
	 * @param schemeId
	 *            the scheme
	 * @param contextId
	 *            the context id
	 * @return the binding
	 */
	@NonNull
	Binding createKeyBinding(@NonNull TriggerSequence sequence, @NonNull ParameterizedCommand command, @NonNull String schemeId, @NonNull String contextId);

	/**
	 * Create a keystroke from basic data
	 * 
	 * @param lookup
	 *            the lookup or keys
	 * @param modifierKeys
	 *            the modifier mask
	 * @param naturalKey
	 *            the natural key value
	 * @return the stroke
	 */
	@NonNull
	KeyStroke getKeyStrokeInstance(@NonNull KeyLookup lookup, int modifierKeys, int naturalKey);
}

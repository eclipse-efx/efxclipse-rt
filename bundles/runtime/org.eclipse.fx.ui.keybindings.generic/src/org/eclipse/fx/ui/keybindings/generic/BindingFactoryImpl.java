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
import org.eclipse.fx.ui.keybindings.KeyLookup;
import org.eclipse.fx.ui.keybindings.KeySequence;
import org.eclipse.fx.ui.keybindings.KeyStroke;
import org.eclipse.fx.ui.keybindings.ParseException;
import org.eclipse.fx.ui.keybindings.TriggerSequence;
import org.eclipse.fx.ui.keybindings.service.BindingFactory;

public class BindingFactoryImpl implements BindingFactory {

	@Override
	public KeySequence getKeySequenceInstance(KeyLookup keylookup, String sequence) throws ParseException {
		return KeySequenceImpl.getInstance(keylookup, sequence);
	}

	@Override
	public Binding createKeyBinding(TriggerSequence sequence, ParameterizedCommand command, String schemeId, String contextId) {
		return new KeyBindingImpl((KeySequence) sequence, command, schemeId, contextId);
	}

	@Override
	public KeySequence getKeySequenceInstance(KeySequence keySequence, KeyStroke stroke) {
		return KeySequenceImpl.getInstance(keySequence, stroke);
	}
	
	@Override
	public KeySequence getKeySequenceInstance() {
		return KeySequenceImpl.getInstance();
	}
	
	@Override
	public KeyStroke getKeyStrokeInstance(KeyLookup lookup, int modifierKeys, int naturalKey) {
		return KeyStrokeImpl.getInstance(lookup, modifierKeys, naturalKey);
	}

}

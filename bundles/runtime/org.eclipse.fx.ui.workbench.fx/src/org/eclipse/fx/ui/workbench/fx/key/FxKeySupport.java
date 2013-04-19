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
package org.eclipse.fx.ui.workbench.fx.key;

import org.eclipse.fx.ui.keybindings.KeyLookup;
import org.eclipse.fx.ui.keybindings.KeyStroke;
import org.eclipse.fx.ui.keybindings.service.BindingFactory;

import javafx.scene.input.KeyEvent;

public class FxKeySupport {

	public static int convertEventToUnmodifiedAccelerator(KeyEvent event) {
		int modifiers = getStateMask(event) & FxKeyLookup.MODIFIER_MASK;
		return modifiers + event.getCode().impl_getCode();
	}
	
	public static final int convertEventToUnshiftedModifiedAccelerator(
			final KeyEvent event) {
		// Disregard alphabetic key strokes.
		if (Character.isLetter(event.getCharacter().charAt(0))) {
			return convertEventToUnmodifiedAccelerator(event);
		}

		int modifiers = getStateMask(event) & (FxKeyLookup.MODIFIER_MASK ^ FxKeyLookup.SHIFT);
		return modifiers + event.getCode().impl_getCode();
//		char character = topKey(event);
//		return modifiers + toUpperCase(character);
	}

	public static final int convertEventToModifiedAccelerator(final KeyEvent event) {
		int modifiers = getStateMask(event) & FxKeyLookup.MODIFIER_MASK;
		return modifiers + event.getCode().impl_getCode();
//		char character = topKey(event);
//		return modifiers + toUpperCase(character);
	}
	
	public static int getStateMask(KeyEvent event) {
		int rv = 0;
		if( event.isAltDown() ) {
			rv |= FxKeyLookup.ALT;
		}
		if( event.isControlDown() ) {
			rv |= FxKeyLookup.CTRL;
		}
		if( event.isShiftDown() ) {
			rv |= FxKeyLookup.SHIFT;
		}
		if( event.isMetaDown() ) {
			rv |= FxKeyLookup.COMMAND;
		}
		return rv;
	}

	public static KeyStroke convertAcceleratorToKeyStroke(BindingFactory factory, KeyLookup lookup, int accelerator) {
		final int modifierKeys = accelerator & FxKeyLookup.MODIFIER_MASK;
		final int naturalKey;
		if (accelerator == modifierKeys) {
			naturalKey = FxKeyLookup.NO_KEY;
		} else {
			naturalKey = accelerator - modifierKeys;
		}
		
		return factory.getKeyStrokeInstance(lookup, modifierKeys, naturalKey);
	}

	
//	private static final char topKey(final KeyEvent event) {
//		char character = event.getCharacter().charAt(0);
//		boolean ctrlDown = (getStateMask(event) & FxKeyLookup.CTRL) != 0;
//
//		if (ctrlDown && event.character != event.keyCode
//				&& event.character < 0x20 
//				&& (event.keyCode & SWT.KEYCODE_BIT) == 0) {
//			character += 0x40;
//		}
//
//		return character;
//	}
}

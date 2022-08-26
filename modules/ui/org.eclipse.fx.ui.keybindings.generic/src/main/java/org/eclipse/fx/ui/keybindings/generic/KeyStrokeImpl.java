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

import java.util.StringTokenizer;

import javafx.scene.input.KeyCode;

import org.eclipse.fx.ui.controls.JavaFXCompatUtil;
import org.eclipse.fx.ui.keybindings.KeyLookup;
import org.eclipse.fx.ui.keybindings.KeyStroke;
import org.eclipse.fx.ui.keybindings.ParseException;
import org.eclipse.fx.ui.keybindings.Trigger;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Keystore implementation
 */
public class KeyStrokeImpl extends TriggerImpl implements KeyStroke {
	/**
	 * The delimiter between multiple keys in a single key strokes -- expressed
	 * in the formal key stroke grammar. This is not to be displayed to the
	 * user. It is only intended as an internal representation.
	 */
	public static final String KEY_DELIMITER = "\u002B"; //$NON-NLS-1$

	/**
	 * The set of delimiters for <code>Key</code> objects allowed during parsing
	 * of the formal string representation.
	 */
	public static final String KEY_DELIMITERS = KEY_DELIMITER;

	/**
	 * The representation for no key.
	 */
	public static final int NO_KEY = 0;

	static final KeyStroke getInstance(KeyLookup lookup, final String string) throws ParseException {
		if (string == null) {
			throw new NullPointerException("Cannot parse a null string"); //$NON-NLS-1$
		}

		int modifierKeys = NO_KEY;
		int naturalKey = NO_KEY;
		final StringTokenizer stringTokenizer = new StringTokenizer(string, KEY_DELIMITERS, true);
		int i = 0;

		while (stringTokenizer.hasMoreTokens()) {
			String token = stringTokenizer.nextToken();
			if (token != null) {
				if (i % 2 == 0) {
					if (stringTokenizer.hasMoreTokens()) {
						token = token.toUpperCase();
						if (token != null) {
							final int modifierKey = lookup.formalModifierLookup(token);
							if (modifierKey == NO_KEY) {
								throw new ParseException("Cannot create key stroke with duplicate or non-existent modifier key: " //$NON-NLS-1$
										+ token);
							}

							modifierKeys |= modifierKey;
						}
					} else if (token.length() == 1) {
						naturalKey = token.charAt(0);
					} else {
						token = token.toUpperCase();
						if (token != null) {
							naturalKey = lookup.formalKeyLookup(token);
							if (naturalKey == NO_KEY) {
								 KeyCode fxKeyCode = KeyCode.valueOf(token);
								 if (fxKeyCode != null)
									 naturalKey = JavaFXCompatUtil.getCode(fxKeyCode);
							}
						}
						
					}
				}

				i++;
			}
		}

		return new KeyStrokeImpl(lookup, modifierKeys, naturalKey);
	}

	static @NonNull KeyStrokeImpl getInstance(KeyLookup lookup, int modifierKeys, int naturalKey) {
		return new KeyStrokeImpl(lookup, modifierKeys, naturalKey);
	}

	/**
	 * An integer representation of the modifier keys; <code>NO_KEY</code> means
	 * that there is no modifier key.
	 */
	private final int modifierKeys;

	/**
	 * The natural key for this key stroke. This value is <code>NO_KEY</code> if
	 * the key stroke is incomplete (i.e., has no natural key).
	 */
	private final int naturalKey;

	private final KeyLookup lookup;

	/**
	 * Constructs an instance of <code>KeyStroke</code> given a set of modifier
	 * keys and a natural key.
	 * 
	 * @param modifierKeys
	 *            the modifier keys. The format of this integer is defined by
	 *            whichever widget toolkit you are using; <code>NO_KEY</code>
	 *            always means no modifier keys.
	 * @param naturalKey
	 *            the natural key. The format of this integer is defined by
	 *            whichever widget toolkit you are using; <code>NO_KEY</code>
	 *            always means no natural key.
	 * @see SWTKeySupport
	 */
	private KeyStrokeImpl(KeyLookup lookup, final int modifierKeys, final int naturalKey) {
		this.modifierKeys = modifierKeys;
		this.naturalKey = naturalKey;
		this.lookup = lookup;
	}

	/**
	 * Compare to another trigger
	 */
	@Override
	public final int compareTo(final Trigger object) {
		final KeyStrokeImpl keyStroke = (KeyStrokeImpl) object;
		int compareTo = Util.compare(this.modifierKeys, keyStroke.modifierKeys);

		if (compareTo == 0) {
			compareTo = Util.compare(this.naturalKey, keyStroke.naturalKey);
		}

		return compareTo;
	}

	@Override
	public final boolean equals(final Object object) {
		if (!(object instanceof KeyStrokeImpl)) {
			return false;
		}

		final KeyStrokeImpl keyStroke = (KeyStrokeImpl) object;
		if (this.modifierKeys != keyStroke.modifierKeys) {
			return false;
		}

		return (this.naturalKey == keyStroke.naturalKey);
	}

	@Override
	public boolean hasAltModifier() {
		return (this.modifierKeys & this.lookup.getAlt()) != 0;
	}

	@Override
	public boolean hasCtrlModifier() {
		return (this.modifierKeys & this.lookup.getCtrl()) != 0;
	}

	@Override
	public boolean hasShiftModifier() {
		return (this.modifierKeys & this.lookup.getShift()) != 0;
	}

	@Override
	public boolean hasCommandModifier() {
		return (this.modifierKeys & this.lookup.getCommand()) != 0;
	}

	@Override
	public final int hashCode() {
		return this.modifierKeys << 4 + this.naturalKey;
	}

	@Override
	public int getKeyCode() {
		return this.naturalKey;
	}

	@Override
	public String toString() {
		return "Modifiers: " + this.modifierKeys + "; NatKey: " + this.naturalKey; //$NON-NLS-1$ //$NON-NLS-2$
	}
}

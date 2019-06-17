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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.eclipse.fx.ui.keybindings.KeyLookup;
import org.eclipse.fx.ui.keybindings.KeySequence;
import org.eclipse.fx.ui.keybindings.KeyStroke;
import org.eclipse.fx.ui.keybindings.ParseException;
import org.eclipse.fx.ui.keybindings.Trigger;
import org.eclipse.fx.ui.keybindings.TriggerSequence;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A keysequence implementation
 */
public class KeySequenceImpl extends TriggerSequenceImpl implements KeySequence {

	@Override
	public int compareTo(KeySequence o) {
		return Util.compare(getTriggers(), o.getTriggers());
	}

	@NonNull
	private final static KeySequenceImpl EMPTY_KEY_SEQUENCE = new KeySequenceImpl(new KeyStroke[0]);

	private final static String KEY_STROKE_DELIMITER = "\u0020"; //$NON-NLS-1$
	private final static String KEY_STROKE_DELIMITERS = KEY_STROKE_DELIMITER + "\b\r\u007F\u001B\f\n\0\t\u000B"; //$NON-NLS-1$

	KeySequenceImpl(KeyStroke[] triggers) {
		super(triggers);
	}

	@SuppressWarnings("null")
	@Override
	public final @NonNull TriggerSequence[] getPrefixes() {
		final int numberOfPrefixes = getTriggers().length;
		final TriggerSequence[] prefixes = new TriggerSequence[numberOfPrefixes];
		prefixes[0] = KeySequenceImpl.getInstance();
		for (int i = 0; i < numberOfPrefixes - 1; i++) {
			final KeyStroke[] prefixKeyStrokes = new KeyStroke[i + 1];
			System.arraycopy(getTriggers(), 0, prefixKeyStrokes, 0, i + 1);
			prefixes[i + 1] = KeySequenceImpl.getInstance(prefixKeyStrokes);
		}

		return prefixes;
	}

	@Override
	public String format() {
		return Arrays.stream(getTriggers())
				.map(this::formatTrigger)
				.collect(Collectors.joining(" ")); //$NON-NLS-1$
	}
	
	@Override
	public String toString() {
		return format();
	}
	
	private String formatTrigger(Trigger trigger) {
		return trigger.toString();
	}

	static final @NonNull KeySequence getInstance() {
		return EMPTY_KEY_SEQUENCE;
	}

	static final @NonNull KeySequence getInstance(final @NonNull KeyStroke[] keyStrokes) {
		return new KeySequenceImpl(keyStrokes);
	}

	static final @NonNull KeySequence getInstance(final @NonNull KeySequence keySequence, final @NonNull KeyStroke keyStroke) {
		final KeyStroke[] oldKeyStrokes = keySequence.getKeyStrokes();
		final int oldKeyStrokeLength = oldKeyStrokes.length;
		final KeyStroke[] newKeyStrokes = new KeyStroke[oldKeyStrokeLength + 1];
		System.arraycopy(oldKeyStrokes, 0, newKeyStrokes, 0, oldKeyStrokeLength);
		newKeyStrokes[oldKeyStrokeLength] = keyStroke;
		return new KeySequenceImpl(newKeyStrokes);
	}

	static final @NonNull KeySequence getInstance(@NonNull KeyLookup lookup, @NonNull final String string) throws ParseException {
		final List<KeyStroke> keyStrokes = new ArrayList<KeyStroke>();
		final StringTokenizer stringTokenizer = new StringTokenizer(string, KEY_STROKE_DELIMITERS);

		try {
			while (stringTokenizer.hasMoreTokens()) {
				keyStrokes.add(KeyStrokeImpl.getInstance(lookup, stringTokenizer.nextToken()));
			}

			final KeyStroke[] keyStrokeArray = (KeyStroke[]) keyStrokes.toArray(new KeyStroke[keyStrokes.size()]);
			return new KeySequenceImpl(keyStrokeArray);
		} catch (final IllegalArgumentException e) {
			throw new ParseException("Could not construct key sequence with these key strokes: " //$NON-NLS-1$
					+ keyStrokes);
		} catch (final NullPointerException e) {
			throw new ParseException("Could not construct key sequence with these key strokes: " //$NON-NLS-1$
					+ keyStrokes);
		}
	}

	@SuppressWarnings("null")
	@Override
	public final @NonNull KeyStroke[] getKeyStrokes() {
		final int triggerLength = getTriggers().length;
		final KeyStroke[] keyStrokes = new KeyStroke[triggerLength];
		System.arraycopy(getTriggers(), 0, keyStrokes, 0, triggerLength);
		return keyStrokes;
	}
}

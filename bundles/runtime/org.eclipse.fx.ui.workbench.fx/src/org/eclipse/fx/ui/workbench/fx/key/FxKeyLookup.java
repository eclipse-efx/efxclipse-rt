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

import java.util.HashMap;
import java.util.Map;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import org.eclipse.fx.ui.keybindings.KeyLookup;
import org.eclipse.osgi.service.environment.Constants;
import org.osgi.framework.FrameworkUtil;

/**
 * <p>
 * A look-up table for the formal grammar for keys, and the integer values they
 * represent. This look-up table is hard-coded to use SWT representations. By
 * replacing this class (and
 * {@link org.eclipse.jface.bindings.keys.SWTKeySupport}), you can remove the
 * dependency on SWT.
 * </p>
 * 
 * @since 3.1
 * @see org.eclipse.jface.bindings.keys.KeyLookupFactory
 */
public final class FxKeyLookup implements KeyLookup {

	/**
	 * The look-up table for modifier keys. This is a map of formal name (
	 * <code>String</code>) to integer value (<code>Integer</code>).
	 */
	private final Map<String, Integer> modifierKeyTable = new HashMap<String, Integer>();

	/**
	 * The look-up table for formal names. This is a map of integer value (
	 * <code>Integer</code>) to formal name (<code>String</code>).
	 */
	private final Map<Integer, String> nameTable = new HashMap<Integer, String>();

	/**
	 * The look-up table for natural keys. This is a map of formal name (
	 * <code>String</code>) to integer value (<code>Integer</code>).
	 */
	private final Map<String, Integer> naturalKeyTable = new HashMap<String, Integer>();

	public static final int ALT = 1 << 16;
	public static final int SHIFT = 1 << 17;
	public static final int CTRL = 1 << 18;
	public static final int COMMAND = 1 << 22;
	public static final int MODIFIER_MASK = ALT | SHIFT | CTRL | COMMAND;
	public static final int NO_KEY = 0;

	private static final boolean isMac = Constants.OS_MACOSX.equals(FrameworkUtil.getBundle(FxKeyLookup.class).getBundleContext().getProperty("osgi.os"));
	private static final String ZERO_LENGTH_STRING = ""; //$NON-NLS-1$

	/**
	 * Constructs a new look-up class. This should only be done by the look-up
	 * factory.
	 * 
	 * @see KeyLookupFactory
	 */
	@SuppressWarnings("deprecation")
	public FxKeyLookup() {
		final Integer alt = new Integer(ALT);
		final Integer command = new Integer(COMMAND);
		final Integer ctrl = new Integer(CTRL);
		final Integer shift = new Integer(SHIFT);
		modifierKeyTable.put(ALT_NAME, alt);
		nameTable.put(alt, ALT_NAME);
		modifierKeyTable.put(COMMAND_NAME, command);
		nameTable.put(command, COMMAND_NAME);
		modifierKeyTable.put(CTRL_NAME, ctrl);
		nameTable.put(ctrl, CTRL_NAME);
		modifierKeyTable.put(SHIFT_NAME, shift);
		nameTable.put(shift, SHIFT_NAME);
		modifierKeyTable.put(M1_NAME, isMac ? command : ctrl);
		modifierKeyTable.put(M2_NAME, shift);
		modifierKeyTable.put(M3_NAME, alt);
		modifierKeyTable.put(M4_NAME, isMac ? ctrl : command);

		// FIXME Port to FX
		{
			final Integer code = Integer.valueOf(KeyCode.DOWN.impl_getCode());
			naturalKeyTable.put(ARROW_DOWN_NAME, code);
			nameTable.put(code, ARROW_DOWN_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.LEFT.impl_getCode());
			naturalKeyTable.put(ARROW_LEFT_NAME, code);
			nameTable.put(code, ARROW_LEFT_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.RIGHT.impl_getCode());
			naturalKeyTable.put(ARROW_RIGHT_NAME, code);
			nameTable.put(code, ARROW_RIGHT_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.UP.impl_getCode());
			naturalKeyTable.put(ARROW_UP_NAME, code);
			nameTable.put(code, ARROW_UP_NAME);
		}
		// final Integer breakKey = new Integer(SWT.BREAK);
		// naturalKeyTable.put(BREAK_NAME, breakKey);
		// nameTable.put(breakKey, BREAK_NAME);
		{
			final Integer code = Integer.valueOf(KeyCode.BACK_SPACE.impl_getCode());
			naturalKeyTable.put(BS_NAME, code);
			nameTable.put(code, BS_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.CAPS.impl_getCode());
			naturalKeyTable.put(CAPS_LOCK_NAME, code);
			nameTable.put(code, CAPS_LOCK_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.ENTER.impl_getCode());
			naturalKeyTable.put(CR_NAME, code);
			nameTable.put(code, CR_NAME);
			naturalKeyTable.put(ENTER_NAME, code);
			naturalKeyTable.put(RETURN_NAME, code);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.DELETE.impl_getCode());
			naturalKeyTable.put(DEL_NAME, code);
			nameTable.put(code, DEL_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.END.impl_getCode());
			naturalKeyTable.put(END_NAME, code);
			nameTable.put(code, END_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.ESCAPE.impl_getCode());
			naturalKeyTable.put(ESC_NAME, code);
			nameTable.put(code, ESC_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F1.impl_getCode());
			naturalKeyTable.put(F1_NAME, code);
			nameTable.put(code, F1_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F2.impl_getCode());
			naturalKeyTable.put(F2_NAME, code);
			nameTable.put(code, F2_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F3.impl_getCode());
			naturalKeyTable.put(F3_NAME, code);
			nameTable.put(code, F3_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F4.impl_getCode());
			naturalKeyTable.put(F4_NAME, code);
			nameTable.put(code, F4_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F5.impl_getCode());
			naturalKeyTable.put(F5_NAME, code);
			nameTable.put(code, F5_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F6.impl_getCode());
			naturalKeyTable.put(F6_NAME, code);
			nameTable.put(code, F6_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F7.impl_getCode());
			naturalKeyTable.put(F7_NAME, code);
			nameTable.put(code, F7_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F8.impl_getCode());
			naturalKeyTable.put(F8_NAME, code);
			nameTable.put(code, F8_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F9.impl_getCode());
			naturalKeyTable.put(F9_NAME, code);
			nameTable.put(code, F9_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F10.impl_getCode());
			naturalKeyTable.put(F10_NAME, code);
			nameTable.put(code, F10_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F11.impl_getCode());
			naturalKeyTable.put(F11_NAME, code);
			nameTable.put(code, F11_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F12.impl_getCode());
			naturalKeyTable.put(F12_NAME, code);
			nameTable.put(code, F12_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F13.impl_getCode());
			naturalKeyTable.put(F13_NAME, code);
			nameTable.put(code, F13_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F14.impl_getCode());
			naturalKeyTable.put(F14_NAME, code);
			nameTable.put(code, F14_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F15.impl_getCode());
			naturalKeyTable.put(F15_NAME, code);
			nameTable.put(code, F15_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F16.impl_getCode());
			naturalKeyTable.put(F16_NAME, code);
			nameTable.put(code, F16_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F17.impl_getCode());
			naturalKeyTable.put(F17_NAME, code);
			nameTable.put(code, F17_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F18.impl_getCode());
			naturalKeyTable.put(F18_NAME, code);
			nameTable.put(code, F18_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F19.impl_getCode());
			naturalKeyTable.put(F19_NAME, code);
			nameTable.put(code, F19_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.F20.impl_getCode());
			naturalKeyTable.put(F20_NAME, code);
			nameTable.put(code, F20_NAME);
		}
		// final Integer ff = new Integer(12); // ASCII 0x0C
		// naturalKeyTable.put(FF_NAME, ff);
		// nameTable.put(ff, FF_NAME);

		{
			final Integer code = Integer.valueOf(KeyCode.HOME.impl_getCode());
			naturalKeyTable.put(HOME_NAME, code);
			nameTable.put(code, HOME_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.INSERT.impl_getCode());
			naturalKeyTable.put(INSERT_NAME, code);
			nameTable.put(code, INSERT_NAME);
		}
		// final Integer lf = new Integer(SWT.LF);
		// naturalKeyTable.put(LF_NAME, lf);
		// nameTable.put(lf, LF_NAME);
		// final Integer nul = new Integer(SWT.NULL);
		// naturalKeyTable.put(NUL_NAME, nul);
		// nameTable.put(nul, NUL_NAME);

		{
			final Integer code = Integer.valueOf(KeyCode.NUM_LOCK.impl_getCode());
			naturalKeyTable.put(NUM_LOCK_NAME, code);
			nameTable.put(code, NUM_LOCK_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.NUMPAD0.impl_getCode());
			naturalKeyTable.put(NUMPAD_0_NAME, code);
			nameTable.put(code, NUMPAD_0_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.NUMPAD1.impl_getCode());
			naturalKeyTable.put(NUMPAD_1_NAME, code);
			nameTable.put(code, NUMPAD_1_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.NUMPAD2.impl_getCode());
			naturalKeyTable.put(NUMPAD_2_NAME, code);
			nameTable.put(code, NUMPAD_2_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.NUMPAD3.impl_getCode());
			naturalKeyTable.put(NUMPAD_3_NAME, code);
			nameTable.put(code, NUMPAD_3_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.NUMPAD4.impl_getCode());
			naturalKeyTable.put(NUMPAD_4_NAME, code);
			nameTable.put(code, NUMPAD_4_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.NUMPAD5.impl_getCode());
			naturalKeyTable.put(NUMPAD_5_NAME, code);
			nameTable.put(code, NUMPAD_5_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.NUMPAD6.impl_getCode());
			naturalKeyTable.put(NUMPAD_6_NAME, code);
			nameTable.put(code, NUMPAD_6_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.NUMPAD7.impl_getCode());
			naturalKeyTable.put(NUMPAD_7_NAME, code);
			nameTable.put(code, NUMPAD_7_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.NUMPAD8.impl_getCode());
			naturalKeyTable.put(NUMPAD_8_NAME, code);
			nameTable.put(code, NUMPAD_8_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.NUMPAD9.impl_getCode());
			naturalKeyTable.put(NUMPAD_9_NAME, code);
			nameTable.put(code, NUMPAD_9_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.ADD.impl_getCode());
			naturalKeyTable.put(NUMPAD_ADD_NAME, code);
			nameTable.put(code, NUMPAD_ADD_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.DECIMAL.impl_getCode());
			naturalKeyTable.put(NUMPAD_DECIMAL_NAME, code);
			nameTable.put(code, NUMPAD_DECIMAL_NAME);
		}
		// final Integer keypadDivide = new Integer(SWT.KEYPAD_DIVIDE);
		// naturalKeyTable.put(NUMPAD_DIVIDE_NAME, keypadDivide);
		// nameTable.put(keypadDivide, NUMPAD_DIVIDE_NAME);
		// final Integer keypadCr = new Integer(SWT.KEYPAD_CR);
		// naturalKeyTable.put(NUMPAD_ENTER_NAME, keypadCr);
		// nameTable.put(keypadCr, NUMPAD_ENTER_NAME);
		// final Integer keypadEqual = new Integer(SWT.KEYPAD_EQUAL);
		// naturalKeyTable.put(NUMPAD_EQUAL_NAME, keypadEqual);
		// nameTable.put(keypadEqual, NUMPAD_EQUAL_NAME);
		// final Integer keypadMultiply = new Integer(SWT.KEYPAD_MULTIPLY);
		// naturalKeyTable.put(NUMPAD_MULTIPLY_NAME, keypadMultiply);
		// nameTable.put(keypadMultiply, NUMPAD_MULTIPLY_NAME);
		// final Integer keypadSubtract = new Integer(SWT.KEYPAD_SUBTRACT);
		// naturalKeyTable.put(NUMPAD_SUBTRACT_NAME, keypadSubtract);
		// nameTable.put(keypadSubtract, NUMPAD_SUBTRACT_NAME);
		{
			final Integer code = Integer.valueOf(KeyCode.PAGE_DOWN.impl_getCode());
			naturalKeyTable.put(PAGE_DOWN_NAME, code);
			nameTable.put(code, PAGE_DOWN_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.PAGE_UP.impl_getCode());
			naturalKeyTable.put(PAGE_UP_NAME, code);
			nameTable.put(code, PAGE_UP_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.PAUSE.impl_getCode());
			naturalKeyTable.put(PAUSE_NAME, code);
			nameTable.put(code, PAUSE_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.PRINTSCREEN.impl_getCode());
			naturalKeyTable.put(PRINT_SCREEN_NAME, code);
			nameTable.put(code, PRINT_SCREEN_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.SCROLL_LOCK.impl_getCode());
			naturalKeyTable.put(SCROLL_LOCK_NAME, code);
			nameTable.put(code, SCROLL_LOCK_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.SPACE.impl_getCode());
			naturalKeyTable.put(SPACE_NAME, code);
			nameTable.put(code, SPACE_NAME);
		}
		{
			final Integer code = Integer.valueOf(KeyCode.TAB.impl_getCode());
			naturalKeyTable.put(TAB_NAME, code);
			nameTable.put(code, TAB_NAME);
		}
		// final Integer vt = new Integer(11); // ASCII 0x0B
		// naturalKeyTable.put(VT_NAME, vt);
		// nameTable.put(vt, VT_NAME);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.bindings.keys.IKeyLookup#formalKeyLookup(java.lang.
	 * String)
	 */
	public final int formalKeyLookup(final String name) {
		final Object value = naturalKeyTable.get(name);
		if (value instanceof Integer) {
			return ((Integer) value).intValue();
		}

		if (name.length() > 0) {
			throw new IllegalArgumentException("Unrecognized formal key name: " //$NON-NLS-1$
					+ name);
		}

		return name.charAt(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.bindings.keys.IKeyLookup#formalKeyLookupInteger(java
	 * .lang.String)
	 */
	public final Integer formalKeyLookupInteger(final String name) {
		final Object value = naturalKeyTable.get(name);
		if (value instanceof Integer) {
			return (Integer) value;
		}

		return new Integer(name.charAt(0));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.bindings.keys.IKeyLookup#formalModifierLookup(java.
	 * lang.String)
	 */
	public final int formalModifierLookup(final String name) {
		final Object value = modifierKeyTable.get(name);
		if (value instanceof Integer) {
			return ((Integer) value).intValue();
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.bindings.keys.IKeyLookup#formalNameLookup(int)
	 */
	public final String formalNameLookup(final int key) {
		final Integer keyObject = new Integer(key);
		final Object value = nameTable.get(keyObject);
		if (value instanceof String) {
			return (String) value;
		}

		return ZERO_LENGTH_STRING + ((char) key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.bindings.keys.IKeyLookup#getAlt()
	 */
	public final int getAlt() {
		return ALT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.bindings.keys.IKeyLookup#getCommand()
	 */
	public final int getCommand() {
		return COMMAND;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.bindings.keys.IKeyLookup#getCtrl()
	 */
	public final int getCtrl() {
		return CTRL;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.bindings.keys.IKeyLookup#getShift()
	 */
	public final int getShift() {
		return SHIFT;
	}

	// /*
	// * (non-Javadoc)
	// *
	// * @see org.eclipse.jface.bindings.keys.IKeyLookup#isModifierKey(int)
	// *
	// */
	// public final boolean isModifierKey(final int key) {
	// return ((key & SWT.MODIFIER_MASK) != 0);
	// }
}

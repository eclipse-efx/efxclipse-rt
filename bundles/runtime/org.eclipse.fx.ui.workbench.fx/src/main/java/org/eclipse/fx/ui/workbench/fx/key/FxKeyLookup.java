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

import org.eclipse.fx.ui.controls.JavaFXCompatUtil;
import org.eclipse.fx.ui.keybindings.KeyLookup;
import org.eclipse.osgi.service.environment.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.component.annotations.Component;

/**
 * <p>
 * A look-up table for the formal grammar for keys, and the integer values they
 * represent.
 * </p>
 *
 * @since 3.1
 */
@Component
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

	/**
	 * Constant for the ALT modifier
	 */
	public static final int ALT = 1 << 16;
	/**
	 * Constant for the SHIFT modifier
	 */
	public static final int SHIFT = 1 << 17;
	/**
	 * Constant for the CTRL modifier
	 */
	public static final int CTRL = 1 << 18;
	/**
	 * Constant for the COMMAND modifier
	 */
	public static final int COMMAND = 1 << 22;
	/**
	 * Modifier mask
	 */
	public static final int MODIFIER_MASK = ALT | SHIFT | CTRL | COMMAND;
	/**
	 * No key constant
	 */
	public static final int NO_KEY = 0;

	private static final boolean isMac = Constants.OS_MACOSX.equals(FrameworkUtil.getBundle(FxKeyLookup.class).getBundleContext().getProperty("osgi.os")); //$NON-NLS-1$
	private static final String ZERO_LENGTH_STRING = ""; //$NON-NLS-1$

	/**
	 * Constructs a new look-up class. This should only be done by the look-up
	 * factory.
	 */
	public FxKeyLookup() {
		final Integer alt = Integer.valueOf(ALT);
		final Integer command = Integer.valueOf(COMMAND);
		final Integer ctrl = Integer.valueOf(CTRL);
		final Integer shift = Integer.valueOf(SHIFT);
		this.modifierKeyTable.put(ALT_NAME, alt);
		this.nameTable.put(alt, ALT_NAME);
		this.modifierKeyTable.put(COMMAND_NAME, command);
		this.nameTable.put(command, COMMAND_NAME);
		this.modifierKeyTable.put(CTRL_NAME, ctrl);
		this.nameTable.put(ctrl, CTRL_NAME);
		this.modifierKeyTable.put(SHIFT_NAME, shift);
		this.nameTable.put(shift, SHIFT_NAME);
		this.modifierKeyTable.put(M1_NAME, isMac ? command : ctrl);
		this.modifierKeyTable.put(M2_NAME, shift);
		this.modifierKeyTable.put(M3_NAME, alt);
		this.modifierKeyTable.put(M4_NAME, isMac ? ctrl : command);

		// FIXME Port to FX
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.DOWN));
			this.naturalKeyTable.put(ARROW_DOWN_NAME, code);
			this.nameTable.put(code, ARROW_DOWN_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.LEFT));
			this.naturalKeyTable.put(ARROW_LEFT_NAME, code);
			this.nameTable.put(code, ARROW_LEFT_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.RIGHT));
			this.naturalKeyTable.put(ARROW_RIGHT_NAME, code);
			this.nameTable.put(code, ARROW_RIGHT_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.UP));
			this.naturalKeyTable.put(ARROW_UP_NAME, code);
			this.nameTable.put(code, ARROW_UP_NAME);
		}
		// final Integer breakKey = new Integer(SWT.BREAK);
		// naturalKeyTable.put(BREAK_NAME, breakKey);
		// nameTable.put(breakKey, BREAK_NAME);
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.BACK_SPACE));
			this.naturalKeyTable.put(BS_NAME, code);
			this.nameTable.put(code, BS_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.CAPS));
			this.naturalKeyTable.put(CAPS_LOCK_NAME, code);
			this.nameTable.put(code, CAPS_LOCK_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.ENTER));
			this.naturalKeyTable.put(CR_NAME, code);
			this.nameTable.put(code, CR_NAME);
			this.naturalKeyTable.put(ENTER_NAME, code);
			this.naturalKeyTable.put(RETURN_NAME, code);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.DELETE));
			this.naturalKeyTable.put(DEL_NAME, code);
			this.nameTable.put(code, DEL_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.END));
			this.naturalKeyTable.put(END_NAME, code);
			this.nameTable.put(code, END_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.ESCAPE));
			this.naturalKeyTable.put(ESC_NAME, code);
			this.nameTable.put(code, ESC_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F1));
			this.naturalKeyTable.put(F1_NAME, code);
			this.nameTable.put(code, F1_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F2));
			this.naturalKeyTable.put(F2_NAME, code);
			this.nameTable.put(code, F2_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F3));
			this.naturalKeyTable.put(F3_NAME, code);
			this.nameTable.put(code, F3_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F4));
			this.naturalKeyTable.put(F4_NAME, code);
			this.nameTable.put(code, F4_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F5));
			this.naturalKeyTable.put(F5_NAME, code);
			this.nameTable.put(code, F5_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F6));
			this.naturalKeyTable.put(F6_NAME, code);
			this.nameTable.put(code, F6_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F7));
			this.naturalKeyTable.put(F7_NAME, code);
			this.nameTable.put(code, F7_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F8));
			this.naturalKeyTable.put(F8_NAME, code);
			this.nameTable.put(code, F8_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F9));
			this.naturalKeyTable.put(F9_NAME, code);
			this.nameTable.put(code, F9_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F10));
			this.naturalKeyTable.put(F10_NAME, code);
			this.nameTable.put(code, F10_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F11));
			this.naturalKeyTable.put(F11_NAME, code);
			this.nameTable.put(code, F11_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F12));
			this.naturalKeyTable.put(F12_NAME, code);
			this.nameTable.put(code, F12_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F13));
			this.naturalKeyTable.put(F13_NAME, code);
			this.nameTable.put(code, F13_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F14));
			this.naturalKeyTable.put(F14_NAME, code);
			this.nameTable.put(code, F14_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F15));
			this.naturalKeyTable.put(F15_NAME, code);
			this.nameTable.put(code, F15_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F16));
			this.naturalKeyTable.put(F16_NAME, code);
			this.nameTable.put(code, F16_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F17));
			this.naturalKeyTable.put(F17_NAME, code);
			this.nameTable.put(code, F17_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F18));
			this.naturalKeyTable.put(F18_NAME, code);
			this.nameTable.put(code, F18_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F19));
			this.naturalKeyTable.put(F19_NAME, code);
			this.nameTable.put(code, F19_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.F20));
			this.naturalKeyTable.put(F20_NAME, code);
			this.nameTable.put(code, F20_NAME);
		}
		// final Integer ff = new Integer(12); // ASCII 0x0C
		// naturalKeyTable.put(FF_NAME, ff);
		// nameTable.put(ff, FF_NAME);

		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.HOME));
			this.naturalKeyTable.put(HOME_NAME, code);
			this.nameTable.put(code, HOME_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.INSERT));
			this.naturalKeyTable.put(INSERT_NAME, code);
			this.nameTable.put(code, INSERT_NAME);
		}
		// final Integer lf = new Integer(SWT.LF);
		// naturalKeyTable.put(LF_NAME, lf);
		// nameTable.put(lf, LF_NAME);
		// final Integer nul = new Integer(SWT.NULL);
		// naturalKeyTable.put(NUL_NAME, nul);
		// nameTable.put(nul, NUL_NAME);

		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.NUM_LOCK));
			this.naturalKeyTable.put(NUM_LOCK_NAME, code);
			this.nameTable.put(code, NUM_LOCK_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.NUMPAD0));
			this.naturalKeyTable.put(NUMPAD_0_NAME, code);
			this.nameTable.put(code, NUMPAD_0_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.NUMPAD1));
			this.naturalKeyTable.put(NUMPAD_1_NAME, code);
			this.nameTable.put(code, NUMPAD_1_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.NUMPAD2));
			this.naturalKeyTable.put(NUMPAD_2_NAME, code);
			this.nameTable.put(code, NUMPAD_2_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.NUMPAD3));
			this.naturalKeyTable.put(NUMPAD_3_NAME, code);
			this.nameTable.put(code, NUMPAD_3_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.NUMPAD4));
			this.naturalKeyTable.put(NUMPAD_4_NAME, code);
			this.nameTable.put(code, NUMPAD_4_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.NUMPAD5));
			this.naturalKeyTable.put(NUMPAD_5_NAME, code);
			this.nameTable.put(code, NUMPAD_5_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.NUMPAD6));
			this.naturalKeyTable.put(NUMPAD_6_NAME, code);
			this.nameTable.put(code, NUMPAD_6_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.NUMPAD7));
			this.naturalKeyTable.put(NUMPAD_7_NAME, code);
			this.nameTable.put(code, NUMPAD_7_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.NUMPAD8));
			this.naturalKeyTable.put(NUMPAD_8_NAME, code);
			this.nameTable.put(code, NUMPAD_8_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.NUMPAD9));
			this.naturalKeyTable.put(NUMPAD_9_NAME, code);
			this.nameTable.put(code, NUMPAD_9_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.ADD));
			this.naturalKeyTable.put(NUMPAD_ADD_NAME, code);
			this.nameTable.put(code, NUMPAD_ADD_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.DECIMAL));
			this.naturalKeyTable.put(NUMPAD_DECIMAL_NAME, code);
			this.nameTable.put(code, NUMPAD_DECIMAL_NAME);
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
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.PAGE_DOWN));
			this.naturalKeyTable.put(PAGE_DOWN_NAME, code);
			this.nameTable.put(code, PAGE_DOWN_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.PAGE_UP));
			this.naturalKeyTable.put(PAGE_UP_NAME, code);
			this.nameTable.put(code, PAGE_UP_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.PAUSE));
			this.naturalKeyTable.put(PAUSE_NAME, code);
			this.nameTable.put(code, PAUSE_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.PRINTSCREEN));
			this.naturalKeyTable.put(PRINT_SCREEN_NAME, code);
			this.nameTable.put(code, PRINT_SCREEN_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.SCROLL_LOCK));
			this.naturalKeyTable.put(SCROLL_LOCK_NAME, code);
			this.nameTable.put(code, SCROLL_LOCK_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.SPACE));
			this.naturalKeyTable.put(SPACE_NAME, code);
			this.nameTable.put(code, SPACE_NAME);
		}
		{
			final Integer code = Integer.valueOf(JavaFXCompatUtil.getCode(KeyCode.TAB));
			this.naturalKeyTable.put(TAB_NAME, code);
			this.nameTable.put(code, TAB_NAME);
		}
		// final Integer vt = new Integer(11); // ASCII 0x0B
		// naturalKeyTable.put(VT_NAME, vt);
		// nameTable.put(vt, VT_NAME);
	}

	@Override
	 public final String formalNameLookup(final int key) {
	  final Integer keyObject = Integer.valueOf(key);
	  final Object value = this.nameTable.get(keyObject);
	  if (value instanceof String) {
	   return (String) value;
	  }

	  return ZERO_LENGTH_STRING + ((char) key);
	 }

	@Override
	public final int formalKeyLookup(final String name) {
		final Object value = this.naturalKeyTable.get(name);
		if (value instanceof Integer) {
			return ((Integer) value).intValue();
		}
		return NO_KEY;
	}

	@Override
	public final int formalModifierLookup(final String name) {
		final Object value = this.modifierKeyTable.get(name);
		if (value instanceof Integer) {
			return ((Integer) value).intValue();
		}
		return NO_KEY;
	}

	@Override
	public final int getAlt() {
		return ALT;
	}

	@Override
	public final int getCommand() {
		return COMMAND;
	}

	@Override
	public final int getCtrl() {
		return CTRL;
	}

	@Override
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

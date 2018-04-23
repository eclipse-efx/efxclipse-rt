/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.fx.core.SystemUtils;
import org.eclipse.fx.core.log.LoggerCreator;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.stage.Window;

/**
 * Set of utility allowing to access none public JavaFX APIs for different
 * JavaFX versions.
 *
 * Historically JavaFX-2/8 had public methods prefixed with <code>impl_</code>
 * who get replaced with property API in JavaFX-9 and some of them got removed
 * or made internal.
 *
 * @since 3.0
 */
public class JavaFXCompatUtil {
	/**
	 * @return current list of JavaFX windows shown
	 */
	@SuppressWarnings("unchecked")
	public static List<Window> getAllWindows() {
		try {
			if (SystemUtils.getMajorFXVersion() > 8) {
				// ObservableList<Window> windows = Window.getWindows();
				return ((List<Window>) Window.class.getMethod("getWindows").invoke(null)); //$NON-NLS-1$
			} else {
				// impl_getWindows = Window.impl_getWindows();
				Iterator<Window> it = (Iterator<Window>) Window.class.getMethod("impl_getWindows").invoke(null); //$NON-NLS-1$
				List<Window> rv = new ArrayList<>();
				while (it.hasNext()) {
					rv.add(it.next());
				}
				return Collections.unmodifiableList(rv);
			}
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}

	/**
	 * Returns the underlying platform code used to represent the
	 * {@link #getChar(KeyCode) character} in the key code.
	 *
	 * @param keyCode
	 *            the key code instance
	 * @return the keycode
	 */
	public static int getCode(KeyCode keyCode) {
		if (SystemUtils.getMajorFXVersion() > 8) {
			try {
				return ((Integer) KeyCode.class.getMethod("getCode").invoke(keyCode)).intValue(); //$NON-NLS-1$
			} catch (Throwable t) {
				LoggerCreator.createLogger(JavaFXCompatUtil.class).error("Unable to call KeyCode#getCode()", t); //$NON-NLS-1$
				throw new RuntimeException(t);
			}
		} else {
			try {
				return ((Integer) KeyCode.class.getMethod("impl_getCode").invoke(keyCode)).intValue(); //$NON-NLS-1$
			} catch (Throwable t) {
				LoggerCreator.createLogger(JavaFXCompatUtil.class).error("Unable to call KeyCode#impl_getCode()", t); //$NON-NLS-1$
				throw new RuntimeException(t);
			}
		}

	}

	/**
	 * Returns the character element of this key code, which is simply a mapping
	 * of the underlying platform code returned by {@link #getCode(KeyCode)}.
	 *
	 * @param keyCode
	 *            the keycode
	 * @return the character
	 */
	public static String getChar(KeyCode keyCode) {
		if (SystemUtils.getMajorFXVersion() > 8) {
			try {
				return (String) KeyCode.class.getMethod("getChar").invoke(keyCode); //$NON-NLS-1$
			} catch (Throwable t) {
				LoggerCreator.createLogger(JavaFXCompatUtil.class).error("Unable to call KeyCode#getChar()", t); //$NON-NLS-1$
				throw new RuntimeException(t);
			}
		} else {
			try {
				return (String) KeyCode.class.getMethod("impl_getChar").invoke(keyCode); //$NON-NLS-1$
			} catch (Throwable t) {
				LoggerCreator.createLogger(JavaFXCompatUtil.class).error("Unable to call KeyCode#impl_getChar()", t); //$NON-NLS-1$
				throw new RuntimeException(t);
			}
		}

	}

	/**
	 * Force reapplying the CSS on the provided node
	 *
	 * @param node
	 *            the node
	 */
	public static void reapplyCSS(Node node) {
		if (SystemUtils.getMajorFXVersion() > 8) {
			try {
				Method m = Node.class.getDeclaredMethod("reapplyCSS"); //$NON-NLS-1$
				m.setAccessible(true);
				m.invoke(node);
			} catch (Throwable t) {
				LoggerCreator.createLogger(JavaFXCompatUtil.class).error("Unable to call Node#reapplyCSS()", t); //$NON-NLS-1$
				throw new RuntimeException(t);
			}

		} else {
			try {
				Method m = Node.class.getDeclaredMethod("impl_reapplyCSS"); //$NON-NLS-1$
				m.invoke(node);
			} catch (Throwable t) {
				LoggerCreator.createLogger(JavaFXCompatUtil.class).error("Unable to call Node#impl_reapplyCSS()", t); //$NON-NLS-1$
				throw new RuntimeException(t);
			}
		}
	}
}

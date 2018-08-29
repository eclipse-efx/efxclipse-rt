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

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.PathElement;
import javafx.scene.text.Text;
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

	/**
	 * Set the caret position
	 * 
	 * @param t
	 *            the text node
	 * @param value
	 *            the value
	 * @since 3.4.0
	 */
	public static void setCaretPosition(Text t, int value) {
		if (SystemUtils.getMajorFXVersion() > 8) {
			try {
				Method m = Text.class.getDeclaredMethod("setPosition", int.class); //$NON-NLS-1$
				m.invoke(t, Integer.valueOf(value));
			} catch (Throwable e) {
				LoggerCreator.createLogger(JavaFXCompatUtil.class).error("Unable to call Text#setPosition()", e); //$NON-NLS-1$
				throw new RuntimeException(e);
			}
		} else {
			try {
				Method m = Text.class.getDeclaredMethod("setImpl_caretPosition", int.class); //$NON-NLS-1$
				m.invoke(t, Integer.valueOf(value));
			} catch (Throwable e) {
				LoggerCreator.createLogger(JavaFXCompatUtil.class).error("Unable to call Text#setImpl_caretPosition()", e); //$NON-NLS-1$
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * Get the caret shape
	 * 
	 * @param t
	 *            the text node
	 * @return the path elements
	 * @since 3.4.0
	 */
	public static PathElement[] getCaretShape(Text t) {
		if (SystemUtils.getMajorFXVersion() > 8) {
			try {
				Method m = Text.class.getDeclaredMethod("getCaretShape"); //$NON-NLS-1$
				return (PathElement[]) m.invoke(t);
			} catch (Throwable e) {
				LoggerCreator.createLogger(JavaFXCompatUtil.class).error("Unable to call Text#getCaretShape()", e); //$NON-NLS-1$
				throw new RuntimeException(e);
			}
		} else {
			try {
				Method m = Text.class.getDeclaredMethod("getImpl_caretShape"); //$NON-NLS-1$
				return (PathElement[]) m.invoke(t);
			} catch (Throwable e) {
				LoggerCreator.createLogger(JavaFXCompatUtil.class).error("Unable to call Text#getImpl_caretShape()", e); //$NON-NLS-1$
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * Maps local point to index in the content.
	 * 
	 * @param t
	 *            the text
	 * @param point
	 *            the point
	 * @return the index or <code>null</code> if no hit
	 */
	public static Integer getInsertionIndex(Text t, Point2D point) {
		Object hitInfo = null;
		if (SystemUtils.getMajorFXVersion() > 8) {
			try {
				Method m = Text.class.getDeclaredMethod("impl_hitTestChar", Point2D.class); //$NON-NLS-1$
				hitInfo = m.invoke(t, point);
			} catch (Throwable e) {
				LoggerCreator.createLogger(JavaFXCompatUtil.class).error("Unable to call Text#impl_hitTestChar(Point2D)"); //$NON-NLS-1$
				throw new RuntimeException(e);
			}
		} else {
			try {
				Method m = Text.class.getDeclaredMethod("hitTest", Point2D.class); //$NON-NLS-1$
				hitInfo = m.invoke(t, point);
			} catch (Throwable e) {
				LoggerCreator.createLogger(JavaFXCompatUtil.class).error("Unable to call Text#impl_hitTestChar(Point2D)"); //$NON-NLS-1$
				throw new RuntimeException(e);
			}
		}

		if (hitInfo != null) {
			try {
				Method m = hitInfo.getClass().getMethod("getInsertionIndex"); //$NON-NLS-1$
				return (Integer) m.invoke(hitInfo);
			} catch (Throwable e) {
				LoggerCreator.createLogger(JavaFXCompatUtil.class).error("Unable to call HitInfo#getInsertionIndex()"); //$NON-NLS-1$
				throw new RuntimeException(e);
			}
		}
		return null;
	}

	/**
	 * Compute the insertation index for a given point
	 * 
	 * @param t
	 *            the text
	 * @param point
	 *            the location relative to the text node
	 * @return the index
	 */
	public static Integer insertationIndex(Text t, Point2D point) {
		if (SystemUtils.getMajorFXVersion() > 8) {
			try {
				Method m = Text.class.getDeclaredMethod("hitTestChar", Point2D.class); //$NON-NLS-1$
				Object hitTest = m.invoke(t, point);
				if (hitTest != null) {
					Method m2 = hitTest.getClass().getDeclaredMethod("getInsertionIndex"); //$NON-NLS-1$
					return (Integer) m2.invoke(hitTest, point);
				}
			} catch (Throwable e) {
				LoggerCreator.createLogger(JavaFXCompatUtil.class).error("Unable to call Text#getImpl_caretShape()", e); //$NON-NLS-1$
				throw new RuntimeException(e);
			}
		} else {
			try {
				Method m = Text.class.getDeclaredMethod("impl_hitTestChar", Point2D.class); //$NON-NLS-1$
				Object hitTest = m.invoke(t, point);
				if (hitTest != null) {
					Method m2 = hitTest.getClass().getDeclaredMethod("getInsertionIndex"); //$NON-NLS-1$
					return (Integer) m2.invoke(hitTest, point);
				}
			} catch (Throwable e) {
				LoggerCreator.createLogger(JavaFXCompatUtil.class).error("Unable to call Text#getImpl_caretShape()", e); //$NON-NLS-1$
				throw new RuntimeException(e);
			}
		}
		return null;
	}
}

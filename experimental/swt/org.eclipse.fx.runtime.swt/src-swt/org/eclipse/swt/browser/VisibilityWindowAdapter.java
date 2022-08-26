/*******************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.browser;

/**
 * This adapter class provides default implementations for the
 * methods described by the {@link VisibilityWindowListener} interface.
 * <p>
 * Classes that wish to deal with {@link WindowEvent}'s can
 * extend this class and override only the methods which they are
 * interested in.
 * </p>
 * 
 * @see <a href="http://www.eclipse.org/swt/">Sample code and further information</a>
 *
 * @since 3.0
 */
public abstract class VisibilityWindowAdapter implements VisibilityWindowListener {

public void hide(WindowEvent event) {
}
 
public void show(WindowEvent event) {
}
}

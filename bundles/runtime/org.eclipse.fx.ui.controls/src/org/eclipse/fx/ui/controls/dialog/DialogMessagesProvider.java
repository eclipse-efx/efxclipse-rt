/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.dialog;

import java.util.ResourceBundle;

import org.eclipse.fx.core.text.TextRegistry;

/**
 * Provider responsible to provide text messages
 */
public interface DialogMessagesProvider extends TextRegistry {
	/**
	 * @return the title of the frame
	 */
	public String frameTitle();
	
	/**
	 * @return the ok message
	 */
	public default String ok() {
		return ResourceBundle.getBundle("org.eclipse.fx.ui.controls.dialog.messages").getString("ok"); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	/**
	 * @return the cancel message
	 */
	public default String cancel() {
		return ResourceBundle.getBundle("org.eclipse.fx.ui.controls.dialog.messages").getString("cancel"); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	/**
	 * @return the close message
	 */
	public default String close() {
		return ResourceBundle.getBundle("org.eclipse.fx.ui.controls.dialog.messages").getString("close"); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	/**
	 * @return the close message
	 */
	public default String yes() {
		return ResourceBundle.getBundle("org.eclipse.fx.ui.controls.dialog.messages").getString("yes"); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	/**
	 * @return the close message
	 */
	public default String no() {
		return ResourceBundle.getBundle("org.eclipse.fx.ui.controls.dialog.messages").getString("no"); //$NON-NLS-1$ //$NON-NLS-2$
	}
}

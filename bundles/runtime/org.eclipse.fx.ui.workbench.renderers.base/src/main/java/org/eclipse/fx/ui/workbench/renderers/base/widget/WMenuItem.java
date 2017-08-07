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
package org.eclipse.fx.ui.workbench.renderers.base.widget;

import org.eclipse.e4.ui.model.application.ui.menu.MMenuItem;
import org.eclipse.fx.ui.keybindings.KeySequence;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Abstraction of a menu item
 * 
 * @param <N>
 *            the native widget
 */
public interface WMenuItem<N> extends WMenuElement<MMenuItem> {
	/**
	 * Callback to invoke when the item is selected
	 * 
	 * @param runnable
	 *            the runnable to invoke
	 */
	void setOnActionCallback(@NonNull Runnable runnable);

	/**
	 * Inform if the menu item is handled
	 * 
	 * @param handled
	 *            <code>true</code> if handled
	 */
	void setHandled(boolean handled);

	/**
	 * Associating a accelerator with the item
	 * 
	 * @param sequence
	 *            the sequence
	 */
	void setAccelerator(@Nullable KeySequence sequence);
}

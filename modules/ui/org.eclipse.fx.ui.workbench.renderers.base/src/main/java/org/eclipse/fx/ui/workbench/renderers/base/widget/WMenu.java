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
package org.eclipse.fx.ui.workbench.renderers.base.widget;

import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Abstraction of menus
 * 
 * @param <N>
 *            the native widget
 */
public interface WMenu<N> extends WMenuElement<MMenu> {
	/**
	 * Append a widget
	 * 
	 * @param widget
	 *            the widget
	 */
	void addElement(@NonNull WMenuElement<MMenuElement> widget);

	/**
	 * Insert a widget at the given index
	 * 
	 * @param idx
	 *            the index
	 * @param widget
	 *            the widget
	 */
	void addElement(int idx, @NonNull WMenuElement<MMenuElement> widget);

	/**
	 * Callback invoked when the menu is shown
	 * 
	 * @param showingCallback
	 *            the callback
	 */
	void setShowingCallback(@NonNull Runnable showingCallback);

	/**
	 * Remove the widget
	 * 
	 * @param widget
	 *            the widget to remove
	 */
	void removeElement(@NonNull WMenuElement<MMenuElement> widget);

	/**
	 * Callback invoked when the menu is hidden
	 * 
	 * @param hidingCallback
	 *            the callback
	 */
	void setHidingCallback(@NonNull Runnable hidingCallback);
}
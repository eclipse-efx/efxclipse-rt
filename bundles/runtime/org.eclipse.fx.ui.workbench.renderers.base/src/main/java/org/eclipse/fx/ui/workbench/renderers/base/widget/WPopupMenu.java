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

import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MPopupMenu;

/**
 * Abstraction of a popup menu
 * 
 * @param <N>
 *            the native widget
 */
public interface WPopupMenu<N> extends WMenuElement<MPopupMenu> {

	/**
	 * Append a widget
	 * 
	 * @param widget
	 *            the widget
	 */
	void addElement(WMenuElement<MMenuElement> widget);

	/**
	 * Insert a widget at the given index
	 * 
	 * @param idx
	 *            the index
	 * @param widget
	 *            the widget
	 */
	void addElement(int idx, WMenuElement<MMenuElement> widget);

	/**
	 * Callback to invoke when the menu is shown
	 * 
	 * @param showingCallback
	 *            the callback
	 */
	void setShowingCallback(Runnable showingCallback);

	/**
	 * Callback to invoke when the menu is hidden
	 * 
	 * @param hidingCallback
	 *            the callback
	 */
	void setHidingCallback(Runnable hidingCallback);

	/**
	 * Remove a widget
	 * 
	 * @param widget
	 *            the widget
	 */
	void removeElement(WMenuElement<MMenuElement> widget);
}
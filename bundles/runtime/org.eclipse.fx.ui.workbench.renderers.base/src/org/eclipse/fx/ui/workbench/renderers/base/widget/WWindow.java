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

import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.basic.MWindowElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Window abstraction
 * 
 * @param <N>
 *            the native type
 */
public interface WWindow<N> extends WWidget<MWindow> {
	/**
	 * Set a main menu
	 * 
	 * @param menuWidget
	 *            the main menu widget
	 */
	public void setMainMenu(@Nullable WLayoutedWidget<MMenu> menuWidget);

	/**
	 * Set the top trim
	 * 
	 * @param trimBar
	 *            the widget shown in the top trim area
	 */
	public void setTopTrim(@Nullable WLayoutedWidget<MTrimBar> trimBar);

	/**
	 * Set the left trim
	 * 
	 * @param trimBar
	 *            the widget shown in the left trim area
	 */
	public void setLeftTrim(@Nullable WLayoutedWidget<MTrimBar> trimBar);

	/**
	 * Set the right trim
	 * 
	 * @param trimBar
	 *            the widget shown in the right trim area
	 */
	public void setRightTrim(@Nullable WLayoutedWidget<MTrimBar> trimBar);

	/**
	 * Set the bottom trim
	 * 
	 * @param trimBar
	 *            the widget shown in the bottom trim area
	 */
	public void setBottomTrim(@Nullable WLayoutedWidget<MTrimBar> trimBar);

	/**
	 * Append a child widget shown in the center
	 * 
	 * @param widget
	 *            the widget
	 */
	public void addChild(@NonNull WLayoutedWidget<MWindowElement> widget);

	/**
	 * Insert a child widget at the given index
	 * 
	 * @param idx
	 *            the index
	 * @param widget
	 *            the widget
	 */
	public void addChild(int idx, @NonNull WLayoutedWidget<MWindowElement> widget);

	/**
	 * Remove a child widget
	 * 
	 * @param widget
	 *            the widget
	 */
	public void removeChild(@NonNull WLayoutedWidget<MWindowElement> widget);

	/**
	 * Add a child window
	 * 
	 * @param widget
	 *            the window
	 */
	public void addChildWindow(@NonNull WWindow<N> widget);

	/**
	 * Remove the given child window
	 * 
	 * @param widget
	 *            the window
	 */
	public void removeChildWindow(@NonNull WWindow<N> widget);

	/**
	 * Add a callback to veto the closing of the window
	 * 
	 * @param closeCallback
	 *            the callback
	 */
	public void setOnCloseCallback(@NonNull WCallback<WWindow<N>, Boolean> closeCallback);

	/**
	 * Show the window
	 */
	public void show();

	/**
	 * Hide the window
	 */
	public void close();
}

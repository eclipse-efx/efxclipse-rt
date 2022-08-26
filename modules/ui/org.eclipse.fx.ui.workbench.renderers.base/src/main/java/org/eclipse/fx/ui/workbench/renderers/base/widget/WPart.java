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

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Abstract of a part widget
 *
 * @param <N>
 *            the native widget
 * @param <T>
 *            the toolbar widget
 * @param <M>
 *            the menu widget
 */
public interface WPart<N, T, M> extends WLayoutedWidget<MPart>, WDialogHost {
	/**
	 * Show a trim area at the top with the icon and title of the view
	 *
	 * @since 2.2.0
	 */
	public static final String SHOW_TOP_TRIM_AREA_TAG = "showTopTrimArea"; //$NON-NLS-1$
	
	/**
	 * Wrap the content so that it can be collapsed
	 * 
	 * @since 3.8.0
	 */
	public static final String WITH_COLLAPSIBLE_CONTENT = "fx_withCollapsibleContent"; //$NON-NLS-1$

	/**
	 * Set a toolbar
	 *
	 * @param widget
	 *            the widget
	 */
	public void setToolbar(@Nullable WToolBar<T> widget);

	/**
	 * Set a menu
	 *
	 * @param widget
	 *            the widget
	 */
	public void setMenu(@Nullable WMenu<M> widget);

	/**
	 * @return the current menu
	 */
	@Nullable
	public WMenu<M> getMenu();

	/**
	 * @return the current toolbar
	 */
	@Nullable
	public WToolBar<T> getToolbar();
}

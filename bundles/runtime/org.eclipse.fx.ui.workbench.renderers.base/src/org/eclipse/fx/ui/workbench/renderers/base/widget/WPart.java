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

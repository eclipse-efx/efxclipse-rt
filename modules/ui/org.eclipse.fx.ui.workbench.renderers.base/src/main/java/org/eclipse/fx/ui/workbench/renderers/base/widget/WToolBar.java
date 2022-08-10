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

import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBarElement;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Widget abstraction for toolbars
 * 
 * @param <N>
 *            the native widget
 */
public interface WToolBar<N> extends WLayoutedWidget<MToolBar> {
	/**
	 * Append a child
	 * 
	 * @param itemWidget
	 *            the widget to append
	 */
	void addChild(@NonNull WWidget<MToolBarElement> itemWidget);

	/**
	 * Insert a child at a given position
	 * 
	 * @param idx
	 *            the index
	 * @param widget
	 *            the widget
	 */
	void addChild(int idx, @NonNull WWidget<MToolBarElement> widget);

	/**
	 * Remove a widget
	 * 
	 * @param widget
	 *            the widget
	 */
	void removeChild(@NonNull WWidget<MToolBarElement> widget);

}

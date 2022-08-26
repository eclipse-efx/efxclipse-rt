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

import java.util.List;

import org.eclipse.e4.ui.model.application.ui.advanced.MArea;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Abstraction of area widget
 * 
 * @param <N>
 *            the native widget
 */
public interface WArea<N> extends WLayoutedWidget<MArea> {
	/**
	 * Append a widget
	 * 
	 * @param widget
	 *            the widget
	 */
	public void addItem(@NonNull WLayoutedWidget<MPartSashContainerElement> widget);

	/**
	 * @return number of current children
	 */
	public int getItemCount();

	/**
	 * Append multiple widgets
	 * 
	 * @param list
	 *            the list of widgets
	 */
	public void addItems(@NonNull List<WLayoutedWidget<MPartSashContainerElement>> list);

	/**
	 * Insert multiple widgets at the given index
	 * 
	 * @param index
	 *            the index
	 * @param list
	 *            the widgets to add
	 */
	public void addItems(int index, @NonNull List<WLayoutedWidget<MPartSashContainerElement>> list);

	/**
	 * Remove a widget
	 * 
	 * @param widget
	 *            the widget
	 */
	public void removeItem(@NonNull WLayoutedWidget<MPartSashContainerElement> widget);

}

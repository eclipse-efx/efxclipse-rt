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

import java.util.List;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Abstraction of perspective widget
 * 
 * @param <N>
 *            the native
 */
public interface WPerspective<N> extends WLayoutedWidget<MPerspective>, WDialogHost, WMaximizationHost {

	/**
	 * Append widgets
	 * 
	 * @param list
	 *            the list of widgets
	 */
	void addItems(@NonNull List<WLayoutedWidget<MPartSashContainerElement>> list);

	/**
	 * Insert widgets at the given index
	 * 
	 * @param index
	 *            the index
	 * @param widget
	 *            the widget
	 */
	void addItem(int index, @NonNull WLayoutedWidget<MPartSashContainerElement> widget);

	/**
	 * Remove widgets
	 * 
	 * @param widget
	 *            the widget
	 */
	void removeItem(@NonNull WLayoutedWidget<MUIElement> widget);

}

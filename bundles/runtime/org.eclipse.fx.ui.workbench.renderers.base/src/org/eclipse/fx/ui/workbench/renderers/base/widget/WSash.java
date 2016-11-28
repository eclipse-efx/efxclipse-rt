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

import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Widget abstraction for sash
 *
 * @param <N>
 *            the native widget
 */
public interface WSash<N> extends WLayoutedWidget<MPartSashContainer> {
	/**
	 * PersistatedState Key to fix the layout.
	 * <p>
	 * Value type is boolean.
	 * </p>
	 */
	public static final String TAG_FIXED_LAYOUT = "fx_fixedLayout"; //$NON-NLS-1$

	/**
	 * PersistatedState Key to specify the fixed layout width - only has an
	 * effect when used with {@link #TAG_FIXED_LAYOUT}.
	 * <p>
	 * Value type is int.
	 * </p>
	 */
	public static final String FIXED_LAYOUT_WIDTH = "fx_layout_width"; //$NON-NLS-1$
	/**
	 * PersistatedState Key to specify the fixed layout height - only has an
	 * effect when used with {@link #TAG_FIXED_LAYOUT}
	 * <p>
	 * Value type is int.
	 * </p>
	 */
	public static final String FIXED_LAYOUT_HEIGHT = "fx_layout_height"; //$NON-NLS-1$
	/**
	 * PersistatedState Key to specify that the control should grab the
	 * remaining horizontal space
	 * <p>
	 * Value type is boolean.
	 * </p>
	 */
	public static final String FIXED_LAYOUT_GRAB_HORIZONTAL = "fx_layout_grab_horizontal"; //$NON-NLS-1$
	/**
	 * PersistatedState Key to specify that the control should grab the
	 * remaining vertical space
	 * <p>
	 * Value type is boolean.
	 * </p>
	 */
	public static final String FIXED_LAYOUT_GRAB_VERTICAL = "fx_layout_grab_vertical"; //$NON-NLS-1$

	/**
	 * A child of a sash tagged with {@link #TAG_NO_AUTO_RESIZE} will not resize
	 * if its parent is growing shrinking
	 */
	public static final String TAG_NO_AUTO_RESIZE = "fx_no_auto_resize"; //$NON-NLS-1$

	/**
	 * Append a widget
	 *
	 * @param widget
	 *            the widget
	 */
	public void addItem(@NonNull WLayoutedWidget<MPartSashContainerElement> widget);

	/**
	 * @return amount of children
	 */
	public int getItemCount();

	/**
	 * Append a list of widgets
	 *
	 * @param list
	 *            the list of widgets
	 */
	public void addItems(@NonNull List<WLayoutedWidget<MPartSashContainerElement>> list);

	/**
	 * Insert items at the given index
	 *
	 * @param index
	 *            the index
	 * @param list
	 *            the list of items
	 */
	public void addItems(int index, @NonNull List<WLayoutedWidget<MPartSashContainerElement>> list);

	/**
	 * Remove item
	 *
	 * @param widget
	 *            the widget
	 */
	public void removeItem(@NonNull WLayoutedWidget<MPartSashContainerElement> widget);

	/**
	 * Update the layout
	 */
	public void updateLayout();
}
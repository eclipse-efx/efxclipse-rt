/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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

import org.eclipse.e4.ui.model.application.ui.basic.MCompositePart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Widget abstraction for a composite part widget
 * 
 * @param <N>
 *            the native widget
 */
public interface WCompositePart<N> extends WLayoutedWidget<MCompositePart> {
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
	 * Sets the toolbar.
	 *
	 * @param toolbar
	 *            the {@link WToolBar} to be set.
	 */
	public void setToolbar(WToolBar<N> toolbar);

	/**
	 * Sets the menu.
	 * 
	 * @param menu
	 *            the {@link WMenu} to be set.
	 */
	public void setMenu(WMenu<N> menu);

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

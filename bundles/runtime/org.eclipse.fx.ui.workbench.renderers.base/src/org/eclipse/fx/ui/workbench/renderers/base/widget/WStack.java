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

import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Abstraction of a stack widget
 *
 * @param <N>
 *            the native widget
 * @param <I>
 *            the native stack item widget
 * @param <IC>
 *            the native stack item content widget
 */
public interface WStack<N, I, IC> extends WLayoutedWidget<MPartStack>, WMinMaxableWidget, WDragSourceWidget, WDragTargetWidget {
	/**
	 * Tag to use a pagination control
	 */
	public static final String TAG_PAGINATION = "fx_pagination"; //$NON-NLS-1$
	/**
	 * None of the tabs can be closed
	 * @since 1.2
	 */
	public static final String TAG_TAB_CLOSING_POLICY_UNAVAILABLE = "fx_tab_closing_policy_unavailable"; //$NON-NLS-1$
	/**
	 * Only the selected tab can be closed
	 * @since 1.2
	 */
	public static final String TAG_TAB_CLOSING_POLICY_SELECTED_TAB = "fx_tab_closing_policy_selectedTab"; //$NON-NLS-1$
	/**
	 * All tabs can be closed
	 * @since 1.2
	 */
	public static final String TAG_TAB_CLOSING_POLICY_ALL_TABS = "fx_tab_closing_policy_allTabs"; //$NON-NLS-1$

	/**
	 * Location of the tabs. Supported values depend on the control
	 */
	public static final String STATE_KEY_TABS_LOCATION = "fx.stack.tabslocation"; //$NON-NLS-1$

	/**
	 * Abstraction representing an item in the stack
	 *
	 * @param <I>
	 *            the native item type
	 * @param <IC>
	 *            the native content element type
	 */
	public interface WStackItem<I, IC> {
		/**
		 * @return the native item
		 */
		@Nullable
		public I getNativeItem();

		/**
		 * Attach the application model element
		 *
		 * @param domElement
		 *            the element
		 */
		public void setDomElement(@NonNull MStackElement domElement);

		/**
		 * @return the currently associated application model element
		 */
		@Nullable
		public MStackElement getDomElement();

		/**
		 * Set a callback to invoke when the tab is activated the first time
		 *
		 * @param callback
		 *            the callback
		 */
		public void setInitCallback(@NonNull WCallback<@NonNull WStackItem<I, IC>, @Nullable IC> callback);

		/**
		 * Set a callback to invoke when the tab is closed and veto it if
		 * desired
		 *
		 * @param callback
		 *            the callback
		 */
		public void setOnCloseCallback(@NonNull WCallback<@NonNull WStackItem<I, IC>, Boolean> callback);
	}

	/**
	 * @return the class used to represent the stack items
	 */
	@NonNull
	public Class<? extends WStackItem<I, IC>> getStackItemClass();

	/**
	 * Append a stack item
	 *
	 * @param item
	 *            the item
	 */
	public void addItem(@NonNull WStackItem<I, IC> item);

	/**
	 * Append multiple stack items
	 *
	 * @param items
	 *            the items to append
	 */
	public void addItems(@NonNull List<@NonNull WStackItem<I, IC>> items);

	/**
	 * Insert stack items at the given index
	 *
	 * @param index
	 *            the index
	 * @param items
	 *            the items to add
	 */
	public void addItems(int index, @NonNull List<@NonNull WStackItem<I, IC>> items);

	/**
	 * Select the item at a given index
	 *
	 * @param idx
	 *            the index to select
	 */
	public void selectItem(int idx);

	/**
	 * The index of the item
	 *
	 * @param item
	 *            the item
	 * @return the index or <code>-1</code> if not found
	 */
	public int indexOf(@NonNull WStackItem<I, IC> item);

	/**
	 * @return all items
	 */
	@NonNull
	public List<@NonNull WStackItem<I, IC>> getItems();

	/**
	 * Remove items
	 *
	 * @param items
	 *            the items to remove
	 */
	public void removeItems(@NonNull List<@NonNull WStackItem<I, IC>> items);

	/**
	 * Set the callback to be used when the item is selected by the mouse
	 *
	 * @param selectedItemCallback
	 *            the callback
	 */
	public void setMouseSelectedItemCallback(@NonNull WCallback<@NonNull WStackItem<I, IC>, Void> selectedItemCallback);

	/**
	 * Set the callback to be used when the item is selected by the keyboard
	 *
	 * @param selectedItemCallback
	 *            the callback
	 */
	public void setKeySelectedItemCallback(@NonNull WCallback<@NonNull WStackItem<I, IC>, Void> selectedItemCallback);

	/**
	 * @return the number of items
	 */
	public int getItemCount();
}

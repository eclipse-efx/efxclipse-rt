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

import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Abstraction of the perspective stack
 * 
 * @param <N>
 *            the native widget
 * @param <I>
 *            the stack item type
 * @param <IC>
 *            the type of the stack items content
 */
public interface WPerspectiveStack<N, I, IC> extends WLayoutedWidget<MPerspectiveStack> {
	/**
	 * Abstraction of the stack item
	 * 
	 * @param <I>
	 *            the type
	 * @param <IC>
	 *            the type of the content
	 */
	public interface WStackItem<I, IC> {
		/**
		 * @return the native item
		 */
		@Nullable
		public I getNativeItem();

		/**
		 * The application model element
		 * 
		 * @param domElement
		 *            the model element
		 */
		public void setDomElement(@NonNull MPerspective domElement);

		/**
		 * @return the application model element
		 */
		@Nullable
		public MPerspective getDomElement();

		/**
		 * Callback invoked on first activation of the perspective
		 * 
		 * @param callback
		 *            the callback to invoke
		 */
		public void setInitCallback(@NonNull WCallback<WStackItem<I, IC>, IC> callback);

		/**
		 * Callback to invoke when the perspective is closed and to veto it
		 * 
		 * @param callback
		 *            the callback to invoke
		 */
		public void setOnCloseCallback(@NonNull WCallback<WStackItem<I, IC>, Boolean> callback);
	}

	/**
	 * @return the class type representing the stack item
	 */
	@NonNull
	public Class<? extends WStackItem<I, IC>> getStackItemClass();

	/**
	 * Append an item to the stack
	 * 
	 * @param item
	 *            the item
	 */
	public void addItem(@NonNull WStackItem<I, IC> item);

	/**
	 * Append a list if items to the stack
	 * 
	 * @param items
	 *            the list of items
	 */
	public void addItems(@NonNull List<WStackItem<I, IC>> items);

	/**
	 * Insert items at the given index
	 * 
	 * @param index
	 *            the index
	 * @param items
	 *            the items
	 */
	public void addItems(int index, @NonNull List<WStackItem<I, IC>> items);

	/**
	 * Select the item at the index
	 * 
	 * @param idx
	 *            the index
	 */
	public void selectItem(int idx);

	/**
	 * Find the index of the given item
	 * 
	 * @param item
	 *            the item
	 * @return the index or <code>-1</code> if not found
	 */
	public int indexOf(@NonNull WStackItem<I, IC> item);

	/**
	 * @return all stack items
	 */
	@NonNull
	public List<WStackItem<I, IC>> getItems();

	/**
	 * Remove items
	 * 
	 * @param items
	 *            the items
	 */
	public void removeItems(@NonNull List<WStackItem<I, IC>> items);

	/**
	 * Callback invoked when activation is done by the mouse
	 * 
	 * @param selectedItemCallback
	 *            the callback to invoke
	 */
	public void setMouseSelectedItemCallback(@NonNull WCallback<WStackItem<I, IC>, Void> selectedItemCallback);

	/**
	 * Callback invoked when the activation is done by the keyboard
	 * 
	 * @param selectedItemCallback
	 *            the callback to invoke
	 */
	public void setKeySelectedItemCallback(@NonNull WCallback<WStackItem<I, IC>, Void> selectedItemCallback);

	/**
	 * @return number of items
	 */
	public int getItemCount();
}

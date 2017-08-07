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

import org.eclipse.e4.ui.model.application.ui.menu.MToolItem;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Widget abstraction for a tool item
 * 
 * @param <N>
 *            the native widget
 */
public interface WToolItem<N> extends WWidget<MToolItem> {
	/**
	 * Tag used to mark a tool item to be a checkbox
	 */
	public static final String TAG_CHECKBOX = "fx_checkbox"; //$NON-NLS-1$

	/**
	 * The callback invoked when the item is clicked
	 * 
	 * @param onActionCallback
	 *            the callback
	 */
	public void setOnActionCallback(@NonNull Runnable onActionCallback);

	/**
	 * Inform the widget that it is backed by a handler
	 * 
	 * @param handled
	 *            <code>true</code> if handled
	 */
	public void setHandled(boolean handled);
}
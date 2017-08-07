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

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Mixin to implement for widgets who act as drag source
 */
public interface WDragSourceWidget {
	/**
	 * Set a callback invoked on drag start
	 *
	 * @param dragStackCallback
	 *            the callback
	 */
	public void setDragStartCallback(@NonNull WCallback<@NonNull DragData, @NonNull Boolean> dragStackCallback);

	/**
	 * Drag data
	 */
	public static class DragData {
		/**
		 * The stack
		 */
		@NonNull
		public final MUIElement container;
		/**
		 * The item
		 */
		@NonNull
		public final MUIElement item;

		/**
		 * Create a new drag data instance
		 *
		 * @param container
		 *            the container
		 * @param item
		 *            the item
		 */
		public DragData(@NonNull MUIElement container, @NonNull MStackElement item) {
			this.container = container;
			this.item = item;
		}
	}
}

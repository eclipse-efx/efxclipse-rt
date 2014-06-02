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

import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
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
		public final MPartStack stack;
		/**
		 * The item
		 */
		@NonNull 
		public final MStackElement item;

		/**
		 * Create a new drag data instance
		 * 
		 * @param stack
		 *            the stack
		 * @param item
		 *            the item
		 */
		public DragData(@NonNull MPartStack stack, @NonNull MStackElement item) {
			this.stack = stack;
			this.item = item;
		}
	}
}

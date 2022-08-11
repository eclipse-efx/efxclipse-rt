/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Mixin implemented by widget who act as drag target
 */
public interface WDragTargetWidget {
	/**
	 * Callback to invoke when element is dropped
	 * 
	 * @param callback
	 *            the callback
	 */
	public void setDragDroppedCallback(@Nullable WCallback<@NonNull DropData, @Nullable Void> callback);

	/**
	 * @return the current callback
	 */
	public @Nullable WCallback<@NonNull DropData, @Nullable Void> getDropDroppedCallback();

	/**
	 * The drop type
	 */
	public enum BasicDropLocation implements DropLocation {
		/**
		 * Before the reference element
		 */
		BEFORE, /**
				 * After the reference element
				 */
		AFTER, /**
				 * Detach the reference element
				 */
		DETACH, /**
				 * Insert the element into the reference
				 */
		INSERT, /**
				 * Split vertical and put the new item above the other
				 */
		SPLIT_TOP, /**
					 * Split vertical and put the new item below the other
					 */
		SPLIT_BOTTOM, /**
						 * split horizontal and put the new item left to the
						 * other
						 */
		SPLIT_LEFT, /**
					 * split horizontal and put the new item right to the other
					 */
		SPLIT_RIGHT;

		@Override
		public boolean isReorder() {
			return this == BEFORE || this == AFTER;
		}

		@Override
		public boolean isSplit() {
			return this == SPLIT_TOP || this == SPLIT_BOTTOM || this == SPLIT_LEFT || this == SPLIT_RIGHT;
		}

		@Override
		public boolean isInsert() {
			return this == INSERT;
		}

		@Override
		public boolean isDetach() {
			return this == DETACH;
		}

		@Override
		public boolean isCustom() {
			return false;
		}
	}

	/**
	 * Interface implemented by drop locations basic types are provided by
	 * {@link BasicDropLocation}
	 */
	public interface DropLocation {
		/**
		 * @return is it a reordering (might include a reparent)
		 */
		public boolean isReorder();

		/**
		 * @return if it is a split (might include a reparent)
		 */
		public boolean isSplit();

		/**
		 * @return if it is a insert (might include a reparent)
		 */
		public boolean isInsert();

		/**
		 * @return if it is a detach
		 */
		public boolean isDetach();

		/**
		 * @return if it is a custom type
		 */
		public boolean isCustom();
	}

	/**
	 * Drop data
	 */
	public static class DropData {
		/**
		 * The reference element
		 */
		@Nullable
		public final MUIElement reference;
		/**
		 * The source element
		 */
		@NonNull
		public final MUIElement sourceElement;
		/**
		 * The drop type
		 */
		@NonNull
		public final DropLocation dropType;

		/**
		 * The x coordinate relative to the screen
		 */
		public final double x;
		/**
		 * The y coordinate relative to the screen
		 */
		public final double y;

		/**
		 * Create new drop data
		 * 
		 * @param x
		 *            the x coordinate of the drop relative to the screen
		 * @param y
		 *            the y coordinate of the drop relative to the screen
		 * 
		 * @param reference
		 *            the reference
		 * @param sourceElement
		 *            the source element
		 * @param dropType
		 *            the drop type
		 */
		public DropData(double x, double y, @Nullable MUIElement reference, @NonNull MUIElement sourceElement, @NonNull DropLocation dropType) {
			this.x = x;
			this.y = y;
			this.reference = reference;
			this.sourceElement = sourceElement;
			this.dropType = dropType;
		}
	}
}

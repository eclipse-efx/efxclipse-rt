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
package org.eclipse.fx.ui.controls.tabpane;

import java.util.function.Consumer;
import java.util.function.Function;

import javafx.geometry.Bounds;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.DragEvent;

import org.eclipse.fx.ui.controls.tabpane.skin.DnDTabPaneSkin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Factory to create a tab pane who support DnD
 */
public final class DndTabPaneFactory {
	private DndTabPaneFactory() {

	}

	/**
	 * Create a tab pane and set the drag strategy
	 * 
	 * @param setup
	 *            the setup instance for the pane
	 * @return the tab pane
	 */
	public static TabPane createDndTabPane(Consumer<DragSetup> setup) {
		return new TabPane() {
			@Override
			protected javafx.scene.control.Skin<?> createDefaultSkin() {
				DnDTabPaneSkin skin = new DnDTabPaneSkin(this);
				setup.accept(skin);
				return skin;
			}
		};
	}

	/**
	 * Extract the tab content
	 * 
	 * @param e
	 *            the event
	 * @return the content
	 */
	public static boolean hasDnDContent(DragEvent e) {
		return e.getDragboard().hasContent(DnDTabPaneSkin.TAB_MOVE);
	}

	/**
	 * Extract the tab content
	 * 
	 * @param e
	 *            the event
	 * @return the content
	 */
	public static String getDnDContent(DragEvent e) {
		return (String) e.getDragboard().getContent(DnDTabPaneSkin.TAB_MOVE);
	}

	/**
	 * The drop type
	 */
	public enum DropType {
		/**
		 * No dropping
		 */
		NONE,
		/**
		 * Dropped before a reference tab
		 */
		BEFORE,
		/**
		 * Dropped after a reference tab
		 */
		AFTER
	}

	/**
	 * Data to create a feedback
	 */
	public static class FeedbackData {
		/**
		 * The tab dragged
		 */
		public final @NonNull Tab draggedTab;
		/**
		 * The reference tab
		 */
		public final Tab targetTab;
		/**
		 * The bounds of the reference tab
		 */
		public final Bounds bounds;
		/**
		 * The drop type
		 */
		public final @NonNull DropType dropType;

		/**
		 * Create a feedback data
		 * 
		 * @param draggedTab
		 *            the dragged tab
		 * @param targetTab
		 *            the reference tab
		 * @param bounds
		 *            the bounds of the reference tab
		 * @param dropType
		 *            the drop type
		 */
		public FeedbackData(@NonNull Tab draggedTab, Tab targetTab, Bounds bounds, @NonNull DropType dropType) {
			this.draggedTab = draggedTab;
			this.targetTab = targetTab;
			this.bounds = bounds;
			this.dropType = dropType;
		}
	}

	/**
	 * The drop data
	 */
	public static class DroppedData {
		/**
		 * The dragged tab
		 */
		public final @NonNull Tab draggedTab;
		/**
		 * The reference tab
		 */
		public final @NonNull Tab targetTab;
		/**
		 * The drop type
		 */
		public final @NonNull DropType dropType;

		/**
		 * Create drop data
		 * 
		 * @param draggedTab
		 *            the dragged tab
		 * @param targetTab
		 *            the target tab
		 * @param dropType
		 *            the drop type
		 */
		public DroppedData(@NonNull Tab draggedTab, @NonNull Tab targetTab, @NonNull DropType dropType) {
			this.draggedTab = draggedTab;
			this.targetTab = targetTab;
			this.dropType = dropType;
		}
	}

	/**
	 * Setup of the drag and drop
	 */
	public interface DragSetup {
		/**
		 * Function to handle the starting of the the drag
		 * 
		 * @param startFunction
		 *            the function
		 */
		public void setStartFunction(@Nullable Function<@NonNull Tab, @NonNull Boolean> startFunction);

		/**
		 * Consumer called to handle the finishing of the drag process
		 * 
		 * @param dragFinishedConsumer
		 *            the consumer
		 */
		public void setDragFinishedConsumer(@Nullable Consumer<@NonNull Tab> dragFinishedConsumer);

		/**
		 * Consumer called to present drag feedback
		 * 
		 * @param feedbackConsumer
		 *            the consumer to call
		 */
		public void setFeedbackConsumer(@Nullable Consumer<@NonNull FeedbackData> feedbackConsumer);

		/**
		 * Consumer called when the drop has to be handled
		 * 
		 * @param dropConsumer
		 *            the consumer
		 */
		public void setDropConsumer(@Nullable Consumer<@NonNull DroppedData> dropConsumer);

		/**
		 * Function to translate the tab content into clipboard content
		 * 
		 * @param clipboardDataFunction
		 *            the function
		 */
		public void setClipboardDataFunction(@Nullable Function<@NonNull Tab, @NonNull String> clipboardDataFunction);
	}
}

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
import java.util.function.Supplier;

import org.eclipse.fx.core.SystemUtils;
import org.eclipse.fx.ui.controls.dnd.EFXDragEvent;
import org.eclipse.fx.ui.controls.markers.PositionMarker;
import org.eclipse.fx.ui.controls.markers.TabOutlineMarker;
import org.eclipse.fx.ui.controls.tabpane.skin.DndTabPaneSkinHooker;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.control.TabPane;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * Factory to create a tab pane who support DnD
 */
public final class DndTabPaneFactory {
	private static MarkerFeedback CURRENT_FEEDBACK;

	private DndTabPaneFactory() {

	}

	/**
	 * Setup a drag and drop for the given instance
	 *
	 * @param feedbackType
	 *            the feedback type
	 * @param dragSetup
	 *            the drag setup
	 * @param detachHandler
	 *            the detach handler
	 * @return a node to add to the scene graph
	 */
	public static <D extends Node & DragSetup> Pane setup(FeedbackType feedbackType, D dragSetup, Consumer<GenericTab> detachHandler) {
		StackPane pane = new StackPane();
		setup(() -> feedbackType, pane, pane.getChildren(), dragSetup, detachHandler);
		pane.getChildren().add(dragSetup);
		return pane;
	}

	/**
	 * Create a tab pane and set the drag strategy
	 *
	 * @param setup
	 *            the setup instance for the pane
	 * @return the tab pane
	 */
	public static TabPane createDndTabPane(Consumer<DragSetup> setup) {
		return createDndTabPane(setup, false);
	}

	/**
	 * Create a tab pane with a default setup for drag feedback
	 *
	 * @param feedbackType
	 *            the feedback type
	 * @return a pane containing the TabPane
	 */
	public static TabPane createDefaultDnDPane(FeedbackType feedbackType) {
		return createDefaultDnDPane(feedbackType, false);
	}

	/**
	 * Create a tab pane and set the drag strategy
	 *
	 * @param setup
	 *            the setup instance for the pane
	 * @param allowDetach
	 *            allow detaching
	 * @return the tab pane
	 */
	public static TabPane createDndTabPane(Consumer<DragSetup> setup, boolean allowDetach) {
		return new DndTabPane(allowDetach, setup);
	}

	/**
	 * Create a tab pane with a default setup for drag feedback
	 *
	 * @param feedbackType
	 *            the feedback type
	 * @param allowDetach
	 *            allow detaching
	 * @return the TabPane
	 */
	public static TabPane createDefaultDnDPane(FeedbackType feedbackType, boolean allowDetach) {
		if (SystemUtils.getMajorFXVersion() > 8 || Boolean.getBoolean("java9.tabpane")) {
			return new TabPane();
		} else {
			return new DndTabPane(feedbackType, allowDetach);
		}
	}

	/**
	 * Extract the tab content
	 *
	 * @param e
	 *            the event
	 * @return the content
	 */
	public static boolean hasDnDContent(Event e) {
		if (e instanceof DragEvent) {
			return ((DragEvent) e).getDragboard().hasContent(DndTabPaneSkinHooker.TAB_MOVE);
		} else if (e instanceof EFXDragEvent) {
			return ((EFXDragEvent) e).getDraggedContent() instanceof String;
		}
		return false;
	}

	/**
	 * Extract the content
	 *
	 * @param e
	 *            the event
	 * @return the return value
	 */
	public static String getDnDContent(Event e) {
		if (e instanceof DragEvent) {
			return (String) ((DragEvent) e).getDragboard().getContent(DndTabPaneSkinHooker.TAB_MOVE);
		} else if (e instanceof EFXDragEvent) {
			Object content = ((EFXDragEvent) e).getDraggedContent();
			if( content instanceof String ) {
				return (String) content;
			}
		}
		return null;
	}

	/**
	 * Setup insert marker
	 *
	 * @param layoutNode
	 *            the layout node used to position
	 * @param layoutNodeChildren
	 *            the children of {@code layoutNode}
	 * @param setup
	 *            the setup
	 */
	@SuppressWarnings("null")
	static void setup(Supplier<FeedbackType> typeProvider, Node layoutNode, ObservableList<Node> layoutNodeChildren, DragSetup setup, Consumer<GenericTab> detachHandler) {
		setup.setStartFunction((t) -> Boolean.TRUE);
		setup.setFeedbackConsumer((d) -> handleFeedback(typeProvider, layoutNode, layoutNodeChildren, d));
		setup.setDropConsumer(d -> handleDropped(d, detachHandler));
		setup.setDragFinishedConsumer(DndTabPaneFactory::handleFinished);
	}

	/**
	 * Teardown insert marker
	 *
	 * @param setup
	 *            the setup
	 */
	static void teardown(DragSetup setup) {
		setup.setStartFunction(null);
		setup.setFeedbackConsumer(null);
		setup.setDropConsumer(null);
		setup.setDragFinishedConsumer(null);
	}

	private static void handleDropped(DroppedData data, Consumer<GenericTab> detachHandler) {
		if (data.dropType == DropType.DETACH) {
			if (detachHandler != null) {
				detachHandler.accept(data.draggedTab);
			}
		} else if (data.targetTab != null) {
			GenericTabPane targetPane = data.targetTab.getOwner();
			data.draggedTab.getOwner().remove(data.draggedTab);
			int idx = targetPane.indexOf(data.targetTab);
			if (data.dropType == DropType.AFTER) {
				if (idx + 1 <= targetPane.getTabNumber()) {
					targetPane.add(idx + 1, data.draggedTab);
				} else {
					targetPane.add(data.draggedTab);
				}
			} else {
				targetPane.add(idx, data.draggedTab);
			}
			data.draggedTab.getOwner().select(data.draggedTab);
		}
	}

	private static void handleFeedback(Supplier<FeedbackType> typeProvider, Node layoutNode, ObservableList<Node> layoutNodeChildren, FeedbackData data) {
		if (data.dropType == DropType.NONE) {
			cleanup();
			return;
		}

		MarkerFeedback f = CURRENT_FEEDBACK;
		if (f == null || !f.data.equals(data)) {
			cleanup();
			if (typeProvider.get() == FeedbackType.OUTLINE) {
				CURRENT_FEEDBACK = handleOutline(layoutNode, layoutNodeChildren, data);
			} else {
				CURRENT_FEEDBACK = handleMarker(layoutNodeChildren, data);
			}
		}
	}

	private static void handleFinished(GenericTab tab) {
		cleanup();
	}

	static void cleanup() {
		if (CURRENT_FEEDBACK != null) {
			CURRENT_FEEDBACK.hide();
			CURRENT_FEEDBACK = null;
		}
	}

	private static MarkerFeedback handleMarker(ObservableList<Node> layoutNodeChildren, FeedbackData data) {
		PositionMarker marker = null;
		for (Node n : layoutNodeChildren) {
			if (n instanceof PositionMarker) {
				marker = (PositionMarker) n;
			}
		}

		if (marker == null) {
			marker = new PositionMarker();
			marker.setManaged(false);
			layoutNodeChildren.add(marker);
		} else {
			marker.setVisible(true);
		}

		double w = marker.getBoundsInLocal().getWidth();
		double h = marker.getBoundsInLocal().getHeight();

		double ratio = data.bounds.getHeight() / h;
		ratio += 0.1;
		marker.setScaleX(ratio);
		marker.setScaleY(ratio);

		double wDiff = w / 2;
		double hDiff = (h - h * ratio) / 2;

		if (data.dropType == DropType.AFTER) {
			marker.relocate(data.bounds.getMinX() + data.bounds.getWidth() - wDiff, data.bounds.getMinY() - hDiff);
		} else {
			marker.relocate(data.bounds.getMinX() - wDiff, data.bounds.getMinY() - hDiff);
		}

		final PositionMarker fmarker = marker;

		return new MarkerFeedback(data) {

			@Override
			public void hide() {
				fmarker.setVisible(false);
			}
		};
	}

	@SuppressWarnings("null")
	private static MarkerFeedback handleOutline(Node layoutNode, ObservableList<Node> layoutNodeChildren, FeedbackData data) {
		TabOutlineMarker marker = null;

		for (Node n : layoutNodeChildren) {
			if (n instanceof TabOutlineMarker) {
				marker = (TabOutlineMarker) n;
			}
		}

		if (marker == null) {
			marker = new TabOutlineMarker(layoutNode.getBoundsInLocal(), new BoundingBox(data.bounds.getMinX(), data.bounds.getMinY(), data.bounds.getWidth(), data.bounds.getHeight()), data.dropType == DropType.BEFORE);
			marker.setManaged(false);
			marker.setMouseTransparent(true);
			layoutNodeChildren.add(marker);
		} else {
			marker.updateBounds(layoutNode.getBoundsInLocal(), new BoundingBox(data.bounds.getMinX(), data.bounds.getMinY(), data.bounds.getWidth(), data.bounds.getHeight()), data.dropType == DropType.BEFORE);
			marker.setVisible(true);
		}

		final TabOutlineMarker fmarker = marker;

		return new MarkerFeedback(data) {

			@Override
			public void hide() {
				fmarker.setVisible(false);
			}
		};
	}

	private abstract static class MarkerFeedback {
		public final FeedbackData data;

		public MarkerFeedback(FeedbackData data) {
			this.data = data;
		}

		public abstract void hide();
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
		AFTER,
		/**
		 * Dropped in an area to detach
		 */
		DETACH
	}

	/**
	 * The feedback type to use
	 */
	public enum FeedbackType {
		/**
		 * Show a marker
		 */
		MARKER,
		/**
		 * Show an outline
		 */
		OUTLINE
	}

	/**
	 * Data to create a feedback
	 */
	public static class FeedbackData {
		/**
		 * The tab dragged
		 */
		public final @NonNull GenericTab draggedTab;
		/**
		 * The reference tab
		 */
		public final GenericTab targetTab;
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
		public FeedbackData(@NonNull GenericTab draggedTab, GenericTab targetTab, Bounds bounds, @NonNull DropType dropType) {
			this.draggedTab = draggedTab;
			this.targetTab = targetTab;
			this.bounds = bounds;
			this.dropType = dropType;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((this.bounds == null) ? 0 : this.bounds.hashCode());
			result = prime * result + this.draggedTab.hashCode();
			result = prime * result + this.dropType.hashCode();
			result = prime * result + ((this.targetTab == null) ? 0 : this.targetTab.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			FeedbackData other = (FeedbackData) obj;
			if (this.bounds == null) {
				if (other.bounds != null)
					return false;
			} else if (!this.bounds.equals(other.bounds))
				return false;
			if (!this.draggedTab.equals(other.draggedTab))
				return false;
			if (this.dropType != other.dropType)
				return false;
			if (this.targetTab == null) {
				if (other.targetTab != null)
					return false;
			} else if (!this.targetTab.equals(other.targetTab))
				return false;
			return true;
		}

	}

	/**
	 * The drop data
	 */
	public static class DroppedData {
		/**
		 * The dragged tab
		 */
		public final @NonNull GenericTab draggedTab;
		/**
		 * The reference tab
		 */
		public final @Nullable GenericTab targetTab;
		/**
		 * The drop type
		 */
		public final @NonNull DropType dropType;

		/**
		 * The x coordinate relative to the screen
		 */
		public final double x;

		/**
		 * The y coordinate relative to the screen
		 */
		public final double y;

		/**
		 * Create drop data
		 *
		 * @param x
		 *            the x coordinate
		 *
		 * @param y
		 *            the y coordinate
		 *
		 * @param draggedTab
		 *            the dragged tab
		 * @param targetTab
		 *            the target tab
		 * @param dropType
		 *            the drop type
		 */
		public DroppedData(double x, double y, @NonNull GenericTab draggedTab, @Nullable GenericTab targetTab, @NonNull DropType dropType) {
			this.x = x;
			this.y = y;
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
		public void setStartFunction(@Nullable Function<@NonNull GenericTab, @NonNull Boolean> startFunction);

		/**
		 * Consumer called to handle the finishing of the drag process
		 *
		 * @param dragFinishedConsumer
		 *            the consumer
		 */
		public void setDragFinishedConsumer(@Nullable Consumer<@NonNull GenericTab> dragFinishedConsumer);

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
		public void setClipboardDataFunction(@Nullable Function<@NonNull GenericTab, @NonNull String> clipboardDataFunction);
	}
}

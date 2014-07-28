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
package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import java.lang.reflect.Field;
import java.util.function.Consumer;
import java.util.function.Function;

import javafx.css.StyleOrigin;
import javafx.css.StyleableProperty;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import org.eclipse.fx.ui.workbench.renderers.fx.internal.DndTabPaneFactory.DragSetup;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import com.sun.javafx.scene.control.skin.TabPaneSkin;

@SuppressWarnings("restriction")
public class DnDTabPaneSkin extends TabPaneSkin implements DragSetup {
	private static Tab DRAGGED_TAB;
	public static final DataFormat TAB_MOVE = new DataFormat("DnDTabPane:tabMove"); //$NON-NLS-1$

//	public static final EventType<TabPaneDragStartEvent> DND_TABPANE_DRAG_START = new EventType<>(Event.ANY, "DND_TABPANE_DRAG_START"); //$NON-NLS-1$
//	public static final EventType<TabPaneDroppedEvent> DND_TABPANE_DROPPED = new EventType<>(Event.ANY, "DND_TABPANE_DROPPED"); //$NON-NLS-1$
//	public static final EventType<TabPaneDragFinishedEvent> DND_TABPANE_DRAG_FINISHED = new EventType<>(Event.ANY, "DND_TABPANE_DRAG_FINISHED"); //$NON-NLS-1$
//	public static final EventType<TabPaneFeedbackDragEvent> DND_TABPANE_DRAG_FEEDBACK = new EventType<>(Event.ANY, "DND_TABPANE_DRAG_FEEDBACK"); //$NON-NLS-1$

	private Object noneEnum;
	private StyleableProperty<Object> openAnimation;
	private StyleableProperty<Object> closeAnimation;

//	public static class TabPaneDragStartEvent extends Event {
//		/**
//		 * 
//		 */
//		private static final long serialVersionUID = 1L;
//
//		public final Tab tab;
//
//		public TabPaneDragStartEvent(TabPane pane, Tab tab) {
//			super(pane, pane, DND_TABPANE_DRAG_START);
//			this.tab = tab;
//		}
//	}
//
//	public static class TabPaneDragFinishedEvent extends Event {
//		/**
//		 * 
//		 */
//		private static final long serialVersionUID = 1L;
//
//		public final Tab tab;
//
//		public TabPaneDragFinishedEvent(TabPane pane, Tab tab) {
//			super(pane, pane, DND_TABPANE_DRAG_FINISHED);
//			this.tab = tab;
//		}
//	}
//
//	public static class TabPaneDroppedEvent extends Event {
//		/**
//		 * 
//		 */
//		private static final long serialVersionUID = 1L;
//
//		public final Tab sourceTab;
//
//		public final Tab targetTab;
//
//		public final DropType type;
//
//		public TabPaneDroppedEvent(TabPane pane, Tab sourceTab, Tab targetTab, DropType type) {
//			super(pane, pane, DND_TABPANE_DROPPED);
//			this.sourceTab = sourceTab;
//			this.targetTab = targetTab;
//			this.type = type;
//		}
//	}
//
//	public static class TabPaneFeedbackDragEvent extends Event {
//		/**
//		 * 
//		 */
//		private static final long serialVersionUID = 1L;
//
//		public final Tab sourceTab;
//
//		public final Tab targetTab;
//
//		public final DropType dropType;
//
//		public final Bounds bounds;
//
//		public TabPaneFeedbackDragEvent(TabPane pane, Tab sourceTab, Tab targetTab, Bounds bounds, DropType dropType) {
//			super(pane, pane, DND_TABPANE_DRAG_FEEDBACK);
//			this.sourceTab = sourceTab;
//			this.targetTab = targetTab;
//			this.dropType = dropType;
//			this.bounds = bounds;
//		}
//	}

	public enum DropType {
		NONE, BEFORE, AFTER
	}
	
	public DnDTabPaneSkin(TabPane tabPane) {
		super(tabPane);
		hookTabFolderSkin();
	}

	
	@SuppressWarnings("unchecked")
	private void hookTabFolderSkin() {
		try {
			Field f_tabHeaderArea = TabPaneSkin.class.getDeclaredField("tabHeaderArea"); //$NON-NLS-1$
			f_tabHeaderArea.setAccessible(true);

			Pane tabHeaderArea = (StackPane) f_tabHeaderArea.get(this);
			tabHeaderArea.setOnDragOver((e) -> e.consume());

			Field f_headersRegion = tabHeaderArea.getClass().getDeclaredField("headersRegion"); //$NON-NLS-1$
			f_headersRegion.setAccessible(true);

			Pane headersRegion = (StackPane) f_headersRegion.get(tabHeaderArea);
			EventHandler<MouseEvent> handler = this::tabPane_handleDragStart;
			EventHandler<DragEvent> handlerFinished = this::tabPane_handleDragDone;

			for (Node tabHeaderSkin : headersRegion.getChildren()) {
				tabHeaderSkin.addEventHandler(MouseEvent.DRAG_DETECTED, handler);
				tabHeaderSkin.addEventHandler(DragEvent.DRAG_DONE, handlerFinished);
			}

			headersRegion.getChildren().addListener((javafx.collections.ListChangeListener.Change<? extends Node> change) -> {
				while (change.next()) {
					if (change.wasRemoved()) {
						change.getRemoved().forEach((e) -> e.removeEventHandler(MouseEvent.DRAG_DETECTED, handler));
						change.getRemoved().forEach((e) -> e.removeEventHandler(DragEvent.DRAG_DONE, handlerFinished));
					}
					if (change.wasAdded()) {
						change.getAddedSubList().forEach((e) -> e.addEventHandler(MouseEvent.DRAG_DETECTED, handler));
						change.getRemoved().forEach((e) -> e.addEventHandler(DragEvent.DRAG_DONE, handlerFinished));
					}
				}
			});

			tabHeaderArea.addEventHandler(DragEvent.DRAG_OVER, (e) -> tabPane_handleDragOver(tabHeaderArea, headersRegion, e));
			tabHeaderArea.addEventHandler(DragEvent.DRAG_DROPPED, (e) -> tabPane_handleDragDropped(tabHeaderArea, headersRegion, e));
			tabHeaderArea.addEventHandler(DragEvent.DRAG_EXITED, this::tabPane_handleDragDone);

			Field field = TabPaneSkin.class.getDeclaredField("openTabAnimation"); //$NON-NLS-1$
			field.setAccessible(true);
			this.openAnimation = (StyleableProperty<Object>) field.get(this);

			field = TabPaneSkin.class.getDeclaredField("closeTabAnimation"); //$NON-NLS-1$
			field.setAccessible(true);
			this.closeAnimation = (StyleableProperty<Object>) field.get(this);

			for (Class<?> cl : getClass().getDeclaredClasses()) {
				if ("TabAnimation".equals(cl.getSimpleName())) { //$NON-NLS-1$
					for (Enum<?> enumConstant : (Enum<?>[]) cl.getEnumConstants()) {
						if ("NONE".equals(enumConstant.name())) { //$NON-NLS-1$
							this.noneEnum = enumConstant;
							break;
						}
					}
					break;
				}

			}
		} catch (Throwable t) {
			// // TODO Auto-generated catch block
			t.printStackTrace();
		}
	}

	void tabPane_handleDragStart(MouseEvent event) {
		try {
			Field f_tab = event.getSource().getClass().getDeclaredField("tab"); //$NON-NLS-1$
			f_tab.setAccessible(true);
			Tab t = (Tab) f_tab.get(event.getSource());

			if (t != null && efx_canStartDrag(t)) {
				DRAGGED_TAB = t;
				Node node = (Node) event.getSource();
				Dragboard db = node.startDragAndDrop(TransferMode.MOVE);

				WritableImage snapShot = node.snapshot(new SnapshotParameters(), null);
				PixelReader reader = snapShot.getPixelReader();
				int padX = 10;
				int padY = 10;
				int width = (int) snapShot.getWidth();
				int height = (int) snapShot.getHeight();
				WritableImage image = new WritableImage(width + padX, height + padY);
				PixelWriter writer = image.getPixelWriter();

				int h = 0;
				int v = 0;
				while (h < width + padX) {
					v = 0;
					while (v < height + padY) {
						if (h >= padX && h <= width + padX && v >= padY && v <= height + padY) {
							writer.setColor(h, v, reader.getColor(h - padX, v - padY));
						} else {
							writer.setColor(h, v, Color.TRANSPARENT);
						}

						v++;
					}
					h++;
				}

				db.setDragView(image, image.getWidth(), image.getHeight() * -1);

				ClipboardContent content = new ClipboardContent();
				String data = getClipboardContent(t);
				if (data != null) {
					content.put(TAB_MOVE, data);
				}
				db.setContent(content);
			}
		} catch (Throwable t) {
			// // TODO Auto-generated catch block
			t.printStackTrace();
		}
	}

	/**
	 * Calculate the content to put into the clipboard
	 * 
	 * @param t
	 *            the tab
	 * @return the content
	 */
	@SuppressWarnings("static-method")
	protected String getClipboardContent(Tab t) {
		return System.identityHashCode(t) + ""; //$NON-NLS-1$
	}

	void tabPane_handleDragOver(Pane tabHeaderArea, Pane headersRegion, DragEvent event) {
		if (DRAGGED_TAB == null) {
			return;
		}

		// Consume the drag in any case
		event.consume();

		double x = event.getX() - headersRegion.getBoundsInParent().getMinX();

		Node referenceNode = null;
		DropType type = DropType.AFTER;
		for (Node n : headersRegion.getChildren()) {
			Bounds b = n.getBoundsInParent();
			if (b.getMaxX() > x) {
				if (b.getMinX() + b.getWidth() / 2 > x) {
					referenceNode = n;
					type = DropType.BEFORE;
				} else {
					referenceNode = n;
					type = DropType.AFTER;
				}
				break;
			}
		}

		if (referenceNode == null && headersRegion.getChildren().size() > 0) {
			referenceNode = headersRegion.getChildren().get(headersRegion.getChildren().size() - 1);
			type = DropType.AFTER;
		}

		if (referenceNode != null) {
			try {
				Field field = referenceNode.getClass().getDeclaredField("tab"); //$NON-NLS-1$
				field.setAccessible(true);
				Tab tab = (Tab) field.get(referenceNode);

				boolean noMove = false;
				if (tab == DRAGGED_TAB) {
					noMove = true;
				} else if (type == DropType.BEFORE) {
					int idx = getSkinnable().getTabs().indexOf(tab);
					if (idx > 0) {
						if (getSkinnable().getTabs().get(idx - 1) == DRAGGED_TAB) {
							noMove = true;
						}
					}
				} else {
					int idx = getSkinnable().getTabs().indexOf(tab);

					if (idx + 1 < getSkinnable().getTabs().size()) {
						if (getSkinnable().getTabs().get(idx + 1) == DRAGGED_TAB) {
							noMove = true;
						}
					}
				}

				if (noMove) {
					efx_dragFeedback(DRAGGED_TAB, null, null, DropType.NONE);
					return;
				}

				Bounds b = referenceNode.getBoundsInLocal();
				b = referenceNode.localToScene(b);
				b = getSkinnable().sceneToLocal(b);

				efx_dragFeedback(DRAGGED_TAB, tab, b, type);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			event.acceptTransferModes(TransferMode.MOVE);
		} else {
			efx_dragFeedback(DRAGGED_TAB, null, null, DropType.NONE);
		}
	}

	void tabPane_handleDragDropped(Pane tabHeaderArea, Pane headersRegion, DragEvent event) {
		if (DRAGGED_TAB == null) {
			return;
		}

		double x = event.getX() - headersRegion.getBoundsInParent().getMinX();

		Node referenceNode = null;
		DropType type = DropType.AFTER;
		for (Node n : headersRegion.getChildren()) {
			Bounds b = n.getBoundsInParent();
			if (b.getMaxX() > x) {
				if (b.getMinX() + b.getWidth() / 2 > x) {
					referenceNode = n;
					type = DropType.BEFORE;
				} else {
					referenceNode = n;
					type = DropType.AFTER;
				}
				break;
			}
		}

		if (referenceNode == null && headersRegion.getChildren().size() > 0) {
			referenceNode = headersRegion.getChildren().get(headersRegion.getChildren().size() - 1);
			type = DropType.AFTER;
		}

		if (referenceNode != null) {
			try {
				Field field = referenceNode.getClass().getDeclaredField("tab"); //$NON-NLS-1$
				field.setAccessible(true);
				Tab tab = (Tab) field.get(referenceNode);

				boolean noMove = false;
				if (tab == DRAGGED_TAB) {
					noMove = true;
				} else if (type == DropType.BEFORE) {
					int idx = getSkinnable().getTabs().indexOf(tab);
					if (idx > 0) {
						if (getSkinnable().getTabs().get(idx - 1) == DRAGGED_TAB) {
							noMove = true;
						}
					}
				} else {
					int idx = getSkinnable().getTabs().indexOf(tab);

					if (idx + 1 < getSkinnable().getTabs().size()) {
						if (getSkinnable().getTabs().get(idx + 1) == DRAGGED_TAB) {
							noMove = true;
						}
					}
				}

				if (!noMove) {
					StyleOrigin openOrigin = this.openAnimation.getStyleOrigin();
					StyleOrigin closeOrigin = this.closeAnimation.getStyleOrigin();
					Object openValue = this.openAnimation.getValue();
					Object closeValue = this.closeAnimation.getValue();
					try {
						this.openAnimation.setValue(this.noneEnum);
						this.closeAnimation.setValue(this.noneEnum);
						efx_dropped(DRAGGED_TAB, tab, type);
						event.setDropCompleted(true);
					} finally {
						this.openAnimation.applyStyle(openOrigin, openValue);
						this.closeAnimation.applyStyle(closeOrigin, closeValue);
					}

				} else {
					event.setDropCompleted(false);
				}
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			event.consume();
		}
	}

	void tabPane_handleDragDone(DragEvent event) {
		if (DRAGGED_TAB == null) {
			return;
		}

		efx_dragFinished(DRAGGED_TAB);
	}
	
	private @Nullable Function<@NonNull Tab, @NonNull Boolean> startFunction;
	private @Nullable Consumer<@NonNull Tab> dragFinishedConsumer;
	private @Nullable Consumer<@NonNull FeedbackData> feedbackConsumer;
	private @Nullable Consumer<@NonNull DroppedData> dropConsumer;
	
	public void setStartFunction(@Nullable Function<@NonNull Tab, @NonNull Boolean> startFunction) {
		this.startFunction = startFunction;
	}
	
	public @Nullable Function<@NonNull Tab, @NonNull Boolean> getStartFunction() {
		return this.startFunction;
	}
	
	public void setDragFinishedConsumer(@Nullable Consumer<@NonNull Tab> dragFinishedConsumer) {
		this.dragFinishedConsumer = dragFinishedConsumer;
	}
	
	public @Nullable Consumer<@NonNull Tab> getDragFinishedConsumer() {
		return this.dragFinishedConsumer;
	}
	
	public void setFeedbackConsumer(@Nullable Consumer<@NonNull FeedbackData> feedbackConsumer) {
		this.feedbackConsumer = feedbackConsumer;
	}
	
	public @Nullable Consumer<@NonNull FeedbackData> getFeedbackConsumer() {
		return this.feedbackConsumer;
	}
	
	public void setDropConsumer(@Nullable Consumer<@NonNull DroppedData> dropConsumer) {
		this.dropConsumer = dropConsumer;
	}
	
	public @Nullable Consumer<@NonNull DroppedData> getDropConsumer() {
		return this.dropConsumer;
	}
	
	public static class FeedbackData {
		public final Tab draggedTab;
		public final Tab targetTab;
		public final Bounds bounds;
		public final DropType dropType;
		
		public FeedbackData(Tab draggedTab, Tab targetTab, Bounds bounds, DropType dropType) {
			this.draggedTab = draggedTab;
			this.targetTab = targetTab;
			this.bounds = bounds;
			this.dropType = dropType;
		}
	}
	
	public static class DroppedData {
		public final Tab draggedTab;
		public final Tab targetTab;
		public final DropType dropType;
		
		public DroppedData(Tab draggedTab, Tab targetTab, DropType dropType) {
			this.draggedTab = draggedTab;
			this.targetTab = targetTab;
			this.dropType = dropType;
		}
	}
	
	private boolean efx_canStartDrag(@NonNull Tab tab) {
		if( this.startFunction != null ) {
			return this.startFunction.apply(tab).booleanValue();
		}
		return true;
	}
	
	private void efx_dragFeedback(Tab draggedTab, Tab targetTab, Bounds bounds, DropType dropType) {
		if( this.feedbackConsumer != null ) {
			this.feedbackConsumer.accept(new FeedbackData(draggedTab, targetTab, bounds, dropType));
		}
	}
	
	private void efx_dropped(Tab draggedTab, Tab targetTab, DropType dropType) {
		if( this.dropConsumer != null ) {
			this.dropConsumer.accept(new DroppedData(draggedTab, targetTab, dropType));
		}
	}
	
	private void efx_dragFinished(@NonNull Tab tab) {
		if( this.dragFinishedConsumer != null ) {
			this.dragFinishedConsumer.accept(tab);
		}
	}
	
	
	
}

/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.tabpane.skin;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory.DragSetup;
import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory.DropType;
import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory.DroppedData;
import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory.FeedbackData;
import org.eclipse.fx.ui.controls.tabpane.GenericTab;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Skin;
import javafx.scene.control.SkinBase;
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
import javafx.scene.paint.Color;

/**
 * Create a hooker who use native DnD
 */
public class DndTabPaneSkinHooker implements DragSetup {
	private static Tab DRAGGED_TAB;
	/**
	 * Custom data format for move data
	 */
	public static final DataFormat TAB_MOVE = new DataFormat("DnDTabPane:tabMove"); //$NON-NLS-1$

	private @Nullable Function<@NonNull GenericTab, @NonNull Boolean> startFunction;
	private @Nullable Function<@NonNull GenericTab, @NonNull String> clipboardDataFunction;
	private @Nullable Consumer<@NonNull GenericTab> dragFinishedConsumer;
	private @Nullable Consumer<@NonNull FeedbackData> feedbackConsumer;
	private @Nullable Consumer<@NonNull DroppedData> dropConsumer;

	private final TabPane pane;

	/**
	 * Create a new hooker instance
	 *
	 * @param skin
	 *            the skin
	 */
	public DndTabPaneSkinHooker(Skin<TabPane> skin) {
		this.pane = skin.getSkinnable();
		Optional<Node> o_TabHeaderArea = ((SkinBase<TabPane>) skin).getChildren().stream().filter(e -> e.getClass().getSimpleName().equals("TabHeaderArea")) //$NON-NLS-1$
				.findFirst();
		if (!o_TabHeaderArea.isPresent() || !(o_TabHeaderArea.get() instanceof Pane)) {
			LoggerCreator.createLogger(DndTabPaneSkinHooker.class).warning("Could not find a supported TabHeaderArea pane. DnD is disabled."); //$NON-NLS-1$
			return;
		}

		Pane tabHeaderArea = (Pane) o_TabHeaderArea.get();

		Optional<Node> o_HeadersRegion = tabHeaderArea.getChildren().stream().filter(e -> e.getStyleClass().contains("headers-region")).findFirst(); //$NON-NLS-1$

		if (!o_HeadersRegion.isPresent() || !(o_HeadersRegion.get() instanceof Pane)) {
			LoggerCreator.createLogger(DndTabPaneSkinHooker.class).warning("Could not find a supported HeadersRegion pane. DnD is disabled."); //$NON-NLS-1$
			return;
		}

		Pane headersRegion = (Pane) o_HeadersRegion.get();

		// Hook the nodes
		tabHeaderArea.setOnDragOver((e) -> e.consume());

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
					change.getAddedSubList().forEach((e) -> e.addEventHandler(DragEvent.DRAG_DONE, handlerFinished));
				}
			}
		});

		tabHeaderArea.addEventHandler(DragEvent.DRAG_OVER, (e) -> tabPane_handleDragOver(tabHeaderArea, headersRegion, e));
		tabHeaderArea.addEventHandler(DragEvent.DRAG_DROPPED, (e) -> tabPane_handleDragDropped(tabHeaderArea, headersRegion, e));
		tabHeaderArea.addEventHandler(DragEvent.DRAG_EXITED, this::tabPane_handleDragDone);

	}

	@Override
	public void setClipboardDataFunction(@Nullable Function<@NonNull GenericTab, @NonNull String> clipboardDataFunction) {
		this.clipboardDataFunction = clipboardDataFunction;
	}

	@Override
	public void setDragFinishedConsumer(Consumer<@NonNull GenericTab> dragFinishedConsumer) {
		this.dragFinishedConsumer = dragFinishedConsumer;
	}

	@Override
	public void setDropConsumer(Consumer<@NonNull DroppedData> dropConsumer) {
		this.dropConsumer = dropConsumer;
	}

	@Override
	public void setFeedbackConsumer(Consumer<@NonNull FeedbackData> feedbackConsumer) {
		this.feedbackConsumer = feedbackConsumer;
	}

	@Override
	public void setStartFunction(@Nullable Function<@NonNull GenericTab, @NonNull Boolean> startFunction) {
		this.startFunction = startFunction;
	}

	private Tab getTab(Node n) {
		int tabIdx = n.getParent().getChildrenUnmodifiable().indexOf(n); // The
																			// order
																			// in
																			// the
																			// parent
																			// ==
																			// order
																			// in
																			// pane.getTabs()
		return this.pane.getTabs().get(tabIdx);
	}

	@SuppressWarnings("all")
	void tabPane_handleDragDropped(Pane tabHeaderArea, Pane headersRegion, DragEvent event) {
		Tab draggedTab = DRAGGED_TAB;
		if (draggedTab == null) {
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
				Tab tab = getTab(referenceNode);

				boolean noMove = false;
				if (tab == null) {
					event.setDropCompleted(false);
					return;
				} else if (tab == draggedTab) {
					noMove = true;
				} else if (type == DropType.BEFORE) {
					int idx = pane.getTabs().indexOf(tab);
					if (idx > 0) {
						if (pane.getTabs().get(idx - 1) == draggedTab) {
							noMove = true;
						}
					}
				} else {
					int idx = pane.getTabs().indexOf(tab);

					if (idx + 1 < pane.getTabs().size()) {
						if (pane.getTabs().get(idx + 1) == draggedTab) {
							noMove = true;
						}
					}
				}

				if (!noMove) {
					efx_dropped(event.getScreenX(), event.getScreenY(), FXTabWrapper.wrap(draggedTab), FXTabWrapper.wrap(tab), type);
					event.setDropCompleted(true);
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

	void tabPane_handleDragStart(MouseEvent event) {
		try {
			Tab t = getTab((Node) event.getSource());

			if (t != null && efx_canStartDrag(FXTabWrapper.wrap(t))) {
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
				String data = efx_getClipboardContent(FXTabWrapper.wrap(t));
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

	@SuppressWarnings("all")
	void tabPane_handleDragOver(Pane tabHeaderArea, Pane headersRegion, DragEvent event) {
		Tab draggedTab = DRAGGED_TAB;
		if (draggedTab == null) {
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
				Tab tab = getTab(referenceNode);

				boolean noMove = false;
				if (tab == draggedTab) {
					noMove = true;
				} else if (type == DropType.BEFORE) {
					int idx = pane.getTabs().indexOf(tab);
					if (idx > 0) {
						if (pane.getTabs().get(idx - 1) == draggedTab) {
							noMove = true;
						}
					}
				} else {
					int idx = pane.getTabs().indexOf(tab);

					if (idx + 1 < pane.getTabs().size()) {
						if (pane.getTabs().get(idx + 1) == draggedTab) {
							noMove = true;
						}
					}
				}

				if (noMove) {
					efx_dragFeedback(FXTabWrapper.wrap(draggedTab), null, null, DropType.NONE);
					return;
				}

				Bounds b = referenceNode.getBoundsInLocal();
				b = referenceNode.localToScene(b);
				b = pane.sceneToLocal(b);

				efx_dragFeedback(FXTabWrapper.wrap(draggedTab), FXTabWrapper.wrap(tab), b, type);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			event.acceptTransferModes(TransferMode.MOVE);
		} else {
			efx_dragFeedback(FXTabWrapper.wrap(draggedTab), null, null, DropType.NONE);
		}
	}

	void tabPane_handleDragDone(DragEvent event) {
		Tab tab = DRAGGED_TAB;
		if (tab == null) {
			return;
		}

		efx_dragFinished(FXTabWrapper.wrap(tab));
	}

	private boolean efx_canStartDrag(@NonNull GenericTab tab) {
		if (this.startFunction != null) {
			return this.startFunction.apply(tab).booleanValue();
		}
		return true;
	}

	private void efx_dragFinished(@NonNull GenericTab tab) {
		if (this.dragFinishedConsumer != null) {
			this.dragFinishedConsumer.accept(tab);
		}
	}

	private String efx_getClipboardContent(@NonNull GenericTab t) {
		if (this.clipboardDataFunction != null) {
			return this.clipboardDataFunction.apply(t);
		}
		return System.identityHashCode(t) + ""; //$NON-NLS-1$
	}

	private void efx_dragFeedback(@NonNull GenericTab draggedTab, GenericTab targetTab, Bounds bounds, @NonNull DropType dropType) {
		if (this.feedbackConsumer != null) {
			this.feedbackConsumer.accept(new FeedbackData(draggedTab, targetTab, bounds, dropType));
		}
	}

	private void efx_dropped(double x, double y, @NonNull GenericTab draggedTab, @NonNull GenericTab targetTab, @NonNull DropType dropType) {
		if (this.dropConsumer != null) {
			this.dropConsumer.accept(new DroppedData(x, y, draggedTab, targetTab, dropType));
		}
	}
}

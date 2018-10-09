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
import org.eclipse.fx.ui.controls.Util;
import org.eclipse.fx.ui.controls.dnd.EFXDragEvent;
import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory.DragSetup;
import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory.DroppedData;
import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory.FeedbackData;
import org.eclipse.fx.ui.controls.tabpane.DropType;
import org.eclipse.fx.ui.controls.tabpane.GenericTab;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.animation.ScaleTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Skin;
import javafx.scene.control.SkinBase;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

/**
 * Hook a TabSkin and allow detaching
 */
public class DnDTabPaneSkinHookerFullDrag implements DragSetup {
	private static Tab DRAGGED_TAB;
	private final TabPane pane;

	private @Nullable Function<@NonNull GenericTab, @NonNull Boolean> startFunction;
	private @Nullable Consumer<@NonNull GenericTab> dragFinishedConsumer;
	private @Nullable Consumer<@NonNull FeedbackData> feedbackConsumer;
	private @Nullable Consumer<@NonNull DroppedData> dropConsumer;
	private @Nullable Function<@NonNull GenericTab, @NonNull String> clipboardDataFunction;

	/**
	 * Create a new hooker
	 *
	 * @param skin
	 *            the skin
	 */
	public DnDTabPaneSkinHookerFullDrag(Skin<TabPane> skin) {
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

		EventHandler<MouseEvent> handler = this::tabPane_handleDragStart;
		EventHandler<EFXDragEvent> handlerFinished = this::tabPane_handleDragDone;
		EventHandler<MouseEvent> handle_mouseDragged = this::handle_mouseDragged;
		EventHandler<MouseEvent> handleMouseReleased = this::handleMouseReleased;

		for (Node tabHeaderSkin : headersRegion.getChildren()) {
			tabHeaderSkin.addEventHandler(MouseEvent.DRAG_DETECTED, handler);
			tabHeaderSkin.addEventHandler(MouseEvent.MOUSE_DRAGGED, handle_mouseDragged);
			tabHeaderSkin.addEventHandler(MouseEvent.MOUSE_RELEASED, handleMouseReleased);
			tabHeaderSkin.addEventHandler(EFXDragEvent.DRAG_DONE, handlerFinished);
		}

		headersRegion.getChildren().addListener((javafx.collections.ListChangeListener.Change<? extends Node> change) -> {
			while (change.next()) {
				if (change.wasRemoved()) {
					change.getRemoved().forEach((e) -> e.removeEventHandler(MouseEvent.DRAG_DETECTED, handler));
					change.getRemoved().forEach((e) -> e.removeEventHandler(MouseEvent.MOUSE_DRAGGED, handle_mouseDragged));
					change.getRemoved().forEach((e) -> e.removeEventHandler(MouseEvent.MOUSE_RELEASED, handleMouseReleased));
					// change.getRemoved().forEach((e) ->
					// e.removeEventHandler(MouseDragEvent.MOUSE_DRAG_RELEASED,
					// handlerFinished));
				}
				if (change.wasAdded()) {
					change.getAddedSubList().forEach((e) -> e.addEventHandler(MouseEvent.DRAG_DETECTED, handler));
					change.getAddedSubList().forEach((e) -> e.addEventHandler(MouseEvent.MOUSE_DRAGGED, handle_mouseDragged));
					change.getAddedSubList().forEach((e) -> e.addEventHandler(MouseEvent.MOUSE_RELEASED, handleMouseReleased));
					// change.getAddedSubList().forEach((e) ->
					// e.addEventHandler(MouseDragEvent.MOUSE_DRAG_RELEASED,
					// handlerFinished));
				}
			}
		});

		// tabHeaderArea.addEventHandler(MouseDragEvent.MOUSE_DRAG_OVER, (e) ->
		// tabPane_handleDragOver(tabHeaderArea, headersRegion, e));
		tabHeaderArea.addEventHandler(EFXDragEvent.DRAG_OVER, (e) -> tabPane_handleDragOver(tabHeaderArea, headersRegion, e));
		tabHeaderArea.addEventHandler(EFXDragEvent.DRAG_DROPPED, (e) -> tabPane_handleDragDropped(tabHeaderArea, headersRegion, e));
		// tabHeaderArea.addEventHandler(MouseDragEvent.MOUSE_DRAG_EXITED,
		// this::tabPane_handleDragDone);

		this.pane.addEventHandler(EFXDragEvent.DRAG_DONE, this::tabPane_handleDragDone);
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

	void tabPane_handleDragStart(MouseEvent event) {
		try {
			Tab t = getTab((Node) event.getSource());

			if (t != null && efx_canStartDrag(FXTabWrapper.wrap(t))) {
				DRAGGED_TAB = t;

				Node n = (Node) event.getSource();
				n.startFullDrag();

				String data = efx_getClipboardContent(FXTabWrapper.wrap(t));
				EFXDragEvent evt = new EFXDragEvent(event.getSource(), event.getTarget(), EFXDragEvent.DRAG_START, event.getScreenX(), event.getScreenY(), false);
				evt.setDraggedContent(data);
				evt.updateFeedback(p -> {
					final SnapshotParameters snapshotParameters = new SnapshotParameters();
					snapshotParameters.setFill(Color.TRANSPARENT);
					WritableImage snapShot = n.snapshot(snapshotParameters, null);
					ImageView v = new ImageView(snapShot);
					// if (!p.getStyleClass().contains(styleClassPrefix +
					// "-tab-folder-dragimage")){ // I am a hack
					// p.getStyleClass().add(styleClassPrefix +
					// "-tab-folder-dragimage"); // me too
					// }
					ScaleTransition st = new ScaleTransition(Duration.millis(200), v);
					st.setFromX(0);
					st.setToX(1);
					st.play();

					p.getChildren().add(v);
				});
				Event.fireEvent(event.getTarget(), evt);
				event.consume();
			}
		} catch (Throwable t) {
			// // TODO Auto-generated catch block
			t.printStackTrace();
		}
	}

	void tabPane_handleDragDone(EFXDragEvent event) {
		Tab tab = DRAGGED_TAB;
		if (tab == null) {
			return;
		}

		efx_dragFinished(FXTabWrapper.wrap(tab));
	}

	void handle_mouseDragged(MouseEvent e) {
		if (DRAGGED_TAB == null) {
			return;
		}
		Node node = Util.findNode((Window) null, e.getScreenX(), e.getScreenY());
		if (node != null) {
			((Stage) node.getScene().getWindow()).toFront();
			Event.fireEvent(node, new EFXDragEvent(this, node, EFXDragEvent.DRAG_OVER, e.getScreenX(), e.getScreenY(), false));
		} else {
			EFXDragEvent.updateFeedbackLocation(e.getScreenX(), e.getScreenY());
		}
	}

	@SuppressWarnings("all")
	void tabPane_handleDragOver(Pane tabHeaderArea, Pane headersRegion, EFXDragEvent event) {
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
				LoggerCreator.createLogger(getClass()).error("Failure while handling drag over", e);
			}
		} else {
			efx_dragFeedback(FXTabWrapper.wrap(draggedTab), null, null, DropType.NONE);
		}
	}

	@SuppressWarnings("all")
	void tabPane_handleDragDropped(Pane tabHeaderArea, Pane headersRegion, EFXDragEvent event) {
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
					event.setComplete(false);
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
					event.setComplete(true);
				} else {
					event.setComplete(false);
				}
			} catch (Throwable e) {
				LoggerCreator.createLogger(getClass()).error("Error while handling drop",e);
			}

			event.consume();
		}
	}

	private void handleMouseReleased(MouseEvent e) {
		if (DRAGGED_TAB == null) {
			return;
		}

		boolean isComplete = false;
		try {
			Node node = Util.findNode((Window) null, e.getScreenX(), e.getScreenY());
			if (node != null) {
				EFXDragEvent event = new EFXDragEvent(node, node, EFXDragEvent.DRAG_DROPPED, e.getScreenX(), e.getScreenY(), false);
				Event.fireEvent(node, event);
				isComplete = event.isComplete();
			} else {
				efx_dropped(e.getScreenX(), e.getScreenY(), FXTabWrapper.wrap(DRAGGED_TAB), null, DropType.DETACH);
			}
		} finally {
			Event.fireEvent(this.pane, new EFXDragEvent(this.pane, this.pane, EFXDragEvent.DRAG_DONE, e.getScreenX(), e.getScreenY(), isComplete));
			DRAGGED_TAB = null;
		}
	}

	private boolean efx_canStartDrag(@NonNull GenericTab tab) {
		if (this.startFunction != null) {
			return this.startFunction.apply(tab).booleanValue();
		}
		return true;
	}

	private void efx_dragFeedback(@NonNull GenericTab draggedTab, GenericTab targetTab, Bounds bounds, @NonNull DropType dropType) {
		if (this.feedbackConsumer != null) {
			this.feedbackConsumer.accept(new FeedbackData(draggedTab, targetTab, bounds, dropType));
		}
	}

	private void efx_dropped(double x, double y, @NonNull GenericTab draggedTab, @Nullable GenericTab targetTab, @NonNull DropType dropType) {
		if (this.dropConsumer != null) {
			this.dropConsumer.accept(new DroppedData(x, y, draggedTab, targetTab, dropType));
		}
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
}

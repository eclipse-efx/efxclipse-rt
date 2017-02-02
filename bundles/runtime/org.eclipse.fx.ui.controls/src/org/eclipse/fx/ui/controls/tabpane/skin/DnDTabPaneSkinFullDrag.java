///*******************************************************************************
// * Copyright (c) 2014 BestSolution.at and others.
// * All rights reserved. This program and the accompanying materials
// * are made available under the terms of the Eclipse Public License v1.0
// * which accompanies this distribution, and is available at
// * http://www.eclipse.org/legal/epl-v10.html
// *
// * Contributors:
// *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
// *******************************************************************************/
//package org.eclipse.fx.ui.controls.tabpane.skin;
//
//import java.lang.reflect.Field;
//import java.util.function.Consumer;
//import java.util.function.Function;
//
//import org.eclipse.fx.ui.controls.Util;
//import org.eclipse.fx.ui.controls.dnd.EFXDragEvent;
//import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory.DragSetup;
//import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory.DropType;
//import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory.DroppedData;
//import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory.FeedbackData;
//import org.eclipse.fx.ui.controls.tabpane.GenericTab;
//import org.eclipse.jdt.annotation.NonNull;
//import org.eclipse.jdt.annotation.Nullable;
//
//import com.sun.javafx.scene.control.skin.TabPaneSkin;
//
//import javafx.animation.ScaleTransition;
//import javafx.css.StyleOrigin;
//import javafx.css.StyleableProperty;
//import javafx.event.Event;
//import javafx.event.EventHandler;
//import javafx.geometry.Bounds;
//import javafx.scene.Node;
//import javafx.scene.SnapshotParameters;
//import javafx.scene.control.Tab;
//import javafx.scene.control.TabPane;
//import javafx.scene.image.ImageView;
//import javafx.scene.image.WritableImage;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//import javafx.stage.Window;
//import javafx.util.Duration;
//
///**
// * Skin for TabPane which support DnD
// */
//@SuppressWarnings("restriction")
//public class DnDTabPaneSkinFullDrag extends TabPaneSkin implements DragSetup {
//	private static Tab DRAGGED_TAB;
//
//	private Object noneEnum;
//	private StyleableProperty<Object> openAnimation;
//	private StyleableProperty<Object> closeAnimation;
//
//	/**
//	 * Create a new skin
//	 *
//	 * @param tabPane
//	 *            the tab pane
//	 */
//	public DnDTabPaneSkinFullDrag(TabPane tabPane) {
//		super(tabPane);
//		hookTabFolderSkin();
//	}
//
//	@SuppressWarnings("unchecked")
//	private void hookTabFolderSkin() {
//		try {
//			Field f_tabHeaderArea = TabPaneSkin.class.getDeclaredField("tabHeaderArea"); //$NON-NLS-1$
//			f_tabHeaderArea.setAccessible(true);
//
//			Pane tabHeaderArea = (StackPane) f_tabHeaderArea.get(this);
//			tabHeaderArea.setOnDragOver((e) -> e.consume());
//
//			Field f_headersRegion = tabHeaderArea.getClass().getDeclaredField("headersRegion"); //$NON-NLS-1$
//			f_headersRegion.setAccessible(true);
//
//			Pane headersRegion = (StackPane) f_headersRegion.get(tabHeaderArea);
//			EventHandler<MouseEvent> handler = this::tabPane_handleDragStart;
//			EventHandler<EFXDragEvent> handlerFinished = this::tabPane_handleDragDone;
//			EventHandler<MouseEvent> handle_mouseDragged = this::handle_mouseDragged;
//			EventHandler<MouseEvent> handleMouseReleased = this::handleMouseReleased;
//
//			for (Node tabHeaderSkin : headersRegion.getChildren()) {
//				tabHeaderSkin.addEventHandler(MouseEvent.DRAG_DETECTED, handler);
//				tabHeaderSkin.addEventHandler(MouseEvent.MOUSE_DRAGGED, handle_mouseDragged);
//				tabHeaderSkin.addEventHandler(MouseEvent.MOUSE_RELEASED, handleMouseReleased);
//				tabHeaderSkin.addEventHandler(EFXDragEvent.DRAG_DONE, handlerFinished);
//			}
//
//			headersRegion.getChildren().addListener((javafx.collections.ListChangeListener.Change<? extends Node> change) -> {
//				while (change.next()) {
//					if (change.wasRemoved()) {
//						change.getRemoved().forEach((e) -> e.removeEventHandler(MouseEvent.DRAG_DETECTED, handler));
//						change.getRemoved().forEach((e) -> e.removeEventHandler(MouseEvent.MOUSE_DRAGGED, handle_mouseDragged));
//						change.getRemoved().forEach((e) -> e.removeEventHandler(MouseEvent.MOUSE_RELEASED, handleMouseReleased));
////						change.getRemoved().forEach((e) -> e.removeEventHandler(MouseDragEvent.MOUSE_DRAG_RELEASED, handlerFinished));
//					}
//					if (change.wasAdded()) {
//						change.getAddedSubList().forEach((e) -> e.addEventHandler(MouseEvent.DRAG_DETECTED, handler));
//						change.getAddedSubList().forEach((e) -> e.addEventHandler(MouseEvent.MOUSE_DRAGGED, handle_mouseDragged));
//						change.getAddedSubList().forEach((e) -> e.addEventHandler(MouseEvent.MOUSE_RELEASED, handleMouseReleased));
////						change.getAddedSubList().forEach((e) -> e.addEventHandler(MouseDragEvent.MOUSE_DRAG_RELEASED, handlerFinished));
//					}
//				}
//			});
//
////			tabHeaderArea.addEventHandler(MouseDragEvent.MOUSE_DRAG_OVER, (e) -> tabPane_handleDragOver(tabHeaderArea, headersRegion, e));
//			tabHeaderArea.addEventHandler(EFXDragEvent.DRAG_OVER, (e) -> tabPane_handleDragOver(tabHeaderArea, headersRegion, e));
//			tabHeaderArea.addEventHandler(EFXDragEvent.DRAG_DROPPED, (e) -> tabPane_handleDragDropped(tabHeaderArea, headersRegion, e));
////			tabHeaderArea.addEventHandler(MouseDragEvent.MOUSE_DRAG_EXITED, this::tabPane_handleDragDone);
//
//			Field field = TabPaneSkin.class.getDeclaredField("openTabAnimation"); //$NON-NLS-1$
//			field.setAccessible(true);
//			this.openAnimation = (StyleableProperty<Object>) field.get(this);
//
//			field = TabPaneSkin.class.getDeclaredField("closeTabAnimation"); //$NON-NLS-1$
//			field.setAccessible(true);
//			this.closeAnimation = (StyleableProperty<Object>) field.get(this);
//
//			for (Class<?> cl : getClass().getDeclaredClasses()) {
//				if ("TabAnimation".equals(cl.getSimpleName())) { //$NON-NLS-1$
//					for (Enum<?> enumConstant : (Enum<?>[]) cl.getEnumConstants()) {
//						if ("NONE".equals(enumConstant.name())) { //$NON-NLS-1$
//							this.noneEnum = enumConstant;
//							break;
//						}
//					}
//					break;
//				}
//
//			}
//		} catch (Throwable t) {
//			// // TODO Auto-generated catch block
//			t.printStackTrace();
//		}
//		getSkinnable().addEventHandler(EFXDragEvent.DRAG_DONE, this::tabPane_handleDragDone);
//	}
//
//	void handle_mouseDragged(MouseEvent e) {
//		if( DRAGGED_TAB == null ) {
//			return;
//		}
//		Node node = Util.findNode((Window)null, e.getScreenX(), e.getScreenY());
//		if (node != null) {
//			((Stage)node.getScene().getWindow()).toFront();
//            Event.fireEvent(node, new EFXDragEvent(this, node, EFXDragEvent.DRAG_OVER, e.getScreenX(),
//                            e.getScreenY(), false));
//		} else {
//            EFXDragEvent.updateFeedbackLocation(e.getScreenX(), e.getScreenY());
//		}
//	}
//
//	private void handleMouseReleased(MouseEvent e) {
//		if( DRAGGED_TAB == null ) {
//			return;
//		}
//
//		boolean isComplete = false;
//		try {
//			Node node = Util.findNode((Window)null, e.getScreenX(), e.getScreenY());
//	        if (node != null) {
//	                EFXDragEvent event = new EFXDragEvent(node, node, EFXDragEvent.DRAG_DROPPED, e.getScreenX(),
//	                                e.getScreenY(), false);
//	                Event.fireEvent(node, event);
//	                isComplete = event.isComplete();
//	        } else {
//	        	efx_dropped(e.getScreenX(), e.getScreenY(),FXTabWrapper.wrap(DRAGGED_TAB), null, DropType.DETACH);
//	        }
//		} finally {
//	        Event.fireEvent(getSkinnable(), new EFXDragEvent(getSkinnable(), getSkinnable(),
//                    EFXDragEvent.DRAG_DONE, e.getScreenX(), e.getScreenY(), isComplete));
//	        DRAGGED_TAB = null;
//		}
//	}
//
//	void tabPane_handleDragStart(MouseEvent event) {
//		try {
//			Field f_tab = event.getSource().getClass().getDeclaredField("tab"); //$NON-NLS-1$
//			f_tab.setAccessible(true);
//			Tab t = (Tab) f_tab.get(event.getSource());
//
//			if (t != null && efx_canStartDrag(FXTabWrapper.wrap(t))) {
//				DRAGGED_TAB = t;
//
//				Node n = (Node) event.getSource();
//				n.startFullDrag();
//
//				String data = efx_getClipboardContent(FXTabWrapper.wrap(t));
//				EFXDragEvent evt = new EFXDragEvent(event.getSource(), event.getTarget(), EFXDragEvent.DRAG_START, event.getScreenX(), event.getScreenY(), false);
//				evt.setDraggedContent(data);
//				evt.updateFeedback(p -> {
//					final SnapshotParameters snapshotParameters = new SnapshotParameters();
//					snapshotParameters.setFill(Color.TRANSPARENT);
//					WritableImage snapShot = n.snapshot(snapshotParameters, null);
//					ImageView v = new ImageView(snapShot);
////					if (!p.getStyleClass().contains(styleClassPrefix + "-tab-folder-dragimage")){ // I am a hack
////						p.getStyleClass().add(styleClassPrefix + "-tab-folder-dragimage"); // me too
////					}
//					ScaleTransition st = new ScaleTransition(Duration.millis(200), v);
//					st.setFromX(0);
//					st.setToX(1);
//					st.play();
//
//					p.getChildren().add(v);
//				} );
//				Event.fireEvent(event.getTarget(),evt);
//				event.consume();
////
////
////				Node node = (Node) event.getSource();
////				Dragboard db = node.startDragAndDrop(TransferMode.MOVE);
////
////				WritableImage snapShot = node.snapshot(new SnapshotParameters(), null);
////				PixelReader reader = snapShot.getPixelReader();
////				int padX = 10;
////				int padY = 10;
////				int width = (int) snapShot.getWidth();
////				int height = (int) snapShot.getHeight();
////				WritableImage image = new WritableImage(width + padX, height + padY);
////				PixelWriter writer = image.getPixelWriter();
////
////				int h = 0;
////				int v = 0;
////				while (h < width + padX) {
////					v = 0;
////					while (v < height + padY) {
////						if (h >= padX && h <= width + padX && v >= padY && v <= height + padY) {
////							writer.setColor(h, v, reader.getColor(h - padX, v - padY));
////						} else {
////							writer.setColor(h, v, Color.TRANSPARENT);
////						}
////
////						v++;
////					}
////					h++;
////				}
////
////				db.setDragView(image, image.getWidth(), image.getHeight() * -1);
////
////				ClipboardContent content = new ClipboardContent();
////				String data = efx_getClipboardContent(FXTabWrapper.wrap(t));
////				if (data != null) {
////					content.put(DnDTabPaneSkin.TAB_MOVE, data);
////				}
////				db.setContent(content);
//			}
//		} catch (Throwable t) {
//			// // TODO Auto-generated catch block
//			t.printStackTrace();
//		}
//	}
//
//	@SuppressWarnings("all")
//	void tabPane_handleDragOver(Pane tabHeaderArea, Pane headersRegion, EFXDragEvent event) {
////		System.err.println("==========> OVER AT HEADER");
//		Tab draggedTab = DRAGGED_TAB;
//		if (draggedTab == null) {
//			return;
//		}
//
//		// Consume the drag in any case
//		event.consume();
//
//		double x = event.getX() - headersRegion.getBoundsInParent().getMinX();
//
//		Node referenceNode = null;
//		DropType type = DropType.AFTER;
//		for (Node n : headersRegion.getChildren()) {
//			Bounds b = n.getBoundsInParent();
//			if (b.getMaxX() > x) {
//				if (b.getMinX() + b.getWidth() / 2 > x) {
//					referenceNode = n;
//					type = DropType.BEFORE;
//				} else {
//					referenceNode = n;
//					type = DropType.AFTER;
//				}
//				break;
//			}
//		}
//
//		if (referenceNode == null && headersRegion.getChildren().size() > 0) {
//			referenceNode = headersRegion.getChildren().get(headersRegion.getChildren().size() - 1);
//			type = DropType.AFTER;
//		}
//
//		if (referenceNode != null) {
//			try {
//				Field field = referenceNode.getClass().getDeclaredField("tab"); //$NON-NLS-1$
//				field.setAccessible(true);
//				Tab tab = (Tab) field.get(referenceNode);
//
//				boolean noMove = false;
//				if (tab == draggedTab) {
//					noMove = true;
//				} else if (type == DropType.BEFORE) {
//					int idx = getSkinnable().getTabs().indexOf(tab);
//					if (idx > 0) {
//						if (getSkinnable().getTabs().get(idx - 1) == draggedTab) {
//							noMove = true;
//						}
//					}
//				} else {
//					int idx = getSkinnable().getTabs().indexOf(tab);
//
//					if (idx + 1 < getSkinnable().getTabs().size()) {
//						if (getSkinnable().getTabs().get(idx + 1) == draggedTab) {
//							noMove = true;
//						}
//					}
//				}
//
//				if (noMove) {
//					efx_dragFeedback(FXTabWrapper.wrap(draggedTab), null, null, DropType.NONE);
//					return;
//				}
//
//				Bounds b = referenceNode.getBoundsInLocal();
//				b = referenceNode.localToScene(b);
//				b = getSkinnable().sceneToLocal(b);
//
//				efx_dragFeedback(FXTabWrapper.wrap(draggedTab), FXTabWrapper.wrap(tab), b, type);
//			} catch (Throwable e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
////			event.acceptTransferModes(TransferMode.MOVE);
//		} else {
//			efx_dragFeedback(FXTabWrapper.wrap(draggedTab), null, null, DropType.NONE);
//		}
//	}
//
//	@SuppressWarnings("all")
//	void tabPane_handleDragDropped(Pane tabHeaderArea, Pane headersRegion, EFXDragEvent event) {
//		Tab draggedTab = DRAGGED_TAB;
//		if (draggedTab == null) {
//			return;
//		}
//
//		double x = event.getX() - headersRegion.getBoundsInParent().getMinX();
//
//		Node referenceNode = null;
//		DropType type = DropType.AFTER;
//		for (Node n : headersRegion.getChildren()) {
//			Bounds b = n.getBoundsInParent();
//			if (b.getMaxX() > x) {
//				if (b.getMinX() + b.getWidth() / 2 > x) {
//					referenceNode = n;
//					type = DropType.BEFORE;
//				} else {
//					referenceNode = n;
//					type = DropType.AFTER;
//				}
//				break;
//			}
//		}
//
//		if (referenceNode == null && headersRegion.getChildren().size() > 0) {
//			referenceNode = headersRegion.getChildren().get(headersRegion.getChildren().size() - 1);
//			type = DropType.AFTER;
//		}
//
//		if (referenceNode != null) {
//			try {
//				Field field = referenceNode.getClass().getDeclaredField("tab"); //$NON-NLS-1$
//				field.setAccessible(true);
//				Tab tab = (Tab) field.get(referenceNode);
//
//				boolean noMove = false;
//				if( tab == null ) {
//					event.setComplete(false);
//					return;
//				} else if (tab == draggedTab) {
//					noMove = true;
//				} else if (type == DropType.BEFORE) {
//					int idx = getSkinnable().getTabs().indexOf(tab);
//					if (idx > 0) {
//						if (getSkinnable().getTabs().get(idx - 1) == draggedTab) {
//							noMove = true;
//						}
//					}
//				} else {
//					int idx = getSkinnable().getTabs().indexOf(tab);
//
//					if (idx + 1 < getSkinnable().getTabs().size()) {
//						if (getSkinnable().getTabs().get(idx + 1) == draggedTab) {
//							noMove = true;
//						}
//					}
//				}
//
//				if (!noMove) {
//					StyleOrigin openOrigin = this.openAnimation.getStyleOrigin();
//					StyleOrigin closeOrigin = this.closeAnimation.getStyleOrigin();
//					Object openValue = this.openAnimation.getValue();
//					Object closeValue = this.closeAnimation.getValue();
//					try {
//						this.openAnimation.setValue(this.noneEnum);
//						this.closeAnimation.setValue(this.noneEnum);
//						efx_dropped(event.getScreenX(), event.getScreenY(),FXTabWrapper.wrap(draggedTab), FXTabWrapper.wrap(tab), type);
//						event.setComplete(true);
//					} finally {
//						this.openAnimation.applyStyle(openOrigin, openValue);
//						this.closeAnimation.applyStyle(closeOrigin, closeValue);
//					}
//
//				} else {
//					event.setComplete(false);
//				}
//			} catch (Throwable e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			event.consume();
//		}
//
////		Event.fireEvent(event.getTarget(), new EFXDragEvent(event.getTarget(), event.getTarget(),
////                EFXDragEvent.DRAG_DONE, event.getScreenX(), event.getScreenY(), true));
//	}
//
//	void tabPane_handleDragDone(EFXDragEvent event) {
//		Tab tab = DRAGGED_TAB;
//		if (tab == null) {
//			return;
//		}
//
//		efx_dragFinished(FXTabWrapper.wrap(tab));
//	}
//
//	private @Nullable Function<@NonNull GenericTab, @NonNull Boolean> startFunction;
//	private @Nullable Consumer<@NonNull GenericTab> dragFinishedConsumer;
//	private @Nullable Consumer<@NonNull FeedbackData> feedbackConsumer;
//	private @Nullable Consumer<@NonNull DroppedData> dropConsumer;
//	private @Nullable Function<@NonNull GenericTab, @NonNull String> clipboardDataFunction;
//
//	@Override
//	public void setClipboardDataFunction(@Nullable Function<@NonNull GenericTab, @NonNull String> clipboardDataFunction) {
//		this.clipboardDataFunction = clipboardDataFunction;
//	}
//
//	@Override
//	public void setStartFunction(@Nullable Function<@NonNull GenericTab, @NonNull Boolean> startFunction) {
//		this.startFunction = startFunction;
//	}
//
//	@Override
//	public void setDragFinishedConsumer(@Nullable Consumer<@NonNull GenericTab> dragFinishedConsumer) {
//		this.dragFinishedConsumer = dragFinishedConsumer;
//	}
//
//	@Override
//	public void setFeedbackConsumer(@Nullable Consumer<@NonNull FeedbackData> feedbackConsumer) {
//		this.feedbackConsumer = feedbackConsumer;
//	}
//
//	@Override
//	public void setDropConsumer(@Nullable Consumer<@NonNull DroppedData> dropConsumer) {
//		this.dropConsumer = dropConsumer;
//	}
//
//	private boolean efx_canStartDrag(@NonNull GenericTab tab) {
//		if (this.startFunction != null) {
//			return this.startFunction.apply(tab).booleanValue();
//		}
//		return true;
//	}
//
//	private void efx_dragFeedback(@NonNull GenericTab draggedTab, GenericTab targetTab, Bounds bounds, @NonNull DropType dropType) {
//		if (this.feedbackConsumer != null) {
//			this.feedbackConsumer.accept(new FeedbackData(draggedTab, targetTab, bounds, dropType));
//		}
//	}
//
//	private void efx_dropped(double x, double y, @NonNull GenericTab draggedTab, @Nullable GenericTab targetTab, @NonNull DropType dropType) {
//		if (this.dropConsumer != null) {
//			this.dropConsumer.accept(new DroppedData(x, y, draggedTab, targetTab, dropType));
//		}
//	}
//
//	private void efx_dragFinished(@NonNull GenericTab tab) {
//		if (this.dragFinishedConsumer != null) {
//			this.dragFinishedConsumer.accept(tab);
//		}
//	}
//
//	private String efx_getClipboardContent(@NonNull GenericTab t) {
//		if (this.clipboardDataFunction != null) {
//			return this.clipboardDataFunction.apply(t);
//		}
//		return System.identityHashCode(t) + ""; //$NON-NLS-1$
//	}
//
//}

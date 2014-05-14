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
package org.eclipse.fx.ui.workbench.renderers.fx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.Skin;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.fx.ui.workbench.renderers.base.BaseRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseStackRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WStack;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WStack.WStackItem;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.DnDSupport;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.DnDTabPane;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.PaginationItem;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;
import org.eclipse.jdt.annotation.NonNull;

/**
 * default renderer for {@link MPartStack}
 */
public class DefStackRenderer extends BaseStackRenderer<Node, Object, Node> {

	@Override
	protected Class<? extends WStack<Node, Object, Node>> getWidgetClass(MPartStack stack) {
		if (stack.getTags().contains(WStack.TAG_PAGINATION)) {
			return PaginationWidgetImpl.class;
		} else {
			return StackWidgetImpl.class;
		}

	}

	static class StackWidgetImpl extends WLayoutedWidgetImpl<Node, Node, MPartStack> implements WStack<Node, Object, Node> {

		WCallback<WStackItem<Object, Node>, Void> mouseSelectedItemCallback;
		WCallback<WStackItem<Object, Node>, Void> keySelectedItemCallback;
		WCallback<DragData, Boolean> dragStartCallback;
		WCallback<DropData, Void> droppedCallback;
		
		// private WCallback<WMinMaxState, Void> minMaxCallback;
		// private MinMaxGroup minMaxGroup;
		boolean inKeyTraversal;

		// @Inject
		// private EModelService modelService;

		@Inject
		DnDFeedbackService dndFeedback;
		
		private final MPartStack domainElement;
		
		@Inject
		public StackWidgetImpl(@Named(BaseRenderer.CONTEXT_DOM_ELEMENT) MPartStack domainElement) {
			this.domainElement = domainElement;
		}
		
		@Override
		protected Pane createStaticPane() {
			return new StackPane() {
				@Override
				protected void layoutChildren() {
					super.layoutChildren();
					// if( minMaxGroup != null ) {
					//
					// }
				}
			};
		}

		@Override
		public void setMouseSelectedItemCallback(WCallback<WStackItem<Object, Node>, Void> mouseSelectedItemCallback) {
			this.mouseSelectedItemCallback = mouseSelectedItemCallback;
		}

		@Override
		public void setKeySelectedItemCallback(WCallback<WStackItem<Object, Node>, Void> keySelectedItemCallback) {
			this.keySelectedItemCallback = keySelectedItemCallback;
		}

		@Override
		public TabPane getWidget() {
			return (TabPane) super.getWidget();
		}

		@Override
		public int indexOf(WStackItem<Object, Node> item) {
			return getWidget().getTabs().indexOf(item.getNativeItem());
		}

		@Override
		public int getItemCount() {
			return getWidget().getTabs().size();
		}

		@Override
		public void setMinMaxCallback(WCallback<WMinMaxState, Void> minMaxCallback) {
			// this.minMaxCallback = minMaxCallback;
		}

		@Override
		public void setMinMaxState(WMinMaxState state) {
			// if( state == WMinMaxState.NONE ) {
			// if( minMaxGroup != null ) {
			// ((Pane)getStaticLayoutNode()).getChildren().remove(minMaxGroup);
			// minMaxGroup = null;
			// }
			// } else {
			// if( minMaxGroup == null ) {
			// minMaxGroup = new MinMaxGroup();
			// minMaxGroup.setManaged(false);
			// minMaxGroup.setState(state);
			// ((Pane)getStaticLayoutNode()).getChildren().add(minMaxGroup);
			// } else {
			// minMaxGroup.setState(state);
			// ((Pane)getStaticLayoutNode()).requestLayout();
			// }
			// }
		}
		
		@Override
		protected TabPane createWidget() {
			DnDSupport dnd = new DnDSupport(
					(param) -> StackWidgetImpl.this.dragStartCallback,
					(param) -> StackWidgetImpl.this.droppedCallback,
					StackWidgetImpl.this.dndFeedback,
					domainElement);
			
			DnDTabPane p = new DnDTabPane();
			p.addEventHandler(DnDTabPane.DND_TABPANE_DRAG_START, dnd::handleDragStart);
			p.addEventHandler(DnDTabPane.DND_TABPANE_DROPPED, dnd::handleDropped);
			p.addEventHandler(DnDTabPane.DND_TABPANE_DRAG_FEEDBACK, dnd::handleFeedback);
			p.addEventHandler(DnDTabPane.DND_TABPANE_DRAG_FINISHED, dnd::handleFinished);
			
//			TabPane p = new TabPane() {
//				@Override
//				protected Skin<?> createDefaultSkin() {
//					Skin<?> skin = super.createDefaultSkin();
//					DnDSupporter.hookTabPane(skin, getDomElement(), StackWidgetImpl.this.dndFeedback,
//							(param) -> StackWidgetImpl.this.dragStartCallback,
//							(param) -> StackWidgetImpl.this.droppedCallback);
//					return skin;
//				}
//			};

			// ContextMenu m = new ContextMenu();
			//
			// {
			// MenuItem item = new MenuItem("Detach");
			// item.setOnAction(new EventHandler<ActionEvent>() {
			//
			// @Override
			// public void handle(ActionEvent event) {
			// DetachView d = new DetachView();
			// d.detach((MPart) getDomElement().getSelectedElement(),
			// modelService);
			// }
			// });
			// m.getItems().add(item);
			// }
			//
			// {
			// MenuItem item = new MenuItem("Move To First");
			// item.setOnAction(new EventHandler<ActionEvent>() {
			//
			// @Override
			// public void handle(ActionEvent event) {
			// MoveToFirst d = new MoveToFirst();
			// d.move((MPart) getDomElement().getSelectedElement());
			// }
			// });
			// m.getItems().add(item);
			// }
			//
			// {
			// MenuItem item = new MenuItem("Move To Last");
			// item.setOnAction(new EventHandler<ActionEvent>() {
			//
			// @Override
			// public void handle(ActionEvent event) {
			// MoveToLast d = new MoveToLast();
			// d.move((MPart) getDomElement().getSelectedElement());
			// }
			// });
			// m.getItems().add(item);
			// }
			//
			// {
			// MenuItem item = new MenuItem("Pin To Bottom");
			// item.setOnAction(new EventHandler<ActionEvent>() {
			//
			// @Override
			// public void handle(ActionEvent event) {
			// PinToBottom d = new PinToBottom();
			// d.pin((MPart) getDomElement().getSelectedElement());
			// }
			// });
			// m.getItems().add(item);
			// }
			//
			// p.setContextMenu(m);
			// (FXTabPane)p.minMaxStateProperty().addListener(new
			// ChangeListener<MinMaxState>() {
			//
			// @Override
			// public void changed(ObservableValue<? extends MinMaxState>
			// observable, MinMaxState oldValue, MinMaxState newValue) {
			// if( minMaxCallback != null ) {
			// switch (newValue) {
			// case RESTORED:
			// minMaxCallback.call(WMinMaxState.RESTORED);
			// break;
			// case MAXIMIZED:
			// minMaxCallback.call(WMinMaxState.MAXIMIZED);
			// break;
			// case MINIMIZED:
			// minMaxCallback.call(WMinMaxState.MINIMIZED);
			// break;
			// case NONE:
			// // Nothing to do
			// break;
			// }
			// }
			// }
			// });
			p.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent event) {
					StackWidgetImpl.this.inKeyTraversal = true;
				}

			});
			p.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent event) {
					StackWidgetImpl.this.inKeyTraversal = false;
				}

			});

			p.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

				@Override
				public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
					if (newValue == null || (getWidgetState() != WidgetState.CREATED && getWidgetState() != WidgetState.IN_SETUP)) {
						return;
					}
					final StackItemImpl w = (StackItemImpl) newValue.getUserData();
					w.handleSelection();

					final WCallback<WStackItem<Object, Node>, Void> cb;
					if (!StackWidgetImpl.this.inKeyTraversal) {
						cb = StackWidgetImpl.this.mouseSelectedItemCallback;
					} else {
						cb = StackWidgetImpl.this.keySelectedItemCallback;
					}
					
					if (cb != null) {
						if (w.tab.getContent() != null && !w.tab.getContent().isVisible()) {
							// At the moment the visibility changes the content
							// is not yet
							// made visible
							w.tab.getContent().visibleProperty().addListener(new ChangeListener<Boolean>() {

								@Override
								public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
									w.tab.getContent().visibleProperty().removeListener(this);
									if (newValue.booleanValue()) {
										cb.call(w);
									}
								}
							});
						} else {
							if (w.tab.getContent() == null || w.tab.getContent().getScene() != null) {
								// Delay if the subcontrol just got created
								// isVisible() reports true while it is not
								// really
								Platform.runLater(new Runnable() {

									@Override
									public void run() {
										cb.call(w);
									}
								});
							} else {
								// We are in the init phase
								cb.call(w);
							}
						}
					}
				}
			});
			return p;
		}

		@Override
		protected TabPane getWidgetNode() {
			return getWidget();
		}

		@Override
		public Class<? extends WStackItem<Object, Node>> getStackItemClass() {
			return StackItemImpl.class;
		}

		@Override
		public void addItem(WStackItem<Object, Node> item) {
			addItems(Collections.singletonList(item));
		}

		@Override
		public void addItems(List<WStackItem<Object, Node>> items) {
			getWidget().getTabs().addAll(extractTabs(items));
		}

		@Override
		public void addItems(int index, List<WStackItem<Object, Node>> items) {
			if( index >= getWidget().getTabs().size() ) {
				addItems(items);
			} else {
				getWidget().getTabs().addAll(index, extractTabs(items));	
			}
		}

		private static final List<Tab> extractTabs(List<WStackItem<Object, Node>> items) {
			List<Tab> tabs = new ArrayList<Tab>(items.size());
			for (WStackItem<Object, Node> t : items) {
				tabs.add((Tab) t.getNativeItem());
			}
			return tabs;
		}

		@Override
		public void selectItem(int idx) {
			getWidget().getSelectionModel().select(idx);
		}

		@Override
		public List<WStackItem<Object, Node>> getItems() {
			List<WStackItem<Object, Node>> rv = new ArrayList<WStackItem<Object, Node>>();
			for (Tab t : getWidget().getTabs()) {
				@SuppressWarnings("unchecked")
				WStackItem<Object, Node> i = (WStackItem<Object, Node>) t.getUserData();
				if (i != null) {
					rv.add(i);
				}
			}
			return Collections.unmodifiableList(rv);
		}

		@Override
		public void removeItems(List<WStackItem<Object, Node>> items) {
			List<Object> l = new ArrayList<Object>();
			for (WStackItem<Object, Node> i : items) {
				l.add(i.getNativeItem());
			}
			getWidget().getTabs().removeAll(l);
		}
		
		@Override
		public void setDragStartCallback(@NonNull WCallback<DragData, Boolean> dragStackCallback) {
			this.dragStartCallback = dragStackCallback;
		}

		@Override
		public void setDragDroppedCallback(@NonNull WCallback<DropData, Void> droppedCallback) {
			this.droppedCallback = droppedCallback;
		}
		
		
	}

	static class StackItemImpl implements WStackItem<Object, Node> {
		Tab tab;
		private WCallback<WStackItem<Object, Node>, Node> initCallback;
		WCallback<WStackItem<Object, Node>, Boolean> closeCallback;
		private MStackElement domElement;

		@Inject
		private GraphicsLoader graphicsLoader;

		private String label;
		private boolean dirty;

		@Inject
		public StackItemImpl(@Named(ATTRIBUTE_localizedLabel) @Optional String label, @Named(UIEvents.Dirtyable.DIRTY) @Optional boolean dirty) {
			this.label = label;
			this.dirty = dirty;
		}

		@PostConstruct
		void init() {
			getWidget();
		}

		@Override
		public void setDomElement(MStackElement domElement) {
			this.domElement = domElement;
		}

		@Override
		public MStackElement getDomElement() {
			return this.domElement;
		}

		protected Tab getWidget() {
			if (this.tab == null) {
				this.tab = createWidget();
			}
			this.tab.setUserData(this);
			return this.tab;
		}

		protected Tab createWidget() {
			final Tab t = new Tab();
			t.setOnCloseRequest(new EventHandler<Event>() {

				@Override
				public void handle(Event event) {
					if (StackItemImpl.this.closeCallback != null) {
						if (StackItemImpl.this.closeCallback.call(StackItemImpl.this).booleanValue()) {
							event.consume();
						}
					}
				}
			});
			return t;
		}

		void handleSelection() {
			if (this.initCallback != null) {
				this.tab.setContent(this.initCallback.call(this));
				this.initCallback = null;
			}
		}

		@Override
		public void setInitCallback(WCallback<WStackItem<Object, Node>, Node> initCallback) {
			this.initCallback = initCallback;
		}

		@Override
		public Tab getNativeItem() {
			return getWidget();
		}

		@Inject
		public void setLabel(@Named(ATTRIBUTE_localizedLabel) @Optional String label) {
			this.label = label;
			getWidget().setText(this.dirty ? "*" + notNull(label) : notNull(label)); //$NON-NLS-1$
		}

		@Inject
		public void setCloseable(@Named(UIEvents.Part.CLOSEABLE) @Optional boolean closeable) {
			getWidget().setClosable(closeable);
		}

		@Inject
		public void setIcon(@Named(UIEvents.UILabel.ICONURI) @Optional String iconUri) {
			if (iconUri != null) {
				getWidget().setGraphic(this.graphicsLoader.getGraphicsNode(URI.createURI(iconUri)));
			} else {
				getWidget().setGraphic(null);
			}
		}

		@Inject
		public void setDirty(@Named(UIEvents.Dirtyable.DIRTY) @Optional boolean dirty) {
			this.dirty = dirty;
			getWidget().setText(dirty ? "*" + notNull(this.label) : notNull(this.label)); //$NON-NLS-1$
		}

		@Override
		public void setOnCloseCallback(final WCallback<WStackItem<Object, Node>, Boolean> callback) {
			this.closeCallback = callback;
		}

		private static String notNull(String s) {
			return s == null ? "" : s; //$NON-NLS-1$
		}
	}

	static class PaginationWidgetImpl extends WLayoutedWidgetImpl<Node, Node, MPartStack> implements WStack<Node, Object, Node> {
		List<WStackItem<Object, Node>> items = new ArrayList<WStack.WStackItem<Object, Node>>();
		WCallback<WStackItem<Object, Node>, Void> mouseSelectedItemCallback;

		@Override
		public void setMinMaxCallback(WCallback<WMinMaxState, Void> minMaxCallback) {
			// TODO Auto-generated method stub

		}

		@Override
		public void setMinMaxState(WMinMaxState state) {
			// TODO Auto-generated method stub

		}

		@Override
		public Class<? extends WStackItem<Object, Node>> getStackItemClass() {
			return PagninationItemImpl.class;
		}

		@Override
		public Pagination getWidget() {
			return (Pagination) super.getWidget();
		}

		@Override
		public void addItem(WStackItem<Object, Node> item) {
			this.items.add(item);
			getWidget().setPageCount(this.items.size());
		}

		@Override
		public void addItems(List<WStackItem<Object, Node>> items) {
			this.items.addAll(items);
			getWidget().setPageCount(this.items.size());
		}

		@Override
		public void addItems(int index, List<WStack.WStackItem<Object, Node>> items) {
			this.items.addAll(index, items);
			getWidget().setPageCount(this.items.size());
		}

		@Override
		public void selectItem(int idx) {
			getWidget().setCurrentPageIndex(idx);
		}

		@Override
		public int indexOf(WStackItem<Object, Node> item) {
			return this.items.indexOf(item);
		}

		@Override
		public List<WStackItem<Object, Node>> getItems() {
			return this.items;
		}

		@Override
		public void removeItems(List<WStackItem<Object, Node>> items) {
			this.items.removeAll(items);
			getWidget().setPageCount(this.items.size());
		}

		@Override
		public void setMouseSelectedItemCallback(WCallback<WStack.WStackItem<Object, Node>, Void> selectedItemCallback) {
			this.mouseSelectedItemCallback = selectedItemCallback;
		}

		@Override
		public void setKeySelectedItemCallback(WCallback<WStack.WStackItem<Object, Node>, Void> selectedItemCallback) {
			// empty
		}

		@Override
		public int getItemCount() {
			return this.items.size();
		}

		@Override
		protected Pagination getWidgetNode() {
			return getWidget();
		}

		@Override
		protected Pagination createWidget() {
			Pagination p = new Pagination();
			p.setPageFactory(new Callback<Integer, Node>() {

				@Override
				public Node call(Integer param) {
					PagninationItemImpl item = (PagninationItemImpl) PaginationWidgetImpl.this.items.get(param.intValue());
					item.handleSelection();
					PaginationWidgetImpl.this.mouseSelectedItemCallback.call(item);
					PaginationItem nativeItem = item.getNativeItem();
					if( nativeItem != null ) {
						return nativeItem.getContent();	
					}
					return null;
				}
			});
			p.currentPageIndexProperty().addListener(new ChangeListener<Number>() {

				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					final PagninationItemImpl item = (PagninationItemImpl) PaginationWidgetImpl.this.items.get(newValue.intValue());
					if (PaginationWidgetImpl.this.mouseSelectedItemCallback != null) {
						PaginationWidgetImpl.this.mouseSelectedItemCallback.call(item);
					}
				}
			});
			return p;
		}
		
		@Override
		public void setDragStartCallback(WCallback<DragData, Boolean> dragStackCallback) {
			// not implemented yet
		}

		@Override
		public void setDragDroppedCallback(WCallback<DropData, Void> callback) {
			// not implemented yet
		}

	}

	static class PagninationItemImpl implements WStackItem<Object, Node> {
		private WCallback<WStackItem<Object, Node>, Node> initCallback;
		private PaginationItem item = new PaginationItem();
		private MStackElement domElement;

		void handleSelection() {
			if (this.initCallback != null) {
				this.item.setContent(this.initCallback.call(this));
				this.initCallback = null;
			}
		}

		@Override
		public PaginationItem getNativeItem() {
			return this.item;
		}

		@Override
		public void setDomElement(MStackElement domElement) {
			this.domElement = domElement;
		}

		@Override
		public MStackElement getDomElement() {
			return this.domElement;
		}

		@Override
		public void setInitCallback(WCallback<WStackItem<Object, Node>, Node> callback) {
			this.initCallback = callback;
		}

		@Override
		public void setOnCloseCallback(WCallback<WStackItem<Object, Node>, Boolean> callback) {
			// there's no close
		}
	}
}

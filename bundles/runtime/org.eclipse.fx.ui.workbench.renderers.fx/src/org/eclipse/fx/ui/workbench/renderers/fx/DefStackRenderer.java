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
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.workbench.IResourceUtilities;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.e4.controls.FXTab;
import org.eclipse.fx.ui.workbench.fx.controls.FXTabFactory;
import org.eclipse.fx.ui.workbench.renderers.base.BaseStackRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WStack;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WStack.WStackItem;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.PaginationItem;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;


public class DefStackRenderer extends BaseStackRenderer<Node,Object, Node> {

	@Override
	protected Class<? extends WStack<Node,Object, Node>> getWidgetClass(MPartStack stack) {
		if( stack.getTags().contains(WStack.TAG_PAGINATION) ) {
			return PaginationWidgetImpl.class;
		} else {
			return StackWidgetImpl.class;	
		}
		
	}

	public static class StackWidgetImpl extends WLayoutedWidgetImpl<Node, Node, MPartStack> implements WStack<Node, Object, Node> {
		
		private WCallback<WStackItem<Object, Node>, Void> mouseSelectedItemCallback;
		private WCallback<WStackItem<Object, Node>, Void> keySelectedItemCallback;
//		private WCallback<WMinMaxState, Void> minMaxCallback;
		private boolean inKeyTraversal;
		
//		@Inject
//		private EModelService modelService;
		
		public void setMouseSelectedItemCallback(WCallback<WStackItem<Object, Node>, Void> mouseSelectedItemCallback) {
			this.mouseSelectedItemCallback = mouseSelectedItemCallback;
		}
		
		public void setKeySelectedItemCallback(WCallback<WStackItem<Object, Node>, Void> keySelectedItemCallback) {
			this.keySelectedItemCallback = keySelectedItemCallback;
		}
		
		@Override
		public TabPane  getWidget() {
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
//			this.minMaxCallback = minMaxCallback;
		}
		
		@Override
		public void setMinMaxState(WMinMaxState state) {
//			MinMaxState t = MinMaxState.RESTORED;
//			switch (state) {
//			case MAXIMIZED:
//				t = MinMaxState.MAXIMIZED;
//				break;
//			case MINIMIZED:
//				t = MinMaxState.MINIMIZED;
//				break;
//			case RESTORED:
//				t = MinMaxState.RESTORED;
//				break;
//			case NONE:
//				t = MinMaxState.NONE;
//				break;
//			}
//			getWidget().setMinMaxState(t);
		}
		
		@Override
		protected TabPane  createWidget() {
			TabPane  p = FXTabFactory.createTabPane();
			
//			ContextMenu m = new ContextMenu();
//			
//			{
//				MenuItem item = new MenuItem("Detach");
//				item.setOnAction(new EventHandler<ActionEvent>() {
//					
//					@Override
//					public void handle(ActionEvent event) {
//						DetachView d = new DetachView();
//						d.detach((MPart) getDomElement().getSelectedElement(), modelService);
//					}
//				});
//				m.getItems().add(item);	
//			}
//			
//			{
//				MenuItem item = new MenuItem("Move To First");
//				item.setOnAction(new EventHandler<ActionEvent>() {
//					
//					@Override
//					public void handle(ActionEvent event) {
//						MoveToFirst d = new MoveToFirst();
//						d.move((MPart) getDomElement().getSelectedElement());
//					}
//				});
//				m.getItems().add(item);	
//			}
//			
//			{
//				MenuItem item = new MenuItem("Move To Last");
//				item.setOnAction(new EventHandler<ActionEvent>() {
//					
//					@Override
//					public void handle(ActionEvent event) {
//						MoveToLast d = new MoveToLast();
//						d.move((MPart) getDomElement().getSelectedElement());
//					}
//				});
//				m.getItems().add(item);	
//			}
//			
//			{
//				MenuItem item = new MenuItem("Pin To Bottom");
//				item.setOnAction(new EventHandler<ActionEvent>() {
//					
//					@Override
//					public void handle(ActionEvent event) {
//						PinToBottom d = new PinToBottom();
//						d.pin((MPart) getDomElement().getSelectedElement());
//					}
//				});
//				m.getItems().add(item);	
//			}
//			
//			p.setContextMenu(m);
//			(FXTabPane)p.minMaxStateProperty().addListener(new ChangeListener<MinMaxState>() {
//
//				@Override
//				public void changed(ObservableValue<? extends MinMaxState> observable, MinMaxState oldValue, MinMaxState newValue) {
//					if( minMaxCallback != null ) {
//						switch (newValue) {
//						case RESTORED:
//							minMaxCallback.call(WMinMaxState.RESTORED);
//							break;
//						case MAXIMIZED:
//							minMaxCallback.call(WMinMaxState.MAXIMIZED);
//							break;
//						case MINIMIZED:
//							minMaxCallback.call(WMinMaxState.MINIMIZED);
//							break;
//						case NONE:
//							// Nothing to do
//							break;
//						}	
//					}
//				}
//			});
			p.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent event) {
					inKeyTraversal = true;
				}
				
			});
			p.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent event) {
					inKeyTraversal = false;
				}
				
			});

			p.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

				@Override
				public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
					if( newValue == null || (getWidgetState() != WidgetState.CREATED && getWidgetState() != WidgetState.IN_SETUP ) ) {
						return;
					}
					final StackItemImpl w = (StackItemImpl) newValue.getUserData();
					w.handleSelection();
					 
					final WCallback<WStackItem<Object, Node>, Void> cb;
					if( ! inKeyTraversal ) {
						cb = mouseSelectedItemCallback;
					} else {
						cb = keySelectedItemCallback;
					}
					
					if( cb != null ) {
						if( w.tab.getContent() != null && ! w.tab.getContent().isVisible() ) {
							// At the moment the visibility changes the content is not yet
							// made visible
							w.tab.getContent().visibleProperty().addListener(new ChangeListener<Boolean>() {

								@Override
								public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
									w.tab.getContent().visibleProperty().removeListener(this);
									if( newValue ) {
										cb.call(w);
									}
								}
							});
						} else {
							if( w.tab.getContent() == null || w.tab.getContent().getScene() != null ) {
								// Delay if the subcontrol just got created
								// isVisible() reports true while it is not really
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
			getWidget().getTabs().addAll(index, extractTabs(items));
		}
		
		private static final List<Tab> extractTabs(List<WStackItem<Object, Node>> items) {
			List<Tab> tabs = new ArrayList<Tab>(items.size());
			for( WStackItem<Object, Node> t : items ) {
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
			for( Tab t : getWidget().getTabs() ) {
				@SuppressWarnings("unchecked")
				WStackItem<Object, Node> i = (WStackItem<Object, Node>) t.getUserData();
				if( i != null ) {
					rv.add(i);	
				}
			}
			return Collections.unmodifiableList(rv);
		}

		@Override
		public void removeItems(List<WStackItem<Object, Node>> items) {
			List<Object> l = new ArrayList<Object>();
			for( WStackItem<Object, Node> i : items ) {
				l.add(i.getNativeItem());
			}
			getWidget().getTabs().removeAll(l);
		}
	}
	
	public static class StackItemImpl implements WStackItem<Object, Node> {
		private Tab tab;
		private WCallback<WStackItem<Object, Node>, Node> initCallback;
		private WCallback<WStackItem<Object, Node>, Boolean> closeCallback;
		private MStackElement domElement;
		
		@Inject
		private IResourceUtilities<Image> resourceUtilities;
		
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
			return domElement;
		}

		protected Tab getWidget() {
			if( tab == null ) {
				tab = createWidget();
			}
			tab.setUserData(this);
			return tab;
		}
		
		protected Tab createWidget() {
			final Tab t = FXTabFactory.createTab();
			((FXTab)t).setCloseVetoHandler(new Callback<Tab, Boolean>() {
				
				@Override
				public Boolean call(Tab param) {
					if( closeCallback != null ) {
						return closeCallback.call(StackItemImpl.this);
					}
					return Boolean.FALSE;
				}
			});
			return t;
		}
		
		void handleSelection() {
			if( initCallback != null ) {
				tab.setContent(initCallback.call(this));
				initCallback = null;
			}	
		}
		
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
			getWidget().setText(dirty ? "*" + notNull(label) : notNull(label));
		}
		
		@Inject
		public void setCloseable(@Named(UIEvents.Part.CLOSEABLE) @Optional boolean closeable) {
			getWidget().setClosable(closeable);
		}
		
		@Inject
		public void setIcon(@Named(UIEvents.UILabel.ICONURI) @Optional String iconUri) {
			if( iconUri != null ) {
				getWidget().setGraphic(new ImageView(resourceUtilities.imageDescriptorFromURI(URI.createURI(iconUri))));
			} else {
				getWidget().setGraphic(null);
			}
		}
		
		@Inject
		public void setDirty(@Named(UIEvents.Dirtyable.DIRTY) @Optional boolean dirty) {
			this.dirty = dirty;
			getWidget().setText(dirty ? "*" + notNull(label) : notNull(label));
		}
		
		@Override
		public void setOnCloseCallback(final WCallback<WStackItem<Object, Node>, Boolean> callback) {
			this.closeCallback = callback;
		}
		
		private static String notNull(String s) {
			return s == null ? "" : s;
		}
	}
	
	
	public static class PaginationWidgetImpl extends WLayoutedWidgetImpl<Node, Node, MPartStack> implements WStack<Node, Object, Node> {
		private List<WStackItem<Object, Node>> items = new ArrayList<WStack.WStackItem<Object,Node>>();
		private WCallback<WStackItem<Object, Node>, Void> mouseSelectedItemCallback;
		
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
			items.add(item);
			getWidget().setPageCount(items.size());
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
			return items.indexOf(item);
		}

		@Override
		public List<WStackItem<Object, Node>> getItems() {
			return items;
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
		}

		@Override
		public int getItemCount() {
			return items.size();
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
					PagninationItemImpl item = (PagninationItemImpl) items.get(param.intValue());
					item.handleSelection();
					mouseSelectedItemCallback.call(item);
					return item.getNativeItem().getContent();
				}
			});
			p.currentPageIndexProperty().addListener(new ChangeListener<Number>() {

				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					final PagninationItemImpl item =  (PagninationItemImpl) items.get(newValue.intValue());
					if( mouseSelectedItemCallback != null ) {
						mouseSelectedItemCallback.call(item);
					}
				}
			});
			return p;
		}
		
	}

	public static class PagninationItemImpl implements WStackItem<Object, Node> {
		private WCallback<WStackItem<Object, Node>, Node> initCallback;
		private PaginationItem item = new PaginationItem();
		private MStackElement domElement;
		
		void handleSelection() {
			if( initCallback != null ) {
				item.setContent(initCallback.call(this));
				initCallback = null;
			}	
		}
		
		@Override
		public PaginationItem getNativeItem() {
			return item;
		}

		@Override
		public void setDomElement(MStackElement domElement) {
			this.domElement = domElement;
		}

		@Override
		public MStackElement getDomElement() {
			return domElement;
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

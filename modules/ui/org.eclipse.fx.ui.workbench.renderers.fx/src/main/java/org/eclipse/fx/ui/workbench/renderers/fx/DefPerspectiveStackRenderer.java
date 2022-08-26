/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
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
package org.eclipse.fx.ui.workbench.renderers.fx;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.fx.ui.controls.Util;
import org.eclipse.fx.ui.services.Constants;
import org.eclipse.fx.ui.workbench.renderers.base.BasePerspectiveStackRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.services.PerspectiveTransitionService;
import org.eclipse.fx.ui.workbench.renderers.base.services.PerspectiveTransitionService.AnimationDelegate;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPerspectiveStack;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPerspectiveStack.WStackItem;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.PerspectiveStackItem;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;
import org.eclipse.jdt.annotation.NonNull;

/**
 * default renderer for {@link MPerspectiveStack}
 */
public class DefPerspectiveStackRenderer extends BasePerspectiveStackRenderer<BorderPane, PerspectiveStackItem, Node> {

	@Override
	protected Class<? extends WPerspectiveStack<BorderPane, PerspectiveStackItem, Node>> getWidgetClass(MPerspectiveStack stack) {
		if( stack.getTags().contains("efx-nodetach") ) { //$NON-NLS-1$
			return PerspectiveStackNoDetachImpl.class;
		} else {
			return PerspectiveStackImpl.class;
		}
		
	}
	
	/**
	 * @noreference
	 */
	public static class PerspectiveStackNoDetachImpl extends WLayoutedWidgetImpl<StackPane, StackPane, MPerspectiveStack> implements WPerspectiveStack<BorderPane, PerspectiveStackItem, Node> {
		@NonNull
		private List<@NonNull WStackItem<PerspectiveStackItem, Node>> items = new ArrayList<>();

		@Inject
		@Optional
		private PerspectiveTransitionService<BorderPane, Node> perspectiveSwitch;

		@Inject
		IEventBroker eventBroker;
		
		@Override
		public Class<? extends WStackItem<PerspectiveStackItem, Node>> getStackItemClass() {
			return PerspectiveStackItemImpl.class;
		}

		@Override
		public void addItem(WStackItem<PerspectiveStackItem, Node> item) {
			this.items.add(item);
		}

		@Override
		public void addItems(List<@NonNull WStackItem<PerspectiveStackItem, Node>> items) {
			this.items.addAll(items);
		}

		@Override
		public void addItems(int index, List<@NonNull WStackItem<PerspectiveStackItem, Node>> items) {
			this.items.addAll(index, items);
		}

		@Override
		public void selectItem(int idx) {
			WStackItem<PerspectiveStackItem, Node> item = this.items.get(idx);
			PerspectiveStackItem nativeItem = item.getNativeItem();
			if( nativeItem != null ) {
				Node node = nativeItem.getContent();
				if( node == null ) {
					return;
				}
				
				getWidget().getChildren().stream().forEach( c -> {
					if( c == node ) {
						c.setManaged(true);
						c.setVisible(true);
					} else {
						c.setManaged(false);
						c.setVisible(false);
					}
				});
				
				if( ! getWidget().getChildren().contains(node) ) {
					getWidget().getChildren().add(node);
				}
			}
		}

		@Override
		public int indexOf(WStackItem<PerspectiveStackItem, Node> item) {
			return this.items.indexOf(item);
		}

		@Override
		public List<WStackItem<PerspectiveStackItem, Node>> getItems() {
			return this.items;
		}

		@Override
		public void removeItems(List<WStackItem<PerspectiveStackItem, Node>> items) {
			this.items.removeAll(items);
		}

		@Override
		public void setMouseSelectedItemCallback(WCallback<WStackItem<PerspectiveStackItem, Node>, Void> selectedItemCallback) {
			// empty
		}

		@Override
		public void setKeySelectedItemCallback(WCallback<WStackItem<PerspectiveStackItem, Node>, Void> selectedItemCallback) {
			// empty
		}

		@Override
		public int getItemCount() {
			return this.items.size();
		}

		@Override
		public StackPane getWidgetNode() {
			return getWidget();
		}

		@Override
		protected StackPane createWidget() {
			return new StackPane();
		}
	}
	
	/**
	 * @noreference
	 */
	public static class PerspectiveStackItemImpl implements WStackItem<PerspectiveStackItem, Node> {
		private PerspectiveStackItem item;
		private MPerspective domElement;
		WCallback<WStackItem<PerspectiveStackItem, Node>, Node> initCallback;
		
		@PostConstruct
		void init() {
			getWidget();
		}

		protected PerspectiveStackItem getWidget() {
			if (this.item == null) {
				this.item = createWidget();
			}
			return this.item;
		}

		protected PerspectiveStackItem createWidget() {
			final PerspectiveStackItem t = new PerspectiveStackItem();
			t.setInitRunnable(new Runnable() {

				@Override
				public void run() {
					if (PerspectiveStackItemImpl.this.initCallback != null) {
						t.setContent(PerspectiveStackItemImpl.this.initCallback.call(PerspectiveStackItemImpl.this));
					}
				}
			});
			return t;
		}

		@Override
		public PerspectiveStackItem getNativeItem() {
			return this.item;
		}

		@Override
		public void setDomElement(MPerspective domElement) {
			this.domElement = domElement;
		}

		@Override
		public MPerspective getDomElement() {
			return this.domElement;
		}

		@Override
		public void setInitCallback(WCallback<WStackItem<PerspectiveStackItem, Node>, Node> callback) {
			this.initCallback = callback;
		}

		@Override
		public void setOnCloseCallback(WCallback<WStackItem<PerspectiveStackItem, Node>, Boolean> callback) {
			// empty
		}

	}

	
	/**
	 * @noreference
	 */
	public static class PerspectiveStackImpl extends WLayoutedWidgetImpl<BorderPane, BorderPane, MPerspectiveStack> implements WPerspectiveStack<BorderPane, PerspectiveStackItem, Node> {
		@NonNull
		private List<@NonNull WStackItem<PerspectiveStackItem, Node>> items = new ArrayList<>();
		private int currentIndex;

		@Inject
		@Optional
		private PerspectiveTransitionService<BorderPane, Node> perspectiveSwitch;

		@Inject
		IEventBroker eventBroker;

		@Override
		public Class<? extends WStackItem<PerspectiveStackItem, Node>> getStackItemClass() {
			return PerspectiveStackItemImpl.class;
		}

		@Override
		public void addItem(WStackItem<PerspectiveStackItem, Node> item) {
			this.items.add(item);
		}

		@Override
		public void addItems(List<@NonNull WStackItem<PerspectiveStackItem, Node>> items) {
			this.items.addAll(items);
		}

		@Override
		public void addItems(int index, List<@NonNull WStackItem<PerspectiveStackItem, Node>> items) {
			this.items.addAll(index, items);
		}

		@SuppressWarnings("null")
		@Override
		public void selectItem(int idx) {
			// sanity check
			if (idx >= this.items.size()) {
				this.logger.error(MessageFormat.format("Passed perspective index out of bounds in perspective stack: index={0}, size={1}", //$NON-NLS-1$
						Integer.valueOf(idx), Integer.valueOf(this.items.size())));
				return;
			}

			WStackItem<PerspectiveStackItem, Node> item = this.items.get(idx);
			PerspectiveStackItem nativeItem = item.getNativeItem();
			if (nativeItem != null) {
				Node node = nativeItem.getContent();
				if (node == null) {
					return;
				}

				WStackItem<PerspectiveStackItem, Node> currentItem = getCurrentItem();
				MPerspective curDomElement = currentItem != null ? currentItem.getDomElement() : null;
				MPerspective nexDomElement = item.getDomElement();

				if (getWidget().getCenter() != null && this.perspectiveSwitch != null) {
					if (curDomElement != null && nexDomElement != null) {
						AnimationDelegate<BorderPane, Node> a = this.perspectiveSwitch.getDelegate(curDomElement, nexDomElement);
						if (a == null) {
							Util.attachNode(node, getWidget()::setCenter);
						} else {
							a.animate(getWidget(), node, () -> {
								if (curDomElement != null) {
									this.eventBroker.send(Constants.PERSPECTIVE_HIDDEN, curDomElement);
								}
								this.eventBroker.send(Constants.PERSPECTIVE_SHOWN, nexDomElement);
							});
						}
					} else {
						Util.attachNode(node, getWidget()::setCenter);
						if (curDomElement != null) {
							this.eventBroker.send(Constants.PERSPECTIVE_HIDDEN, curDomElement);
						}
						this.eventBroker.send(Constants.PERSPECTIVE_SHOWN, nexDomElement);
					}
				} else {
					Util.attachNode(node, getWidget()::setCenter);
					if (curDomElement != null) {
						this.eventBroker.send(Constants.PERSPECTIVE_HIDDEN, curDomElement);
					}
					this.eventBroker.send(Constants.PERSPECTIVE_SHOWN, nexDomElement);
				}
				this.currentIndex = idx;
			}
		}

		private WStackItem<PerspectiveStackItem, Node> getCurrentItem() {
			if (this.currentIndex >= 0 && this.currentIndex < this.items.size()) {
				return this.items.get(this.currentIndex);
			}
			return null;
		}

		@Override
		public int indexOf(WStackItem<PerspectiveStackItem, Node> item) {
			return this.items.indexOf(item);
		}

		@Override
		public List<WStackItem<PerspectiveStackItem, Node>> getItems() {
			return this.items;
		}

		@Override
		public void removeItems(List<WStackItem<PerspectiveStackItem, Node>> items) {
			final WStackItem<PerspectiveStackItem, Node> currentItem = getCurrentItem();
			this.items.removeAll(items);
			if (currentItem != null && !items.contains(currentItem)) {
				this.currentIndex = items.indexOf(currentItem);
			} else {
				// active element was removed or did not exist in the first place
				this.currentIndex = -1;
				if (currentItem != null) {
					this.eventBroker.send(Constants.PERSPECTIVE_HIDDEN, currentItem.getDomElement());
				}
			}
		}

		@Override
		public void setMouseSelectedItemCallback(WCallback<WStackItem<PerspectiveStackItem, Node>, Void> selectedItemCallback) {
			// empty
		}

		@Override
		public void setKeySelectedItemCallback(WCallback<WStackItem<PerspectiveStackItem, Node>, Void> selectedItemCallback) {
			// empty
		}

		@Override
		public int getItemCount() {
			return this.items.size();
		}

		@Override
		public BorderPane getWidgetNode() {
			return getWidget();
		}

		@Override
		protected BorderPane createWidget() {
			return new BorderPane();
		}
	}
}
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
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.fx.ui.workbench.renderers.base.BasePerspectiveStackRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.services.PerspectiveTransitionService;
import org.eclipse.fx.ui.workbench.renderers.base.services.PerspectiveTransitionService.AnimationDelegate;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPerspectiveStack;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPerspectiveStack.WStackItem;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.PerspectiveStackItem;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;

/**
 * default renderer for {@link MPerspectiveStack}
 */
public class DefPerspectiveStackRenderer extends BasePerspectiveStackRenderer<BorderPane, PerspectiveStackItem, Node> {

	@Override
	protected Class<? extends WPerspectiveStack<BorderPane, PerspectiveStackItem, Node>> getWidgetClass(MPerspectiveStack stack) {
		return PerspectiveStackImpl.class;
	}

	static class PerspectiveStackItemImpl implements WStackItem<PerspectiveStackItem, Node> {
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

	static class PerspectiveStackImpl extends WLayoutedWidgetImpl<BorderPane, BorderPane, MPerspectiveStack> implements WPerspectiveStack<BorderPane, PerspectiveStackItem, Node> {
		private List<WStackItem<PerspectiveStackItem, Node>> items = new ArrayList<WStackItem<PerspectiveStackItem, Node>>();
		private int currentIndex;

		@Inject
		@Optional
		private PerspectiveTransitionService<BorderPane, Node> perspectiveSwitch;

		@Override
		public Class<? extends WStackItem<PerspectiveStackItem, Node>> getStackItemClass() {
			return PerspectiveStackItemImpl.class;
		}

		@Override
		public void addItem(WStackItem<PerspectiveStackItem, Node> item) {
			this.items.add(item);
		}

		@Override
		public void addItems(List<WStackItem<PerspectiveStackItem, Node>> items) {
			this.items.addAll(items);
		}

		@Override
		public void addItems(int index, List<WStackItem<PerspectiveStackItem, Node>> items) {
			this.items.addAll(index, items);
		}

		@Override
		public void selectItem(int idx) {
			WStackItem<PerspectiveStackItem, Node> item = this.items.get(idx);
			Node node = item.getNativeItem().getContent();
			if (getWidget().getCenter() != null && this.perspectiveSwitch != null) {
				AnimationDelegate<BorderPane, Node> a = this.perspectiveSwitch.getDelegate(this.items.get(this.currentIndex).getDomElement(), item.getDomElement());
				if (a == null) {
					getWidget().setCenter(node);
				} else {
					a.animate(getWidget(), node);
				}
			} else {
				getWidget().setCenter(node);
			}
			this.currentIndex = idx;
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
		protected BorderPane getWidgetNode() {
			return getWidget();
		}

		@Override
		protected BorderPane createWidget() {
			return new BorderPane();
		}
	}
}
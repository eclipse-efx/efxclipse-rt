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
import java.util.Map;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.control.SplitPane.Divider;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.ui.panes.GridData;
import org.eclipse.fx.ui.panes.GridData.Alignment;
import org.eclipse.fx.ui.panes.GridLayoutPane;
import org.eclipse.fx.ui.workbench.renderers.base.BaseSashRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WSash;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;

/**
 * default renderer for sash
 */
public class DefSashRenderer extends BaseSashRenderer<Node> {

	@Override
	protected Class<? extends WSash<Node>> getWidgetClass(MPartSashContainer container) {
		if (container.getTags().contains(WSash.TAG_FIXED_LAYOUT)) {
			return WFixedSashImpl.class;
		} else {
			return WResizableSashImpl.class;
		}
	}

	static class WFixedSashImpl extends WLayoutedWidgetImpl<GridLayoutPane, Node, MPartSashContainer> implements WSash<Node> {

		private static GridData toGridData(Map<String, String> dataMap) {
			GridData gd = new GridData();
			if (dataMap.containsKey(WSash.FIXED_LAYOUT_WIDTH)) {
				gd.widthHint.set(Integer.parseInt(dataMap.get(WSash.FIXED_LAYOUT_WIDTH)));
				if (!dataMap.containsKey(WSash.FIXED_LAYOUT_HEIGHT)) {
					gd.grabExcessVerticalSpace.set(true);
					gd.verticalAlignment.set(Alignment.FILL);
				}
			} else {
				gd.horizontalAlignment.set(Alignment.FILL);
			}

			if (dataMap.containsKey(WSash.FIXED_LAYOUT_HEIGHT)) {
				gd.heightHint.set(Integer.parseInt(dataMap.get(WSash.FIXED_LAYOUT_HEIGHT)));
				if (!dataMap.containsKey(WSash.FIXED_LAYOUT_WIDTH)) {
					gd.grabExcessHorizontalSpace.set(true);
					gd.horizontalAlignment.set(Alignment.FILL);
				}
			} else {
				gd.verticalAlignment.set(Alignment.FILL);
			}

			if (dataMap.containsKey(WSash.FIXED_LAYOUT_GRAB_HORIZONTAL)) {
				gd.grabExcessHorizontalSpace.set(Boolean.parseBoolean(dataMap.get(WSash.FIXED_LAYOUT_GRAB_HORIZONTAL)));
				gd.horizontalAlignment.set(Alignment.FILL);
			}

			if (dataMap.containsKey(WSash.FIXED_LAYOUT_GRAB_VERTICAL)) {
				gd.grabExcessVerticalSpace.set(Boolean.parseBoolean(dataMap.get(WSash.FIXED_LAYOUT_GRAB_VERTICAL)));
				gd.verticalAlignment.set(Alignment.FILL);
			}

			return gd;
		}

		@Override
		public void addItem(WLayoutedWidget<MPartSashContainerElement> widget) {
			Node n = (Node) widget.getStaticLayoutNode();

			GridLayoutPane p = getWidget();
			if (getDomElement().isHorizontal()) {
				p.setNumColumns(p.getNumColumns() + 1);
			}

			GridData gd = toGridData(widget.getDomElement().getPersistedState());
			GridLayoutPane.setConstraint(n, gd);
			p.getChildren().add(n);
		}

		@Override
		public int getItemCount() {
			return getWidget().getChildren().size();
		}

		@Override
		public void addItems(List<WLayoutedWidget<MPartSashContainerElement>> list) {
			List<Node> nodeList = new ArrayList<Node>();
			GridLayoutPane p = getWidget();

			for (WLayoutedWidget<MPartSashContainerElement> w : list) {
				Node n = (Node) w.getStaticLayoutNode();

				GridData gd = toGridData(w.getDomElement().getPersistedState());
				GridLayoutPane.setConstraint(n, gd);
				nodeList.add(n);
			}

			if (getDomElement().isHorizontal()) {
				p.setNumColumns(p.getNumColumns() + nodeList.size());
			}

			p.getChildren().addAll(nodeList);
		}

		@Override
		public void addItems(int index, List<WLayoutedWidget<MPartSashContainerElement>> list) {
			List<Node> nodeList = new ArrayList<Node>();
			GridLayoutPane p = getWidget();

			for (WLayoutedWidget<MPartSashContainerElement> w : list) {
				Node n = (Node) w.getStaticLayoutNode();

				GridData gd = toGridData(w.getDomElement().getPersistedState());
				GridLayoutPane.setConstraint(n, gd);
				nodeList.add(n);
			}

			if (getDomElement().isHorizontal()) {
				p.setNumColumns(p.getNumColumns() + nodeList.size());
			}

			p.getChildren().addAll(index, nodeList);
		}

		@Override
		public void removeItem(WLayoutedWidget<MPartSashContainerElement> widget) {
			Node n = (Node) widget.getStaticLayoutNode();
			GridLayoutPane p = getWidget();
			p.setNumColumns(p.getNumColumns() - 1);
			p.getChildren().remove(n);
		}

		@Override
		protected GridLayoutPane getWidgetNode() {
			return getWidget();
		}

		@Override
		protected GridLayoutPane createWidget() {
			GridLayoutPane p = new GridLayoutPane();
			p.setMarginWidth(0);
			p.setMarginHeight(0);
			p.setHorizontalSpacing(0);
			p.setVerticalSpacing(0);
			return p;
		}

	}

	static class WResizableSashImpl extends WLayoutedWidgetImpl<SplitPane, SplitPane, MPartSashContainer> implements WSash<Node> {
		private List<WLayoutedWidget<MPartSashContainerElement>> items = new ArrayList<WLayoutedWidget<MPartSashContainerElement>>();

		ChangeListener<Number> listener = new ChangeListener<Number>() {
			boolean queueing;

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (!this.queueing) {
					this.queueing = true;
					Platform.runLater(new Runnable() {

						@SuppressWarnings("unqualified-field-access")
						@Override
						public void run() {
							recalcWeight();
							queueing = false;
						}
					});
				}
			}
		};

		void recalcWeight() {
			if (this.state != WidgetState.CREATED) {
				return;
			}

			// FIXME We should not do recalcs when we are in teardown of the
			// widget
			double prev = 0;
			int idx = 0;
			// No items nothing to recalculate
			if (this.items.isEmpty()) {
				return;
			}
			for (double d : getWidget().getDividerPositions()) {
				this.items.get(idx++).getDomElement().setContainerData((d - prev) * 10 + ""); //$NON-NLS-1$
				prev = d;
			}
			this.items.get(this.items.size() - 1).getDomElement().setContainerData((1.0 - prev) * 10 + ""); //$NON-NLS-1$
		}

		@Override
		protected void bindProperties(final SplitPane widget) {
			super.bindProperties(widget);
			widget.getDividers().addListener(new ListChangeListener<Divider>() {

				@Override
				public void onChanged(javafx.collections.ListChangeListener.Change<? extends Divider> c) {
					while (c.next()) {
						for (Divider d : c.getAddedSubList()) {
							d.positionProperty().addListener(WResizableSashImpl.this.listener);
						}

						for (Divider d : c.getRemoved()) {
							d.positionProperty().removeListener(WResizableSashImpl.this.listener);
						}
					}
				}
			});
			for (Divider d : widget.getDividers()) {
				d.positionProperty().addListener(this.listener);
			}
		}

		@Override
		protected SplitPane createWidget() {
			SplitPane p = new SplitPane();
			return p;
		}

		@Inject
		void setOrientation(@Named(UIEvents.GenericTile.HORIZONTAL) boolean horizontal) {
			getWidget().setOrientation(horizontal ? Orientation.HORIZONTAL : Orientation.VERTICAL);
		}

		@Override
		protected SplitPane getWidgetNode() {
			return getWidget();
		}

		@Override
		public void addItem(WLayoutedWidget<MPartSashContainerElement> widget) {
			SplitPane p = getWidget();
			p.getItems().add((Node) widget.getStaticLayoutNode());
			this.items.add(widget);
			updateDividers();
		}

		@Override
		public void addItems(int index, List<WLayoutedWidget<MPartSashContainerElement>> list) {
			SplitPane p = getWidget();
			List<Node> l = new ArrayList<Node>();
			for (WLayoutedWidget<MPartSashContainerElement> i : list) {
				l.add((Node) i.getStaticLayoutNode());
			}
			p.getItems().addAll(index, l);
			this.items.addAll(index, list);
			updateDividers();
		}

		@Override
		public void addItems(List<WLayoutedWidget<MPartSashContainerElement>> list) {
			SplitPane p = getWidget();
			List<Node> l = new ArrayList<Node>();
			for (WLayoutedWidget<MPartSashContainerElement> i : list) {
				l.add((Node) i.getStaticLayoutNode());
			}
			p.getItems().addAll(l);
			this.items.addAll(list);
			updateDividers();
		}

		@Override
		public void setWidgetState(WidgetState state) {
			super.setWidgetState(state);
			if (state == WidgetState.CREATED) {
				updateDividers();
			}
		}

		@Override
		public void removeItem(WLayoutedWidget<MPartSashContainerElement> widget) {
			SplitPane p = getWidget();
			p.getItems().remove(widget.getStaticLayoutNode());
			this.items.remove(widget);
			updateDividers();
		}

		@Override
		protected void doCleanup() {
			super.doCleanup();
			this.items.clear();
		}

		private void updateDividers() {
			if (this.items.size() <= 1) {
				return;
			}

			if (this.state != WidgetState.CREATED) {
				return;
			}

			double total = 0;

			for (WLayoutedWidget<MPartSashContainerElement> w : this.items) {
				total += w.getWeight();
			}

			double[] deviders = new double[this.items.size() - 1];
			for (int i = 0; i < this.items.size() - 1; i++) {
				deviders[i] = (i == 0 ? 0 : deviders[i - 1]) + (this.items.get(i).getWeight() / total);
			}

			getWidget().setDividerPositions(deviders);
		}

		@Override
		public int getItemCount() {
			return getWidget().getItems().size();
		}
	}
}

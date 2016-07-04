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

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.core.log.Logger.Level;
import org.eclipse.fx.ui.workbench.renderers.base.BaseRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseSashRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WSash;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;
import org.eclipse.jdt.annotation.Nullable;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.control.SplitPane.Divider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

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

	static class WFixedSashImpl extends WLayoutedWidgetImpl<GridPane, Node, MPartSashContainer> implements WSash<Node> {

		static RowConstraints toRowConstraint(Map<String, String> dataMap) {
			RowConstraints r;

			if (dataMap.containsKey(WSash.FIXED_LAYOUT_HEIGHT)) {
				int h = Integer.parseInt(dataMap.get(WSash.FIXED_LAYOUT_HEIGHT));
				r = new RowConstraints(h);
			} else {
				r = new RowConstraints();
			}

			if( dataMap.containsKey(WSash.FIXED_LAYOUT_GRAB_VERTICAL) && Boolean.parseBoolean(dataMap.get(WSash.FIXED_LAYOUT_GRAB_VERTICAL)) ) {
				r.setVgrow(Priority.ALWAYS);
			}

			return r;
		}

		static ColumnConstraints toColConstraint(Map<String, String> dataMap) {
			ColumnConstraints c;

			if( dataMap.containsKey(WSash.FIXED_LAYOUT_WIDTH) ) {
				int w = Integer.parseInt(dataMap.get(WSash.FIXED_LAYOUT_WIDTH));
				c = new ColumnConstraints(w);
			} else {
				c = new ColumnConstraints();
			}

			if (dataMap.containsKey(WSash.FIXED_LAYOUT_GRAB_HORIZONTAL) && Boolean.parseBoolean(dataMap.get(WSash.FIXED_LAYOUT_GRAB_HORIZONTAL)) )  {
				c.setHgrow(Priority.ALWAYS);
			}

			return c;
		}

		@Override
		public int getItemCount() {
			return getWidget().getChildren().size();
		}

		private static void fixIndex(GridPane p, MPartSashContainer c) {
			if( c.isHorizontal() ) {
				int i = 0;
				for( Node n : p.getChildren() ) {
					GridPane.setColumnIndex(n, Integer.valueOf(i));

					Map<String, String> map = c.getChildren().get(i).getPersistedState();

					if( map.containsKey(WSash.FIXED_LAYOUT_GRAB_VERTICAL) ) {
						if( Boolean.parseBoolean(map.get(WSash.FIXED_LAYOUT_GRAB_VERTICAL)) ) {
							GridPane.setFillHeight(n, Boolean.TRUE);
							GridPane.setVgrow(n, Priority.ALWAYS);
						}
					} else {
						GridPane.setFillHeight(n, Boolean.TRUE);
						GridPane.setVgrow(n, Priority.ALWAYS);
					}
					i++;
				}
			} else {
				int i = 0;
				for( Node n : p.getChildren() ) {
					GridPane.setRowIndex(n, Integer.valueOf(i));
					Map<String, String> map = c.getChildren().get(i).getPersistedState();

					if( map.containsKey(WSash.FIXED_LAYOUT_GRAB_HORIZONTAL) ) {
						if( Boolean.parseBoolean(map.get(WSash.FIXED_LAYOUT_GRAB_HORIZONTAL)) ) {
							GridPane.setHgrow(n, Priority.ALWAYS);
							GridPane.setFillWidth(n, Boolean.TRUE);
						}
					} else {
						GridPane.setHgrow(n, Priority.ALWAYS);
						GridPane.setFillWidth(n, Boolean.TRUE);
					}

					i++;
				}
			}
		}

		@Override
		public void addItem(WLayoutedWidget<MPartSashContainerElement> widget) {
			Node n = (Node) widget.getStaticLayoutNode();

			GridPane p = getWidget();
			MPartSashContainer domElement = getDomElement();
			MPartSashContainerElement widgetElement = widget.getDomElement();

			if( domElement == null ) {
				this.logger.log(Level.ERROR, "Could not find DOM element for '"+this+"'"); //$NON-NLS-1$ //$NON-NLS-2$
				return;
			}

			if( widgetElement == null ) {
				this.logger.log(Level.ERROR, "Could not find DOM element for '"+widget+"'"); //$NON-NLS-1$ //$NON-NLS-2$
				return;
			}

			if( domElement.isHorizontal() ) {
				p.getColumnConstraints().add(toColConstraint(widgetElement.getPersistedState()));
			} else {
				p.getRowConstraints().add(toRowConstraint(widgetElement.getPersistedState()));
			}
			p.getChildren().add(n);

			fixIndex(p, domElement);
		}

		@Override
		public void addItems(List<WLayoutedWidget<MPartSashContainerElement>> list) {
			List<Node> nodeList = new ArrayList<Node>();
			GridPane p = getWidget();

			MPartSashContainer domElement = getDomElement();

			if( domElement == null ) {
				this.logger.log(Level.ERROR, "Could not find DOM element for '"+this+"'"); //$NON-NLS-1$ //$NON-NLS-2$
				return;
			}

			for (WLayoutedWidget<MPartSashContainerElement> w : list) {
				Node n = (Node) w.getStaticLayoutNode();

				MPartSashContainerElement widgetElement = w.getDomElement();
				if( widgetElement != null ) {
					if( domElement.isHorizontal() ) {
						p.getColumnConstraints().add(toColConstraint(widgetElement.getPersistedState()));
					} else {
						p.getRowConstraints().add(toRowConstraint(widgetElement.getPersistedState()));
					}
				}
				nodeList.add(n);
			}

			p.getChildren().addAll(nodeList);
			fixIndex(p,domElement);
		}

		@Override
		public void addItems(int index, List<WLayoutedWidget<MPartSashContainerElement>> list) {
			List<Node> nodeList = new ArrayList<Node>();
			GridPane p = getWidget();

			MPartSashContainer domElement = getDomElement();
			if( domElement == null ) {
				this.logger.log(Level.ERROR, "Could not find DOM element for '"+this+"'"); //$NON-NLS-1$ //$NON-NLS-2$
				return;
			}

			List<ColumnConstraints> columnConstraints = new ArrayList<>();
			List<RowConstraints> rowConstraints = new ArrayList<>();

			for (WLayoutedWidget<MPartSashContainerElement> w : list) {
				Node n = (Node) w.getStaticLayoutNode();

				MPartSashContainerElement element = w.getDomElement();
				if( element != null ) {
					if( domElement.isHorizontal() ) {
						columnConstraints.add(toColConstraint(element.getPersistedState()));
					} else {
						rowConstraints.add(toRowConstraint(element.getPersistedState()));
					}
				} else {
					this.logger.log(Level.ERROR, "Could not find DOM element for '"+w+"'"); //$NON-NLS-1$ //$NON-NLS-2$
					return;
				}

				nodeList.add(n);
			}

			if( domElement.isHorizontal() ) {
				p.getColumnConstraints().addAll(index, columnConstraints);
			} else {
				p.getRowConstraints().addAll(index,rowConstraints);
			}

			p.getChildren().addAll(index, nodeList);
			fixIndex(p, domElement);
		}

		@Override
		public void removeItem(WLayoutedWidget<MPartSashContainerElement> widget) {
			Node n = (Node) widget.getStaticLayoutNode();
			GridPane p = getWidget();
			MPartSashContainer domElement = getDomElement();

			if( domElement == null ) {
				this.logger.log(Level.ERROR, "Could not find DOM element for '"+this+"'"); //$NON-NLS-1$ //$NON-NLS-2$
				return;
			}

			int idx = p.getChildren().indexOf(n);

			if( domElement.isHorizontal() ) {
				p.getColumnConstraints().remove(idx);
			} else {
				p.getRowConstraints().remove(idx);
			}
			p.getChildren().remove(n);
			fixIndex(p, domElement);
		}

		@Override
		public GridPane getWidgetNode() {
			return getWidget();
		}

		@Override
		protected GridPane createWidget() {
			GridPane p = new GridPane();
			return p;
		}

		@Override
		public void updateLayout() {
			// TODO Auto-generated method stub

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

		@Override
		public void updateLayout() {
			updateDividers();
		}

		void recalcWeight() {
			@Nullable
			MPartSashContainer domElement = getDomElement();
			if( domElement != null ) {
				BaseRenderer<?, ?> r = (BaseRenderer<?, ?>) domElement.getRenderer();
				r.syncUIModifications(domElement, this::doRecalcWeight);
			} else {
				this.logger.error("The domain object should not be null at this point"); //$NON-NLS-1$
			}
		}

		void doRecalcWeight() {
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
				MPartSashContainerElement element = this.items.get(idx++).getDomElement();
				if( element != null ) {
					element.setContainerData((d - prev) * 10 + ""); //$NON-NLS-1$
				}
				prev = d;
			}
			MPartSashContainerElement element = this.items.get(this.items.size() - 1).getDomElement();
			if( element != null ) {
				element.setContainerData((1.0 - prev) * 10 + ""); //$NON-NLS-1$
			}
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
		public SplitPane getWidgetNode() {
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

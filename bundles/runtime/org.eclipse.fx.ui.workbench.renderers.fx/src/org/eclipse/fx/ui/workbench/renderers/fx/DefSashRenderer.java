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
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.ui.panes.GridData;
import org.eclipse.fx.ui.panes.GridData.Alignment;
import org.eclipse.fx.ui.panes.GridLayoutPane;
import org.eclipse.fx.ui.panes.SashPane;
import org.eclipse.fx.ui.workbench.renderers.base.BaseRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseSashRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WSash;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.control.SplitPane.Divider;

/**
 * default renderer for sash
 */
public class DefSashRenderer extends BaseSashRenderer<Node> {

	@Override
	protected Class<? extends WSash<Node>> getWidgetClass(MPartSashContainer container) {
		if (container.getTags().contains(WSash.TAG_FIXED_LAYOUT)) {
			return WFixedSashImpl.class;
		} else if(Boolean.getBoolean("efxclipse.eclipse.compat.sash")) { //$NON-NLS-1$
			System.err.println("======> CUSTOM IMPL");
			return WResizableSashImpl_2.class;
		} else {
			return WResizableSashImpl.class;
		}
	}

	static class WFixedSashImpl extends WLayoutedWidgetImpl<GridLayoutPane, Node, MPartSashContainer> implements WSash<Node> {

		private static @NonNull GridData toGridData(Map<String, String> dataMap) {
			GridData gd = new GridData();
			if (dataMap.containsKey(WSash.FIXED_LAYOUT_WIDTH)) {
				gd.widthHintProperty().set(Integer.parseInt(dataMap.get(WSash.FIXED_LAYOUT_WIDTH)));
				if (!dataMap.containsKey(WSash.FIXED_LAYOUT_HEIGHT)) {
					gd.grabExcessVerticalSpaceProperty().set(true);
					gd.verticalAlignmentProperty().set(Alignment.FILL);
				}
			} else {
				gd.horizontalAlignmentProperty().set(Alignment.FILL);
			}

			if (dataMap.containsKey(WSash.FIXED_LAYOUT_HEIGHT)) {
				gd.heightHintProperty().set(Integer.parseInt(dataMap.get(WSash.FIXED_LAYOUT_HEIGHT)));
				if (!dataMap.containsKey(WSash.FIXED_LAYOUT_WIDTH)) {
					gd.grabExcessHorizontalSpaceProperty().set(true);
					gd.horizontalAlignmentProperty().set(Alignment.FILL);
				}
			} else {
				gd.verticalAlignmentProperty().set(Alignment.FILL);
			}

			if (dataMap.containsKey(WSash.FIXED_LAYOUT_GRAB_HORIZONTAL)) {
				gd.grabExcessHorizontalSpaceProperty().set(Boolean.parseBoolean(dataMap.get(WSash.FIXED_LAYOUT_GRAB_HORIZONTAL)));
				gd.horizontalAlignmentProperty().set(Alignment.FILL);
			}

			if (dataMap.containsKey(WSash.FIXED_LAYOUT_GRAB_VERTICAL)) {
				gd.grabExcessVerticalSpaceProperty().set(Boolean.parseBoolean(dataMap.get(WSash.FIXED_LAYOUT_GRAB_VERTICAL)));
				gd.verticalAlignmentProperty().set(Alignment.FILL);
			}

			return gd;
		}


		private final @NonNull MPartSashContainer mPartSashContainer;

		@Inject
		public WFixedSashImpl(@NonNull @Named(BaseRenderer.CONTEXT_DOM_ELEMENT) MPartSashContainer mPartSashContainer) {
			this.mPartSashContainer = mPartSashContainer;
		}

		@Override
		public void addItem(WLayoutedWidget<MPartSashContainerElement> widget) {
			Node n = (Node) widget.getStaticLayoutNode();

			GridLayoutPane p = getWidget();
			MPartSashContainer element = getDomElement();
			if ( element != null && element.isHorizontal()) {
				p.setNumColumns(p.getNumColumns() + 1);
			}

			MPartSashContainerElement domElement2 = widget.getDomElement();
			if( domElement2 != null ) {
				GridData gd = toGridData(domElement2.getPersistedState());
				GridLayoutPane.setConstraint(n, gd);
			}
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

				MPartSashContainerElement element = w.getDomElement();
				if( element != null ) {
					GridData gd = toGridData(element.getPersistedState());
					GridLayoutPane.setConstraint(n, gd);
				}
				nodeList.add(n);
			}

			MPartSashContainer element = getDomElement();
			if (element != null && element.isHorizontal()) {
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

				MPartSashContainerElement element = w.getDomElement();
				if( element != null ) {
					GridData gd = toGridData(element.getPersistedState());
					GridLayoutPane.setConstraint(n, gd);
				}
				nodeList.add(n);
			}

			MPartSashContainer element = getDomElement();
			if (element != null && element.isHorizontal()) {
				p.setNumColumns(p.getNumColumns() + nodeList.size());
			}

			p.getChildren().addAll(index, nodeList);
		}

		@Override
		public void removeItem(WLayoutedWidget<MPartSashContainerElement> widget) {
			Node n = (Node) widget.getStaticLayoutNode();
			GridLayoutPane p = getWidget();
			MPartSashContainer domElement = getDomElement();

			if( domElement != null && domElement.isHorizontal() ) {
				p.setNumColumns(p.getNumColumns() - 1);
			}
			p.getChildren().remove(n);
		}

		@Override
		public GridLayoutPane getWidgetNode() {
			return getWidget();
		}

		@Override
		protected GridLayoutPane createWidget() {
			GridLayoutPane p = new GridLayoutPane();
			p.setMarginWidth(0);
			p.setMarginHeight(0);
			p.setHorizontalSpacing(0);
			p.setVerticalSpacing(0);
			p.setNumColumns(this.mPartSashContainer.isHorizontal() ? 0 : 1);
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

		private static void setResizableWithParent(WLayoutedWidget widget) {
			MUIElement domElement = widget.getDomElement();
			if( domElement != null ) {
				System.err.println(domElement);
				SplitPane.setResizableWithParent((Node)widget.getStaticLayoutNode(), ! domElement.getTags().contains(WSash.TAG_NO_AUTO_RESIZE));
			}
		}

		@Override
		public void addItem(WLayoutedWidget<MPartSashContainerElement> widget) {
			SplitPane p = getWidget();
			setResizableWithParent(widget);
			p.getItems().add((Node) widget.getStaticLayoutNode());
			this.items.add(widget);
			updateDividers();
		}

		@Override
		public void addItems(int index, List<WLayoutedWidget<MPartSashContainerElement>> list) {
			SplitPane p = getWidget();
			List<Node> l = new ArrayList<Node>();
			for (WLayoutedWidget<MPartSashContainerElement> i : list) {
				setResizableWithParent(i);
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
				setResizableWithParent(i);
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

	static class WResizableSashImpl_2 extends WLayoutedWidgetImpl<SashPane, Node, MPartSashContainer> implements WSash<Node> {
		private List<WLayoutedWidget<?>> items = new ArrayList<>();

		@Override
		public int getItemCount() {
			SashPane p = getWidget();
			return p.getItems().size();
		}

		private static int getWeight(WLayoutedWidget<?> w) {
			double v = w.getWeight();
			if( v < 1 ) {
				return (int)(v * 100);
			} else if( w.getDomElement().getContainerData() == null) {
				return 200;
			} else {
				return (int) v;
			}
		}

		@Override
		public void addItem(@NonNull WLayoutedWidget<MPartSashContainerElement> widget) {
			syncWeights();

			SashPane p = getWidget();
			int[] w = p.getWeights();
			p.getItems().add((Node) widget.getStaticLayoutNode());
			int[] wn = new int[w.length+1];
			System.arraycopy(w, 0, wn, 0, w.length);
			wn[wn.length-1] = getWeight(widget);
			p.setWeights(wn);
			this.items.add(widget);
		}

		@Override
		public void addItems(@NonNull List<WLayoutedWidget<MPartSashContainerElement>> list) {
			syncWeights();

			SashPane p = getWidget();
			int[] w = p.getWeights();

			p.getItems().addAll(list.stream().map( e -> (Node)e.getStaticLayoutNode()).collect(Collectors.toList()));

			int[] wn = new int[w.length+list.size()];
			System.arraycopy(w, 0, wn, 0, w.length);
			for( int i = w.length; i < wn.length; i++ ) {
				wn[i] = getWeight(list.get(i-w.length));
			}
			p.setWeights(wn);
			this.items.addAll(list);
		}

		@Override
		public void addItems(int index, @NonNull List<WLayoutedWidget<MPartSashContainerElement>> list) {
			syncWeights();

			SashPane p = getWidget();
			int[] w = p.getWeights();
			p.getItems().addAll(index,list.stream().map(e -> (Node)e.getStaticLayoutNode()).collect(Collectors.toList()));

			int[] wn = new int[w.length+list.size()];
			System.arraycopy(w, 0, wn, 0, index);
			for( int i = 0; i < list.size(); i++ ) {
				wn[i+index] = getWeight(list.get(i));
			}
			System.arraycopy(w, index, wn, index+1, w.length-index);
			p.setWeights(wn);
			this.items.addAll(index, list);
		}

		@Override
		public void removeItem(@NonNull WLayoutedWidget<MPartSashContainerElement> widget) {
			syncWeights();
			SashPane p = getWidget();
			p.getItems().remove(widget.getStaticLayoutNode());
			this.items.remove(widget);
		}

		@Override
		public void updateLayout() {
//			updateDividers();
		}

		private void syncWeights() {
			int[] weights = getWidget().getWeights();
			for( int i = 0; i < weights.length; i++ ) {
				MUIElement domElement = this.items.get(i).getDomElement();
				if( domElement != null ) {
					domElement.setContainerData(weights[i]+""); //$NON-NLS-1$
				}
			}
		}

		@Override
		public @NonNull Node getWidgetNode() {
			return getWidget();
		}

		@Override
		protected @NonNull SashPane createWidget() {
			SashPane p = new SashPane();
			return p;
		}

		@Inject
		void setOrientation(@Named(UIEvents.GenericTile.HORIZONTAL) boolean horizontal) {
			getWidget().setHorizontal(horizontal);
		}
	}
}

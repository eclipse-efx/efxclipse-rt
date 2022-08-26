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

import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.control.SplitPane.Divider;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.model.application.ui.advanced.MArea;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.ui.workbench.renderers.base.BaseAreaRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WArea;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;

/**
 * default renderer for {@link MArea}
 */
public class DefAreaRenderer extends BaseAreaRenderer<SplitPane> {
	@Override
	protected Class<? extends WArea<SplitPane>> getWidgetClass(MArea area) {
		return WAreaImpl.class;
	}

	/**
	 * @noreference
	 */
	public static class WAreaImpl extends WLayoutedWidgetImpl<SplitPane, SplitPane, MArea> implements WArea<SplitPane> {
		private List<WLayoutedWidget<MPartSashContainerElement>> items = new ArrayList<WLayoutedWidget<MPartSashContainerElement>>();

		private ChangeListener<Number> listener = new ChangeListener<Number>() {
			boolean queueing;

			@SuppressWarnings("unqualified-field-access")
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (!this.queueing) {
					this.queueing = true;
					Platform.runLater(() -> {
						recalcWeight();
						queueing = false;
					});
				}
			}
		};

		void recalcWeight() {
			double prev = 0;
			int idx = 0;
			for (double d : getWidget().getDividerPositions()) {
				MPartSashContainerElement element = this.items.get(idx++).getDomElement();
				if( element != null ) {
					element.setContainerData((d - prev) * 10 + ""); //$NON-NLS-1$	
				}
				
				prev = d;
			}
			if( this.items.size() - 1 >= 0 ) {
				MPartSashContainerElement element = this.items.get(this.items.size() - 1).getDomElement();
				if( element != null ) {
					element.setContainerData((1.0 - prev) * 10 + ""); //$NON-NLS-1$	
				}	
			}
		}

		@Override
		protected void bindProperties(final SplitPane widget) {
			super.bindProperties(widget);
			widget.getDividers().addListener(this::handleDeviderChange);
			for (Divider d : widget.getDividers()) {
				d.positionProperty().addListener(this.listener);
			}
		}

		private void handleDeviderChange(javafx.collections.ListChangeListener.Change<? extends Divider> c) {
			while (c.next()) {
				for (Divider d : c.getAddedSubList()) {
					if( d != null ) {
						d.positionProperty().addListener(this.listener);
					}
					
				}

				for (Divider d : c.getRemoved()) {
					if( d != null ) {
						d.positionProperty().removeListener(this.listener);
					}
				}
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
